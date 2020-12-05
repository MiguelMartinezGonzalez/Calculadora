import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class Vista extends JFrame {

	private static final long serialVersionUID = 9196050215311033348L;

	private JPanel contentPane;
	private final JLabel Cuadro1 = new JLabel("N\u00DAMERO 1");
	private JTextField Texto1;
	private JTextField Texto2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(new File("src/musica/Genshin.wav")));
					clip.start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
					System.out.println("Error al reproducir sonido");
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/img/iconito.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Cuadro1.setForeground(Color.WHITE);
		Cuadro1.setFont(new Font("Arial", Font.BOLD, 13));
		Cuadro1.setBounds(44, 173, 95, 25);
		contentPane.add(Cuadro1);

		JLabel Cuadro2 = new JLabel("N\u00DAMERO 2");
		Cuadro2.setForeground(Color.WHITE);
		Cuadro2.setFont(new Font("Arial", Font.BOLD, 13));
		Cuadro2.setBounds(211, 173, 95, 25);
		contentPane.add(Cuadro2);

		Texto1 = new JTextField();
		Texto1.setForeground(Color.BLACK);
		Texto1.setFont(new Font("Arial", Font.BOLD, 13));
		Texto1.setBounds(44, 202, 131, 25);
		contentPane.add(Texto1);
		Texto1.setColumns(10);

		Texto2 = new JTextField();
		Texto2.setForeground(Color.BLACK);
		Texto2.setFont(new Font("Arial", Font.BOLD, 13));
		Texto2.setColumns(10);
		Texto2.setBounds(211, 202, 131, 25);
		contentPane.add(Texto2);

		JLabel Resultado = new JLabel("");
		Resultado.setForeground(Color.WHITE);
		Resultado.setFont(new Font("Arial", Font.BOLD, 13));
		Resultado.setBounds(555, 433, 145, 25);
		contentPane.add(Resultado);

		JButton Boton1 = new JButton("Sumar");
		Boton1.setForeground(Color.BLACK);
		Boton1.setBackground(new Color(255, 255, 255));
		Boton1.setFont(new Font("Arial", Font.BOLD, 13));
		Boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int suma = Integer.parseInt(Texto1.getText()) + Integer.parseInt(Texto2.getText());
				Resultado.setText("EL RESULTADO ES " + suma);
			}
		});
		Boton1.setBounds(44, 273, 131, 31);
		contentPane.add(Boton1);

		JButton Boton2 = new JButton("Restar");
		Boton2.setForeground(Color.BLACK);
		Boton2.setBackground(new Color(255, 255, 255));
		Boton2.setFont(new Font("Arial", Font.BOLD, 13));
		Boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int restar = Integer.parseInt(Texto1.getText()) - Integer.parseInt(Texto2.getText());
				Resultado.setText("El resultado es " + restar);
			}
		});
		Boton2.setBounds(211, 273, 131, 31);
		contentPane.add(Boton2);

		JButton Boton3 = new JButton("Multiplicar");
		Boton3.setForeground(Color.BLACK);
		Boton3.setBackground(new Color(255, 255, 255));
		Boton3.setFont(new Font("Arial", Font.BOLD, 13));
		Boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int multiplicar = Integer.parseInt(Texto1.getText()) * Integer.parseInt(Texto2.getText());
				Resultado.setText("El resultado es " + multiplicar);
			}
		});
		Boton3.setBounds(44, 336, 131, 31);
		contentPane.add(Boton3);

		JButton Boton4 = new JButton("Dividir");
		Boton4.setForeground(Color.BLACK);
		Boton4.setBackground(new Color(255, 255, 255));
		Boton4.setFont(new Font("Arial", Font.BOLD, 13));
		Boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dividir = Integer.parseInt(Texto1.getText()) / Integer.parseInt(Texto2.getText());
				Resultado.setText("El resultado es " + dividir);
			}
		});
		Boton4.setBounds(211, 336, 131, 31);
		contentPane.add(Boton4);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setIcon(new ImageIcon("src/img/icono.png"));
		lblNewLabel.setBounds(44, 11, 250, 151);
		contentPane.add(lblNewLabel);

		JButton raizCuadrada = new JButton("Ra\u00EDz Cuadrada");
		raizCuadrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funcionabilidad No Disponible", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		raizCuadrada.setFont(new Font("Arial", Font.BOLD, 13));
		raizCuadrada.setBackground(Color.WHITE);
		raizCuadrada.setBounds(44, 400, 131, 31);
		contentPane.add(raizCuadrada);

		JButton raizCubica = new JButton("Ra\u00EDz C\u00FAbica");
		raizCubica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String password = JOptionPane.showInputDialog(null, "Escriba la Contraseña",
						"Funcionabilidad Bloqueada", JOptionPane.QUESTION_MESSAGE);

				if ("12345".equals(password)) {
					JOptionPane.showMessageDialog(null, "Contraseña Correcta", "Funcionabilidad Disponible",
							JOptionPane.INFORMATION_MESSAGE);

					Double raiz = (double) Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un Número",
							"Funcionabilidad Activada", JOptionPane.QUESTION_MESSAGE));
					double otroNumero = raiz;
					double raizCubica = Math.cbrt(otroNumero);
					Resultado.setText("EL RESULTADO ES " + raizCubica);

				} else {
					JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		raizCubica.setFont(new Font("Arial", Font.BOLD, 13));
		raizCubica.setBackground(Color.WHITE);
		raizCubica.setBounds(211, 400, 131, 31);
		contentPane.add(raizCubica);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("src/img/fondo.jpg"));
		fondo.setBounds(0, -73, 722, 621);
		contentPane.add(fondo);
	}
}
