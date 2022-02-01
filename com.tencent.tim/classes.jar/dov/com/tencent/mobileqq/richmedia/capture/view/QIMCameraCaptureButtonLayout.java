package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axip;
import ayxr;
import ayxs;
import ayxt;
import ayxu;
import ayxv;
import ayxw;
import azbx;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import wja;

public class QIMCameraCaptureButtonLayout
  extends RelativeLayout
{
  protected View NA;
  public View Nx;
  public View Ny;
  protected View Nz;
  protected ValueAnimator P = null;
  protected CameraCaptureView a;
  protected a a;
  protected b a;
  protected c a;
  public QIMCameraCountTimeLayout a;
  public long ahO = 0L;
  private TextView aif;
  protected ValueAnimator animator = null;
  public AnimationQIMCircleProgress b;
  private ObjectAnimator bT;
  protected boolean cAn = false;
  protected boolean dBF = false;
  private boolean dBG = true;
  private boolean dBH = true;
  public AtomicBoolean dE = new AtomicBoolean(false);
  public AtomicBoolean dF = new AtomicBoolean(false);
  private int dyO = wja.dp2px(53.0F, getResources());
  private int dyP = wja.dp2px(80.0F, getResources());
  protected int dyQ = 1;
  public Handler handler = new ayxw(this, Looper.getMainLooper());
  protected boolean isOver = false;
  protected boolean isPaused = false;
  protected boolean mIsEnable = true;
  private View.OnTouchListener onTouchListener = new ayxv(this);
  protected float za = 20000.0F;
  
  public QIMCameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QIMCameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void eUe()
  {
    switch (this.dyQ)
    {
    default: 
    case 4: 
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
    }
    startCapture();
  }
  
  protected void AQ()
  {
    ba(1.0F);
    this.b.setProgress(0.0F);
    this.b.setCenterScaleValue(1.0F);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText("0秒");
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(8);
    this.Ny.setEnabled(true);
    this.Ny.setVisibility(0);
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
  
  public void a(a parama, CameraCaptureView paramCameraCaptureView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = paramCameraCaptureView;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a = parama;
  }
  
  public void aZ(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.dE.get());
    }
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
          } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a == null);
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.coA();
          return;
        } while (!this.dE.get());
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.coB();
        }
        this.dE.set(false);
        AQ();
        return;
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.dKK();
        }
        AQ();
        return;
      } while (!this.dE.get());
      adc();
      this.handler.sendEmptyMessageDelayed(5, 50L);
      return;
      reset();
    } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a == null);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.eFf();
  }
  
  protected void adc()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$b != null)
    {
      if (this.isOver) {
        stopCapture();
      }
      return;
    }
    long l = System.currentTimeMillis() - this.ahO;
    boolean bool;
    if ((float)l >= this.za)
    {
      bool = true;
      label41:
      this.isOver = bool;
      if (!this.isOver) {
        break label155;
      }
    }
    label155:
    for (int i = QIMCircleProgress.bCb;; i = (int)((float)l / this.za * QIMCircleProgress.bCb))
    {
      String str = (int)l / 1000 + "秒";
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText(str);
      this.b.setProgress(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CameraCaptureLayout", 2, "updateProgress percent:" + i + ", time:" + str);
      break;
      bool = false;
      break label41;
    }
  }
  
  public void ba(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Ny.getLayoutParams();
    localLayoutParams.width = ((int)(this.dyO * paramFloat));
    localLayoutParams.height = ((int)(this.dyO * paramFloat));
    localLayoutParams.addRule(13);
    this.Ny.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.width = ((int)(this.dyP * paramFloat));
    localLayoutParams.height = ((int)(this.dyP * paramFloat));
    localLayoutParams.addRule(13);
    this.b.setLayoutParams(localLayoutParams);
  }
  
  public float cp()
  {
    return this.za;
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
    this.animator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
    this.animator.setDuration(400L);
    this.animator.addUpdateListener(new ayxs(this));
    this.animator.addListener(new ayxt(this));
    this.animator.start();
    this.b.aea(1);
    this.P = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
    this.P.setDuration(400L);
    this.b.setStrokeWidth(3.0F);
    this.P.addUpdateListener(new ayxu(this));
    this.P.start();
  }
  
  public void dKJ()
  {
    if ((this.aif != null) && (this.aif.getVisibility() == 0))
    {
      this.aif.clearAnimation();
      this.aif.setVisibility(8);
    }
  }
  
  public void eA(boolean paramBoolean)
  {
    this.dBH = paramBoolean;
  }
  
  public void eTW()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getLayoutParams();
    localLayoutParams.bottomMargin = wja.dp2px(158.0F, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getResources());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setLayoutParams(localLayoutParams);
  }
  
  public void eTX() {}
  
  public void eUf()
  {
    ZS(false);
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.eFh();
    }
  }
  
  public void eUo()
  {
    if (this.aif != null)
    {
      this.aif.setVisibility(0);
      this.bT = ObjectAnimator.ofFloat(this.aif, "alpha", new float[] { 1.0F, 0.0F });
      this.bT.setStartDelay(3000L);
      this.bT.setDuration(500L);
      this.bT.addListener(new ayxr(this));
      this.bT.start();
    }
  }
  
  protected void init()
  {
    LayoutInflater.from(getContext()).inflate(2131561115, this, true);
    this.Nz = findViewById(2131364260);
    this.b = ((AnimationQIMCircleProgress)findViewById(2131365505));
    this.Ny = findViewById(2131367247);
    this.Ny.setOnTouchListener(this.onTouchListener);
    this.Ny.setEnabled(true);
    this.Nx = findViewById(2131367250);
    this.Nx.setOnTouchListener(this.onTouchListener);
    this.b.setBackgroundResource(2130845324);
    this.b.setCenterView();
    this.b.setVisibility(0);
    this.b.aea(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout = ((QIMCameraCountTimeLayout)findViewById(2131364275));
    this.aif = ((TextView)findViewById(2131366478));
    this.NA = findViewById(2131365506);
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
    reset();
  }
  
  public boolean r(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.dE.get() + ", actionUp:" + this.dF.get() + ", isOver:" + this.isOver + ", mTouchEnable:" + this.dBG);
    }
    dKJ();
    if (!this.dBG) {
      return false;
    }
    if (this.dBH) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.Ny, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    }
    if (this.isOver) {
      return false;
    }
    if (!this.mIsEnable)
    {
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a != null) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.eFe();
      }
      return false;
    }
    if (this.NA.getVisibility() == 0)
    {
      eUf();
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      if (this.isPaused) {
        return false;
      }
      eUe();
      return true;
      stopCapture();
      return true;
      if ((this.Ny != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView instanceof EffectsCameraCaptureView)) && (((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).auV())) {
        ((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).dLg();
      }
    }
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
      this.b.setVisibility(0);
      return;
    }
    this.Nx.setVisibility(0);
    this.Ny.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.dyQ = paramInt;
  }
  
  public void setIsFollowCaptureTips()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.aif.getLayoutParams();
    localLayoutParams.topMargin += azbx.dip2px(10.0F);
    this.aif.setLayoutParams(localLayoutParams);
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.za = paramFloat;
  }
  
  public void setRecordTipsWording(String paramString)
  {
    this.aif.setText(paramString);
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
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, "start fail because is started");
      }
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
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$c != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$c.startCountDown();
    }
  }
  
  public void stopCapture()
  {
    if (!this.cAn) {
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, "stop failed because is not start");
      }
    }
    do
    {
      return;
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
          this.b.aea(0);
          return;
          this.handler.removeMessages(1);
          if (this.dyQ == 1) {
            this.handler.sendEmptyMessage(4);
          } else if ((this.dyQ == 3) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a != null)) {
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.eFg();
          }
        }
      case 2: 
        this.handler.sendEmptyMessage(4);
        this.cAn = false;
        this.b.aea(0);
        return;
      }
    } while (!this.dE.get());
    this.dF.set(true);
    this.handler.removeMessages(5);
    cxg();
    axip.a().od(System.currentTimeMillis() - jc());
    this.handler.sendEmptyMessage(3);
    this.cAn = false;
    this.b.aea(0);
  }
  
  public static abstract interface a
  {
    public abstract boolean aNv();
    
    public abstract void coA();
    
    public abstract void coB();
    
    public abstract void dKK();
    
    public abstract void eFe();
    
    public abstract void eFf();
    
    public abstract void eFg();
    
    public abstract void eFh();
    
    public abstract void eFi();
  }
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract void startCountDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */