public class RajaMantriChorSipahi extends Activity {

  @Override
  protected void onPostResume() {
    super.onPostResume();
  }

  @Override
  public boolean onKeyDown(int key_code, KeyEvent event) {
    AlertDialog dialog = new AlertDialog.Builder(this).create();
    dialog.setTitle("Exit game!");
    dialog.setMessage("Are you sure you want to exit the game?");

    dialog.setButton("Exit", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int close_button) {
        finish();
      }
    });

    dialog.setButton("Cancel", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int close_button) {
        dialog.dismiss();
      }
    });
	
    dialog.show();
    return super.onKeyDown(key_code, event);
  }

  @Override
  public void onLowMemory() {
    AlertDialog dialog = new AlertDialog.Builder(this).create();
    dialog.setTitle("Low memory!");
    dialog.setMessage("Too many apps open, kindly close some other apps and try again!");

    dialog.setButton("Exit", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int close_button) {	
        finish();
      }
    });	

    dialog.show();
    super.onLowMemory();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  String[] solution_array = {"RAJA", "MANTRI", "CHOR", "SIPAHI"};
  String[] players_array = {"Player1", "Player2", "Player3", "Player4"};

  static String player1 = "";
  static String player2 = "";
  static String player3 = "";
  static String player4 = "";
  static String player1_name = "" ;
  static String player2_name = "";
  static String player3_name = "";
  static String player4_name = "";
  static String player1_role = "";
  static String player2_role = "";
  static String player3_role = "";
  static String player4_role = "";

  static boolean guess = false;

  static int i=0,j=0,k=0,l=0;

  static int p1_score = 0;
  static int p2_score = 0;
  static int p3_score = 0;
  static int p4_score = 0;

  int count = 0;

  Button btn_raja_mantri;
  Button btn_help;
  Button btn_play;
  Button btn_signin;

  static Button btn_pod1;
  static Button btn_pod2;
  static Button btn_pod3;
  static Button btn_pod4;

  EditText edit_txt_player1;
  EditText edit_txt_player2;
  EditText edit_txt_player3;
  EditText edit_txt_player4;

  TextView lbl_player1;
  TextView lbl_player2;
  TextView lbl_player3;
  TextView lbl_player4;

  static TextView txt_turn;
  static TextView txt_player1;
  static TextView txt_player2;
  static TextView txt_player3;
  static TextView txt_player4;

  Bundle savedInstanceState;
  Button btn_main_menu;

  String next_turn = "";
	
    public void onRestart(){
    	
    	super.onRestart();
    /*	player1_name = "" ;
    	player2_name = "";
    	player3_name = "";
    	player4_name = "";
    	guess = false;
    	player1 = "";
    	player2 = "";
    	player3 = "";
    	player4 = "";
    	i=0;j=0;k=0;l=0;
    	p1_score = 0;
    	p2_score = 0;
    	p3_score = 0;
    	p4_score = 0;*/
    	
    	
    }
    
    public void onResume(){
    	
    	super.onResume();
    	/*player1_name = "" ;
    	player2_name = "";
    	player3_name = "";
    	player4_name = "";
    	guess = false;
    	player1 = "";
    	player2 = "";
    	player3 = "";
    	player4 = "";
    	i=0;j=0;k=0;l=0;
    	p1_score = 0;
    	p2_score = 0;
    	p3_score = 0;
    	p4_score = 0;*/
    	
    	
    }




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
      
        i = 0;
        j = 0;
        k = 0;
        l = 0;
        btn_help = (Button)findViewById(R.id.btn_help);
        btn_help.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				setContentView(R.layout.help);
				 // Create the adView
			    AdView adView = new AdView(RajaMantri.this, AdSize.BANNER, "a14e156523d01de");
			    // Lookup your LinearLayout assuming it’s been given
			    // the attribute android:id="@+id/mainLayout"
			    LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayoutHelp);
			    // Add the adView to it
			    layout.addView(adView);
			    // Initiate a generic request to load it with an ad
			    adView.loadAd(new AdRequest());
				TextView txtHelp = (TextView)findViewById(R.id.txtHelp);
				String text = "Welcome to nostalgia! This is the paper free version of Raja Mantri Chor Sipahi.\n\nThe game involves bluffing with facial expressions and good guessing. This is a very popular childhood game in India played among kids often during their long summer vacations.\n\nThe game has 4 paper chits with Chor (thief), Sipahi (police), Raja (king) and Mantri (minister). The chits are folded at the start of the game and one of the 4 players will press SHUFFLE each one of the four players is supposed to secretly (by taking the phone and not letting the others see it)pick one chit by clicking on it, the player then clicks on the chit again to fold it back. All the players will then secretly open their chits and read what they have got. \n\nThe player who gets the chit with Raja written on it will say MERA MANTRI KAUN? (Who is my minister?). The player who got the chit with Mantri will say MEIN! (Me), The player with Raja will then say CHOR SIPAHI KA PATA LAGAO (find out who is the theif and who is the soldier). The player with Mantri will then guess who is the Chor (Thief), if he is wrong then his points are deducted and if he is correct he gets more points and the points from the player who got Chor (Thief) are deducted.\n\nIf the guess is correct the player with Chor is wrapped on his wrist by the Mantri, and if the Mantri is wrong then the Chor gets to hit his wrist.";
				txtHelp.setText(text);
				Button btnBack = (Button)findViewById(R.id.btn_main_menuHelp);
				btnBack.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						
						Intent i = new Intent(RajaMantri.this, RajaMantri.class);
						RajaMantri.this.startActivity(i);
						finish();
						
					}
				});
			}
		});
        btn_raja_mantri = (Button) findViewById(R.id.btn_raja_mantri);
        btn_raja_mantri.setOnClickListener(new OnClickListener() {
        	
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 		setContentView(R.layout.rmcsp);	
 		 // Create the adView
	    AdView adView = new AdView(RajaMantri.this, AdSize.BANNER, "a14e156523d01de");
	    // Lookup your LinearLayout assuming it’s been given
	    // the attribute android:id="@+id/mainLayout"
	    LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayoutPlayer);
	    // Add the adView to it
	    layout.addView(adView);
	    // Initiate a generic request to load it with an ad
	    adView.loadAd(new AdRequest());
	    
 		edit_txt_player1 = (EditText) findViewById(R.id.edit_txt_player1);
 		edit_txt_player2 = (EditText)findViewById(R.id.edit_txt_player2);
 		edit_txt_player3 = (EditText)findViewById(R.id.edit_txt_player3);
 		edit_txt_player4 = (EditText)findViewById(R.id.edit_txt_player4);
 		
 		lbl_player1 = (TextView) findViewById(R.id.lbl_player1);
 		lbl_player2 = (TextView) findViewById(R.id.lbl_player2);
 		lbl_player3 = (TextView) findViewById(R.id.lbl_player3);
 		lbl_player4 = (TextView) findViewById(R.id.lbl_player4);
 		
 		Display display = getWindowManager().getDefaultDisplay(); 
 		int width = display.getWidth();
 		int height = display.getHeight();
 		
 		
 		
 		lbl_player1.setGravity(Gravity.CENTER_HORIZONTAL);
 		lbl_player2.setGravity(Gravity.CENTER_HORIZONTAL);
 		lbl_player3.setGravity(Gravity.CENTER_HORIZONTAL);
 		lbl_player4.setGravity(Gravity.CENTER_HORIZONTAL);
 		
 		
 		Log.v("AkandBakar", "Playernames:" + player1_name);
 		Log.v("AkandBakar", "Playernames:" + player2_name);
 		Log.v("AkandBakar", "Playernames:" + player3_name);
 		Log.v("AkandBakar", "Playernames:" + player4_name);
 		
 		btn_main_menu = (Button) findViewById(R.id.btn_main_menu);
 		btn_main_menu.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				Intent i = new Intent(RajaMantri.this, RajaMantri.class);
				RajaMantri.this.startActivity(i);
				finish();
				
			}
		});
 		
 		btn_signin = (Button) findViewById(R.id.btn_signin);
 		btn_signin.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				player1_name = edit_txt_player1.getText().toString();
		 		player2_name = edit_txt_player2.getText().toString();
		 		player3_name = edit_txt_player3.getText().toString();
		 		player4_name = edit_txt_player4.getText().toString();
		 		
		 		
				if(player1_name.equals("")||player2_name.equals("")||player3_name.equals("")||player4_name.equals("")){
					
					Toast toast = Toast.makeText(getBaseContext(), "Enter player names!", 8000);
					toast.show();
					
				}else{
					setContentView(R.layout.rmcsgnew);	
					 // Create the adView
				    AdView adView = new AdView(RajaMantri.this, AdSize.BANNER, "a14e156523d01de");
				    // Lookup your LinearLayout assuming it’s been given
				    // the attribute android:id="@+id/mainLayout"
				    LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayout);
				    // Add the adView to it
				    layout.addView(adView);
				    // Initiate a generic request to load it with an ad
				    adView.loadAd(new AdRequest());

					txt_turn = (TextView)findViewById(R.id.txt_turn);
					txt_turn.setText("Click on SHUFFLE!");
					players_array[0] = player1_name;
			 		players_array[1] = player2_name;
			 		players_array[2] = player3_name;
			 		players_array[3] = player4_name;
			 		
			 		
			 		
					txt_player1 = (TextView) findViewById(R.id.txt_player1);
					txt_player1.setText("1."+player1_name + " [" + p1_score + "]");
					
					txt_player2 = (TextView) findViewById(R.id.txt_player2);
					txt_player2.setText("2."+player2_name+ " [" + p2_score + "]");
					
					txt_player3 = (TextView) findViewById(R.id.txt_player3);
					txt_player3.setText("3."+player3_name+ " [" + p3_score + "]");
					
					txt_player4 = (TextView) findViewById(R.id.txt_player4);
					txt_player4.setText("4."+player4_name+ " [" + p4_score + "]");
					
				btn_play = (Button) findViewById(R.id.btn_play);
				
				btn_play.setOnClickListener(new OnClickListener() {
		 			
		 			public void onClick(View v) {
		 				// TODO Auto-generated method stub
		 				
		 				if(btn_play.getText().equals("SHUFFLE")){
		 				
		 					RajaMantri.this.shuffle();
		 					
		 				}else{
		 					
		 					
		 					RajaMantri.this.makeGuess();
										
		 					Log.v("RajaMantri", "########## Player Name:" + player1_name +" Role:" + player1_role);
		 					Log.v("RajaMantri", "########## Player Name:" + player2_name +" Role:" + player2_role);
		 					Log.v("RajaMantri", "########## Player Name:" + player3_name +" Role:" + player3_role);
		 					Log.v("RajaMantri", "########## Player Name:" + player4_name +" Role:" + player4_role);
						}
						
		 				
		 			}
		 		});
		         
		         
		         
				}
		         
		     }
		     
		 	});
			}

		
		});
 		 
       
    }
    
    
    public void makeGuess(){
    	
    	btn_play.setText("SHUFFLE");
			count = 0;
			btn_play.setText("SHUFFLE");
			
			btn_pod1.setClickable(true);
			btn_pod2.setClickable(true);
			btn_pod3.setClickable(true);
			btn_pod4.setClickable(true);
			
		if(player1.equals("RAJA")){
			
			btn_pod1.setText("RAJA");
			btn_pod1.setBackgroundResource(R.drawable.podopen);
			btn_pod1.setClickable(false);
		}
		if(player2.equals("RAJA")){
			
			btn_pod2.setText("RAJA");
			btn_pod2.setBackgroundResource(R.drawable.podopen);
			btn_pod2.setClickable(false);
		}
		if(player3.equals("RAJA")){

			btn_pod3.setText("RAJA");
			btn_pod3.setBackgroundResource(R.drawable.podopen);
			btn_pod3.setClickable(false);
		}
		if(player4.equals("RAJA")){

			btn_pod4.setText("RAJA");
			btn_pod4.setBackgroundResource(R.drawable.podopen);
			btn_pod4.setClickable(false);
		}

		if(player1.equals("MANTRI")){
			
			btn_pod1.setText("MANTRI");
			btn_pod1.setBackgroundResource(R.drawable.podopen);
			btn_pod1.setClickable(false);
		}
		if(player2.equals("MANTRI")){
			
			btn_pod2.setText("MANTRI");
			btn_pod2.setBackgroundResource(R.drawable.podopen);
			btn_pod2.setClickable(false);
		}
		if(player3.equals("MANTRI")){

			btn_pod3.setText("MANTRI");
			btn_pod3.setBackgroundResource(R.drawable.podopen);
			btn_pod3.setClickable(false);
		}
		if(player4.equals("MANTRI")){

			btn_pod4.setText("MANTRI");
			btn_pod4.setBackgroundResource(R.drawable.podopen);
			btn_pod4.setClickable(false);
			
		}
		
		if(player1_role.equals("MANTRI")){
			txt_turn.setText(player1_name + " will find the CHOR!");
		}
		if(player2_role.equals("MANTRI")){
			txt_turn.setText(player2_name + " will find the CHOR!");
		}
		if(player3_role.equals("MANTRI")){
			txt_turn.setText(player3_name + " will find the CHOR!");
		}
		if(player4_role.equals("MANTRI")){
			txt_turn.setText(player4_name + " will find the CHOR!");
		}
		
		Log.v("AkhandBakar","#########" + btn_pod1.getText());
		
		if(btn_pod1.getText().equals("")){
			
			btn_pod1.setOnClickListener(new OnClickListener() {
				
			
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.v("AkhandBakar","#########" + player1);
					if(player1.equals("CHOR")){
					
						RajaMantri.guess = true;
						btn_pod1.setBackgroundResource(R.drawable.podopen);
						btn_pod1.setText("CHOR");
						
					}else{
						
						RajaMantri.guess = false;
						btn_pod1.setBackgroundResource(R.drawable.podopen);
						btn_pod1.setText("SIPAHI");
					}
					btn_pod1.setClickable(false);
					btn_pod2.setClickable(false);
					btn_pod3.setClickable(false);
					btn_pod4.setClickable(false);
					updateScore();
				}
			});
		}	
		
		
		Log.v("AkhandBakar","#########" + btn_pod2.getText());
		if(btn_pod2.getText().equals("")){
			
			btn_pod2.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.v("AkhandBakar","#########" + player2);
					if(player2.equals("CHOR")){
					
						RajaMantri.guess = true;
						btn_pod2.setBackgroundResource(R.drawable.podopen);
						btn_pod2.setText("CHOR");
					}else{
						
						RajaMantri.guess = false;
						btn_pod2.setBackgroundResource(R.drawable.podopen);
						btn_pod2.setText("SIPAHI");
						
					}
					btn_pod1.setClickable(false);
					btn_pod2.setClickable(false);
					btn_pod3.setClickable(false);
					btn_pod4.setClickable(false);
					updateScore();
				}
			});
		}	
    	
		Log.v("AkhandBakar","#########" + btn_pod3.getText());
		if(btn_pod3.getText().equals("")){
			
			btn_pod3.setOnClickListener(new OnClickListener() {
				
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.v("AkhandBakar","#########" + player3);
					if(player3.equals("CHOR")){
					
						RajaMantri.guess = true;
						btn_pod3.setBackgroundResource(R.drawable.podopen);
						btn_pod3.setText("CHOR");
					}else{
						
						RajaMantri.guess = false;
						btn_pod3.setBackgroundResource(R.drawable.podopen);
						btn_pod3.setText("SIPAHI");
						
					}
					btn_pod1.setClickable(false);
					btn_pod2.setClickable(false);
					btn_pod3.setClickable(false);
					btn_pod4.setClickable(false);
					updateScore();
				}
			});
		}
    	
		
		Log.v("AkhandBakar","#########" + btn_pod4.getText());
		if(btn_pod4.getText().equals("")){
			
			btn_pod4.setOnClickListener(new OnClickListener() {
				
			
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.v("AkhandBakar","#########" + player4);
					if(player4.equals("CHOR")){
					
						RajaMantri.guess = true;
						btn_pod4.setBackgroundResource(R.drawable.podopen);
						btn_pod4.setText("CHOR");
					}else{
						
						RajaMantri.guess = false;
						btn_pod4.setBackgroundResource(R.drawable.podopen);
						btn_pod4.setText("SIPAHI");
						
					}
					btn_pod1.setClickable(false);
					btn_pod2.setClickable(false);
					btn_pod3.setClickable(false);
					btn_pod4.setClickable(false);
					updateScore();
				}
			});
		}
		
    }
    
    
    public void shuffle(){
    	
    	btn_play.setText("Guess");
			btn_play.setClickable(false);
			shuffleArray(solution_array);
			txt_turn.setText(player1_name + "'s" + " turn!");
			next_turn = player2_name;
			btn_pod1 = (Button)findViewById(R.id.btn_pod1);
			btn_pod1.setBackgroundResource(R.drawable.podtlclosed);
			btn_pod1.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					player1 = solution_array[0];
					btn_pod1.setText(player1);
					btn_pod1.setBackgroundResource(R.drawable.podopen);
					btn_pod2.setClickable(false);
					btn_pod3.setClickable(false);
					btn_pod4.setClickable(false);
					if(txt_turn.getText().equals(player1_name + "'s" + " turn!")){
						
						if(player1.equals("MANTRI")){
							
							player1_role = "MANTRI";
						}
						if(player1.equals("RAJA")){
							
							player1_role = "RAJA";
						}
						if(player1.equals("SIPAHI")){

							player1_role = "SIPAHI";
						}
						if(player1.equals("CHOR")){
							
							player1_role = "CHOR";
						}
				    	

						next_turn = player2_name + "'s" + " turn!";
						
					}
					if(txt_turn.getText().equals(player2_name + "'s" + " turn!")){
						
						if(player1.equals("MANTRI")){
							
							player2_role = "MANTRI";
						}
						if(player1.equals("RAJA")){
							
							player2_role = "RAJA";
						}
						if(player1.equals("SIPAHI")){

							player2_role = "SIPAHI";
						}
						if(player1.equals("CHOR")){
							
							player2_role = "CHOR";
						}
				    	
						next_turn = player3_name + "'s" + " turn!";
						
					}
					if(txt_turn.getText().equals(player3_name + "'s" + " turn!")){
						
						if(player1.equals("MANTRI")){
							
							player3_role = "MANTRI";
						}
						if(player1.equals("RAJA")){
							
							player3_role = "RAJA";
						}
						if(player1.equals("SIPAHI")){

							player3_role = "SIPAHI";
						}
						if(player1.equals("CHOR")){
							
							player3_role = "CHOR";
						}
				    	
						next_turn = player4_name + "'s" + " turn!";
						
					}
					
					if(txt_turn.getText().equals(player4_name + "'s" + " turn!")){
						
						if(player1.equals("MANTRI")){
							
							player4_role = "MANTRI";
						}
						if(player1.equals("RAJA")){
							
							player4_role = "RAJA";
						}
						if(player1.equals("SIPAHI")){

							player4_role = "SIPAHI";
						}
						if(player1.equals("CHOR")){
							
							player4_role = "CHOR";
						}
				    	
						
						next_turn = "Click on Guess!";
						
					}
					
					txt_turn.setText("Click again to close the chit!");
				
					
					
					btn_pod1.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							// TODO Auto-generated method stub
							btn_pod1.setClickable(false);
							count++;
							btn_pod1.setText("");
							btn_pod1.setBackgroundResource(R.drawable.podtlhalf);
							txt_turn.setText(next_turn);
							btn_pod2.setClickable(true);
							btn_pod3.setClickable(true);
							btn_pod4.setClickable(true);
							if(count == 4){
								
								txt_turn.setText("Click on Guess!");
								btn_play.setClickable(true);
								count = 0;
								
							}
						}
					});
				}
			});
			
			btn_pod2 = (Button)findViewById(R.id.btn_pod2);
			btn_pod2.setBackgroundResource(R.drawable.podtrclosed);
			btn_pod2.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						player2 = solution_array[1];
						btn_pod2.setText(player2);
						btn_pod2.setBackgroundResource(R.drawable.podopen);
						btn_pod1.setClickable(false);
						btn_pod3.setClickable(false);
						btn_pod4.setClickable(false);
						if(txt_turn.getText().equals(player1_name + "'s" + " turn!")){
							
							if(player2.equals("MANTRI")){
								
								player1_role = "MANTRI";
							}
							if(player2.equals("RAJA")){
								
								player1_role = "RAJA";
							}
							if(player2.equals("SIPAHI")){

								player1_role = "SIPAHI";
							}
							if(player2.equals("CHOR")){
								
								player1_role = "CHOR";
							}
					    	
							next_turn = player2_name+ "'s" + " turn!";
							
						}
						if(txt_turn.getText().equals(player2_name + "'s" + " turn!")){
							
							if(player2.equals("MANTRI")){
								
								player2_role = "MANTRI";
							}
							if(player2.equals("RAJA")){
								
								player2_role = "RAJA";
							}
							if(player2.equals("SIPAHI")){

								player2_role = "SIPAHI";
							}
							if(player2.equals("CHOR")){
								
								player2_role = "CHOR";
							}
					    	
							next_turn = player3_name+ "'s" + " turn!";
							
						}
						if(txt_turn.getText().equals(player3_name + "'s" + " turn!")){
							
							if(player2.equals("MANTRI")){
								
								player3_role = "MANTRI";
							}
							if(player2.equals("RAJA")){
								
								player3_role = "RAJA";
							}
							if(player2.equals("SIPAHI")){

								player3_role = "SIPAHI";
							}
							if(player2.equals("CHOR")){
								
								player3_role = "CHOR";
							}
					    	
							next_turn = player4_name+ "'s" + " turn!";
							
						}
						if(txt_turn.getText().equals(player4_name + "'s" + " turn!")){
							
							if(player2.equals("MANTRI")){
								
								player4_role = "MANTRI";
							}
							if(player2.equals("RAJA")){
								
								player4_role = "RAJA";
							}
							if(player2.equals("SIPAHI")){

								player4_role = "SIPAHI";
							}
							if(player2.equals("CHOR")){
								
								player4_role = "CHOR";
							}
					    	
							next_turn = "Click on Guess!";
							
						}
						txt_turn.setText("Click again to close the chit!");
						btn_pod2.setOnClickListener(new OnClickListener() {
							
							public void onClick(View v) {
								// TODO Auto-generated method stub
								btn_pod2.setClickable(false);
								count++;
								btn_pod2.setText("");
								btn_pod2.setBackgroundResource(R.drawable.podtrhalf);
								txt_turn.setText(next_turn);
								btn_pod1.setClickable(true);
								btn_pod3.setClickable(true);
								btn_pod4.setClickable(true);
								if(count == 4){
									
									txt_turn.setText("Click on Guess!");
									btn_play.setClickable(true);
									count = 0;
									
								}
							}
						});
					}
				});
		        
		        
			btn_pod3 = (Button)findViewById(R.id.btn_pod3);
			btn_pod3.setBackgroundResource(R.drawable.podblclosed);
			btn_pod3.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						player3 = solution_array[2];
						btn_pod3.setText(player3);
						btn_pod3.setBackgroundResource(R.drawable.podopen);

						btn_pod2.setClickable(false);
						btn_pod1.setClickable(false);
						btn_pod4.setClickable(false);
						if(txt_turn.getText().equals(player1_name + "'s" + " turn!")){
							
							if(player3.equals("MANTRI")){
								
								player1_role = "MANTRI";
							}
							if(player3.equals("RAJA")){
								
								player1_role = "RAJA";
							}
							if(player3.equals("SIPAHI")){

								player1_role = "SIPAHI";
							}
							if(player3.equals("CHOR")){
								
								player1_role = "CHOR";
							}
					    	
							next_turn = player2_name+ "'s" + " turn!";
							
						}
						if(txt_turn.getText().equals(player2_name + "'s" + " turn!")){
							
							if(player3.equals("MANTRI")){
								
								player2_role = "MANTRI";
							}
							if(player3.equals("RAJA")){
								
								player2_role = "RAJA";
							}
							if(player3.equals("SIPAHI")){

								player2_role = "SIPAHI";
							}
							if(player3.equals("CHOR")){
								
								player2_role = "CHOR";
							}
					    	
							next_turn = player3_name+ "'s" + " turn!";
							
						}
						if(txt_turn.getText().equals(player3_name + "'s" + " turn!")){
							
							if(player3.equals("MANTRI")){
								
								player3_role = "MANTRI";
							}
							if(player3.equals("RAJA")){
								
								player3_role = "RAJA";
							}
							if(player3.equals("SIPAHI")){

								player3_role = "SIPAHI";
							}
							if(player3.equals("CHOR")){
								
								player3_role = "CHOR";
							}
							next_turn = player4_name+ "'s" + " turn!";
							
						}
						if(txt_turn.getText().equals(player4_name + "'s" + " turn!")){
							
							if(player3.equals("MANTRI")){
								
								player4_role = "MANTRI";
							}
							if(player3.equals("RAJA")){
								
								player4_role = "RAJA";
							}
							if(player3.equals("SIPAHI")){

								player4_role = "SIPAHI";
							}
							if(player3.equals("CHOR")){
								
								player4_role = "CHOR";
							}
							next_turn = "Click on Guess!";
							
						}

						txt_turn.setText("Click again to close the chit!");
						btn_pod3.setOnClickListener(new OnClickListener() {
							
							public void onClick(View v) {
								// TODO Auto-generated method stub
								btn_pod3.setClickable(false);
								count++;
								btn_pod3.setText("");
								btn_pod3.setBackgroundResource(R.drawable.podblhalf);
								txt_turn.setText(next_turn);
								btn_pod2.setClickable(true);
								btn_pod1.setClickable(true);
								btn_pod4.setClickable(true);
								if(count == 4){
									
									txt_turn.setText("Click on Guess!");
									btn_play.setClickable(true);
									count = 0;
									
								}
							}
						});
					}
				});
		     
			
			
			
			btn_pod4 = (Button)findViewById(R.id.btn_pod4);
			btn_pod4.setBackgroundResource(R.drawable.podbrclosed);
			
			btn_pod4.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						player4 = solution_array[3];
						btn_pod4.setText(player4);
						btn_pod4.setBackgroundResource(R.drawable.podopen);
						

						btn_pod2.setClickable(false);
						btn_pod3.setClickable(false);
						btn_pod1.setClickable(false);
						if(txt_turn.getText().equals(player1_name + "'s" + " turn!")){
							
							if(player4.equals("MANTRI")){
								
								player1_role = "MANTRI";
							}
							if(player4.equals("RAJA")){
								
								player1_role = "RAJA";
							}
							if(player4.equals("SIPAHI")){

								player1_role = "SIPAHI";
							}
							if(player4.equals("CHOR")){
								
								player1_role = "CHOR";
							}
							next_turn = player2_name+ "'s" + " turn!";
							
						}
						if(txt_turn.getText().equals(player2_name + "'s" + " turn!")){
							
							if(player4.equals("MANTRI")){
								
								player2_role = "MANTRI";
							}
							if(player4.equals("RAJA")){
								
								player2_role = "RAJA";
							}
							if(player4.equals("SIPAHI")){

								player2_role = "SIPAHI";
							}
							if(player4.equals("CHOR")){
								
								player2_role = "CHOR";
							}
							next_turn = player3_name+ "'s" + " turn!";
							
						}
						if(txt_turn.getText().equals(player3_name + "'s" + " turn!")){
							
							if(player4.equals("MANTRI")){
								
								player3_role = "MANTRI";
							}
							if(player4.equals("RAJA")){
								
								player3_role = "RAJA";
							}
							if(player4.equals("SIPAHI")){

								player3_role = "SIPAHI";
							}
							if(player4.equals("CHOR")){
								
								player3_role = "CHOR";
							}
							next_turn = player4_name+ "'s" + " turn!";
							
						}
						if(txt_turn.getText().equals(player4_name + "'s" + " turn!")){
							
							if(player4.equals("MANTRI")){
								
								player4_role = "MANTRI";
							}
							if(player4.equals("RAJA")){
								
								player4_role = "RAJA";
							}
							if(player4.equals("SIPAHI")){

								player4_role = "SIPAHI";
							}
							if(player4.equals("CHOR")){
								
								player4_role = "CHOR";
							}
							next_turn = "Click on Guess!";
							
						}
						
						txt_turn.setText("Click again to close the chit!");
						btn_pod4.setOnClickListener(new OnClickListener() {
							
							public void onClick(View v) {
								// TODO Auto-generated method stub
								btn_pod4.setClickable(false);
								count++;
								btn_pod4.setText("");
								btn_pod4.setBackgroundResource(R.drawable.podbrhalf);
								txt_turn.setText(next_turn);
								btn_pod2.setClickable(true);
								btn_pod3.setClickable(true);
								btn_pod1.setClickable(true);
								if(count == 4){
									
									txt_turn.setText(next_turn);
									btn_play.setClickable(true);
									count = 0;
									
								}
							}
						});
					}
				});    
			
			btn_pod1.setText("");
			btn_pod2.setText("");
			btn_pod3.setText("");
			btn_pod4.setText("");
    	
    	
    }
    
    public void setRole(String role, String player){
    	
    	if(player1.equals("MANTRI")){
			
			player4_role = "MANTRI";
		}
		if(player1.equals("RAJA")){
			
			player4_role = "RAJA";
		}
		if(player1.equals("SIPAHI")){

			player4_role = "SIPAHI";
		}
		if(player1.equals("CHOR")){
			
			player4_role = "CHOR";
		}
    	
    	
    } 
    
    void shuffleArray(String[] solution_array)
    {
    	Random rnd = new Random();
    	for (int i = solution_array.length - 1; i >= 0; i--)
    		{
    			int index = rnd.nextInt(i + 1);
  
    			String a = solution_array[index];
    			solution_array[index] = solution_array[i];
    			solution_array[i] = a;
    		}
	}
    
    static void updateScore(){
    	
    	Log.v("AkhandBakar", "##########"+ guess);
    	if(player1_role.equals("MANTRI"))
    	{
    		Log.v("AkhandBakar", "##########Mantri"+ player1_name);
    	if(guess)
    		{
    		i = i+80;
    		p1_score=i;
    		txt_turn.setText(player1_name+" is right!");
    		btn_pod1.setText(player1);
			btn_pod2.setText(player2);
			btn_pod3.setText(player3);
			btn_pod4.setText(player4);
			btn_pod1.setBackgroundResource(R.drawable.podopen);
			btn_pod2.setBackgroundResource(R.drawable.podopen);
			btn_pod3.setBackgroundResource(R.drawable.podopen);
			btn_pod4.setBackgroundResource(R.drawable.podopen);
    		if(player2_role.equals("CHOR"))
    			{
    			p2_score=j;
    			if(player3_role.equals("RAJA")){
    				
    				k = k+100;
    				l = l+50;
    				p3_score=k;
    				p4_score=l;
    			}else{
    				
    				l = l+100;
    				k = k+50;
    				p4_score=l;
    				p3_score=k;
    			}
    			}
    		if(player3_role.equals("CHOR"))
    			{
    			
    			p3_score=k;
    			
    			
    			if(player2_role.equals("RAJA")){
    				
    				j = j+100;
    				l = l+50;
    				p2_score=j;
    				p4_score=l;
    			}else{
    				
    				l = l+100;
    				j = j+50;
    				p4_score=l;
    				p2_score=j;
    			}
    			}
    		if(player4_role.equals("CHOR"))
    			{
    			
    			p4_score=l;
    			
    			if(player3_role.equals("RAJA")){
    				
    				k = k+100;
    				j = j+50;
    				p2_score=j;
    				p3_score=k;
    			}else{
    				
    				j = j+100;
    				k = k+50;
    				p3_score=k;
    				p2_score=j;
    			}
    			}
    		}
    	else
    		{
    		i=i-80;
    		p1_score = i;
    		txt_turn.setText(player1_name+" is wrong!");
    		btn_pod1.setText(player1);
			btn_pod2.setText(player2);
			btn_pod3.setText(player3);
			btn_pod4.setText(player4);
			btn_pod1.setBackgroundResource(R.drawable.podopen);
			btn_pod2.setBackgroundResource(R.drawable.podopen);
			btn_pod3.setBackgroundResource(R.drawable.podopen);
			btn_pod4.setBackgroundResource(R.drawable.podopen);
			if(player2_role.equals("CHOR"))
			{
				j = j+25;
			p2_score=j;
			if(player3_role.equals("RAJA")){
				
				k = k+100;
				l = l+50;
				p3_score=k;
				p4_score=l;
			}else{
				
				l = l+100;
				k = k+50;
				p4_score=l;
				p3_score=k;
			}
			}
		if(player3_role.equals("CHOR"))
			{
			k=k+25;
			p3_score=k;
			
			
			if(player2_role.equals("RAJA")){
				
				j = j+100;
				l = l+50;
				p2_score=j;
				p4_score=l;
			}else{
				
				l = l+100;
				j = j+50;
				p4_score=l;
				p2_score=j;
			}
			}
		if(player4_role.equals("CHOR"))
			{
			l=l+25;
			p4_score=l;
			
			if(player3_role.equals("RAJA")){
				
				k = k+100;
				j = j+50;
				p2_score=j;
				p3_score=k;
			}else{
				
				j = j+100;
				k = k+50;
				p3_score=k;
				p2_score=j;
			}
			}
    		}

    	}
    if(player2_role.equals("MANTRI"))
    	{
    	if(guess)
    		{
    		Log.v("AkhandBakar", "##########Mantri"+ player2_name);
    		j = j+80;
    		p2_score=j;
    		txt_turn.setText(player2_name+" is right!");
    		btn_pod1.setText(player1);
			btn_pod2.setText(player2);
			btn_pod3.setText(player3);
			btn_pod4.setText(player4);
			btn_pod1.setBackgroundResource(R.drawable.podopen);
			btn_pod2.setBackgroundResource(R.drawable.podopen);
			btn_pod3.setBackgroundResource(R.drawable.podopen);
			btn_pod4.setBackgroundResource(R.drawable.podopen);
    		if(player1_role.equals("CHOR"))
    			{
    			p1_score=i;
    			
    			if(player3_role.equals("RAJA")){
    			
    				k = k+100;
    				l = l+50;
    				p3_score=k;
    				p4_score=l;
    			
    			}else{
    				
    				l = l+100;
    				k = k+50;
    				p4_score=l;
    				p3_score=k;
    			}
    			
    			}
    		if(player3_role.equals("CHOR"))
    			{
    			
    			p3_score=k;
    			
    			
    			if(player1_role.equals("RAJA")){
    				
    				i = i+100;
    				l = l+50;
    				p1_score=i;
    				p4_score=l;
    				
    			}else{
    				
    				l = l+100;
    				i = i+50;
    				p1_score=i;
    				p4_score=l;
    				
    			}
    			
    			}
    		if(player4_role.equals("CHOR"))
    			{
    			
    			p4_score=l;
    			
    			if(player1_role.equals("RAJA")){
    				
    				i = i+100;
    				k = k+50;
    				p1_score=i;
        			p3_score=k;
    				
    			}else{
    				
    				k = k+100;
    				i = i+50;
    				p1_score=i;
        			p3_score=k;
    			
    			
    			}
    			
    			
    			}
    		}
    	else
    		{
    		 
    		j=j-80;
    		p2_score = j;
    		txt_turn.setText(player2_name+" is wrong!");
    		btn_pod1.setText(player1);
			btn_pod2.setText(player2);
			btn_pod3.setText(player3);
			btn_pod4.setText(player4);
			btn_pod1.setBackgroundResource(R.drawable.podopen);
			btn_pod2.setBackgroundResource(R.drawable.podopen);
			btn_pod3.setBackgroundResource(R.drawable.podopen);
			btn_pod4.setBackgroundResource(R.drawable.podopen);
			if(player1_role.equals("CHOR"))
			{
				i = i+25;
			p1_score=i;
			
			if(player3_role.equals("RAJA")){
			
				k = k+100;
				l = l+50;
				p3_score=k;
				p4_score=l;
			
			}else{
				
				l = l+100;
				k = k+50;
				p4_score=l;
				p3_score=k;
			}
			
			}
		if(player3_role.equals("CHOR"))
			{
			k = k+25;
			p3_score=k;
			
			
			if(player1_role.equals("RAJA")){
				
				i = i+100;
				l = l+50;
				p1_score=i;
				p4_score=l;
				
			}else{
				
				l = l+100;
				i = i+50;
				p1_score=i;
				p4_score=l;
				
			}
			
			}
		if(player4_role.equals("CHOR"))
			{
			l = l+25;
			p4_score=l;
			
			if(player1_role.equals("RAJA")){
				
				i = i+100;
				k = k+50;
				p1_score=i;
    			p3_score=k;
				
			}else{
				
				k = k+100;
				i = i+50;
				p1_score=i;
    			p3_score=k;
			
			
			}
			
			
			}
    		}

    	}
    if(player3_role.equals("MANTRI"))
    	{
    	Log.v("AkhandBakar", "##########Mantri"+ player3_name);
    	if(guess)
    		{
    		k = k+80;
    		p3_score = k;
    		txt_turn.setText(player3_name+" is right!");
    		btn_pod1.setText(player1);
			btn_pod2.setText(player2);
			btn_pod3.setText(player3);
			btn_pod4.setText(player4);
			btn_pod1.setBackgroundResource(R.drawable.podopen);
			btn_pod2.setBackgroundResource(R.drawable.podopen);
			btn_pod3.setBackgroundResource(R.drawable.podopen);
			btn_pod4.setBackgroundResource(R.drawable.podopen);
    		if(player1_role.equals("CHOR"))
    			{
    			p1_score=i;
    			
    			if(player2_role.equals("RAJA")){
    				
    				j = j+100;
    				l = l+50;
    				p2_score=j;
        			p4_score=l;
        			
    				
    			}else{
    				
    				l = l+100;
    				j = j+50;
    				p2_score=j;
        			p4_score=l;
    				
    				
    			}
    			
    			}
    		if(player2_role.equals("CHOR"))
    			{
    			
    			p2_score=j;
    			
    			
    			if(player1_role.equals("RAJA")){
    				
    				i = i+100;
    				l = l+50;
    				p1_score=i;
    				p4_score=l;
    				
    			}else{
    				
    				i = i+50;
    				l = l+100;
    				p1_score=i;
    				p4_score=l;
    				
    			}
    			
    			}
    		if(player4_role.equals("CHOR"))
    			{
    			
    			p4_score=l;
    			
    			if(player2_role.equals("RAJA")){
    				
    				j = j+100;
    				i = i+50;
    				p1_score=i;
        			p2_score=j;
    				
    			}else{
    				
    				j = j+50;
    				i = i+100;
    				p1_score=i;
        			p2_score=j;
    				
    			}
    			
    			
    			}
    		}
    	else
    		{
    		k = k-80;
    		p3_score = k;
    		txt_turn.setText(player3_name+" is wrong!");
    		btn_pod1.setText(player1);
			btn_pod2.setText(player2);
			btn_pod3.setText(player3);
			btn_pod4.setText(player4);
			btn_pod1.setBackgroundResource(R.drawable.podopen);
			btn_pod2.setBackgroundResource(R.drawable.podopen);
			btn_pod3.setBackgroundResource(R.drawable.podopen);
			btn_pod4.setBackgroundResource(R.drawable.podopen);
			if(player1_role.equals("CHOR"))
			{
				i = i+25;
			p1_score=i;
			
			if(player2_role.equals("RAJA")){
				
				j = j+100;
				l = l+50;
				p2_score=j;
    			p4_score=l;
    			
				
			}else{
				
				l = l+100;
				j = j+50;
				p2_score=j;
    			p4_score=l;
				
				
			}
			
			}
		if(player2_role.equals("CHOR"))
			{
			j = j+25;
			p2_score=j;
			
			
			if(player1_role.equals("RAJA")){
				
				i = i+100;
				l = l+50;
				p1_score=i;
				p4_score=l;
				
			}else{
				
				i = i+50;
				l = l+100;
				p1_score=i;
				p4_score=l;
				
			}
			
			}
		if(player4_role.equals("CHOR"))
			{
			l = l+25;
			p4_score=l;
			
			if(player2_role.equals("RAJA")){
				
				j = j+100;
				i = i+50;
				p1_score=i;
    			p2_score=j;
				
			}else{
				
				j = j+50;
				i = i+100;
				p1_score=i;
    			p2_score=j;
				
			}
			
			
			}
    		}

    	}
    if(player4_role.equals("MANTRI"))
    	{
    	Log.v("AkhandBakar", "##########Mantri"+ player4_name);
    	if(guess)
    		{
    		l = l+80;
    		p4_score=l;
    		txt_turn.setText(player4_name+" is right!");
    		btn_pod1.setText(player1);
			btn_pod2.setText(player2);
			btn_pod3.setText(player3);
			btn_pod4.setText(player4);
			btn_pod1.setBackgroundResource(R.drawable.podopen);
			btn_pod2.setBackgroundResource(R.drawable.podopen);
			btn_pod3.setBackgroundResource(R.drawable.podopen);
			btn_pod4.setBackgroundResource(R.drawable.podopen);
    		if(player1_role.equals("CHOR"))
    			{
    			p1_score=i;
    			
    			
    			if(player2_role.equals("RAJA")){
    				
    				j = j+100;
    				k = k+50;
    				p2_score=j;
        			p3_score=k;
    				
    			}else{
    				
    				j = j+50;
    				k = k+100;
    				p2_score=j;
        			p3_score=k;
    				
    			}
    			}
    		if(player2_role.equals("CHOR"))
    			{
    			
    			p2_score=j;
    			
    			
    			if(player1_role.equals("RAJA")){
    				
    				i = i+100;
    				k = k+50;
    				p1_score=i;
    				p3_score=k;
    			}else{
    				
    				i = i+50;
    				k = k+100;
    				p1_score=i;
    				p3_score=k;
    				
    			}
    			
    			}
    		if(player3_role.equals("CHOR"))
    			{
    			
    			p3_score=k;
    			
    			if(player1_role.equals("RAJA")){
    				
    				i = i+100;
    				j = j+50;
    				p1_score=i;
        			p2_score=j;
    			}else{
    				
    				i = i+50;
    				j = j+100;
    				p1_score=i;
        			p2_score=j;
    				
    			}
    			
    			
    			}
    		}
    	else
    		{
    		l = l-80;
    		p4_score = l;
    		txt_turn.setText(player4_name+" is wrong!");
    		btn_pod1.setText(player1);
			btn_pod2.setText(player2);
			btn_pod3.setText(player3);
			btn_pod4.setText(player4);
			btn_pod1.setBackgroundResource(R.drawable.podopen);
			btn_pod2.setBackgroundResource(R.drawable.podopen);
			btn_pod3.setBackgroundResource(R.drawable.podopen);
			btn_pod4.setBackgroundResource(R.drawable.podopen);
			if(player1_role.equals("CHOR"))
			{
				i = i+25;
			p1_score=i;
			
			
			if(player2_role.equals("RAJA")){
				
				j = j+100;
				k = k+50;
				p2_score=j;
    			p3_score=k;
				
			}else{
				
				j = j+50;
				k = k+100;
				p2_score=j;
    			p3_score=k;
				
			}
			}
		if(player2_role.equals("CHOR"))
			{
			j=j+25;
			p2_score=j;
			
			
			if(player1_role.equals("RAJA")){
				
				i = i+100;
				k = k+50;
				p1_score=i;
				p3_score=k;
			}else{
				
				i = i+50;
				k = k+100;
				p1_score=i;
				p3_score=k;
				
			}
			
			}
		if(player3_role.equals("CHOR"))
			{
			k=k+25;
			p3_score=k;
			
			if(player1_role.equals("RAJA")){
				
				i = i+100;
				j = j+50;
				p1_score=i;
    			p2_score=j;
			}else{
				
				i = i+50;
				j = j+100;
				p1_score=i;
    			p2_score=j;
				
			}
			
			
			}
    		}

    	}
    	
    
    Log.v("AkhandBakar", "##########Score "+ i);
	txt_player1.setText("1."+ player1_name + " [" + i + "]");
	Log.v("AkhandBakar", player1 + " [" + i + "]");
	
	txt_player2.setText("2." + player2_name+ " [" + j + "]");
	
	Log.v("AkhandBakar", player2 + " [" + p2_score + "]");
	
	txt_player3.setText("3." + player3_name+ " [" + k + "]");
	Log.v("AkhandBakar", player3 + " [" + p3_score + "]");
	
	txt_player4.setText("4."+player4_name+ " [" + l + "]");	
	Log.v("AkhandBakar", player4 + " [" + p4_score + "]");
    }
}
