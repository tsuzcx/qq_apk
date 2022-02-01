package dov.com.tencent.mobileqq.richmedia.capture.view;

import acfp;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aoko;
import azbx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import wla.a;

public class GuideVideoView
  extends LinearLayout
  implements View.OnClickListener, wla.a
{
  protected FadedButton a;
  private a jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView$a;
  private b jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView$b;
  private c jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView$c;
  boolean acN = false;
  private TextView aie;
  private FadedButton b;
  boolean dBP = false;
  boolean dBQ = false;
  protected RelativeLayout dj;
  protected LinearLayout mB;
  boolean mIsPrepared = false;
  private List<String> mVideoList = new ArrayList();
  private int status = -1;
  private MqqHandler uiHandler;
  
  public GuideVideoView(Context paramContext, MqqHandler paramMqqHandler)
  {
    super(paramContext);
    this.mVideoList.add("https://sqdd.myapp.com/myapp/qqteam/QIM/Test-QIM/ad_dancegame.mp4");
    initUI();
    this.uiHandler = paramMqqHandler;
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "handleMessage");
    }
  }
  
  public void adH(String paramString)
  {
    this.mVideoList.add(0, paramString);
  }
  
  public void eUm()
  {
    if (!this.dBQ)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "hasn't opening URL, now prepare");
      }
      play();
    }
  }
  
  public void eUn() {}
  
  public void initUI()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    int i = azbx.aC(getContext()) - azbx.dip2px(95.0F) * 2;
    double d = 0.0D;
    if (Double.isNaN(0.0D)) {
      d = 0.6D;
    }
    int j = (int)(d * i);
    j = (azbx.SCREEN_WIDTH - j) / 2;
    setPadding(j, azbx.dip2px(95.0F), j, 0);
    setOrientation(1);
    setLayoutParams(localLayoutParams);
    this.mB = new LinearLayout(getContext());
    this.mB.setPadding((int)(i * 0.05D), (int)(i * 0.06D), (int)(i * 0.05D), (int)(i * 0.05D));
    localLayoutParams = new LinearLayout.LayoutParams(-1, i);
    this.mB.setLayoutParams(localLayoutParams);
    this.mB.setOrientation(1);
    this.dj = new RelativeLayout(getContext());
    localLayoutParams = new LinearLayout.LayoutParams(-1, (int)(0.782D * i));
    this.dj.setLayoutParams(localLayoutParams);
    this.dj.setBackgroundColor(-16777216);
    this.mB.addView(this.dj);
    this.aie = new TextView(getContext());
    localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    localLayoutParams.topMargin = ((int)(i * 0.01D));
    this.aie.setLayoutParams(localLayoutParams);
    this.aie.setGravity(17);
    this.aie.setText(acfp.m(2131707100));
    this.aie.setTextSize(1, 14.0F);
    this.aie.setTextColor(-1);
    this.mB.addView(this.aie);
    addView(this.mB);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton = new FadedButton(getContext());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton.setBackgroundResource(2130846841);
    localLayoutParams = new LinearLayout.LayoutParams(azbx.dip2px(40.0F), azbx.dip2px(40.0F));
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = 16;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton.setOnClickListener(this);
    addView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton);
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "TVK_SDK is not installed");
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton) {
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView$a != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView$a.onClose();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView != this.b) {}
    }
  }
  
  public void onPause()
  {
    this.status = 1;
  }
  
  public void onResume()
  {
    this.status = 0;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void play() {}
  
  public void setOnCloseListener(a parama)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView$a = parama;
  }
  
  public void setOnCompleteListener(b paramb)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView$b = paramb;
  }
  
  public void setOnErrorListener(c paramc)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView$c = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void onClose();
  }
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.GuideVideoView
 * JD-Core Version:    0.7.0.1
 */