package main.java.memoranda;

import nu.xom.Element;


//TASK 2-2 SMELL BETWEEN CLASSES
//Class was long and had nested classes within it.  
//they were moved outside so that it would be easier to maintain.
class Day {
		Element dEl = null;

		public Day(Element el) {
			dEl = el;
		}

		public int getValue() {
			return new Integer(dEl.getAttribute("day").getValue()).intValue();
		}

		/*
		 * public Note getNote() { return new NoteImpl(dEl);
		 */

		public Element getElement() {
			return dEl;
		}
	}
