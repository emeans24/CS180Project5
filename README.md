# CS180Project5

Note: did not test all methods involving concurrency, as Campuswire post #3414 suggested testing
for those methods was optional.

Tests for LoginGUI

    GUI Test 1 for openAndClose() method
        Step 1: Activate Server class, such as through terminal.
        Step 2: Activate LoginGUI class, such as through terminal.
        Step 3: Click on "Create Account" button.
        Step 4: Enter username.
        Step 5: Enter password.
        Step 6: Enter phone number.
        Step 7: Enter email.
        Step 8: Click "Create Account" button.
        Step 9: Click "OK" on message which appears next.
        Step 10: Check "Users.txt" file to make sure new
        username, password, etc. have been recorded.
        
    Performing the above test allowed us to make sure that
    the class performed as expected when users entered valid,
    expected input, and that both the openAndClose and run
    methods (which were called during the test) worked
    properly. Had the program not behaved as expected in the
    above testing instructions, we would have examined those
    methods to see if they contained the mistake or
    mistakes.
    
    GUI Test 1 for actionPerformed() method in an ActionListener object
        Step 1: Activate Server class, such as through terminal.
        Step 2: Activate LoginGUI class, such as through terminal.
        Step 3: Click on "Login" button.
        Step 4: Enter username not currently associated
        with any user.
        Step 5: Enter password associated with a user.
            
    Performing the above test allowed us to make sure
    an error message saying "The username or password you
    entered is incorrect." appeared when users attempted to log in
    with an incorrect username. If that message did not appear
    after the above steps, we would know the actionPerformed() method
    needed adjustment.
    
    GUI Test 2 for actionPerformed() method in an ActionListener object
        Step 1: Activate Server class, such as through terminal.
        Step 2: Activate LoginGUI class, such as through terminal.
        Step 3: Click on "Login" button.
        Step 4: Enter username currently associated with a user.
        Step 5: Enter password not currently associated with
        any user.
                
    Performing the above test allowed us to make sure
    an error message saying "The username or password you
    entered is incorrect." appeared when users attempted to log in
    with an incorrect password. If that message did not appear
    after the above steps, we would know the actionPerformed() method
    needed adjustment.
    
    GUI Test 1 for isAUser() method
        Step 1: Perform all three above tests, but adjust
        actionPerformed() method so that a System.out.println() is on
        the line directly beneath any lines where isAUser() is called.
    
    If isAUser()is working correctly, the first test should print
    "true" and the second test should print "false."
    
    GUI Test 1 for validInfo() method
        Step 1: Activate Server class, such as through terminal.
        Step 2: Activate LoginGUI class, such as through terminal.
        Step 3: Click on "Create Account" button.
        Step 4: Enter username already associated with an account.
        Step 5: Enter password.
        Step 6: Enter phone number.
        Step 7: Enter email.
        Step 8: Click "Create Account" button.
        
    Performing the above test allowed us to make sure
    an error message saying "Invalid Username" appeared when users
    attempted to create an account with a username already taken.
    If that message did not appear after the above steps, we would know the validInfo() method
    needed adjustment.
    
    GUI Test 2 for validInfo() method
        Step 1: Activate Server class, such as through terminal.
        Step 2: Activate LoginGUI class, such as through terminal.
        Step 3: Click on "Create Account" button.
        Step 4: Enter an empty String (i.e, "") in username field.
        Step 5: Enter password.
        Step 6: Enter phone number.
        Step 7: Enter email.
        Step 8: Click "Create Account" button.
        
    Performing the above test allowed us to make sure
    an error message saying "Invalid Username" appeared when users
    attempted to create an account with a an empty String as a username.
    If that message did not appear after the above steps, we would know the validInfo() method
    needed adjustment.
    
    GUI Test 3 for validInfo() method
        Step 1: Activate Server class, such as through terminal.
        Step 2: Activate LoginGUI class, such as through terminal.
        Step 3: Click on "Create Account" button.
        Step 4: Enter username.
        Step 5: Enter password less than eight characters long.
        Step 6: Enter phone number.
        Step 7: Enter email.
        Step 8: Click "Create Account" button.
        
    Performing the above test allowed us to make sure an error message
    saying "Invalid Password. Must be at least 8 characters" appeared
    when users attempted to create an account with a password less
    than eight characters long. If that message did not appear after
    the above steps, we would know the validInfo() method needed
    adjustment.
    
    GUI Test 4 for validInfo() method
        Step 1: Activate Server class, such as through terminal.
        Step 2: Activate LoginGUI class, such as through terminal.
        Step 3: Click on "Create Account" button.
        Step 4: Enter username.
        Step 5: Enter password.
        Step 6: Enter phone number.
        Step 7: Enter email with no "at" symbol (i.e, no "@").
        Step 8: Click "Create Account" button.
        
    Performing the above test allowed us to make sure an error message
    saying "Invalid Email." appeared when users attempted to create an account with an email with no
    "at" symbol. If that message did not appear after the above steps, we would know the validInfo()
    method needed adjustment.
    
    GUI Test 5 for validInfo() method
        Step 1: Activate Server class, such as through terminal.
        Step 2: Activate LoginGUI class, such as through terminal.
        Step 3: Click on "Create Account" button.
        Step 4: Enter username.
        Step 5: Enter password.
        Step 6: Enter phone number.
        Step 7: Enter email with no period.
        Step 8: Click "Create Account" button.
        
    Performing the above test allowed us to make sure an error message
    saying "Invalid Email." appeared when users attempted to create an account with an email with no
    period. If that message did not appear after the above steps, we would know the validInfo()
    method needed adjustment.
    
    GUI Test 6 for validInfo() method
        Step 1: Activate Server class, such as through terminal.
        Step 2: Activate LoginGUI class, such as through terminal.
        Step 3: Click on "Create Account" button.
        Step 4: Enter username.
        Step 5: Enter password.
        Step 6: Enter phone number with more or less than 10 numbers.
        Step 7: Enter email.
        Step 8: Click "Create Account" button.
        
    Performing the above test allowed us to make sure an error message
    saying "Invalid Phone Number (Must be 10 digits long with numbers only)"
    appeared when users attempted to create an account with a phone number.
    that was too long or short. If that message did not appear after the
    above steps, we would know the validInfo() method needed adjustment.
    
    GUI Test 7 for validInfo() method
        Step 1: Activate Server class, such as through terminal.
        Step 2: Activate LoginGUI class, such as through terminal.
        Step 3: Click on "Create Account" button.
        Step 4: Enter username.
        Step 5: Enter password.
        Step 6: Enter phone number with a letter in the place of
        one digit.
        Step 7: Enter email.
        Step 8: Click "Create Account" button.
        
    Performing the above test allowed us to make sure an error message
    saying "Invalid Phone Number (Must be 10 digits long with numbers only)"
    appeared when users attempted to create an account with a phone number.
    containing a letter. If that message did not appear after the
    above steps, we would know the validInfo() method needed adjustment.
    
    In addition to the above tests, we used JUnit to test whether the class
    existed and was inheriting from the correct superclass; whether it had
    the correct fields, and whether they had the correct types and access
    modifiers; whether it had the correct methods, and whether they had the
    correct return types and access modifiers; and whether its methods
    behaved properly with proper input and failed otherwise.
    
