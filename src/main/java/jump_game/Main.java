package jump_game;

public class Main {
    public static void main(String[] args) {
        int[] array = {2, 1, 0, 1, 4};
        boolean result = canJump(array);
        System.out.println(result);

        boolean result2 = canJumpOptimal(array);
        System.out.println(result2);
    }

    static boolean canJump(int[] array) {
        return canJumpFromPosition(array, 0);
    }

    static boolean canJumpFromPosition(int[] array, int position) {
        if (position == array.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + array[position], array.length - 1);
        for (int i = position + 1; i <= furthestJump; i++) {
            if (canJumpFromPosition(array, i)) {
                return true;
            }
        }
        return false;
    }

    static boolean canJumpOptimal(int[] array) {
        return canJumpFromPositionOptimal(array, 0);
    }

    static boolean canJumpFromPositionOptimal(int[] array, int position) {
        if (position == array.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + array[position], array.length - 1);
        for (int i = furthestJump; i > position; i--) {
            if (canJumpFromPositionOptimal(array, i)) {
                return true;
            }
        }
        return false;
    }
}
