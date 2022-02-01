package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import acja;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anot;
import aurf;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.network.SubscribeGetFollowFeedsRequest;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;
import mqq.os.MqqHandler;
import nyi;
import nyn;
import nyp;
import nyq;
import nyr;
import nys;
import nyt;
import ocp;
import odd;
import rxt;
import rze;
import sao;
import sbf;
import sqn;

public class FolderFollowTabFragment
  extends FolderBaseTabFragment
  implements Handler.Callback, DragFrameLayout.c
{
  public static String TAG = "FolderFollowTabFragment";
  public static int bdf = 1;
  private a jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$a;
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  private ServiceFolderFollowPBHeadView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private sao jdField_a_of_type_Sao;
  private sbf jdField_a_of_type_Sbf;
  private QQAppInterface app;
  private boolean avA;
  private Activity mContext;
  private ExtraTypeInfo mExtraTypeInfo;
  private boolean mIsFirstRequest = true;
  private final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  private void a(sbf paramsbf)
  {
    SubscribeGetFollowFeedsRequest localSubscribeGetFollowFeedsRequest = new SubscribeGetFollowFeedsRequest(null);
    localSubscribeGetFollowFeedsRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localSubscribeGetFollowFeedsRequest, new nyr(this, localSubscribeGetFollowFeedsRequest, paramsbf));
  }
  
  private void b(sbf paramsbf)
  {
    if ((getActivity() != null) && (!getActivity().isFinishing()) && (paramsbf != null) && (this.jdField_a_of_type_Sao != null))
    {
      paramsbf.clearData();
      paramsbf.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Sao);
      this.jdField_a_of_type_Sao.a(new nys(this));
    }
  }
  
  private void bcB()
  {
    nyn localnyn = nyn.a();
    List localList = localnyn.bk();
    if ((localList != null) && (localList.size() > 0))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = localList;
      localMessage.what = 101;
      localMessage.arg1 = bdf;
      this.uiHandler.sendMessage(localMessage);
    }
    ThreadManager.executeOnSubThread(new FolderFollowTabFragment.1(this, localnyn));
    localnyn.d(this.app, NetConnInfoCenter.getServerTime());
    odd.bU("SERVICE_FOLDER_COST", null);
  }
  
  private void bcC()
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.mRootView.findViewById(2131378073));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView = new ServiceFolderFollowPBHeadView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_Sbf = new sbf(null);
    this.jdField_a_of_type_Sbf.setInNightMode(this.avA);
    this.jdField_a_of_type_Sbf.uv(false);
    this.jdField_a_of_type_Sbf.setOnLoadDataDelegate(new nyp(this));
    this.jdField_a_of_type_Sao = new sao(null);
    this.jdField_a_of_type_Sao.setInNightMode(this.avA);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(new nyq(this, null));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Sbf);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setExtraTypeInfo(this.mExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableRefresh(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.start();
  }
  
  private void c(sbf paramsbf)
  {
    SubscribeGetFollowFeedsRequest localSubscribeGetFollowFeedsRequest = new SubscribeGetFollowFeedsRequest(paramsbf.getLoadInfo().c());
    VSNetworkHelper.a().a(localSubscribeGetFollowFeedsRequest, new nyt(this, paramsbf));
  }
  
  private void dr(List<nyi> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new FolderFollowTabFragment.8(this, paramList));
  }
  
  private boolean en(String paramString)
  {
    acja localacja = (acja)this.app.getManager(56);
    if (localacja != null)
    {
      paramString = localacja.b(paramString);
      if ((paramString != null) && (ocp.F(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  private void initView()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.b(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    bcC();
    if (getActivity() != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$a = new a(null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_refresh_return_page");
      getActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$a, localIntentFilter);
    }
  }
  
  private void oU(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setJumpWebMessageListUrl(paramString);
    }
  }
  
  public void a(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, int paramInt)
  {
    if (paramInt == getCurrentIndex())
    {
      paramServiceAccountFolderActivityNew.L(true);
      if (paramServiceAccountFolderActivityNew.Gp())
      {
        paramServiceAccountFolderActivityNew.uq(8);
        bcB();
        if (this.jdField_a_of_type_Sbf != null) {
          a(this.jdField_a_of_type_Sbf);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    nyi localnyi;
    long l;
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() == -1) && (paramDragFrameLayout.bI() != null) && (paramDragFrameLayout.bI().getId() == 2131378069))
    {
      localnyi = (nyi)paramDragFrameLayout.bI().getTag(2131378063);
      paramInt = ((Integer)paramDragFrameLayout.bI().getTag(2131378061)).intValue();
      if (localnyi != null)
      {
        l = nyn.a().a(localnyi);
        localQQAppInterface = this.app;
        if (!localnyi.Gq()) {
          break label257;
        }
      }
    }
    label257:
    for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
    {
      anot.a(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, "" + localnyi.mUnreadNum, "" + (paramInt + 1), "" + l);
      nyn.a().b(this.app, localnyi, true);
      sqn.b(localnyi.mUin, "auth_page", "ignore", 0, 0, new String[0]);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onChange->drag red dot:" + localnyi.mUin);
      }
      return;
    }
  }
  
  public int getCurrentIndex()
  {
    return bdd;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      int i = paramMessage.arg1;
      this.uiHandler.removeMessages(100);
      ThreadManager.executeOnSubThread(new FolderFollowTabFragment.7(this, i));
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 101)
      {
        List localList = (List)paramMessage.obj;
        if (localList.isEmpty()) {
          if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null) {
            this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setTopBannerVisibility(false);
          }
        }
        while (((this.mContext instanceof ServiceAccountFolderActivityNew)) && (paramMessage.arg1 != bdf))
        {
          ((ServiceAccountFolderActivityNew)this.mContext).uq(0);
          sqn.d("auth_follow", "tab_red", 0, 0, new String[0]);
          return true;
          if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null)
          {
            this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setTopBannerVisibility(true);
            this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.setData(localList);
          }
        }
      }
    }
  }
  
  protected void initViewData()
  {
    if (this.mRootView == null) {
      this.mRootView = LayoutInflater.from(getActivity()).inflate(2131558870, null, false);
    }
    this.avA = rze.Mp();
    this.app = getActivity().app;
    if (this.app != null) {
      this.app.setHandler(FolderFollowTabFragment.class, this.uiHandler);
    }
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      ExtraTypeInfo localExtraTypeInfo2 = (ExtraTypeInfo)getActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      ExtraTypeInfo localExtraTypeInfo1 = localExtraTypeInfo2;
      if (localExtraTypeInfo2 == null) {
        localExtraTypeInfo1 = new ExtraTypeInfo();
      }
      this.mExtraTypeInfo = new ExtraTypeInfo(7003, localExtraTypeInfo1.sourceType);
    }
    this.mContext = getActivity();
    initView();
    bcB();
    QLog.d(FolderBaseTabFragment.TAG, 4, "initViewData:" + getCurrentIndex());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.mRootView == null) {
      this.mRootView = LayoutInflater.from(getActivity()).inflate(2131558870, null, false);
    }
    this.avA = rze.Mp();
    if (this.avA) {
      this.mRootView.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      QLog.d(FolderBaseTabFragment.TAG, 4, "onCreateView:" + getCurrentIndex());
      paramLayoutInflater = this.mRootView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.mRootView.setBackgroundColor(-1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.bzf();
    }
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$a != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment$a);
    }
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.onDestroy();
    }
    if (this.app != null) {
      this.app.removeHandler(FolderFollowTabFragment.class);
    }
  }
  
  public void us(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView.us(paramInt);
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "action_refresh_return_page")) && (FolderFollowTabFragment.a(FolderFollowTabFragment.this) != null)) {
        FolderFollowTabFragment.b(FolderFollowTabFragment.this, FolderFollowTabFragment.a(FolderFollowTabFragment.this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */