package com.tencent.ad.tangram.analysis;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public enum AdAnalysis
{
  INSTANCE;
  
  private static final String TAG = "AdAnalysis";
  private volatile boolean initialized = false;
  
  private AdAnalysis() {}
  
  public void init(Context paramContext)
  {
    AdLog.i("AdAnalysis", String.format("init %b", new Object[] { Boolean.valueOf(this.initialized) }));
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
    }
    finally {}
    this.initialized = true;
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      paramContext = new WeakReference(paramContext);
      if ((paramContext == null) || (paramContext.get() == null)) {
        break;
      }
      AdThreadManager.INSTANCE.post(new AdAnalysis.1(this, paramContext), 4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.AdAnalysis
 * JD-Core Version:    0.7.0.1
 */