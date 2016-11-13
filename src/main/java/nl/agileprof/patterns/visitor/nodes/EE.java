package nl.agileprof.patterns.visitor.nodes;
// Expression Evaluator

import java.text.ParseException;

public class EE
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.err.println("usage: java Expr expr");
			return;
		}

		try
		{
			Parser p = new Parser();
			ASTNode n = p.parse(args[0]);
			n.accept(new PrintVisitor());
			System.out.println();
			EvaluateVisitor ev = new EvaluateVisitor();
			n.accept(ev);
			System.out.printf("%s = %f%n%n", args[0], ev.total());
		}
		catch (ParseException pe)
		{
			System.err.printf("%s%n%s%n", args[0], pe.getMessage());
		}
	}
}                          
