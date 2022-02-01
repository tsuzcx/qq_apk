package com.tencent.token;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public abstract interface fn
{
  public abstract ColorStateList getSupportBackgroundTintList();
  
  public abstract PorterDuff.Mode getSupportBackgroundTintMode();
  
  public abstract void setSupportBackgroundTintList(ColorStateList paramColorStateList);
  
  public abstract void setSupportBackgroundTintMode(PorterDuff.Mode paramMode);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fn
 * JD-Core Version:    0.7.0.1
 */