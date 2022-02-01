package com.tencent.biz.qqcircle.list.bizblocks;

import acfp;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleTopTagEvent;
import com.tencent.biz.qqcircle.events.QCircleTopTagListEvent;
import com.tencent.biz.qqcircle.requests.QCircleFollowTagListRequest;
import com.tencent.biz.qqcircle.widgets.QCircleFollowTagListItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudRead.StGetFollowTagListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ovd;
import pbt;
import rwv;
import rwx;
import rxt;
import ryi.a;

public class QCircleFollowTagListBlock
  extends pbt<FeedCloudMeta.StTagInfo, FeedCloudRead.StGetFollowTagListRsp>
  implements rwx
{
  private static final String TAG = "QCircleFollowTagListBlock";
  private String mUin;
  
  public QCircleFollowTagListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String getAttachInfoFromRsp(FeedCloudRead.StGetFollowTagListRsp paramStGetFollowTagListRsp)
  {
    return paramStGetFollowTagListRsp.attachInfo.get();
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_follow_tag_list";
  }
  
  public String getEmptyHint()
  {
    return acfp.m(2131700113);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleTopTagEvent.class);
    return localArrayList;
  }
  
  public boolean getIsFinishFromRsp(FeedCloudRead.StGetFollowTagListRsp paramStGetFollowTagListRsp)
  {
    return paramStGetFollowTagListRsp.hasNext.get() == 1;
  }
  
  public List<FeedCloudMeta.StTagInfo> getListDataFromRsp(FeedCloudRead.StGetFollowTagListRsp paramStGetFollowTagListRsp)
  {
    return paramStGetFollowTagListRsp.tagInfos.get();
  }
  
  public VSBaseRequest getRequest(String paramString)
  {
    return new QCircleFollowTagListRequest(paramString, this.mUin);
  }
  
  public String getTitle()
  {
    return acfp.m(2131700111);
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void initTitleBar(View paramView) {}
  
  public boolean isItemEqual(Object paramObject1, Object paramObject2)
  {
    return ((FeedCloudMeta.StTagInfo)paramObject1).tagName.equals(((FeedCloudMeta.StTagInfo)paramObject2).tagName);
  }
  
  public void loadData(rxt paramrxt) {}
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    rwv.a().a(this);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null) {
      ((ryi.a)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
    }
    QLog.d("QCircleFollowTagListBlock", 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public ryi.a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ryi.a(new QCircleFollowTagListItemView(getParentFragment().getActivity(), ovd.eL(this.mExtraTypeInfo.getUserId())));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    rwv.a().b(this);
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d("QCircleFollowTagListBlock", 1, "onPrepareParams");
    super.onInitBlock(paramBundle);
    if (this.mExtraTypeInfo != null) {
      this.mUin = this.mExtraTypeInfo.userId;
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleTopTagEvent)) {
      updateFollowTagData(((QCircleTopTagEvent)paramSimpleBaseEvent).stTagInfo, ((QCircleTopTagEvent)paramSimpleBaseEvent).followState);
    }
  }
  
  public void setInitData(ArrayList<FeedCloudMeta.StTagInfo> paramArrayList) {}
  
  public void updateFollowTagData(Object paramObject, int paramInt)
  {
    if ((paramObject == null) || (this.mDataList == null)) {
      return;
    }
    Iterator localIterator = this.mDataList.iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!isItemEqual(localObject, paramObject));
    for (;;)
    {
      if (localObject != null) {
        this.mDataList.remove(localObject);
      }
      if (paramInt == 2)
      {
        this.mDataList.add(0, paramObject);
        paramObject = new ArrayList();
        if (this.mDataList.size() <= 4) {
          break label181;
        }
        paramObject = this.mDataList.subList(0, 4);
      }
      for (;;)
      {
        rwv.a().a(new QCircleTopTagListEvent(paramObject));
        notifyDataSetChanged();
        return;
        if (paramInt != 3) {
          break;
        }
        paramInt = 0;
        while (paramInt < this.mDataList.size())
        {
          if (((FeedCloudMeta.StTagInfo)this.mDataList.get(paramInt)).isTop.get() != 1) {
            break label169;
          }
          paramInt += 1;
        }
        break;
        label169:
        this.mDataList.add(paramInt, paramObject);
        break;
        label181:
        paramObject.addAll(this.mDataList);
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowTagListBlock
 * JD-Core Version:    0.7.0.1
 */