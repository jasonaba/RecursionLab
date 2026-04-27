import javax.swing.JFrame;

public class FractalDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create JFrame
		JFrame frame = new JFrame("Fractal City");
		frame.setSize(800, 600);
		CityPanel city = new CityPanel();
		frame.add(city);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
