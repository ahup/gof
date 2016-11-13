package nl.agileprof.patterns.visitor.behandelingen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ahup
 * @since 13/11/2016
 */
public class HuidigeBehandelingenVisitor implements Visitor
{
	private List<Behandeling> huidigeBehandelingen = new ArrayList<Behandeling>();

	private Date currentDate;

	public HuidigeBehandelingenVisitor(Date currentDate)
	{
		this.currentDate = currentDate;
	}

	@Override
	public void visitBehandeling(Behandeling behandeling)
	{
		if (isInPeriod(behandeling))
		{
			huidigeBehandelingen.add(behandeling);
		}
	}

	private boolean isInPeriod(Behandeling behandeling)
	{
		return currentDate.after(behandeling.getStartDatum()) && currentDate.before(behandeling.getEindDatum());
	}

	public List<Behandeling> getHuidigeBehandelingen()
	{
		return huidigeBehandelingen;
	}
}
