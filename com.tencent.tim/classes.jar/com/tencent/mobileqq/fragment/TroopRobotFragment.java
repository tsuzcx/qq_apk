package com.tencent.mobileqq.fragment;

import abfr;
import acfp;
import acms;
import acnd;
import ahpc;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import anot;
import aptu;
import aptv;
import aptw;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.widget.AddedRobotView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopRobotFragment
  extends IphoneTitleBarFragment
{
  abfr jdField_a_of_type_Abfr;
  private AddedRobotView jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView;
  acnd b = new ahpc(this);
  private boolean bCh;
  private XListView mListView;
  private String mTroopUin;
  
  private Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  private void jU(long paramLong)
  {
    if (getActivity() == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = getActivity().app;
      } while (localObject == null);
      localObject = ((aptw)((QQAppInterface)localObject).getManager(203)).a(paramLong);
    } while (getActivity() == null);
    getActivity().runOnUiThread(new TroopRobotFragment.2(this, (aptu)localObject));
  }
  
  public void d(ArrayList<aptv> paramArrayList1, ArrayList<aptv> paramArrayList2, int paramInt)
  {
    if ((this.mListView != null) && (this.mListView.getVisibility() != 0)) {
      this.mListView.setVisibility(0);
    }
    if (this.jdField_a_of_type_Abfr != null) {
      this.jdField_a_of_type_Abfr.setData(paramArrayList2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView.setAddList(paramArrayList1, paramInt, this.mTroopUin);
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mTroopUin = a(getActivity()).getStringExtra("uin");
    this.bCh = a(getActivity()).getBooleanExtra("be_admin_in_the_troop", false);
    paramLayoutInflater = getActivity().getResources().getString(2131721453);
    setTitle(paramLayoutInflater, paramLayoutInflater);
    this.mListView = ((XListView)this.mContentView.findViewById(2131377559));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView = new AddedRobotView(getActivity());
    this.mListView.setVerticalScrollBarEnabled(false);
    this.mListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView);
    this.mListView.setDivider(getResources().getDrawable(2130851428));
    this.jdField_a_of_type_Abfr = new abfr(getActivity().app, getActivity(), this.mListView, this.mTroopUin, this.bCh);
    this.mListView.setAdapter(this.jdField_a_of_type_Abfr);
    getActivity().addObserver(this.b);
    if ((AppSetting.enableTalkBack) && (this.leftView != null)) {
      this.leftView.setContentDescription(acfp.m(2131716105));
    }
    anot.a(getActivity().app, "dc00898", "", "", "", "0X8009F9D", 0, 0, "", "", "", "");
  }
  
  public void dpm()
  {
    QLog.d("TroopRobotFragment", 2, "getRobotLisFromServer");
    try
    {
      l = Long.parseLong(this.mTroopUin);
      ((acms)getActivity().app.getBusinessHandler(20)).hY(l);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopRobotFragment", 2, "parseLong err", localException);
        }
        long l = 0L;
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131560858;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Abfr != null)
    {
      this.jdField_a_of_type_Abfr.destroy();
      this.jdField_a_of_type_Abfr = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView.Destroy();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView = null;
    }
    getActivity().removeObserver(this.b);
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("TroopRobotFragment", 2, "onResume");
    dpm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TroopRobotFragment
 * JD-Core Version:    0.7.0.1
 */