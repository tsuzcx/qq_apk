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
import com.tencent.biz.subscribe.component.base.ComponentMergeAdapter.1;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class yib
  extends yij<yhy>
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new yid(this);
  private ComponentPageView jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  private final ConcurrentHashMap<String, yif> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final CopyOnWriteArrayList<yig> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private tvw jdField_a_of_type_Tvw;
  private int jdField_b_of_type_Int;
  private final ConcurrentHashMap<String, yhy> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public yib(ComponentPageView paramComponentPageView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = paramComponentPageView;
    setHasStableIds(true);
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, yhy paramyhy, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramyhy.getSpanCount(paramViewHolder.getLayoutPosition() - paramyhy.getPositionOffsetStart()) == 1) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void b(String paramString, yif paramyif)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((yig)localIterator.next()).handleShareDataChange(paramString, paramyif);
      }
    }
  }
  
  private void b(yhy paramyhy, int paramInt)
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext()) {
      ((yhy)localIterator.next()).handleComponentAdapterChange(paramyhy, paramInt);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (f())
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore is loading:" + hashCode());
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore maxCount 0 hashCode:" + hashCode());
      return;
    }
    if (yiv.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView) == -1)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore not renderReady hashCode:" + hashCode());
      return;
    }
    if (g())
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
  
  private boolean g()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int);
  }
  
  public int a()
  {
    return a(this.mDataList);
  }
  
  public int a(ArrayList<yhy> paramArrayList)
  {
    try
    {
      int m = paramArrayList.size();
      int k = 0;
      int i = 0;
      int j = i;
      if (k < m)
      {
        if (bhrz.a(k, paramArrayList)) {
          return i;
        }
        yhy localyhy = (yhy)paramArrayList.get(k);
        j = i;
        if (localyhy != null) {
          if (!b()) {
            break label148;
          }
        }
        label148:
        for (j = 1;; j = 0)
        {
          localyhy.setGlobalPositionOffset(j + i);
          i += localyhy.getItemCount();
          j = i;
          if (jdField_a_of_type_Boolean)
          {
            Log.d("CMADebugTAG|" + localyhy.getClass().getSimpleName(), "size:" + localyhy.getItemCount());
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
    return new yic(this);
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mDataList.size() == 0)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = new yie(this, new View(paramViewGroup.getContext()));
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
        j += ((yhy)this.mDataList.get(i)).getViewTypeCount();
        i += 1;
      }
      i = paramInt - j;
    }
    if (jdField_a_of_type_Boolean) {
      Log.d("CMADebugTAG|" + ((yhy)this.mDataList.get(k)).getClass().getSimpleName(), "createItemViewHolder ViewType:" + i);
    }
    return ((yhy)this.mDataList.get(k)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public ComponentPageView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  }
  
  public tvw a()
  {
    return this.jdField_a_of_type_Tvw;
  }
  
  public yhy a(int paramInt)
  {
    if (paramInt < a())
    {
      int k = this.mDataList.size();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        yhy localyhy = (yhy)this.mDataList.get(paramInt);
        j = localyhy.getItemCount();
        if (i < j) {
          return localyhy;
        }
        i = Math.max(i - j, 0);
        paramInt += 1;
      }
    }
    return null;
  }
  
  public yhy a(String paramString)
  {
    return (yhy)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public yif a(String paramString)
  {
    return (yif)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
      yhy localyhy = (yhy)this.mDataList.get(i);
      if (localyhy.isEnableRefresh()) {
        localyhy.onRefreshData();
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
      ((yhy)this.mDataList.get(i)).onActivityResult(paramInt1, paramInt2, paramIntent);
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
        yhy localyhy = (yhy)this.mDataList.get(paramInt);
        j = localyhy.getItemCount();
        if (i < j) {
          localyhy.onBindViewHolder(paramViewHolder, i);
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
  
  public void a(String paramString, yif paramyif)
  {
    if (paramyif == null)
    {
      QLog.w(getClass().getSimpleName(), 1, "setShareData null");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramyif);
    b(paramString, paramyif);
  }
  
  public void a(tvw paramtvw)
  {
    this.jdField_a_of_type_Tvw = paramtvw;
  }
  
  public void a(yhy paramyhy)
  {
    a(paramyhy, -1);
  }
  
  public void a(yhy paramyhy, int paramInt)
  {
    if ((paramyhy != null) && (!this.mDataList.contains(paramyhy)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.mDataList.size();
      }
      if (paramyhy.getUniqueKey() != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramyhy.getUniqueKey(), paramyhy);
      }
      this.mDataList.add(i, paramyhy);
      paramyhy.setParentAdapter(this);
      paramyhy.onAttachedToRecyclerView(a().a());
      b(paramyhy, 1);
      a(paramyhy);
      notifyDataSetChanged();
    }
  }
  
  public void a(yig paramyig)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramyig);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramyig.handleShareDataChange(str, (yif)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext()) {
      if (((yhy)localIterator.next()).onBackEvent()) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    yhy localyhy = (yhy)this.mDataList.get(this.mDataList.size() - 1);
    if (!a().b()) {}
    do
    {
      do
      {
        return;
      } while (localyhy.getLoadInfo().b());
      if (localyhy.getLoadInfo().a())
      {
        localyhy.getLoadInfo().a(4);
        return;
      }
    } while (this.mDataList.size() <= 0);
    f();
    localyhy.getLoadInfo().a(3);
    localyhy.loadMoreData(localyhy.getLoadInfo());
  }
  
  public void b(yhy paramyhy)
  {
    if ((paramyhy != null) && (this.mDataList.contains(paramyhy))) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ComponentMergeAdapter.1(this, paramyhy));
    }
  }
  
  public void b(yig paramyig)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramyig);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Tvw = null;
  }
  
  public void d()
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext())
    {
      yhy localyhy = (yhy)localIterator.next();
      if (!localyhy.isLazyLoad()) {
        localyhy.onInit();
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
        yhy localyhy = (yhy)this.mDataList.get(paramInt);
        k = localyhy.getItemCount();
        if (j < k)
        {
          j = localyhy.getItemViewType(j);
          if (jdField_a_of_type_Boolean) {
            Log.d("CMADebugTAG|" + localyhy.getClass().getSimpleName(), "getItemViewType ViewType:" + j);
          }
          if (j < 0) {}
          for (;;)
          {
            localyhy.setViewTypeOffset(i);
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, paramInt);
            return j;
            j += i;
          }
        }
        j = Math.max(j - k, 0);
        if (localyhy.getViewTypeCount() == 0) {
          throw new IllegalArgumentException("ComponentAdapter getViewTypeCount() has to be greater than 0");
        }
        i += localyhy.getViewTypeCount();
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
      ((yhy)this.mDataList.get(i)).onActivityDestroyed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((yhy)this.mDataList.get(i)).onActivityPaused(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((yhy)this.mDataList.get(i)).onActivityResumed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((yhy)this.mDataList.get(i)).onActivityStarted(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((yhy)this.mDataList.get(i)).onActivityStopped(paramActivity);
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
      ((yhy)this.mDataList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
    paramRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    boolean bool = localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    if ((bool) && (((paramViewHolder instanceof yil)) || ((paramViewHolder instanceof yim)))) {
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
          yhy localyhy = (yhy)this.mDataList.get(i);
          int m = localyhy.getItemCount();
          if (j < m)
          {
            if (bool) {
              a(paramViewHolder, localyhy, localLayoutParams);
            }
            localyhy.onViewAttachedToWindow(paramViewHolder);
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
        yhw localyhw = (yhw)this.mDataList.get(i);
        int m = localyhw.getItemCount();
        if (j < m)
        {
          localyhw.onViewDetachedFromWindow(paramViewHolder);
          return;
        }
        j = Math.max(j - m, 0);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yib
 * JD-Core Version:    0.7.0.1
 */