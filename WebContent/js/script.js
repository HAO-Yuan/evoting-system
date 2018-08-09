    function formCheck(){
       var pwd1 = document.getElementById("pwd1").value;
       var pwd2 = document.getElementById("pwd2").value;
       if(pwd1!=pwd2){
       alert("Please input same passwords");
       return false;
       }
       return true;
    }
