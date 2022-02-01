package com.tencent.mobileqq.app.qqdaily;

import acyq;
import acyr;
import acyu;
import adqr;
import adta;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.Size;
import com.tencent.ark.open.ArkAppInfo.Size;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import wja;
import wyw;

public class QQDailyArkView
  extends RelativeLayout
{
  private UnsetPressed a;
  public WrappedArkView a;
  private ArkAppLoadLayout b;
  private boolean bKq;
  private RelativeLayout jB;
  private Context mContext;
  
  static
  {
    adta.GI(true);
    adta.cUm();
  }
  
  public QQDailyArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131561788, this, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView = ((WrappedArkView)findViewById(2131362952));
    this.jB = ((RelativeLayout)findViewById(2131362975));
    this.b = ((ArkAppLoadLayout)findViewById(2131370776));
    cPc();
  }
  
  private void U(View paramView, int paramInt)
  {
    paramView = (RelativeLayout)paramView.getParent();
    if (paramView != null)
    {
      paramView = paramView.findViewById(2131362955);
      if (paramView != null) {
        paramView.setVisibility(paramInt);
      }
    }
  }
  
  private void cPb()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.addRule(14);
    localLayoutParams.width = (acyu.getScreenWidth(this.mContext) - getContext().getResources().getDimensionPixelSize(2131297631));
    localLayoutParams.height = getContext().getResources().getDimensionPixelSize(2131298931);
    int i = acyu.dp2px(getContext(), 6);
    localLayoutParams.setMargins(i, i, i, i);
  }
  
  private void cPc()
  {
    if (this.b != null)
    {
      this.b.setArkView(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl);
      cPb();
    }
    ArkAppInfo.Size localSize = new ArkAppInfo.Size(acyu.getScreenWidth(this.mContext) - getContext().getResources().getDimensionPixelSize(2131297631), getContext().getResources().getDimensionPixelSize(2131298931));
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.setSize(localSize, localSize, localSize);
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.setOnLoadListener(new acyr(this));
  }
  
  private void cdC()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl.getViewModel();
    int j;
    int i;
    int k;
    if (localObject != null) {
      if ((localObject instanceof wyw))
      {
        ArkViewModelBase.Size localSize = ((wyw)localObject).a();
        if ((localSize != null) && (localSize.height > 0))
        {
          j = localSize.height;
          if ((localSize == null) || (localSize.width <= 0)) {
            break label221;
          }
          i = localSize.width;
          k = j;
          label75:
          j = k;
          if (k <= 0) {
            j = (int)(((ArkViewModel)localObject).getHeight() * this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl.mScale);
          }
          if (i > 0) {
            break label228;
          }
          i = (int)(((ArkViewModel)localObject).getWidth() * this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl.mScale);
        }
      }
    }
    for (;;)
    {
      k = j;
      if (j <= 0) {
        k = wja.dp2px(352.0F, this.b.getResources());
      }
      j = i;
      if (i <= 0) {
        j = BaseChatItemLayout.bNT;
      }
      localObject = this.b.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = k;
      ((ViewGroup.LayoutParams)localObject).width = j;
      if (QLog.isColorLevel()) {
        QLog.i("QQDailyArkView", 2, String.format(Locale.CHINA, "resizeLoadingView.view.%h.w.%d.h.%d", new Object[] { this, Integer.valueOf(j), Integer.valueOf(k) }));
      }
      return;
      j = 0;
      break;
      label221:
      i = 0;
      k = j;
      break label75;
      label228:
      continue;
      i = 0;
      k = 0;
      break label75;
      i = 0;
      j = 0;
    }
  }
  
  private void onClick()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDailyArkView", 2, "WrappedArkView onClick");
    }
    anot.a(null, "dc00898", "", "", "0X800AC02", "0X800AC02", 0, 0, "", "", "", "");
  }
  
  public void B(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDailyArkView", 2, "load: [" + paramString1 + "][" + paramString2 + "][" + paramString3 + "][" + paramString4 + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.setClipRadius(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.load(paramString1, paramString2, paramString3, paramString4, adqr.sQ(), new acyq(this));
  }
  
  public boolean adc()
  {
    return this.bKq;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (isPressed())
      {
        onClick();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed = new UnsetPressed(null);
        }
        setPressed(true);
        removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed);
        postDelayed(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed, ViewConfiguration.getPressedStateDuration());
        continue;
        setPressed(false);
        continue;
        setPressed(false);
      }
    }
  }
  
  public void setDarkMode(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jB.setBackgroundResource(2130847106);
    }
    setPadding(0, 0, 0, 0);
  }
  
  public void setExpReported(boolean paramBoolean)
  {
    this.bKq = paramBoolean;
  }
  
  final class UnsetPressed
    implements Runnable
  {
    private UnsetPressed() {}
    
    public void run()
    {
      QQDailyArkView.this.setPressed(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyArkView
 * JD-Core Version:    0.7.0.1
 */