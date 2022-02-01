package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import aqcx;
import atau.a;
import auwv;
import auwv.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msd;
import msd.a;
import mwf;
import mwg;
import mwh;

public class VideoFeedsRecyclerView
  extends RecyclerViewWithHeaderFooter
  implements auwv.c, msd.a
{
  private static int aVv;
  private static int aVw;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new mwf(this);
  private auwv jdField_a_of_type_Auwv;
  private msd jdField_a_of_type_Msd;
  private int aVx;
  private int aVy = -1;
  private int aVz;
  private boolean aoK;
  private boolean aoL;
  private boolean aoM;
  private boolean apN = true;
  private boolean apO = true;
  private boolean apP = true;
  private RecyclerView.ViewHolder b;
  private int flingVelocityIncrease;
  private float jM;
  private View mFooterView;
  private View mHeaderView;
  private boolean mIsScrollable = true;
  private boolean mIsScrolling;
  private List<a> mListeners;
  private int pagerGravity;
  private int snapOffset;
  private boolean snapOnFling = true;
  private float snapSpeedFactor;
  private long wT;
  
  public VideoFeedsRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sH, paramInt, 0);
    this.pagerGravity = paramContext.getInt(0, 0);
    this.snapOffset = paramContext.getDimensionPixelSize(1, 0);
    this.snapSpeedFactor = paramContext.getFloat(2, 25.0F);
    paramContext.recycle();
  }
  
  private void Y(int paramInt, boolean paramBoolean)
  {
    if (this.aoL) {}
    label116:
    do
    {
      do
      {
        return;
      } while ((this.mIsScrolling) || (this.b == null));
      this.aoL = true;
      if ((this.jdField_a_of_type_Msd != null) && (this.apN))
      {
        if (paramInt != 0) {
          break label116;
        }
        localObject = this.jdField_a_of_type_Msd.getContext();
        if ((localObject instanceof Activity)) {
          ((Activity)localObject).setRequestedOrientation(0);
        }
      }
      while (this.mListeners != null)
      {
        localObject = this.mListeners.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a)((Iterator)localObject).next()).a(this.b, true);
        }
        localObject = this.jdField_a_of_type_Msd.getContext();
        if ((localObject instanceof Activity)) {
          ((Activity)localObject).setRequestedOrientation(8);
        }
      }
    } while (!paramBoolean);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    startAnimation((Animation)localObject);
  }
  
  private void aTm()
  {
    View localView = new View(getContext());
    localView.setId(2131376714);
    localView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
    this.mHeaderView = localView;
    addHeaderView(localView);
    localView = new View(getContext());
    localView.setId(2131376713);
    localView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
    this.mFooterView = localView;
    addFooterView(localView);
  }
  
  private void aa(int paramInt, boolean paramBoolean)
  {
    if (!this.aoL) {}
    do
    {
      do
      {
        return;
      } while ((this.mIsScrolling) || (this.b == null));
      this.aoL = false;
      if ((this.jdField_a_of_type_Msd != null) && (this.apN))
      {
        localObject = this.jdField_a_of_type_Msd.getContext();
        if ((localObject instanceof Activity)) {
          ((Activity)localObject).setRequestedOrientation(1);
        }
      }
      if (this.mListeners != null)
      {
        localObject = this.mListeners.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a)((Iterator)localObject).next()).a(this.b, false);
        }
      }
    } while (!paramBoolean);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    startAnimation((Animation)localObject);
  }
  
  private void init()
  {
    addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    aTm();
    setOverScrollMode(2);
    setItemAnimator(null);
    setHasFixedSize(true);
    setItemViewCacheSize(0);
    setClipChildren(false);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    aVv = super.getMinFlingVelocity() * 3;
    aVw = super.getMinFlingVelocity() * 3;
  }
  
  private void sF(int paramInt)
  {
    if (this.mHeaderView != null)
    {
      View localView = this.mHeaderView;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localLayoutParams.width = -1;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void setupPagerSnaper()
  {
    this.jdField_a_of_type_Auwv = new auwv(this.pagerGravity, this.snapSpeedFactor);
    this.jdField_a_of_type_Auwv.setSnapOffset(this.snapOffset);
    this.jdField_a_of_type_Auwv.setReboundFooterCount(this.aVx + 1);
    this.jdField_a_of_type_Auwv.setPlaceHeaderCount(1);
    this.jdField_a_of_type_Auwv.b(this);
    this.jdField_a_of_type_Auwv.a(this);
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_Auwv.setQuickPageChanged(true);
    }
    addOnLayoutChangeListener(new mwg(this));
  }
  
  public boolean EK()
  {
    return this.jdField_a_of_type_Auwv.snapToNextPosition();
  }
  
  public boolean EL()
  {
    return this.jdField_a_of_type_Auwv.snapToPreviousPosition();
  }
  
  public void a(a parama)
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(parama);
  }
  
  public void aTn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecyclerView", 2, "changeFullScreenStatus: mIsShowingFull=" + this.aoL);
    }
    if (this.aoL)
    {
      oH(true);
      return;
    }
    ov(true);
  }
  
  public void aTo()
  {
    addOnLayoutChangeListener(new mwh(this));
  }
  
  public View ak()
  {
    if ((getLayoutManager() instanceof LinearLayoutManager)) {
      return this.jdField_a_of_type_Auwv.findCenterView((LinearLayoutManager)getLayoutManager());
    }
    return null;
  }
  
  public long cX()
  {
    return this.wT;
  }
  
  public boolean dW(int paramInt)
  {
    return this.jdField_a_of_type_Auwv.snapToTargetPosition(paramInt);
  }
  
  public void doOnDestory()
  {
    if (this.mListeners != null)
    {
      this.mListeners.clear();
      this.mListeners = null;
    }
    if (this.jdField_a_of_type_Msd != null) {
      this.jdField_a_of_type_Msd.destory();
    }
  }
  
  public int getMinFlingVelocity()
  {
    if (getLayoutManager().canScrollVertically()) {
      return aVv + this.flingVelocityIncrease;
    }
    return aVw + this.flingVelocityIncrease;
  }
  
  public boolean isScrolling()
  {
    return this.mIsScrolling;
  }
  
  public void oH(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecyclerView", 2, "user exitFullScreen: ");
    }
    this.aVy = 1;
    aa(1, paramBoolean);
  }
  
  public void onFooterRebound()
  {
    if (this.mListeners != null)
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).aSa();
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.wT = System.currentTimeMillis();
    if (this.jdField_a_of_type_Auwv.isSnapping()) {}
    do
    {
      do
      {
        return false;
      } while (this.aoL);
      if (paramMotionEvent.getAction() == 0)
      {
        this.jM = paramMotionEvent.getY();
        this.aoM = false;
      }
      if ((paramMotionEvent.getAction() == 2) && (!this.aoM) && (this.b != null))
      {
        int i = aqcx.dip2px(getContext(), 25.0F);
        int j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if ((Math.abs(this.jM - paramMotionEvent.getY()) > j) && ((this.jM < i) || (Math.abs(getHeight() - this.jM) < i)))
        {
          this.aoM = true;
          return false;
        }
      }
    } while (!this.mIsScrollable);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if ((this.mIsScrolling) || (!this.aoK) || (this.b == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecyclerView", 2, "onOrientationChanged: requestOrientation=" + paramInt + ", userOrientation=" + this.aVy);
      }
    } while ((this.aVy != -1) && (this.aVy != paramInt));
    this.aVy = -1;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      Y(paramInt, true);
      return;
    case 1: 
      aa(paramInt, true);
      return;
    case 8: 
      Y(paramInt, true);
      return;
    }
    aa(paramInt, true);
  }
  
  public void onPagerChanged(RecyclerView.ViewHolder paramViewHolder)
  {
    this.b = paramViewHolder;
    if (this.mListeners != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecyclerView", 2, "onPagerChanged: pagerSnapOnCenterViewChanged position=" + paramViewHolder.getLayoutPosition() + ", this=" + this);
      }
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).c(paramViewHolder);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Auwv.isSnapping()) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.aoL);
      bool1 = bool2;
    } while (this.aoM);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void ov(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecyclerView", 2, "user enterFullScreen: ");
    }
    this.aVy = 0;
    Y(0, paramBoolean);
  }
  
  public int qa()
  {
    return this.jdField_a_of_type_Auwv.getCurrentPosition() - 1;
  }
  
  public int qb()
  {
    return this.jdField_a_of_type_Auwv.getCurrentPosition();
  }
  
  public void scrollToPosition(int paramInt)
  {
    super.scrollToPosition(getHeaderViewsCount() + paramInt);
    this.jdField_a_of_type_Auwv.requestLayoutChanged();
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    RecyclerView.Adapter localAdapter = getAdapter();
    super.setAdapter(paramAdapter);
    if ((localAdapter != getAdapter()) && (getAdapter() != null) && (getLayoutManager() != null)) {
      setupPagerSnaper();
    }
  }
  
  public void setEnableFooterView(boolean paramBoolean)
  {
    this.apP = paramBoolean;
  }
  
  public void setEnableHeaderView(boolean paramBoolean)
  {
    this.apO = paramBoolean;
  }
  
  public void setExtraFooterCount(int paramInt)
  {
    this.aVx = paramInt;
  }
  
  public void setFlingVelocityIncrease(int paramInt)
  {
    this.flingVelocityIncrease = paramInt;
  }
  
  public void setHeaderHeight(int paramInt)
  {
    this.aVz = paramInt;
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    super.setLayoutManager(paramLayoutManager);
    if ((localLayoutManager != getLayoutManager()) && (getLayoutManager() != null) && (getAdapter() != null)) {
      setupPagerSnaper();
    }
  }
  
  public void setNeedDetectOrientation(Activity paramActivity, boolean paramBoolean)
  {
    this.aoK = paramBoolean;
    if ((this.aoK) && (this.jdField_a_of_type_Msd == null)) {
      this.jdField_a_of_type_Msd = new msd(paramActivity, this);
    }
  }
  
  public void setNeedDetectOrientation(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.apN = paramBoolean2;
    setNeedDetectOrientation(paramActivity, paramBoolean1);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.mIsScrollable = paramBoolean;
  }
  
  public void setSnapOffset(int paramInt)
  {
    this.snapOffset = paramInt;
    if (this.jdField_a_of_type_Auwv != null) {
      this.jdField_a_of_type_Auwv.setSnapOffset(paramInt);
    }
  }
  
  public void setSnapOnFling(boolean paramBoolean)
  {
    this.snapOnFling = paramBoolean;
    this.jdField_a_of_type_Auwv.setSnapOnFling(paramBoolean);
  }
  
  public void setSnapOnIdle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Auwv.setSnapOnIdle(paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean);
    
    public abstract void aSa();
    
    public abstract void c(RecyclerView.ViewHolder paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView
 * JD-Core Version:    0.7.0.1
 */