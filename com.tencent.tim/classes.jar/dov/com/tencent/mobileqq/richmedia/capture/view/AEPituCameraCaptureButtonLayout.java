package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import aqnm;
import atau.a;
import axcg;
import axim;
import axip;
import axis;
import axiy;
import axjd;
import ayxb;
import ayxc;
import ayxd;
import ayxe;
import ayxf;
import ayxg;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.view.AECircleCaptureProgressView;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import wja;

public class AEPituCameraCaptureButtonLayout
  extends RelativeLayout
{
  protected float GT = 20000.0F;
  protected View NA;
  public View Nx;
  public View Ny;
  protected View Nz;
  protected ValueAnimator P;
  public AECircleCaptureProgressView a;
  public a a;
  protected b a;
  protected c a;
  public QIMCameraCountTimeLayout a;
  private Intent ah;
  public long ahO;
  protected ValueAnimator animator;
  public AnimationQIMCircleProgress b;
  protected AECameraGLSurfaceView c;
  protected boolean cAn;
  private String cYg;
  private String cYh;
  private String cYi;
  protected URLImageView ch;
  private boolean dBE;
  protected boolean dBF;
  private boolean dBG = true;
  private boolean dBH = true;
  public AtomicBoolean dE = new AtomicBoolean(false);
  public AtomicBoolean dF = new AtomicBoolean(false);
  private boolean dyC;
  private int dyO;
  private int dyP;
  protected int dyQ = 1;
  protected int eMY = 20;
  private int from;
  public Handler handler = new ayxg(this, Looper.getMainLooper());
  protected boolean isOver;
  protected boolean isPaused;
  protected boolean mIsEnable = true;
  private View.OnTouchListener onTouchListener = new ayxf(this);
  
  public AEPituCameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AEPituCameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d(paramContext, paramAttributeSet);
    init();
  }
  
  private boolean aRs()
  {
    return (axcg.oe(this.from)) || (axcg.od(this.from)) || (axcg.oc(this.from)) || (axcg.of(this.from));
  }
  
  private boolean apb()
  {
    return ((getContext() instanceof Activity)) && (axcg.ay(((Activity)getContext()).getIntent()));
  }
  
  private void eTY()
  {
    eTZ();
    this.ch.setOnClickListener(new ayxe(this));
    if (this.dBE)
    {
      if (apb())
      {
        this.cYh = axis.a().t("circle_camera_ad_icon_url", "", 4);
        this.cYi = axis.a().t("circle_camera_ad_schema", "", 4);
      }
    }
    else {
      return;
    }
    this.cYh = axis.a().t("camera_ad_icon_url", "", 4);
    this.cYi = axis.a().t("camera_ad_schema", "", 4);
  }
  
  private void eTZ()
  {
    if (apb()) {
      this.dBE = axis.a().c("circle_camera_ad_show", false, 4);
    }
    for (this.cYg = axis.a().t("circle_camera_ad_type", "", 4);; this.cYg = axis.a().t("camera_ad_type", "", 4))
    {
      axiy.i("CameraCaptureLayout", "isPresent: " + this.dBE + " type: " + this.cYg);
      if ((!"h5".equals(this.cYg)) && (!"widget".equals(this.cYg))) {
        this.dBE = false;
      }
      return;
      this.dBE = axis.a().c("camera_ad_show", false, 4);
    }
  }
  
  private void eUb()
  {
    axiy.i("CameraCaptureLayout", "content entry present.");
    if (this.ch.getVisibility() == 0) {
      return;
    }
    this.ch.setVisibility(0);
    if ((this.cYh != null) && (!TextUtils.isEmpty(this.cYh))) {
      try
      {
        axiy.i("CameraCaptureLayout", "in url drawable set：" + this.cYh);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2131167595);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2131167595);
        localObject = URLDrawable.getDrawable(this.cYh, (URLDrawable.URLDrawableOptions)localObject);
        this.ch.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Exception localException)
      {
        axiy.e("CameraCaptureLayout", "url error url: " + this.cYh);
        return;
      }
    }
    axiy.i("CameraCaptureLayout", "iconUrl is empty.");
  }
  
  private void eUd()
  {
    if ((this.ch != null) && (this.ch.getVisibility() != 0)) {
      axim.a().eLa();
    }
  }
  
  private void eUe()
  {
    switch (this.dyQ)
    {
    }
    do
    {
      do
      {
        return;
        if (!FeatureManager.isBasicFeaturesFunctionReady())
        {
          QQToast.a(getContext(), 1, getContext().getString(2131690026), 1).show();
          return;
        }
        if ((this.cAn) && (this.dE.get()))
        {
          stopCapture();
          return;
        }
      } while (this.cAn);
      if (this.dBF)
      {
        startCountDown();
        return;
      }
      startCapture();
      return;
      if ((this.cAn) && (this.dE.get()))
      {
        stopCapture();
        return;
      }
    } while (this.cAn);
    if (this.dBF)
    {
      startCountDown();
      return;
    }
    startCapture();
  }
  
  protected void AQ()
  {
    bN(1.0F);
    if (!this.dyC)
    {
      this.b.setProgress(0.0F);
      this.b.setCenterScaleValue(1.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText("0秒");
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(8);
      this.Ny.setEnabled(true);
      this.Ny.setVisibility(0);
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setProgress(0.0F);
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setCenterScaleValue(1.0F);
    }
  }
  
  public void Yp(boolean paramBoolean)
  {
    QIMCameraCountTimeLayout localQIMCameraCountTimeLayout;
    if (!this.dyC)
    {
      if (this.b != null) {
        this.b.Yp(paramBoolean);
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout != null)
      {
        localQIMCameraCountTimeLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout;
        if (!paramBoolean) {
          break label66;
        }
      }
    }
    label66:
    for (int i = -16777216;; i = -1)
    {
      localQIMCameraCountTimeLayout.setTextColor(i);
      return;
      if (this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView == null) {
        break;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.Yp(paramBoolean);
      break;
    }
  }
  
  public void ZR(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = this.Nz.getHeight();
      if (i != 0)
      {
        i = i / 2 - aqnm.dip2px(86.0F);
        if (!this.dyC) {
          this.b.setTranslationY(i);
        }
        for (;;)
        {
          this.Ny.setTranslationY(i);
          return;
          this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setTranslationY(i);
        }
      }
      if (!this.dyC) {
        this.b.setTranslationY(aqnm.dip2px(17.0F));
      }
      for (;;)
      {
        this.Ny.setTranslationY(aqnm.dip2px(17.0F));
        return;
        this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setTranslationY(aqnm.dip2px(17.0F));
      }
    }
    if (!this.dyC) {
      this.b.setTranslationY(aqnm.dip2px(17.0F));
    }
    for (;;)
    {
      this.Ny.setTranslationY(aqnm.dip2px(17.0F));
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setTranslationY(aqnm.dip2px(17.0F));
    }
  }
  
  public void ZS(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.NA.setVisibility(0);
      return;
    }
    this.NA.setVisibility(8);
  }
  
  public void a(a parama, int paramInt, AECameraGLSurfaceView paramAECameraGLSurfaceView)
  {
    this.c = paramAECameraGLSurfaceView;
    this.from = paramInt;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a = parama;
    eUc();
  }
  
  public void a(boolean paramBoolean, @NonNull axjd paramaxjd)
  {
    if (!this.dyC) {
      if (this.b != null) {
        this.b.a(paramBoolean, paramaxjd);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout != null) && (paramBoolean))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setTextColor(paramaxjd.eFt);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setTextShadow(paramaxjd.duY);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setDotView(paramaxjd.eFs);
      }
      return;
      if (this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView != null) {
        this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(paramBoolean, paramaxjd);
      }
    }
  }
  
  public void a(boolean paramBoolean, c paramc)
  {
    this.dBF = paramBoolean;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$c = paramc;
  }
  
  public boolean aRr()
  {
    return this.dBE;
  }
  
  public boolean aRt()
  {
    if (!this.dyC) {
      if (this.b.getMode() == 0) {}
    }
    while (this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.getMode() != 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void aZ(Message paramMessage)
  {
    axiy.i("CameraCaptureLayout", "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.dE.get());
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            cxj();
            return;
          } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a == null);
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a.coA();
          return;
        } while (!this.dE.get());
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a.coB();
        }
        this.dE.set(false);
        this.dF.set(false);
        AQ();
        setVisibility(8);
        return;
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a.dKK();
        }
        AQ();
        return;
      } while (!this.dE.get());
      adc();
      this.handler.sendEmptyMessageDelayed(5, 50L);
      return;
      reset();
    } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a == null);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a.eFf();
  }
  
  protected void adc()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$b != null) {}
    label142:
    label152:
    for (;;)
    {
      if (this.isOver) {
        stopCapture();
      }
      return;
      long l = System.currentTimeMillis() - this.ahO;
      boolean bool;
      label41:
      int i;
      if ((float)l >= this.GT)
      {
        bool = true;
        this.isOver = bool;
        if (!this.isOver) {
          break label125;
        }
        i = QIMCircleProgress.bCb;
        label58:
        String str = (int)l / 1000 + "秒";
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText(str);
        if (this.dyC) {
          break label142;
        }
        this.b.setProgress(i);
      }
      for (;;)
      {
        if (!QLog.isDevelopLevel()) {
          break label152;
        }
        break;
        bool = false;
        break label41;
        label125:
        i = (int)((float)l / this.GT * QIMCircleProgress.bCb);
        break label58;
        this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setProgress(i);
      }
    }
  }
  
  public void bN(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Ny.getLayoutParams();
    localLayoutParams.width = ((int)(this.dyO * paramFloat));
    localLayoutParams.height = ((int)(this.dyO * paramFloat));
    localLayoutParams.addRule(13);
    this.Ny.setLayoutParams(localLayoutParams);
    if (!this.dyC)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.width = ((int)(this.dyP * paramFloat));
      localLayoutParams.height = ((int)(this.dyP * paramFloat));
      localLayoutParams.addRule(13);
      this.b.setLayoutParams(localLayoutParams);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.ba(paramFloat);
  }
  
  @TargetApi(11)
  public void cxg()
  {
    if (this.animator != null) {
      this.animator.cancel();
    }
    if (this.P != null) {
      this.P.cancel();
    }
  }
  
  @TargetApi(11)
  protected void cxj()
  {
    if (!this.dyC)
    {
      this.animator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
      if (this.dyC) {
        break label198;
      }
      this.animator.setDuration(400L);
      label45:
      this.animator.addUpdateListener(new ayxb(this));
      this.animator.addListener(new ayxc(this));
      this.animator.start();
      if (this.dyC) {
        break label212;
      }
      this.b.aea(1);
      label97:
      if (this.dyC) {
        break label223;
      }
      this.P = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
      this.b.setStrokeWidth(3.0F);
      label134:
      if (this.dyC) {
        break label256;
      }
      this.P.setDuration(400L);
    }
    for (;;)
    {
      this.P.addUpdateListener(new ayxd(this));
      this.P.start();
      return;
      this.animator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.333333F });
      break;
      label198:
      this.animator.setDuration(300L);
      break label45;
      label212:
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.aea(1);
      break label97;
      label223:
      this.P = ValueAnimator.ofFloat(new float[] { 1.0F, 0.6F });
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setStrokeWidth(5.0F);
      break label134;
      label256:
      this.P.setDuration(300L);
    }
  }
  
  protected void d(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {}
    do
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.pz);
    } while (paramContext == null);
    this.dyC = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }
  
  public void eTW()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getLayoutParams();
    localLayoutParams.bottomMargin = wja.dp2px(158.0F, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getResources());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setLayoutParams(localLayoutParams);
  }
  
  public void eTX() {}
  
  public void eUa()
  {
    if (!this.dBE)
    {
      if (this.ch.getVisibility() == 0) {
        this.ch.setVisibility(8);
      }
      axiy.d("CameraCaptureLayout", "hide camera content entry.");
      return;
    }
    if (axcg.oi(this.from))
    {
      eUb();
      return;
    }
    if (axcg.oh(this.from))
    {
      eUd();
      eUb();
      return;
    }
    if (aRs())
    {
      if ("h5".equals(axis.a().t("camera_ad_type", "", 4)))
      {
        eUd();
        eUb();
        return;
      }
      if (this.ch.getVisibility() == 0) {
        this.ch.setVisibility(8);
      }
      this.dBE = false;
      return;
    }
    if (this.ch.getVisibility() == 0) {
      this.ch.setVisibility(8);
    }
    this.dBE = false;
  }
  
  public void eUc()
  {
    if (apb()) {
      return;
    }
    if (aRs())
    {
      this.dBE = "h5".equals(axis.a().t("camera_ad_type", "", 4));
      return;
    }
    this.dBE = axcg.oh(this.from);
  }
  
  public void eUf()
  {
    ZS(false);
  }
  
  protected void init()
  {
    if (!this.dyC)
    {
      LayoutInflater.from(getContext()).inflate(2131561115, this, true);
      this.dyO = wja.dp2px(53.0F, getResources());
      this.dyP = wja.dp2px(80.0F, getResources());
      this.Nz = findViewById(2131364260);
      if (this.dyC) {
        break label277;
      }
      this.b = ((AnimationQIMCircleProgress)findViewById(2131365505));
      label83:
      this.Ny = findViewById(2131367247);
      this.ch = ((URLImageView)findViewById(2131364195));
      eTY();
      this.Ny.setOnTouchListener(this.onTouchListener);
      this.Ny.setEnabled(true);
      this.Nx = findViewById(2131367250);
      this.Nx.setOnTouchListener(this.onTouchListener);
      if (this.dyC) {
        break label294;
      }
      this.b.setBackgroundResource(2130845324);
      this.b.setCenterView();
      this.b.setVisibility(0);
      this.b.aea(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout = ((QIMCameraCountTimeLayout)findViewById(2131364275));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setIsCircleStyle(this.dyC);
      this.NA = findViewById(2131365506);
      return;
      LayoutInflater.from(getContext()).inflate(2131558548, this, true);
      this.dyO = wja.dp2px(95.0F, getResources());
      this.dyP = wja.dp2px(86.25F, getResources());
      break;
      label277:
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView = ((AECircleCaptureProgressView)findViewById(2131365505));
      break label83;
      label294:
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setCenterView();
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.aea(0);
    }
  }
  
  public long jc()
  {
    return this.ahO;
  }
  
  public void onPause()
  {
    this.isPaused = true;
    stopCapture();
  }
  
  public void onResume()
  {
    this.isPaused = false;
    this.cAn = false;
    reset();
  }
  
  public boolean r(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!QLog.isDevelopLevel()) || (!this.dBG)) {}
    do
    {
      do
      {
        return false;
        if (this.dBH) {
          GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.Ny, this.c);
        }
      } while ((this.isOver) || (!this.mIsEnable));
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a != null) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a.eGc();
      }
      if (this.NA.getVisibility() == 0)
      {
        eUf();
        return false;
      }
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      case 4: 
      default: 
        return false;
      }
    } while (this.isPaused);
    this.ch.setVisibility(8);
    eUe();
    return true;
    stopCapture();
    return true;
    return true;
  }
  
  public void reset()
  {
    AQ();
    this.dF.set(false);
    this.dE.set(false);
    this.ahO = 0L;
    this.isOver = false;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.mIsEnable == paramBoolean) {
      return;
    }
    this.mIsEnable = paramBoolean;
    if (this.mIsEnable)
    {
      this.Nx.setVisibility(8);
      this.Ny.setVisibility(0);
      if (this.dyC)
      {
        this.b.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setVisibility(0);
      return;
    }
    this.Nx.setVisibility(0);
    this.Ny.setVisibility(8);
    if (this.dyC)
    {
      this.b.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setVisibility(8);
  }
  
  public void setEntryPresent(boolean paramBoolean)
  {
    if ((this.ch == null) || (!this.dBE)) {
      return;
    }
    if (paramBoolean)
    {
      eUa();
      return;
    }
    this.ch.setVisibility(8);
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.dyQ = paramInt;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.GT = paramFloat;
    this.eMY = ((int)(this.GT / 1000.0F));
  }
  
  public void setOriginIntent(Intent paramIntent)
  {
    this.ah = paramIntent;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    this.dBG = paramBoolean;
  }
  
  public void startCapture()
  {
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    Iterator localIterator = LogicDataManager.getInstance().getEditableWMElement().iterator();
    while (localIterator.hasNext())
    {
      WMElement localWMElement = (WMElement)localIterator.next();
      if (!localWMElement.getCheckInDate().equals(str)) {
        localWMElement.addDays(str);
      }
    }
    if (this.cAn) {
      axiy.i("CameraCaptureLayout", "start fail because is started");
    }
    do
    {
      return;
      if ((this.dyQ == 3) || (this.dyQ == 1) || (this.dyQ == 4)) {
        this.handler.sendEmptyMessageDelayed(1, 100L);
      }
      this.cAn = true;
    } while (this.dyQ != 2);
    stopCapture();
  }
  
  public void startCountDown()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$c != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$c.startCountDown();
    }
  }
  
  public void stopCapture()
  {
    if (!this.cAn)
    {
      axiy.i("CameraCaptureLayout", "stop failed because is not start");
      return;
    }
    switch (this.dyQ)
    {
    default: 
      return;
    case 1: 
    case 3: 
      this.dF.set(true);
      this.handler.removeMessages(5);
      cxg();
      if (this.dE.get()) {
        this.handler.sendEmptyMessage(3);
      }
      for (;;)
      {
        this.cAn = false;
        if (this.dyC) {
          break;
        }
        this.b.aea(0);
        return;
        this.handler.removeMessages(1);
        if (this.dyQ == 1) {
          this.handler.sendEmptyMessage(4);
        } else if ((this.dyQ == 3) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a != null)) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout$a.eFg();
        }
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.aea(0);
      return;
    case 2: 
      this.handler.sendEmptyMessage(4);
      this.cAn = false;
      if (!this.dyC)
      {
        this.b.aea(0);
        return;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.aea(0);
      return;
    }
    if (this.dE.get())
    {
      axiy.d("CameraCaptureLayout", "in stop capture 1");
      this.dF.set(true);
      this.handler.removeMessages(5);
      cxg();
      axip.a().od(System.currentTimeMillis() - jc());
      this.handler.sendEmptyMessage(3);
      this.cAn = false;
      if (!this.dyC)
      {
        this.b.aea(0);
        return;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.aea(0);
      return;
    }
    axiy.d("CameraCaptureLayout", "in stop capture 2 " + this.cAn);
  }
  
  public static abstract interface a
  {
    public abstract void acc(String paramString);
    
    public abstract void coA();
    
    public abstract void coB();
    
    public abstract void dKK();
    
    public abstract void eFf();
    
    public abstract void eFg();
    
    public abstract void eGc();
  }
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract void startCountDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */