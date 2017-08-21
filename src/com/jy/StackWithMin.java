package com.jy;

import java.util.ArrayDeque;

public class StackWithMin<T extends Comparable<T>> {
	// 数据栈
	private ArrayDeque<T> dataStack;
	// 最小栈
	private ArrayDeque<T> minStack;

	// 构造函数
	public StackWithMin() {
		super();
		this.dataStack = new ArrayDeque<T>();
		this.minStack = new ArrayDeque<T>();
	}

	/**
	 * 出栈
	 * 
	 * @return 返回栈顶元素
	 */
	public T pop() {
		// 先判断栈是否为空
		if (dataStack.isEmpty())
			throw new RuntimeException("the stack is already empty!");
		// 两个栈同时出栈
		minStack.pop();
		return dataStack.pop();
	}

	/**
	 * 入栈
	 * 
	 * @param t
	 *            待入栈的元素
	 */
	public void push(T t) {
		if (t == null)
			throw new RuntimeException("the element is null!");
		// 当栈为空时，两个栈都直接入栈
		if (dataStack.isEmpty()) {
			dataStack.push(t);
			minStack.push(t);
			return;
		}
		// 数据栈直接入栈
		dataStack.push(t);
		// 去除最小栈的栈顶元素与待入栈元素比较大小
		T min = minStack.peek();
		if (min.compareTo(t) > 0)
			// 比最小栈的栈顶元素还小，则将元素入住
			minStack.push(t);
		else
			// 否则将栈顶元素再次入栈
			minStack.push(min);

	}

	/**
	 * 获取栈的最小元素
	 * 
	 * @return 返回栈中的最小元素
	 */
	public T min() {
		// 先判断栈是否为空
		if (minStack.isEmpty())
			throw new RuntimeException("the stack is already empty!");
		// 返回栈顶的最小元素，但并不出栈
		return minStack.peek();
	}

}
