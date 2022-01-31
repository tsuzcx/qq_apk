package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.BounceScrollView;
import java.util.Observable;
import java.util.Observer;

public class BaseNewFriendView
  extends FrameLayout
  implements Observer
{
  private int jdField_a_of_type_Int;
  protected Intent a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  protected BaseNewFriendView.INewFriendContext a;
  public QQAppInterface a;
  protected boolean a;
  View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = false;
  private boolean e;
  
  public BaseNewFriendView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected View a(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return this.jdField_c_of_type_AndroidViewView.findViewById(paramInt);
    }
    return findViewById(paramInt);
  }
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    a(getResources().getString(paramInt1), paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((20000 == paramInt1) && (paramInt2 != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a().setResult(paramInt2, paramIntent);
      i();
    }
  }
  
  protected final void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    if (!a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a(paramInt, paramBoolean);
  }
  
  protected void a(Intent paramIntent)
  {
    b(paramIntent, 0);
  }
  
  protected final void a(Intent paramIntent, int paramInt)
  {
    b(paramIntent, paramInt);
  }
  
  protected void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    if (paramIntent != null) {
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("call_by_forward", false);
    }
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext = paramINewFriendContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.b();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a();
    if (this.jdField_c_of_type_Boolean) {
      b(true);
    }
  }
  
  protected final void a(String paramString, int paramInt)
  {
    if (!a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a(paramString, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a(paramBoolean);
  }
  
  protected final boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected final void b()
  {
    this.d = true;
    if (!a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a();
    }
  }
  
  protected final void b(int paramInt)
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    BounceScrollView localBounceScrollView = (BounceScrollView)localLayoutInflater.inflate(2130903078, null);
    this.jdField_c_of_type_AndroidViewView = localLayoutInflater.inflate(paramInt, null);
    localBounceScrollView.addView(this.jdField_c_of_type_AndroidViewView);
    addView(localBounceScrollView);
  }
  
  protected final void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a().overridePendingTransition(paramInt1, paramInt2);
  }
  
  protected final void b(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a().startActivityForResult(paramIntent, paramInt);
  }
  
  protected void b(boolean paramBoolean)
  {
    NewFriendManager localNewFriendManager = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a().getManager(31);
    if (paramBoolean)
    {
      localNewFriendManager.addObserver(this);
      return;
    }
    localNewFriendManager.deleteObserver(this);
  }
  
  protected final void c()
  {
    this.d = false;
    if (!a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.b();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  protected void d()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.d) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(this.e);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.b();
    }
  }
  
  protected void e() {}
  
  protected void f() {}
  
  protected void g()
  {
    c();
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void h()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      b(false);
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  protected void i()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a().finish();
  }
  
  public void update(Observable paramObservable, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView
 * JD-Core Version:    0.7.0.1
 */