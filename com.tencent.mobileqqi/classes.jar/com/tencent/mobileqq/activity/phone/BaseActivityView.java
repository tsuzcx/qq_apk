package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import eol;
import eom;
import eon;
import eoo;
import eop;
import eoq;

@SuppressLint({"ViewConstructor"})
public class BaseActivityView
  extends FrameLayout
{
  public static final int a = 1;
  static final long jdField_a_of_type_Long = 120000L;
  public static final int b = 2;
  static final int jdField_c_of_type_Int = 1;
  static final int jdField_d_of_type_Int = 2;
  static final int e = 3;
  public Activity a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View a;
  protected ImageView a;
  public TextView a;
  private PhoneInnerFrame jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame;
  public PhoneContactManagerImp a;
  public QQAppInterface a;
  public QQProgressDialog a;
  private eoq jdField_a_of_type_Eoq;
  protected boolean a;
  protected View b;
  protected TextView b;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  protected TextView c;
  public boolean c;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  
  public BaseActivityView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    if ((paramContext instanceof PhoneFrameActivity)) {
      this.jdField_a_of_type_AndroidAppActivity = ((PhoneFrameActivity)paramContext);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidViewView.getHeight();
  }
  
  private void a(BaseActivityView.IPhoneContext paramIPhoneContext)
  {
    this.jdField_c_of_type_AndroidWidgetTextView = paramIPhoneContext.a();
    this.jdField_d_of_type_AndroidWidgetTextView = paramIPhoneContext.d();
    this.jdField_a_of_type_AndroidViewView = paramIPhoneContext.a();
    this.jdField_b_of_type_AndroidViewView = paramIPhoneContext.b();
    this.jdField_a_of_type_AndroidWidgetImageView = paramIPhoneContext.a();
    this.jdField_a_of_type_AndroidWidgetTextView = paramIPhoneContext.b();
    this.jdField_b_of_type_AndroidWidgetTextView = paramIPhoneContext.c();
  }
  
  private void j()
  {
    DialogUtil.a(getContext(), 231, getResources().getString(2131558949), getResources().getString(2131558950), new eop(this), null).show();
  }
  
  protected View a(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return this.jdField_c_of_type_AndroidViewView.findViewById(paramInt);
    }
    return findViewById(paramInt);
  }
  
  protected void a()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558947));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561746);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("取消本次转发");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new eol(this));
      this.jdField_d_of_type_Boolean = false;
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558947));
      }
      else
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558948));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838030);
      }
    }
  }
  
  protected final void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, long paramLong)
  {
    if (!a())
    {
      b(paramInt);
      this.jdField_a_of_type_Eoq.sendEmptyMessageDelayed(2, paramLong);
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Eoq;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localObject = ((eoq)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Eoq.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
  }
  
  protected final void a(int paramInt, boolean paramBoolean)
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    if (paramBoolean)
    {
      BounceScrollView localBounceScrollView = (BounceScrollView)localLayoutInflater.inflate(2130903099, null);
      this.jdField_c_of_type_AndroidViewView = localLayoutInflater.inflate(paramInt, null);
      localBounceScrollView.addView(this.jdField_c_of_type_AndroidViewView);
      addView(localBounceScrollView);
      return;
    }
    localLayoutInflater.inflate(paramInt, this, true);
  }
  
  public final void a(Intent paramIntent)
  {
    b(paramIntent, 0);
  }
  
  protected final void a(Intent paramIntent, int paramInt)
  {
    b(paramIntent, paramInt);
  }
  
  public void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    if (paramIntent != null) {
      this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("call_by_select_member", false);
    }
    this.jdField_a_of_type_Eoq = new eoq(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame = paramPhoneInnerFrame;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
    paramIntent = paramPhoneInnerFrame.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramIntent.a();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    a(paramIntent);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (!a()) {
      DialogUtil.a(getContext(), 231, paramString1, paramString2, new eom(this), null).show();
    }
  }
  
  protected boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b() {}
  
  protected void b(int paramInt)
  {
    b(getResources().getString(paramInt));
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if ((!a()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getContext(), a());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new eon(this));
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnKeyListener(new eoo(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  protected final void b(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame.a(paramIntent, paramInt);
  }
  
  public void b(String paramString)
  {
    if (!a()) {
      QQToast.a(getContext(), 0, paramString, 0).b(a());
    }
  }
  
  protected void c() {}
  
  public void d()
  {
    this.jdField_d_of_type_Boolean = true;
    g();
  }
  
  public void e() {}
  
  public void f()
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame.f();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Eoq.removeMessages(1);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  public void h()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837860);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      this.jdField_a_of_type_Eoq.removeMessages(3);
      this.jdField_a_of_type_Eoq.sendEmptyMessageDelayed(3, 120000L);
    }
  }
  
  public void i()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_a_of_type_Eoq.removeMessages(3);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BaseActivityView
 * JD-Core Version:    0.7.0.1
 */