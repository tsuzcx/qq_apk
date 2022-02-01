package com.tencent.mobileqq.activity.contacts.troop;

import acbo;
import accd;
import acfd;
import achq;
import acms;
import acnd;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import anov;
import apwk;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;
import wja;
import zam;
import zco;
import zcp;

public class TroopFragment
  extends ContactsBaseFragment
  implements View.OnClickListener
{
  protected apwk a;
  public ContactsTroopAdapter a;
  protected a a;
  protected b a;
  protected c a;
  protected SwipPinnedHeaderExpandableListView a;
  private acbo b;
  protected accd b;
  protected boolean bpK;
  protected boolean bqJ;
  
  public TroopFragment()
  {
    this.jdField_b_of_type_Accd = new zco(this);
    this.jdField_b_of_type_Acbo = new zcp(this);
  }
  
  private void resetAdapter()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.destroy();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter = new ContactsTroopAdapter(this.mActivity, this.mApp, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnGroupClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter);
    }
  }
  
  public void Av(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onResume:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView == null) {
      return;
    }
    if (paramBoolean) {
      bpM();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter == null) {
      resetAdapter();
    }
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new TroopFragment.1(this), 200L);
    this.bqJ = true;
    this.jdField_a_of_type_Apwk.start();
    new anov(this.mApp).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp").report();
  }
  
  public void Aw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onPause");
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null) {
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.AP();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.pause();
    }
    if (paramBoolean) {
      bpN();
    }
    if (this.bqJ) {
      this.jdField_a_of_type_Apwk.stop();
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "getView");
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = new ContactsPinnedHeaderExpandableListView(this.mActivity);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setId(2131374470);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167595);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, wja.dp2px(54.0F, getResources()));
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnScrollListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Apwk = new apwk(this.mApp, null, "Grp_time", "Grp_contactlist", "visit_time");
      return this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
      paramLayoutInflater = this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.getParent();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView);
      }
    }
  }
  
  public void bMe()
  {
    if ((this.mk) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.pause();
    }
    if (this.jdField_a_of_type_Apwk != null) {
      this.jdField_a_of_type_Apwk.stop();
    }
    super.bMe();
  }
  
  public void bMf()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.cof();
      if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.getFirstVisiblePosition() > 0) {
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelection(0);
      }
    }
  }
  
  public void bOm()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.notifyDataSetChanged();
    }
  }
  
  public void bpM()
  {
    if (this.mk)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$a = new a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$c == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$c = new c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$b == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$b = new b();
      }
      this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$a);
      this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$c);
      this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$b);
      this.mApp.addObserver(this.jdField_b_of_type_Accd);
      this.mApp.addObserver(this.jdField_b_of_type_Acbo);
    }
  }
  
  public void bpN()
  {
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$a);
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$c);
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$b);
    this.mApp.removeObserver(this.jdField_b_of_type_Accd);
    this.mApp.removeObserver(this.jdField_b_of_type_Acbo);
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.destroy();
    }
    bpN();
    if (this.jdField_a_of_type_Apwk != null) {
      this.jdField_a_of_type_Apwk.stop();
    }
  }
  
  public View e()
  {
    return this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void refresh()
  {
    ((acms)this.mApp.getBusinessHandler(20)).cMF();
    this.bpK = true;
  }
  
  public void resetData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "resetData");
    }
    resetAdapter();
    if ((this.mk) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_Apwk = new apwk(this.mApp, null, "Grp_time", "Grp_contactlist", "visit_time");
    if (isResumed()) {
      this.jdField_a_of_type_Apwk.start();
    }
  }
  
  public static class ContactsPinnedHeaderExpandableListView
    extends SwipPinnedHeaderExpandableListView
  {
    private boolean bpL = true;
    
    public ContactsPinnedHeaderExpandableListView(Context paramContext)
    {
      super();
    }
    
    public ContactsPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public ContactsPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
    {
      if (this.bpL) {
        super.a(paramInt1, paramInt2, paramView, paramInt3);
      }
    }
    
    public void setChildViewCanAction(boolean paramBoolean)
    {
      ExpandableListAdapter localExpandableListAdapter = getExpandableListAdapter();
      if ((localExpandableListAdapter instanceof zam)) {
        ((zam)localExpandableListAdapter).setChildViewCanAction(paramBoolean);
      }
      this.bpL = paramBoolean;
    }
  }
  
  public class a
    extends acfd
  {
    protected a() {}
    
    public void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        TroopFragment.this.bOm();
      }
    }
    
    public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
    {
      TroopFragment.this.bOm();
    }
    
    public void onUpdateTroopHead(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        TroopFragment.this.bOm();
      }
    }
  }
  
  public class b
    extends achq
  {
    protected b() {}
    
    public void aoF()
    {
      TroopFragment.this.bOm();
    }
  }
  
  public class c
    extends acnd
  {
    protected c() {}
    
    public void H(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        TroopFragment.this.bOm();
      }
    }
    
    public void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
    {
      if (paramBoolean) {
        TroopFragment.this.bOm();
      }
    }
    
    public void d(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
    {
      if (paramBoolean) {
        TroopFragment.this.bOm();
      }
    }
    
    public void di(String paramString1, String paramString2)
    {
      if (TroopFragment.this.a != null) {
        TroopFragment.this.a.cnv();
      }
    }
    
    public void jc(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.TroopFragment", 2, "onUpdateTroopList " + paramBoolean);
      }
      if (TroopFragment.this.bpK)
      {
        TroopFragment.this.bpK = false;
        if (TroopFragment.a(TroopFragment.this) != null) {
          TroopFragment.b(TroopFragment.this).d(TroopFragment.this.xZ(), paramBoolean, null);
        }
      }
      ThreadManager.getUIHandler().postDelayed(new TroopFragment.MyTroopObserver.1(this), 500L);
    }
    
    public void q(int paramInt1, int paramInt2, String paramString)
    {
      if (paramInt1 == 6) {
        if (paramInt2 == 0) {
          TroopFragment.this.bOm();
        }
      }
      do
      {
        do
        {
          return;
          if (paramInt1 != 2) {
            break;
          }
        } while (paramInt2 != 0);
        TroopFragment.this.bOm();
        return;
      } while ((paramInt1 != 9) || (paramInt2 != 0));
      TroopFragment.this.bOm();
    }
    
    public void xj(boolean paramBoolean)
    {
      if (paramBoolean) {
        TroopFragment.this.bOm();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.TroopFragment
 * JD-Core Version:    0.7.0.1
 */