import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

public class yds
  extends yec<ydp>
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean jdField_c_of_type_Boolean;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private ComponentPageView jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  private final ConcurrentHashMap<String, ydw> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final CopyOnWriteArrayList<ydx> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private tvm jdField_a_of_type_Tvm;
  private final ConcurrentHashMap<String, ydp> b;
  private String jdField_c_of_type_JavaLangString = alpo.a(2131702642);
  private String d = alpo.a(2131702716);
  private String e = alpo.a(2131702715);
  private String f = alpo.a(2131702639);
  
  public yds(ComponentPageView paramComponentPageView)
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = paramComponentPageView;
    setHasStableIds(true);
  }
  
  public static int a(ArrayList<ydp> paramArrayList)
  {
    try
    {
      int m = paramArrayList.size();
      int k = 0;
      int i = 0;
      int j = i;
      if (k < m)
      {
        if (bhns.a(k, paramArrayList)) {
          return i;
        }
        ydp localydp = (ydp)paramArrayList.get(k);
        j = i;
        if (localydp != null)
        {
          localydp.c(i);
          if (k != paramArrayList.size() - 1) {
            break label151;
          }
        }
        label151:
        for (boolean bool = true;; bool = false)
        {
          localydp.e(bool);
          i += localydp.getItemCount();
          j = i;
          if (jdField_c_of_type_Boolean)
          {
            Log.d("CMADebugTAG|" + localydp.getClass().getSimpleName(), "size:" + localydp.getItemCount());
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
  
  private void a(RecyclerView.ViewHolder paramViewHolder, ydp paramydp, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramydp.a(paramViewHolder.getLayoutPosition() - paramydp.d()) == 1) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void b(String paramString, ydw paramydw)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((ydx)localIterator.next()).a(paramString, paramydw);
      }
    }
  }
  
  private void b(ydp paramydp, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ydp)localIterator.next()).a(paramydp, paramInt);
    }
  }
  
  public GridLayoutManager.SpanSizeLookup a()
  {
    return new ydt(this);
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ydu(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558711, paramViewGroup, false));
  }
  
  public ComponentPageView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  }
  
  public ydp a(int paramInt)
  {
    if (bhns.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList)) {
      return null;
    }
    return (ydp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public ydp a(String paramString)
  {
    return (ydp)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ydw a(String paramString)
  {
    return (ydw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((ydp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = 0;
    Object localObject;
    if ((paramViewHolder instanceof ydu))
    {
      paramViewHolder = (ydu)paramViewHolder;
      localObject = ydu.a(paramViewHolder);
      if (!this.jdField_b_of_type_Boolean) {
        break label98;
      }
      paramInt = 0;
      ((LinearLayout)localObject).setVisibility(paramInt);
      if ((!this.jdField_a_of_type_Boolean) || (getItemCount() <= a())) {
        break label104;
      }
      paramInt = 1;
      label55:
      if (paramInt == 0) {
        break label109;
      }
      ydu.a(paramViewHolder).start();
      label68:
      localObject = ydu.a(paramViewHolder);
      if (paramInt == 0) {
        break label121;
      }
    }
    label98:
    label104:
    label109:
    label121:
    for (paramInt = i;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      ydu.a(paramViewHolder).setText(this.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 8;
      break;
      paramInt = 0;
      break label55;
      ydu.a(paramViewHolder).stop();
      break label68;
    }
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(String paramString, ydw paramydw)
  {
    if (paramydw == null)
    {
      QLog.w(getClass().getSimpleName(), 1, "setShareData null");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramydw);
    b(paramString, paramydw);
  }
  
  public void a(tvm paramtvm)
  {
    this.jdField_a_of_type_Tvm = paramtvm;
  }
  
  public void a(ydp paramydp)
  {
    a(paramydp, -1);
  }
  
  public void a(ydp paramydp, int paramInt)
  {
    if ((paramydp != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramydp)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if (paramydp.a() != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramydp.a(), paramydp);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(i, paramydp);
      paramydp.a(this);
      paramydp.onAttachedToRecyclerView(a().a());
      b(paramydp, 1);
      a(paramydp);
      notifyDataSetChanged();
    }
  }
  
  public void a(ydx paramydx)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramydx);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramydx.a(str, (ydw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
    }
  }
  
  protected void a(boolean paramBoolean, ydp paramydp)
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
    for (paramydp = this.e;; paramydp = this.d)
    {
      a(true, false, paramydp);
      return;
      i = 0;
      break;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView == null) || (!a().b())) {
      return;
    }
    if (paramBoolean1)
    {
      a(paramBoolean2, false, this.f);
      return;
    }
    int i;
    if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
    }
    label68:
    for (String str = this.e;; str = this.d)
    {
      a(true, false, str);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((ydp)localIterator.next()).b()) {
        return true;
      }
    }
    return false;
  }
  
  protected RecyclerView.ViewHolder b(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = new ydv(this, new View(paramViewGroup.getContext()));
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
        j += ((ydp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        i += 1;
      }
      i = paramInt - j;
    }
    if (jdField_c_of_type_Boolean) {
      Log.d("CMADebugTAG|" + ((ydp)this.jdField_a_of_type_JavaUtilArrayList.get(k)).getClass().getSimpleName(), "createItemViewHolder ViewType:" + i);
    }
    return ((ydp)this.jdField_a_of_type_JavaUtilArrayList.get(k)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public ydp b(int paramInt)
  {
    if (paramInt < a(this.jdField_a_of_type_JavaUtilArrayList))
    {
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        ydp localydp = (ydp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localydp.getItemCount();
        if (i < j) {
          return localydp;
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
      ydp localydp = (ydp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localydp.d_()) {
        localydp.o();
      }
      i += 1;
    }
  }
  
  protected void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      if (paramInt < k)
      {
        ydp localydp = (ydp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = localydp.getItemCount();
        if (i < j) {
          localydp.onBindViewHolder(paramViewHolder, i);
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
  
  public void b(ydp paramydp)
  {
    if ((paramydp != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramydp))) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ComponentMergeAdapter.1(this, paramydp));
    }
  }
  
  public void b(ydx paramydx)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramydx);
  }
  
  public int c()
  {
    return a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void c()
  {
    ydp localydp = (ydp)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (!a().b()) {}
    do
    {
      do
      {
        return;
      } while (localydp.a().b());
      if (localydp.a().a())
      {
        localydp.a().a(4);
        return;
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
    a(true, true, jdField_b_of_type_JavaLangString);
    localydp.a().a(3);
    localydp.b(localydp.a());
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Tvm = null;
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ydp localydp = (ydp)localIterator.next();
      if (!localydp.e()) {
        localydp.p();
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
        ydp localydp;
        if (i < n)
        {
          localydp = (ydp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          k = localydp.getItemCount();
          if (paramInt >= k) {
            break label158;
          }
          paramInt = localydp.getItemViewType(paramInt);
          if (jdField_c_of_type_Boolean) {
            Log.d("CMADebugTAG|" + localydp.getClass().getSimpleName(), "getItemViewType ViewType:" + paramInt);
          }
          if (paramInt >= 0) {
            break label151;
          }
        }
        for (;;)
        {
          localydp.d(j);
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt, i);
          k = paramInt;
          return k;
          label151:
          paramInt += j;
        }
        label158:
        paramInt = Math.max(paramInt - k, 0);
        if (localydp.a() == 0) {
          throw new IllegalArgumentException("ComponentAdapter getViewTypeCount() has to be greater than 0");
        }
        j += localydp.a();
        i += 1;
      }
    }
    return 99999;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((ydp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityDestroyed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((ydp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityPaused(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((ydp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityResumed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((ydp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityStarted(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((ydp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityStopped(paramActivity);
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
      ((ydp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    boolean bool = localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    if ((bool) && ((paramViewHolder instanceof ydu))) {
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
        ydp localydp = (ydp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        int m = localydp.getItemCount();
        if (j < m)
        {
          if (bool) {
            a(paramViewHolder, localydp, localLayoutParams);
          }
          localydp.onViewAttachedToWindow(paramViewHolder);
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
        ydn localydn = (ydn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        m = localydn.getItemCount();
        if (j < m) {
          localydn.onViewDetachedFromWindow(paramViewHolder);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yds
 * JD-Core Version:    0.7.0.1
 */