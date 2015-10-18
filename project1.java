//////// Project 1: Monster chasing the hero, who chases after the gold ////
//////// Teng Lin  (CST 112; 2015/10/14)

String author=  "Teng Lin";
String title=  " Monster Chasing HERO ";
String help=  " Click RESET to reset everything to starting positions. (deduct 50 points) ";
String quit= " Press q to quit";

//// GLOBALS ////
float goldx, goldy;
float mx, my;                  //monster
float hx, hy;                  //hero position
float hdx, hdy;                //hero speed
float horizon;
float sunx=50, suny=50;        //sun
float moonx=50, moony=50;      //moon
float gx=200, gy=400;          //gold
int score;


//// SETUP: window size ////
void setup() {
  size (600,600);
  horizon = height/3;
  hx = width/2;
  hy = height/2;
  mx=60;
  my=300;
  hdx = 1;
  hdy = 1;
  reset();
  reset1();
}

//// NEXT FRAM ////
void draw() {
  scene();
  button();
  hero();
  gold();
  monster();
  score();
  messages();
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

void button(){
  fill(255,0,0);
  rect(50,100, 80,40);
  fill(0);
  text("RESET", 70,125);

}


void mouseClicked() {
 if ( mouseX >= 50 && mouseX <= 130 && mouseY >=100 && mouseY <=140 ) {
  reset();
  score -= 50;
    }
}

void reset() {
  
  gx= random(200,400);
  gy= random(300,550);
  hx=300;
  hy=150;
  mx=50;
  my=250;
}

void reset1() {
  
  gx= random(200,400);
  gy= random(300,550);
  hx=600;
  hy=150;
  mx=50;
  my=250; 

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
  fill( 111,133,234);
  rect( hx-30, hy+35 , 60,70);                         //body
  fill(0);
  textSize(15);
  text( "HERO", hx-15, hy+75);
  /*rect(lshoulderx, lshouldery, 10,45);               //arm
  rect(rshoulderx, rshouldery, 10,45);
  rect( lshoex, lshoey, 20,10);                        //leg
  rect( rshoex, rshoey, 20,10);
  ellipse(hx-10, hy, 10, 10);                          //eye
  ellipse(hx+10, hy, 10, 10);  
  */
  
  //moving arms, legs, eyes, mouth//
  int k= frameCount/30%2;
  if (k==0) {
    fill(205,205,211);
    rect(lshoulderx, lshouldery, 10,45);             //left arm
    rect(rshoulderx, rshouldery, 10,45);             //right arm
    fill( 111,133,234);
    rect( lshoex, lshoey, 20,10);                    //left shoe
    rect( rshoex, rshoey, 20,10);                    //right shoe
    fill(255);
    ellipse(hx-10, hy, 10, 10);                      //left eye
    ellipse(hx+10, hy, 10, 10);                      //right eye
    rect( hx-10, hy+12, 20,2);                       //mouth
  }
  else {
    fill(205,205,211);
    rect(lshoulderx-30, lshouldery, 40,10);
    rect(rshoulderx, rshouldery, 40,10);
    fill( 111,133,234);
    rect( lshoex+10, lshoey, 20,10);
    rect( rshoex+10, rshoey, 20,10);
    fill(255);
    ellipse(hx-10, hy, 12, 12);                 
    ellipse(hx+10, hy, 12, 12);
    rect( hx-10, hy+12, 20,8);                
  }
  ////moving hero to chase after the gold////
  
  hx = hx + hdx;
  hy = hy + hdy;
  hx= hx + ( gx - (hx) ) / 60 ; 
  hy= hy + ( gy - (hy) ) / 60 ;
  
  if ( hx > width-50 || hx < 50 ) {
    hdx *= -1;
    
  }
  
  if ( hy > height-150 || hy < horizon-50) {
    hdy *= -1;
    
  }
  
}

void gold( ) {
  
  fill(255,255,0);
  rect( gx, gy, 10,20);
  if ( dist( hx,hy, gx,gy ) < 70 ) {
  gx= random(200,400);
  gy= random(300,550);
  }
}




void monster() {
  
  fill(111,84,31,30);                    //ghost
  ellipse(mx, my, 80,60);                //head
  ellipse(mx, my, 60,80);                //head
  ellipse(mx-10, my , 10,10);            //left eye
  ellipse(mx+10, my , 20, 20);           //right eye
  rect( mx-10, my+20, 20,5);             //mouth
  
  // Monster chases hero //
  mx +=  (hx-mx) / 120;
  my +=  (hy-my) / 120;
  
  // Monster catches hero!
  if ( dist( hx,hy, mx,my ) < 50 )  {
      score -= 100;
      reset();  
   } 
  
  if ( dist( hx,hy, gx,gy ) < 75 )  {
      score +=100;
      reset1();
  }
  
}

void score() {
  
  fill(0);
  textSize(10);
  text("SCORE", 550, 20);
  text(score, 550, 50);

}

void messages() {
  
  fill(0);
  text( title, 250, 20 );
  text( author, 550,height-15 );
  text( help, 10, height-50 );
  text( quit, 10, height-30 );
}

void keyPressed() {
  if (key == 'q') {
    exit();                           // press 'q' key to QUIT.
  }
  
}
