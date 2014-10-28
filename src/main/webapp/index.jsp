<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Praqma roadshow</title>
    </head>

    <body>
        <h1>Welcome</h1>
        <p>
            <a href="Calculator">Link to the calculator</a>
        </p>
        <div style="width:70%; display:block; float:left;">
            <div style="float:left; vertical-align:top;">
                <h4>${project.version}</h4>
                <h2>Assignments for you</h2>
                <ol>
                    <li>Implement multiplication</li>
                    <li>Extend model and model interface to handle load/store functionality</li>
                    <li>Implement an equation display</li>
                </ol>

                <h2>Other stuff you could do</h2>
                <ol>
                    <li>Introduce additional functionality, square root, store result for later use, modulus etc..</li>
                    <li>Create a 'scientific' calculator, by extending the CalculatorModel interface</li>
                    <li>Make the user interface respond to keyboard input (plus, minus, divide, multiply)</li>
                    <li>Make the calculator able calculate with imaginary numbers</li>
                    <li>Improve the user interface with better layout and prettier buttons etc.. for example using Twitter Bootstrap templates</li>
                </ol>
            </div>
            <img src="images/eq_display.png" style="float:left; margin-left:20px;"/>
         </div>
         <div style="width:30%; display:block; float:left;">
            <h2>Requirements</h2>
            <ol>
                <li>Your implementation must be testable</li>
                <li>All your implemented methods must be unit tested with 100% coverage</li>
                <li>Your implementation must have 0 test failures</li>
                <li>You must have fund implementing the solution!</li>
            </ol>
        </div>
    </body>
</html>