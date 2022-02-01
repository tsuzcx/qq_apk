package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import auqt;
import avre;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import oum;
import ovf;
import ovv;
import rwv;
import rwx;
import rxn;
import rxq;
import rxt;

public abstract class QCircleFakeAdapter
  extends rxq
  implements rwx
{
  private static boolean ayG;
  private boolean ayE;
  private boolean ayF = true;
  private HashMap<String, Integer> eV = new HashMap();
  private HashMap<String, Runnable> eW = new HashMap();
  private List<FeedCloudMeta.StFeed> ll = new ArrayList(5);
  
  public QCircleFakeAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private boolean HB()
  {
    boolean bool = false;
    if (getDataList().size() > 0) {
      bool = ((FeedCloudMeta.StFeed)getDataList().get(0)).id.get().startsWith("qcircle_fakeid_");
    }
    return bool;
  }
  
  private void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("fakeFeed state:").append(paramQCircleFeedEvent.mState).append(",fakeId:").append(paramQCircleFeedEvent.mTargetId).append(",fake listSize:");
    if (paramQCircleFeedEvent.mFakeFeedDataList == null) {}
    for (int i = 0;; i = paramQCircleFeedEvent.mFakeFeedDataList.size())
    {
      QLog.d("QCircleFakeAdapter", 2, i);
      if (paramQCircleFeedEvent != null) {}
      switch (paramQCircleFeedEvent.mState)
      {
      default: 
        return;
      }
    }
    c(paramQCircleFeedEvent);
    return;
    e(paramQCircleFeedEvent);
    return;
    d(paramQCircleFeedEvent);
    return;
    a(paramQCircleFeedEvent, false);
    return;
    b(paramQCircleFeedEvent);
  }
  
  private int aZ(String paramString)
  {
    int i = 0;
    FeedCloudMeta.StFeed localStFeed;
    int j;
    if (i < getDataList().size())
    {
      localStFeed = (FeedCloudMeta.StFeed)getDataList().get(i);
      if ((paramString.startsWith("qcircle_fakeid_")) && (!localStFeed.id.get().startsWith("qcircle_fakeid_"))) {
        QLog.d("QCircleFakeAdapter", 2, "has none fakeFeeds");
      }
    }
    else
    {
      j = -1;
    }
    do
    {
      return j;
      if (!localStFeed.isRecomFd.get()) {
        break;
      }
      j = i;
    } while (paramString.equals(localStFeed.recomForward.id.get()));
    while (!paramString.equals(localStFeed.id.get()))
    {
      i += 1;
      break;
    }
    QLog.d("QCircleFakeAdapter", 2, "find fakeid:" + paramString);
    return i;
  }
  
  private List<FeedCloudMeta.StFeed> af(List<FeedCloudMeta.StFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)paramList.next();
        if (c(localStFeed)) {
          localArrayList.add(localStFeed);
        }
      }
    }
    return localArrayList;
  }
  
  private void b(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (paramQCircleFeedEvent != null)
    {
      oum.a("qcircle_fakeid_" + paramQCircleFeedEvent.mTargetId, Integer.valueOf(paramQCircleFeedEvent.mState));
      QLog.d("QCircleFakeAdapter", 4, "fake feed composite success");
    }
  }
  
  private void bhQ()
  {
    getMainHandler().post(new QCircleFakeAdapter.2(this));
  }
  
  private void bhR()
  {
    if (getDataList().size() > 0)
    {
      Iterator localIterator = getDataList().iterator();
      while (localIterator.hasNext()) {
        if (((FeedCloudMeta.StFeed)localIterator.next()).id.get().startsWith("qcircle_fakeid_")) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void c(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (!this.ayF) {
      return;
    }
    this.ayF = false;
    if ((paramQCircleFeedEvent.mFakeFeedDataList != null) && (paramQCircleFeedEvent.mFakeFeedDataList.size() > 0))
    {
      ayG = true;
      paramQCircleFeedEvent = af(paramQCircleFeedEvent.mFakeFeedDataList);
      getMainHandler().post(new QCircleFakeAdapter.1(this, paramQCircleFeedEvent));
      return;
    }
    ayG = false;
    bhQ();
  }
  
  private void d(QCircleFeedEvent paramQCircleFeedEvent)
  {
    int i = aZ(paramQCircleFeedEvent.mTargetId);
    if (i != -1) {
      getMainHandler().post(new QCircleFakeAdapter.3(this, i));
    }
  }
  
  private void e(QCircleFeedEvent paramQCircleFeedEvent)
  {
    getMainHandler().post(new QCircleFakeAdapter.4(this, paramQCircleFeedEvent));
  }
  
  private String lS()
  {
    if ((getInteractor() instanceof ovv)) {
      return ((ovv)getInteractor()).b().getTagInfo().tagName.get();
    }
    return "";
  }
  
  private void qo(String paramString)
  {
    if (this.ll.size() > 0)
    {
      Iterator localIterator = this.ll.iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals(((FeedCloudMeta.StFeed)localIterator.next()).id.get())) {
          localIterator.remove();
        }
      }
    }
  }
  
  public boolean HC()
  {
    return this.ll.size() > 0;
  }
  
  protected void a(QCircleFeedEvent paramQCircleFeedEvent, boolean paramBoolean)
  {
    VSNetworkHelper.a().a(new QCircleGetFeedDetailRequest(paramQCircleFeedEvent.mSingleFakeFeed.id.get(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramQCircleFeedEvent.mSingleFakeFeed.createTime.get(), true), new ovf(this, paramQCircleFeedEvent, paramBoolean));
  }
  
  public void bhS()
  {
    if (this.ayE)
    {
      this.ayF = true;
      avre.a().eBI();
    }
  }
  
  public List<FeedCloudMeta.StFeed> bs()
  {
    if ((this.mDataList == null) || (this.mDataList.size() == 0)) {
      return null;
    }
    if (HC()) {
      this.mDataList.removeAll(this.ll);
    }
    return this.mDataList;
  }
  
  protected boolean c(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (getExtraTypeInfo() != null) && (getExtraTypeInfo().pageType == 7))
    {
      Object localObject = paramStFeed.tagInfos.get();
      paramStFeed = lS();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((FeedCloudMeta.StTagInfo)((Iterator)localObject).next()).tagName.get().equals(paramStFeed)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public void f(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (!this.eV.containsKey(paramQCircleFeedEvent.mTargetId)) {
      this.eV.put(paramQCircleFeedEvent.mTargetId, Integer.valueOf(1));
    }
    Object localObject;
    for (int i = 2000;; i = ((Integer)localObject).intValue() * 2000)
    {
      QLog.d("QCircleFakeAdapter", 1, " retry count delay:" + i);
      localObject = new RetryRunnable(this, paramQCircleFeedEvent);
      this.eW.put(paramQCircleFeedEvent.mTargetId, localObject);
      getMainHandler().postDelayed((Runnable)localObject, i);
      return;
      localObject = (Integer)this.eV.get(paramQCircleFeedEvent.mTargetId);
      if (((Integer)localObject).intValue() >= 3)
      {
        if (getContext() != null) {
          QQToast.a(getContext(), 0, 2131697486, 0).show();
        }
        QLog.d("QCircleFakeAdapter", 1, "max retry return");
        return;
      }
      localObject = Integer.valueOf(((Integer)localObject).intValue() + 1);
      this.eV.put(paramQCircleFeedEvent.mTargetId, localObject);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCirclePublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public void notifyLoadingComplete(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    int i;
    rxn localrxn;
    if ((getBlockContainer() != null) && (getBlockMerger() != null))
    {
      getLoadInfo().setCurrentState(4);
      getBlockContainer().setRefreshing(false);
      if (isLastPeerBlock())
      {
        if (getItemCount() != 0) {
          break label74;
        }
        i = 1;
        localrxn = getBlockMerger();
        if ((!paramBoolean2) || (i != 0)) {
          break label79;
        }
      }
    }
    label74:
    label79:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      localrxn.ay(paramBoolean1, paramBoolean2);
      return;
      i = 0;
      break;
    }
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    if (this.ayE) {
      rwv.a().a(this);
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.ayE) {
      rwv.a().b(this);
    }
    if (this.eW.size() > 0)
    {
      paramRecyclerView = this.eW.keySet().iterator();
      while (paramRecyclerView.hasNext())
      {
        String str = (String)paramRecyclerView.next();
        getMainHandler().removeCallbacks((Runnable)this.eW.get(str));
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      a((QCircleFeedEvent)paramSimpleBaseEvent);
    }
  }
  
  public void re(boolean paramBoolean)
  {
    this.ayE = paramBoolean;
  }
  
  public void setDatas(ArrayList paramArrayList)
  {
    this.mDataList.clear();
    notifyDataSetChanged();
    if (paramArrayList == null) {
      return;
    }
    if (this.ll.size() > 0) {
      this.mDataList.addAll(this.ll);
    }
    this.mDataList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  protected void vd(int paramInt)
  {
    if (auqt.b(paramInt, getDataList())) {
      return;
    }
    getDataList().remove(paramInt);
    notifyItemRemoved(paramInt);
  }
  
  public static class RetryRunnable
    implements Runnable
  {
    private QCircleFakeAdapter a;
    private QCircleFeedEvent b;
    
    public RetryRunnable(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent)
    {
      this.a = paramQCircleFakeAdapter;
      this.b = paramQCircleFeedEvent;
    }
    
    public void run()
    {
      if ((this.a != null) && (this.b != null))
      {
        this.a.a(this.b, true);
        return;
      }
      QLog.d("QCircleFakeAdapter", 1, "adapter or event is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter
 * JD-Core Version:    0.7.0.1
 */