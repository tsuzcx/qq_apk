package com.tencent.mobileqq.activity.phone;

import ahgq;
import akwl;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import zqy;

public class PhoneInnerFrame
  extends InnerFrame
{
  private PhoneLaunchView jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView;
  private PhoneMatchView jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView;
  private BaseActivityView.a jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$a;
  private BaseActivityView jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView;
  private ContactListView jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView;
  public boolean isResume;
  private akwl j;
  private int reqType = 0;
  
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
    if (this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != paramBaseActivityView)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null)
      {
        if (this.isResume) {
          this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.onPause();
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.onStop();
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = paramBaseActivityView;
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.a(paramIntent, this);
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.onStart();
      if (this.isResume) {
        this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.onResume();
      }
      setContentView(this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView);
    }
  }
  
  private void cF(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = new PhoneMatchView(getActivity(), this.reqType);
    }
    a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView);
  }
  
  private void cG(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = new PhoneLaunchView(getActivity(), this.reqType);
    }
    a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView);
  }
  
  private void showListView()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView == null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView = new ContactListView(getContext(), this.reqType);
    }
    a(null, this.jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView);
  }
  
  public ahgq a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView != null) {
      return this.jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView.a;
    }
    return null;
  }
  
  protected BaseActivityView.a a()
  {
    return null;
  }
  
  public final BaseActivityView.a b()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$a == null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$a = a();
    }
    return this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$a;
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    if (paramBundle != null) {
      this.reqType = paramBundle.getInt("key_req_type");
    }
    crp();
    if (this.j == null)
    {
      this.j = new zqy(this);
      b().getApp().registObserver(this.j);
    }
  }
  
  public void crp()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)b().getApp().getManager(11);
    switch (localPhoneContactManagerImp.xy())
    {
    default: 
      showListView();
      return;
    case 0: 
    case 7: 
    case 8: 
    case 9: 
      showListView();
      return;
    case 1: 
    case 2: 
    case 3: 
      if (this.reqType == 2)
      {
        showListView();
        return;
      }
      cG(null);
      return;
    case 4: 
    case 5: 
      cG(null);
      return;
    }
    if ((localPhoneContactManagerImp.Ut()) || (this.reqType == 2))
    {
      showListView();
      return;
    }
    cF(null);
  }
  
  public void finish()
  {
    a().yW(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = null;
    this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = null;
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.onPause();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView.onPause();
    }
    this.isResume = false;
    super.onPause();
  }
  
  public void onResume()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.onResume();
    }
    this.isResume = true;
    super.onResume();
  }
  
  public void onStop()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.onStop();
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = null;
      removeAllViews();
    }
    if (this.j != null)
    {
      b().getApp().unRegistObserver(this.j);
      this.j = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView.onDestroy();
      this.jdField_b_of_type_ComTencentMobileqqActivityPhoneContactListView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = null;
    }
    super.onStop();
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    getActivity().overridePendingTransition(paramInt1, paramInt2);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getComponent().getClassName();
    if (str.equals(ContactListView.class.getName()))
    {
      showListView();
      return;
    }
    if (str.equals(PhoneLaunchActivity.class.getName()))
    {
      cG(paramIntent);
      return;
    }
    if (str.equals(PhoneMatchView.class.getName()))
    {
      cF(null);
      return;
    }
    getActivity().startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneInnerFrame
 * JD-Core Version:    0.7.0.1
 */