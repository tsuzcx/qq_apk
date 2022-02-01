package com.tencent.ad.tangram.mini;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import java.lang.ref.WeakReference;

@Keep
public abstract interface AdQQMINIProgramAdapter
{
  public abstract AdError show(Params paramParams);
  
  @Keep
  public static final class Params
  {
    public Ad ad;
    public WeakReference<Context> context;
    
    public boolean isValid()
    {
      return (this.context != null) && (this.context.get() != null) && (this.ad != null) && (this.ad.isValid()) && (!TextUtils.isEmpty(this.ad.getUrlForLandingPage()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter
 * JD-Core Version:    0.7.0.1
 */