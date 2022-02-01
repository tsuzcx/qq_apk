package com.tencent.qqmail.view.imageview;

public abstract interface GestureImageViewListener
{
  public abstract void onFling();
  
  public abstract void onPosition(float paramFloat1, float paramFloat2);
  
  public abstract void onScale(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void onTouch(float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.GestureImageViewListener
 * JD-Core Version:    0.7.0.1
 */