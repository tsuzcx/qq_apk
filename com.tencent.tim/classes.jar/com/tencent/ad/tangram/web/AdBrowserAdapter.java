package com.tencent.ad.tangram.web;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import java.lang.ref.WeakReference;

@Keep
public abstract interface AdBrowserAdapter
{
  public abstract AdError show(Params paramParams);
  
  @Keep
  public static final class Params
  {
    public WeakReference<Activity> activity;
    public Ad ad;
    public Bundle extrasForIntent;
    public String url;
    
    public boolean isValid()
    {
      return (this.activity != null) && (this.activity.get() != null) && (!TextUtils.isEmpty(this.url)) && (this.ad != null) && (this.ad.isValid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.web.AdBrowserAdapter
 * JD-Core Version:    0.7.0.1
 */