package com.tencent.mobileqq.activity.aio.stickerbubble;

import abrb;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import wja;
import yfy;
import ygb;
import ygb.a;

public class StickerBubbleReceiverAnimationRunnable
  implements Runnable, ygb.a
{
  public static volatile boolean bmt;
  private String aXE;
  private boolean bmu;
  private boolean bmv;
  private boolean bmw;
  private boolean bmx;
  private boolean bmy;
  private Runnable eE = new StickerBubbleReceiverAnimationRunnable.1(this);
  private int[] iJ;
  private QQAppInterface mApp;
  private Context mContext;
  private int mCount;
  private int mCurrentCount;
  private boolean mFinished;
  private Handler mHandler;
  private View xG;
  
  public StickerBubbleReceiverAnimationRunnable(QQAppInterface paramQQAppInterface, int paramInt, @NonNull View paramView, @NonNull String paramString)
  {
    this.mContext = paramQQAppInterface.getApp().getApplicationContext();
    this.mApp = paramQQAppInterface;
    this.mCount = paramInt;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.xG = paramView;
    this.aXE = paramString;
    if (!abrb.S(this.mApp)) {}
    for (boolean bool = true;; bool = false)
    {
      this.bmv = bool;
      ygb.a().a(this);
      return;
    }
  }
  
  @NonNull
  private int[] D()
  {
    int m = 0;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.mCount * 80 < 5000) {
      return yfy.a((QQAppInterface)localObject);
    }
    localObject = yfy.a((QQAppInterface)localObject);
    int n = localObject.length;
    int j = 0;
    for (int i = 0; j < n; i = k)
    {
      k = i;
      if (localObject[j] <= this.mCount) {
        k = i + 1;
      }
      j += 1;
    }
    localObject = new int[i];
    int k = 62 / i;
    j = m;
    while (j < i)
    {
      localObject[j] = ((j + 1) * k);
      j += 1;
    }
    return localObject;
  }
  
  public void cia()
  {
    bmt = false;
    if (wja.bNH > 0) {
      wja.bNH -= 1;
    }
  }
  
  public void cib()
  {
    this.mHandler.removeCallbacksAndMessages(null);
    yfy.a(this, this.xG);
    this.bmx = false;
    this.mFinished = true;
    bmt = false;
    wja.bNH = 0;
    if (this.bmv)
    {
      abrb.b(this.mApp, "StickerBubble", false);
      this.bmw = true;
    }
  }
  
  public void run()
  {
    if (this.mFinished) {
      return;
    }
    bmt = true;
    if ((this.bmv) && (!this.bmw))
    {
      abrb.b(this.mApp, "StickerBubble", true);
      this.bmw = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleRunnable", 2, "showReceiveAnimationView from runnable");
    }
    StickerBubbleAnimationView localStickerBubbleAnimationView = ygb.a().b((ViewGroup)this.xG, this.mContext);
    if (!this.bmu)
    {
      localStickerBubbleAnimationView.bringToFront();
      this.bmu = true;
    }
    if (this.iJ == null) {
      this.iJ = D();
    }
    this.mCurrentCount += 1;
    if ((this.mCurrentCount > this.mCount) || (this.mCurrentCount * 80 > 5000))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleRunnable", 2, "Sticker bubble receiver animation sending finished " + this);
      }
      this.bmy = true;
      this.mHandler.postDelayed(this.eE, 3000L);
      return;
    }
    if (this.mCurrentCount == 2)
    {
      yfy.b(this, this.xG);
      this.bmx = true;
      this.bmy = false;
    }
    localStickerBubbleAnimationView.a(yfy.a(this.mContext.getResources().getDisplayMetrics().widthPixels, this.aXE, this.mCurrentCount, this.iJ));
    this.mHandler.postDelayed(this, 80L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleReceiverAnimationRunnable
 * JD-Core Version:    0.7.0.1
 */