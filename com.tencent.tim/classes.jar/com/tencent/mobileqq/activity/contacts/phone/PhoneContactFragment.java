package com.tencent.mobileqq.activity.contacts.phone;

import ajdo.a;
import akwl;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import auru;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;
import ysf;
import ysf.a;
import zaz;

public class PhoneContactFragment
  extends ContactsBaseFragment
  implements ajdo.a, ysf.a
{
  protected a a;
  protected PhoneContactStatusCheckView a;
  protected zaz a;
  protected boolean aUE;
  protected FrameLayout bi;
  private Runnable eT = new PhoneContactFragment.2(this);
  private Runnable eU = new PhoneContactFragment.3(this);
  protected Handler mHandler = new auru(Looper.getMainLooper(), null);
  protected XListView mListView;
  protected View rootView;
  
  public PhoneContactFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment$a = new a(null);
  }
  
  public void Av(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "doOnResume:" + paramBoolean);
    }
    if (this.mListView == null) {
      return;
    }
    if (paramBoolean) {
      bpM();
    }
    if (this.jdField_a_of_type_Zaz == null)
    {
      this.jdField_a_of_type_Zaz = new zaz(this.mActivity, this.mApp, this.mListView, 1, true, this);
      this.mListView.setAdapter(this.jdField_a_of_type_Zaz);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.cro();
    ThreadManager.excute(new PhoneContactFragment.1(this), 16, null, true);
  }
  
  public void Aw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "doOnPause:" + paramBoolean);
    }
    if (paramBoolean) {
      bpN();
    }
  }
  
  public void Az(int paramInt) {}
  
  public void Bi(boolean paramBoolean)
  {
    super.Bi(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.Bi(paramBoolean);
    }
  }
  
  public void T(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "onRecommendCountChanged " + paramBoolean + " " + paramInt);
    }
    resetData();
  }
  
  public boolean UX()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.getVisibility() == 0);
  }
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (this.rootView == null)
    {
      this.rootView = paramLayoutInflater.inflate(2131559080, null, false);
      this.mListView = ((XListView)this.rootView.findViewById(2131373050));
      this.bi = new FrameLayout(this.rootView.getContext());
      paramLayoutInflater = new AbsListView.LayoutParams(-1, -2);
      this.bi.setLayoutParams(paramLayoutInflater);
      this.mListView.addHeaderView(this.bi);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView = new PhoneContactStatusCheckView(this.rootView.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.setOrientation(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.setGravity(17);
      int i = getResources().getDimensionPixelSize(2131297876);
      paramLayoutInflater = new FrameLayout.LayoutParams(-1, i);
      paramLayoutInflater.gravity = 17;
      if (bq != null) {
        paramLayoutInflater.height = Math.max(i, bq.bottom - bq.top);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.setLayoutParams(paramLayoutInflater);
      this.bi.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView, paramLayoutInflater);
      this.mListView.setSelector(new ColorDrawable(0));
      this.mListView.setNeedCheckSpringback(true);
      this.mListView.setCacheColorHint(0);
      this.mListView.setDivider(null);
      this.mListView.setOverScrollMode(0);
      this.mListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.setPhoneContactFragment(this);
    }
    for (;;)
    {
      return this.rootView;
      paramLayoutInflater = this.rootView.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.rootView);
      }
    }
  }
  
  public void bLU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "onMayKnowStatesChanged");
    }
    resetData();
  }
  
  public void bLV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "onContactCountChanged");
    }
    resetData();
  }
  
  public void bpM()
  {
    if ((this.mApp != null) && (this.mk))
    {
      ((PhoneContactManagerImp)this.mApp.getManager(11)).a(this);
      this.mApp.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment$a);
      ((ysf)this.mApp.getManager(34)).a(this);
    }
  }
  
  public void bpN()
  {
    if (this.mApp != null)
    {
      ((PhoneContactManagerImp)this.mApp.getManager(11)).b(this);
      this.mApp.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment$a);
      ((ysf)this.mApp.getManager(34)).b(this);
    }
    if (this.mListView != null) {
      this.mListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Zaz != null)
    {
      this.jdField_a_of_type_Zaz.clearData();
      this.jdField_a_of_type_Zaz.destroy();
      this.jdField_a_of_type_Zaz = null;
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "doOnDestroy");
    }
    bpN();
  }
  
  public View e()
  {
    return this.mListView;
  }
  
  public void eH(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "onUIBitsChanged " + paramLong);
    }
    resetData();
  }
  
  public void refresh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "refresh");
    }
    resetData();
    ((PhoneContactManagerImp)this.mApp.getManager(11)).i(true, false, 16);
    this.aUE = true;
  }
  
  public void resetData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "resetData  mIsTabSelected:" + this.mk);
    }
    if (this.mk)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.eU);
      ThreadManager.getSubThreadHandler().post(this.eU);
    }
    while (this.jdField_a_of_type_Zaz == null) {
      return;
    }
    this.jdField_a_of_type_Zaz.bo(this.mApp);
  }
  
  public void sc(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "onBindStateChanged " + paramInt);
    }
    resetData();
  }
  
  public void sd(int paramInt) {}
  
  public void se(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "onUpdateContactList " + paramInt);
    }
    resetData();
  }
  
  class a
    extends akwl
  {
    private a() {}
    
    private void Bl(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactFragment", 2, String.format("refreshResult [%s]", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      if (PhoneContactFragment.this.aUE)
      {
        if (PhoneContactFragment.a(PhoneContactFragment.this) != null) {
          PhoneContactFragment.b(PhoneContactFragment.this).d(PhoneContactFragment.this.xZ(), paramBoolean, null);
        }
        if (paramBoolean) {
          PhoneContactFragment.this.resetData();
        }
        PhoneContactFragment.this.aUE = false;
      }
    }
    
    public void aJ(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactFragment", 2, String.format("onQueryBindState [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
      }
      Bl(paramBoolean1);
    }
    
    public void xp(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactFragment", 2, String.format("onHideContact [%s]", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      PhoneContactFragment.this.resetData();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment
 * JD-Core Version:    0.7.0.1
 */