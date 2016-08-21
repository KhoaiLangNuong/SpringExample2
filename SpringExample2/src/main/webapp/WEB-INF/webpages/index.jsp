 <%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
 <html>  
  <head><title><spring:message code="header.title"/> </title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">	
  </head>  
  <body>  
       <c:if test="${param.lang == 'vi' }">  
            <a href="<spring:url value="/home?lang=vi"/>" style="color:red;">Vi</a>   
            <a href="<spring:url value="/home?lang=en"/>">En</a>  
       </c:if>  
       <c:if test="${param.lang != 'vi' }">  
            <a href="<spring:url value="/home?lang=vi"/>">Vi</a>  
            <a href="<spring:url value="/home?lang=en"/>" style="color:red;">En</a>   
       </c:if>  
   <h1><spring:message code="body.title1"/> </h1>  
   <h3><spring:message code="body.title2"/> </h3>  
   <form:form method="POST" action="submitStudentInfo" commandName="model">  
        <input type="hidden" name="lang" value="${param.lang }"/>  
        <spring:message code="body.form.your_name"/>: <c:out value="${model.name }"/>  
        <form:hidden path="name"/><br/><br/>  
        <spring:message code="body.form.your_list_of_book"/>:   
        <c:forEach items="${model.listBook}" var="book" varStatus="status">  
             <form:input path="listBook[${status.index}]"></form:input>  
        </c:forEach>  
        <input type="submit" value="<spring:message code="body.form.button.submit"/>"/>  
   </form:form>  
   <div style="background:#972F2C;color: #FFF;"><c:out value="${message}"/></div>  
  </body>  
 </html> 