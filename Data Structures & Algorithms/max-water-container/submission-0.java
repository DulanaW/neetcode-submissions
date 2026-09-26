class Solution {

    public int getArea(int[] heights, int left, int right) {

        int width = right - left;
        int height = Math.min(heights[left], heights[right]);
        return height * width;
    }

    public int maxArea(int[] heights) {
        // find max h x w where h = min(leftbar, rightbar)
        int maxArea = 0;
        int maxLeft = 0;

        int area = 0;
        int right = heights.length - 1;
        int left = 0;

        while (left < right) {
            
            area = getArea(heights, left, right);
            maxArea = Math.max(area, maxArea);

            if (heights[left] < heights[right]) {
                left++;
            } else { right--; }

        }

        return maxArea;
    }
}
