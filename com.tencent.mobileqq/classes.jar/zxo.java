import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class zxo
  extends zyb<zxu>
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new zxq(this);
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  private final ConcurrentHashMap<String, zxs> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final CopyOnWriteArrayList<zxt> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private zxi jdField_a_of_type_Zxi;
  private int jdField_b_of_type_Int;
  private final ConcurrentHashMap<String, zxu> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public zxo(BlockContainer paramBlockContainer)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = paramBlockContainer;
    setHasStableIds(true);
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, zxu paramzxu, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramzxu.getSpanCount(paramViewHolder.getLayoutPosition() - paramzxu.getPositionOffsetStart()) == 1) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void b(String paramString, zxs paramzxs)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((zxt)localIterator.next()).handleShareDataChange(paramString, paramzxs);
      }
    }
  }
  
  private void b(zxu paramzxu, int paramInt)
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext()) {
      ((zxu)localIterator.next()).handleBlockChange(paramzxu, paramInt);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.mDataList.size() == 0)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore mDataList.size() == 0" + hashCode());
      return;
    }
    zxu localzxu = (zxu)this.mDataList.get(this.mDataList.size() - 1);
    if (localzxu == null)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore adapter == null" + hashCode());
      return;
    }
    if (localzxu.getLoadInfo().b())
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore is loading:" + hashCode());
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore maxCount 0 hashCode:" + hashCode());
      return;
    }
    int i = zzi.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    if (i == -1)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore not renderReady hashCode:" + hashCode());
      return;
    }
    if (i < localzxu.getItemCount() - 1)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore enough to scroll hashCode:" + hashCode());
      return;
    }
    if (f())
    {
      QLog.e("CMADebugTAG", 1, "isNeedTryToLoadMore invalid hashCode:" + hashCode());
      return;
    }
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) && (!paramBoolean))
    {
      this.jdField_a_of_type_Int += 1;
      b();
      QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore try to loadMore Success hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
      return;
    }
    this.jdField_a_of_type_Int = 0;
    QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore reset hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
  }
  
  private boolean f()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int);
  }
  
  public int a()
  {
    return a(this.mDataList);
  }
  
  public int a(ArrayList<zxu> paramArrayList)
  {
    try
    {
      int m = paramArrayList.size();
      int k = 0;
      int i = 0;
      int j = i;
      if (k < m)
      {
        if (bkfj.a(k, paramArrayList)) {
          return i;
        }
        zxu localzxu = (zxu)paramArrayList.get(k);
        j = i;
        if (localzxu != null) {
          if (!b()) {
            break label148;
          }
        }
        label148:
        for (j = 1;; j = 0)
        {
          localzxu.setGlobalPositionOffset(j + i);
          i += localzxu.getItemCount();
          j = i;
          if (jdField_a_of_type_Boolean)
          {
            Log.d("CMADebugTAG|" + localzxu.getClass().getSimpleName(), "size:" + localzxu.getItemCount());
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
  
  public GridLayoutManager.SpanSizeLookup a()
  {
    return new zxp(this);
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mDataList.size() == 0)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = new zxr(this, new View(paramViewGroup.getContext()));
      }
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    }
    if (paramInt == -99999) {
      return super.onCreateViewHolder(paramViewGroup, paramInt);
    }
    int k = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt);
    int i = paramInt;
    if (k != 0)
    {
      i = 0;
      int j = 0;
      while (i < k)
      {
        j += ((zxu)this.mDataList.get(i)).getViewTypeCount();
        i += 1;
      }
      i = paramInt - j;
    }
    if (jdField_a_of_type_Boolean) {
      Log.d("CMADebugTAG|" + ((zxu)this.mDataList.get(k)).getClass().getSimpleName(), "createItemViewHolder ViewType:" + i);
    }
    return ((zxu)this.mDataList.get(k)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public BlockContainer a()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  }
  
  public zxi a()
  {
    return this.jdField_a_of_type_Zxi;
  }
  
  public zxs a(String paramString)
  {
    return (zxs)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public zxu a(int paramInt)
  {
    if (paramInt < a())
    {
      int k = this.mDataList.size();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        zxu localzxu = (zxu)this.mDataList.get(paramInt);
        j = localzxu.getItemCount();
        if (i < j) {
          return localzxu;
        }
        i = Math.max(i - j, 0);
        paramInt += 1;
      }
    }
    return null;
  }
  
  public zxu a(String paramString)
  {
    return (zxu)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    super.a();
    if (this.mDataList.size() > 0) {
      a().setRefreshing(true);
    }
    int i = 0;
    while (i < this.mDataList.size())
    {
      zxu localzxu = (zxu)this.mDataList.get(i);
      if (localzxu.isEnableRefresh()) {
        localzxu.onRefreshData();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((zxu)this.mDataList.get(i)).onActivityResult(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int k = this.mDataList.size();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      if (paramInt < k)
      {
        zxu localzxu = (zxu)this.mDataList.get(paramInt);
        j = localzxu.getItemCount();
        if (i < j) {
          localzxu.onBindViewHolder(paramViewHolder, i);
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
  
  public void a(String paramString, zxs paramzxs)
  {
    if (paramzxs == null)
    {
      QLog.w(getClass().getSimpleName(), 1, "setShareData null");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramzxs);
    b(paramString, paramzxs);
  }
  
  public void a(zxi paramzxi)
  {
    this.jdField_a_of_type_Zxi = paramzxi;
  }
  
  public void a(zxt paramzxt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramzxt);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramzxt.handleShareDataChange(str, (zxs)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
    }
  }
  
  public void a(zxu paramzxu)
  {
    a(paramzxu, -1);
  }
  
  public void a(zxu paramzxu, int paramInt)
  {
    if ((paramzxu != null) && (!this.mDataList.contains(paramzxu)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.mDataList.size();
      }
      if (paramzxu.getUniqueKey() != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramzxu.getUniqueKey(), paramzxu);
      }
      this.mDataList.add(i, paramzxu);
      paramzxu.setBlockMerger(this);
      paramzxu.onAttachedToRecyclerView(a().a());
      b(paramzxu, 1);
      a(paramzxu);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext()) {
      if (((zxu)localIterator.next()).onBackEvent()) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    zxu localzxu = (zxu)this.mDataList.get(this.mDataList.size() - 1);
    if (!a().b()) {}
    do
    {
      do
      {
        return;
      } while (localzxu.getLoadInfo().b());
      if (localzxu.getLoadInfo().a())
      {
        localzxu.getLoadInfo().a(4);
        return;
      }
    } while (this.mDataList.size() <= 0);
    f();
    localzxu.getLoadInfo().a(3);
    localzxu.loadMoreData(localzxu.getLoadInfo());
  }
  
  public void b(zxt paramzxt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramzxt);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Zxi = null;
  }
  
  public void d()
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext())
    {
      zxu localzxu = (zxu)localIterator.next();
      if (!localzxu.isLazyLoad()) {
        localzxu.onInit();
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int getDataNumber()
  {
    return a();
  }
  
  public int getItemCount()
  {
    return a() + b();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int k;
    if ((b()) && (paramInt == 0))
    {
      k = -10000;
      return k;
    }
    int j = a(paramInt);
    if (j < a())
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
        zxu localzxu = (zxu)this.mDataList.get(paramInt);
        k = localzxu.getItemCount();
        if (j < k)
        {
          j = localzxu.getItemViewType(j);
          if (jdField_a_of_type_Boolean) {
            Log.d("CMADebugTAG|" + localzxu.getClass().getSimpleName(), "getItemViewType ViewType:" + j);
          }
          if (j < 0) {}
          for (;;)
          {
            localzxu.setViewTypeOffset(i);
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, paramInt);
            return j;
            j += i;
          }
        }
        j = Math.max(j - k, 0);
        if (localzxu.getViewTypeCount() == 0) {
          throw new IllegalArgumentException("HorizontalRVBlock getViewTypeCount() has to be greater than 0");
        }
        i += localzxu.getViewTypeCount();
        paramInt += 1;
      }
    }
    return -99999;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((zxu)this.mDataList.get(i)).onActivityDestroyed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((zxu)this.mDataList.get(i)).onActivityPaused(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((zxu)this.mDataList.get(i)).onActivityResumed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((zxu)this.mDataList.get(i)).onActivityStarted(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((zxu)this.mDataList.get(i)).onActivityStopped(paramActivity);
      i += 1;
    }
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    int j = this.mDataList.size();
    int i = 0;
    while (i < j)
    {
      ((zxu)this.mDataList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
    paramRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    boolean bool = localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    if ((bool) && (((paramViewHolder instanceof zyd)) || ((paramViewHolder instanceof zye)))) {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
    }
    for (;;)
    {
      return;
      int j = a(paramViewHolder.getAdapterPosition());
      if (j >= 0)
      {
        int k = this.mDataList.size();
        int i = 0;
        while (i < k)
        {
          zxu localzxu = (zxu)this.mDataList.get(i);
          int m = localzxu.getItemCount();
          if (j < m)
          {
            if (bool) {
              a(paramViewHolder, localzxu, localLayoutParams);
            }
            localzxu.onViewAttachedToWindow(paramViewHolder);
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
    int j = a(paramViewHolder.getAdapterPosition());
    if (j < 0) {}
    for (;;)
    {
      return;
      int k = this.mDataList.size();
      int i = 0;
      while (i < k)
      {
        zxx localzxx = (zxx)this.mDataList.get(i);
        int m = localzxx.getItemCount();
        if (j < m)
        {
          localzxx.onViewDetachedFromWindow(paramViewHolder);
          return;
        }
        j = Math.max(j - m, 0);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxo
 * JD-Core Version:    0.7.0.1
 */