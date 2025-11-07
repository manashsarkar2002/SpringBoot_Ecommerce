<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <jsp:include page="navbar.jsp" />
<%@ page import="java.util.*" %>
<%@ page import="com.example.jpa.model.Product" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
</head>
<body>
<br><br>
<br>

<div class="container mt-5">
    <div class="row">
            
            
             <%
                // Retrieve the  list from the request attribute
               List<Product> product=(List<Product>)request.getAttribute("product");
           					if(product!=null && !product.isEmpty())
           					{
           						for(Product prod:product)
           						{
            %>
                   
                   
                 <div class="col-md-4 mb-4">
    <div class="card" style="width: 18rem;">
       
        <div class="card-body">
        	<img src="" width="200" height="150" alt="Image"/>
            <h5 class="card-title"><%=prod.getName() %></h5>
            <p class="card-text">Available Quantity: <%=prod.getQuantity() %></p>
            <p class="card-text">Price Rs: <%=prod.getPrice() %> /</p>
            
            
            <a href="log" class="btn btn-primary">Buy Now</a>
            
            <a href="log" class="btn btn-primary">Add to Cart</a>
        </div>
    </div>
</div>
                   
                   
                   
                        
                        
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="3">No Product to display.</td>
                    </tr>
            <%
                }
            %>
       
           </div>
           </div>
           </div>
            
                   
                   
                   
                
        
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    