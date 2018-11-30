package main.java.memoranda;

import java.util.Vector;

import main.java.memoranda.date.CalendarDate;
import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Elements;

//TASK 2-2 SMELL BETWEEN CLASSES
//Class was long and had nested classes within it.  
//they were moved outside so that it would be easier to maintain.
class Month {
	Element mElement = null;

	public Month(Element el) {
		mElement = el;
	}

	public int getValue() {
		return new Integer(mElement.getAttribute("month").getValue())
			.intValue();
	}

	public Day getDay(int d) {
		if (mElement == null)
			return null;
		Elements ds = mElement.getChildElements("day");
		String dd = new Integer(d).toString();
		for (int i = 0; i < ds.size(); i++)
			if (ds.get(i).getAttribute("day").getValue().equals(dd))
				return new Day(ds.get(i));
		//return createDay(d);
		return null;
	}

	Day createDay(int d) {
		Element el = new Element("day");
		el.addAttribute(new Attribute("day", new Integer(d).toString()));
		el.addAttribute(
			new Attribute(
				"date",
				new CalendarDate(
					d,
					getValue(),
					new Integer(
						((Element) mElement.getParent())
							.getAttribute("year")
							.getValue())
						.intValue())
					.toString()));

		mElement.appendChild(el);
		return new Day(el);
	}

	public Vector getDays() {
		if (mElement == null)
			return null;
		Vector v = new Vector();
		Elements ds = mElement.getChildElements("day");
		for (int i = 0; i < ds.size(); i++)
			v.add(new Day(ds.get(i)));
		return v;
	}

	public Element getElement() {
		return mElement;
	}

}