Tests for Server

    We used JUnit to test whether the class existed and was inheriting from
    the correct superclass; whether it had the correct fields, and whether
    they had the correct types and access modifiers; whether it had the
    correct methods, and whether they had the correct return types and
    access modifiers; and whether its methods behaved properly with proper
    input and failed otherwise.
        
Tests for User

    We used JUnit to test whether the class existed and was inheriting from
    the correct superclass; whether it had the correct fields, and whether
    they had the correct types and access modifiers; whether it had the
    correct methods, and whether they had the correct return types and
    access modifiers; and whether its methods behaved properly with proper
    input and failed otherwise.
        
Tests for ChatMessage

    We used JUnit to test whether the class existed and was inheriting from
    the correct superclass; whether it had the correct fields, and whether
    they had the correct types and access modifiers; whether it had the
    correct methods, and whether they had the correct return types and
    access modifiers; and whether its methods behaved properly with proper
    input and failed otherwise.
    
Tests for MessageClient

    GUI Test 1 for display() method in GUI mode
        Although the display() method deals solely
        with GUI operations in GUI mode, we chose
        to test it in the main method of
        RunLocalTest because testing it only
        seemed feasible if we ran a program
        including an instance of the
        MessageClientGUI class, and at the
        time MessageClientGUI's own main method
        wasn't working properly. To test it, we
        simply ran the main method of
        RunLocalTest and checked to ensure that
        a message appeared in the chat room saying
        "Method display is working correctly in
        GUI mode."
        
    GUI Test 1 for sendMessage() method in GUI mode
        Step 1: run MessageServer, then
        MessageServerGUI, then MessageClient.
        Step 2: click login.
        Step 3: type Client in the window running
        MessageClient, hit enter, then type the
        word "Test," and hit enter again.
        The current time, followed by "Anonymous:
        Client," should appear in the chat room
        window.
    The above test allowed us to ensure that the
    sendMessage() method functioned properly. As
    its only perimeter was a ChatMessage object,
    there wasn't really a way to give an
    incorrect input, so it was only tested for
    proper input.
        
    GUI Test 1 for disconnect() method in GUI mode
        Step 1: run MessageServer, then
        MessageServerGUI, then MessageClient.
        Step 2: click login.
        Step 3: type Client in the window running
        MessageClient, and then hit enter.
        Step 4: type Client in the window running
        MessageClient, and then hit enter. The
        window running MessageClient should
        display the following message: "Server
        has closed the connection:
        java.net.SocketException: socket closed,"
        if the disconnect() method is working
        properly.
    The above test allowed us to ensure that the
    sendMessage() method functioned properly. As
    its only perimeter was a ChatMessage object,
    there wasn't really a way to give an
    incorrect input, so it was only tested for
    proper input.
    
    GUI Test 1 for run() method
        Step 1: Repeat steps for testing start()
        method, as the run() method plays a large
        role in start() method's operation. If
        the messages expected in those testing
        instructions do not appear, the run()
        method is not working properly.
    The above test allowed us to ensure that the
    run() method functioned properly. As
    the run() method had no parameters,
    there wasn't really a way to give
    incorrect input, so it was only tested for
    proper input.
    
    In addition to the above tests, we used JUnit to test whether the class
    existed and was inheriting from the correct superclass; whether it had
    the correct fields, and whether they had the correct types and access
    modifiers; whether it had the correct methods, and whether they had the
    correct return types and access modifiers; and whether its methods
    behaved properly with proper input and failed otherwise.
    

