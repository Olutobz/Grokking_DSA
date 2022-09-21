import java.util.Arrays;

public class SetMismatch {

    // TC -> O(N^2), SC -> O(1) (if we ignore the output data)
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[2];

        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (num == i) {
                    count++;
                }
            }
            if (count == 2) {
                result[0] = i;
            } else if (count == 0) {
                result[1] = i;
            }
        }

        return result;
    }

    // TC -> O(NLogN), SC -> O(sorting)
    public int[] findErrorNumsII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int duplicate = 0, missing = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                duplicate = nums[i];
            } else if (nums[i] > nums[i - 1] + 1) {
                missing = nums[i - 1] + 1;
            }
        }
        return new int[]{duplicate, nums[nums.length - 1] == nums.length ? missing : nums.length};
    }

    // TC -> O(N), SC -> O(1) (if we ignore the output data)
    public int[] findErrorNumsIII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                result[0] = idx + 1;
            } else {
                nums[idx] = -1 * nums[idx];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            } else {
                result[1] = i + 1;
            }
        }

        return result;
    }

}
