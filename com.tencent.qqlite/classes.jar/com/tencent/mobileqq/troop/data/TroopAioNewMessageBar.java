package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.utils.MsgUtils;
import eme;
import emf;

public class TroopAioNewMessageBar
  extends TroopAioAgent
  implements Animation.AnimationListener
{
  private static int d = 1;
  private static int e = 2;
  private static int f = 0;
  private static int g = 1;
  private static int h = 2;
  private static int i = 3;
  private static int j = 0;
  private float jdField_a_of_type_Float = 0.0F;
  private Handler jdField_a_of_type_AndroidOsHandler = new eme(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  public LinearLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  public LinearLayout b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  public boolean b;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation = null;
  private boolean jdField_c_of_type_Boolean = false;
  private int k = 0;
  private int l = f;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  
  public TroopAioNewMessageBar()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Object localObject;
    if (paramInt == e)
    {
      paramTextView.setText(2131362499);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838218, 0);
      paramTextView.setCompoundDrawablePadding(4);
      paramTextView.setGravity(17);
      localObject = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != d);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramTextView.setGravity(19);
      localObject = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -1;
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    } while (localObject == null);
    MsgSummary localMsgSummary = new MsgSummary();
    MsgUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (QQMessageFacade.Message)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMsgSummary, ((QQMessageFacade.Message)localObject).nickName, false, false);
    paramTextView.setText(localMsgSummary.a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.k = paramInt;
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(j);
    if (this.l == f)
    {
      a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
      this.l = g;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      }
    }
    do
    {
      return;
      if (this.l == g)
      {
        a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
        return;
      }
      if (this.l == h)
      {
        a(this.jdField_b_of_type_AndroidWidgetTextView, paramInt);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
          return;
        }
        a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
        return;
      }
    } while (this.l != i);
    f();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
    this.l = g;
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131296315);
      Object localObject = new RelativeLayout.LayoutParams(-1, this.m);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131296663);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131296355);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130837676);
      localObject = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      setChanged();
      notifyObservers(TroopAioAgent.Message.a(2131296315));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject = new LinearLayout.LayoutParams(-1, this.m * 2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
      ((LinearLayout.LayoutParams)localObject).rightMargin = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296356);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427496));
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetTextView.setId(2131296357);
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(16);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427496));
      localObject = new RelativeLayout.LayoutParams(-1, this.m);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-1, this.m);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131296356);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new emf(this));
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(j);
    if (this.l == g)
    {
      f();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      this.l = i;
    }
    while (this.l != h) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    this.l = i;
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat < -0.2F)
    {
      if (e == this.k) {
        e();
      }
      return;
    }
    if (this.l != f)
    {
      this.jdField_a_of_type_Float = 0.0F;
      return;
    }
    this.jdField_a_of_type_Float += paramFloat;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0) {
      if (paramInt > this.o) {
        b(d);
      }
    }
    for (;;)
    {
      this.o = paramInt;
      return;
      if (this.o > 0) {
        e();
      } else if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.r() < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b() - 11)
      {
        if ((f == this.l) && (this.jdField_c_of_type_Boolean)) {
          b(e);
        }
      }
      else if (e == this.k) {
        e();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = true;
      a(this.o);
      this.jdField_c_of_type_Boolean = false;
    }
    while (e != this.k) {
      return;
    }
    e();
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_AndroidWidgetLinearLayout != null;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Float = 0.0F;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.n = localDisplayMetrics.heightPixels;
    this.m = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131492870));
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, this.m, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.m);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - this.m);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(j);
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      f();
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Float = 0.0F;
    if (paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.l = f;
    }
    do
    {
      do
      {
        return;
        if (!paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) {
          break;
        }
        this.l = h;
      } while (this.k != e);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, j), 3000L);
      return;
    } while (!paramAnimation.equals(this.jdField_c_of_type_AndroidViewAnimationAnimation));
    a(this.jdField_a_of_type_AndroidWidgetTextView, this.k);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioNewMessageBar
 * JD-Core Version:    0.7.0.1
 */