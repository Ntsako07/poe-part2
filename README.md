poe part2

QuickChat Messaging Application
---

#### Overview

#### 

#### QuickChat is a Java console-based messaging application that allows users to:

#### 

#### Log into the system

#### Send messages

#### Validate recipient numbers

#### Generate unique message IDs

#### Create message hashes

#### Store messages for later

#### Display sent messages

#### Track the total number of messages sent

#### 

#### The project demonstrates:

#### 

#### Object-Oriented Programming (OOP)

#### File handling

#### Validation

#### Arrays and ArrayLists

#### User interaction using Scanner

#### Basic message management

#### Features

#### User Login

#### 

#### Users must log in using the correct credentials.

#### 

#### Default Login Credentials

#### Username	Password

#### admin	Pass@123

#### Message Sending

#### 

#### Users can:

#### 

#### Send messages

#### Disregard messages

#### Store messages for later

#### Message Validation

#### Recipient Validation

#### 

#### A recipient number must:

#### 

#### Start with +

#### Be no longer than 10 characters

#### 

#### Example:

#### 

#### +278312345

#### Message Length Validation

#### 

#### Messages cannot exceed 250 characters.

#### 

#### Message ID

#### 

#### Each message receives a randomly generated:

#### 

#### 10-digit unique ID

#### 

#### Example:

#### 

#### 1234567890

#### Message Hash

#### 

#### A message hash is automatically generated using:

#### 

#### First 2 digits of Message ID

#### Message number

#### First word of message

#### Last word of message

#### Example

#### 12:1:HELLOWORLD

#### JSON Storage

#### 

#### Messages can be stored in:

#### 

#### storedMessages.json

#### 

#### Stored details include:

#### 

#### Message ID

#### Message Hash

#### Recipient

#### Message Content

#### Project Structure

#### message.pkgclass

#### │

#### ├── Message.java

#### └── QuickChat.java

#### Classes

#### Message.java

#### 

#### Handles:

#### 

#### Message creation

#### Message validation

#### Message hashing

#### Message storage

#### Displaying sent messages

#### Important Methods

#### Method	Description

#### checkMessageID()	Validates message ID

#### checkRecipientCell()	Validates recipient number

#### validateMessage()	Validates message length

#### createMessageHash()	Generates message hash

#### sentMessage()	Handles send/store/disregard

#### storeMessage()	Saves messages to JSON

#### printMessages()	Displays sent messages

#### returnTotalMessages()	Returns total sent messages

#### QuickChat.java

#### 

#### Handles:

#### 

#### User login

#### Main application menu

#### Message sending flow

#### User interaction

#### Main Menu

#### 1\. Send Messages

#### 2\. Show recently sent messages

#### 3\. Quit

#### How to Run the Program

#### Requirements

#### Java JDK 8 or higher

#### NetBeans IDE (recommended)

#### Compile and Run

#### Using NetBeans

#### Open the project in NetBeans

#### Right-click the project

#### Select:

#### Run

#### Using Command Line

#### 

#### Compile:

#### 

#### javac message/pkgclass/\*.java

#### 

#### Run:

#### 

#### java message.pkgclass.QuickChat

#### Example Program Flow

#### ===== QUICKCHAT LOGIN =====

#### 

#### Enter username: admin

#### Enter password: Pass@123

#### 

#### Welcome to QuickChat.

#### 

#### How many messages would you like to send? 2

#### Example Sent Message

#### ===== MESSAGE DETAILS =====

#### 

#### Message ID: 1234567890

#### Message Hash: 12:1:HELLOWORLD

#### Recipient: +278312345

#### Message: Hello World

#### Future Improvements

#### 

#### Possible enhancements:

#### 

#### GUI interface

#### Database integration

#### Encryption for messages

#### Real-time chat

#### Better JSON formatting

#### Message search functionality

#### Delete stored messages

#### User registration system

#### Technologies Used

#### Java

#### OOP Principles

#### File Handling

#### JSON Formatting

#### NetBeans IDE

#### Author

#### 

#### Developed as part of a Java programming project for QuickChat messaging functionality.

#### 

#### Get sma

