<%@page import="model.Score"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<title>Danh sach diem</title>
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/index.css"/>
<link rel="stylesheet" href="fontawesome-free-5.15.4-web/css/all.css"/>
</head>
<body>
  <div class="sidebar">
    <div class="logo-details">
      <i class='bx bxl-c-plus-plus icon'></i>
        <div class="logo_name">Manager</div>
        <i class='bx bx-menu' id="btn" ></i>
    </div>
    <ul class="nav-list">
      <!-- <li>
          <i class='bx bx-search' ></i>
         <form action="SearchStudent" method="get">
         	<input type="text" placeholder="Tìm kiếm sinh viên" name="key">
         </form>
         <span class="tooltip">Search</span>
      </li> -->
      
      <li>
       <a href="ListUser">
         <i class='bx bx-user' ></i>
         <span class="links_name">Quan ly User</span>
       </a>
       <span class="tooltip">Quan ly User</span>
     </li>
     <li>
       <a href="Setting">
         <i class="fas fa-hospital-alt"></i>
         <span class="links_name">Cau hinh</span>
       </a>
       <span class="tooltip">Cau hinh</span>
     </li>
     <li>
       <a href="BaoCao">
         <i class='bx  bx-right-arrow'></i>
         <span class="links_name">Xuat bao cao</span>
       </a>
       <span class="tooltip">Xuat bao cao</span>
     </li>
      <li>
       <!-- <a href="ListClassRoom">
         <i class="fas fa-hospital-alt"></i>
         <span class="links_name">Manage ClassRoom</span>
       </a> -->
      <!--  <span class="tooltip">Manager ClassRoom</span> -->
     </li>
<!--      <li class="profile">
         <div class="profile-details">
           <img src="profile.jpg" alt="profileImg">
           <div class="name_job">
             <div class="name">Prem Shahi</div>
             <div class="job">Web designer</div>
           </div>
         </div>
         <i class='bx bx-log-out' id="log_out" ></i>
     </li> -->
    </ul>
  </div>
  <section class="home-section">
      <div class="container">
		      <% if(session.getAttribute("success")!=null)
		      			{
		      		%>
		      		<div class="alert alert-success" role="alert">
					  <%=session.getAttribute("success") %>
					 <% session.removeAttribute("success"); %>
					</div>
		      		<%} %>
     		 <h1 style="text-align:center; padding-top:40px;">Danh sach diem</h1>
      		<!-- <div style="padding:20px 0px">
      			<a class="btn btn-success" href="AddUser">Add User</a>
      		</div> -->
      		<div class="content">
      			<table class="table table-dark">
				  <thead>
				    <tr>
				      <th scope="col" style="text-align:center">id</th>
				      <th scope="col" style="text-align:center">ten mon hoc</th>
				      <th scope="col" style="text-align:center">so tin chi</th>
				      <th scope="col" style="text-align:center">diem chuyen can</th>
				      <th scope="col" style="text-align:center">diem giua ky</th>
				      <th scope="col" style="text-align:center">diem cuoi ky</th>
				      <th scope="col" style="text-align:center">diem tong ket</th>
				    </tr>
				  </thead>
				  <tbody>
				  <%
				  ArrayList<Score> listScore = (ArrayList<Score>)request.getAttribute("list_score");
				  int userId = (Integer)request.getAttribute("userId");
				  for(int i=0;i<listScore.size();i++){%>
				  	<tr>
				  		<th scope="row" style="text-align:center"><%=listScore.get(i).getId() %> </th>
				      	<td style="text-align:center"><%=listScore.get(i).getMon().getName()%></td>
				      	<td style="text-align:center"><%=listScore.get(i).getMon().getSotinchi()%></td>
				      	<td style="text-align:center"><%=listScore.get(i).getDiemcc()%></td>
				      	<td style="text-align:center"><%=listScore.get(i).getDiemgiuaky()%></td>
				      	<td style="text-align:center"><%=listScore.get(i).getDiemcuoiky()%></td>
				      	<td style="text-align:center"><%=listScore.get(i).getDiemtongket() %></td>
				     </tr>
				   <%} %>
				  </tbody>
				</table>      		
      		</div>

      		<form style="padding:20px 0px; text-align:right" method="post">
      			<input style="display:none" type="number" value="<%=userId%>"/>
      			<input class="btn btn-primary" type="submit" value="Luu"/>
      		</form>
      </div>
  </section>
  <script>
  let sidebar = document.querySelector(".sidebar");
  let closeBtn = document.querySelector("#btn");
  let searchBtn = document.querySelector(".bx-search");

  closeBtn.addEventListener("click", ()=>{
    sidebar.classList.toggle("open");
    menuBtnChange();//calling the function(optional)
  });

  searchBtn.addEventListener("click", ()=>{ // Sidebar open when you click on the search iocn
    sidebar.classList.toggle("open");
    menuBtnChange(); //calling the function(optional)
  });

  // following are the code to change sidebar button(optional)
  function menuBtnChange() {
   if(sidebar.classList.contains("open")){
     closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");//replacing the iocns class
   }else {
     closeBtn.classList.replace("bx-menu-alt-right","bx-menu");//replacing the iocns class
   }
  }
  </script>
</body>
</html>