package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

abstract class AbsSpinnerICS
  extends AdapterViewICS
{
  SpinnerAdapter mAdapter;
  boolean mBlockLayoutRequests;
  private DataSetObserver mDataSetObserver;
  int mHeightMeasureSpec;
  final AbsSpinnerICS.RecycleBin mRecycler = new AbsSpinnerICS.RecycleBin(this);
  int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  final Rect mSpinnerPadding = new Rect();
  private Rect mTouchFrame;
  int mWidthMeasureSpec;
  
  AbsSpinnerICS(Context paramContext)
  {
    super(paramContext);
    initAbsSpinner();
  }
  
  AbsSpinnerICS(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  AbsSpinnerICS(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initAbsSpinner();
  }
  
  private void initAbsSpinner()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public SpinnerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  int getChildHeight(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  int getChildWidth(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  public int getCount()
  {
    return this.mItemCount;
  }
  
  public View getSelectedView()
  {
    if ((this.mItemCount > 0) && (this.mSelectedPosition >= 0)) {
      return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }
    return null;
  }
  
  abstract void layout(int paramInt, boolean paramBoolean);
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    int i = getPaddingLeft();
    int m = getPaddingTop();
    int k = getPaddingRight();
    int j = getPaddingBottom();
    Object localObject = this.mSpinnerPadding;
    if (i > this.mSelectionLeftPadding)
    {
      ((Rect)localObject).left = i;
      localObject = this.mSpinnerPadding;
      if (m <= this.mSelectionTopPadding) {
        break label414;
      }
      i = m;
      label67:
      ((Rect)localObject).top = i;
      localObject = this.mSpinnerPadding;
      if (k <= this.mSelectionRightPadding) {
        break label422;
      }
      i = k;
      label91:
      ((Rect)localObject).right = i;
      localObject = this.mSpinnerPadding;
      if (j <= this.mSelectionBottomPadding) {
        break label430;
      }
      i = j;
      label115:
      ((Rect)localObject).bottom = i;
      if (this.mDataChanged) {
        handleDataChanged();
      }
      i = getSelectedItemPosition();
      if ((i < 0) || (this.mAdapter == null) || (i >= this.mAdapter.getCount())) {
        break label438;
      }
      View localView = this.mRecycler.get(i);
      localObject = localView;
      if (localView == null) {
        localObject = this.mAdapter.getView(i, null, this);
      }
      if (localObject != null) {
        this.mRecycler.put(i, (View)localObject);
      }
      if (localObject == null) {
        break label438;
      }
      if (((View)localObject).getLayoutParams() == null)
      {
        this.mBlockLayoutRequests = true;
        ((View)localObject).setLayoutParams(generateDefaultLayoutParams());
        this.mBlockLayoutRequests = false;
      }
      measureChild((View)localObject, paramInt1, paramInt2);
      j = getChildHeight((View)localObject) + this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
      i = getChildWidth((View)localObject) + this.mSpinnerPadding.left + this.mSpinnerPadding.right;
      k = 0;
    }
    for (;;)
    {
      m = i;
      if (k != 0)
      {
        k = this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
        m = i;
        j = k;
        if (n == 0)
        {
          m = this.mSpinnerPadding.left + this.mSpinnerPadding.right;
          j = k;
        }
      }
      i = Math.max(j, getSuggestedMinimumHeight());
      j = Math.max(m, getSuggestedMinimumWidth());
      i = resolveSize(i, paramInt2);
      setMeasuredDimension(resolveSize(j, paramInt1), i);
      this.mHeightMeasureSpec = paramInt2;
      this.mWidthMeasureSpec = paramInt1;
      return;
      i = this.mSelectionLeftPadding;
      break;
      label414:
      i = this.mSelectionTopPadding;
      break label67;
      label422:
      i = this.mSelectionRightPadding;
      break label91;
      label430:
      i = this.mSelectionBottomPadding;
      break label115;
      label438:
      k = 1;
      i = 0;
      j = 0;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AbsSpinnerICS.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.selectedId >= 0L)
    {
      this.mDataChanged = true;
      this.mNeedSync = true;
      this.mSyncRowId = paramParcelable.selectedId;
      this.mSyncPosition = paramParcelable.position;
      this.mSyncMode = 0;
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    AbsSpinnerICS.SavedState localSavedState = new AbsSpinnerICS.SavedState(super.onSaveInstanceState());
    localSavedState.selectedId = getSelectedItemId();
    if (localSavedState.selectedId >= 0L)
    {
      localSavedState.position = getSelectedItemPosition();
      return localSavedState;
    }
    localSavedState.position = -1;
    return localSavedState;
  }
  
  public int pointToPosition(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.mTouchFrame;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.mTouchFrame = new Rect();
      localObject1 = this.mTouchFrame;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject2 = getChildAt(i);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return this.mFirstPosition + i;
        }
      }
      i -= 1;
    }
    return -1;
  }
  
  void recycleAllViews()
  {
    int j = getChildCount();
    AbsSpinnerICS.RecycleBin localRecycleBin = this.mRecycler;
    int k = this.mFirstPosition;
    int i = 0;
    while (i < j)
    {
      localRecycleBin.put(k + i, getChildAt(i));
      i += 1;
    }
  }
  
  public void requestLayout()
  {
    if (!this.mBlockLayoutRequests) {
      super.requestLayout();
    }
  }
  
  void resetList()
  {
    this.mDataChanged = false;
    this.mNeedSync = false;
    removeAllViewsInLayout();
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    invalidate();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    int i = -1;
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
      resetList();
    }
    this.mAdapter = paramSpinnerAdapter;
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    if (this.mAdapter != null)
    {
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.mAdapter.getCount();
      checkFocus();
      this.mDataSetObserver = new AdapterViewICS.AdapterDataSetObserver(this);
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
      if (this.mItemCount > 0) {
        i = 0;
      }
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      if (this.mItemCount == 0) {
        checkSelectionChanged();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      checkFocus();
      resetList();
      checkSelectionChanged();
    }
  }
  
  public void setSelection(int paramInt)
  {
    setNextSelectedPositionInt(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mFirstPosition <= paramInt) && (paramInt <= this.mFirstPosition + getChildCount() - 1)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setSelectionInt(paramInt, paramBoolean);
      return;
    }
  }
  
  void setSelectionInt(int paramInt, boolean paramBoolean)
  {
    if (paramInt != this.mOldSelectedPosition)
    {
      this.mBlockLayoutRequests = true;
      int i = this.mSelectedPosition;
      setNextSelectedPositionInt(paramInt);
      layout(paramInt - i, paramBoolean);
      this.mBlockLayoutRequests = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.AbsSpinnerICS
 * JD-Core Version:    0.7.0.1
 */