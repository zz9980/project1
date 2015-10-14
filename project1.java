//////// Project 1: Monster chasing the hero, who chases after the gold ////
//////// Teng Lin  (CST 112; 2015/10/14)



//// GLOBALS ////
float goldx, goldy;
float mx, my;         //monster
float hx, hy;                  //hero position
float hdx, hdy;                //hero speed
float horizon;
float sunx=50, suny=50;        //sun
float moonx=50, moony=50;      //moon



//// SETUP: window size ////
void setup() {
  size (600,600);
  horizon = height/3;
  hx = width/2;
  hy = height/2;
  hdx = 1;
  hdy = 1;
  
}
//// NEXT FRAM ////
void draw() {
  scene();
  hero();
  //monster();
  //gold();
  
}

void scene() {
  
  background(104,186,240);
  fill (0,240,0);
  stroke(0,240,0);
  rect(0,horizon,600,600);
  noStroke();
 
  // SUN //
  fill(255,255,0);
  ellipse(sunx,suny, 50,50);
  sunx = sunx+.125 ;                                           //sun move
  sunx %= width+(width/1);                                     //sun come back
  
  if (sunx >= width) {
  fill(0,0,255);
  rect(0, 0, 600, horizon);
  fill(17,124,54);
  rect(0, horizon, 600,600);
  fill(255,255,0);
  ellipse(moonx, moony, 50,50);
  fill(0,0,255);
  ellipse(moonx-20, moony, 60,60);
  moonx = moonx + .125;
  moonx %= width+(width/10);
  }
  // HOUSE //
  stroke(162,167,165);
  fill(162,167,165);
  rect(200,horizon-100, 200,150);  
  rect(horizon, horizon-140, 30,80);                           //door
  triangle(180,horizon-100, 420,horizon-100, 300,horizon-180); //roof
  
  // cloud //
  stroke(255);
  fill(255);
  ellipse(200, 35, 50,30);
  ellipse(180, 20, 60,35);
  noStroke();
  fill(188,110,80);
  rect(275, horizon-40, 50, horizon-110);
  fill(255,255,0);
  ellipse(290, horizon, 15,15);
  
}

void hero() {
  
  float lhipx=hx-30,lhipy=hy+105;                      //left leg
  float rhipx=hx+20,rhipy=hy+105;                      //right leg
  float lshoulderx=lhipx-10, lshouldery=hy+35;         //left arm
  float rshoulderx=rhipx+10, rshouldery=hy+35;         //right arm
  float lshoex=lhipx-10, lshoey=lhipy+35;              //left shoe
  float rshoex=rhipx-10, rshoey=rhipy+35;              //right shoe
 
  fill(205,205,211);
  ellipse( hx, hy, 50,50);
  rect( hx-5, hy+25, 10,10);
  rect(lhipx, lhipy, 10,35);
  rect(rhipx, rhipy, 10,35);
  
  //rect(lshoulderx, lshouldery, 10,45);
  //rect(rshoulderx, rshouldery, 10,45);
  fill( 111,133,234);
  rect( hx-30, hy+35 , 60,70);                         //body
  //rect( lshoex, lshoey, 20,10);
  //rect( rshoex, rshoey, 20,10);
  
  //moving arms and legs
  int k= frameCount/30%2;
  if (k==0) {
    fill(205,205,211);
    rect(lshoulderx, lshouldery, 10,45);
    rect(rshoulderx, rshouldery, 10,45);
    fill( 111,133,234);
    rect( lshoex, lshoey, 20,10);
    rect( rshoex, rshoey, 20,10);
  }
  else {
    fill(205,205,211);
    rect(lshoulderx-30, lshouldery, 40,10);
    rect(rshoulderx, rshouldery, 40,10);
    fill( 111,133,234);
    rect( lshoex+10, lshoey, 20,10);
    rect( rshoex+10, rshoey, 20,10);
      
  }
  
  hx = hx + hdx;
  hy = hy + hdy;
  
  
  if ( hx > width-50 || hx < 50 ) {
    hdx *= -1;
    
  }
  
  if ( hy > height-150 || hy < horizon-50) {
    hdy *= -1;
    
  }
  
  
}
