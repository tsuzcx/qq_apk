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
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class zoo
  extends zpc<zou>
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new zoq(this);
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  private final ConcurrentHashMap<String, zos> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final CopyOnWriteArrayList<zot> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private zoj jdField_a_of_type_Zoj;
  private int jdField_b_of_type_Int;
  private final ConcurrentHashMap<String, zou> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public zoo(BlockContainer paramBlockContainer)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = paramBlockContainer;
    setHasStableIds(true);
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, zou paramzou, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramViewHolder != null) && (paramzou != null) && (paramzou.c(paramViewHolder.getLayoutPosition() - paramzou.b()) == 1)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void b(String paramString, zos paramzos)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((zot)localIterator.next()).a(paramString, paramzos);
      }
    }
  }
  
  private void b(zou paramzou, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((zou)localIterator.next()).a(paramzou, paramInt);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore mDataList.size() == 0" + hashCode());
      return;
    }
    zou localzou = (zou)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (localzou == null)
    {
      QLog.i("CMADebugTAG", 2, "isNeedTryToLoadMore adapter == null" + hashCode());
      return;
    }
    if (localzou.a().b())
    {
      QLog.i("CMADebugTAG", 2, "isNeedTryToLoadMore is loading:" + hashCode());
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      QLog.i("CMADebugTAG", 2, "isNeedTryToLoadMore maxCount 0 hashCode:" + hashCode());
      return;
    }
    int i = zpp.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    if (i == -1)
    {
      QLog.i("CMADebugTAG", 2, "isNeedTryToLoadMore not renderReady hashCode:" + hashCode());
      return;
    }
    if (i < localzou.getItemCount() - 1)
    {
      QLog.i("CMADebugTAG", 2, "isNeedTryToLoadMore enough to scroll hashCode:" + hashCode());
      return;
    }
    if (f())
    {
      QLog.e("CMADebugTAG", 2, "isNeedTryToLoadMore invalid hashCode:" + hashCode());
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
    return a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public int a(ArrayList<zou> paramArrayList)
  {
    try
    {
      int m = paramArrayList.size();
      int k = 0;
      int i = 0;
      int j = i;
      if (k < m)
      {
        if (ArrayUtils.isOutOfArrayIndex(k, paramArrayList)) {
          return i;
        }
        zou localzou = (zou)paramArrayList.get(k);
        j = i;
        if (localzou != null) {
          if (!b()) {
            break label148;
          }
        }
        label148:
        for (j = 1;; j = 0)
        {
          localzou.a(j + i);
          i += localzou.getItemCount();
          j = i;
          if (jdField_a_of_type_Boolean)
          {
            Log.d("CMADebugTAG|" + localzou.getClass().getSimpleName(), "size:" + localzou.getItemCount());
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
    return new zop(this);
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = new zor(this, new View(paramViewGroup.getContext()));
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
        j += ((zou)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        i += 1;
      }
      i = paramInt - j;
    }
    if (jdField_a_of_type_Boolean) {
      Log.d("CMADebugTAG|" + ((zou)this.jdField_a_of_type_JavaUtilArrayList.get(k)).getClass().getSimpleName(), "createItemViewHolder ViewType:" + i);
    }
    return ((zou)this.jdField_a_of_type_JavaUtilArrayList.get(k)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public BlockContainer a()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  }
  
  public zos a(String paramString)
  {
    return (zos)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public zou a(int paramInt)
  {
    if (paramInt < a())
    {
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        zou localzou = (zou)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localzou.getItemCount();
        if (i < j) {
          return localzou;
        }
        i = Math.max(i - j, 0);
        paramInt += 1;
      }
    }
    return null;
  }
  
  public zou a(String paramString)
  {
    return (zou)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      a().setRefreshing(true);
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      zou localzou = (zou)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localzou.a()) {
        localzou.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
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
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((zou)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      if (paramInt < k)
      {
        zou localzou = (zou)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localzou.getItemCount();
        if (i < j) {
          localzou.onBindViewHolder(paramViewHolder, i);
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
  
  public void a(String paramString, zos paramzos)
  {
    if (paramzos == null)
    {
      QLog.w(getClass().getSimpleName(), 1, "setShareData null");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramzos);
    b(paramString, paramzos);
  }
  
  public void a(zoj paramzoj)
  {
    this.jdField_a_of_type_Zoj = paramzoj;
  }
  
  public void a(zot paramzot)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramzot);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramzot.a(str, (zos)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
    }
  }
  
  public void a(zou paramzou)
  {
    a(paramzou, -1);
  }
  
  public void a(zou paramzou, int paramInt)
  {
    if ((paramzou != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramzou)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if (paramzou.a() != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramzou.a(), paramzou);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(i, paramzou);
      paramzou.a(this);
      paramzou.onAttachedToRecyclerView(a().a());
      b(paramzou, 1);
      a(paramzou);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((zou)localIterator.next()).c()) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    zou localzou = (zou)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (!a().b()) {}
    do
    {
      do
      {
        return;
      } while (localzou.a().b());
      if (localzou.a().a())
      {
        localzou.a().a(4);
        return;
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
    f();
    localzou.a().a(3);
    localzou.b(localzou.a());
  }
  
  public void b(zot paramzot)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramzot);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Zoj = null;
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      zou localzou = (zou)localIterator.next();
      if (!localzou.b()) {
        localzou.b();
      }
    }
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
      int n = this.jdField_a_of_type_JavaUtilArrayList.size();
      paramInt = 0;
      int i = 0;
      for (;;)
      {
        k = m;
        if (paramInt >= n) {
          break;
        }
        zou localzou = (zou)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        k = localzou.getItemCount();
        if (j < k)
        {
          j = localzou.getItemViewType(j);
          if (jdField_a_of_type_Boolean) {
            Log.d("CMADebugTAG|" + localzou.getClass().getSimpleName(), "getItemViewType ViewType:" + j);
          }
          if (j < 0) {}
          for (;;)
          {
            localzou.b(i);
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, paramInt);
            return j;
            j += i;
          }
        }
        j = Math.max(j - k, 0);
        if (localzou.a() == 0) {
          throw new IllegalArgumentException("HorizontalRVBlock getViewTypeCount() has to be greater than 0");
        }
        i += localzou.a();
        paramInt += 1;
      }
    }
    return -99999;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((zou)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityDestroyed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((zou)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityPaused(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((zou)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityResumed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((zou)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityStarted(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((zou)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityStopped(paramActivity);
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
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((zou)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
    paramRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    boolean bool = localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    if ((bool) && (((paramViewHolder instanceof zpe)) || ((paramViewHolder instanceof zpf)))) {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
    }
    for (;;)
    {
      return;
      int j = a(paramViewHolder.getAdapterPosition());
      if (j >= 0)
      {
        int k = this.jdField_a_of_type_JavaUtilArrayList.size();
        int i = 0;
        while (i < k)
        {
          zou localzou = (zou)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          int m = localzou.getItemCount();
          if (j < m)
          {
            if (bool) {
              a(paramViewHolder, localzou, localLayoutParams);
            }
            localzou.onViewAttachedToWindow(paramViewHolder);
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
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < k)
      {
        zox localzox = (zox)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        int m = localzox.getItemCount();
        if (j < m)
        {
          localzox.onViewDetachedFromWindow(paramViewHolder);
          return;
        }
        j = Math.max(j - m, 0);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zoo
 * JD-Core Version:    0.7.0.1
 */