Tests for MessageClientGUI

    GUI Test 1 for append() method
        Although the append() method deals solely
        with GUI operations, we chose to test it
        in the main method of RunLocalTest
        because testing it only seemed feasible
        if we ran a program including an instance
        of the MessageClientGUI class, and at the
        time MessageClientGUI's own main method
        wasn't working properly. To test it, we
        simply ran the main method of
        RunLocalTest and checked to ensure that
        a message appeared on the computer saying
        "If you see this message, method append is
        working properly."
        
    GUI Test 1 for append() method
        Although the connectionFailed() method
        deals solely with GUI operations, we
        chose to test it in the main method of
        RunLocalTest because testing it only
        seemed feasible if we ran a program
        including instances of both the
        MessageClientGUI and MessageClient
        classes, and at the
        time MessageClientGUI's own main method
        wasn't working properly. To test it, we
        simply ran the main method of
        RunLocalTest and checked to ensure that
        a message appeared on the computer saying
        "Method connectionFailed is
        working correctly."
        
    In addition to the above tests, we used JUnit to test whether the class
    existed and was inheriting from the correct superclass; whether it had
    the correct fields, and whether they had the correct types and access
    modifiers; whether it had the correct methods, and whether they had the
    correct return types and access modifiers; and whether its methods
    behaved properly with proper input and failed otherwise.
        
