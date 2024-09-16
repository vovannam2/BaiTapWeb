<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Forgot Password</title>

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="main">

        <!-- Forgot Password Form -->
        <section class="forgot-password">
            <div class="container">
                <div class="forgot-password-content">
                
                    <div class="forgot-password-form">
                        <h2 class="form-title">Forgot Password</h2>
						<c:if test="${alert !=null}">
							<h3 class="alert">${message}</h3>
						</c:if>
						<form method="post" action="ResetPassword" class="register-form"
                            id="forgot-password-form">
                            <div class="form-group">
                                <label for="username"><i
                                    class="zmdi zmdi-account material-icons-name"></i></label> 
                                <input type="text" name="username" id="username"
                                    placeholder="Your Username" required />
                            </div>
                            <div class="form-group">
                                <label for="new-password"><i class="zmdi zmdi-lock"></i></label> 
                                <input type="password" name="new-password" id="new-password"
                                    placeholder="New Password" required />
                            </div>
                            <div class="form-group">
                                <label for="confirm-password"><i class="zmdi zmdi-lock-outline"></i></label> 
                                <input type="password" name="confirm-password" id="confirm-password"
                                    placeholder="Confirm New Password" required />
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="reset-password" id="reset-password"
                                    class="form-submit" value="Reset Password" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
    
    <!-- JavaScript to display alerts -->
    <script>
        // Check if there is a message or error attribute set by the servlet
   
    </script>
</body>
</html>
