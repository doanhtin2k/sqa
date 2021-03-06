<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới User</title>
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
 <!--      <li>
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
     <!--  <li>
       <a href="ListClassRoom">
         <i class="fas fa-hospital-alt"></i>
         <span class="links_name">Manage ClassRoom</span>
       </a>
       <span class="tooltip">Manager ClassRoom</span>
     </li> -->
     
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
  <% 
  		
  String errorName = (String)request.getAttribute("name")!=null ? (String)request.getAttribute("name") : "";
  String errorMasv = (String)request.getAttribute("masv")!= null ? (String)request.getAttribute("masv") : "";	
  String errorKhoa = (String)request.getAttribute("khoa")!= null ? (String)request.getAttribute("khoa") : "";
  String errorPassword = (String)request.getAttribute("password")!= null ? (String)request.getAttribute("password") : "";
  String errorBirthday = (String)request.getAttribute("birthday")!= null ? (String)request.getAttribute("birthday") : "";
  String errorCountry = (String)request.getAttribute("country")!= null ? (String)request.getAttribute("country") : "";%>
  <section class="home-section">
      <div class="container" style="width:40%">
      <h1 style="text-align:center; padding-top:40px;">Them moi User</h1>
      		<form method="post">
			  <div class="form-group">
			    <label>Ten <span style="color:red">*</span></label>
			    <input type="text" class="form-control" placeholder="Enter Username" name ="name" autofocus>
			    <span style="color:red"><%= errorName %></span>
			  </div>
			  <div class="form-group">
			    <label>Ma sinh vien <span style="color:red">*</span></label>
			    <input type="text" class="form-control" placeholder="Enter MaSV" name ="masv">
			    <span style="color:red"><%= errorMasv %></span>
			  </div>
			  <div class="form-group">
				   <label>Khoa <span style="color:red">*</span></label>
				    <select name="khoa" class="form-control" >
				    	<option value="1">CNTT</option>
				    	<option value="2">ATTT</option>
				    	<option value="3">DTVT</option>
				    	<option value="4">DPT</option>
				    </select> 
				    <span style="color:red"><%= errorKhoa %></span>
			  </div>
			  <div class="form-group">
			    <label>Mat Khau <span style="color:red">*</span></label>
			    <input type="password" class="form-control" placeholder="Enter Password" name ="password">
			    <span style="color:red"><%= errorPassword %></span>
			  </div>
			  <div class="form-group">
			    <label>Ngay sinh <span style="color:red">*</span></label>
			    <input type="date" class="form-control" name ="birthday">
			    <span style="color:red"><%= errorBirthday %></span>
			  </div>
			  <div class="form-group">
			    <label>Que quan <span style="color:red">*</span></label>
			    <input type="text" class="form-control" placeholder="Enter Country" name ="country">
			    <span style="color:red"><%= errorCountry %></span>
			  </div>
			  <button type="submit" class="btn btn-primary">Luu</button>
			</form>
			<div style="padding:20px 0px">
					<a  href="ListUser">Quay ve danh sach user</a>
			</div>
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