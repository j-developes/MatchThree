package com.nash;

/**
 * @author John Nash
 * 
 *         Clock Class runs a Game clock which calls the PSched or Paint
 *         Scheduler to update the graphics.
 */
public class Clock {

	PSched GraphicSch;
	ClockWorks Works;

	private class ClockWorks {

		Thread Worker;
		private long lastLoopTime;
		private final int TARGET_FPS;
		private final long OPTIMAL_TIME;
		private long lastFpsTime;
		private long updateLength;
		private long now;

		ClockWorks() {
			lastLoopTime = System.nanoTime(); // Start of program
			TARGET_FPS = 60;
			OPTIMAL_TIME = 1000000000 / TARGET_FPS; // 1 frame per 16666666.666666667 ~ 17 nano seconds
			lastFpsTime = 0;
			now = 0;
		}

		private void initalizeClock() {

			Worker = new Thread(new Runnable() {

				@Override
				public void run() {

					while (Worker.isAlive()) {
						now = System.nanoTime();
						updateLength = (now - lastLoopTime);// start of loop - current loop
						if (updateLength > OPTIMAL_TIME) {
							GraphicSch.update();
							lastLoopTime = now;
							lastFpsTime = (lastFpsTime + updateLength); // lastFpsTime = almost 0 + next almost 0 + ...
						}

						if (lastFpsTime > 1000000000) { // make 0 if you get to 1 second
							lastFpsTime = 0;
						}
						pause();
					}
				}

			}, "Clock");

			Worker.start();
		}

		private void pause() {
			try {
				Thread.sleep(30);
			} catch (InterruptedException t) {
				System.exit(0);
			}
		}

	}

	Clock(PSched G) {
		GraphicSch = G;
		Works = new ClockWorks();
	}

	protected void startClock() {
		Works.initalizeClock();
	}

}
