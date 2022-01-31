import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.subscribe.component.base.ComponentMergeAdapter.1;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class wpc
  extends wpl<woz>
{
  private static boolean jdField_c_of_type_Boolean;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private ComponentPageView jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  private final ConcurrentHashMap<String, wpf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final CopyOnWriteArrayList<wpg> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private final ConcurrentHashMap<String, woz> b;
  private String jdField_c_of_type_JavaLangString = ajya.a(2131702270);
  private String d = ajya.a(2131702344);
  private String e = ajya.a(2131702343);
  private String f = ajya.a(2131702267);
  
  public wpc(ComponentPageView paramComponentPageView)
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = paramComponentPageView;
    setHasStableIds(true);
  }
  
  public static int a(ArrayList<woz> paramArrayList)
  {
    try
    {
      int m = paramArrayList.size();
      int k = 0;
      int i = 0;
      int j = i;
      if (k < m)
      {
        if (bfmy.a(k, paramArrayList)) {
          return i;
        }
        woz localwoz = (woz)paramArrayList.get(k);
        j = i;
        if (localwoz != null)
        {
          localwoz.c(i);
          if (k != paramArrayList.size() - 1) {
            break label151;
          }
        }
        label151:
        for (boolean bool = true;; bool = false)
        {
          localwoz.e(bool);
          i += localwoz.getItemCount();
          j = i;
          if (jdField_c_of_type_Boolean)
          {
            Log.d("CMADebugTAG|" + localwoz.getClass().getSimpleName(), "size:" + localwoz.getItemCount());
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
  
  private void a(RecyclerView.ViewHolder paramViewHolder, woz paramwoz, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramwoz.a(paramViewHolder.getLayoutPosition() - paramwoz.c()) == 1) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void b(String paramString, wpf paramwpf)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((wpg)localIterator.next()).a(paramString, paramwpf);
      }
    }
  }
  
  private void b(woz paramwoz, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((woz)localIterator.next()).a(paramwoz, paramInt);
    }
  }
  
  public GridLayoutManager.SpanSizeLookup a()
  {
    return new wpd(this);
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = new wpe(this, new View(paramViewGroup.getContext()));
      }
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    }
    if (paramInt == 99999) {
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
        j += ((woz)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        i += 1;
      }
      i = paramInt - j;
    }
    if (jdField_c_of_type_Boolean) {
      Log.d("CMADebugTAG|" + ((woz)this.jdField_a_of_type_JavaUtilArrayList.get(k)).getClass().getSimpleName(), "createItemViewHolder ViewType:" + i);
    }
    return ((woz)this.jdField_a_of_type_JavaUtilArrayList.get(k)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public ComponentPageView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  }
  
  public woz a(int paramInt)
  {
    if (bfmy.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList)) {
      return null;
    }
    return (woz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public woz a(String paramString)
  {
    return (woz)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public wpf a(String paramString)
  {
    return (wpf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
        woz localwoz = (woz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localwoz.getItemCount();
        if (i < j) {
          localwoz.onBindViewHolder(paramViewHolder, i);
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
  
  public void a(String paramString, wpf paramwpf)
  {
    if (paramwpf == null)
    {
      QLog.w(getClass().getSimpleName(), 1, "setShareData null");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramwpf);
    b(paramString, paramwpf);
  }
  
  public void a(woz paramwoz)
  {
    a(paramwoz, -1);
  }
  
  public void a(woz paramwoz, int paramInt)
  {
    if ((paramwoz != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramwoz)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if (paramwoz.a() != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramwoz.a(), paramwoz);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(i, paramwoz);
      paramwoz.a(this);
      paramwoz.onAttachedToRecyclerView(a().a());
      b(paramwoz, 1);
      a(paramwoz);
      notifyDataSetChanged();
    }
  }
  
  public void a(wpg paramwpg)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramwpg);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramwpg.a(str, (wpf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
    }
  }
  
  protected void a(boolean paramBoolean, woz paramwoz)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView == null) || (!a().b())) {
      return;
    }
    if (paramBoolean)
    {
      a(false, false, this.f);
      return;
    }
    int i;
    if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = 1;
      if (i == 0) {
        break label66;
      }
    }
    label66:
    for (paramwoz = this.e;; paramwoz = this.d)
    {
      a(true, false, paramwoz);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((woz)localIterator.next()).b()) {
        return true;
      }
    }
    return false;
  }
  
  public woz b(int paramInt)
  {
    if (paramInt < a(this.jdField_a_of_type_JavaUtilArrayList))
    {
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        woz localwoz = (woz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localwoz.getItemCount();
        if (i < j) {
          return localwoz;
        }
        i = Math.max(i - j, 0);
        paramInt += 1;
      }
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      a().setRefreshing(true);
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      woz localwoz = (woz)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localwoz.a()) {
        localwoz.o();
      }
      i += 1;
    }
  }
  
  public void b(woz paramwoz)
  {
    if ((paramwoz != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramwoz))) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ComponentMergeAdapter.1(this, paramwoz));
    }
  }
  
  public void b(wpg paramwpg)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramwpg);
  }
  
  public void c()
  {
    woz localwoz = (woz)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (!a().b()) {}
    do
    {
      do
      {
        return;
      } while (localwoz.a().b());
      if (localwoz.a().a())
      {
        localwoz.a().a(4);
        return;
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
    a(true, true, jdField_b_of_type_JavaLangString);
    localwoz.a().a(3);
    ((woz)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).b(localwoz.a());
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      woz localwoz = (woz)localIterator.next();
      if (!localwoz.e()) {
        localwoz.p();
      }
    }
  }
  
  public int getItemCount()
  {
    int j = a(this.jdField_a_of_type_JavaUtilArrayList);
    if (a().b()) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < a(this.jdField_a_of_type_JavaUtilArrayList))
    {
      int m = -1;
      int n = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      int j = 0;
      for (;;)
      {
        int k = m;
        woz localwoz;
        if (i < n)
        {
          localwoz = (woz)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          k = localwoz.getItemCount();
          if (paramInt >= k) {
            break label158;
          }
          paramInt = localwoz.getItemViewType(paramInt);
          if (jdField_c_of_type_Boolean) {
            Log.d("CMADebugTAG|" + localwoz.getClass().getSimpleName(), "getItemViewType ViewType:" + paramInt);
          }
          if (paramInt >= 0) {
            break label151;
          }
        }
        for (;;)
        {
          localwoz.d(j);
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt, i);
          k = paramInt;
          return k;
          label151:
          paramInt += j;
        }
        label158:
        paramInt = Math.max(paramInt - k, 0);
        if (localwoz.a() == 0) {
          throw new IllegalArgumentException("ComponentAdapter getViewTypeCount() has to be greater than 0");
        }
        j += localwoz.a();
        i += 1;
      }
    }
    return 99999;
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
      ((woz)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    boolean bool = localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    if ((bool) && ((paramViewHolder instanceof wpm))) {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
    }
    for (;;)
    {
      return;
      int j = paramViewHolder.getAdapterPosition();
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < k)
      {
        woz localwoz = (woz)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        int m = localwoz.getItemCount();
        if (j < m)
        {
          if (bool) {
            a(paramViewHolder, localwoz, localLayoutParams);
          }
          localwoz.onViewAttachedToWindow(paramViewHolder);
          return;
        }
        j = Math.max(j - m, 0);
        i += 1;
      }
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    int j = paramViewHolder.getAdapterPosition();
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      int m;
      if (i < k)
      {
        wox localwox = (wox)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        m = localwox.getItemCount();
        if (j < m) {
          localwox.onViewDetachedFromWindow(paramViewHolder);
        }
      }
      else
      {
        return;
      }
      j = Math.max(j - m, 0);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wpc
 * JD-Core Version:    0.7.0.1
 */