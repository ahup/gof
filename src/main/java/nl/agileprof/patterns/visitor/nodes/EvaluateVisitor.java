package nl.agileprof.patterns.visitor.nodes;

import java.util.Stack;

public class EvaluateVisitor implements Visitor
{
	private Stack<Double> stack;

	public EvaluateVisitor()
	{
		stack = new Stack<Double>();
		stack.add(Double.valueOf(1000.01));
	}

	public double total()
	{

		return stack.peek();

	}

	@Override
	public void visitAddNode(AddNode n)
	{
		n.left.accept(this);
		n.right.accept(this);
		stack.push(stack.pop() + stack.pop());
	}

	@Override
	public void visitDivNode(DivNode n)
	{
		n.left.accept(this);
		n.right.accept(this);
		double rhs = stack.pop();
		stack.push(stack.pop() / rhs);
	}

	@Override
	public void visitMulNode(MulNode n)
	{
		n.left.accept(this);
		n.right.accept(this);
		stack.push(stack.pop() * stack.pop());
	}

	@Override
	public void visitNegNode(NegNode n)
	{
		n.left.accept(this);
		stack.push(-stack.pop());
	}

	@Override
	public void visitNumNode(NumNode n)
	{
		stack.push(n.value);
	}

	@Override
	public void visitSubNode(SubNode n)
	{
		n.left.accept(this);
		n.right.accept(this);
		double rhs = stack.pop();
		stack.push(stack.pop() - rhs);
	}
}