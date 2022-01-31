import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.subscribe.component.base.PullLoadMoreAdapter.2;
import com.tencent.biz.subscribe.component.base.RefreshHeaderView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public abstract class yij<E>
  extends yhw<E>
  implements yio
{
  private static String jdField_g_of_type_JavaLangString = "PullLoadMoreAdapter";
  protected final Handler a;
  protected RecyclerView.LayoutManager a;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  public RecyclerView a;
  private View jdField_a_of_type_AndroidViewView;
  private RefreshHeaderView jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView;
  protected String a;
  private boolean jdField_a_of_type_Boolean;
  protected String b;
  private boolean b;
  protected String c;
  private boolean c;
  protected String d;
  private boolean d;
  protected String e;
  private boolean e;
  protected String f;
  private boolean f;
  private boolean jdField_g_of_type_Boolean = true;
  
  public yij()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangString = alud.a(2131702654);
    this.jdField_b_of_type_JavaLangString = alud.a(2131702728);
    this.jdField_c_of_type_JavaLangString = alud.a(2131702727);
    this.jdField_d_of_type_JavaLangString = alud.a(2131698356);
    this.jdField_e_of_type_JavaLangString = alud.a(2131709253);
    this.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected int a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_b_of_type_Boolean) {
      i = paramInt - 1;
    }
    return i;
  }
  
  protected abstract RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt);
  
  public RefreshHeaderView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView;
  }
  
  public void a() {}
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = paramLayoutManager;
  }
  
  protected abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    label62:
    int i;
    if (d())
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = paramBoolean2;
      this.jdField_d_of_type_Boolean = paramBoolean1;
      if (!paramBoolean2) {
        break label168;
      }
      str = this.jdField_d_of_type_JavaLangString;
      this.jdField_f_of_type_JavaLangString = str;
      if ((bdnn.a(this.jdField_f_of_type_JavaLangString)) && ((!paramBoolean2) || (this.jdField_a_of_type_AndroidViewView == null))) {
        break label175;
      }
      bool = true;
      this.jdField_f_of_type_Boolean = bool;
      if (!paramBoolean1)
      {
        if (NetworkUtils.isNetworkAvailable(BaseApplication.getContext())) {
          break label181;
        }
        i = 1;
        label83:
        if (i == 0) {
          break label186;
        }
      }
    }
    label168:
    label175:
    label181:
    label186:
    for (String str = this.jdField_c_of_type_JavaLangString;; str = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_f_of_type_JavaLangString = str;
      this.jdField_f_of_type_Boolean = this.jdField_g_of_type_Boolean;
      notifyItemChanged(getItemCount() - 1);
      QLog.i(jdField_g_of_type_JavaLangString, 1, String.format("onLoadMoreCompleted: hashCode:%d ,isSuccess:%b, isFinish:%b, isShow:%b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.jdField_f_of_type_Boolean) }));
      return;
      str = "";
      break;
      bool = false;
      break label62;
      i = 0;
      break label83;
    }
  }
  
  public int b()
  {
    int i = 0;
    if (this.jdField_b_of_type_Boolean) {
      i = 1;
    }
    int j = i;
    if (this.jdField_c_of_type_Boolean) {
      j = i + 1;
    }
    return j;
  }
  
  protected RecyclerView.ViewHolder b(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView == null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView = new RefreshHeaderView(paramViewGroup.getContext());
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView.setOnRefreshListener(this);
    }
    return new yim(this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView);
  }
  
  protected abstract void b();
  
  protected void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof yil))
    {
      paramViewHolder = (yil)paramViewHolder;
      if (!this.jdField_f_of_type_Boolean)
      {
        yil.a(paramViewHolder).setVisibility(8);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          yil.a(paramViewHolder).setVisibility(8);
        }
        QLog.i(jdField_g_of_type_JavaLangString, 1, "onBindProgressViewHolder hideLoadingFooter");
      }
    }
    else
    {
      return;
    }
    boolean bool;
    ProgressBar localProgressBar;
    if ((this.jdField_e_of_type_Boolean) && (getItemCount() > c()))
    {
      bool = true;
      yil.a(paramViewHolder).setIndeterminate(bool);
      localProgressBar = yil.a(paramViewHolder);
      if (!bool) {
        break label153;
      }
    }
    label153:
    for (paramInt = 0;; paramInt = 8)
    {
      localProgressBar.setVisibility(paramInt);
      if ((this.jdField_a_of_type_AndroidViewView == null) || (yil.a(paramViewHolder) == null) || (!this.jdField_a_of_type_Boolean)) {
        break label159;
      }
      yil.a(paramViewHolder).setVisibility(8);
      yil.a(paramViewHolder).setVisibility(0);
      QLog.i(jdField_g_of_type_JavaLangString, 1, "onBindProgressViewHolder show CustomNoMoreDataView");
      return;
      bool = false;
      break;
    }
    label159:
    yil.a(paramViewHolder).setVisibility(0);
    yil.a(paramViewHolder).setText(this.jdField_f_of_type_JavaLangString);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      yil.a(paramViewHolder).setVisibility(8);
    }
    QLog.i(jdField_g_of_type_JavaLangString, 1, "onBindProgressViewHolder show progress text:" + this.jdField_f_of_type_JavaLangString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected int c()
  {
    return 1;
  }
  
  protected RecyclerView.ViewHolder c(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new yil(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560557, paramViewGroup, false));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      yil.a(paramViewGroup).addView(this.jdField_a_of_type_AndroidViewView);
    }
    return paramViewGroup;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView != null)
    {
      this.jdField_e_of_type_Boolean = c();
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView.setRefreshing(paramBoolean);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView != null) {
      return this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView.b();
    }
    return false;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void f()
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    this.jdField_f_of_type_Boolean = true;
    notifyItemChanged(getItemCount() - 1);
  }
  
  public boolean f()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView != null))
    {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView.setState(2);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PullLoadMoreAdapter.2(this), 100L);
    }
  }
  
  public int getItemCount()
  {
    return this.mDataList.size() + b();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramInt == 0)) {
      return -10000;
    }
    if (a(paramInt) < this.mDataList.size()) {
      return 0;
    }
    return -99999;
  }
  
  protected void h()
  {
    int j;
    try
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      }
      if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager instanceof LinearLayoutManager))
      {
        if (((LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).findLastVisibleItemPosition() < this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.getItemCount() - 3) {
          return;
        }
        b();
        return;
      }
      if (!(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager instanceof StaggeredGridLayoutManager)) {
        return;
      }
      StaggeredGridLayoutManager localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
      j = localStaggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
      if (j == 1)
      {
        arrayOfInt = new int[1];
        localStaggeredGridLayoutManager.findLastVisibleItemPositions(arrayOfInt);
        if (arrayOfInt[0] < localStaggeredGridLayoutManager.getItemCount() - 3) {
          return;
        }
        b();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    int[] arrayOfInt = new int[j];
    localException.findLastVisibleItemPositions(arrayOfInt);
    int i = arrayOfInt[(j - 1)];
    if (arrayOfInt.length == 2) {
      if (arrayOfInt[1] < arrayOfInt[0]) {
        break label185;
      }
    }
    label185:
    for (i = arrayOfInt[1]; i >= localException.getItemCount() - b() - 3 * j; i = arrayOfInt[0])
    {
      b();
      return;
    }
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = paramRecyclerView.getLayoutManager();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new yik(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == null) || (paramInt >= getItemCount()) || ((this.jdField_b_of_type_Boolean) && (paramInt == 0))) {
      return;
    }
    if (-99999 == getItemViewType(paramInt))
    {
      b(paramViewHolder, paramInt);
      return;
    }
    a(paramViewHolder, a(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == -99999) {
      return c(paramViewGroup, paramInt);
    }
    if (paramInt == -10000)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = b(paramViewGroup, paramInt);
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    }
    return a(paramViewGroup, paramInt);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView.d();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yij
 * JD-Core Version:    0.7.0.1
 */