<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 26/8/15
  Time: 11:37 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <script>

    </script>
</head>

<body>
<div>
    <p>below is the Test</p>
    <g:form controller="person" action="test2" method="POST" name="test2">
        <g:textField name="encryptedText" value="${encryptedText}"/><br><br>
        <g:submitButton name="decrypted"/>
    </g:form>

</div>
%{--<iframe id="frame" src="${createLink(controller: 'person', action: 'two')}"/>--}%
%{--<iframe id="3frame1" style="height: 95%; width: 100%; " src="http://localhost:8070/blogistan/login"/>--}%
%{--<iframe id="3frame" style="height: 95%; width: 100%; " src="http://localhost:8070/blogistan/signUp"/>--}%
</body>
</html>
