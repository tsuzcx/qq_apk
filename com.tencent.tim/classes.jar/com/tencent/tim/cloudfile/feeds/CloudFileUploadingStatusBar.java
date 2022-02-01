package com.tencent.tim.cloudfile.feeds;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import athu;
import atln;
import audx;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import mqq.os.MqqHandler;

public class CloudFileUploadingStatusBar
  extends LinearLayout
{
  public static volatile boolean die;
  public static volatile boolean dif;
  private a a;
  private TextView aeX;
  private TextView aeY;
  private TextView aeZ;
  private Timer ag;
  private String bN;
  private int boq;
  private boolean dia = true;
  private boolean dib;
  private boolean dic;
  private boolean did;
  private AsyncImageView j;
  private LinearLayout lX;
  private LinearLayout lY;
  private int mFailCount;
  private int mFileType = -1;
  private int mProgress;
  private double mSpeed;
  private int mTotalCount;
  private ProgressBar progressBar;
  
  public CloudFileUploadingStatusBar(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public CloudFileUploadingStatusBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public CloudFileUploadingStatusBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void etU()
  {
    QLog.d("CloudFileUploadingStatusBar", 1, "showProcessState");
    long l = Math.round(this.mSpeed / 1024.0D);
    if (l < 1024L) {}
    for (String str = String.format("%d", new Object[] { Long.valueOf(l) }) + "KB";; str = String.format("%.01f", new Object[] { Float.valueOf((float)l / 1024.0F) }) + "MB")
    {
      this.aeY.setText(str);
      this.aeX.setText(String.valueOf(this.boq));
      this.lX.setVisibility(0);
      if (this.a != null) {
        this.a.bLT();
      }
      this.progressBar.setVisibility(0);
      this.lY.setVisibility(0);
      this.aeZ.setVisibility(8);
      return;
    }
  }
  
  private void etV()
  {
    if (this.ag != null) {
      return;
    }
    this.ag = new Timer();
    this.ag.schedule(new CloudFileUploadingStatusBar.4(this), 3000L);
  }
  
  private void etW()
  {
    QLog.d("CloudFileUploadingStatusBar", 1, "showCompletedState bNeedShowComplete " + die + " bForbidShowComplete " + dif);
    if ((!dif) && (die))
    {
      this.lX.setVisibility(0);
      if (this.a != null) {
        this.a.bLT();
      }
      this.progressBar.setVisibility(4);
      this.lY.setVisibility(8);
      this.aeZ.setText(2131691709);
      this.aeZ.setVisibility(0);
      etV();
    }
    do
    {
      return;
      dif = false;
      die = false;
      this.lX.setVisibility(8);
    } while (this.a == null);
    this.a.bLS();
  }
  
  private void etX()
  {
    QLog.d("CloudFileUploadingStatusBar", 1, "showAbortedState mFailCount " + this.mFailCount + "mTotalCount " + this.mTotalCount);
    this.lX.setVisibility(0);
    if (this.a != null) {
      this.a.bLT();
    }
    this.progressBar.setVisibility(4);
    this.lY.setVisibility(8);
    String str;
    if (this.mFailCount == this.mTotalCount)
    {
      str = String.format(getResources().getString(2131691710), new Object[] { Integer.valueOf(this.mFailCount) });
      this.aeZ.setText(str);
    }
    for (;;)
    {
      this.aeZ.setVisibility(0);
      return;
      if (audx.amK())
      {
        this.aeZ.setText(2131691712);
      }
      else
      {
        str = String.format(getResources().getString(2131691711), new Object[] { Integer.valueOf(this.mTotalCount - this.mFailCount) });
        this.aeZ.setText(str);
      }
    }
  }
  
  private void initView(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131558985, this, true);
    this.j = ((AsyncImageView)findViewById(2131364784));
    this.lX = ((LinearLayout)findViewById(2131364783));
    this.aeZ = ((TextView)findViewById(2131364787));
    this.lY = ((LinearLayout)findViewById(2131364782));
    this.aeX = ((TextView)findViewById(2131364785));
    this.aeY = ((TextView)findViewById(2131364781));
    this.progressBar = ((ProgressBar)findViewById(2131364815));
    this.progressBar.setMax(100);
    this.progressBar.setProgressDrawable(getContext().getResources().getDrawable(2130839431));
    this.lX.setOnClickListener(new atln(this));
    updateView();
  }
  
  private void invalidateView()
  {
    if (this.did) {
      return;
    }
    this.did = true;
    ThreadManager.getUIHandler().post(new CloudFileUploadingStatusBar.5(this));
  }
  
  public static void setForbidShowComplete()
  {
    dif = true;
  }
  
  public static void setNeedShowCompletedState()
  {
    QLog.d("CloudFileUploadingStatusBar", 1, "setNeedShowCompletedState");
    die = true;
  }
  
  private void updateView()
  {
    this.did = false;
    if (this.dic)
    {
      QLog.d("CloudFileUploadingStatusBar", 1, "updateView bForceHide, so hide");
      this.lX.setVisibility(8);
      if (this.a != null) {
        this.a.bLS();
      }
    }
    do
    {
      return;
      if (this.dib) {
        break;
      }
      QLog.d("CloudFileUploadingStatusBar", 1, "updateView bHasUploading is false, so hide");
      this.lX.setVisibility(8);
    } while (this.a == null);
    this.a.bLS();
    return;
    if (this.dia) {
      this.j.setDefaultImage(athu.hL(this.mFileType));
    }
    switch (this.mFileType)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      this.dia = false;
      if (this.mTotalCount == 0)
      {
        this.mProgress = 0;
        etW();
      }
      break;
    }
    for (;;)
    {
      this.progressBar.setProgress(this.mProgress);
      return;
      QLog.d("testtest", 1, "updateView mThumbPath is " + this.bN);
      this.j.setAsyncImage(this.bN);
      break;
      this.j.setApkIconAsyncImage(this.bN);
      break;
      this.j.setAsyncImage(this.bN);
      break;
      if (this.boq != 0)
      {
        etU();
      }
      else
      {
        this.mProgress = 0;
        etX();
      }
    }
  }
  
  public void setForceHide(boolean paramBoolean)
  {
    if (this.dic == paramBoolean) {
      return;
    }
    this.dic = paramBoolean;
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      updateView();
      return;
    }
    ThreadManager.getUIHandler().post(new CloudFileUploadingStatusBar.1(this));
  }
  
  public void setHasUploading(boolean paramBoolean)
  {
    QLog.d("CloudFileUploadingStatusBar", 1, "setHasUploading " + paramBoolean);
    this.dib = paramBoolean;
    ThreadManager.getUIHandler().post(new CloudFileUploadingStatusBar.2(this));
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt <= this.mProgress)
    {
      QLog.d("CloudFileUploadingStatusBar", 1, "setProgress new progress[" + paramInt + "] < last progress[" + this.mProgress + "]");
      return;
    }
    this.mProgress = paramInt;
    invalidateView();
  }
  
  public void setSpeed(double paramDouble)
  {
    if (this.mSpeed == paramDouble) {
      return;
    }
    this.mSpeed = paramDouble;
    invalidateView();
  }
  
  public void setStateListener(a parama)
  {
    this.a = parama;
  }
  
  public void setTaskCount(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == this.boq) && (paramInt3 == this.mTotalCount) && (paramInt2 == this.mFailCount)) {
      return;
    }
    this.boq = paramInt1;
    this.mFailCount = paramInt2;
    this.mTotalCount = paramInt3;
    QLog.d("CloudFileUploadingStatusBar", 1, "setTaskCount TotalCount[" + this.mTotalCount + "] FailCount[" + this.mFailCount + "] UploadingCount[" + this.boq);
    invalidateView();
  }
  
  public void setThumbPath(String paramString, int paramInt)
  {
    if ((paramString != null) && (!paramString.equals(this.bN)))
    {
      QLog.d("testtest", 1, "setThumbPath thumbPath is " + paramString);
      this.dia = true;
      this.bN = paramString;
      this.mFileType = paramInt;
      invalidateView();
      return;
    }
    QLog.d("testtest", 1, "setThumbPath thumbPath is same as last " + paramString);
  }
  
  public static abstract interface a
  {
    public abstract void bLS();
    
    public abstract void bLT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar
 * JD-Core Version:    0.7.0.1
 */