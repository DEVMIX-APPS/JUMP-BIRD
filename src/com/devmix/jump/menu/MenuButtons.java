package com.devmix.jump.menu;

import static com.devmix.cocos2d.utils.DeviceSettings.screenHeight;
import static com.devmix.cocos2d.utils.DeviceSettings.screenResolution;
import static com.devmix.cocos2d.utils.DeviceSettings.screenWidth;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;

import com.devmix.cocos2d.utils.Button;
import com.devmix.cocos2d.utils.ButtonDelegate;
import com.devmix.jump.scene.GameScene;
import com.devmix.jump.utils.Assets;


public class MenuButtons extends CCLayer{
	private Button playButton;
	
	public MenuButtons(){
		this.setIsTouchEnabled(true);
		this.playButton = new Button(Assets.PLAY);
		
		this.playButton.setButtonDelegateListener(new ButtonDelegate() {
			@Override
			public void buttonClicked(Button sender) {
				CCDirector.sharedDirector().replaceScene(CCFadeTransition.transition(1.0f, GameScene.createGame()));
			}
		});
		
		setButtonsPosition();
		
		addChild(playButton);
		
	}

	private void setButtonsPosition() {
		playButton.setPosition(
				screenResolution(CGPoint.ccp(screenWidth()/2, Math.round(screenHeight()/2))));
		
	}
	
}
