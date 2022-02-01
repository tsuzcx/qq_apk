package com.tencent.biz.qqcircle.list.bizblocks;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.qqcircle.requests.QCircleMessageNoticeRequest;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleCommentOrReplyMessageItemView;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleDefaultMessageWidget;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleFollowMessageItemView;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleUnsupportedMessageItemView;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudRead.StGetNoticeListRsp;
import java.util.ArrayList;
import java.util.List;
import oux;
import pbt;
import pco;
import pcr;
import pdp;
import riw;
import rxt;
import ryi.a;

public class QCircleMessageListBlock
  extends pbt<FeedCloudMeta.StNotice, FeedCloudRead.StGetNoticeListRsp>
{
  private static final int MESSAGE_TYPE_UNSUPPORTED = SUPPORT_MESSAGE_TYPES.length;
  private static final int[] SUPPORT_MESSAGE_TYPES = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
  private static final String TAG = "QCircleMessageListBlock";
  private boolean mFromPush;
  
  public QCircleMessageListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String getAttachInfoFromRsp(FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    return paramStGetNoticeListRsp.feedAttchInfo.get();
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_message_notice_page";
  }
  
  public String getEmptyHint()
  {
    return acfp.m(2131700138);
  }
  
  public boolean getIsFinishFromRsp(FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    return paramStGetNoticeListRsp.isFinish.get() == 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt))
    {
      paramInt = ((FeedCloudMeta.StNotice)this.mDataList.get(paramInt)).noticeType.get();
      if ((paramInt >= 0) && (paramInt < MESSAGE_TYPE_UNSUPPORTED)) {
        return paramInt;
      }
    }
    QLog.e("QCircleMessageListBlock", 2, "getItemViewType()  return MESSAGE_TYPE_UNSUPPORTED" + MESSAGE_TYPE_UNSUPPORTED);
    return MESSAGE_TYPE_UNSUPPORTED;
  }
  
  public List<FeedCloudMeta.StNotice> getListDataFromRsp(FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    return paramStGetNoticeListRsp.vecNotice.get();
  }
  
  public VSBaseRequest getRequest(String paramString)
  {
    return new QCircleMessageNoticeRequest(paramString, false);
  }
  
  public String getTitle()
  {
    return acfp.m(2131700139);
  }
  
  public int getViewTypeCount()
  {
    return SUPPORT_MESSAGE_TYPES.length + 1;
  }
  
  public void initTitleBar(View paramView) {}
  
  public void loadData(rxt paramrxt)
  {
    super.loadData(paramrxt);
    if (paramrxt.Mg())
    {
      pdp.a().bke();
      QCircleGlobalBroadcastHelper.a().bhH();
    }
    while (!paramrxt.Mh()) {
      return;
    }
    pdp.a().bke();
    QCircleGlobalBroadcastHelper.a().bhH();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (pcr.a().ey(59)) {
      pcr.a().aX(getActivity().getIntent());
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    pcr.a().vq(59);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    pco.h("", 17, 1L);
  }
  
  public boolean onBackEvent()
  {
    if (this.mFromPush)
    {
      QLog.d("QCircleMessageListBlock", 1, "mFromPush back launchFolderPage");
      if (pcr.a().sc() <= 1) {
        oux.u(getContext(), null);
      }
      getActivity().finish();
      return true;
    }
    QLog.d("QCircleMessageListBlock", 1, "not mFromPush back finish");
    return false;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null) {
      ((ryi.a)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
    }
    QLog.d("QCircleMessageListBlock", 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public ryi.a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("QCircleMessageListBlock", 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
      return new ryi.a(new QCircleUnsupportedMessageItemView(getParentFragment().getActivity()));
    case 0: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      return new ryi.a(new QCircleDefaultMessageWidget(getParentFragment().getActivity(), paramInt));
    case 1: 
    case 2: 
      return new ryi.a(new QCircleCommentOrReplyMessageItemView(getParentFragment().getActivity(), paramInt));
    }
    return new ryi.a(new QCircleFollowMessageItemView(getParentFragment().getActivity(), paramInt));
  }
  
  public void onDrawItemDecoration(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, RecyclerView.State paramState)
  {
    paramState = getContext().getResources().getDrawable(2130844856);
    int i = paramRecyclerView.getPaddingLeft();
    int j = riw.dip2px(getContext(), 70.0F);
    int k = paramRecyclerView.getWidth();
    int m = paramRecyclerView.getPaddingRight();
    if ((paramView.getWidth() == 0) || (paramView.getHeight() == 0)) {
      return;
    }
    paramRecyclerView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int n = paramView.getBottom();
    n = paramRecyclerView.bottomMargin + n;
    paramState.setBounds(j + i, n, k - m, paramState.getIntrinsicHeight() + n);
    paramState.draw(paramCanvas);
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d("QCircleMessageListBlock", 1, "onPrepareParams");
    super.onInitBlock(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_jump_from");
      if (!TextUtils.isEmpty(paramBundle)) {
        this.mFromPush = paramBundle.equals(String.valueOf(7));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleMessageListBlock
 * JD-Core Version:    0.7.0.1
 */