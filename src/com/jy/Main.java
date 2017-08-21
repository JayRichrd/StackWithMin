package com.jy;

public class Main {

	public static void main(String[] args) {
		StackWithMin<Integer> stackWithMin = new StackWithMin<>();
		stackWithMin.push(4);
		stackWithMin.push(1);
		stackWithMin.push(3);
		stackWithMin.pop();
		stackWithMin.push(2);

		System.out.println("栈中的最小元素：" + stackWithMin.min());
	}

}
