import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
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
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.2;
import com.tencent.biz.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.richframework.part.block.base.RefreshHeaderView.a;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public abstract class rxu<E>
  extends rxs<E>
  implements RefreshHeaderView.a
{
  private static String TAG = "PullLoadMoreAdapter";
  protected String aDk = acfp.m(2131704247);
  protected String aDl = acfp.m(2131704249);
  protected String aDm = acfp.m(2131704248);
  protected String aDn = acfp.m(2131700146);
  protected String aDo = acfp.m(2131710274);
  protected String aDp = this.aDn;
  private boolean aKt;
  private boolean aKu = true;
  private boolean aKv = true;
  private RefreshHeaderView b;
  private RecyclerView.ViewHolder f;
  private boolean fV;
  private boolean mIsLoading;
  private boolean mIsShow;
  private boolean mIsSuccess;
  protected RecyclerView.LayoutManager mLayoutManager;
  public RecyclerView mRecyclerView;
  protected final Handler mUIHandler = new Handler(Looper.getMainLooper());
  private View pA;
  
  public boolean Me()
  {
    return this.aKu;
  }
  
  protected abstract RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt);
  
  public void ay(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    label62:
    int i;
    if (Me())
    {
      this.mIsLoading = false;
      this.fV = paramBoolean2;
      this.mIsSuccess = paramBoolean1;
      if (!paramBoolean2) {
        break label168;
      }
      str = this.aDn;
      this.aDp = str;
      if ((aqmr.isEmpty(this.aDp)) && ((!paramBoolean2) || (this.pA == null))) {
        break label175;
      }
      bool = true;
      this.mIsShow = bool;
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
    for (String str = this.aDm;; str = this.aDl)
    {
      this.aDp = str;
      this.mIsShow = this.aKv;
      notifyItemChanged(getItemCount() - 1);
      QLog.i(TAG, 1, String.format("onLoadMoreCompleted: hashCode:%d ,isSuccess:%b, isFinish:%b, isShow:%b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.mIsShow) }));
      return;
      str = "";
      break;
      bool = false;
      break label62;
      i = 0;
      break label83;
    }
  }
  
  protected RecyclerView.ViewHolder b(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.b == null)
    {
      this.b = new RefreshHeaderView(paramViewGroup.getContext());
      this.b.setOnRefreshListener(this);
    }
    return new rxu.b(this.b);
  }
  
  public RefreshHeaderView b()
  {
    return this.b;
  }
  
  public void b(RecyclerView.LayoutManager paramLayoutManager)
  {
    this.mLayoutManager = paramLayoutManager;
  }
  
  protected void bje()
  {
    int j;
    try
    {
      if (this.mLayoutManager == null) {
        this.mLayoutManager = this.mRecyclerView.getLayoutManager();
      }
      if ((this.mLayoutManager instanceof LinearLayoutManager))
      {
        if (((LinearLayoutManager)this.mLayoutManager).findLastVisibleItemPosition() < this.mLayoutManager.getItemCount() - 3) {
          return;
        }
        bxl();
        return;
      }
      if (!(this.mLayoutManager instanceof StaggeredGridLayoutManager)) {
        return;
      }
      StaggeredGridLayoutManager localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)this.mLayoutManager;
      j = localStaggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
      if (j == 1)
      {
        arrayOfInt = new int[1];
        localStaggeredGridLayoutManager.findLastVisibleItemPositions(arrayOfInt);
        if (arrayOfInt[0] < localStaggeredGridLayoutManager.getItemCount() - 3) {
          return;
        }
        bxl();
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
    for (i = arrayOfInt[1]; i >= localException.getItemCount() - ue() - 3 * j; i = arrayOfInt[0])
    {
      bxl();
      return;
    }
  }
  
  protected abstract void bxl();
  
  protected void bxo()
  {
    this.mIsLoading = true;
    this.aDp = this.aDo;
    this.mIsShow = true;
    notifyItemChanged(getItemCount() - 1);
  }
  
  public void bxp()
  {
    if ((this.mRecyclerView != null) && (this.b != null))
    {
      this.b.setState(2);
      this.mUIHandler.postDelayed(new PullLoadMoreAdapter.2(this), 100L);
    }
  }
  
  protected RecyclerView.ViewHolder c(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new rxu.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560916, paramViewGroup, false));
    if (this.pA != null) {
      rxu.a.a(paramViewGroup).addView(this.pA);
    }
    return paramViewGroup;
  }
  
  protected abstract void c(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  protected void d(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof rxu.a))
    {
      paramViewHolder = (rxu.a)paramViewHolder;
      if (!this.mIsShow)
      {
        rxu.a.a(paramViewHolder).setVisibility(8);
        if (this.pA != null) {
          rxu.a.a(paramViewHolder).setVisibility(8);
        }
        QLog.i(TAG, 1, "onBindProgressViewHolder hideLoadingFooter");
      }
    }
    else
    {
      return;
    }
    boolean bool;
    ProgressBar localProgressBar;
    if ((this.mIsLoading) && (getItemCount() > uf()))
    {
      bool = true;
      rxu.a.a(paramViewHolder).setIndeterminate(bool);
      localProgressBar = rxu.a.a(paramViewHolder);
      if (!bool) {
        break label155;
      }
    }
    label155:
    for (paramInt = 0;; paramInt = 8)
    {
      localProgressBar.setVisibility(paramInt);
      if ((this.pA == null) || (rxu.a.a(paramViewHolder) == null) || (!this.fV)) {
        break label161;
      }
      rxu.a.a(paramViewHolder).setVisibility(8);
      rxu.a.a(paramViewHolder).setVisibility(0);
      QLog.i(TAG, 1, "onBindProgressViewHolder show CustomNoMoreDataView");
      return;
      bool = false;
      break;
    }
    label161:
    rxu.a.a(paramViewHolder).setVisibility(0);
    rxu.a.a(paramViewHolder).setText(this.aDp);
    if (this.pA != null) {
      rxu.a.a(paramViewHolder).setVisibility(8);
    }
    QLog.i(TAG, 1, "onBindProgressViewHolder show progress text:" + this.aDp);
  }
  
  public void dY(View paramView)
  {
    this.pA = paramView;
  }
  
  public int getItemCount()
  {
    return this.mDataList.size() + ue();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.aKt) && (paramInt == 0)) {
      return -10000;
    }
    if (getRealPosition(paramInt) < this.mDataList.size()) {
      return 0;
    }
    return -99999;
  }
  
  protected int getRealPosition(int paramInt)
  {
    int i = paramInt;
    if (this.aKt) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public boolean isEnableRefresh()
  {
    return this.aKt;
  }
  
  public boolean isFinish()
  {
    return this.fV;
  }
  
  public boolean isLoading()
  {
    return this.mIsLoading;
  }
  
  public boolean isRefreshing()
  {
    if (this.b != null) {
      return this.b.mm();
    }
    return false;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.mRecyclerView = paramRecyclerView;
    this.mLayoutManager = paramRecyclerView.getLayoutManager();
    this.mRecyclerView.addOnScrollListener(new rxv(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == null) || (paramInt >= getItemCount()) || ((this.aKt) && (paramInt == 0))) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (-99999 == getItemViewType(paramInt)) {
        d(paramViewHolder, paramInt);
      } else {
        c(paramViewHolder, getRealPosition(paramInt));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == -99999) {
      return c(paramViewGroup, paramInt);
    }
    if (paramInt == -10000)
    {
      this.f = b(paramViewGroup, paramInt);
      return this.f;
    }
    return a(paramViewGroup, paramInt);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.b != null) {
      this.b.onDestroy();
    }
    this.mUIHandler.removeCallbacksAndMessages(null);
  }
  
  public void onRefresh() {}
  
  public void sR(String paramString)
  {
    this.aDn = paramString;
  }
  
  public void setEnableLoadMore(boolean paramBoolean)
  {
    this.aKu = paramBoolean;
  }
  
  public void setEnableRefresh(boolean paramBoolean)
  {
    this.aKt = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.b != null)
    {
      this.mIsLoading = isRefreshing();
      this.b.setRefreshing(paramBoolean);
    }
  }
  
  public int ue()
  {
    int i = 0;
    if (this.aKt) {
      i = 1;
    }
    int j = i;
    if (this.aKu) {
      j = i + 1;
    }
    return j;
  }
  
  protected int uf()
  {
    return 1;
  }
  
  public void up(boolean paramBoolean)
  {
    this.aKv = paramBoolean;
  }
  
  public static class a
    extends RecyclerView.ViewHolder
  {
    private ProgressBar H;
    private final FrameLayout aI;
    private LinearLayout mContainer;
    private TextView zD;
    
    public a(View paramView)
    {
      super();
      this.H = ((ProgressBar)paramView.findViewById(2131372946));
      this.mContainer = ((LinearLayout)paramView.findViewById(2131370107));
      this.zD = ((TextView)paramView.findViewById(2131380973));
      this.aI = ((FrameLayout)paramView.findViewById(2131367169));
    }
  }
  
  public static class b
    extends RecyclerView.ViewHolder
  {
    public b(RefreshHeaderView paramRefreshHeaderView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxu
 * JD-Core Version:    0.7.0.1
 */