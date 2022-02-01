package com.tencent.ad.tangram.image;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;

@Keep
public abstract interface AdImageViewAdapter
{
  public abstract View buildImageView(Params paramParams);
  
  @Keep
  public static abstract interface Callback
  {
    public abstract void onStopLoad(boolean paramBoolean);
  }
  
  @Keep
  public static class Params
  {
    public WeakReference<AdImageViewAdapter.Callback> callback;
    public WeakReference<Context> context;
    public String guassianUrl;
    public String url;
    
    public boolean isValid()
    {
      return (this.context != null) && (this.context.get() != null) && (!TextUtils.isEmpty(this.url)) && (this.callback != null) && (this.callback.get() != null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.image.AdImageViewAdapter
 * JD-Core Version:    0.7.0.1
 */