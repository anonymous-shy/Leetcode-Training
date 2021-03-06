/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }
    
    // 思路 2：辅助栈和数据栈不同步
    // 关键 1：辅助栈的元素空的时候，必须放入新进来的数
    // 关键 2：新来的数小于或者等于辅助栈栈顶元素的时候，才放入（特别注意这里等于要考虑进去）
    // 关键 3：出栈的时候，辅助栈的栈顶元素等于数据栈的栈顶元素，才出栈，即"出栈保持同步"就可以了
    public void push(int x) {
        data.add(x);
        // 辅助栈在必要的时候才增加
        // 关键 1 和 关键 2
        if (helper.isEmpty() || helper.peek() >= x) 
            helper.add(x);
    }
    
    public void pop() {
        if (!data.isEmpty()){
            int top = data.pop();
            if (top == helper.peek())
                helper.pop();
        }
    }
    
    public int top() {
        if (!data.isEmpty()) 
            return data.peek();
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
    
    public int getMin() {
        if (!helper.isEmpty()) 
            return helper.peek();
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

