<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Title</title>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="resources/ckfinder/ckfinder.js"></script>
<script src="/resources/components/ckeditor/ckeditor.js"></script>
<script>
	var editorConfig = {
		filebrowserUploadUrl : "/community/imageUpload", //이미지 업로드
	};

	CKEDITOR.on('dialogDefinition', function(ev) {
		var dialogName = ev.data.name;
		var dialogDefinition = ev.data.definition;

		switch (dialogName) {
		case 'image': //Image Properties dialog
			//dialogDefinition.removeContents('info');
			dialogDefinition.removeContents('Link');
			dialogDefinition.removeContents('advanced');
			break;
		}
	});
	window.onload = function() {
		ck = CKEDITOR.replace("editor", editorConfig);
	};
</script>
</head>
<body>
	<form class="form-horizontal" role="form" id="editorForm" method="post"
		action="insert.do">
		<table border="1" width="500" >
			<tr><td width="80">제목</td><td><input type="text" name="subject" style="width:420px"></td></tr>
		</table>
		<div class="form-group">
			<div class="form-group">
				<div class="col-lg-12">
					<textarea name="image_name" id="editor"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-12" align="right">
					<button type="submit" class="btn btn-default">저장</button>
				</div>
			</div>
		</div>
	</form>

</body>
</html>