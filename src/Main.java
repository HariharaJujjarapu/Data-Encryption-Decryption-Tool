import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;

    public Main() {
        frame = new JFrame("Data Encryption & Decryption");
        frame.setSize(450, 325);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeUI();
    }

    private void initializeUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Select Required Option", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, gbc);

        JRadioButton eb = new JRadioButton("Encryption");
        JRadioButton db = new JRadioButton("Decryption");
        JRadioButton exitbtn = new JRadioButton("Exit");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(eb);
        buttonGroup.add(db);
        buttonGroup.add(exitbtn);

        gbc.gridy = 1;
        panel.add(eb, gbc);
        gbc.gridy = 2;
        panel.add(db, gbc);
        gbc.gridy = 3;
        panel.add(exitbtn, gbc);

        JButton submitButton = new JButton("Submit");
        gbc.gridy = 4;
        panel.add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (eb.isSelected()) {
                    openEncryptionFrame();
                } else if (db.isSelected()) {
                    openDecryptionFrame();
                } else if (exitbtn.isSelected()) {
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select an option");
                }
            }
        });

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void openEncryptionFrame() {
        frame.dispose(); // Close the current frame
        new Encryption(); // Open the Encryption frame
    }

    private void openDecryptionFrame() {
        frame.dispose(); // Close the current frame
        new Decryption(); // Open the Decryption frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            new Main();
        });
    }
}
