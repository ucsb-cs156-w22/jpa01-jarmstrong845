package edu.ucsb.cs56.pconrad.menuitem;

public class MenuItem {

    private String name;
    private int priceInCents;
    private String category;

    /**
     * Custom exception thrown when getPrice is called with a width
     * that is too narrow for the formatted price.
     */

    public static class TooNarrowException extends RuntimeException {
    }


    public MenuItem(String name, int priceInCents, String category) {
        this.name = name;
	this.priceInCents = priceInCents;
	this.category = category;
    }

    /**
     * Returns the category of the menu item
     */

    public String getCategory() {
	return category;
    }

    /**
     * Returns the name of the menu item
     */

    public String getName() {
	return name;
    }

    /**
     * Returns the price, formatted as a string with a $.
     * For example "$0.99", "$10.99", or "$3.50"
     */

    public String getPrice() {
	int dollars = priceInCents / 100;
	int cents = priceInCents % 100;
	String S_dollars = Integer.toString(dollars);
	String S_cents = Integer.toString(cents);
	String price = "$" + S_dollars + "." + S_cents;
        return price;
    }

    /**
     * Returns the price, formatted as a string with a $,
     * right justified in a field with the specified width.
     * For example "$0.99", "$10.99", or "$3.50".
     * <p>
     * If the width is too small, throws TooNarrowException
     *
     * @param width width of returned string
     */

    public String getPrice(int width) {
	String price = this.getPrice();
	int diff = width - price.length();
	String result = "";
	if (diff < 0) {
	    throw new TooNarrowException();
	} else if (diff == 0) {
	    result = price;
	} else {
	    String space = "";
	    for (int x = 0; x < diff; x++) {
		space += " ";
	    }
	    result = space + price;
	}

        return result;
    }

    /**
     * get the prince in cents only
     */

    public int getPriceInCents() {
	return priceInCents;
    }

    /**
     * return a string in csv format, in the order name,price,cateogry.
     * For example <code>Small Poke Bowl,1049,Poke Bowls</code>
     *
     * @return string in csv format
     */

    @Override
    public String toString() {
	String price = Integer.toString(priceInCents);
	String result = name + "," + price + "," + category;
        return result;
    }

}
