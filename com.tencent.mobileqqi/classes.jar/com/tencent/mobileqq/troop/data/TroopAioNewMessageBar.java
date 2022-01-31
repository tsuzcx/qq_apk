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
import gzi;
import gzj;

public class TroopAioNewMessageBar
  extends TroopAioAgent
  implements Animation.AnimationListener
{
  private static int jdField_c_of_type_Int = 1;
  private static int d = 2;
  private static int e = 0;
  private static int f = 1;
  private static int g = 2;
  private static int h = 3;
  private static int i = 0;
  private float jdField_a_of_type_Float = 0.0F;
  private Handler jdField_a_of_type_AndroidOsHandler = new gzi(this);
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
  private int j = 0;
  private int k = e;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  
  public TroopAioNewMessageBar()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Object localObject;
    if (paramInt == d)
    {
      paramTextView.setText(2131560614);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838330, 0);
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
      } while (paramInt != jdField_c_of_type_Int);
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
    this.j = paramInt;
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(i);
    if (this.k == e)
    {
      a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
      this.k = f;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      }
    }
    do
    {
      return;
      if (this.k == f)
      {
        a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
        return;
      }
      if (this.k == g)
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
    } while (this.k != h);
    f();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
    this.k = f;
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131230788);
      Object localObject = new RelativeLayout.LayoutParams(-1, this.l);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131231201);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131230825);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130837757);
      localObject = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      setChanged();
      notifyObservers(TroopAioAgent.Message.a(2131230788));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject = new LinearLayout.LayoutParams(-1, this.l * 2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
      ((LinearLayout.LayoutParams)localObject).rightMargin = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131230826);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131362095));
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetTextView.setId(2131230827);
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(16);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131362095));
      localObject = new RelativeLayout.LayoutParams(-1, this.l);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-1, this.l);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131230826);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new gzj(this));
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(i);
    if (this.k == f)
    {
      f();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      this.k = h;
    }
    while (this.k != g) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    this.k = h;
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
      if (d == this.j) {
        e();
      }
      return;
    }
    if (this.k != e)
    {
      this.jdField_a_of_type_Float = 0.0F;
      return;
    }
    this.jdField_a_of_type_Float += paramFloat;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0) {
      if (paramInt > this.n) {
        b(jdField_c_of_type_Int);
      }
    }
    for (;;)
    {
      this.n = paramInt;
      return;
      if (this.n > 0) {
        e();
      } else if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.r() < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a() - 11)
      {
        if ((e == this.k) && (this.jdField_c_of_type_Boolean)) {
          b(d);
        }
      }
      else if (d == this.j) {
        e();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = true;
      a(this.n);
      this.jdField_c_of_type_Boolean = false;
    }
    while (d != this.j) {
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
    this.m = localDisplayMetrics.heightPixels;
    this.l = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131427357));
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, this.l, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.l);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - this.l);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(i);
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
      this.k = e;
    }
    do
    {
      do
      {
        return;
        if (!paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) {
          break;
        }
        this.k = g;
      } while (this.j != d);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, i), 3000L);
      return;
    } while (!paramAnimation.equals(this.jdField_c_of_type_AndroidViewAnimationAnimation));
    a(this.jdField_a_of_type_AndroidWidgetTextView, this.j);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioNewMessageBar
 * JD-Core Version:    0.7.0.1
 */