package CS180Project5;

import org.junit.Test;
import org.junit.After;
import java.lang.reflect.Field;
import org.junit.Assert;
import org.junit.Before;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.*;
import java.net.Socket;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * RunLocalTest
 *
 * A class for testing classes in Project 5
 *
 * Received help understanding JUnit tests from "IntelliJ IDEA. Writing Tests with JUnit 5 (2020)" on YouTube, program
 * based on RunLocalTest from previous CS180 assignment
 *
 * @author Timothy Porterfield
 * @version 11/29/2020
 *
 */

public class RunLocalTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - JUnit test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }

        User testUser = new User("Mr. Tess Tyooser", "elvishwordforfriend", "e@mail.gov",
                1231231231);
        LoginGUI.allUsers.add(testUser);

        if (LoginGUI.isAUser("Mr. Tess Tyooser", "elvishwordforfriend")) {
            System.out.println("Method isAUser is working correctly with correct input.");
        } else {
            System.out.println("Method isAUser is failing with correct input; something is wrong with it.");
        }

        if (LoginGUI.isAUser("Mr. Tess Tyooser", "dwarvishwordforfriend") || LoginGUI.isAUser(
                "Not Mr. Tess Tyooser", "elvishwordforfriend") || LoginGUI.isAUser(
                "Not Mr. Tess Tyooser", "dwarvishwordforfriend")) {
            System.out.println("Method isAUser is handling incorrect input improperly; something is wrong with it.");
        } else {
            System.out.println("Method isAUser is handling incorrect input properly.");
        }

        while (LoginGUI.allUsers.indexOf(testUser) != -1) {
            LoginGUI.allUsers.remove(LoginGUI.allUsers.indexOf(testUser));
        }
    }

    public static class TestCase {
        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalSysin);
            System.setOut(originalOutput);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }

        @Test(timeout = 1000)
        public void testLoginGUI() { // Performs tests for LoginGUI class
            Class<?> clazz;
            String className;
            int modifiers;
            Field testField;
            Class<?>[] superinterfaces;
            Class<?> superclass;
            Class<?> type;
            Method method;
            Class<?> actualReturnType;

            try {
                Class.forName("CS180Project5.LoginGUI");
                clazz = LoginGUI.class;
            } catch (ClassNotFoundException e) {
                Assert.fail("Ensure that LoginGUI exists!");

                return;
            }

            modifiers = clazz.getModifiers();
            superinterfaces = clazz.getInterfaces();
            superclass = clazz.getSuperclass();
            className = "LoginGUI";

            assertEquals("Ensure that LoginGUI extends JComponent!",
                    superclass, JComponent.class); // tests to ensure LoginGUI exists and inherits from Object

            /**
             * verifies that login field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            String fieldName = "login";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName
                    + "` field is the correct type!", expectedType, type);

            /**
             * verifies that createAccount field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "createAccount";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JButton.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that enter field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "enter";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JButton.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that enter1 field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "enter1";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JButton.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that back field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "back";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JButton.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that back1 field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "back1";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JButton.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that userName field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "userName";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JTextField.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that userName1 field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "userName1";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JTextField.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that password field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "password";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JPasswordField.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that password1 field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "password1";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JPasswordField.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that enter field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "phoneNumber";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JTextField.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that email field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "email";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JTextField.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that welcomePanel field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "welcomePanel";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JFrame.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that loginPanel field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "loginPanel";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JFrame.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that createAccountPanel field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "createAccountPanel";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = JFrame.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            /**
             * verifies that counter field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "counter";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = int.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is `static`!", Modifier.isStatic(modifiers));

            /**
             * verifies that allUsers field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "allUsers";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = ArrayList.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is `static`!", Modifier.isStatic(modifiers));

            /**
             * verifies that newUsers field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "newUsers";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = ArrayList.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is `static`!", Modifier.isStatic(modifiers));

            /**
             * verifies that socket field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "socket";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = Socket.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is `static`!", Modifier.isStatic(modifiers));

            /**
             * verifies that openAndClose method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            String methodName = "openAndClose";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that run method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "run";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType(); // start here

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that createAccountPanelExitProcedure method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "createAccountPanelExitProcedure";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType(); // start here

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that loginPanelExitProcedure method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "loginPanelExitProcedure";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType(); // start here

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that welcomePanelExitProcedure method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "welcomePanelExitProcedure";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType(); // start here

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that isAUser method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "isAUser";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = boolean.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` with" +
                        " two parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType(); // start here

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `static`!", Modifier.isStatic(modifiers));

            /**
             * verifies that validInfo method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "validInfo";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = boolean.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType(); // start here

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `static`!", Modifier.isStatic(modifiers));
        }

        @Test(timeout = 1000)
        public void testServer() { // Performs tests for Server class
            Class<?> clazz;
            Class<?> superclass;

            try {
                Class.forName("CS180Project5.Server");
                clazz = Server.class;
            } catch (ClassNotFoundException e) {
                Assert.fail("Ensure that Server exists!");

                return;
            }

            superclass = clazz.getSuperclass();

            assertEquals("Ensure that Server does NOT extend any other class!",
                    superclass, Object.class); // tests to ensure LoginGUI exists and inherits from Object
        }

        @Test(timeout = 1000)
        public void testUser() { // Performs tests for User class
            Class<?> clazz;
            String className;
            int modifiers;
            Field testField;
            Class<?> superclass;
            Class<?> type;
            Method method;
            Class<?> actualReturnType;
            User testUser;

            try {
                Class.forName("CS180Project5.User");
                clazz = User.class;
            } catch (ClassNotFoundException e) {
                Assert.fail("Ensure that User exists!");

                return;
            }

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            className = "User";

            assertEquals("Ensure that User does NOT extend any other class!",
                    superclass, Object.class); // tests to ensure LoginGUI exists and inherits from Object

            /**
             * verifies that userName field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            String fieldName = "userName";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            Class<?> expectedType = String.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName
                    + "` field is the correct type!", expectedType, type);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is `private`!", Modifier.isPrivate(modifiers));

            /**
             * verifies that password field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "password";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = String.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is `private`!", Modifier.isPrivate(modifiers));

            /**
             * verifies that email field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "email";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = String.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is `private`!", Modifier.isPrivate(modifiers));

            /**
             * verifies that phoneNumber field exists,
             * and that it has the correct type and access modifier
             */

            // set the field that you want to test
            fieldName = "phoneNumber";

            // set the type of the field you want to test
            // use the type + .class
            // for example, String.class or int.class
            expectedType = long.class;

            // attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is the correct type!", expectedType, type);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName +
                    "` field is `private`!", Modifier.isPrivate(modifiers));

            /**
             * verifies that setUserName method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            String methodName = "setUserName";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that getUserName method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "getUserName";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = String.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that setUserName and getUserName function
             * properly when given proper input (as input is of type String, all input is acceptable,
             * and no test for failure upon receiving incorrect input is necessary)
             */

            testUser = new User("Alvin User", "pancakenomicon", "darkmagicpancakes@arcane.net",
                    1231231231);

            testUser.setUserName("Pancakesior");

            Assert.assertTrue("Ensure that `" + className + "`'s `setUserName` and `getUserName` methods " +
                    "work properly!", testUser.getUserName().equals("Pancakesior"));

            /**
             * verifies that setPassword method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "setPassword";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that getPassword method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "getPassword";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = String.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that setPassword and getPassword function
             * properly when given proper input (as input is of type String, all input is acceptable,
             * and no test for failure upon receiving improper input is necessary)
             */

            testUser.setPassword("darkbookofpancakesecrets");

            Assert.assertTrue("Ensure that `" + className + "`'s `setPassword` and `getPassword` methods " +
                    "work properly!", testUser.getPassword().equals("darkbookofpancakesecrets"));

            /**
             * verifies that setEmail method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "setEmail";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that getEmail method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "getEmail";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = String.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that setEmail and getEmail function
             * properly when given proper input (as input is of type String, all input is acceptable,
             * and no test for failure upon receiving improper input is necessary)
             */

            testUser.setEmail("pancakes@repectablepancakeemailservice.com");

            Assert.assertTrue("Ensure that `" + className + "`'s `setEmail` and `getEmail` methods " +
                    "work properly!", testUser.getEmail().equals("pancakes@repectablepancakeemailservice.com"));

            /**
             * verifies that setPhoneNumber method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "setPhoneNumber";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, long.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that getPhoneNumber method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "getPhoneNumber";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = long.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that setPhoneNumber and getPhoneNumber function
             * properly when given proper input, and fail with
             * improper input (uses ideas recommended in response to
             * Campuswire post # 3339: Project 5 Test Cases)
             */

            testUser.setPhoneNumber(1212121212);

            Assert.assertTrue("Ensure that `" + className + "`'s `setPhoneNumber` and " +
                    "`getPhoneNumber` methods work properly!", testUser.getPhoneNumber() == 1212121212);

            /**
             * verifies that toString method exists,
             * and that it has the correct type and access modifier
             */

            // Set the method that you want to test
            methodName = "toString";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            expectedReturnType = String.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName +
                    "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName +
                    "` method has the correct return type!", expectedReturnType, actualReturnType);

            /**
             * verifies that toString functions properly (toString has no input, so no test
             * is performed for incorrect input)
             */

            Assert.assertTrue("Ensure that `" + className + "`'s `toString` method " +
                    "works properly!",
                    testUser.toString().equals("Pancakesior,darkbookofpancakesecrets," +
                            "pancakes@repectablepancakeemailservice.com,1212121212"));
        }
    }
}
