//////// Project 1: Monster chasing the hero, who chases after the gold ////
//////// Teng Lin  (CST 112; 2015/10/14)



//// GLOBALS ////
float goldX, goldY;
float mX, mY;         //monster
float hX, hY;                  //hero position
float hDX, hDY;                //hero speed
float horizon;
float sunx=50, suny=50;        //sun
float moonx=50, moony=50;      //moon



//// SETUP: window size ////
void setup() {
  size (600,600);
  horizon = height/3;
  hX = width/2;
  hY = height/2;
  hDX = 1;
  hDY = 1;
  
}
//// NEXT FRAM ////
void draw() {
  scene();
  //hero();
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
  sunx = sunx+.125 ;                                             //sun move
  sunx %= width+(width/1); 
  
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
  rect(horizon, horizon-140, 30,80);  
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
