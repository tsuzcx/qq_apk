package com.tencent.mobileqq.activity.contact.connections;

import acfd;
import achg;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.b;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.d;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import yrf;
import yrg;
import yrh;

public class ConnectionsExplorationFragment
  extends PublicBaseFragment
  implements ViewPager.OnPageChangeListener, TabLayoutCompat.b
{
  private TextView BC;
  private TextView LC;
  private achg jdField_a_of_type_Achg;
  private ConnectionsExplorationViewPager jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager;
  private ConnectionsViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter;
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private boolean bon = true;
  acfd e = new yrg(this);
  private QQAppInterface mApp;
  private LinearLayout mContent;
  private ArrayList<yrh> mTabs = new ArrayList();
  private TextView mTitleTextView;
  
  private void bg(boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.getSubThreadHandler().post(new ConnectionsExplorationFragment.2(this, paramBoolean2, paramBoolean1));
  }
  
  private void ckX()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager != null))
    {
      if (this.mTabs.size() > 1)
      {
        int j = fw(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager.getCurrentItem());
        int i = j;
        if (j == -1) {
          i = fw(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.w(this.mTabs, i);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setVisibility(8);
  }
  
  private int fw(int paramInt)
  {
    if ((this.mTabs != null) && (paramInt < this.mTabs.size()))
    {
      yrh localyrh = (yrh)this.mTabs.get(paramInt);
      if (localyrh != null) {
        return localyrh.tab_id;
      }
    }
    return -1;
  }
  
  private void u(View paramView)
  {
    this.mApp = getActivity().app;
    this.mApp.addObserver(this.e);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131377546);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localLinearLayout.setFitsSystemWindows(true);
      localLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    this.mTitleTextView = ((TextView)paramView.findViewById(2131369627));
    this.mTitleTextView.setVisibility(0);
    this.mTitleTextView.setText(2131689884);
    this.BC = ((TextView)paramView.findViewById(2131369579));
    this.BC.setVisibility(0);
    this.BC.setText("");
    this.BC.setOnClickListener(new yrf(this));
    this.jdField_a_of_type_Achg = ((achg)this.mApp.getManager(159));
    this.mContent = ((LinearLayout)paramView.findViewById(2131370769));
    this.LC = ((TextView)paramView.findViewById(2131366420));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager = ((ConnectionsExplorationViewPager)paramView.findViewById(2131365233));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter = new ConnectionsViewPagerAdapter(getChildFragmentManager(), getActivity().app, this.mTabs);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager.setOffscreenPageLimit(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout = ((ThemeTabLayout)paramView.findViewById(2131379154));
    bg(true, false);
    L(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setOnTabSelectedListener(this);
  }
  
  public void L(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public void a(TabLayoutCompat.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onTabSelected mCurrentTabPos:" + paramd.getPosition());
    }
    if (this.bon) {
      this.bon = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationViewPager.setCurrentItem(paramd.getPosition(), false);
      return;
      anot.a(this.mApp, "dc00898", "", "", "frd_recom", "frd_tab_clk", fw(paramd.getPosition()), 0, "0", "4", "", "");
    }
  }
  
  public void b(TabLayoutCompat.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onTabUnselected mCurrentTabPos:" + paramd.getPosition());
    }
  }
  
  public void c(TabLayoutCompat.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onTabReselected mCurrentTabPos:" + paramd.getPosition());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561502, paramViewGroup, false);
    u(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter.doOnDestroy();
    }
    this.mApp.removeObserver(this.e);
    super.onDestroy();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsExplorationFragment", 2, "onPageSelected mCurrentTabPos:" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsViewPagerAdapter.onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment
 * JD-Core Version:    0.7.0.1
 */