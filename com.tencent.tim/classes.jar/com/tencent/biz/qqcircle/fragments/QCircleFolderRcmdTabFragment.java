package com.tencent.biz.qqcircle.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import ovg;
import ovp;
import pae;
import pco;
import pcr;
import pdy;
import rwv;
import rwx;
import rxj;
import rxq;

public class QCircleFolderRcmdTabFragment
  extends QCircleBaseTabFragment
  implements rwx
{
  public static String TAG = "QCircleFolderRcmdTabFragment";
  private ovp b;
  
  protected boolean HH()
  {
    return ((this.jdField_a_of_type_Ovg != null) && (this.jdField_a_of_type_Ovg.getItemCount() > 0)) || ((this.jdField_b_of_type_Ovp != null) && (this.jdField_b_of_type_Ovp.getItemCount() > 0));
  }
  
  public void bhT()
  {
    super.bhT();
  }
  
  protected void biN()
  {
    super.biN();
    this.jdField_b_of_type_Ovp.a(this.jdField_b_of_type_Pdy, this);
  }
  
  protected List<rxq> bx()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_b_of_type_Ovp = new ovp(null);
    localArrayList.add(this.jdField_b_of_type_Ovp);
    return localArrayList;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Rxj.a().a().addOnScrollListener(new pae(this));
    rwv.a().a(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleLazyLoadTabEvent.class);
    return localArrayList;
  }
  
  public String getLogTag()
  {
    return TAG;
  }
  
  public String lZ()
  {
    return arU;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    rwv.a().b(this);
  }
  
  public void onDetach()
  {
    QLog.d(TAG, 1, "QCircleFolderRcmdTabFragment->onDetach");
    super.onDetach();
    pcr.a().vq(3);
  }
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedEvent)) && (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 3))
    {
      paramSimpleBaseEvent = ((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId;
      if (!TextUtils.isEmpty(paramSimpleBaseEvent)) {}
    }
    label160:
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_Pdy != null) {
        this.jdField_b_of_type_Pdy.qD(paramSimpleBaseEvent);
      }
      if (this.jdField_a_of_type_Ovg != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Ovg.getDataList();
        if (localArrayList != null)
        {
          int i = 0;
          int j = localArrayList.size();
          label78:
          if (i < j) {
            if (!paramSimpleBaseEvent.equals(((FeedCloudMeta.StFeed)localArrayList.get(i)).id.get())) {}
          }
          for (;;)
          {
            if (i < 0) {
              break label160;
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
            break label78;
            if (!(paramSimpleBaseEvent instanceof QCircleLazyLoadTabEvent)) {
              break;
            }
            biL();
            return;
            i = -1;
          }
        }
      }
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(TAG, 1, "QCircleFolderRcmdTabFragment->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (pcr.a().ey(3)) {
        pcr.a().aX(getActivity().getIntent());
      }
      pco.h("", 23, 1L);
      return;
    }
    pcr.a().vq(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleFolderRcmdTabFragment
 * JD-Core Version:    0.7.0.1
 */