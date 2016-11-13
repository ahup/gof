package nl.agileprof.patterns.visitor.behandelingen;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

/**
 * @author ahup
 * @since 13/11/2016
 */
public class HuidigeBehandelingenVisitorTest
{
	@Test
	public void testHuidigeBehandelingen()
	{

		Behandeling behandelingB1 = new Behandeling("B1", createDate("01-03-2016"), createDate("01-04-2016"));
		Behandeling behandelingB2 = new Behandeling("B2", createDate("01-04-2016"), createDate("01-05-2016"));
		List<Behandeling> behandelingen = new ArrayList<Behandeling>();
		behandelingen.add(behandelingB1);
		behandelingen.add(behandelingB2);

		HuidigeBehandelingenVisitor visitor = new HuidigeBehandelingenVisitor(createDate("15-03-2016"));
		for (Behandeling behandeling : behandelingen)
		{
			behandeling.accept(visitor);
		}

		assert (visitor.getHuidigeBehandelingen().size() == 1);
		assert (visitor.getHuidigeBehandelingen().get(0).getNaam().equals("B1"));
	}

	private Date createDate(String dateValue)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = null;
		try
		{
			inputDate = dateFormat.parse(dateValue);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return inputDate;
	}
}
