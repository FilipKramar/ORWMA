function Flank() {


  var x = document.getElementsByClassName('filter');
  for(var i=0;i<x.length;i++){
      if ( document.getElementById("healer").classList.contains('Active') ){
          Healer();}
      if ( document.getElementById("dps").classList.contains('Active') ){
          Dps();}
      if ( document.getElementById("tank").classList.contains('Active') ){
          Tank();}
              
  
  if ( document.getElementById("flank").classList.contains('button') ){
      
  document.getElementById("flank").classList.add('Active');
  document.getElementById("flank").classList.remove('button');
  }
  else{
      document.getElementById("flank").classList.add('button');
      document.getElementById("flank").classList.remove('Active');
  }
}



    var x = document.getElementsByClassName('container');
    for(var i=0;i<x.length;i++){
      if (x[i].style.display === 'none') {
        x[i].style.display = 'block';
      }
     else if (x[i].classList.contains('flank')) {
      x[i].style.display = 'block';
    } else {
      x[i].style.display = 'none';
    }}
  }