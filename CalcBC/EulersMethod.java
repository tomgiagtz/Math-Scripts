import java.math.*;

public class EulersMethod {
	public static void main(String[] args) {
		double x, y, xFin;
		x = Double.parseDouble(args[0]);
		y = Double.parseDouble(args[1]);
		xFin = Double.parseDouble(args[2]);
		int steps = Integer.parseInt(args[3]);
		double dx = (xFin - x)/steps;
		System.out.println("dx =" + round(dx));
		double change, dy;
		boolean isRight = dx > 0;

		System.out.println("|x \t|y \t|dydx \t|dx \t|dy");
		
		for (int i = 0; (isRight && x < xFin) || (!isRight && x > xFin); x += dx) {
		
			change = dydx(x, y);
			dy = change * dx;
			y += dy;
			System.out.println("|" + round(x) + " \t|" + round(y) + " \t|" + round(change) + " \t|" + round(dx) + "\t|" + round(dy));

		}
		System.out.println("Final point = (" + round(x) +", " + round(y) + ")");



	}

	public static double dydx(double x, double y){
		double change;
		//change this function to represent the one given
		change = 2x + 1;
		//System.out.println("(" + x + ", " + y + ") dy/dx = " + change);
		return change;
	}
	//attempt to round - not actually rounding right now :(
	public static double round(double value) {

    	BigDecimal bd = new BigDecimal(value);
    	bd = bd.setScale(4, RoundingMode.HALF_UP);
    	return bd.doubleValue();
	}
}