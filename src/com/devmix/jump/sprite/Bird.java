package com.devmix.jump.sprite;

import static com.devmix.cocos2d.utils.DeviceSettings.screenHeight;
import static com.devmix.cocos2d.utils.DeviceSettings.screenResolution;
import static com.devmix.cocos2d.utils.DeviceSettings.screenWidth;

import org.cocos2d.actions.instant.CCCallFuncN;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

public class Bird extends CCSprite{
	
	private float x,y;
	public Bird(String image){
		super(image);
		setX(screenWidth()/2);
		setY(screenHeight()/5);
		this.setPosition(screenResolution(CGPoint.ccp(getX(), getY())));
	}
	
	public void move(int actualDuration,int x,int y){
		this.setX(x);
		this.setY(y);
		CCMoveTo actionMove = CCMoveTo.action(actualDuration, CGPoint.ccp(x, y));
	    CCCallFuncN actionMoveDone = CCCallFuncN.action(this, "birdDown");
	    CCSequence actions = CCSequence.actions(actionMove, actionMoveDone);
	 
	    this.runAction(actions);
	}
	
	public void shoot(int toX, int toY,boolean callBack){
		//ADICIONA 40% NA POSICAO Y
		toY = Double.valueOf(toY*1.4).intValue();
		
		this.setX(toX);
		this.setY(toY);
		
	    float length = (float)Math.sqrt((toX * toX) + (toY * toY));
	    float velocity = 480.0f / 0.5f; // 480 pixels / 1 sec
	    float realMoveDuration = length / velocity;
	 
	    this.runAction(CCSequence.actions(
	            CCMoveTo.action(realMoveDuration, CGPoint.ccp(toX, toY)),
	            callBack ? CCCallFuncN.action(this, "birdDown"):CCCallFuncN.action(this, "end")));
	}
	
	public void birdDown(Object sender){
		shoot(Math.round(this.x),Math.round(screenHeight()/5),false);
	}
	
	public void end(Object sender){
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	
}
