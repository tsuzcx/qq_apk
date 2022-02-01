package com.tencent.mobileqq.ar.view;

import acfp;
import adap;
import adch;
import adjh;
import adjj;
import adjq;
import adjv;
import adkl;
import adkt;
import adkt.a;
import adkv;
import adky;
import adld;
import adlz;
import adma;
import admb;
import admc;
import admd;
import adme;
import admf;
import admg;
import admh;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqft;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;
import rvx;
import wja;

public class QRScanEntryView
  extends ScanEntryProviderView
  implements adjh, adjq, adkt.a, View.OnClickListener, View.OnTouchListener
{
  private CheckBox H;
  private TextView QI;
  private TextView QL;
  private TextView QM;
  private long Va;
  private long Vb;
  private ScanEntryProviderContainerView.a jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a;
  private ViewfinderView jdField_a_of_type_ComTencentMobileqqArViewViewfinderView;
  private Rect bA;
  private boolean bPB;
  private boolean bPC;
  private boolean bPD;
  private boolean bPE;
  private boolean bPF;
  private boolean bPG;
  volatile boolean bPH;
  private String buA;
  private ViewGroup dV;
  private ViewGroup dW;
  private ViewGroup dX;
  private Runnable ga = new QRScanEntryView.1(this);
  private Runnable gb = new QRScanEntryView.2(this);
  Runnable gc = new QRScanEntryView.13(this);
  private View.OnTouchListener j = new adlz(this);
  protected View mContentView;
  private long mLastTouchDownTime;
  private int mLastTouchDownX;
  private int mLastTouchDownY;
  private TextView mTitle;
  private ImageView yj;
  ImageView yk;
  
  public QRScanEntryView(Context paramContext, admh paramadmh)
  {
    super(paramContext, paramadmh);
  }
  
  private void Gx(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("updateFlashLightView byUserClick=%s mIsFlashLightVisible=%s mIsFlashLightOn=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.bPB), Boolean.valueOf(this.bPC) }));
    }
    if (this.QM != null)
    {
      if ((this.bPB) && (!this.bPC) && (!this.bPD))
      {
        this.bPD = true;
        cTp();
      }
    }
    else {
      return;
    }
    TextView localTextView = this.QM;
    boolean bool = this.bPB;
    if (!paramBoolean)
    {
      paramBoolean = true;
      c(localTextView, bool, paramBoolean);
      localTextView = this.QL;
      if ((this.bPB) && (!this.bPC)) {
        break label180;
      }
    }
    label180:
    for (paramBoolean = true;; paramBoolean = false)
    {
      c(localTextView, paramBoolean, true);
      if (!this.bPC) {
        break label185;
      }
      this.QM.setCompoundDrawablesWithIntrinsicBounds(0, 2130845766, 0, 0);
      this.QM.setText(2131700727);
      this.QM.setTextColor(-14782465);
      return;
      paramBoolean = false;
      break;
    }
    label185:
    this.QM.setCompoundDrawablesWithIntrinsicBounds(0, 2130845765, 0, 0);
    this.QM.setText(2131700728);
    this.QM.setTextColor(-1);
  }
  
  private void Gy(boolean paramBoolean)
  {
    if ((!this.bPE) && (paramBoolean))
    {
      anot.a(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 1, 0, "", "", "", "");
      this.bPE = true;
    }
    while ((this.bPF) || (paramBoolean)) {
      return;
    }
    anot.a(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 0, 0, "", "", "", "");
    this.bPF = true;
  }
  
  private void c(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (paramView != null)
    {
      if (paramBoolean2) {
        break label33;
      }
      paramView.setAlpha(1.0F);
      if (!paramBoolean1) {
        break label27;
      }
    }
    for (;;)
    {
      paramView.setVisibility(i);
      return;
      label27:
      i = 4;
    }
    label33:
    ObjectAnimator localObjectAnimator;
    if (paramBoolean1)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
      paramView.setAlpha(0.0F);
      paramView.setVisibility(4);
    }
    for (;;)
    {
      localObjectAnimator.addListener(new admb(this, paramView, paramBoolean1));
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.start();
      return;
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
      paramView.setAlpha(1.0F);
      paramView.setVisibility(0);
    }
  }
  
  private void cTk()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "checkIfNeedAutoFocus isCameraPrviewing=" + adkt.a().aeN() + ";mIsResumed=" + this.uA);
    if ((adkt.a().aeN()) && (this.uA)) {
      adkt.a().ho(adky.screenWidth, adky.screenHeight);
    }
  }
  
  private void cTo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "resetFlashLightState");
    }
    this.bPB = false;
    this.bPC = false;
    c(this.QM, this.bPB, false);
    TextView localTextView = this.QL;
    if (!this.bPB) {}
    for (boolean bool = true;; bool = false)
    {
      c(localTextView, bool, false);
      ((adkv)this.jdField_a_of_type_Adkl).I(true, 0L);
      return;
    }
  }
  
  private void cTp()
  {
    LottieComposition.Factory.fromAssetFileName(this.mContext, "qq_ar_light_first_show.json", new adma(this));
  }
  
  public void G(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onQRRecognizeSuccess type=%s data=%s fromDetect=%b", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) }));
    }
    if (!this.uA)
    {
      QLog.d("AREngine_QRScanEntryView", 1, "QREntry has closed,so give up this result");
      return;
    }
    Activity localActivity = (Activity)this.mContext;
    if (localActivity != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("detectType", 1);
      localIntent.putExtra("scannerResult", paramString2.trim());
      localIntent.putExtra("scannerType", paramString1.trim());
      localActivity.setResult(13, localIntent);
      localActivity.finish();
      localActivity.overridePendingTransition(0, 0);
    }
    if ((localActivity != null) && ((localActivity instanceof ScanTorchActivity)))
    {
      long l = ((ScanTorchActivity)localActivity).fp();
      if (l > 0L)
      {
        adap.a().ai(l, System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_QRScanEntryView", 2, String.format("QR_识别_启动累计耗时 timeCost=%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        }
      }
    }
    anot.a(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 0, 0, "", "", "", "");
  }
  
  public void Gz(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject2 = Uri.parse("file://" + paramString);
    Object localObject1 = new SparseArray(2);
    int i = rvx.a((Uri)localObject2, this.mContext, 3, (SparseArray)localObject1);
    boolean bool1 = rvx.fa(i);
    boolean bool2 = rvx.fb(i);
    localObject2 = (Activity)this.mContext;
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_QRScanEntryView", 2, "scan photo QRCode finish");
      }
      localObject1 = (Pair)((SparseArray)localObject1).get(1);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("detectType", 1);
      ((Intent)localObject2).putExtra("scannerResult", String.valueOf(((Pair)localObject1).first).trim());
      ((Intent)localObject2).putExtra("scannerType", String.valueOf(((Pair)localObject1).second).trim());
      ((Intent)localObject2).putExtra("filePath", paramString);
      ((Activity)this.mContext).setResult(13, (Intent)localObject2);
      ((Activity)this.mContext).finish();
      ((Activity)this.mContext).overridePendingTransition(0, 0);
      return;
    }
    if ((bool2) && (localObject2 != null))
    {
      localObject1 = (String)((SparseArray)localObject1).get(2);
      ((adkv)this.jdField_a_of_type_Adkl).Gp(true);
      MiniAppLauncher.launchAppByMiniCode((Context)localObject2, (String)localObject1, 1049, new admf(this, (String)localObject1, paramString));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "doDealGalleryPicFile deal fail");
    }
    adch.bU(acfp.m(2131712615), false);
  }
  
  public void KZ(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onLuminanceChanged luminance=%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    ThreadManager.getUIHandler().post(new QRScanEntryView.9(this, paramInt));
  }
  
  public void c(boolean paramBoolean, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) }));
    }
  }
  
  public void cSR()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewShow ");
    super.cSR();
    cTo();
    if (afl())
    {
      cTk();
      if ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a != null) && (!this.bPG))
      {
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a.Lo(2);
        this.bPG = true;
      }
    }
  }
  
  public void cSS()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewClose ");
    super.cSS();
    ((adkv)this.jdField_a_of_type_Adkl).I(false, 0L);
    adkt.a().cRB();
    if (this.bPC) {
      adkt.a().ba(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a.Lo(3);
      this.bPG = false;
    }
  }
  
  public void cSj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "onStartPreviewSuccess");
    }
    cTk();
  }
  
  public void d(List<adjj> paramList, long paramLong)
  {
    boolean bool;
    Object localObject;
    if (QLog.isColorLevel())
    {
      if (paramList.size() > 0)
      {
        bool = true;
        if (paramList.size() <= 0) {
          break label85;
        }
        localObject = ((adjj)paramList.get(0)).rect;
        label42:
        QLog.i("AREngine_QRScanEntryView", 2, String.format("onMiniDetectResult suc=%b rect=%s", new Object[] { Boolean.valueOf(bool), localObject }));
      }
    }
    else {
      if (this.uA) {
        break label93;
      }
    }
    label85:
    label93:
    while ((this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView == null) || (!adjv.aeJ()))
    {
      return;
      bool = false;
      break;
      localObject = "null";
      break label42;
    }
    if (paramList.size() > 0) {}
    for (paramList = ((adjj)paramList.get(0)).rect;; paramList = new Rect())
    {
      this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView.setDetectRect(paramList);
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("dispatchTouchEvent", new Object[0]) + bool);
    }
    return bool;
  }
  
  public void hz(int paramInt1, int paramInt2) {}
  
  public void m(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_QRScanEntryView", 2, String.format("onMiniDecodeResult suc=%b result=%s bFromDetect=%b", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2) }));
    }
    if (!this.uA) {}
    label236:
    label240:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView != null) && (adjv.aeJ()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramBoolean2)
        {
          localObject = "1";
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" [ ").append(paramString).append(" ]");
          this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView.setMiniText(localStringBuilder.toString());
        }
      }
      else
      {
        if (!paramBoolean1) {
          continue;
        }
        if ((!aqft.equalsWithNullCheck(paramString, this.buA)) || (System.currentTimeMillis() - this.Vb >= 10000L)) {
          break label236;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label240;
        }
        localObject = (Activity)this.mContext;
        if (localObject != null)
        {
          ((adkv)this.jdField_a_of_type_Adkl).Gp(true);
          MiniAppLauncher.launchAppByMiniCode((Context)localObject, paramString, 1047, new admg(this, paramString, (Activity)localObject));
        }
        anot.a(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 1, 0, "", "", "", "");
        return;
        localObject = "0";
        break;
      }
    }
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
      cTs();
      continue;
      Wv();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (this.mContentView == null)
    {
      View localView = LayoutInflater.from(getContext()).inflate(2131561217, this, true);
      this.dX = ((ViewGroup)findViewById(2131375314));
      this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView = ((ViewfinderView)findViewById(2131375319));
      this.dV = ((ViewGroup)findViewById(2131379791));
      adld.l(this.mContext, this.dV);
      this.QI = ((TextView)findViewById(2131379793));
      this.mTitle = ((TextView)findViewById(2131379795));
      this.yj = ((ImageView)findViewById(2131365422));
      if (paramBundle.getBoolean("hide_album", false)) {
        this.yj.setVisibility(8);
      }
      this.QI.setOnClickListener(this);
      this.QI.setContentDescription(acfp.m(2131712616));
      this.yj.setOnClickListener(this);
      this.yj.setOnTouchListener(this.j);
      this.yj.setContentDescription(acfp.m(2131712614));
      this.dW = ((ViewGroup)findViewById(2131365423));
      findViewById(2131369822).setOnTouchListener(this.j);
      this.dW.setOnClickListener(new admc(this));
      this.QL = ((TextView)findViewById(2131375313));
      this.QM = ((TextView)findViewById(2131375302));
      this.QM.setOnTouchListener(this.j);
      this.QM.setOnClickListener(new admd(this));
      this.mContentView = localView;
      this.mContentView.setOnTouchListener(this);
    }
    adkt.a().a(this);
    this.jdField_a_of_type_Adkl = new adkv();
    this.jdField_a_of_type_Adkl.a(this.mContext, this.mAppInterface);
    ((adkv)this.jdField_a_of_type_Adkl).a(this, this);
    this.H = ((CheckBox)findViewById(2131364591));
    com.tencent.mobileqq.minicode.RecogUtil.SAVE_DETECT_IMAGE = false;
    this.H.setChecked(false);
    if (adjv.aeJ())
    {
      this.H.setVisibility(0);
      this.H.setOnCheckedChangeListener(new adme(this));
    }
    this.mInited = true;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
  }
  
  public void onDestroy()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onDestroy ");
    super.onDestroy();
    adkt.a().b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a.Lo(4);
    }
    ThreadManager.getUIHandler().removeCallbacks(this.gc);
    com.tencent.mobileqq.minicode.RecogUtil.SAVE_DETECT_IMAGE = false;
  }
  
  public void onPause()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onPause ");
    super.onPause();
    cTo();
    adkt.a().cRB();
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a.Lo(3);
      this.bPG = false;
    }
  }
  
  public void onResume()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onResume ");
    super.onResume();
    ((adkv)this.jdField_a_of_type_Adkl).I(true, 1000L);
    cTk();
    if ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a != null) && (!this.bPG))
    {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a.Lo(2);
      this.bPG = true;
    }
  }
  
  public void onSaveImg(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_QRScanEntryView", 2, String.format("onSaveImg %d", new Object[] { Long.valueOf(paramLong) }));
    }
    ThreadManager.getUIHandler().post(new QRScanEntryView.8(this));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (adkt.a().aeN()) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return true;
      this.mLastTouchDownX = ((int)paramMotionEvent.getRawX());
      this.mLastTouchDownY = ((int)paramMotionEvent.getRawY());
      this.mLastTouchDownTime = System.currentTimeMillis();
      if ((this.Va > 0L) && (System.currentTimeMillis() - this.Va > ViewConfiguration.getDoubleTapTimeout()))
      {
        this.Va = 0L;
        continue;
        if ((this.mLastTouchDownTime > 0L) && (System.currentTimeMillis() - this.mLastTouchDownTime <= ViewConfiguration.getTapTimeout()))
        {
          paramView = ThreadManager.getUIHandler();
          if (this.Va > 0L)
          {
            paramView.removeCallbacks(this.ga);
            paramView.post(this.gb);
          }
          for (;;)
          {
            this.Va = System.currentTimeMillis();
            break;
            paramView.postDelayed(this.ga, ViewConfiguration.getDoubleTapTimeout());
          }
          this.mLastTouchDownTime = 0L;
          this.Va = 0L;
        }
      }
    }
  }
  
  public void setRectAreas(Rect paramRect)
  {
    if (this.jdField_a_of_type_Adkl != null) {
      ((adkv)this.jdField_a_of_type_Adkl).h(paramRect);
    }
    this.bA = paramRect;
    if (this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView.setRect(paramRect);
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.dX.getLayoutParams();
    localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, paramRect.bottom - wja.dp2px(60.0F, getResources()), localMarginLayoutParams.rightMargin, localMarginLayoutParams.bottomMargin);
  }
  
  public void setVoiceScanStatusListener(ScanEntryProviderContainerView.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView
 * JD-Core Version:    0.7.0.1
 */