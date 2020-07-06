import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int number;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < number ) {
				message = guess + " меньше загаданного числа. Попробуйте еще разок.";
			 }
			else if (guess > number) {
				message = guess + " больше загаданного числа. Попробуйте еще разок.";
				
			} else {
				message = "Вы угадали! Давайте сыграем ещe, новое число уже загадано!";
				
				newGame();
			}
		} catch (Exception e) {
			message = "Введите целое число от 1 до 100";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
			
		}


	}
	public void newGame() {
		number = (int)(Math.random() * 100 + 1);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Maria's HiLo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Maria's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 6, 450, 16);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Дано число от 1 до 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(75, 57, 163, 26);
		getContentPane().add(lblNewLabel_1);

		txtGuess = new JTextField();
		txtGuess.setBounds(251, 56, 82, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnNewButton = new JButton("Угадать!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();

			}
		});
		txtGuess.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		}
		);
		btnNewButton.setBounds(173, 118, 113, 29);
		getContentPane().add(btnNewButton);

		lblOutput = new JLabel("Введите число в поле и нажмите \"Угадать!\"");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblOutput.setBounds(0, 182, 450, 16);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}
