package com.tencent.mobileqq.extendfriend.fragment;

import afsi;
import afsr;
import afth.a;
import afug;
import afuh;
import afui;
import afuj;
import afuk;
import aful;
import afwd;
import afxv;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqnm;
import auru;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendBottomBarView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.TipsType;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.b;
import cooperation.qzone.api.FeedListView.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jll;

public class ExtendFriendCampusFragment
  extends afwd
  implements afth.a, Handler.Callback, ViewTreeObserver.OnGlobalLayoutListener, ExtendFriendSearchBarView.a, AbsListView.e, FeedListView.b, FeedListView.c
{
  private static final int cUC = aqnm.dpToPx(60.0F);
  private TextView RK;
  private afsi jdField_a_of_type_Afsi;
  private ExtendFriendBottomBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView;
  private ExtendFriendFeedBannerView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView;
  private ExtendFriendSearchBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView;
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private ExtendFriendCampusVerifyTipsView b;
  private afsr c = new afug(this);
  private Handler cO;
  private int cUD;
  private boolean caT = true;
  private boolean caU;
  private LinearLayout iK;
  private FragmentActivity mActivity;
  private QQAppInterface mApp;
  private View mEmptyView;
  private String mSearchKey = afsi.DEFAULT_TAG;
  
  private void K(String paramString, List<Long> paramList)
  {
    if ((afsi.DEFAULT_TAG.equals(paramString)) || (TextUtils.isEmpty(paramString)))
    {
      paramString = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramString.add(String.valueOf((Long)paramList.next()));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView != null)
      {
        int i = this.jdField_a_of_type_Afsi.DB();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.p(i, paramString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.kC(paramString);
      }
    }
  }
  
  private void Tc()
  {
    if (this.iK == null)
    {
      boolean bool = ((afsi)this.mApp.getManager(264)).akb();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendCampusFragment", 2, String.format("initHeaderView mTabPos=%s limitChatSwitch=%s", new Object[] { Integer.valueOf(this.cUR), Boolean.valueOf(bool) }));
      }
      if (this.cUR == 0)
      {
        this.iK = new LinearLayout(this.mActivity);
        this.iK.setOrientation(1);
        if (bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView = new ExtendFriendFeedBannerView(this.mActivity);
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.a(this.mApp, this);
          localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          localLayoutParams.topMargin = ((int)jll.dp2px(this.mActivity, 10.0F));
          this.iK.addView(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView, localLayoutParams);
          this.caU = true;
          anot.a(this.mApp, "dc00898", "", "", "0X80096A4", "0X80096A4", 0, 0, "", "", "", "");
        }
        this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView = new ExtendFriendCampusVerifyTipsView(this.mActivity);
        this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView.setOnClickListener(new aful(this));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.topMargin = ((int)jll.dp2px(this.mActivity, 10.0F));
        localLayoutParams.leftMargin = ((int)jll.dp2px(this.mActivity, 8.0F));
        localLayoutParams.rightMargin = ((int)jll.dp2px(this.mActivity, 8.0F));
        this.iK.addView(this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView, localLayoutParams);
        dcr();
      }
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.addHeaderView(this.iK, 2);
    }
  }
  
  private void dco()
  {
    if (this.iK != null)
    {
      this.iK.removeAllViews();
      this.iK = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.destroy();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView != null) {
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView = null;
    }
  }
  
  private void dcp()
  {
    if ((this.caU) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null))
    {
      boolean bool = true;
      if (this.jdField_a_of_type_CooperationQzoneApiFeedListView.getFirstVisiblePosition() > 0) {
        bool = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.IJ(bool);
      }
    }
  }
  
  private void dcq()
  {
    List localList = null;
    if (this.jdField_a_of_type_Afsi != null) {
      localList = this.jdField_a_of_type_Afsi.Y(1);
    }
    if ((localList != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null))
    {
      if (localList.size() > 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setVisibility(4);
  }
  
  private void dcr()
  {
    Object localObject = (afsi)this.mApp.getManager(264);
    boolean bool = ((afsi)localObject).aka();
    int i = ((afsi)localObject).DA();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusFragment", 2, String.format("updateVerifyTipsView needShowVerifyTips=%s verifyStatus=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
    }
    bool = ExtendFriendCampusVerifyTipsView.e(bool, i);
    localObject = ExtendFriendCampusVerifyTipsView.a(i);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusFragment", 2, String.format("updateVerifyTipsView showVerifyTips=%s tipsType=%s", new Object[] { Boolean.valueOf(bool), localObject }));
    }
    if (this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView != null)
    {
      if (bool)
      {
        this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView.setTipsType((ExtendFriendCampusVerifyTipsView.TipsType)localObject);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView.setVisibility(8);
  }
  
  private void gy(View paramView)
  {
    View localView = paramView.findViewById(2131376025);
    paramView = paramView.findViewById(2131376026);
    if (localView != null)
    {
      localView.setOnTouchListener(new afuj(this, paramView));
      localView.setOnClickListener(new afuk(this));
    }
  }
  
  public void J(String paramString, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusFragment", 2, String.format("onFeedUinChanged tag=%s uinList=%s", new Object[] { paramString, paramList }));
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      Tc();
    }
    K(paramString, paramList);
  }
  
  public void dca()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$a != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$a.dcN();
      afxv.a().NF(2);
    }
    anot.a(this.mApp, "dc00898", "", "", "0X80096A5", "0X80096A5", 0, 0, "", "", "", "");
  }
  
  public void dcn()
  {
    PublicFragmentActivity.start(this.mActivity, ExtendFriendCampusSearchFragment.class);
    this.mActivity.overridePendingTransition(0, 2130772403);
  }
  
  public void ez(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusFragment", 2, String.format("onTagItemClick tag=%s position=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    if (!paramString.equals(this.mSearchKey)) {
      this.mSearchKey = paramString;
    }
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (paramInt == 0) {
      paramString = null;
    }
    if (localFeedListView.a(paramString, this))
    {
      this.mEmptyView.setVisibility(0);
      this.RK.setText(2131720482);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.h(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onCreate: ");
    super.onCreate(paramBundle);
    this.mActivity = getActivity();
    this.mApp = this.mActivity.app;
    this.cO = new auru(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Afsi = ((afsi)this.mApp.getManager(264));
    if (this.mApp != null) {
      this.mApp.addObserver(this.c);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = null;
    StringBuilder localStringBuilder = new StringBuilder().append("onCreateView: ");
    if (paramLayoutInflater.getFactory() == null) {
      paramViewGroup = "null";
    }
    for (;;)
    {
      QLog.i("ExtendFriendCampusFragment", 4, paramViewGroup);
      try
      {
        paramViewGroup = paramLayoutInflater.inflate(2131561318, null);
        if (paramViewGroup == null)
        {
          ExtendFriendFragment.dcA();
          this.mActivity.finish();
          paramLayoutInflater = new View(paramLayoutInflater.getContext());
          V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
          return paramLayoutInflater;
          paramViewGroup = paramLayoutInflater.getFactory().getClass().getName();
        }
      }
      catch (Throwable paramViewGroup)
      {
        for (;;)
        {
          QLog.w("ExtendFriendCampusFragment", 4, "onCreateView: failed create view");
          paramViewGroup = paramBundle;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView = ((ExtendFriendSearchBarView)paramViewGroup.findViewById(2131377783));
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.getViewTreeObserver().addOnGlobalLayoutListener(this);
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setItemClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchButtonEnable(false);
          dcq();
          this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)paramViewGroup.findViewById(2131377716));
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this.mApp, this.mActivity, this.mApp.getLongAccountUin());
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setFeedUinChangedListener(this);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOnScrollListener(this);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExtendFriendCampusFragment.2(this), 800L);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setExpandHead(new afuh(this));
          this.mEmptyView = paramViewGroup.findViewById(2131376014);
          this.mEmptyView.setVisibility(0);
          this.RK = ((TextView)paramViewGroup.findViewById(2131376016));
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView = ((ExtendFriendBottomBarView)paramViewGroup.findViewById(2131363629));
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.b(this.mApp, this.jdField_a_of_type_CooperationQzoneApiFeedListView);
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.setOnClickListener(new afui(this));
          gy(paramViewGroup);
          this.caT = false;
          paramLayoutInflater = paramViewGroup;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onDestroy");
    super.onDestroy();
    dco();
    if (this.mApp != null) {
      this.mApp.removeObserver(this.c);
    }
    if ((Build.VERSION.SDK_INT > 15) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    if ((!this.caT) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null))
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onDestroy();
      this.caT = true;
    }
  }
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.getHeight();
    if (i > this.cUD)
    {
      this.cUD = i;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.NG(this.jdField_a_of_type_CooperationQzoneApiFeedListView.getHeight());
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.getVisibility() != 0) {
        break label95;
      }
    }
    label95:
    for (i = this.cUD;; i = 0)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.setPadding(this.jdField_a_of_type_CooperationQzoneApiFeedListView.getPaddingLeft(), i, this.jdField_a_of_type_CooperationQzoneApiFeedListView.getPaddingRight(), cUC);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExtendFriendCampusFragment.7(this), 20L);
      return;
    }
  }
  
  public void onPause()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onPause");
    super.onPause();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onPause();
    }
  }
  
  public void onResume()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onResume");
    super.onResume();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onResume();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      dcp();
    }
  }
  
  public void onStart()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onStart");
    super.onStart();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStart();
    }
  }
  
  public void onStop()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onStop");
    super.onStop();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStop();
    }
  }
  
  public void yA(boolean paramBoolean)
  {
    QLog.i("ExtendFriendCampusFragment", 1, "onLoadOver: " + paramBoolean);
    if (paramBoolean)
    {
      this.mEmptyView.setVisibility(8);
      return;
    }
    this.RK.setText("刷新失败，请下拉重试");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment
 * JD-Core Version:    0.7.0.1
 */