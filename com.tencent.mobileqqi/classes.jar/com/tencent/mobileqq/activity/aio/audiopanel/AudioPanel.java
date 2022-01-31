package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class AudioPanel
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  public static final int a = 1;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1038, 1948, 2857, 3766, 4675, 5584, 6493, 7402, 8311, 10000 };
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  private static final int e = jdField_a_of_type_ArrayOfInt[1] - jdField_a_of_type_ArrayOfInt[0];
  private static final int g = -15158044;
  private static final int h = -8355712;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ChatActivity jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
  private InputLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AudioPanelAdapter jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter;
  private AudioPanelViewPager jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int f = 1;
  private int i;
  private int j;
  private int k;
  
  public AudioPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public AudioPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static int a(int paramInt)
  {
    int m = 8000;
    if (paramInt < 5000) {
      m = 4000;
    }
    for (;;)
    {
      paramInt = Math.min((int)(m * 0.3F / e), jdField_a_of_type_ArrayOfInt.length - 1);
      return jdField_a_of_type_ArrayOfInt[paramInt];
      if (paramInt >= 8000) {
        if (paramInt < 10000) {
          m = 10000;
        } else if (paramInt < 14000) {
          m = 13000;
        } else if (paramInt < 18000) {
          m = 16000;
        } else if (paramInt < 23000) {
          m = 19000;
        } else if (paramInt < 27000) {
          m = 22000;
        } else if (paramInt < 32000) {
          m = 25000;
        } else if (paramInt < 35000) {
          m = 28000;
        } else if (paramInt < 40000) {
          m = 32000;
        } else if (paramInt < 50000) {
          m = 40000;
        } else {
          m = 40000;
        }
      }
    }
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup)
  {
    Object localObject1 = (ViewGroup)paramViewGroup.getParent();
    int n = ((ViewGroup)localObject1).getChildCount();
    int m = 0;
    if (m < n) {
      if (((ViewGroup)localObject1).getChildAt(m) != paramViewGroup) {}
    }
    for (;;)
    {
      Object localObject2;
      if (m >= 0)
      {
        paramContext = new View(paramContext);
        localObject2 = new RelativeLayout.LayoutParams(-1, paramViewGroup.getHeight());
        ((RelativeLayout.LayoutParams)localObject2).addRule(6, paramViewGroup.getId());
        ((RelativeLayout.LayoutParams)localObject2).addRule(8, paramViewGroup.getId());
        paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramContext.setBackgroundColor(1275068416);
        ((ViewGroup)localObject1).addView(paramContext, m);
      }
      for (;;)
      {
        n = paramViewGroup.getChildCount();
        m = 0;
        label107:
        if (m < n)
        {
          localObject1 = paramViewGroup.getChildAt(m);
          if (((View)localObject1).getId() == 2131231202) {}
          for (;;)
          {
            m += 1;
            break label107;
            m += 1;
            break;
            localObject2 = new AlphaAnimation(1.0F, 0.3F);
            ((AlphaAnimation)localObject2).setFillEnabled(true);
            ((AlphaAnimation)localObject2).setFillAfter(true);
            ((AlphaAnimation)localObject2).setDuration(0L);
            ((AlphaAnimation)localObject2).setInterpolator(new LinearInterpolator());
            ((View)localObject1).startAnimation((Animation)localObject2);
          }
        }
        return paramContext;
        paramContext = null;
      }
      m = -1;
    }
  }
  
  public static PopupWindow a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, View paramView, int paramInt4, int paramInt5, int paramInt6)
  {
    View localView = new View(paramContext);
    localView.setBackgroundColor(0);
    paramContext = new PopupWindow(localView, paramInt1, paramInt2 - paramInt3 - AIOUtils.a(196.0F, paramContext.getResources()));
    paramContext.showAtLocation(paramView, paramInt4, paramInt5, paramInt6);
    return paramContext;
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble < 1000.0D) {}
    int n;
    for (int m = 0;; m = (int)(paramDouble / 1000.0D + 0.5D))
    {
      n = m / 60;
      m %= 60;
      if (m >= 10) {
        break;
      }
      return n + ":0" + m;
    }
    return n + ":" + m;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a()
  {
    int m;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int n = localViewGroup.getChildCount();
      m = 0;
      if (m >= n) {
        break label74;
      }
      localView = localViewGroup.getChildAt(m);
      if (localView.getVisibility() != 0) {
        break label67;
      }
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof AudioPanelCallback))) {
        ((AudioPanelCallback)localView).a();
      }
      return;
      label67:
      m += 1;
      break;
      label74:
      localView = null;
    }
  }
  
  void a(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
  {
    if (paramViewGroup != null)
    {
      int n = paramViewGroup.getChildCount();
      int m = 0;
      while (m < n)
      {
        View localView = paramViewGroup.getChildAt(m);
        if ((localView instanceof TextView)) {
          ((TextView)localView).setTextColor(paramInt1);
        }
        m += 1;
      }
    }
    if ((paramView != null) && ((paramView instanceof TextView))) {
      ((TextView)paramView).setTextColor(paramInt2);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatActivity paramChatActivity, SessionInfo paramSessionInfo, InputLinearLayout paramInputLinearLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity = paramChatActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = paramInputLinearLayout;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager = ((AudioPanelViewPager)findViewById(2131231911));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131232845));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232848));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232849));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131232847));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter = new AudioPanelAdapter(paramQQAppInterface, paramChatActivity, this, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.a(paramQQAppInterface, paramChatActivity, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-15158044);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8355712);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramQQAppInterface = getResources().getDrawable(2130840136);
    if ((paramQQAppInterface instanceof BitmapDrawable)) {
      paramQQAppInterface = ((BitmapDrawable)paramQQAppInterface).getBitmap();
    }
    for (;;)
    {
      paramQQAppInterface = new BitmapDrawable(paramQQAppInterface);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paramQQAppInterface.setDither(true);
        setBackgroundDrawable(paramQQAppInterface);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "AudioPanel.init() is called,time is:" + System.currentTimeMillis());
        }
        return;
        if (!(paramQQAppInterface instanceof SkinnableBitmapDrawable)) {
          break label325;
        }
        paramQQAppInterface = ((SkinnableBitmapDrawable)paramQQAppInterface).getBitmap();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "AudioPanel background is null:");
        }
      }
      label325:
      paramQQAppInterface = null;
    }
  }
  
  public boolean a()
  {
    int m;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int n = localViewGroup.getChildCount();
      m = 0;
      if (m >= n) {
        break label76;
      }
      localView = localViewGroup.getChildAt(m);
      if (localView.getVisibility() != 0) {}
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof AudioPanelCallback)))
      {
        return ((AudioPanelCallback)localView).a();
        m += 1;
        break;
      }
      return false;
      label76:
      localView = null;
    }
  }
  
  public void b()
  {
    int m;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int n = localViewGroup.getChildCount();
      m = 0;
      if (m >= n) {
        break label74;
      }
      localView = localViewGroup.getChildAt(m);
      if (localView.getVisibility() != 0) {
        break label67;
      }
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof AudioPanelCallback))) {
        ((AudioPanelCallback)localView).b();
      }
      return;
      label67:
      m += 1;
      break;
      label74:
      localView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == 2131232848) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(0);
        requestLayout();
        a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), -8355712, -15158044);
      }
    }
    while ((m != 2131232849) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() == 1)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(1);
    requestLayout();
    a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), -8355712, -15158044);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    if (m == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((m == 1) || (m == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.jdField_a_of_type_Boolean)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
      View localView = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(paramInt2);
      if (localView != null)
      {
        paramInt1 = (paramInt3 - paramInt1 - localView.getWidth()) / 2;
        paramInt1 = localView.getLeft() - paramInt1;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "needScrollX is:" + paramInt1);
        }
        this.jdField_b_of_type_AndroidViewViewGroup.scrollTo(paramInt1, this.jdField_b_of_type_AndroidViewViewGroup.getScrollY());
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "onPageScrollStateChanged() is called,state is:" + paramInt);
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getPageMargin() + paramInt1;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.k = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
      this.i = (this.k * paramInt2);
      this.j = this.jdField_b_of_type_AndroidViewViewGroup.getScrollX();
      this.jdField_a_of_type_Boolean = true;
    }
    paramFloat = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getScrollX() - this.i;
    if (paramFloat < 0.0F) {
      paramInt1 = this.k - 1;
    }
    for (;;)
    {
      View localView1 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.k);
      View localView2 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(paramInt1);
      if (QLog.isColorLevel())
      {
        QLog.d("AIOAudioPanel", 2, "onPageScrolled() is called,pageBeforeScroll is:" + this.k + ",nextPage is:" + paramInt1 + ",vpWidthWithMargin is:" + paramInt2);
        QLog.d("AIOAudioPanel", 2, "vpRelativeScrollX is:" + paramFloat + ",vpScrollXBeforeScroll is:" + this.i + ",pdScrollXBeforeScroll is:" + this.j);
      }
      if ((localView1 != null) && (localView2 != null))
      {
        paramInt1 = localView1.getLeft() + localView1.getWidth() / 2;
        int m = localView2.getLeft() + localView2.getWidth() / 2;
        int n = (int)(Math.abs(paramFloat / paramInt2) * (m - paramInt1));
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "centerChildCenterX is:" + paramInt1 + ",nextCenterChildCenterX is:" + m + ",pdRelativeScrollX is:" + n);
        }
        this.jdField_b_of_type_AndroidViewViewGroup.scrollTo(this.j + n, this.jdField_b_of_type_AndroidViewViewGroup.getScrollY());
        if (Math.abs(paramFloat) == paramInt2) {
          a(this.jdField_b_of_type_AndroidViewViewGroup, localView2, -8355712, -15158044);
        }
      }
      return;
      if (paramFloat > 0.0F) {
        paramInt1 = this.k + 1;
      } else {
        paramInt1 = this.k;
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "onPageSelected() is called,position is:" + paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setStatus(int paramInt)
  {
    this.f = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setStatus(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel
 * JD-Core Version:    0.7.0.1
 */