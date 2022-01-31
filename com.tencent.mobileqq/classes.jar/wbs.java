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

public class wbs
  extends wcb<wbp>
{
  private static boolean jdField_c_of_type_Boolean;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private ComponentPageView jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  private final ConcurrentHashMap<String, wbv> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final CopyOnWriteArrayList<wbw> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private final ConcurrentHashMap<String, wbp> b;
  private String jdField_c_of_type_JavaLangString = ajjy.a(2131636475);
  private String d = ajjy.a(2131636549);
  private String e = ajjy.a(2131636548);
  private String f = ajjy.a(2131636472);
  
  public wbs(ComponentPageView paramComponentPageView)
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = paramComponentPageView;
    setHasStableIds(true);
  }
  
  public static int a(ArrayList<wbp> paramArrayList)
  {
    try
    {
      int m = paramArrayList.size();
      int k = 0;
      int i = 0;
      int j = i;
      if (k < m)
      {
        if (been.a(k, paramArrayList)) {
          return i;
        }
        wbp localwbp = (wbp)paramArrayList.get(k);
        j = i;
        if (localwbp != null)
        {
          localwbp.c(i);
          if (k != paramArrayList.size() - 1) {
            break label151;
          }
        }
        label151:
        for (boolean bool = true;; bool = false)
        {
          localwbp.e(bool);
          i += localwbp.getItemCount();
          j = i;
          if (jdField_c_of_type_Boolean)
          {
            Log.d("CMADebugTAG|" + localwbp.getClass().getSimpleName(), "size:" + localwbp.getItemCount());
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
  
  private void a(RecyclerView.ViewHolder paramViewHolder, wbp paramwbp, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramwbp.a(paramViewHolder.getLayoutPosition() - paramwbp.c()) == 1) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void b(String paramString, wbv paramwbv)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((wbw)localIterator.next()).a(paramString, paramwbv);
      }
    }
  }
  
  private void b(wbp paramwbp, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((wbp)localIterator.next()).a(paramwbp, paramInt);
    }
  }
  
  public GridLayoutManager.SpanSizeLookup a()
  {
    return new wbt(this);
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = new wbu(this, new View(paramViewGroup.getContext()));
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
        j += ((wbp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        i += 1;
      }
      i = paramInt - j;
    }
    if (jdField_c_of_type_Boolean) {
      Log.d("CMADebugTAG|" + ((wbp)this.jdField_a_of_type_JavaUtilArrayList.get(k)).getClass().getSimpleName(), "createItemViewHolder ViewType:" + i);
    }
    return ((wbp)this.jdField_a_of_type_JavaUtilArrayList.get(k)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public ComponentPageView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  }
  
  public wbp a(int paramInt)
  {
    if (been.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList)) {
      return null;
    }
    return (wbp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public wbp a(String paramString)
  {
    return (wbp)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public wbv a(String paramString)
  {
    return (wbv)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
        wbp localwbp = (wbp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localwbp.getItemCount();
        if (i < j) {
          localwbp.onBindViewHolder(paramViewHolder, i);
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
  
  public void a(String paramString, wbv paramwbv)
  {
    if (paramwbv == null)
    {
      QLog.w(getClass().getSimpleName(), 1, "setShareData null");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramwbv);
    b(paramString, paramwbv);
  }
  
  public void a(wbp paramwbp)
  {
    a(paramwbp, -1);
  }
  
  public void a(wbp paramwbp, int paramInt)
  {
    if ((paramwbp != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramwbp)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if (paramwbp.a() != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramwbp.a(), paramwbp);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(i, paramwbp);
      paramwbp.a(this);
      paramwbp.onAttachedToRecyclerView(a().a());
      b(paramwbp, 1);
      a(paramwbp);
      notifyDataSetChanged();
    }
  }
  
  public void a(wbw paramwbw)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramwbw);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramwbw.a(str, (wbv)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
    }
  }
  
  protected void a(boolean paramBoolean, wbp paramwbp)
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
    for (paramwbp = this.e;; paramwbp = this.d)
    {
      a(true, false, paramwbp);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((wbp)localIterator.next()).b()) {
        return true;
      }
    }
    return false;
  }
  
  public wbp b(int paramInt)
  {
    if (paramInt < a(this.jdField_a_of_type_JavaUtilArrayList))
    {
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        wbp localwbp = (wbp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localwbp.getItemCount();
        if (i < j) {
          return localwbp;
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
      wbp localwbp = (wbp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localwbp.a()) {
        localwbp.d();
      }
      i += 1;
    }
  }
  
  public void b(wbp paramwbp)
  {
    if ((paramwbp != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramwbp))) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ComponentMergeAdapter.1(this, paramwbp));
    }
  }
  
  public void b(wbw paramwbw)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramwbw);
  }
  
  public void c()
  {
    wbp localwbp = (wbp)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (!a().b()) {}
    do
    {
      do
      {
        return;
      } while (localwbp.a().b());
      if (localwbp.a().a())
      {
        localwbp.a().a(4);
        return;
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
    a(true, true, jdField_b_of_type_JavaLangString);
    localwbp.a().a(3);
    ((wbp)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).b(localwbp.a());
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
      wbp localwbp = (wbp)localIterator.next();
      if (!localwbp.e()) {
        localwbp.e();
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
        wbp localwbp;
        if (i < n)
        {
          localwbp = (wbp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          k = localwbp.getItemCount();
          if (paramInt >= k) {
            break label158;
          }
          paramInt = localwbp.getItemViewType(paramInt);
          if (jdField_c_of_type_Boolean) {
            Log.d("CMADebugTAG|" + localwbp.getClass().getSimpleName(), "getItemViewType ViewType:" + paramInt);
          }
          if (paramInt >= 0) {
            break label151;
          }
        }
        for (;;)
        {
          localwbp.d(j);
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt, i);
          k = paramInt;
          return k;
          label151:
          paramInt += j;
        }
        label158:
        paramInt = Math.max(paramInt - k, 0);
        if (localwbp.a() == 0) {
          throw new IllegalArgumentException("ComponentAdapter getViewTypeCount() has to be greater than 0");
        }
        j += localwbp.a();
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
      ((wbp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    boolean bool = localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    if ((bool) && ((paramViewHolder instanceof wcc))) {
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
        wbp localwbp = (wbp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        int m = localwbp.getItemCount();
        if (j < m)
        {
          if (bool) {
            a(paramViewHolder, localwbp, localLayoutParams);
          }
          localwbp.onViewAttachedToWindow(paramViewHolder);
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
        wbn localwbn = (wbn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        m = localwbn.getItemCount();
        if (j < m) {
          localwbn.onViewDetachedFromWindow(paramViewHolder);
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
 * Qualified Name:     wbs
 * JD-Core Version:    0.7.0.1
 */