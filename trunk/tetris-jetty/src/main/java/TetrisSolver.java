public class TetrisSolver {
    final static int DO_NOT_ROTATE = 0;
    final static int ROTATE_90_CLOCKWISE = 1;
    final static int ROTATE_180_CLOCKWISE = 2;
    final static int ROTATE_90_COUNTERCLOCKWISE = 3;

    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;

    private char[][] glassArray = new char[HEIGHT][WIDTH];

    public String answer(String figure, int x, int y, String glass, String next) {

	fillArray(glass, figure);

	System.out.println("--------------------------");

	int displ = 0;

	if (figure.equals("O")) {
	    return moveO(x);

	} else if (figure.equals("I")) {
	    return moveI(x);
	} else if (figure.equals("J")) {
	    return moveJ(x);
	} else if (figure.equals("L")) {
	    return moveL(x);
	} else if (figure.equals("T")) {
	    return moveT(x);
	} else if (figure.equals("S")) {
	    return moveS(x);
	}

	else {
	    return "drop";
	}

    }

    private String moveS(int x) {
	// |__
	for (int i = HEIGHT - 1; i >= 0; i--) {
	    for (int j = 0; j < WIDTH; j++) {
		if (((j + 2) < WIDTH) && ((i - 1) >= 0)) {
		    if ((glassArray[i][j] == '*')
			    && (glassArray[i][j + 1] == ' ')
			    && (glassArray[i][j + 2] == ' ')
			    && (glassArray[i - 1][j] == ' ')
			    && (glassArray[i - 1][j + 1] == ' ')) {
			if (j + 1 > x) {
			    return "right=" + (j + 1 - x) + ", drop";

			} else {
			    return "left=" + (x - j - 1) + ", drop";
			}
		    }
		}

	    }
	}

	return "drop";
    }

    private String moveT(int x) {
	for (int i = HEIGHT - 1; i >= 0; i--) {
	    for (int j = 0; j < WIDTH; j++) {
		if (((j + 1) < WIDTH) && ((j + 2) < WIDTH) && ((i - 1) >= 0)) {
		    if ((glassArray[i][j] == ' ')
			    && (glassArray[i][j + 1] == ' ')
			    && (glassArray[i][j + 2] == ' ')
			    && (glassArray[i - 1][j + 1] == ' ')) {
			if (j + 1 > x) {
			    return "right=" + (j + 1 - x) + ", drop";

			} else {
			    return "left=" + (x - j - 1) + ", drop";
			}
		    }
		}

		if (((j + 1) < WIDTH) && ((i - 2) >= 0)) {
		    if ((glassArray[i][j + 1] == ' ')
			    && (glassArray[i - 1][j + 1] == ' ')
			    && (glassArray[i - 2][j + 1] == ' ')
			    && (glassArray[i - 1][j] == ' ')) {
			if (j + 1 > x) {
			    return "rotate=3, right=" + (j + 1 - x) + ", drop";

			} else {
			    return "rotate=3, left=" + (x - j - 1) + ", drop";
			}
		    }
		}

		if (((j + 1) < WIDTH) && ((i - 2) >= 0)) {
		    if ((glassArray[i][j] == ' ')
			    && (glassArray[i - 1][j] == ' ')
			    && (glassArray[i - 2][j] == ' ')
			    && (glassArray[i - 1][j + 1] == ' ')
			    && (glassArray[i][j + 1] == '*')) {
			if (j > x) {
			    return "rotate=1,right=" + (j - x) + ", drop";

			} else {
			    return "rotate=1,left=" + (x - j) + ", drop";
			}
		    }
		}

		if (((j + 1) < WIDTH) && ((i - 2) >= 0)) {
		    if ((glassArray[i][j] == '*')
			    && (glassArray[i - 1][j] == ' ')
			    && (glassArray[i - 2][j + 1] == ' ')
			    && (glassArray[i - 1][j + 1] == ' ')
			    && (glassArray[i][j + 1] == ' ')) {
			if (j + 1 > x) {
			    return "rotate=3,right=" + (j + 1 - x) + ", drop";

			} else {
			    return "rotate=3,left=" + (x - j - 1) + ", drop";
			}
		    }
		}

		if (((j + 2) < WIDTH) && ((i - 1) >= 0)) {
		    if ((glassArray[i][j + 1] == ' ')
			    && (glassArray[i - 1][j] == ' ')
			    && (glassArray[i - 1][j + 1] == ' ')
			    && (glassArray[i - 1][j + 2] == ' ')
			    && (glassArray[i][j] == '*')
			    && (glassArray[i][j + 2] == '*')) {
			if (j + 1 > x) {
			    return "rotate=2,right=" + (j + 1 - x) + ", drop";

			} else {
			    return "rotate=2,left=" + (x - j - 1) + ", drop";
			}
		    }
		}

	    }
	}

	return "drop";
    }

    private String moveL(int x) {
	for (int i = HEIGHT - 1; i >= 0; i--) {
	    for (int j = 0; j < WIDTH; j++) {
		// __|
		if (((j + 1) < WIDTH) && ((j + 2) < WIDTH) && ((i - 1) >= 0)) {
		    if ((glassArray[i][j] == ' ')
			    && (glassArray[i - 1][j + 2] == ' ')
			    && (glassArray[i][j + 1] == ' ')
			    && (glassArray[i][j + 2] == ' ')) {
			if (j + 1 > x) {
			    return "rotate=3,right=" + (j + 1 - x) + ", drop";

			} else {
			    return "rotate=3,left=" + (x - j - 1) + ", drop";
			}
		    }
		}

		// |--
		if (((j + 2) < WIDTH) && ((i - 1) >= 0)) {
		    if ((glassArray[i][j] == ' ')
			    && (glassArray[i - 1][j] == ' ')
			    && (glassArray[i - 1][j + 1] == ' ')
			    && (glassArray[i - 1][j + 2] == ' ')
			    && (glassArray[i][j + 1] == '*')
			    && (glassArray[i][j + 2] == '*')) {
			if (j + 1 > x) {
			    return "rotate=1,right=" + (j + 1 - x) + ", drop";

			} else {
			    return "rotate=1,left=" + (x - j - 1) + ", drop";
			}
		    }
		}

		// L
		if (((j + 1) < WIDTH) && ((i - 2) >= 0)) {
		    if ((glassArray[i][j] == ' ')
			    && (glassArray[i][j + 1] == ' ')
			    && (glassArray[i - 1][j] == ' ')
			    && (glassArray[i - 2][j] == ' ')) {
			if (j > x) {
			    return "right=" + (j - x) + ", drop";

			} else {
			    return "left=" + (x - j) + ", drop";
			}
		    }
		}
		// -|
		if (((j + 1) < WIDTH) && ((i - 2) >= 0)) {
		    if ((glassArray[i][j + 1] == ' ')
			    && (glassArray[i - 1][j + 1] == ' ')
			    && (glassArray[i - 2][j + 1] == ' ')
			    && (glassArray[i - 2][j] == ' ')
			    && (glassArray[i][j] == '*')
			    && (glassArray[i - 1][j] == '*')) {
			if (j + 1 > x) {
			    return "rotate=2,right=" + (j + 1 - x) + ", drop";

			} else {
			    return "rotate=2,left=" + (x - j - 1) + ", drop";
			}
		    }
		}

	    }
	}

	return "drop";
    }

    private String moveJ(int x) {
	// |__
	for (int i = HEIGHT - 1; i >= 0; i--) {
	    for (int j = 0; j < WIDTH; j++) {
		if (((j + 1) < WIDTH) && ((j + 2) < WIDTH) && ((i - 1) >= 0)) {
		    if ((glassArray[i][j] == ' ')
			    && (glassArray[i - 1][j] == ' ')
			    && (glassArray[i][j + 1] == ' ')
			    && (glassArray[i][j + 2] == ' ')) {
			if (j + 1 > x) {
			    return "rotate=1,right=" + (j + 1 - x) + ", drop";

			} else {
			    return "rotate=1,left=" + (x - j - 1) + ", drop";
			}
		    }
		}

		// J
		if (((j + 1) < WIDTH) && ((i - 2) >= 0)) {
		    if ((glassArray[i][j] == ' ')
			    && (glassArray[i][j + 1] == ' ')
			    && (glassArray[i - 1][j + 1] == ' ')
			    && (glassArray[i - 2][j + 1] == ' ')) {
			if (j > x) {
			    return "right=" + (j + 1 - x) + ", drop";

			} else {
			    return "left=" + (x - j - 1) + ", drop";
			}
		    }
		}
		// --|
		if (((j + 2) < WIDTH) && ((i - 1) >= 0)) {
		    if ((glassArray[i - 1][j] == ' ')
			    && (glassArray[i][j + 2] == ' ')
			    && (glassArray[i - 1][j + 1] == ' ')
			    && (glassArray[i - 1][j + 2] == ' ')
			    && (glassArray[i][j] == '*')
			    && (glassArray[i][j + 1] == '*')) {
			if (j + 1 > x) {
			    return "rotate=3, right=" + (j + 1 - x) + ", drop";

			} else {
			    return "rotate=3,left=" + (x - j - 1) + ", drop";
			}
		    }
		}
		// Г
		if (((j + 1) < WIDTH) && ((i - 2) >= 0)) {
		    if ((glassArray[i][j] == ' ')
			    && (glassArray[i - 1][j] == ' ')
			    && (glassArray[i - 2][j] == ' ')
			    && (glassArray[i - 2][j + 1] == ' ')
			    && (glassArray[i][j + 1] == '*')
			    && (glassArray[i - 1][j + 1] == '*')) {
			if (j > x) {
			    return "rotate=2, right=" + (j - x) + ", drop";

			} else {
			    return "rotate=2,left=" + (x - j) + ", drop";
			}
		    }
		}

	    }
	}

	return "drop";
    }

    private String moveI(int x) {

	for (int i = HEIGHT - 1; i >= 0; i--) {
	    for (int j = 0; j < WIDTH; j++) {
		if (((j + 1) < WIDTH) && ((j + 2) < WIDTH) && ((j + 3) < WIDTH)) {
		    if ((glassArray[i][j] == ' ')
			    && (glassArray[i][j + 1] == ' ')
			    && (glassArray[i][j + 2] == ' ')
			    && (glassArray[i][j + 3] == ' ')) {
			if (j + 1 > x) {
			    return "rotate=3,right=" + (j + 1 - x) + ", drop";

			} else {
			    return "rotate=3,left=" + (x - j - 1) + ", drop";
			}
		    }
		}

		if (((i - 1) > 0) && ((i - 2) > 0) && ((i - 3) > 0)) {
		    if ((glassArray[i][j] == ' ')
			    && (glassArray[i - 1][j] == ' ')
			    && (glassArray[i - 2][j] == ' ')
			    && (glassArray[i - 3][j] == ' ')) {
			if (j > x) {
			    return "right=" + (j - x) + ", drop";

			} else {
			    return "left=" + (x - j) + ", drop";
			}
		    }
		}

	    }
	}

	return "rotate=-1, drop";
    }

    private String moveO(int x) {
	int newX = getNewX();

	if (newX > x) {
	    return "right=" + (newX - x) + ", drop";

	} else {
	    return "left=" + (x - newX) + ", drop";
	}
    }

    private int getNewX() {
	for (int i = HEIGHT - 1; i >= 0; i--) {
	    for (int j = 0; j < WIDTH; j++) {
		if ((i - 1 >= 0) && ((j + 1) < WIDTH)) {
		    if ((glassArray[i][j] == ' ')
			    && (glassArray[i - 1][j] == ' ')
			    && (glassArray[i - 1][j + 1] == ' ')
			    && (glassArray[i][j + 1] == ' ')) {
			return j;
		    }
		}
	    }

	}

	return 0;
    }

    private void fillArray(String glass, String figure) {
	for (int i = HEIGHT - 1; i >= 0; i--) {
	    System.out.print("|");
	    for (int j = 0; j < WIDTH; j++) {
		int index = i * WIDTH + j;

		glassArray[HEIGHT - 1 - i][j] = glass.charAt(index);
		System.out.print(glassArray[i][j]);
	    }
	    System.out.print("|");

	    System.out.println();

	}

    }
}
