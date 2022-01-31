package com.tencent.mobileqq.activity.phone;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.voip.VoipAddressBookActivity;
import com.tencent.mobileqq.activity.voip.VoipAddressBookView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import eqd;

public class PhoneInnerFrame
  extends InnerFrame
{
  private BaseActivityView.IPhoneContext jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext;
  private BaseActivityView jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView;
  public ContactListView a;
  private PhoneLaunchView jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView;
  private PhoneMatchView jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView;
  public VoipAddressBookActivity a;
  public VoipAddressBookView a;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public boolean a;
  boolean b;
  boolean c;
  public boolean d;
  
  public PhoneInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public PhoneInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Intent paramIntent, BaseActivityView paramBaseActivityView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != paramBaseActivityView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null)
      {
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.c();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.d();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = paramBaseActivityView;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.a(paramIntent, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.a();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.b();
      }
      setContentView(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView);
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = new PhoneMatchView(a(), this.b);
    }
    a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView);
  }
  
  private void c(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = new PhoneLaunchView(a(), this.b);
    }
    a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookView = new VoipAddressBookView(a(), this.b);
    }
    a(null, this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookView);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookActivity.d();
    }
  }
  
  private void i()
  {
    h();
  }
  
  public ForwardOperations a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.a;
    }
    return null;
  }
  
  protected BaseActivityView.IPhoneContext a()
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.b();
    }
    this.jdField_a_of_type_Boolean = true;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a().overridePendingTransition(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getComponent().getClassName();
    if (str.equals(ContactListView.class.getName()))
    {
      i();
      return;
    }
    if (str.equals(PhoneLaunchActivity.class.getName()))
    {
      c(paramIntent);
      return;
    }
    if (str.equals(PhoneMatchView.class.getName()))
    {
      b(null);
      return;
    }
    a().startActivityForResult(paramIntent, paramInt);
  }
  
  public final BaseActivityView.IPhoneContext b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext = a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.c();
    }
    this.jdField_a_of_type_Boolean = false;
    super.b();
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    if (paramBundle != null)
    {
      this.b = paramBundle.getBoolean("call_by_forward");
      this.c = paramBundle.getBoolean("call_by_select_member");
    }
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new eqd(this);
      b().a().registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    ((PhoneContactManager)b().a().getManager(10)).b();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.d();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = null;
      removeAllViews();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      b().a().unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = null;
    }
    super.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = null;
    super.d();
  }
  
  public void f()
  {
    a().a(0);
  }
  
  public void g()
  {
    Object localObject = (PhoneContactManagerImp)b().a().getManager(10);
    switch (((PhoneContactManagerImp)localObject).b())
    {
    case 5: 
    default: 
      i();
      return;
    case 0: 
    case 4: 
    case 6: 
    case 7: 
      i();
      return;
    case 1: 
    case 2: 
      if (this.c)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("call_by_select_member", true);
        c((Intent)localObject);
        return;
      }
      c(null);
      return;
    }
    if (((PhoneContactManagerImp)localObject).i())
    {
      i();
      return;
    }
    if (this.c)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("call_by_select_member", true);
      b((Intent)localObject);
      return;
    }
    b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneInnerFrame
 * JD-Core Version:    0.7.0.1
 */