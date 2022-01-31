package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class ContactBaseView
  extends FrameLayout
{
  protected Context a;
  protected ContactBaseView.IAddContactContext a;
  protected QQAppInterface a;
  
  public ContactBaseView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext = paramIAddContactContext;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramIAddContactContext.a();
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131493138);
  }
  
  protected void a() {}
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e() {}
  
  protected void f() {}
  
  protected void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
 * JD-Core Version:    0.7.0.1
 */