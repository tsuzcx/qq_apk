package com.tencent.ad.tangram.canvas;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import java.lang.ref.WeakReference;

@Keep
public abstract interface AdCanvasAdapter
{
  public abstract int getQueueLength(WeakReference<Context> paramWeakReference);
  
  public abstract AdError show(Params paramParams);
  
  @Keep
  public static final class Params
  {
    public WeakReference<Activity> activity;
    public Ad ad;
    public boolean autoDownload = false;
    public Bundle extrasForIntent;
    
    public boolean isValid()
    {
      return (this.activity != null) && (this.activity.get() != null) && (this.ad != null) && (this.ad.isValid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.AdCanvasAdapter
 * JD-Core Version:    0.7.0.1
 */