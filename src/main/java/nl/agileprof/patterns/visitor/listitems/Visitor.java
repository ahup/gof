package nl.agileprof.patterns.visitor.listitems;

/**
 * @author ahup
 * @since 11/11/2016
 */
public interface Visitor
{
	int visit(Book book);

	int visit(Fruit fruit);
}
