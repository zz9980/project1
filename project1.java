//////// Project 1: Monster chasing the hero, who chases after the gold ////
//////// Teng Lin  (CST 112; 2015/10/14)



//// GLOBALS ////
float goldX, goldY;
float mX, mY;         //monster
float hX, hY;                  //hero position
float hDX, hDY;                //hero speed
float horizon;
float sunx=50, suny=50;        //sun
float cloud1x = horizon, cloud1y = horizon-160; 
float cloud2x = horizon-20, cloud2y = horizon-180, dxc=1.2;

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
  cloudmove();
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
  sunx = sunx+.75 ;                                             //sun move
  sunx %= width+(width/6); 
  
  if (sunx >= 620) {
    fill(0,0,255);
    rect(0, 0, 600, horizon);
    
  }
  
  // HOUSE //
  //ellipse(cloud1x, cloud1y, 50,30);                        //cloud
  //ellipse(cloud2x, cloud2y, 60,35);                        //cloud
  stroke(162,167,165);
  fill(162,167,165);
  rect(200,horizon-100, 200,150);  
  rect(horizon, horizon-140, 30,80);  
  triangle(180,horizon-100, 420,horizon-100, 300,horizon-180); //roof
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
 
 
 void cloudmove(){
     
  cloud1x = cloud1x - .125*dxc;
  cloud2x = cloud2x - .125*dxc;
  cloud1y = cloud1y - .125*dxc;
  cloud2y = cloud2y - .125*dxc;
  
  
 
  
  
}


