package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import anot;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igd;
import igv;
import iiv;
import iju;
import iov;
import iow;
import iwu;
import ixv;
import ixw;
import java.lang.ref.WeakReference;

public class BeautyToolbar
  extends BaseToolbar
{
  static final String TAG = "BeautyToolbar";
  RelativeLayout mBeautySeekBar = null;
  public int mBeautyValue = 0;
  Context mContext = null;
  private VideoControlUI mControlUI;
  public boolean mIs1stShow = false;
  boolean mIsShown = false;
  SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new ixv(this);
  public SeekBar mSeek = null;
  int mThumbWidth;
  public Drawable mThumb_0;
  public Drawable mThumb_100;
  public Drawable mThumb_30;
  public Drawable mThumb_60;
  TextView mTip;
  int mTipLayoutMargin;
  RelativeLayout.LayoutParams mTipLayoutParams;
  BaseToolbar.a mUIInfo = null;
  
  public BeautyToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  static boolean checkShowBeauty(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoController.b().Qb) || (!paramVideoController.b().PY) || (!AVNotifyCenter.cA(paramVideoAppInterface.getCurrentAccountUin())) || (!paramVideoController.b().Qc)) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  protected BaseToolbar.a getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.a();
      this.mUIInfo.avw = 4;
      this.mUIInfo.avy = 2131559979;
      this.mUIInfo.avx = 2130842834;
      this.mUIInfo.QZ = this.mApp.getApp().getString(2131698132);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131697654);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    return iju.isSupport(this.mContext);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mBeautySeekBar = ((RelativeLayout)this.toolbarView.findViewById(2131374255));
    this.mSeek = ((SeekBar)this.toolbarView.findViewById(2131374256));
    this.mTip = ((TextView)this.toolbarView.findViewById(2131374257));
    this.mTipLayoutParams = null;
    this.mContext = paramAVActivity;
    this.mThumb_0 = this.mContext.getResources().getDrawable(2130842795);
    this.mThumb_30 = this.mContext.getResources().getDrawable(2130842797);
    this.mThumb_60 = this.mContext.getResources().getDrawable(2130842798);
    this.mThumb_100 = this.mContext.getResources().getDrawable(2130842796);
    this.mSeek.setMax(100);
    this.mSeek.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.mSeek.getViewTreeObserver().addOnGlobalLayoutListener(new ixw(this));
    if ((paramAVActivity instanceof AVActivity)) {
      this.mControlUI = paramAVActivity.mControlUI;
    }
    if (AudioHelper.jY(0) == 1)
    {
      this.toolbarView.setBackgroundColor(-16711936);
      this.toolbarView.findViewById(2131374255).setBackgroundColor(-256);
      this.toolbarView.findViewById(2131374259).setBackgroundColor(-16711681);
      this.toolbarView.findViewById(2131374256).setBackgroundColor(-65281);
    }
    this.mBeautySeekBar.setVisibility(4);
  }
  
  public void onHide(long paramLong)
  {
    this.mBeautySeekBar.setVisibility(8);
    this.mIsShown = false;
    this.mApp.c("BEAUTY_SKIN", this.mBeautyValue, true);
    if (this.mBeautyValue > 0)
    {
      iiv localiiv = igv.a().a();
      if (localiiv != null) {
        localiiv.Qi = true;
      }
    }
    this.mControlUI.dE(paramLong);
  }
  
  public void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mIsShown = true;
    this.mIs1stShow = true;
    this.mBeautyValue = this.mApp.ak("BEAUTY_SKIN");
    this.mSeek.setProgress(this.mBeautyValue);
    this.mControlUI.auV();
    iow localiow = VideoController.a().a(((AVActivity)this.mActivity.get()).getApplicationContext());
    if (localiow != null)
    {
      if (AudioHelper.aCz()) {
        QLog.w("BeautyToolbar", 1, "onShow, seq[" + paramLong + "]");
      }
      localiow.cp(paramLong);
      iwu.a(paramLong, this.mApp);
    }
  }
  
  public void updateTip(int paramInt)
  {
    if (this.mTipLayoutParams == null)
    {
      this.mTipLayoutParams = ((RelativeLayout.LayoutParams)this.mTip.getLayoutParams());
      this.mThumbWidth = this.mThumb_60.getIntrinsicWidth();
      this.mTipLayoutMargin = (((RelativeLayout.LayoutParams)this.mSeek.getLayoutParams()).leftMargin + this.mThumbWidth / 2);
    }
    this.mTip.setText(paramInt + "%");
    int i = this.mTip.getWidth();
    int j = this.mSeek.getWidth();
    this.mTipLayoutParams.leftMargin = (this.mTipLayoutMargin - i / 2 + (j - this.mThumbWidth) * paramInt / 100);
    this.mTip.requestLayout();
  }
  
  public static class a
  {
    public static void iF(String paramString)
    {
      anot.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
    
    public static void jS(String paramString)
    {
      int i = 0;
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof VideoAppInterface)) {
        i = ((VideoAppInterface)localObject).ak("BEAUTY_SKIN");
      }
      if (i > 0) {}
      for (localObject = "0X80076B4";; localObject = "0X80076B3")
      {
        iF((String)localObject);
        igd.aJ("BeautyToolbar", "DataReport onUserBeauty:" + paramString + "|" + i);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.BeautyToolbar
 * JD-Core Version:    0.7.0.1
 */