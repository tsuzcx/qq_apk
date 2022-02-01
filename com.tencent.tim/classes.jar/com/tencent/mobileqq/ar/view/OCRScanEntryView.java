package com.tencent.mobileqq.ar.view;

import adld;
import admh;
import ahbj;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import mqq.os.MqqHandler;

public class OCRScanEntryView
  extends ScanEntryProviderView
  implements View.OnClickListener
{
  private TextView HU;
  private TextView QK;
  private AnimationQIMCircleProgress a;
  private volatile boolean bPA;
  private View hY;
  private RelativeLayout jH;
  private ImageView yi;
  
  public OCRScanEntryView(Context paramContext, admh paramadmh)
  {
    super(paramContext, paramadmh);
  }
  
  private void GA(String paramString)
  {
    if (this.bPA)
    {
      QLog.e("AREngine_OCRScanEntryView", 1, "handleTakePhotoBtnClick, is in recognize! filePath: " + paramString);
      return;
    }
    this.bPA = true;
    if (ahbj.isFileExists(paramString))
    {
      OCRPerformFragment.b((Activity)this.mContext, paramString, 0, -1008, null);
      anot.a(null, "dc00898", "", "", "0X800AE06", "0X800AE06", 2, 0, "", "0", "0", "");
      this.bPA = false;
      return;
    }
    ThreadManager.getFileThreadHandler().post(new OCRScanEntryView.1(this));
  }
  
  public void Gz(String paramString)
  {
    if (!ahbj.isFileExists(paramString))
    {
      QLog.d("AREngine_OCRScanEntryView", 1, String.format("doDealGalleryPicFile path: %s is not exist", new Object[] { paramString }));
      return;
    }
    GA(paramString);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(null, "dc00898", "", "", "0X8009C80", "0X8009C80", 0, 0, "", "0", "0", "");
      GA(null);
      continue;
      cTs();
      continue;
      Wv();
      anot.a(null, "dc00898", "", "", "0X8009C86", "0X8009C86", 0, 0, "", "0", "0", "");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (this.jH == null)
    {
      this.jH = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131561216, null, false));
      paramBundle = new FrameLayout.LayoutParams(-1, -1);
      addView(this.jH, paramBundle);
      this.mContentView = this.jH;
      this.hY = this.jH.findViewById(2131372610);
      adld.l(this.mContext, this.hY);
      this.a = ((AnimationQIMCircleProgress)this.jH.findViewById(2131372607));
      this.HU = ((TextView)this.jH.findViewById(2131372585));
      this.yi = ((ImageView)this.jH.findViewById(2131372584));
      this.QK = ((TextView)this.jH.findViewById(2131372588));
      this.a.setBackgroundResource(2130845324);
      this.a.setCenterView();
      this.a.aea(0);
      this.HU.setOnClickListener(this);
      this.yi.setOnClickListener(this);
      this.a.setOnClickListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.OCRScanEntryView
 * JD-Core Version:    0.7.0.1
 */