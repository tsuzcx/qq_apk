package com.tencent.gdtad.statistics;

import android.os.SystemClock;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.ref.WeakReference;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tkw;
import tla;
import tla.a;

public final class GdtDwellTimeStatisticsAfterClick
{
  private boolean aPu;
  private GdtAd ad;
  private long rV = -2147483648L;
  private boolean running;
  private WeakReference<View> view;
  
  public GdtDwellTimeStatisticsAfterClick(GdtAd paramGdtAd, WeakReference<View> paramWeakReference)
  {
    this.ad = paramGdtAd;
    this.view = paramWeakReference;
  }
  
  private void check()
  {
    WeakReference localWeakReference = new WeakReference(this);
    if (this.aPu)
    {
      if ((this.view != null) && (this.view.get() != null))
      {
        if (((View)this.view.get()).isShown())
        {
          this.aPu = false;
          this.running = false;
          leave();
          return;
        }
        ((View)this.view.get()).postDelayed(new CheckRunnable(localWeakReference), 100L);
        return;
      }
      this.aPu = false;
      this.running = false;
      leave();
      return;
    }
    if ((this.view != null) && (this.view.get() != null))
    {
      if (!((View)this.view.get()).isShown())
      {
        this.aPu = true;
        enter();
        ((View)this.view.get()).postDelayed(new CheckRunnable(localWeakReference), 100L);
        return;
      }
      ((View)this.view.get()).postDelayed(new CheckRunnable(localWeakReference), 100L);
      return;
    }
    this.running = false;
  }
  
  private void enter()
  {
    this.rV = SystemClock.elapsedRealtime();
    tkw.i("GdtDwellTimeStatisticsAfterClick", String.format("enter %d", new Object[] { Long.valueOf(this.rV) }));
  }
  
  private boolean isValid()
  {
    return (this.ad != null) && (this.view != null) && (this.view.get() != null);
  }
  
  private void leave()
  {
    long l = SystemClock.elapsedRealtime();
    tkw.i("GdtDwellTimeStatisticsAfterClick", String.format("leave %d", new Object[] { Long.valueOf(l) }));
    if (this.rV == -2147483648L) {
      tkw.e("GdtDwellTimeStatisticsAfterClick", "leave error");
    }
    l -= this.rV;
    tkw.i("GdtDwellTimeStatisticsAfterClick", String.format("dwell %d", new Object[] { Long.valueOf(l) }));
    this.rV = -2147483648L;
    tla.a locala = new tla.a();
    locala.ad = this.ad;
    locala.a.landing_page_action_type.set(42);
    locala.a.latency_ms.set(l);
    tla.a(locala);
  }
  
  public void click()
  {
    if (!isValid()) {
      tkw.e("GdtDwellTimeStatisticsAfterClick", "click error");
    }
    while (this.running) {
      return;
    }
    this.running = true;
    check();
  }
  
  static final class CheckRunnable
    implements Runnable
  {
    WeakReference<GdtDwellTimeStatisticsAfterClick> dB;
    
    public CheckRunnable(WeakReference<GdtDwellTimeStatisticsAfterClick> paramWeakReference)
    {
      this.dB = paramWeakReference;
    }
    
    public void run()
    {
      if ((this.dB == null) || (this.dB.get() == null)) {
        return;
      }
      GdtDwellTimeStatisticsAfterClick.a((GdtDwellTimeStatisticsAfterClick)this.dB.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick
 * JD-Core Version:    0.7.0.1
 */