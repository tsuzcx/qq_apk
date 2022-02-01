package com.tencent.gdtad.api;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import tgc;
import tgc.a;
import tgc.b;
import tgj;
import tgk;
import tgl;
import tgm;
import tkw;

public abstract class GdtAd
  implements Serializable
{
  private static long Ek = -2147483648L;
  private static int bBm;
  private WeakReference<tgl> listener;
  private tgc.a loadListener = new tgj(this);
  private long loadedTimeMillis = -2147483648L;
  private tgc loader;
  private int status = 0;
  
  public GdtAd(tgm paramtgm)
  {
    if (paramtgm == null)
    {
      tkw.e("GdtAd", "constructor");
      return;
    }
    tgc.b localb = new tgc.b();
    localb.a = paramtgm.b;
    this.loader = new tgc(localb, new WeakReference(this.loadListener));
  }
  
  private void a(tgk paramtgk)
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.1(this, localWeakReference, paramtgk));
  }
  
  private void bCT()
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.2(this, localWeakReference));
  }
  
  public com.tencent.gdtad.aditem.GdtAd getAd()
  {
    if (isLoaded()) {
      return getParams().c.ad;
    }
    return null;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 6;
    int i;
    if (paramInt1 == -2147483648) {
      i = 3;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramInt1 != 200);
        if (paramInt2 == 0) {
          break;
        }
        i = j;
      } while (paramInt2 != 1);
      return 4;
      if (paramInt3 == 0) {
        break;
      }
      i = j;
    } while (paramInt3 != 102006);
    return 5;
    if (paramGdtAd == null) {
      return 1;
    }
    if (!paramGdtAd.isValid()) {
      return 1;
    }
    return 0;
  }
  
  public tgc getGdtAdLoader()
  {
    return this.loader;
  }
  
  public abstract tgm getParams();
  
  public boolean isInvalidated()
  {
    return (isLoaded()) && (SystemClock.elapsedRealtime() - this.loadedTimeMillis > 86400000L);
  }
  
  public boolean isLoaded()
  {
    return (isValid()) && (this.status == 2) && (getParams().c.ad != null) && (getParams().c.ad.isValid()) && (this.loadedTimeMillis != -9223372036854775808L);
  }
  
  public boolean isValid()
  {
    return (getParams() != null) && (getParams().b != null) && (getParams().isValid());
  }
  
  public boolean load(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      tkw.e("GdtAd", String.format("load error, status:%d", new Object[] { Integer.valueOf(this.status) }));
      return false;
      if ((isValid()) && ((this.status == 0) || (this.status == 3)))
      {
        if ((Ek == -2147483648L) || (SystemClock.elapsedRealtime() - Ek > 60000L)) {
          break;
        }
        if (bBm < 30) {
          break label114;
        }
        this.status = 3;
        a(new tgk(2));
      }
    }
    bBm = 0;
    Ek = SystemClock.elapsedRealtime();
    label114:
    this.status = 1;
    bBm += 1;
    this.loader.c(new WeakReference(paramContext));
    return true;
  }
  
  public void notifyClicked()
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.4(this, localWeakReference));
  }
  
  protected void notifyClosed()
  {
    WeakReference localWeakReference = new WeakReference(this);
    AdThreadManager.INSTANCE.post(new GdtAd.5(this, localWeakReference), 0);
  }
  
  protected void notifyImpression()
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.3(this, localWeakReference));
  }
  
  public void setListener(WeakReference<tgl> paramWeakReference)
  {
    this.listener = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd
 * JD-Core Version:    0.7.0.1
 */