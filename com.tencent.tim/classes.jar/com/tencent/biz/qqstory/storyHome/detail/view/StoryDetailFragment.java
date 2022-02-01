package com.tencent.biz.qqstory.storyHome.detail.view;

import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import ppf;
import pre;
import pso;
import psx;
import ptq;
import qrd;
import qrj;
import qru;
import qsb;
import qsl;
import qsm;
import qsn;
import qsr;
import qss;
import qst;
import qsw;
import qta;
import qtb;
import qtf;
import qth;
import qvf;
import ram;
import rar;
import rpq;

public class StoryDetailFragment
  extends ReportV4Fragment
  implements View.OnTouchListener, AdapterView.c, AdapterView.d, qrd
{
  public StoryDetailListView a;
  public qsb a;
  private qsn a;
  public qvf a;
  private boolean aFn;
  private String ayv;
  private int bnU;
  private int bnW;
  private int bnX;
  private qru d;
  private RelativeLayout fN;
  private TextView ht;
  private String mFeedId;
  private int mSource;
  
  public static StoryDetailFragment a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, String paramString2, int paramInt3, int paramInt4)
  {
    StoryDetailFragment localStoryDetailFragment = new StoryDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("feed_id", paramString1);
    localBundle.putInt("source", paramInt1);
    localBundle.putBoolean("should_up_keyboard", paramBoolean);
    localBundle.putInt("focus_comment_id", paramInt2);
    localBundle.putString("focus_video_id", paramString2);
    localBundle.putInt("play_source", paramInt3);
    localBundle.putInt("focus_tab", paramInt4);
    localStoryDetailFragment.setArguments(localBundle);
    return localStoryDetailFragment;
  }
  
  private void aA(String paramString, boolean paramBoolean)
  {
    if (ppf.IC())
    {
      localIntent = new Intent(getActivity(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("main_tab_id", 6);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.setFlags(335544320);
      startActivity(localIntent);
      return;
    }
    Intent localIntent = new Intent(getActivity(), QQStoryMainActivity.class);
    localIntent.putExtra("new_video_extra_info", paramString);
    if (paramBoolean) {
      localIntent.putExtra("selfSet_leftViewText", getActivity().getString(2131691039));
    }
    startActivity(localIntent);
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Qsb == null) {
      return false;
    }
    if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.sC()) {
      return false;
    }
    paramInt -= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.sC();
    paramView = ((qss)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      ram.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    if ((this.d != null) && (this.d.d != null)) {
      if (!this.d.d.getOwner().isMe()) {
        break label155;
      }
    }
    label155:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      rar.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, rar.bX(this.mSource) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Qsn.bpW();
      return true;
    }
    this.jdField_a_of_type_Qsb.b(paramView, paramInt, this.jdField_a_of_type_Qsn.sO());
    return true;
  }
  
  public boolean a(qru paramqru, boolean paramBoolean)
  {
    return (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.Kx()) || (paramqru == null) || (paramqru.Y(paramBoolean)) || (paramqru.a(paramBoolean) != null);
  }
  
  public void aq(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.pn(paramBoolean1);
    StoryDetailListView localStoryDetailListView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView;
    if (!paramBoolean2) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localStoryDetailListView.setLoadMoreComplete("StoryDetailFragment", paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  public void azy()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.azy();
  }
  
  public void b(qru paramqru, boolean paramBoolean)
  {
    ram.d("Q.qqstory.detail.StoryDetailFragment", "update feed all info. %s.", paramqru.toString());
    this.d = paramqru;
    this.ht.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setVisibility(0);
    this.fN.setVisibility(0);
    if (getActivity() != null) {
      getActivity().setTitle(fZ(paramqru.d.date));
    }
    if (this.jdField_a_of_type_Qsb == null) {
      this.jdField_a_of_type_Qsb = new qsb(getActivity(), getView(), paramqru, true, this.mSource, this.jdField_a_of_type_Qsn);
    }
    Object localObject = (qtf)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("GeneralFeedProfileSegment");
    ((qtf)localObject).c(paramqru);
    ((qtf)localObject).rX(this.ayv);
    ((qtf)localObject).setDisplay(true);
    localObject = (qth)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("ShareGroupFeedProfileSegment");
    ((qth)localObject).c(paramqru);
    ((qth)localObject).rX(this.ayv);
    ((qth)localObject).setDisplay(true);
    localObject = (qsr)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("BannerProfileSegment");
    ((qsr)localObject).c(paramqru);
    ((qsr)localObject).setDisplay(true);
    ((qsw)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailInteractSegment")).a(paramqru, this.mSource, this.bnW);
    ((qst)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailDoubleTabSegment")).d(paramqru, paramBoolean);
    ((qta)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailLikeListSegment")).d(paramqru, paramBoolean);
    ((qss)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).d(paramqru, paramBoolean);
    ((qtb)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailTagListSegment")).c(paramqru);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.azy();
    localObject = paramqru.h(paramBoolean);
    int i;
    if ((this.bnU != -1) && (localObject != null)) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((List)localObject).size())
      {
        if (((CommentEntry)((List)localObject).get(i)).commentId == this.bnU) {
          wx(i);
        }
      }
      else
      {
        if (this.aFn)
        {
          this.aFn = false;
          getView().postDelayed(new StoryDetailFragment.2(this), 100);
          rar.a("home_page", "auto_reply", rar.a(paramqru.d), 0, new String[0]);
        }
        return;
      }
      i += 1;
    }
  }
  
  public void bqg()
  {
    ram.i("Q.qqstory.detail.StoryDetailFragment", "show empty page.");
    this.ht.setVisibility(8);
    this.fN.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setProfileSegmentDisplay(false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.azy();
  }
  
  public void bqh()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.sD();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setSelectionFromBottom(i, 0);
    ram.d("Q.qqstory.detail.StoryDetailFragment", "scoll to last comment. position is %d.", Integer.valueOf(i));
  }
  
  public void c(qru paramqru, boolean paramBoolean)
  {
    ((qst)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailDoubleTabSegment")).d(paramqru, paramBoolean);
    ((qta)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailLikeListSegment")).d(paramqru, paramBoolean);
    ((qss)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).d(paramqru, paramBoolean);
    paramBoolean = a(paramqru, paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnLoadMoreListener("StoryDetailFragment", new qsm(this));
    paramqru = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramqru.setLoadMoreComplete("StoryDetailFragment", true, paramBoolean);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.azy();
      return;
    }
  }
  
  public String fZ(String paramString)
  {
    paramString = rpq.g(paramString);
    return paramString[1] + acfp.m(2131714824) + paramString[2] + acfp.m(2131714823);
  }
  
  public void loadMore()
  {
    this.jdField_a_of_type_Qsn.bpW();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_Qvf.gb.remove("2_" + this.mFeedId);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.bd(getActivity());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.onCreate();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setRequestDataListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnLoadMoreListener("StoryDetailFragment", new qsl(this));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setLoadMoreComplete("StoryDetailFragment", true, false);
    this.jdField_a_of_type_Qsn = new qsn(this, this.mFeedId, this.mSource, this.bnW);
    this.jdField_a_of_type_Qsn.create();
    if (this.bnX != 0) {
      this.jdField_a_of_type_Qsn.setTabType(2);
    }
    this.jdField_a_of_type_Qsn.refreshData(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setCallback(this.jdField_a_of_type_Qsn);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
      String str = paramIntent.getStringExtra("new_video_extra_info");
      Object localObject1;
      if ((this.mSource == 211) || (this.mSource == 221))
      {
        localObject1 = new Intent(getActivity(), TroopStoryMainActivity.class);
        ((Intent)localObject1).putExtra("new_video_extra_info", str);
        ((Intent)localObject1).setFlags(335544320);
        startActivity((Intent)localObject1);
      }
      for (;;)
      {
        getActivity().finish();
        getActivity().overridePendingTransition(0, 0);
        break;
        if (this.bnW == 106)
        {
          localObject1 = (pso)psx.a(18);
          if ((((pso)localObject1).aBw) && (((pso)localObject1).fI != null))
          {
            Iterator localIterator = ((pso)localObject1).fI.keySet().iterator();
            while (localIterator.hasNext())
            {
              Object localObject2 = (String)localIterator.next();
              localObject2 = (QQStoryBaseActivity)((WeakReference)((pso)localObject1).fI.get(localObject2)).get();
              if ((localObject2 != null) && (getActivity() != localObject2) && (!((QQStoryBaseActivity)localObject2).isFinishing())) {
                ((QQStoryBaseActivity)localObject2).finish();
              }
            }
          }
          aA(str, true);
        }
        else
        {
          aA(str, false);
        }
      }
      if (this.jdField_a_of_type_Qsb != null)
      {
        qrj.a(this.jdField_a_of_type_Qsb.b, paramIntent);
        ThreadManager.getUIHandler().postDelayed(new StoryDetailFragment.4(this), 100L);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle == null) {
      return;
    }
    this.mFeedId = paramBundle.getString("feed_id");
    this.mSource = paramBundle.getInt("source");
    this.bnW = paramBundle.getInt("play_source");
    this.aFn = paramBundle.getBoolean("should_up_keyboard");
    this.bnU = paramBundle.getInt("focus_comment_id", -1);
    this.ayv = paramBundle.getString("focus_video_id");
    this.bnX = paramBundle.getInt("focus_tab");
    this.jdField_a_of_type_Qvf = ((qvf)psx.a(11));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131561818, paramViewGroup, false);
    this.fN = ((RelativeLayout)paramViewGroup.findViewById(2131365322));
    if (QQStoryContext.isNightMode())
    {
      ((InputLinearLayout)paramViewGroup.findViewById(2131377137)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166760));
      ((LinearLayout)paramViewGroup.findViewById(2131363673)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166759));
      ((XEditTextEx)paramViewGroup.findViewById(2131366528)).setHintTextColor(paramLayoutInflater.getContext().getResources().getColor(2131166761));
      paramViewGroup.findViewById(2131365990).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166760));
    }
    this.ht = ((TextView)paramViewGroup.findViewById(2131370820));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView = ((StoryDetailListView)paramViewGroup.findViewById(2131365780));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.mSource = this.mSource;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.bnW = 0;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.onDestroy();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView = null;
    }
    if (this.jdField_a_of_type_Qsn != null)
    {
      this.jdField_a_of_type_Qsn.destroy();
      this.jdField_a_of_type_Qsn = null;
    }
    if (this.jdField_a_of_type_Qsb != null) {
      this.jdField_a_of_type_Qsb.destroy();
    }
    if (this.jdField_a_of_type_Qvf != null) {
      this.jdField_a_of_type_Qvf.gb.remove("2_" + this.mFeedId);
    }
    rar.cy("home_page-comment_suc-d1", null);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Qsb == null) {}
    while (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.sC()) {
      return;
    }
    paramInt -= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.sC();
    paramAdapterView = ((qss)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramInt);
    if (paramAdapterView == null)
    {
      ram.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (paramAdapterView.type == 1)
    {
      this.jdField_a_of_type_Qsn.bpW();
      return;
    }
    this.jdField_a_of_type_Qsb.c(paramAdapterView, paramInt, this.jdField_a_of_type_Qsn.sO());
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    String str = null;
    if ((this.bnW == 106) || (this.bnW == 108)) {
      str = String.valueOf(this.bnW);
    }
    rar.cy("home_page-comment_suc-d1", str);
    this.jdField_a_of_type_Qsn.bqk();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.onResume();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Qsb != null) && (this.jdField_a_of_type_Qsb.Ks()))
    {
      int i;
      if (paramMotionEvent.getAction() == 1)
      {
        this.jdField_a_of_type_Qsb.bqb();
        if (this.d != null)
        {
          paramMotionEvent = pre.a().auz;
          i = rar.a(this.d.d);
          if (!this.d.d.getOwner().isMe()) {
            break label134;
          }
        }
      }
      label134:
      for (paramView = "1";; paramView = "2")
      {
        rar.a("home_page", "cancel_reply", i, 0, new String[] { paramView, rar.bX(this.mSource), paramMotionEvent, this.mFeedId });
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.detail.StoryDetailFragment", 2, "touch list while keyboard is showing, so hide the keyboard");
        }
        return true;
      }
    }
    return false;
  }
  
  public void pullToRefresh()
  {
    this.ayv = null;
    this.bnU = -1;
    this.jdField_a_of_type_Qvf.gb.remove("2_" + this.mFeedId);
    this.jdField_a_of_type_Qsn.refreshData(false);
  }
  
  public void wx(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.sC() + paramInt, 0);
    ram.d("Q.qqstory.detail.StoryDetailFragment", "scoll to the comment. position is %d.", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.sC() + paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment
 * JD-Core Version:    0.7.0.1
 */