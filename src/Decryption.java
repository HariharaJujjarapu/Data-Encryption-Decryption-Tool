import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Decryption extends JFrame {
    private JTextField dataTextField;
    private JTextField codeTextField;
    private JTextArea outputTextArea;

    public Decryption() {
        setTitle("Decryption");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel dataLabel = new JLabel("Enter the data to be decrypted:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(dataLabel, gbc);

        dataTextField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(dataTextField, gbc);

        JLabel codeLabel = new JLabel("Enter the code:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(codeLabel, gbc);

        codeTextField = new JTextField(5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(codeTextField, gbc);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDecryption();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(decryptButton, gbc);

        outputTextArea = new JTextArea(5, 20);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(scrollPane, gbc);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the frame
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.SOUTHEAST; // Align to the bottom right
        panel.add(exitButton, gbc);

        add(panel);

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void performDecryption() {
        String encryptedStr = dataTextField.getText();

        try {
            String codestring = codeTextField.getText();
            int code = searchEquivalentValue(codestring);

            StringBuilder decryptedOutput = new StringBuilder();

            for (int i = 0; i < encryptedStr.length(); i++) {
                decryptedOutput.append((char) (encryptedStr.charAt(i) - code));
            }

            outputTextArea.setText(decryptedOutput.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric code.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int searchEquivalentValue(String searchString) {
        // Replace with your actual database credentials and connection URL
        String url = "jdbc:mysql://localhost:3306/javacbpcodes";
        String username = "root";
        String password = "Hari@261003";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a PreparedStatement to execute the SQL query
            String sqlQuery = "SELECT offset FROM codes WHERE codeName = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                // Set the input string parameter in the prepared statement
                preparedStatement.setString(1, searchString);

                // Execute the query and retrieve the result set
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Check if the result set has any rows
                    if (resultSet.next()) {
                        // Retrieve the value from the integer column
                        return resultSet.getInt("offset");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        // Run on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new Decryption());
    }
}
