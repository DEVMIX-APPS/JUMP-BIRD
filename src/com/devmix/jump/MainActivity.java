package com.devmix.jump;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.devmix.jump.scene.GameHomeScene;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
 		requestWindowFeature(Window.FEATURE_NO_TITLE);
 		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

 		// view
 		CCGLSurfaceView glSurfaceView = new CCGLSurfaceView(this);
 		setContentView(glSurfaceView);
 		CCDirector.sharedDirector().attachInView(glSurfaceView);
 		
 		// configure CCDirector 
 		CCDirector.sharedDirector().setScreenSize(320, 480);
 		
 		// Starts title screen
 		CCScene scene = new GameHomeScene().scene();
 		CCDirector.sharedDirector().runWithScene(scene);
	}


}
