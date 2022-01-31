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
import com.tencent.mobileqq.activity.BaseChatPie;
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
  private static PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow = null;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1038, 1948, 2857, 3766, 4675, 5584, 6493, 7402, 8311, 10000 };
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  private static final int i = jdField_a_of_type_ArrayOfInt[1] - jdField_a_of_type_ArrayOfInt[0];
  private static final int k = -15158044;
  private static final int l = -8355712;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private InputLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AudioPanelAdapter jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter;
  private AudioPanelViewPager jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private TextView c;
  private int j = 1;
  private int m;
  private int n;
  private int o;
  private int p = -1;
  
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
    int i1 = 8000;
    if (paramInt < 5000) {
      i1 = 4000;
    }
    for (;;)
    {
      paramInt = Math.min((int)(i1 * 0.3F / i), jdField_a_of_type_ArrayOfInt.length - 1);
      return jdField_a_of_type_ArrayOfInt[paramInt];
      if (paramInt >= 8000) {
        if (paramInt < 10000) {
          i1 = 10000;
        } else if (paramInt < 14000) {
          i1 = 13000;
        } else if (paramInt < 18000) {
          i1 = 16000;
        } else if (paramInt < 23000) {
          i1 = 19000;
        } else if (paramInt < 27000) {
          i1 = 22000;
        } else if (paramInt < 32000) {
          i1 = 25000;
        } else if (paramInt < 35000) {
          i1 = 28000;
        } else if (paramInt < 40000) {
          i1 = 32000;
        } else if (paramInt < 50000) {
          i1 = 40000;
        } else {
          i1 = 40000;
        }
      }
    }
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup)
  {
    Object localObject1 = (ViewGroup)paramViewGroup.getParent();
    int i2 = ((ViewGroup)localObject1).getChildCount();
    int i1 = 0;
    if (i1 < i2) {
      if (((ViewGroup)localObject1).getChildAt(i1) != paramViewGroup) {}
    }
    for (;;)
    {
      Object localObject2;
      if (i1 >= 0)
      {
        paramContext = new View(paramContext);
        localObject2 = new RelativeLayout.LayoutParams(-1, paramViewGroup.getHeight());
        ((RelativeLayout.LayoutParams)localObject2).addRule(6, paramViewGroup.getId());
        ((RelativeLayout.LayoutParams)localObject2).addRule(8, paramViewGroup.getId());
        paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramContext.setBackgroundColor(1275068416);
        ((ViewGroup)localObject1).addView(paramContext, i1);
      }
      for (;;)
      {
        i2 = paramViewGroup.getChildCount();
        i1 = 0;
        label107:
        if (i1 < i2)
        {
          localObject1 = paramViewGroup.getChildAt(i1);
          if (((View)localObject1).getId() == 2131296668) {}
          for (;;)
          {
            i1 += 1;
            break label107;
            i1 += 1;
            break;
            if (((View)localObject1).getVisibility() != 8)
            {
              localObject2 = new AlphaAnimation(1.0F, 0.3F);
              ((AlphaAnimation)localObject2).setFillEnabled(true);
              ((AlphaAnimation)localObject2).setFillAfter(true);
              ((AlphaAnimation)localObject2).setDuration(0L);
              ((AlphaAnimation)localObject2).setInterpolator(new LinearInterpolator());
              ((View)localObject1).startAnimation((Animation)localObject2);
            }
          }
        }
        return paramContext;
        paramContext = null;
      }
      i1 = -1;
    }
  }
  
  public static PopupWindow a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, View paramView, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((jdField_a_of_type_AndroidWidgetPopupWindow != null) && (jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      return jdField_a_of_type_AndroidWidgetPopupWindow;
    }
    View localView = new View(paramContext);
    localView.setBackgroundColor(1275068416);
    jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView, paramInt1, paramInt2 - AIOUtils.a(196.0F, paramContext.getResources()));
    jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, paramInt4, paramInt5, paramInt6);
    return jdField_a_of_type_AndroidWidgetPopupWindow;
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble < 1000.0D) {}
    int i2;
    for (int i1 = 0;; i1 = (int)(paramDouble / 1000.0D + 0.5D))
    {
      i2 = i1 / 60;
      i1 %= 60;
      if (i1 >= 10) {
        break;
      }
      return i2 + ":0" + i1;
    }
    return i2 + ":" + i1;
  }
  
  public int a()
  {
    return this.j;
  }
  
  public void a()
  {
    int i1;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int i2 = localViewGroup.getChildCount();
      i1 = 0;
      if (i1 >= i2) {
        break label74;
      }
      localView = localViewGroup.getChildAt(i1);
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
      i1 += 1;
      break;
      label74:
      localView = null;
    }
  }
  
  public void a(ViewGroup paramViewGroup) {}
  
  void a(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
  {
    if (paramViewGroup != null)
    {
      int i2 = paramViewGroup.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = paramViewGroup.getChildAt(i1);
        if ((localObject instanceof TextView))
        {
          localObject = (TextView)localObject;
          ((TextView)localObject).setTextColor(paramInt1);
          ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
        }
        i1 += 1;
      }
    }
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      paramViewGroup = (TextView)paramView;
      paramViewGroup.setTextColor(paramInt2);
      paramViewGroup.setContentDescription("已选中" + paramViewGroup.getText());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, InputLinearLayout paramInputLinearLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = paramInputLinearLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager = ((AudioPanelViewPager)findViewById(2131298113));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131298114));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298118));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298119));
    this.c = ((TextView)findViewById(2131298117));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131298116));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter = new AudioPanelAdapter(paramQQAppInterface, paramBaseChatPie, this, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.a(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-15158044);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("已选中" + this.jdField_a_of_type_AndroidWidgetTextView.getText());
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8355712);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_b_of_type_Boolean = true;
    paramQQAppInterface = getResources().getDrawable(2130839354);
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
          break label402;
        }
        paramQQAppInterface = ((SkinnableBitmapDrawable)paramQQAppInterface).getBitmap();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "AudioPanel background is null:");
        }
      }
      label402:
      paramQQAppInterface = null;
    }
  }
  
  public boolean a()
  {
    int i1;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int i2 = localViewGroup.getChildCount();
      i1 = 0;
      if (i1 >= i2) {
        break label76;
      }
      localView = localViewGroup.getChildAt(i1);
      if (localView.getVisibility() != 0) {}
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof AudioPanelCallback)))
      {
        return ((AudioPanelCallback)localView).a();
        i1 += 1;
        break;
      }
      return false;
      label76:
      localView = null;
    }
  }
  
  public void b()
  {
    jdField_a_of_type_AndroidWidgetPopupWindow = null;
    int i1;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int i2 = localViewGroup.getChildCount();
      i1 = 0;
      if (i1 >= i2) {
        break label78;
      }
      localView = localViewGroup.getChildAt(i1);
      if (localView.getVisibility() != 0) {
        break label71;
      }
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof AudioPanelCallback))) {
        ((AudioPanelCallback)localView).c();
      }
      return;
      label71:
      i1 += 1;
      break;
      label78:
      localView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131298118) {
      setCurrentPannel(1, false);
    }
    do
    {
      return;
      if (i1 == 2131298119)
      {
        setCurrentPannel(2, false);
        return;
      }
    } while (i1 != 2131298117);
    setCurrentPannel(0, false);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i1 == 1) || (i1 == 3)) {
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
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Boolean = false;
      a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), -8355712, -15158044);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getPageMargin() + paramInt1;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.o = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
      this.m = ((this.o + this.p) * paramInt2);
      this.n = this.jdField_b_of_type_AndroidViewViewGroup.getScrollX();
      this.jdField_a_of_type_Boolean = true;
    }
    paramFloat = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getScrollX() - this.m;
    if (paramFloat < 0.0F) {
      paramInt1 = this.o - 1;
    }
    for (;;)
    {
      View localView1 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.o);
      View localView2 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(paramInt1);
      if (QLog.isColorLevel())
      {
        QLog.d("AIOAudioPanel", 2, "onPageScrolled() is called,pageBeforeScroll is:" + this.o + ",nextPage is:" + paramInt1 + ",vpWidthWithMargin is:" + paramInt2);
        QLog.d("AIOAudioPanel", 2, "vpRelativeScrollX is:" + paramFloat + ",vpScrollXBeforeScroll is:" + this.m + ",pdScrollXBeforeScroll is:" + this.n);
      }
      if ((localView1 != null) && (localView2 != null))
      {
        paramInt1 = localView1.getLeft() + localView1.getWidth() / 2;
        int i1 = localView2.getLeft() + localView2.getWidth() / 2;
        int i2 = (int)(Math.abs(paramFloat / paramInt2) * (i1 - paramInt1));
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "centerChildCenterX is:" + paramInt1 + ",nextCenterChildCenterX is:" + i1 + ",pdRelativeScrollX is:" + i2);
        }
        this.jdField_b_of_type_AndroidViewViewGroup.scrollTo(this.n + i2, this.jdField_b_of_type_AndroidViewViewGroup.getScrollY());
        if (Math.abs(paramFloat) == paramInt2) {
          a(this.jdField_b_of_type_AndroidViewViewGroup, localView2, -8355712, -15158044);
        }
      }
      return;
      if (paramFloat > 0.0F) {
        paramInt1 = this.o + 1;
      } else {
        paramInt1 = this.o;
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "onPageSelected() is called,position is:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt, this.jdField_b_of_type_Boolean);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setCurrentPannel(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= 3)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() != paramInt)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(paramInt);
        requestLayout();
        a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), -8355712, -15158044);
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.jdField_a_of_type_Boolean);
    this.p = (-paramInt);
  }
  
  public void setStatus(int paramInt)
  {
    this.j = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setStatus(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel
 * JD-Core Version:    0.7.0.1
 */