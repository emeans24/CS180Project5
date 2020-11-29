# CS180Project5

Tests for LoginGUI

    Test 1 for openAndClose() method
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
    
    Test 1 for actionPerformed() method in an ActionListener object
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
    
    Test 2 for actionPerformed() method in an ActionListener object
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
    
    Test 1 for isAUser() method
        Step 1: Perform all three above tests, but adjust
        actionPerformed() method so that a System.out.println() is on
        the line directly beneath any lines where isAUser() is called.
    
    If isAUser()is working correctly, the first test should print
    "true" and the second test should print "false."
    
    Test 1 for validInfo() method
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
    
    Test 2 for validInfo() method
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
    
    Test 3 for validInfo() method
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
    
    Test 4 for validInfo() method
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
    
    Test 5 for validInfo() method
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
    
    Test 6 for validInfo() method
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
    
    Test 7 for validInfo() method
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