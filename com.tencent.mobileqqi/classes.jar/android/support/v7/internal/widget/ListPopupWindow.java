package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class ListPopupWindow
{
  private static final boolean DEBUG = false;
  private static final int EXPAND_LIST_TIMEOUT = 250;
  public static final int FILL_PARENT = -1;
  public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
  public static final int INPUT_METHOD_NEEDED = 1;
  public static final int INPUT_METHOD_NOT_NEEDED = 2;
  public static final int POSITION_PROMPT_ABOVE = 0;
  public static final int POSITION_PROMPT_BELOW = 1;
  private static final String TAG = "ListPopupWindow";
  public static final int WRAP_CONTENT = -2;
  private ListAdapter mAdapter;
  private Context mContext;
  private boolean mDropDownAlwaysVisible = false;
  private View mDropDownAnchorView;
  private int mDropDownHeight = -2;
  private int mDropDownHorizontalOffset;
  private ListPopupWindow.DropDownListView mDropDownList;
  private Drawable mDropDownListHighlight;
  private int mDropDownVerticalOffset;
  private boolean mDropDownVerticalOffsetSet;
  private int mDropDownWidth = -2;
  private boolean mForceIgnoreOutsideTouch = false;
  private Handler mHandler = new Handler();
  private final ListPopupWindow.ListSelectorHider mHideSelector = new ListPopupWindow.ListSelectorHider(this, null);
  private AdapterView.OnItemClickListener mItemClickListener;
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  private int mLayoutDirection;
  int mListItemExpandMaximum = 2147483647;
  private boolean mModal;
  private DataSetObserver mObserver;
  private PopupWindow mPopup;
  private int mPromptPosition = 0;
  private View mPromptView;
  private final ListPopupWindow.ResizePopupRunnable mResizePopupRunnable = new ListPopupWindow.ResizePopupRunnable(this, null);
  private final ListPopupWindow.PopupScrollListener mScrollListener = new ListPopupWindow.PopupScrollListener(this, null);
  private Runnable mShowDropDownRunnable;
  private Rect mTempRect = new Rect();
  private final ListPopupWindow.PopupTouchInterceptor mTouchInterceptor = new ListPopupWindow.PopupTouchInterceptor(this, null);
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, 2130772002);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772002);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.mContext = paramContext;
    this.mPopup = new PopupWindow(paramContext, paramAttributeSet, paramInt);
    this.mPopup.setInputMethodMode(1);
    paramContext = this.mContext.getResources().getConfiguration().locale;
  }
  
  private int buildDropDown()
  {
    boolean bool2 = true;
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label252:
    int i;
    int j;
    if (this.mDropDownList == null)
    {
      localObject2 = this.mContext;
      this.mShowDropDownRunnable = new ListPopupWindow.1(this);
      if (!this.mModal)
      {
        bool1 = true;
        this.mDropDownList = new ListPopupWindow.DropDownListView((Context)localObject2, bool1);
        if (this.mDropDownListHighlight != null) {
          this.mDropDownList.setSelector(this.mDropDownListHighlight);
        }
        this.mDropDownList.setAdapter(this.mAdapter);
        this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
        this.mDropDownList.setFocusable(true);
        this.mDropDownList.setFocusableInTouchMode(true);
        this.mDropDownList.setOnItemSelectedListener(new ListPopupWindow.2(this));
        this.mDropDownList.setOnScrollListener(this.mScrollListener);
        if (this.mItemSelectedListener != null) {
          this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
        }
        localObject1 = this.mDropDownList;
        localView = this.mPromptView;
        if (localView == null) {
          break label697;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.mPromptPosition)
        {
        default: 
          Log.e("ListPopupWindow", "Invalid hint position " + this.mPromptPosition);
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, -2147483648), 0);
          localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
          i = localView.getMeasuredHeight();
          j = ((LinearLayout.LayoutParams)localObject1).topMargin;
          i = ((LinearLayout.LayoutParams)localObject1).bottomMargin + (i + j);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      this.mPopup.setContentView((View)localObject1);
      for (;;)
      {
        label312:
        localObject1 = this.mPopup.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          if (this.mDropDownVerticalOffsetSet) {
            break label689;
          }
          this.mDropDownVerticalOffset = (-this.mTempRect.top);
        }
        label542:
        label689:
        for (;;)
        {
          label371:
          if (this.mPopup.getInputMethodMode() == 2) {}
          int m;
          for (bool1 = bool2;; bool1 = false)
          {
            m = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, bool1);
            if ((!this.mDropDownAlwaysVisible) && (this.mDropDownHeight != -1)) {
              break label542;
            }
            return m + j;
            bool1 = false;
            break;
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            ((LinearLayout)localObject2).addView(localView);
            break label252;
            ((LinearLayout)localObject2).addView(localView);
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            break label252;
            localObject1 = (ViewGroup)this.mPopup.getContentView();
            localObject1 = this.mPromptView;
            if (localObject1 == null) {
              break label692;
            }
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i = ((View)localObject1).getMeasuredHeight();
            j = ((LinearLayout.LayoutParams)localObject2).topMargin;
            i = ((LinearLayout.LayoutParams)localObject2).bottomMargin + (i + j);
            break label312;
            this.mTempRect.setEmpty();
            j = 0;
            break label371;
          }
          int k;
          switch (this.mDropDownWidth)
          {
          default: 
            k = View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
          }
          for (;;)
          {
            m = this.mDropDownList.measureHeightOfChildrenCompat(k, 0, -1, m - i, -1);
            k = i;
            if (m > 0) {
              k = i + j;
            }
            return m + k;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
            continue;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
          }
        }
        label692:
        i = 0;
      }
      label697:
      i = 0;
    }
  }
  
  private void removePromptView()
  {
    if (this.mPromptView != null)
    {
      ViewParent localViewParent = this.mPromptView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.mPromptView);
      }
    }
  }
  
  public void clearListSelection()
  {
    ListPopupWindow.DropDownListView localDropDownListView = this.mDropDownList;
    if (localDropDownListView != null)
    {
      ListPopupWindow.DropDownListView.access$502(localDropDownListView, true);
      localDropDownListView.requestLayout();
    }
  }
  
  public void dismiss()
  {
    this.mPopup.dismiss();
    removePromptView();
    this.mPopup.setContentView(null);
    this.mDropDownList = null;
    this.mHandler.removeCallbacks(this.mResizePopupRunnable);
  }
  
  public View getAnchorView()
  {
    return this.mDropDownAnchorView;
  }
  
  public int getAnimationStyle()
  {
    return this.mPopup.getAnimationStyle();
  }
  
  public Drawable getBackground()
  {
    return this.mPopup.getBackground();
  }
  
  public int getHeight()
  {
    return this.mDropDownHeight;
  }
  
  public int getHorizontalOffset()
  {
    return this.mDropDownHorizontalOffset;
  }
  
  public int getInputMethodMode()
  {
    return this.mPopup.getInputMethodMode();
  }
  
  public ListView getListView()
  {
    return this.mDropDownList;
  }
  
  public int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = localRect.bottom;
    if (paramBoolean) {
      i = paramView.getContext().getResources().getDisplayMetrics().heightPixels;
    }
    i = Math.max(i - (arrayOfInt[1] + paramView.getHeight()) - paramInt, arrayOfInt[1] - localRect.top + paramInt);
    paramInt = i;
    if (this.mPopup.getBackground() != null)
    {
      this.mPopup.getBackground().getPadding(this.mTempRect);
      paramInt = i - (this.mTempRect.top + this.mTempRect.bottom);
    }
    return paramInt;
  }
  
  public int getPromptPosition()
  {
    return this.mPromptPosition;
  }
  
  public Object getSelectedItem()
  {
    if (!isShowing()) {
      return null;
    }
    return this.mDropDownList.getSelectedItem();
  }
  
  public long getSelectedItemId()
  {
    if (!isShowing()) {
      return -9223372036854775808L;
    }
    return this.mDropDownList.getSelectedItemId();
  }
  
  public int getSelectedItemPosition()
  {
    if (!isShowing()) {
      return -1;
    }
    return this.mDropDownList.getSelectedItemPosition();
  }
  
  public View getSelectedView()
  {
    if (!isShowing()) {
      return null;
    }
    return this.mDropDownList.getSelectedView();
  }
  
  public int getSoftInputMode()
  {
    return this.mPopup.getSoftInputMode();
  }
  
  public int getVerticalOffset()
  {
    if (!this.mDropDownVerticalOffsetSet) {
      return 0;
    }
    return this.mDropDownVerticalOffset;
  }
  
  public int getWidth()
  {
    return this.mDropDownWidth;
  }
  
  public boolean isDropDownAlwaysVisible()
  {
    return this.mDropDownAlwaysVisible;
  }
  
  public boolean isInputMethodNotNeeded()
  {
    return this.mPopup.getInputMethodMode() == 2;
  }
  
  public boolean isModal()
  {
    return this.mModal;
  }
  
  public boolean isShowing()
  {
    return this.mPopup.isShowing();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int m;
    int k;
    int i;
    int j;
    if ((isShowing()) && (paramInt != 62) && ((this.mDropDownList.getSelectedItemPosition() >= 0) || ((paramInt != 66) && (paramInt != 23))))
    {
      m = this.mDropDownList.getSelectedItemPosition();
      ListAdapter localListAdapter;
      if (!this.mPopup.isAboveAnchor())
      {
        k = 1;
        localListAdapter = this.mAdapter;
        i = 2147483647;
        j = -2147483648;
        if (localListAdapter != null)
        {
          boolean bool = localListAdapter.areAllItemsEnabled();
          if (!bool) {
            break label166;
          }
          i = 0;
          label91:
          if (!bool) {
            break label179;
          }
        }
      }
      label166:
      label179:
      for (j = localListAdapter.getCount() - 1;; j = ListPopupWindow.DropDownListView.access$600(this.mDropDownList, localListAdapter.getCount() - 1, false))
      {
        if (((k == 0) || (paramInt != 19) || (m > i)) && ((k != 0) || (paramInt != 20) || (m < j))) {
          break label201;
        }
        clearListSelection();
        this.mPopup.setInputMethodMode(1);
        show();
        return true;
        k = 0;
        break;
        i = ListPopupWindow.DropDownListView.access$600(this.mDropDownList, 0, true);
        break label91;
      }
      label201:
      ListPopupWindow.DropDownListView.access$502(this.mDropDownList, false);
      if (!this.mDropDownList.onKeyDown(paramInt, paramKeyEvent)) {
        break label286;
      }
      this.mPopup.setInputMethodMode(2);
      this.mDropDownList.requestFocusFromTouch();
      show();
      switch (paramInt)
      {
      }
    }
    label286:
    do
    {
      do
      {
        return false;
        if ((k == 0) || (paramInt != 20)) {
          break;
        }
      } while (m != j);
      return true;
    } while ((k != 0) || (paramInt != 19) || (m != i));
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((isShowing()) && (this.mDropDownList.getSelectedItemPosition() >= 0))
    {
      boolean bool = this.mDropDownList.onKeyUp(paramInt, paramKeyEvent);
      if (bool) {}
      switch (paramInt)
      {
      default: 
        return bool;
      }
      dismiss();
      return bool;
    }
    return false;
  }
  
  public boolean performItemClick(int paramInt)
  {
    if (isShowing())
    {
      if (this.mItemClickListener != null)
      {
        ListPopupWindow.DropDownListView localDropDownListView = this.mDropDownList;
        View localView = localDropDownListView.getChildAt(paramInt - localDropDownListView.getFirstVisiblePosition());
        ListAdapter localListAdapter = localDropDownListView.getAdapter();
        this.mItemClickListener.onItemClick(localDropDownListView, localView, paramInt, localListAdapter.getItemId(paramInt));
      }
      return true;
    }
    return false;
  }
  
  public void postShow()
  {
    this.mHandler.post(this.mShowDropDownRunnable);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null) {
      this.mObserver = new ListPopupWindow.PopupDataSetObserver(this, null);
    }
    for (;;)
    {
      this.mAdapter = paramListAdapter;
      if (this.mAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.mDropDownList != null) {
        this.mDropDownList.setAdapter(this.mAdapter);
      }
      return;
      if (this.mAdapter != null) {
        this.mAdapter.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public void setAnchorView(View paramView)
  {
    this.mDropDownAnchorView = paramView;
  }
  
  public void setAnimationStyle(int paramInt)
  {
    this.mPopup.setAnimationStyle(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mPopup.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.mPopup.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.mDropDownWidth = (this.mTempRect.left + this.mTempRect.right + paramInt);
      return;
    }
    setWidth(paramInt);
  }
  
  public void setDropDownAlwaysVisible(boolean paramBoolean)
  {
    this.mDropDownAlwaysVisible = paramBoolean;
  }
  
  public void setForceIgnoreOutsideTouch(boolean paramBoolean)
  {
    this.mForceIgnoreOutsideTouch = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    this.mDropDownHeight = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    this.mDropDownHorizontalOffset = paramInt;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    this.mPopup.setInputMethodMode(paramInt);
  }
  
  void setListItemExpandMax(int paramInt)
  {
    this.mListItemExpandMaximum = paramInt;
  }
  
  public void setListSelector(Drawable paramDrawable)
  {
    this.mDropDownListHighlight = paramDrawable;
  }
  
  public void setModal(boolean paramBoolean)
  {
    this.mModal = true;
    this.mPopup.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.mItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void setPromptPosition(int paramInt)
  {
    this.mPromptPosition = paramInt;
  }
  
  public void setPromptView(View paramView)
  {
    boolean bool = isShowing();
    if (bool) {
      removePromptView();
    }
    this.mPromptView = paramView;
    if (bool) {
      show();
    }
  }
  
  public void setSelection(int paramInt)
  {
    ListPopupWindow.DropDownListView localDropDownListView = this.mDropDownList;
    if ((isShowing()) && (localDropDownListView != null))
    {
      ListPopupWindow.DropDownListView.access$502(localDropDownListView, false);
      localDropDownListView.setSelection(paramInt);
      if (localDropDownListView.getChoiceMode() != 0) {
        localDropDownListView.setItemChecked(paramInt, true);
      }
    }
  }
  
  public void setSoftInputMode(int paramInt)
  {
    this.mPopup.setSoftInputMode(paramInt);
  }
  
  public void setVerticalOffset(int paramInt)
  {
    this.mDropDownVerticalOffset = paramInt;
    this.mDropDownVerticalOffsetSet = true;
  }
  
  public void setWidth(int paramInt)
  {
    this.mDropDownWidth = paramInt;
  }
  
  public void show()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int k = -1;
    int j = buildDropDown();
    boolean bool3 = isInputMethodNotNeeded();
    int i;
    label52:
    PopupWindow localPopupWindow;
    if (this.mPopup.isShowing())
    {
      if (this.mDropDownWidth == -1)
      {
        i = -1;
        if (this.mDropDownHeight != -1) {
          break label207;
        }
        if (!bool3) {
          break label166;
        }
        if (!bool3) {
          break label176;
        }
        localPopupWindow = this.mPopup;
        if (this.mDropDownWidth != -1) {
          break label171;
        }
        label71:
        localPopupWindow.setWindowLayoutMode(k, 0);
      }
      for (;;)
      {
        localPopupWindow = this.mPopup;
        bool1 = bool2;
        if (!this.mForceIgnoreOutsideTouch)
        {
          bool1 = bool2;
          if (!this.mDropDownAlwaysVisible) {
            bool1 = true;
          }
        }
        localPopupWindow.setOutsideTouchable(bool1);
        this.mPopup.update(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, i, j);
        return;
        if (this.mDropDownWidth == -2)
        {
          i = getAnchorView().getWidth();
          break;
        }
        i = this.mDropDownWidth;
        break;
        label166:
        j = -1;
        break label52;
        label171:
        k = 0;
        break label71;
        label176:
        localPopupWindow = this.mPopup;
        if (this.mDropDownWidth == -1) {}
        for (k = -1;; k = 0)
        {
          localPopupWindow.setWindowLayoutMode(k, -1);
          break;
        }
        label207:
        if (this.mDropDownHeight != -2) {
          j = this.mDropDownHeight;
        }
      }
    }
    if (this.mDropDownWidth == -1)
    {
      i = -1;
      label234:
      if (this.mDropDownHeight != -1) {
        break label403;
      }
      j = -1;
      label244:
      this.mPopup.setWindowLayoutMode(i, j);
      localPopupWindow = this.mPopup;
      if ((this.mForceIgnoreOutsideTouch) || (this.mDropDownAlwaysVisible)) {
        break label441;
      }
    }
    for (;;)
    {
      localPopupWindow.setOutsideTouchable(bool1);
      this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
      this.mPopup.showAsDropDown(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
      this.mDropDownList.setSelection(-1);
      if ((!this.mModal) || (this.mDropDownList.isInTouchMode())) {
        clearListSelection();
      }
      if (this.mModal) {
        break;
      }
      this.mHandler.post(this.mHideSelector);
      return;
      if (this.mDropDownWidth == -2)
      {
        this.mPopup.setWidth(getAnchorView().getWidth());
        i = 0;
        break label234;
      }
      this.mPopup.setWidth(this.mDropDownWidth);
      i = 0;
      break label234;
      label403:
      if (this.mDropDownHeight == -2)
      {
        this.mPopup.setHeight(j);
        j = 0;
        break label244;
      }
      this.mPopup.setHeight(this.mDropDownHeight);
      j = 0;
      break label244;
      label441:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */