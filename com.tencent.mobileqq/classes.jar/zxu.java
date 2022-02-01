import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import java.util.ArrayList;
import javax.annotation.Nullable;

public abstract class zxu<E>
  extends zxx<E>
  implements Application.ActivityLifecycleCallbacks, zxt
{
  private static final String TAG = zxu.class.getSimpleName();
  protected static final int VIEW_TYPE_FOOTER = 100001;
  protected static final int VIEW_TYPE_HEADER = 100000;
  protected static final int VIEW_TYPE_ITEM = 100002;
  protected static final int VIEW_TYPE_LIVE = 100003;
  private zxo mBlockMerger;
  private final RecyclerView.AdapterDataObserver mDataSetObserver = new zxv(this);
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  protected boolean mHasInitialized;
  private Bundle mInitData;
  protected aabu mInteractor;
  protected boolean mIsDestroyed;
  private final zxz mLoadInfo = new zxz();
  private zxw mOnLoadDataDelegate;
  private int mPositionOffsetStart;
  private String mUniqueKey = String.valueOf(hashCode());
  private int mViewTypeOffsetStart;
  
  public zxu(Bundle paramBundle)
  {
    this.mInitData = paramBundle;
    setHasStableIds(true);
  }
  
  private void _loadData(zxz paramzxz)
  {
    if (this.mOnLoadDataDelegate != null)
    {
      this.mOnLoadDataDelegate.a(paramzxz, this);
      return;
    }
    loadData(paramzxz);
  }
  
  public void addFixViewOccupySpaceAtTop(View paramView, int paramInt)
  {
    if ((paramView == null) || (getBlockContainer() == null) || (getParentRecyclerView() == null)) {
      return;
    }
    if (paramView.getLayoutParams() != null) {
      ((FrameLayout.LayoutParams)paramView.getLayoutParams()).gravity = 48;
    }
    getBlockContainer().addView(paramView);
    getParentRecyclerView().setPadding(0, paramInt, 0, 0);
  }
  
  public void addFloatView(View paramView)
  {
    if (getBlockContainer() != null) {
      getBlockContainer().addView(paramView);
    }
  }
  
  public void addOnScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    if (getParentRecyclerView() != null) {
      getParentRecyclerView().addOnScrollListener(paramOnScrollListener);
    }
  }
  
  protected Activity getActivity()
  {
    if ((getBlockContainer() != null) && (getBlockContainer().a() != null)) {
      return getBlockContainer().a().getActivity();
    }
    return null;
  }
  
  public BlockContainer getBlockContainer()
  {
    if (getBlockMerger() != null) {
      return getBlockMerger().a();
    }
    return null;
  }
  
  public zxo getBlockMerger()
  {
    return this.mBlockMerger;
  }
  
  protected FrameLayout getCommonHeaderFooterWrapper(@Nullable View paramView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
    return localFrameLayout;
  }
  
  public Context getContext()
  {
    return getActivity();
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    if (getBlockContainer() != null) {
      return getBlockContainer().a();
    }
    return null;
  }
  
  public int getGlobalPosition(int paramInt)
  {
    return this.mPositionOffsetStart + paramInt;
  }
  
  public int getGlobalViewType(int paramInt)
  {
    return this.mViewTypeOffsetStart + paramInt;
  }
  
  public Bundle getInitParams()
  {
    return this.mInitData;
  }
  
  public aabu getInteractor()
  {
    return this.mInteractor;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.mDataList != null) && (!bkfj.a(paramInt, this.mDataList))) {
      return this.mDataList.get(paramInt);
    }
    return null;
  }
  
  public abstract int getItemCount();
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {}
  
  public zxz getLoadInfo()
  {
    return this.mLoadInfo;
  }
  
  public int getLocalPosition(int paramInt)
  {
    return paramInt - this.mPositionOffsetStart;
  }
  
  public Handler getMainHandler()
  {
    return this.mHandler;
  }
  
  public zxw getOnLoadDataDelegate()
  {
    return this.mOnLoadDataDelegate;
  }
  
  public Fragment getParentFragment()
  {
    if (getBlockContainer() != null) {
      return getBlockContainer().a();
    }
    return null;
  }
  
  public NestScrollRecyclerView getParentRecyclerView()
  {
    if (getBlockContainer() != null) {
      return getBlockContainer().a();
    }
    return null;
  }
  
  public int getPositionOffsetStart()
  {
    return this.mPositionOffsetStart;
  }
  
  public zxs getShareData(String paramString)
  {
    if (this.mBlockMerger != null) {
      return this.mBlockMerger.a(paramString);
    }
    return null;
  }
  
  public int getSpanCount(int paramInt)
  {
    return 1;
  }
  
  public String getUniqueKey()
  {
    return this.mUniqueKey;
  }
  
  public <T extends zxg> T getViewModel(Class<T> paramClass)
  {
    if ((getBlockMerger() != null) && (getBlockMerger().a() != null)) {
      return getBlockMerger().a().a(paramClass);
    }
    return null;
  }
  
  public abstract int getViewTypeCount();
  
  protected void handleBlockChange(zxu paramzxu, int paramInt) {}
  
  public void handleShareDataChange(String paramString, zxs paramzxs) {}
  
  public boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public boolean isEnableRefresh()
  {
    return true;
  }
  
  public boolean isLastPeerBlock()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getBlockMerger() != null)
    {
      bool1 = bool2;
      if (getDataList().size() > 0)
      {
        bool1 = bool2;
        if (getBlockMerger().getDataList().get(getBlockMerger().getDataList().size() - 1) == this) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected boolean isLazyLoad()
  {
    return false;
  }
  
  public boolean isOnScreen()
  {
    return true;
  }
  
  public abstract void loadData(zxz paramzxz);
  
  public void loadMoreData(zxz paramzxz)
  {
    if (this.mOnLoadDataDelegate != null)
    {
      this.mOnLoadDataDelegate.a(paramzxz, this);
      return;
    }
    _loadData(paramzxz);
  }
  
  public void notifyLoadingComplete(boolean paramBoolean)
  {
    if ((getBlockContainer() != null) && (getBlockMerger() != null))
    {
      getLoadInfo().a(4);
      getBlockContainer().setRefreshing(false);
      if (isLastPeerBlock()) {
        getBlockMerger().a(paramBoolean, getLoadInfo().a());
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    if (!hasObservers()) {
      registerAdapterDataObserver(this.mDataSetObserver);
    }
    this.mIsDestroyed = false;
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.mIsDestroyed = true;
    if (hasObservers()) {
      unregisterAdapterDataObserver(this.mDataSetObserver);
    }
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDrawItemDecoration(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, RecyclerView.State paramState) {}
  
  protected void onInit()
  {
    if (!this.mHasInitialized)
    {
      onInitBlock(getInitParams());
      this.mLoadInfo.a(1);
      _loadData(this.mLoadInfo);
      this.mHasInitialized = true;
    }
  }
  
  public abstract void onInitBlock(Bundle paramBundle);
  
  public void onRefreshData()
  {
    this.mLoadInfo.a(2);
    this.mLoadInfo.a(null);
    if (this.mOnLoadDataDelegate != null)
    {
      this.mOnLoadDataDelegate.a(this.mLoadInfo, this);
      return;
    }
    _loadData(this.mLoadInfo);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (isLazyLoad()) {
      onInit();
    }
  }
  
  public void removeOnScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    if (getParentRecyclerView() != null) {
      getParentRecyclerView().removeOnScrollListener(paramOnScrollListener);
    }
  }
  
  public void setBlockMerger(zxo paramzxo)
  {
    this.mBlockMerger = paramzxo;
  }
  
  public void setGlobalPositionOffset(int paramInt)
  {
    this.mPositionOffsetStart = paramInt;
  }
  
  public void setInteractor(aabu paramaabu)
  {
    this.mInteractor = paramaabu;
  }
  
  public void setOnLoadDataDelegate(zxw paramzxw)
  {
    this.mOnLoadDataDelegate = paramzxw;
  }
  
  public void setShareData(String paramString, zxs paramzxs)
  {
    if (this.mBlockMerger != null) {
      this.mBlockMerger.a(paramString, paramzxs);
    }
  }
  
  public void setViewTypeOffset(int paramInt)
  {
    this.mViewTypeOffsetStart = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxu
 * JD-Core Version:    0.7.0.1
 */