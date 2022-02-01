package com.tencent.viola.ui.component.image;

import android.os.Bundle;
import android.widget.ImageView;

public abstract interface ImageAction
{
  public abstract ImageView getTarget();
  
  public abstract void onCancel();
  
  public abstract void onError();
  
  public abstract void onSuccess(Object paramObject, String paramString, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.component.image.ImageAction
 * JD-Core Version:    0.7.0.1
 */