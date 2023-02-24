function Healer() {
    var x = document.getElementsByClassName('filter');
    for(var i=0;i<x.length;i++){
        if ( document.getElementById("flank").classList.contains('Active') ){
            Flank();}
        if ( document.getElementById("dps").classList.contains('Active') ){
            Dps();}
        if ( document.getElementById("tank").classList.contains('Active') ){
            Tank();}
                
    
    if ( document.getElementById("healer").classList.contains('button') ){
        
    document.getElementById("healer").classList.add('Active');
    document.getElementById("healer").classList.remove('button');
    }
    else{
        document.getElementById("healer").classList.add('button');
        document.getElementById("healer").classList.remove('Active');
    }
}


    var x = document.getElementsByClassName('container');
    for(var i=0;i<x.length;i++){
      if (x[i].style.display === 'none') {
        x[i].style.display = 'block';
      }
     else if (x[i].classList.contains('healer')) {
      x[i].style.display = 'block';
    } else {
      x[i].style.display = 'none';
    }}
}