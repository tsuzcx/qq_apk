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

public class wpf
  extends wpo<wpc>
{
  private static boolean jdField_c_of_type_Boolean;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private ComponentPageView jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  private final ConcurrentHashMap<String, wpi> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final CopyOnWriteArrayList<wpj> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private final ConcurrentHashMap<String, wpc> b;
  private String jdField_c_of_type_JavaLangString = ajyc.a(2131702259);
  private String d = ajyc.a(2131702333);
  private String e = ajyc.a(2131702332);
  private String f = ajyc.a(2131702256);
  
  public wpf(ComponentPageView paramComponentPageView)
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = paramComponentPageView;
    setHasStableIds(true);
  }
  
  public static int a(ArrayList<wpc> paramArrayList)
  {
    try
    {
      int m = paramArrayList.size();
      int k = 0;
      int i = 0;
      int j = i;
      if (k < m)
      {
        if (bfmh.a(k, paramArrayList)) {
          return i;
        }
        wpc localwpc = (wpc)paramArrayList.get(k);
        j = i;
        if (localwpc != null)
        {
          localwpc.c(i);
          if (k != paramArrayList.size() - 1) {
            break label151;
          }
        }
        label151:
        for (boolean bool = true;; bool = false)
        {
          localwpc.e(bool);
          i += localwpc.getItemCount();
          j = i;
          if (jdField_c_of_type_Boolean)
          {
            Log.d("CMADebugTAG|" + localwpc.getClass().getSimpleName(), "size:" + localwpc.getItemCount());
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
  
  private void a(RecyclerView.ViewHolder paramViewHolder, wpc paramwpc, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramwpc.a(paramViewHolder.getLayoutPosition() - paramwpc.c()) == 1) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void b(String paramString, wpi paramwpi)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((wpj)localIterator.next()).a(paramString, paramwpi);
      }
    }
  }
  
  private void b(wpc paramwpc, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((wpc)localIterator.next()).a(paramwpc, paramInt);
    }
  }
  
  public GridLayoutManager.SpanSizeLookup a()
  {
    return new wpg(this);
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = new wph(this, new View(paramViewGroup.getContext()));
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
        j += ((wpc)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        i += 1;
      }
      i = paramInt - j;
    }
    if (jdField_c_of_type_Boolean) {
      Log.d("CMADebugTAG|" + ((wpc)this.jdField_a_of_type_JavaUtilArrayList.get(k)).getClass().getSimpleName(), "createItemViewHolder ViewType:" + i);
    }
    return ((wpc)this.jdField_a_of_type_JavaUtilArrayList.get(k)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public ComponentPageView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  }
  
  public wpc a(int paramInt)
  {
    if (bfmh.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList)) {
      return null;
    }
    return (wpc)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public wpc a(String paramString)
  {
    return (wpc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public wpi a(String paramString)
  {
    return (wpi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
        wpc localwpc = (wpc)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localwpc.getItemCount();
        if (i < j) {
          localwpc.onBindViewHolder(paramViewHolder, i);
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
  
  public void a(String paramString, wpi paramwpi)
  {
    if (paramwpi == null)
    {
      QLog.w(getClass().getSimpleName(), 1, "setShareData null");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramwpi);
    b(paramString, paramwpi);
  }
  
  public void a(wpc paramwpc)
  {
    a(paramwpc, -1);
  }
  
  public void a(wpc paramwpc, int paramInt)
  {
    if ((paramwpc != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramwpc)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if (paramwpc.a() != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramwpc.a(), paramwpc);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(i, paramwpc);
      paramwpc.a(this);
      paramwpc.onAttachedToRecyclerView(a().a());
      b(paramwpc, 1);
      a(paramwpc);
      notifyDataSetChanged();
    }
  }
  
  public void a(wpj paramwpj)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramwpj);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramwpj.a(str, (wpi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
    }
  }
  
  protected void a(boolean paramBoolean, wpc paramwpc)
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
    for (paramwpc = this.e;; paramwpc = this.d)
    {
      a(true, false, paramwpc);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((wpc)localIterator.next()).b()) {
        return true;
      }
    }
    return false;
  }
  
  public wpc b(int paramInt)
  {
    if (paramInt < a(this.jdField_a_of_type_JavaUtilArrayList))
    {
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        wpc localwpc = (wpc)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localwpc.getItemCount();
        if (i < j) {
          return localwpc;
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
      wpc localwpc = (wpc)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localwpc.a()) {
        localwpc.o();
      }
      i += 1;
    }
  }
  
  public void b(wpc paramwpc)
  {
    if ((paramwpc != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramwpc))) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ComponentMergeAdapter.1(this, paramwpc));
    }
  }
  
  public void b(wpj paramwpj)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramwpj);
  }
  
  public void c()
  {
    wpc localwpc = (wpc)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (!a().b()) {}
    do
    {
      do
      {
        return;
      } while (localwpc.a().b());
      if (localwpc.a().a())
      {
        localwpc.a().a(4);
        return;
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
    a(true, true, jdField_b_of_type_JavaLangString);
    localwpc.a().a(3);
    ((wpc)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).b(localwpc.a());
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
      wpc localwpc = (wpc)localIterator.next();
      if (!localwpc.e()) {
        localwpc.p();
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
        wpc localwpc;
        if (i < n)
        {
          localwpc = (wpc)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          k = localwpc.getItemCount();
          if (paramInt >= k) {
            break label158;
          }
          paramInt = localwpc.getItemViewType(paramInt);
          if (jdField_c_of_type_Boolean) {
            Log.d("CMADebugTAG|" + localwpc.getClass().getSimpleName(), "getItemViewType ViewType:" + paramInt);
          }
          if (paramInt >= 0) {
            break label151;
          }
        }
        for (;;)
        {
          localwpc.d(j);
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt, i);
          k = paramInt;
          return k;
          label151:
          paramInt += j;
        }
        label158:
        paramInt = Math.max(paramInt - k, 0);
        if (localwpc.a() == 0) {
          throw new IllegalArgumentException("ComponentAdapter getViewTypeCount() has to be greater than 0");
        }
        j += localwpc.a();
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
      ((wpc)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    boolean bool = localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    if ((bool) && ((paramViewHolder instanceof wpp))) {
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
        wpc localwpc = (wpc)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        int m = localwpc.getItemCount();
        if (j < m)
        {
          if (bool) {
            a(paramViewHolder, localwpc, localLayoutParams);
          }
          localwpc.onViewAttachedToWindow(paramViewHolder);
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
        wpa localwpa = (wpa)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        m = localwpa.getItemCount();
        if (j < m) {
          localwpa.onViewDetachedFromWindow(paramViewHolder);
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
 * Qualified Name:     wpf
 * JD-Core Version:    0.7.0.1
 */