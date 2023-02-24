function Dps() {


  var x = document.getElementsByClassName('filter');
  for(var i=0;i<x.length;i++){
      if ( document.getElementById("flank").classList.contains('Active') ){
          Flank();}
      if ( document.getElementById("healer").classList.contains('Active') ){
          Healer();}
      if ( document.getElementById("tank").classList.contains('Active') ){
          Tank();}
              
  
  if ( document.getElementById("dps").classList.contains('button') ){
      
  document.getElementById("dps").classList.add('Active');
  document.getElementById("dps").classList.remove('button');
  }
  else{
      document.getElementById("dps").classList.add('button');
      document.getElementById("dps").classList.remove('Active');
  }
}



    var x = document.getElementsByClassName('container');
    for(var i=0;i<x.length;i++){
      if (x[i].style.display === 'none') {
        x[i].style.display = 'block';
      }
     else if (x[i].classList.contains('dps')) {
      x[i].style.display = 'block';
    } else {
      x[i].style.display = 'none';
    }}
  }