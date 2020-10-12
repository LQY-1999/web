function changeCode(){
    var codeImg = document.getElementById("verifyCode");
    codeImg.src="servlet/CreateVerfifyCodeImage?t="+Math.random();
}