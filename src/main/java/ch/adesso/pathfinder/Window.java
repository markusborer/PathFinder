package ch.adesso.pathfinder;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Window extends JFrame {

	private static final int PIXEL_SIZE = 5;

	private int width;
	private int height;
	private BufferedImage image;

	public Window(int width, int height) {
		super();
		this.width = width * PIXEL_SIZE;
		this.height = height * PIXEL_SIZE;
		initialize();
	}

	private void initialize() {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		JPanel panel = new JPanel() {
			@Override
			public void paint(Graphics graphics) {
				super.paint(graphics);
				graphics.drawImage(image, 0, 0, null);
			}
		};
		panel.setPreferredSize(new Dimension(width, height));
		add(panel);
		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setColor(Point point, int[] color) {
		for (int xOffset = 0; xOffset < PIXEL_SIZE; xOffset++) {
			for (int yOffset = 0; yOffset < PIXEL_SIZE; yOffset++) {
				image.getRaster().setPixel(point.x * PIXEL_SIZE + xOffset, point.y * PIXEL_SIZE + yOffset, color);
			}
		}
	}


}
