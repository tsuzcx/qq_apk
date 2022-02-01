package com.tencent.biz.qqcircle.fragments;

import acfp;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import ovg;
import pal;
import pec;
import pel;
import rwv;
import rwx;
import rxj;
import rxt;

public class QCirclePersonalPushFragment
  extends QCirclePersonalBaseBottomFragment
  implements rwx
{
  private void h(pel<List<FeedCloudMeta.StFeed>> parampel)
  {
    if (parampel == null)
    {
      QLog.e(TAG, 1, "handleFeedDataRsp return unexpected data！");
      return;
    }
    boolean bool = parampel.HU();
    int i;
    switch (parampel.getState())
    {
    default: 
      i = 0;
    }
    while ((i != 0) && (this.jdField_a_of_type_Ovg != null))
    {
      this.jdField_a_of_type_Ovg.notifyLoadingComplete(true, bool);
      return;
      QLog.e(TAG, 1, "handleFeedDataRsp() return empty data");
      if ((parampel.HV()) && (this.jdField_a_of_type_Ovg != null) && (this.jdField_a_of_type_Ovg.getItemCount() > 0))
      {
        this.jdField_a_of_type_Ovg.getLoadInfo().setFinish(bool);
        i = 1;
      }
      else
      {
        if (this.jdField_a_of_type_Rxj != null)
        {
          parampel = getString(2131700095);
          ((QCircleStatusView)this.jdField_a_of_type_Rxj.a().a()).showEmptyView(parampel);
          biV();
          i = 1;
          continue;
          if (parampel.getMsg() == null) {}
          for (parampel = acfp.m(2131720624);; parampel = parampel.getMsg())
          {
            QLog.e(TAG, 1, "handleFeedDataRsp() return error！errMsg:" + parampel);
            if ((this.jdField_a_of_type_Ovg == null) || (this.jdField_a_of_type_Ovg.getItemCount() <= 0)) {
              break label250;
            }
            QQToast.a(BaseApplicationImpl.getContext(), 1, parampel, 1).show();
            i = 1;
            break;
          }
          label250:
          if (this.jdField_a_of_type_Rxj != null)
          {
            ((QCircleStatusView)this.jdField_a_of_type_Rxj.a().a()).showErrorView(parampel);
            biV();
            i = 1;
            continue;
            i = 0;
            continue;
            ArrayList localArrayList = (ArrayList)parampel.getData();
            if (this.jdField_a_of_type_Ovg != null)
            {
              if (parampel.HV()) {
                this.jdField_a_of_type_Ovg.addAll(localArrayList);
              }
              for (;;)
              {
                if (this.jdField_a_of_type_Rxj != null)
                {
                  ((QCircleStatusView)this.jdField_a_of_type_Rxj.a().a()).setVisibility(8);
                  this.jdField_a_of_type_Rxj.a().a().setVisibility(0);
                }
                this.jdField_a_of_type_Ovg.getLoadInfo().setFinish(bool);
                i = 1;
                break;
                this.jdField_a_of_type_Ovg.setDatas(localArrayList);
                this.jdField_a_of_type_Ovg.bhS();
              }
            }
          }
        }
        i = 1;
      }
    }
  }
  
  public boolean HI()
  {
    return false;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    rwv.a().a(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  protected void initChildView()
  {
    if (this.jdField_a_of_type_Ovg != null)
    {
      ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
      localExtraTypeInfo.pageType = 9;
      this.jdField_a_of_type_Ovg.setExtraTypeInfo(localExtraTypeInfo);
    }
    if (a() != null)
    {
      this.jdField_a_of_type_Pec = ((pec)a(a(), null, pec.class));
      this.jdField_a_of_type_Pec.p().observe(a(), new pal(this));
    }
  }
  
  protected void loadMore()
  {
    if (this.jdField_a_of_type_Pec != null) {
      this.jdField_a_of_type_Pec.qF(this.mUin);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedEvent)) && (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 3))
    {
      paramSimpleBaseEvent = ((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId;
      if (!TextUtils.isEmpty(paramSimpleBaseEvent)) {
        break label34;
      }
    }
    label134:
    for (;;)
    {
      return;
      label34:
      if (this.jdField_a_of_type_Ovg != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Ovg.getDataList();
        if (localArrayList == null) {
          break;
        }
        int i = 0;
        int j = localArrayList.size();
        if (i < j) {
          if (!paramSimpleBaseEvent.equals(((FeedCloudMeta.StFeed)localArrayList.get(i)).id.get())) {}
        }
        for (;;)
        {
          if (i < 0) {
            break label134;
          }
          try
          {
            this.jdField_a_of_type_Ovg.delete(i);
            this.jdField_a_of_type_Ovg.notifyItemRemoved(i);
            return;
          }
          catch (Throwable paramSimpleBaseEvent)
          {
            QLog.e(TAG, 1, "onReceiveEvent() delete local feed error!", paramSimpleBaseEvent);
            return;
          }
          i += 1;
          break;
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalPushFragment
 * JD-Core Version:    0.7.0.1
 */