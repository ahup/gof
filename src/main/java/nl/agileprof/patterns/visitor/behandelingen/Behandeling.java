package nl.agileprof.patterns.visitor.behandelingen;

import java.util.Date;

/**
 * @author ahup
 * @since 13/11/2016
 */
public class Behandeling
{
	private String naam;

	private Date startDatum;

	private Date eindDatum;

	public Behandeling(String naam, Date startDatum, Date eindDatum)
	{
		this.naam = naam;
		this.startDatum = startDatum;
		this.eindDatum = eindDatum;
	}

	public String getNaam()
	{
		return naam;
	}

	public Date getStartDatum()
	{
		return startDatum;
	}

	public Date getEindDatum()
	{
		return eindDatum;
	}

	public void accept(Visitor visitor)
	{
		visitor.visitBehandeling(this);
	}
}
