package com.tencent.token;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public abstract interface ga
{
  public abstract ColorStateList getSupportImageTintList();
  
  public abstract PorterDuff.Mode getSupportImageTintMode();
  
  public abstract void setSupportImageTintList(ColorStateList paramColorStateList);
  
  public abstract void setSupportImageTintMode(PorterDuff.Mode paramMode);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ga
 * JD-Core Version:    0.7.0.1
 */