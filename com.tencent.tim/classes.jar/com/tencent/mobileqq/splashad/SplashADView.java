package com.tencent.mobileqq.splashad;

import acfp;
import alju;
import allg;
import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anml;
import anmm;
import aqcu;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class SplashADView
  extends RelativeLayout
{
  private static SplashADView jdField_a_of_type_ComTencentMobileqqSplashadSplashADView;
  public ImageView DJ;
  View Hr;
  View Hs;
  public alju a;
  private a jdField_a_of_type_ComTencentMobileqqSplashadSplashADView$a;
  private b jdField_a_of_type_ComTencentMobileqqSplashadSplashADView$b;
  private c jdField_a_of_type_ComTencentMobileqqSplashadSplashADView$c;
  private VideoPlayerCallback jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayerCallback = new anmm(this);
  public boolean cIs;
  public boolean cIt;
  RelativeLayout dj;
  public boolean hasInit;
  private int mCurState = 0;
  TextView mJumpBtn;
  public BaseVideoView mVideoView;
  
  public SplashADView(alju paramalju, Context paramContext)
  {
    this(paramalju, paramContext, null);
  }
  
  public SplashADView(alju paramalju, Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramalju, paramContext, paramAttributeSet, 0);
  }
  
  public SplashADView(alju paramalju, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Alju = paramalju;
    this.hasInit = init(paramContext);
    this.cIs = true;
    QLog.i("QSplash@QbossSplashUtil", 1, "@SplashADView start");
  }
  
  public static SplashADView a(alju paramalju, Context paramContext)
  {
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqSplashadSplashADView == null) && (paramalju != null) && (paramContext != null)) {
        jdField_a_of_type_ComTencentMobileqqSplashadSplashADView = new SplashADView(paramalju, paramContext);
      }
      paramalju = jdField_a_of_type_ComTencentMobileqqSplashadSplashADView;
      return paramalju;
    }
    finally {}
  }
  
  private boolean a(Context paramContext, alju paramalju)
  {
    this.mVideoView = ((BaseVideoView)allg.createBaseVideoViewFS(paramContext, 120L, null, null));
    this.mVideoView.setBackgroundColor(-1);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    paramContext.addRule(13, -1);
    this.mVideoView.setLayoutParams(paramContext);
    this.mVideoView.setTag("video");
    QLog.i("SplashAD", 1, "initVideo addView " + this.mVideoView);
    this.dj.addView(this.mVideoView);
    if (paramalju.cxu)
    {
      this.DJ.setVisibility(0);
      this.DJ.setOnClickListener(new anml(this));
    }
    return true;
  }
  
  private void dRA()
  {
    ThreadManager.getUIHandler().postDelayed(new SplashADView.3(this), 200L);
    startVideo();
  }
  
  private boolean init(Context paramContext)
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "madentry =" + this.jdField_a_of_type_Alju.toString());
    LayoutInflater.from(paramContext).inflate(2131563105, this, true);
    this.mJumpBtn = ((TextView)findViewById(2131369994));
    if ((this.jdField_a_of_type_Alju.duM == 1) && (this.jdField_a_of_type_Alju.duL == 0)) {
      this.mJumpBtn.setText(acfp.m(2131714700));
    }
    this.mJumpBtn.setVisibility(0);
    this.DJ = ((ImageView)findViewById(2131372133));
    if ((this.jdField_a_of_type_Alju.mContentType == 2) && (this.jdField_a_of_type_Alju.cxv))
    {
      this.Hr = findViewById(2131382253);
      this.Hr.setVisibility(0);
    }
    this.dj = ((RelativeLayout)findViewById(2131378661));
    this.Hs = findViewById(2131365492);
    switch (this.jdField_a_of_type_Alju.mContentType)
    {
    case 1: 
    default: 
      return false;
    case 0: 
      paramContext = new ImageView(paramContext);
      paramContext.setTag("image");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 1;
      localOptions.inMutable = true;
      try
      {
        QLog.i("QSplash@QbossSplashUtil", 1, "respath =" + this.jdField_a_of_type_Alju.mResPath);
        paramContext.setImageBitmap(aqcu.decodeFile(this.jdField_a_of_type_Alju.mResPath, localOptions));
        paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dj.addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
        return true;
      }
      catch (OutOfMemoryError paramContext)
      {
        QLog.e("SplashAD", 1, paramContext.toString());
        return false;
      }
    }
    return a(paramContext, this.jdField_a_of_type_Alju);
  }
  
  public void release()
  {
    try
    {
      boolean bool = this.cIt;
      if (bool) {}
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("SplashAD", 2, "release splash res");
        }
        this.cIt = true;
        jdField_a_of_type_ComTencentMobileqqSplashadSplashADView = null;
        this.mCurState = 0;
        switch (this.jdField_a_of_type_Alju.mContentType)
        {
        case 0: 
        case 2: 
          if (this.mVideoView != null)
          {
            this.mVideoView.pause();
            this.mVideoView.releasePlayer(false);
            this.mVideoView = null;
            if (QLog.isColorLevel()) {
              QLog.i("SplashAD", 2, "release splash resvideo");
            }
          }
          break;
        }
      }
    }
    finally {}
  }
  
  public void resumeVideo()
  {
    if ((this.mVideoView != null) && (this.mCurState == 2))
    {
      QLog.i("SplashAD", 1, "resumeVideo");
      this.mVideoView.play();
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Hs.setOnClickListener(paramOnClickListener);
    this.mJumpBtn.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCompletionListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView$b = paramb;
  }
  
  public void setOnErrorListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView$c = paramc;
  }
  
  public void setPresenter(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView$a = parama;
  }
  
  public void startVideo()
  {
    if (this.mVideoView != null)
    {
      QLog.i("SplashAD", 1, "startVideo");
      this.mVideoView.play();
      this.mCurState = 2;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aRp();
  }
  
  public static abstract interface b
  {
    public abstract void dRB();
  }
  
  public static abstract interface c
  {
    public abstract void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADView
 * JD-Core Version:    0.7.0.1
 */