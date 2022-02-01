package com.tencent.qqmail.utilities.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.WrapperListAdapter;
import androidx.annotation.Nullable;
import com.nineoldandroids.animation.TypeEvaluator;
import com.nineoldandroids.util.Property;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class InsertionListView
  extends ListView
{
  private static final int NEW_ROW_DURATION = 600;
  static Property<View, Float> TRANSLATION_Y = new InsertionListView.3("translationY");
  static final TypeEvaluator<Rect> sBoundsEvaluator = new InsertionListView.2();
  private AnimationObserver mAnimationObserver;
  private List<BitmapDrawable> mCellBitmapDrawables;
  private Context mContext;
  private long mCurrentFirstId;
  private boolean mEnableAnimation = true;
  private boolean mIsAnimating;
  private boolean mRelayoutBeforeAdd = false;
  private OnRowAdditionAnimationListener mRowAdditionAnimationListener;
  
  public InsertionListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public InsertionListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public InsertionListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private AnimationListAdapter<?> getAnimationListAdapter()
  {
    for (ListAdapter localListAdapter = getAdapter(); (localListAdapter instanceof WrapperListAdapter); localListAdapter = ((WrapperListAdapter)localListAdapter).getWrappedAdapter()) {}
    return (AnimationListAdapter)localListAdapter;
  }
  
  private BitmapDrawable getBitmapDrawableFromView(View paramView)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    return new BitmapDrawable(getResources(), localBitmap);
  }
  
  @Nullable
  private HeaderViewsAdapter getHeaderViewsAdapter()
  {
    for (ListAdapter localListAdapter = getAdapter(); ((localListAdapter instanceof WrapperListAdapter)) && (!(localListAdapter instanceof HeaderViewsAdapter)); localListAdapter = ((WrapperListAdapter)localListAdapter).getWrappedAdapter()) {}
    if ((localListAdapter instanceof HeaderViewsAdapter)) {
      return (HeaderViewsAdapter)localListAdapter;
    }
    return null;
  }
  
  public void addRows(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    AnimationListAdapter localAnimationListAdapter = getAnimationListAdapter();
    Object localObject1 = getHeaderViewsAdapter();
    int j = getHeaderViewsCount();
    int i;
    HashMap localHashMap;
    int k;
    if (localObject1 == null)
    {
      i = 0;
      j += i;
      localObject1 = new HashMap();
      localHashMap = new HashMap();
      k = getFirstVisiblePosition();
      if (k >= j) {
        break label223;
      }
      i = j;
    }
    for (;;)
    {
      if (i >= getChildCount()) {
        break label228;
      }
      localObject2 = getChildAt(i);
      int m = k + i - j;
      long l2 = 0L;
      long l1 = l2;
      if (localAnimationListAdapter != null)
      {
        l1 = l2;
        if (localAnimationListAdapter.getItem(m) != null) {
          l1 = localAnimationListAdapter.getItemId(localAnimationListAdapter.getItem(m));
        }
      }
      Rect localRect = new Rect(((View)localObject2).getLeft(), ((View)localObject2).getTop(), ((View)localObject2).getRight(), ((View)localObject2).getBottom());
      if (m == 0) {
        this.mCurrentFirstId = l1;
      }
      ((HashMap)localObject1).put(Long.valueOf(l1), localRect);
      localHashMap.put(Long.valueOf(l1), getBitmapDrawableFromView((View)localObject2));
      i += 1;
      continue;
      i = ((HeaderViewsAdapter)localObject1).getHeaderViewsCount();
      break;
      label223:
      i = 0;
    }
    label228:
    Object localObject2 = getViewTreeObserver();
    ((ViewTreeObserver)localObject2).addOnPreDrawListener(new InsertionListView.1(this, j, localAnimationListAdapter, (ViewTreeObserver)localObject2, paramInt, (HashMap)localObject1, localHashMap));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Object localObject;
    if (this.mCellBitmapDrawables.size() > 0)
    {
      localObject = this.mCellBitmapDrawables.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BitmapDrawable)((Iterator)localObject).next()).draw(paramCanvas);
      }
    }
    if ((this.mIsAnimating) && (getFirstVisiblePosition() < getHeaderViewsCount()))
    {
      int i = 0;
      while (i < getHeaderViewsCount())
      {
        localObject = getChildAt(i);
        if (localObject != null) {
          drawChild(paramCanvas, (View)localObject, ((View)localObject).getDrawingTime());
        }
        i += 1;
      }
    }
  }
  
  public Point getLocationOnScreen(View paramView)
  {
    Object localObject = new DisplayMetrics();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    return new Point(localObject[0], localObject[1]);
  }
  
  public void init(Context paramContext)
  {
    setDivider(null);
    this.mContext = paramContext;
    this.mCellBitmapDrawables = new ArrayList();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mEnableAnimation)
    {
      AnimationListAdapter localAnimationListAdapter = getAnimationListAdapter();
      if ((localAnimationListAdapter != null) && (this.mAnimationObserver != null))
      {
        this.mAnimationObserver = new AdapterAnimationObserver();
        localAnimationListAdapter.registerAnimationObserver(this.mAnimationObserver);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mEnableAnimation)
    {
      AnimationListAdapter localAnimationListAdapter = getAnimationListAdapter();
      if ((localAnimationListAdapter != null) && (this.mAnimationObserver != null))
      {
        localAnimationListAdapter.unregisterAnimationObserver(this.mAnimationObserver);
        this.mAnimationObserver = null;
      }
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mRelayoutBeforeAdd = false;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mRelayoutBeforeAdd = true;
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.mRelayoutBeforeAdd = true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((!(paramListAdapter instanceof AnimationListAdapter)) && ((!(paramListAdapter instanceof WrapperListAdapter)) || (!(((WrapperListAdapter)paramListAdapter).getWrappedAdapter() instanceof AnimationListAdapter))))
    {
      super.setAdapter(paramListAdapter);
      this.mEnableAnimation = false;
    }
    do
    {
      return;
      this.mEnableAnimation = true;
      AnimationListAdapter localAnimationListAdapter = getAnimationListAdapter();
      if ((localAnimationListAdapter != null) && (this.mAnimationObserver != null)) {
        localAnimationListAdapter.unregisterAnimationObserver(this.mAnimationObserver);
      }
      super.setAdapter(paramListAdapter);
    } while (paramListAdapter == null);
    this.mAnimationObserver = new AdapterAnimationObserver();
    getAnimationListAdapter().registerAnimationObserver(this.mAnimationObserver);
  }
  
  public void setRowAdditionAnimationListener(OnRowAdditionAnimationListener paramOnRowAdditionAnimationListener)
  {
    this.mRowAdditionAnimationListener = paramOnRowAdditionAnimationListener;
  }
  
  public boolean shouldAnimateInNewImage()
  {
    if (getChildCount() == getHeaderViewsCount()) {}
    boolean bool;
    View localView;
    do
    {
      return true;
      bool = shouldAnimateInNewRow();
      localView = getChildAt(getHeaderViewsCount() - 1);
    } while ((bool) && (localView.getBottom() >= 0));
    return false;
  }
  
  public boolean shouldAnimateInNewRow()
  {
    return getFirstVisiblePosition() < getHeaderViewsCount();
  }
  
  class AdapterAnimationObserver
    implements InsertionListView.AnimationObserver
  {
    AdapterAnimationObserver() {}
    
    public void notifyPrepareAnimation(int paramInt)
    {
      if (InsertionListView.this.mEnableAnimation)
      {
        InsertionListView.this.addRows(paramInt);
        return;
      }
      throw new IllegalArgumentException("Adapter need to extend AnimationListAdpater");
    }
  }
  
  public static abstract interface AnimationListAdapter<T>
    extends Adapter, InsertionListView.OnRowAdditionAnimationListener
  {
    public abstract int getItemId(T paramT);
    
    public abstract void notifyPrepareAnimation(int paramInt);
    
    public abstract void registerAnimationObserver(InsertionListView.AnimationObserver paramAnimationObserver);
    
    public abstract void unregisterAnimationObserver(InsertionListView.AnimationObserver paramAnimationObserver);
  }
  
  public static abstract interface AnimationObserver
  {
    public abstract void notifyPrepareAnimation(int paramInt);
  }
  
  public static abstract interface HeaderViewsAdapter
  {
    public abstract int getHeaderViewsCount();
  }
  
  public static abstract interface OnRowAdditionAnimationListener
  {
    public abstract void onRowAdditionAnimationEnd();
    
    public abstract void onRowAdditionAnimationStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.InsertionListView
 * JD-Core Version:    0.7.0.1
 */