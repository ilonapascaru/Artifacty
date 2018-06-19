function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
};


function ModifyTextForm(){
	document.getElementById("categoriaDestroy").setAttribute("contenteditable","true");
	document.getElementById("tipDestroy").setAttribute("contenteditable","true");
	document.getElementById("secolDestroy").setAttribute("contenteditable","true");
};

function Save(){
		document.getElementById("categoriaDestroy").setAttribute("contenteditable","false");
	document.getElementById("tipDestroy").setAttribute("contenteditable","false");
	document.getElementById("secolDestroy").setAttribute("contenteditable","false");
}
