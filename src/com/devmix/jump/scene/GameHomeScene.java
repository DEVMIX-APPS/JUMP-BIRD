package com.devmix.jump.scene;

import static com.devmix.cocos2d.utils.DeviceSettings.screenHeight;
import static com.devmix.cocos2d.utils.DeviceSettings.screenResolution;
import static com.devmix.cocos2d.utils.DeviceSettings.screenWidth;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import com.devmix.cocos2d.utils.CCLayerBackground;
import com.devmix.jump.menu.MenuButtons;
import com.devmix.jump.utils.Assets;

public class GameHomeScene extends CCLayerBackground{
	
	public GameHomeScene(){
		super.build(Assets.BACKGROUND);
		
		CCSprite icone = CCSprite.sprite(Assets.LOGO);
		icone.setPosition(screenResolution(CGPoint.ccp(screenWidth()/2, Math.round(screenHeight()/1.5))));
		this.addChild(icone);
		this.addChild(new MenuButtons());
	}
	
	public CCScene scene(){
		CCScene scene = CCScene.node();
		scene.addChild(this);
		return scene;
	}

}
