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
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import java.util.ArrayList;
import javax.annotation.Nullable;

public abstract class yhy<E>
  extends yhw<E>
  implements Application.ActivityLifecycleCallbacks, yig
{
  private static final String TAG = yhy.class.getSimpleName();
  protected static final int VIEW_TYPE_FOOTER = 100001;
  protected static final int VIEW_TYPE_HEADER = 100000;
  protected static final int VIEW_TYPE_ITEM = 100002;
  private final RecyclerView.AdapterDataObserver mDataSetObserver = new yhz(this);
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  protected boolean mHasInitialized;
  private Bundle mInitData;
  protected ydl mInteractor;
  protected boolean mIsDestroyed;
  private final yii mLoadInfo = new yii();
  private yia mOnLoadDataDelegate;
  private yib mParentAdapter;
  private int mPositionOffsetStart;
  private String mUniqueKey = String.valueOf(hashCode());
  private int mViewTypeOffsetStart;
  
  public yhy(Bundle paramBundle)
  {
    this.mInitData = paramBundle;
    setHasStableIds(true);
  }
  
  private void _loadData(yii paramyii)
  {
    if (this.mOnLoadDataDelegate != null)
    {
      this.mOnLoadDataDelegate.a(paramyii, this);
      return;
    }
    loadData(paramyii);
  }
  
  public void addFixViewOccupySpaceAtTop(View paramView, int paramInt)
  {
    if ((paramView == null) || (getComponentPageView() == null) || (getParentRecyclerView() == null)) {
      return;
    }
    if (paramView.getLayoutParams() != null) {
      ((FrameLayout.LayoutParams)paramView.getLayoutParams()).gravity = 48;
    }
    getComponentPageView().addView(paramView);
    getParentRecyclerView().setPadding(0, paramInt, 0, 0);
  }
  
  public void addFloatView(View paramView)
  {
    if (getComponentPageView() != null) {
      getComponentPageView().addView(paramView);
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
    if ((getComponentPageView() != null) && (getComponentPageView().a() != null)) {
      return getComponentPageView().a().getActivity();
    }
    return null;
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
  
  public ComponentPageView getComponentPageView()
  {
    if (getParentAdapter() != null) {
      return getParentAdapter().a();
    }
    return null;
  }
  
  protected Context getContext()
  {
    return getActivity();
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    if (getComponentPageView() != null) {
      return getComponentPageView().a();
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
  
  public ydl getInteractor()
  {
    return this.mInteractor;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.mDataList != null) && (!bhrz.a(paramInt, this.mDataList))) {
      return this.mDataList.get(paramInt);
    }
    return null;
  }
  
  public abstract int getItemCount();
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {}
  
  public yii getLoadInfo()
  {
    return this.mLoadInfo;
  }
  
  public int getLocalPosition(int paramInt)
  {
    return paramInt - this.mPositionOffsetStart;
  }
  
  public yia getOnLoadDataDelegate()
  {
    return this.mOnLoadDataDelegate;
  }
  
  public yib getParentAdapter()
  {
    return this.mParentAdapter;
  }
  
  public Fragment getParentFragment()
  {
    if (getComponentPageView() != null) {
      return getComponentPageView().a();
    }
    return null;
  }
  
  public NestScrollRecyclerView getParentRecyclerView()
  {
    if (getComponentPageView() != null) {
      return getComponentPageView().a();
    }
    return null;
  }
  
  public int getPositionOffsetStart()
  {
    return this.mPositionOffsetStart;
  }
  
  public yif getShareData(String paramString)
  {
    if (this.mParentAdapter != null) {
      return this.mParentAdapter.a(paramString);
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
  
  public <T extends ubk> T getViewModel(Class<T> paramClass)
  {
    if ((getParentAdapter() != null) && (getParentAdapter().a() != null)) {
      return getParentAdapter().a().a(paramClass);
    }
    return null;
  }
  
  public abstract int getViewTypeCount();
  
  protected void handleComponentAdapterChange(yhy paramyhy, int paramInt) {}
  
  public void handleShareDataChange(String paramString, yif paramyif) {}
  
  public boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public boolean isEnableRefresh()
  {
    return true;
  }
  
  public boolean isLastAdapter()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getParentAdapter() != null)
    {
      bool1 = bool2;
      if (getDataList().size() > 0)
      {
        bool1 = bool2;
        if (getParentAdapter().getDataList().get(getParentAdapter().getDataList().size() - 1) == this) {
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
  
  public abstract void loadData(yii paramyii);
  
  public void loadMoreData(yii paramyii)
  {
    if (this.mOnLoadDataDelegate != null)
    {
      this.mOnLoadDataDelegate.a(paramyii, this);
      return;
    }
    _loadData(paramyii);
  }
  
  public void notifyLoadingComplete(boolean paramBoolean)
  {
    if ((getComponentPageView() != null) && (getParentAdapter() != null))
    {
      getLoadInfo().a(4);
      getComponentPageView().setRefreshing(false);
      if (isLastAdapter()) {
        getParentAdapter().a(paramBoolean, getLoadInfo().a());
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
      onPrepareParams(getInitParams());
      this.mLoadInfo.a(1);
      _loadData(this.mLoadInfo);
      this.mHasInitialized = true;
    }
  }
  
  public abstract void onPrepareParams(Bundle paramBundle);
  
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
  
  public void setGlobalPositionOffset(int paramInt)
  {
    this.mPositionOffsetStart = paramInt;
  }
  
  public void setInteractor(ydl paramydl)
  {
    this.mInteractor = paramydl;
  }
  
  public void setOnLoadDataDelegate(yia paramyia)
  {
    this.mOnLoadDataDelegate = paramyia;
  }
  
  public void setParentAdapter(yib paramyib)
  {
    this.mParentAdapter = paramyib;
  }
  
  public void setShareData(String paramString, yif paramyif)
  {
    if (this.mParentAdapter != null) {
      this.mParentAdapter.a(paramString, paramyif);
    }
  }
  
  public void setViewTypeOffset(int paramInt)
  {
    this.mViewTypeOffsetStart = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yhy
 * JD-Core Version:    0.7.0.1
 */