package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.LebaConfig;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import csp;
import csr;
import cst;
import csv;

public class LebaListMgrActivity
  extends IphoneTitleBarActivity
{
  private LebaListMgrAdapter jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter;
  protected RedTouchObserver a;
  public DownloadIconsListener a;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new csr(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public LebaListMgrActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppRedTouchObserver = new cst(this);
    this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener = new csv(this);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2130903587, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      View localView = View.inflate(this, 2130903586, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter = new LebaListMgrAdapter(this.b, this, LebaShowListManager.a().a());
    }
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter);
    setTitle(2131562971);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "initUi, " + LebaShowListManager.a().a);
    }
    this.b.o();
    if (!LebaShowListManager.a().a) {
      ThreadManager.b(new csp(this));
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    LebaShowListManager.c |= 0x1;
    d();
    this.b.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.b.a(this.jdField_a_of_type_ComTencentMobileqqAppRedTouchObserver, true);
    paramBundle = this.b.a();
    if (paramBundle != null) {
      paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter = null;
    this.b.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.b.c(this.jdField_a_of_type_ComTencentMobileqqAppRedTouchObserver);
    LebaConfig localLebaConfig = this.b.a();
    if (localLebaConfig != null) {
      localLebaConfig.b(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaListMgrActivity
 * JD-Core Version:    0.7.0.1
 */