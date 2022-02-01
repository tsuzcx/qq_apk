package com.tencent.mobileqq.mini.share;

import amiw;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import ayrd;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.List;
import wja;

public class MiniShareQuicklySendPanelFragment
  extends PublicBaseFragment
  implements View.OnClickListener, ayrd
{
  public static final int QUCIKLY_SHARE_REQUEST_CODE = 678;
  public static final String TAG = MiniShareQuicklySendPanelFragment.class.getSimpleName();
  private MiniShareQuicklySendPanelAdapter adapter;
  private ImageView arrowView;
  private View backgroundView;
  private View contentView;
  private View footerView;
  private boolean isCallback;
  private boolean isShowedPanel;
  private XListView listView;
  private amiw mHelper;
  private View mRootView;
  private Handler mainHandler;
  private boolean needShareCallback;
  private SlideBottomPanel slidePanel;
  
  private void dealSendViewAnimation()
  {
    if ((this.footerView != null) && (this.footerView.getVisibility() == 8) && (this.slidePanel.aQZ())) {
      showSendView(0, 1, 0);
    }
  }
  
  private View getBottomView()
  {
    View localView = new View(getActivity());
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(130.0F, getResources())));
    localView.setBackgroundResource(2130851351);
    return localView;
  }
  
  private void initData()
  {
    Bundle localBundle = getActivity().getIntent().getExtras();
    this.mHelper = new amiw();
    List localList = this.mHelper.a(getActivity(), getActivity().app);
    if (localBundle != null)
    {
      this.needShareCallback = localBundle.getBoolean("needShareCallBack", false);
      localBundle.putBoolean("needShareCallBack", false);
    }
    this.adapter = new MiniShareQuicklySendPanelAdapter(getActivity(), getActivity().app, this.listView, localBundle);
    this.adapter.setData(wipeOutPC(localList));
    this.listView.setAdapter(this.adapter);
  }
  
  private void shareCallBack(boolean paramBoolean)
  {
    if ((this.needShareCallback) && (!this.isCallback))
    {
      this.isCallback = true;
      if (paramBoolean) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
    }
    else
    {
      return;
    }
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
  }
  
  private void showSendView(int paramInt1, int paramInt2, int paramInt3)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramInt1, paramInt2);
    this.footerView.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setDuration(500L);
    this.footerView.setVisibility(paramInt3);
  }
  
  private ArrayList<MiniShareQuicklySendPanelAdapter.SendPanelData> wipeOutPC(List<RecentBaseData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    int i = 0;
    if (i < paramList.size())
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)paramList.get(i);
      QLog.d(TAG, 4, "wipeOutPC RecentBaseData :" + localRecentBaseData.getTitleName());
      if (localRecentBaseData.ng() == 6000) {
        paramList.remove(localRecentBaseData);
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(new MiniShareQuicklySendPanelAdapter.SendPanelData(localRecentBaseData));
      }
    }
    return localArrayList;
  }
  
  public void cancelAnimator() {}
  
  public void displayPanel()
  {
    dealSendViewAnimation();
    if (this.backgroundView != null) {
      this.backgroundView.setVisibility(0);
    }
  }
  
  public void displayPanelFinish()
  {
    if (this.arrowView != null) {
      this.arrowView.setBackgroundResource(2130850667);
    }
  }
  
  public void fadeBackground(float paramFloat)
  {
    if (this.backgroundView != null)
    {
      this.backgroundView.setVisibility(0);
      this.backgroundView.setAlpha(paramFloat);
    }
  }
  
  public void hidePanel()
  {
    if ((this.footerView != null) && (this.footerView.getVisibility() == 0)) {
      showSendView(1, 0, 8);
    }
    if (this.backgroundView != null) {
      this.backgroundView.setVisibility(8);
    }
    this.mainHandler.postDelayed(new MiniShareQuicklySendPanelFragment.1(this), 500L);
  }
  
  public void hidePanelFinish()
  {
    if (this.arrowView != null) {
      this.arrowView.setBackgroundResource(2130850666);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d(TAG, 4, "onActivityResult requestCode:" + paramInt1);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        QLog.d(TAG, 4, "onActivityResult RESULT_OK:" + paramInt2);
        shareCallBack(true);
        this.adapter.notifyShareSuc();
      }
      else
      {
        QLog.d(TAG, 4, "onActivityResult other:" + paramInt2);
        this.adapter.notifyShareCancel();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 4, "R.id.send - onClick");
      }
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (getActivity().app == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = this.mRootView)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.mainHandler = new Handler(Looper.getMainLooper());
      this.mRootView = paramLayoutInflater.inflate(2131563083, paramViewGroup, false);
      this.slidePanel = ((SlideBottomPanel)this.mRootView.findViewById(2131378488));
      this.contentView = this.mRootView.findViewById(2131365396);
      this.listView = ((XListView)this.mRootView.findViewById(2131370527));
      this.footerView = this.mRootView.findViewById(2131378016);
      this.backgroundView = this.mRootView.findViewById(2131363236);
      this.arrowView = ((ImageView)this.mRootView.findViewById(2131380118));
      this.listView.addFooterView(getBottomView());
      this.slidePanel.setSlidePanelListener(this);
      this.footerView.findViewById(2131377979).setOnClickListener(this);
      initData();
    }
  }
  
  public void onDestroy()
  {
    if (this.adapter != null) {
      this.adapter.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    shareCallBack(false);
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((this.slidePanel != null) && (!this.isShowedPanel)) {
      this.slidePanel.displayPanel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelFragment
 * JD-Core Version:    0.7.0.1
 */