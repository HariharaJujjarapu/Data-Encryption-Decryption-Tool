
# Data Encryption & Decryption Tool

The "Data Encryption & Decryption Tool" is a Java-based desktop application that provides a user-friendly interface for encrypting and decrypting text data using a simple substitution cipher. It includes two main functionalities: encryption and decryption. The tool allows users to input text data and a secret code, and it performs encryption or decryption based on the selected operation.


## Features

- Main Menu:
The application starts with a main menu that presents three options: Encryption, Decryption, and Exit.

- Encryption:
Users can choose the "Encryption" option to open a new window for encrypting their text data.
The encryption process involves substituting each character in the input text with a modified character based on a numeric code provided by the user.
The encrypted result is displayed in a text area, and users can copy the encrypted text for further use.

- Decryption:
The "Decryption" option opens a window for decrypting encrypted text.
Users enter the encrypted text and the original numeric code to reveal the decrypted result.
The decrypted output is displayed in a text area, allowing users to view the original text. 

- Database Integration:
The application integrates with a MySQL database to store and retrieve numeric codes associated with code names.
A separate window for decryption includes a database query to find the numeric code based on the provided code name.

- User-Friendly Interface:
The graphical user interface (GUI) is designed with Swing components, providing an intuitive and easy-to-use experience.
Proper input validation is implemented to handle errors, ensuring the user provides valid data.


# How to Use:
- Launch Application:
Run the application to open the main menu.
Select either "Encryption" or "Decryption" based on the desired operation.

- Encryption:
Enter the text to be encrypted.
Input a numeric code for encryption.
Click the "Encrypt" button to view the encrypted result.
Optionally, copy the encrypted text for use.

- Decryption:
Enter the encrypted text.
Input the original numeric code used for encryption.
Click the "Decrypt" button to view the decrypted result.

- Exit:
Choose the "Exit" option to close the application.
# Dependencies:
- The application relies on the Java Swing library for the graphical user interface.
- It requires a MySQL database for storing and retrieving numeric codes.

# Note:
Before using the "Decryption" feature, ensure that the associated MySQL database is properly configured with the required tables.

# Future Enhancements:

- Implementation of more advanced encryption algorithms for enhanced security.
- User authentication and authorization features.
- Improved error handling and user feedback.

# Conclusion:
The "Data Encryption & Decryption Tool" provides a convenient solution for users who need a simple and secure way to encrypt and decrypt their text data. With a user-friendly interface and integration with a database, it offers a practical and efficient tool for protecting sensitive information.




