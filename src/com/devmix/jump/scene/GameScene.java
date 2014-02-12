package com.devmix.jump.scene;

import java.util.Random;

import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import android.view.MotionEvent;

import com.devmix.cocos2d.utils.CCLayerBackground;
import com.devmix.jump.sprite.Bird;
import com.devmix.jump.utils.Assets;

import static com.devmix.cocos2d.utils.DeviceSettings.*;

public class GameScene extends CCLayerBackground{

	private Bird bird;
	public GameScene(){
		super.build(Assets.BACKGROUND);
		this.setIsTouchEnabled(true);
		addBird();
	}

	private void addBird() {
		bird = new Bird(Assets.BIRD);
		addChild(bird);
		//bird.shoot(Math.round(screenWidth()/2),Math.round(screenHeight()),true);
	}

	public static CCScene createGame() {
		CCScene scene = CCScene.node();
		GameScene layer = new GameScene();
		scene.addChild(layer);
		return scene;
	}
	
	@Override
	protected void registerWithTouchDispatcher() {
		CCTouchDispatcher.sharedDispatcher()
				.addTargetedDelegate(this, 0, false);
	}

	@Override
	public boolean ccTouchesBegan(MotionEvent event) {
		
		CGPoint touchLocation = CGPoint.make(event.getX(), event.getY());
		touchLocation = CCDirector.sharedDirector().convertToGL(touchLocation);
		touchLocation = this.convertToNodeSpace(touchLocation);

		// Check Button touched
		if (CGRect.containsPoint(this.bird.getBoundingBox(), touchLocation)) {
			bird.shoot(new Random().nextInt(Math.round(screenWidth())),Math.round((screenHeight())),true);
		}
		
		return true;
	}
}
