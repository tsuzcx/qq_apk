package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.WrapperListAdapter;
import androidx.annotation.Nullable;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Field;

public class ItemScrollListView
  extends PtrListView
{
  private static final int FLAG_FLING = 32;
  private static final int FLAG_HORIZONTAL = 4;
  private static final int FLAG_HORIZONTAL_DOWN = 4;
  private static final int FLAG_HORIZONTAL_MOVE = 5;
  private static final int FLAG_MOVE_CANCEL = 16;
  private static final int FLAG_NONE = 0;
  private static final int FLAG_NOT_HANDLE = 8;
  private static final int FLAG_VERTICAL = 1;
  public static final int RIGHT_VIEW_STYLE_GRAY = 2;
  public static final int RIGHT_VIEW_STYLE_RED = 1;
  public static final int RIGHT_VIEW_STYLE_YELLOW = 3;
  private static final String TAG = "ItemScrollListView";
  private final View.OnClickListener clickListener = new ItemScrollListView.1(this);
  private boolean couldScrollDecidByUser = true;
  private int currentItemPosition;
  private HorizontalScrollItemView currentItemView;
  private int flag = 0;
  private boolean folding = false;
  private ListAdapter mAdapter;
  private OnFoldCallback mCallback = null;
  private OnHandUpAndExpandCallback mDataCollectCallback = null;
  private GestureDetector mGestureDetector;
  private DataSetObserver mObserver = new ItemScrollListView.2(this);
  private OnRightViewClickListener mOnRightViewClickListener;
  private AbsListView.OnScrollListener mOnScrollListener;
  
  public ItemScrollListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ItemScrollListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ItemScrollListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void dataSetChanged()
  {
    reset();
  }
  
  private void expandAndFoldCurrentItemBy(int paramInt)
  {
    if (this.currentItemView != null) {
      this.currentItemView.expandAndFoldBy(this.currentItemPosition, paramInt);
    }
  }
  
  private void expandCurrentItem()
  {
    if (this.mDataCollectCallback != null) {
      this.mDataCollectCallback.OnHandUpAndExpand(this.currentItemPosition);
    }
    if (this.currentItemView != null) {
      this.currentItemView.expand(this.currentItemPosition);
    }
  }
  
  private void foldItemView()
  {
    if (this.currentItemView != null)
    {
      this.currentItemView.fold(this.currentItemPosition);
      this.currentItemView = null;
      this.flag = 8;
    }
  }
  
  public static void formatRightViewStyle(TextView paramTextView, int paramInt)
  {
    paramTextView.setGravity(17);
    paramTextView.setTextSize(2, 16.0F);
    int i = QMUIKit.dpToPx(16);
    paramTextView.setPadding(i, 0, i, 0);
    Resources localResources = paramTextView.getContext().getResources();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      paramTextView.setTextColor(localResources.getColor(2131167213));
      paramTextView.setBackgroundColor(localResources.getColor(2131167210));
      return;
    case 1: 
      paramTextView.setTextColor(localResources.getColor(2131167213));
      paramTextView.setBackgroundColor(localResources.getColor(2131167211));
      return;
    }
    paramTextView.setTextColor(localResources.getColor(2131167213));
    paramTextView.setBackgroundColor(localResources.getColor(2131167212));
  }
  
  @Nullable
  private String getAdapterInfo()
  {
    try
    {
      Object localObject1 = Class.forName("android.widget.AdapterView").getDeclaredField("mItemCount");
      ((Field)localObject1).setAccessible(true);
      int i = ((Integer)((Field)localObject1).get(this)).intValue();
      localObject1 = Class.forName("android.widget.AbsListView").getDeclaredField("mAdapter");
      ((Field)localObject1).setAccessible(true);
      localObject1 = (ListAdapter)((Field)localObject1).get(this);
      Object localObject2 = HeaderViewListAdapter.class.getDeclaredField("mAdapter");
      ((Field)localObject2).setAccessible(true);
      localObject2 = (ListAdapter)((Field)localObject2).get(localObject1);
      int j = ((HeaderViewListAdapter)localObject1).getHeadersCount();
      int k = ((HeaderViewListAdapter)localObject1).getFootersCount();
      localObject1 = "itemCount: " + i + ", realAdapterCount: " + ((ListAdapter)localObject1).getCount() + ", headerCount: " + j + ", footerCount: " + k + ", curAdapterCount: " + this.mAdapter.getCount() + ", realAdapter: " + localObject1 + ", innerAdatper: " + localObject2 + ", curAdapter: " + this.mAdapter;
      return localObject1;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "ItemScrollListView", "getAdapterInfo failed", localException);
    }
    return null;
  }
  
  private void init()
  {
    Context localContext = getContext();
    this.mGestureDetector = new GestureDetector(localContext, new ItemScrollListView.3(this, localContext));
    super.setOnScrollListener(new ItemScrollListView.4(this));
    setOnItemScrollListener(new ItemScrollListView.5(this));
  }
  
  private void initCurrentItem(int paramInt, HorizontalScrollItemView paramHorizontalScrollItemView)
  {
    this.currentItemView = paramHorizontalScrollItemView;
    this.currentItemPosition = paramInt;
    this.currentItemView.setRightViewClickListener(this.clickListener);
    this.flag = 5;
  }
  
  private boolean isEnableRightScroll(int paramInt, ItemScrollAdapter paramItemScrollAdapter)
  {
    return (paramItemScrollAdapter.isEnabledScroll(paramInt) & 0x2) == 2;
  }
  
  private int itemPositionToChildIndex(int paramInt)
  {
    return getHeaderViewsCount() + paramInt - getFirstVisiblePosition();
  }
  
  private View pointToView(MotionEvent paramMotionEvent)
  {
    int i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if (i != -1) {
      return getChildAt(i - getFirstVisiblePosition());
    }
    return null;
  }
  
  private Adapter tryGetWrappedAdapter()
  {
    ListAdapter localListAdapter2 = getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof WrapperListAdapter)) {
      localListAdapter1 = ((WrapperListAdapter)getAdapter()).getWrappedAdapter();
    }
    return localListAdapter1;
  }
  
  private void tryInitCurrentItem(int paramInt, View paramView)
  {
    if ((isEnableRightScroll(paramInt, (ItemScrollAdapter)tryGetWrappedAdapter())) && ((paramView instanceof HorizontalScrollItemView))) {
      initCurrentItem(paramInt, (HorizontalScrollItemView)paramView);
    }
  }
  
  public static HorizontalScrollItemView wrap(View paramView)
  {
    Object localObject = paramView.getContext();
    TextView localTextView1 = new TextView((Context)localObject);
    localTextView1.setId(2131377335);
    TextView localTextView2 = new TextView((Context)localObject);
    localTextView2.setId(2131377336);
    localObject = new TextView((Context)localObject);
    ((TextView)localObject).setId(2131377337);
    localTextView1.setContentDescription(" ");
    localTextView2.setContentDescription(" ");
    ((TextView)localObject).setContentDescription(" ");
    return new HorizontalScrollItemView(paramView, new TextView[] { localTextView1, localTextView2, localObject });
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!this.couldScrollDecidByUser) || (this.flag == 32)) {
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
    }
    do
    {
      return bool1;
      if (paramMotionEvent.getAction() == 0)
      {
        if (this.flag == 8) {
          this.flag = 0;
        }
        if (this.flag == 5)
        {
          if ((this.currentItemView != null) && ((paramMotionEvent.getY() - this.currentItemView.getTop() < 0.0F) || (paramMotionEvent.getY() - this.currentItemView.getTop() > this.currentItemView.getMeasuredHeight())))
          {
            foldItemView();
            return true;
          }
          this.flag = 4;
        }
        if (((this.flag == 0) && (this.currentItemView == null)) || ((this.flag == 1) && (this.currentItemView == null)) || ((this.flag == 4) && (this.currentItemView != null)) || (getAdvertiseMode())) {}
      }
      if ((this.flag & 0x4) == 4)
      {
        if (this.flag == 5) {
          if ((!this.mGestureDetector.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
          {
            if ((this.currentItemView != null) && (this.currentItemView.autoExpandOrFold(this.currentItemPosition)))
            {
              this.currentItemView = null;
              this.flag = 8;
            }
            if (this.mDataCollectCallback != null) {
              this.mDataCollectCallback.OnHandUpAndExpand(this.currentItemPosition);
            }
          }
        }
        for (;;)
        {
          bool1 = bool2;
          if (paramMotionEvent.getAction() != 3) {
            break;
          }
          bool1 = bool2;
          if (isFold()) {
            break;
          }
          return true;
          if ((this.flag == 4) && (this.currentItemView != null)) {
            if (this.currentItemView.isInScrollContentView((int)paramMotionEvent.getX() - this.currentItemView.getLeft(), (int)paramMotionEvent.getY() - this.currentItemView.getTop()))
            {
              if ((!this.mGestureDetector.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1)) {
                foldItemView();
              }
            }
            else
            {
              MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
              localMotionEvent.setLocation(localMotionEvent.getX() - this.currentItemView.getLeft(), localMotionEvent.getY() - this.currentItemView.getTop());
              this.currentItemView.dispatchTouchEvent(localMotionEvent);
              localMotionEvent.recycle();
            }
          }
        }
      }
      if (this.flag == 1) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      if (this.flag == 0)
      {
        if (this.mGestureDetector.onTouchEvent(paramMotionEvent))
        {
          this.flag = 5;
          paramMotionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      bool1 = bool2;
    } while (this.flag != 8);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void expandAndFoldItemAtPosition(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1) {
      return;
    }
    tryInitCurrentItem(paramInt1, getChildAt(itemPositionToChildIndex(paramInt1)));
    expandAndFoldCurrentItemBy(paramInt2);
  }
  
  public void foldItemView(OnFoldCallback paramOnFoldCallback)
  {
    foldItemView();
    if (paramOnFoldCallback != null) {
      this.mCallback = paramOnFoldCallback;
    }
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  public boolean isFold()
  {
    return (this.folding) || (this.currentItemView == null) || (this.currentItemView.getScrollContentView().getScrollX() == 0);
  }
  
  public boolean isItemVisibleAtPositon(int paramInt)
  {
    return itemPositionToChildIndex(paramInt) > 0;
  }
  
  protected void layoutChildren()
  {
    try
    {
      super.layoutChildren();
      return;
    }
    catch (Exception localException)
    {
      String str;
      do
      {
        str = "layoutChildren failed, " + getAdapterInfo();
        QMLog.log(6, "ItemScrollListView", str);
      } while (!AppConfig.isBeta());
      throw new IllegalStateException(str, localException);
    }
  }
  
  public void reset()
  {
    if (this.currentItemView != null)
    {
      this.currentItemView.reset(this.currentItemPosition);
      this.currentItemView = null;
    }
    if ((this.flag != 1) && (this.flag != 32)) {
      this.flag = 8;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mAdapter != null) {
      this.mAdapter.unregisterDataSetObserver(this.mObserver);
    }
    if (paramListAdapter != this.mAdapter)
    {
      this.mAdapter = paramListAdapter;
      super.setAdapter(paramListAdapter);
    }
    if (this.mAdapter != null) {
      this.mAdapter.registerDataSetObserver(this.mObserver);
    }
  }
  
  public void setCouldScrollDecidByUser(boolean paramBoolean)
  {
    this.couldScrollDecidByUser = paramBoolean;
  }
  
  public void setDataCollectCallback(OnHandUpAndExpandCallback paramOnHandUpAndExpandCallback)
  {
    this.mDataCollectCallback = paramOnHandUpAndExpandCallback;
  }
  
  public void setOnItemScrollListener(HorizontalScrollItemView.OnItemScrollListener paramOnItemScrollListener)
  {
    if (this.currentItemView != null) {
      this.currentItemView.setOnItemScrollListener(new ItemScrollListView.6(this, paramOnItemScrollListener));
    }
  }
  
  public void setOnRightViewClickListener(OnRightViewClickListener paramOnRightViewClickListener)
  {
    this.mOnRightViewClickListener = paramOnRightViewClickListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
  }
  
  public static abstract interface ItemScrollAdapter
  {
    public static final int DISABLED_SCROLL = 0;
    public static final int ENABLED_LEFT_SCROLL = 1;
    public static final int ENABLED_RIGHT_SCROLL = 2;
    
    public abstract int isEnabledScroll(int paramInt);
  }
  
  public static abstract interface OnFoldCallback
  {
    public abstract void onFoldEnd(int paramInt);
  }
  
  public static abstract interface OnHandUpAndExpandCallback
  {
    public abstract void OnHandUpAndExpand(int paramInt);
  }
  
  public static abstract interface OnRightViewClickListener
  {
    public abstract void onRightViewClick(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.ItemScrollListView
 * JD-Core Version:    0.7.0.1
 */