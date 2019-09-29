package optional;

/**
 * Refactor this code. Use the MatcherTest to make sure you haven't broken
 * anything.
 */

public class Matcher {

	public Matcher() {
	}

	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {
		clip(actual, clipLimit);
		return actual.length == expected.length && isInDelta(expected, actual, delta);
	}

	private boolean isInDelta(int[] expected, int[] actual, int delta) {
		for (int i = 0; i < actual.length; i++)
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;
		return true;
	}

	private void clip(int[] actual, int clipLimit) {
		for (int i = 0; i < actual.length; i++)
			if (actual[i] > clipLimit)
				actual[i] = clipLimit;
	}
}