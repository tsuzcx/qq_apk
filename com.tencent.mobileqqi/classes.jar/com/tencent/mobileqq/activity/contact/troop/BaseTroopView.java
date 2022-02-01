package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.WeakReferenceHandler;
import efm;

public class BaseTroopView
  extends FrameLayout
{
  protected int a;
  public Dialog a;
  View a;
  protected BaseTroopView.ITroopContext a;
  public QQAppInterface a;
  protected boolean a;
  public View b;
  public boolean b;
  View c;
  View d;
  private View e;
  
  public BaseTroopView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
  }
  
  protected Dialog a()
  {
    return null;
  }
  
  protected View a(int paramInt)
  {
    if (this.e != null) {
      return this.e.findViewById(paramInt);
    }
    return findViewById(paramInt);
  }
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
    setBackgroundDrawable(null);
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().overridePendingTransition(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(paramInt, paramBoolean);
  }
  
  protected void a(Intent paramIntent)
  {
    b(paramIntent, 0);
  }
  
  protected final void a(Intent paramIntent, int paramInt)
  {
    b(paramIntent, paramInt);
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext = paramITroopContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.c();
    this.c = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
    this.d = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.d();
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBusinessObserver);
    }
  }
  
  public final void a(String paramString)
  {
    if (!b()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(paramString);
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public final void b(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  protected final void b(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().startActivityForResult(paramIntent, paramInt);
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(paramBusinessObserver);
    }
  }
  
  protected final boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void e() {}
  
  protected void f() {}
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void h() {}
  
  protected void i()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().finish();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    do
    {
      return;
      Contacts.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_AndroidAppDialog = a();
    } while (this.jdField_a_of_type_AndroidAppDialog == null);
    int i = this.jdField_b_of_type_AndroidViewView.getVisibility();
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog.show();
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new efm(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.BaseTroopView
 * JD-Core Version:    0.7.0.1
 */