Tests for MessageClientGUI

    GUI Test 1 for actionPerformed()
        Step 1: Run MessageServer.
        Step 2: Run MessageClient, then MessageClientGUI.
        Step 3: Click Login.
        Step 4: The chat room window should display the
        message "Connection accepted
        localhost/127.0.0.1:1500."
        Step 5: Click Users.
        Step 6: The chat room window should display the
        message "List of the users connected at [insert current time here]
        1) Anonymous since [insert time MessageClientGUI began running here]."
        Step 7: Click Logout. Doing this should switch
        the Logout and Users buttons to a darker shade
        of grey.
    Performing the above test allowed us to make sure that
    the actionPerformed() method worked properly. If the
    above steps did not yield the expected messages and
    color changes, we would know there was something wrong
    with the method. 
    
    In addition to the above tests, we used JUnit to test whether the class
    existed and was inheriting from the correct superclass; whether it had
    the correct fields, and whether they had the correct types and access
    modifiers; whether it had the correct methods, and whether they had the
    correct return types and access modifiers; and whether its methods
    behaved properly with proper input and failed otherwise.
    
Tests for MessageServer

    GUI Test 1 for start() method
        To test this method, simply run the MessageServer class. If the
        window running the method shows the message "Server waiting for
        Clients on port [insert port number here]," then the method is
        working properly.
        
    GUI Test 1 for stop() method
        Step 1: Run the MessageServerGUI class.
        Step 2: Click the start button. It should switch to display
        the word "Stop."
        Step 3: Run the MessageClient class.
        Step 4: Click the stop button. It should become a start button
        again.
    Performing the above test allowed us to make sure that
    the stop() method worked properly. If the
    above steps did not yield the expected changes to the start
    button, we would know there was something wrong
    with the method.
    
    GUI Test 1 for display() method
        Because the start() method calls the display() method in order
        to display the "Server waiting for Clients on port [insert
        port number here]," we tested the display() method the same way
        we tested the start() method. In both cases, if the expected message did not appear,
        we would know the method was not functioning properly.
        
    Test 1 for broadcast() method
        Step 1: Run MessageServer, then MessageClient.
        Step 2: Type Client in the window running
        MessageClient, hit enter, then type the word "Test," and hit enter again.
        The current time, followed by "Anonymous: Client," should appear in the window
        running MessageServer.
    Performing the above test allowed us to make sure that
    the broadcast() method worked properly. If the
    above steps did not yield the expected messages, we would know there was something
    wrong with the method.
    
    Test for remove() method
        Step 1: Run MessageServer.
        Step 2: Run MessageClient.
        Step 3: Run MessageClientGUI.
        Step 4: Click Login.
        Step 5: Type "Users" in the window running MessageClient. The
        window should display a list containing two users, both named Anonymous.
        Step 6: Click Logout.
        Step 7: Type "Users" in the window running MessageClient. The
        window should display a list containing only one User this time.
    Performing the above test allowed us to make sure that
    the remove() method worked properly. If the
    above steps did not yield the expected messages, we would know there was something
    wrong with the method.
    
Tests for MessageServerGUI
    
    GUI Test 1 for start() method
        To test this method, run the MessageServerGUI class. The method is working
        properly if a window appears containing two white boxes, and the upper box
        shows the message "Chat room."
        
    GUI Test 1 for start() method
        To test this method, run the MessageServerGUI class. The method is working
        properly if a window appears containing two white boxes, and the lower box
        shows the message "Events log."
        
    GUI Test 1 for actionPerformed() method
        Step 1: Run the MessageServerGUI class.
        Step 2: Click the start button. It should switch to display
        the word "Stop."
        Step 3: Click the stop button. It should become a start button
        again.
    Performing the above test allowed us to make sure that
    the actionPerformed() method worked properly. If the
    above steps did not yield the expected changes to the start
    button, we would know there was something wrong
    with the method.
        
    GUI Test 1 for windowClosing() method
        Step 1: Run the MessageServerGUI class.
        Step 2: Click the start button.
        Step 3: Run the MessageClient class.
        Step 4: Click the red "X" button of the MessageServerGUI;
        it should vanish. The MessageClient class should now
        display the message "Server has close the connection:
        java.io.EOFException."
    Performing the above test allowed us to make sure that
    the windowClosing() method worked properly by ensuring that it
    closed its connection, in addition to closing the
    MessageServerGUI. If the above steps did not yield the
    expected messages, and close the MessageServerGUI, we would
    know there was something wrong with the method.
