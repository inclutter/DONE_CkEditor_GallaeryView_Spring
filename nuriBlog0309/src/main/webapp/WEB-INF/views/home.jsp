<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" />
<title>Example</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.js"></script>
</head>
<style>
/* Space out content a bit */
body {
	padding-top: 20px;
	padding-bottom: 20px;
}
/* Everything but the jumbotron gets side spacing for mobile first views */
.header, .marketing, .footer {
	padding-right: 15px;
	padding-left: 15px;
}
/* Custom page header */
.header {
	padding-bottom: 20px;
	border-bottom: 1px solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
	margin-top: 0;
	margin-bottom: 0;
	line-height: 40px;
}
/* Custom page footer */
.footer {
	padding-top: 19px;
	color: #777;
	border-top: 1px solid #e5e5e5;
}
/* Customize container */
@media ( min-width : 768px) {
	.container {
		max-width: 900px;
	}
}

.container-narrow>hr {
	margin: 30px 0;
}
/* Main marketing message and sign up button */
.jumbotron {
	text-align: center;
	border-bottom: 1px solid #e5e5e5;
}

.jumbotron .btn {
	padding: 14px 24px;
	font-size: 21px;
}
/* Supporting marketing content */
.marketing {
	margin: 40px 0;
}

.marketing p+h4 {
	margin-top: 28px;
}
/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
	/* Remove the padding we set earlier */
	.header, .marketing, .footer {
		padding-right: 0;
		padding-left: 0;
	}
	/* Space out the masthead */
	.header {
		margin-bottom: 30px;
	}
	/* Remove the bottom border on the jumbotron for visual effect */
	.jumbotron {
		border-bottom: 0;
	}
}
</style>
<body>

<form method="post">
  <textarea id="summernote" name="editordata"></textarea>
  	<div class="form-group">
			<label for="board_content">내용</label>
			<textarea name="BOARD_CONTENT" id="board_content"></textarea>
	</div> 
</form>

	<!-- /container -->
<script type="text/javascript">
function sendFile(file, el) {
	var form_data = new FormData();
	form_data.append('file', file);
	$.ajax({
		data: form_data,
		type : "post",
		url: 'summer_image',
		cache :false,
		contentType : false,
		enctype : 'multipart/form-data',
		processData : false,
		success : function(img_name) {
			alert("접속2")
			$(el).summernote('editor.insertImage', img_name);
		}
	});
}
$(function() {
	$('#board_content').summernote({
		 	placeholder: '최대 500자 작성 가능합니다.',
	        height: 300,
	        lang: 'ko-KR',
	        callbacks: {
	        	onImageUpload: function(files, editor, welEditable) {
	        		for(var i = files.length -1; i>=0; i--) {
	        			alert("접속1")
	        			sendFile(files[i], this);
	        		}
	        	}
	        }
	 });
});
</script>
</body>
</html>
