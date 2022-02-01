import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class rxn
  extends rxu<rxq>
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean aKr;
  private SparseIntArray H = new SparseIntArray();
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  private rxj jdField_a_of_type_Rxj;
  private int bvL;
  private int bvM;
  private final ConcurrentHashMap<String, rxn.b> cs = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, rxq> ct = new ConcurrentHashMap();
  private RecyclerView.ViewHolder e;
  private final ViewTreeObserver.OnGlobalLayoutListener f = new rxp(this);
  private final CopyOnWriteArrayList<rxn.c> x = new CopyOnWriteArrayList();
  
  public rxn(BlockContainer paramBlockContainer)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = paramBlockContainer;
    setHasStableIds(true);
  }
  
  private boolean Mf()
  {
    return (this.bvL != 0) && (this.bvL >= this.bvM);
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, rxq paramrxq, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramrxq.getSpanCount(paramViewHolder.getLayoutPosition() - paramrxq.getPositionOffsetStart()) == 1) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void a(String paramString, rxn.b paramb)
  {
    if (this.x.size() > 0)
    {
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext()) {
        ((rxn.c)localIterator.next()).handleShareDataChange(paramString, paramb);
      }
    }
  }
  
  private void b(rxq paramrxq, int paramInt)
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext()) {
      ((rxq)localIterator.next()).handleBlockChange(paramrxq, paramInt);
    }
  }
  
  private void uo(boolean paramBoolean)
  {
    if (isLoading())
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore is loading:" + hashCode());
      return;
    }
    if (this.bvM == 0)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore maxCount 0 hashCode:" + hashCode());
      return;
    }
    if (rym.a(this.mRecyclerView) == -1)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore not renderReady hashCode:" + hashCode());
      return;
    }
    if (Mf())
    {
      QLog.e("CMADebugTAG", 1, "isNeedTryToLoadMore invalid hashCode:" + hashCode());
      return;
    }
    if ((this.mRecyclerView != null) && (!paramBoolean))
    {
      this.bvL += 1;
      bxl();
      QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore try to loadMore Success hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
      return;
    }
    this.bvL = 0;
    QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore reset hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
  }
  
  public GridLayoutManager.SpanSizeLookup a()
  {
    return new rxo(this);
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mDataList.size() == 0)
    {
      if (this.e == null) {
        this.e = new rxn.a(new View(paramViewGroup.getContext()));
      }
      return this.e;
    }
    if (paramInt == -99999) {
      return super.onCreateViewHolder(paramViewGroup, paramInt);
    }
    int k = this.H.get(paramInt);
    int i = paramInt;
    if (k != 0)
    {
      i = 0;
      int j = 0;
      while (i < k)
      {
        j += ((rxq)this.mDataList.get(i)).getViewTypeCount();
        i += 1;
      }
      i = paramInt - j;
    }
    if (aKr) {
      Log.d("CMADebugTAG|" + ((rxq)this.mDataList.get(k)).getClass().getSimpleName(), "createItemViewHolder ViewType:" + i);
    }
    return ((rxq)this.mDataList.get(k)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public rxj a()
  {
    return this.jdField_a_of_type_Rxj;
  }
  
  public rxq a(int paramInt)
  {
    if (paramInt < getCount())
    {
      int k = this.mDataList.size();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        rxq localrxq = (rxq)this.mDataList.get(paramInt);
        j = localrxq.getItemCount();
        if (i < j) {
          return localrxq;
        }
        i = Math.max(i - j, 0);
        paramInt += 1;
      }
    }
    return null;
  }
  
  public rxq a(String paramString)
  {
    return (rxq)this.ct.get(paramString);
  }
  
  public void a(rxq paramrxq)
  {
    a(paramrxq, -1);
  }
  
  public void a(rxq paramrxq, int paramInt)
  {
    if ((paramrxq != null) && (!this.mDataList.contains(paramrxq)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.mDataList.size();
      }
      if (paramrxq.getUniqueKey() != null) {
        this.ct.put(paramrxq.getUniqueKey(), paramrxq);
      }
      this.mDataList.add(i, paramrxq);
      paramrxq.setBlockMerger(this);
      paramrxq.onAttachedToRecyclerView(getBlockContainer().a());
      b(paramrxq, 1);
      b(paramrxq);
      notifyDataSetChanged();
    }
  }
  
  public void b(rxn.c paramc)
  {
    this.x.add(paramc);
    Iterator localIterator = this.cs.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramc.handleShareDataChange(str, (rxn.b)this.cs.get(str));
    }
  }
  
  public void b(rxq paramrxq)
  {
    if ((paramrxq != null) && (this.mDataList.contains(paramrxq))) {
      this.mUIHandler.post(new BlockMerger.1(this, paramrxq));
    }
  }
  
  public void bxl()
  {
    rxq localrxq = (rxq)this.mDataList.get(this.mDataList.size() - 1);
    if (!getBlockContainer().Me()) {}
    do
    {
      do
      {
        return;
      } while (localrxq.getLoadInfo().isLoading());
      if (localrxq.getLoadInfo().isFinish())
      {
        localrxq.getLoadInfo().setCurrentState(4);
        return;
      }
    } while (this.mDataList.size() <= 0);
    bxo();
    localrxq.getLoadInfo().setCurrentState(3);
    localrxq.loadMoreData(localrxq.getLoadInfo());
  }
  
  public void bxm()
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext())
    {
      rxq localrxq = (rxq)localIterator.next();
      if (!localrxq.isLazyLoad()) {
        localrxq.onInit();
      }
    }
  }
  
  public void bxn()
  {
    this.bvL = 0;
  }
  
  protected void c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int k = this.mDataList.size();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      if (paramInt < k)
      {
        rxq localrxq = (rxq)this.mDataList.get(paramInt);
        j = localrxq.getItemCount();
        if (i < j) {
          localrxq.onBindViewHolder(paramViewHolder, i);
        }
      }
      else
      {
        return;
      }
      i = Math.max(i - j, 0);
      paramInt += 1;
    }
  }
  
  public void c(rxn.c paramc)
  {
    this.x.remove(paramc);
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = null;
    this.cs.clear();
    this.ct.clear();
    this.jdField_a_of_type_Rxj = null;
  }
  
  public BlockContainer getBlockContainer()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  }
  
  public int getCount()
  {
    return n(this.mDataList);
  }
  
  public int getDataNumber()
  {
    return getCount();
  }
  
  public int getItemCount()
  {
    return getCount() + ue();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int k;
    if ((isEnableRefresh()) && (paramInt == 0))
    {
      k = -10000;
      return k;
    }
    int j = getRealPosition(paramInt);
    if (j < getCount())
    {
      int m = -1;
      int n = this.mDataList.size();
      paramInt = 0;
      int i = 0;
      for (;;)
      {
        k = m;
        if (paramInt >= n) {
          break;
        }
        rxq localrxq = (rxq)this.mDataList.get(paramInt);
        k = localrxq.getItemCount();
        if (j < k)
        {
          j = localrxq.getItemViewType(j);
          if (aKr) {
            Log.d("CMADebugTAG|" + localrxq.getClass().getSimpleName(), "getItemViewType ViewType:" + j);
          }
          if (j < 0) {}
          for (;;)
          {
            localrxq.setViewTypeOffset(i);
            this.H.put(j, paramInt);
            return j;
            j += i;
          }
        }
        j = Math.max(j - k, 0);
        if (localrxq.getViewTypeCount() == 0) {
          throw new IllegalArgumentException("HorizontalRVBlock getViewTypeCount() has to be greater than 0");
        }
        i += localrxq.getViewTypeCount();
        paramInt += 1;
      }
    }
    return -99999;
  }
  
  public rxn.b getShareData(String paramString)
  {
    return (rxn.b)this.cs.get(paramString);
  }
  
  public int n(ArrayList<rxq> paramArrayList)
  {
    try
    {
      int m = paramArrayList.size();
      int k = 0;
      int i = 0;
      int j = i;
      if (k < m)
      {
        if (auqt.b(k, paramArrayList)) {
          return i;
        }
        rxq localrxq = (rxq)paramArrayList.get(k);
        j = i;
        if (localrxq != null) {
          if (!isEnableRefresh()) {
            break label149;
          }
        }
        label149:
        for (j = 1;; j = 0)
        {
          localrxq.setGlobalPositionOffset(j + i);
          i += localrxq.getItemCount();
          j = i;
          if (aKr)
          {
            Log.d("CMADebugTAG|" + localrxq.getClass().getSimpleName(), "size:" + localrxq.getItemCount());
            j = i;
          }
          k += 1;
          i = j;
          break;
        }
      }
      return j;
    }
    catch (Exception paramArrayList)
    {
      j = 0;
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((rxq)this.mDataList.get(i)).onActivityDestroyed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((rxq)this.mDataList.get(i)).onActivityPaused(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((rxq)this.mDataList.get(i)).onActivityResult(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((rxq)this.mDataList.get(i)).onActivityResumed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((rxq)this.mDataList.get(i)).onActivityStarted(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((rxq)this.mDataList.get(i)).onActivityStopped(paramActivity);
      i += 1;
    }
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
  
  public boolean onBackEvent()
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext()) {
      if (((rxq)localIterator.next()).onBackEvent()) {
        return true;
      }
    }
    return false;
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    int j = this.mDataList.size();
    int i = 0;
    while (i < j)
    {
      ((rxq)this.mDataList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
    paramRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.f);
  }
  
  public void onRefresh()
  {
    super.onRefresh();
    if (this.mDataList.size() > 0) {
      getBlockContainer().setRefreshing(true);
    }
    int i = 0;
    while (i < this.mDataList.size())
    {
      rxq localrxq = (rxq)this.mDataList.get(i);
      if (localrxq.isEnableRefresh()) {
        localrxq.onRefreshData();
      }
      i += 1;
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    boolean bool = localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    if ((bool) && (((paramViewHolder instanceof rxu.a)) || ((paramViewHolder instanceof rxu.b)))) {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
    }
    for (;;)
    {
      return;
      int j = getRealPosition(paramViewHolder.getAdapterPosition());
      if (j >= 0)
      {
        int k = this.mDataList.size();
        int i = 0;
        while (i < k)
        {
          rxq localrxq = (rxq)this.mDataList.get(i);
          int m = localrxq.getItemCount();
          if (j < m)
          {
            if (bool) {
              a(paramViewHolder, localrxq, localLayoutParams);
            }
            localrxq.onViewAttachedToWindow(paramViewHolder);
            return;
          }
          j = Math.max(j - m, 0);
          i += 1;
        }
      }
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    int j = getRealPosition(paramViewHolder.getAdapterPosition());
    if (j < 0) {}
    for (;;)
    {
      return;
      int k = this.mDataList.size();
      int i = 0;
      while (i < k)
      {
        rxs localrxs = (rxs)this.mDataList.get(i);
        int m = localrxs.getItemCount();
        if (j < m)
        {
          localrxs.onViewDetachedFromWindow(paramViewHolder);
          return;
        }
        j = Math.max(j - m, 0);
        i += 1;
      }
    }
  }
  
  public void setBlockWrapper(rxj paramrxj)
  {
    this.jdField_a_of_type_Rxj = paramrxj;
  }
  
  public void setShareData(String paramString, rxn.b paramb)
  {
    if (paramb == null)
    {
      QLog.w(getClass().getSimpleName(), 1, "setShareData null");
      return;
    }
    this.cs.put(paramString, paramb);
    a(paramString, paramb);
  }
  
  public void yf(int paramInt)
  {
    this.bvM = paramInt;
    if (this.mRecyclerView != null) {
      this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
    }
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    public a(View paramView)
    {
      super();
    }
  }
  
  public static class b
  {
    public boolean aKs;
    public Object by;
    
    public b(Object paramObject)
    {
      this.by = paramObject;
    }
    
    public b(Object paramObject, boolean paramBoolean)
    {
      this.by = paramObject;
      this.aKs = paramBoolean;
    }
  }
  
  public static abstract interface c
  {
    public abstract void handleShareDataChange(String paramString, rxn.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxn
 * JD-Core Version:    0.7.0.1
 */