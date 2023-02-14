
<html>

<head>
    <title>Home Page</title>
    <%@ include file="partials/head.jsp" %>
</head>

<body>


<div class="container">
    <h2 class="my-3 text-center font-weight-normal">
        Welcome back <%= request.getAttribute("username") %> :)
    </h2>
</div>


<%@ include file="partials/footer.jsp" %>

</body>

</html>