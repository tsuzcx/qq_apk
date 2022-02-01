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

public class yzj
  extends yzx<yzp>
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new yzl(this);
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  private final ConcurrentHashMap<String, yzn> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final CopyOnWriteArrayList<yzo> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private yze jdField_a_of_type_Yze;
  private int jdField_b_of_type_Int;
  private final ConcurrentHashMap<String, yzp> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public yzj(BlockContainer paramBlockContainer)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = paramBlockContainer;
    setHasStableIds(true);
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, yzp paramyzp, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramViewHolder != null) && (paramyzp != null) && (paramyzp.c(paramViewHolder.getLayoutPosition() - paramyzp.b()) == 1)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void b(String paramString, yzn paramyzn)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((yzo)localIterator.next()).a(paramString, paramyzn);
      }
    }
  }
  
  private void b(yzp paramyzp, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((yzp)localIterator.next()).a(paramyzp, paramInt);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore mDataList.size() == 0" + hashCode());
      return;
    }
    yzp localyzp = (yzp)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (localyzp == null)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore adapter == null" + hashCode());
      return;
    }
    if (localyzp.a().b())
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore is loading:" + hashCode());
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore maxCount 0 hashCode:" + hashCode());
      return;
    }
    int i = zak.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    if (i == -1)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore not renderReady hashCode:" + hashCode());
      return;
    }
    if (i < localyzp.getItemCount() - 1)
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
    return a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public int a(ArrayList<yzp> paramArrayList)
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
        yzp localyzp = (yzp)paramArrayList.get(k);
        j = i;
        if (localyzp != null) {
          if (!b()) {
            break label148;
          }
        }
        label148:
        for (j = 1;; j = 0)
        {
          localyzp.a(j + i);
          i += localyzp.getItemCount();
          j = i;
          if (jdField_a_of_type_Boolean)
          {
            Log.d("CMADebugTAG|" + localyzp.getClass().getSimpleName(), "size:" + localyzp.getItemCount());
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
    return new yzk(this);
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = new yzm(this, new View(paramViewGroup.getContext()));
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
        j += ((yzp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        i += 1;
      }
      i = paramInt - j;
    }
    if (jdField_a_of_type_Boolean) {
      Log.d("CMADebugTAG|" + ((yzp)this.jdField_a_of_type_JavaUtilArrayList.get(k)).getClass().getSimpleName(), "createItemViewHolder ViewType:" + i);
    }
    return ((yzp)this.jdField_a_of_type_JavaUtilArrayList.get(k)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public BlockContainer a()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  }
  
  public yzn a(String paramString)
  {
    return (yzn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public yzp a(int paramInt)
  {
    if (paramInt < a())
    {
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        yzp localyzp = (yzp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localyzp.getItemCount();
        if (i < j) {
          return localyzp;
        }
        i = Math.max(i - j, 0);
        paramInt += 1;
      }
    }
    return null;
  }
  
  public yzp a(String paramString)
  {
    return (yzp)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
      yzp localyzp = (yzp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localyzp.a()) {
        localyzp.a();
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
      ((yzp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt1, paramInt2, paramIntent);
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
        yzp localyzp = (yzp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localyzp.getItemCount();
        if (i < j) {
          localyzp.onBindViewHolder(paramViewHolder, i);
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
  
  public void a(String paramString, yzn paramyzn)
  {
    if (paramyzn == null)
    {
      QLog.w(getClass().getSimpleName(), 1, "setShareData null");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramyzn);
    b(paramString, paramyzn);
  }
  
  public void a(yze paramyze)
  {
    this.jdField_a_of_type_Yze = paramyze;
  }
  
  public void a(yzo paramyzo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramyzo);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramyzo.a(str, (yzn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
    }
  }
  
  public void a(yzp paramyzp)
  {
    a(paramyzp, -1);
  }
  
  public void a(yzp paramyzp, int paramInt)
  {
    if ((paramyzp != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramyzp)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if (paramyzp.a() != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramyzp.a(), paramyzp);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(i, paramyzp);
      paramyzp.a(this);
      paramyzp.onAttachedToRecyclerView(a().a());
      b(paramyzp, 1);
      a(paramyzp);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((yzp)localIterator.next()).c()) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    yzp localyzp = (yzp)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (!a().b()) {}
    do
    {
      do
      {
        return;
      } while (localyzp.a().b());
      if (localyzp.a().a())
      {
        localyzp.a().a(4);
        return;
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
    f();
    localyzp.a().a(3);
    localyzp.b(localyzp.a());
  }
  
  public void b(yzo paramyzo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramyzo);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Yze = null;
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      yzp localyzp = (yzp)localIterator.next();
      if (!localyzp.b()) {
        localyzp.b();
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
        yzp localyzp = (yzp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        k = localyzp.getItemCount();
        if (j < k)
        {
          j = localyzp.getItemViewType(j);
          if (jdField_a_of_type_Boolean) {
            Log.d("CMADebugTAG|" + localyzp.getClass().getSimpleName(), "getItemViewType ViewType:" + j);
          }
          if (j < 0) {}
          for (;;)
          {
            localyzp.b(i);
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, paramInt);
            return j;
            j += i;
          }
        }
        j = Math.max(j - k, 0);
        if (localyzp.a() == 0) {
          throw new IllegalArgumentException("HorizontalRVBlock getViewTypeCount() has to be greater than 0");
        }
        i += localyzp.a();
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
      ((yzp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityDestroyed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((yzp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityPaused(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((yzp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityResumed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((yzp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityStarted(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((yzp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityStopped(paramActivity);
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
      ((yzp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
    paramRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    boolean bool = localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    if ((bool) && (((paramViewHolder instanceof yzz)) || ((paramViewHolder instanceof zaa)))) {
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
          yzp localyzp = (yzp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          int m = localyzp.getItemCount();
          if (j < m)
          {
            if (bool) {
              a(paramViewHolder, localyzp, localLayoutParams);
            }
            localyzp.onViewAttachedToWindow(paramViewHolder);
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
        yzs localyzs = (yzs)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        int m = localyzs.getItemCount();
        if (j < m)
        {
          localyzs.onViewDetachedFromWindow(paramViewHolder);
          return;
        }
        j = Math.max(j - m, 0);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzj
 * JD-Core Version:    0.7.0.1
 */