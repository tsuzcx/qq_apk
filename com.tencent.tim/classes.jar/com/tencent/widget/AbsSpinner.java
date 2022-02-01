package com.tencent.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import aush;
import auvm;

public abstract class AbsSpinner
  extends AdapterView<SpinnerAdapter>
{
  private static int ABSSPINNER_ENTRIES = -2;
  final a a = new a();
  SpinnerAdapter mAdapter;
  boolean mBlockLayoutRequests;
  private DataSetObserver mDataSetObserver;
  int mHeightMeasureSpec;
  int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  final Rect mSpinnerPadding = new Rect();
  private Rect mTouchFrame;
  int mWidthMeasureSpec;
  
  public AbsSpinner(Context paramContext)
  {
    super(paramContext);
    initAbsSpinner();
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, true);
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initAbsSpinner();
    if (paramBoolean)
    {
      if (ABSSPINNER_ENTRIES == -2) {
        ABSSPINNER_ENTRIES = getStyleableValue("AbsSpinner_entries");
      }
      paramAttributeSet = new auvm(paramContext.obtainStyledAttributes(paramAttributeSet, getStyleableValues("AbsSpinner"), paramInt, 0));
      CharSequence[] arrayOfCharSequence = paramAttributeSet.getTextArray(ABSSPINNER_ENTRIES);
      if (arrayOfCharSequence != null)
      {
        paramContext = new ArrayAdapter(paramContext, 17367048, arrayOfCharSequence);
        paramContext.setDropDownViewResource(17367049);
        setAdapter(paramContext);
      }
      paramAttributeSet.recycle();
    }
  }
  
  public static int doResolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (j)
    {
    default: 
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      return 0xFF000000 & paramInt3 | paramInt2;
      paramInt2 = paramInt1;
      if (i < paramInt1)
      {
        paramInt2 = i | 0x1000000;
        continue;
        paramInt2 = i;
      }
    }
  }
  
  private void initAbsSpinner()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  protected AdapterView.b a()
  {
    return new AdapterView.b(this);
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
    Object localObject = this.mSpinnerPadding;
    int i;
    label56:
    label84:
    label112:
    int j;
    int k;
    if (this.mPaddingLeft > this.mSelectionLeftPadding)
    {
      i = this.mPaddingLeft;
      ((Rect)localObject).left = i;
      localObject = this.mSpinnerPadding;
      if (this.mPaddingTop <= this.mSelectionTopPadding) {
        break label413;
      }
      i = this.mPaddingTop;
      ((Rect)localObject).top = i;
      localObject = this.mSpinnerPadding;
      if (this.mPaddingRight <= this.mSelectionRightPadding) {
        break label421;
      }
      i = this.mPaddingRight;
      ((Rect)localObject).right = i;
      localObject = this.mSpinnerPadding;
      if (this.mPaddingBottom <= this.mSelectionBottomPadding) {
        break label429;
      }
      i = this.mPaddingBottom;
      ((Rect)localObject).bottom = i;
      if (this.mDataChanged) {
        handleDataChanged();
      }
      i = getSelectedItemPosition();
      if ((i < 0) || (this.mAdapter == null) || (i >= this.mAdapter.getCount())) {
        break label437;
      }
      View localView = this.a.get(i);
      localObject = localView;
      if (localView == null) {
        localObject = this.mAdapter.getView(i, null, this);
      }
      if (localObject != null) {
        this.a.put(i, (View)localObject);
      }
      if (localObject == null) {
        break label437;
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
      int m = i;
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
      i = doResolveSizeAndState(i, paramInt2, 0);
      setMeasuredDimension(doResolveSizeAndState(j, paramInt1, 0), i);
      this.mHeightMeasureSpec = paramInt2;
      this.mWidthMeasureSpec = paramInt1;
      return;
      i = this.mSelectionLeftPadding;
      break;
      label413:
      i = this.mSelectionTopPadding;
      break label56;
      label421:
      i = this.mSelectionRightPadding;
      break label84;
      label429:
      i = this.mSelectionBottomPadding;
      break label112;
      label437:
      k = 1;
      i = 0;
      j = 0;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
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
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
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
    a locala = this.a;
    int k = this.mFirstPosition;
    int i = 0;
    while (i < j)
    {
      locala.put(k + i, getChildAt(i));
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
      this.mDataSetObserver = a();
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
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new aush();
    int position;
    long selectedId;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.selectedId = paramParcel.readLong();
      this.position = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeLong(this.selectedId);
      paramParcel.writeInt(this.position);
    }
  }
  
  class a
  {
    private final SparseArray<View> mScrapHeap = new SparseArray();
    
    a() {}
    
    void clear()
    {
      SparseArray localSparseArray = this.mScrapHeap;
      int j = localSparseArray.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)localSparseArray.valueAt(i);
        if (localView != null) {
          AbsSpinner.a(AbsSpinner.this, localView, true);
        }
        i += 1;
      }
      localSparseArray.clear();
    }
    
    void clearByTag()
    {
      SparseArray localSparseArray = this.mScrapHeap;
      int j = localSparseArray.size();
      int i = 0;
      View localView;
      if (i < j)
      {
        localView = (View)localSparseArray.valueAt(i);
        if ((localView == null) || (!(localView.getTag(2131367834) instanceof Boolean))) {
          break label94;
        }
      }
      label94:
      for (boolean bool = ((Boolean)localView.getTag(2131367834)).booleanValue();; bool = true)
      {
        if ((localView != null) && (bool)) {
          AbsSpinner.b(AbsSpinner.this, localView, true);
        }
        i += 1;
        break;
        localSparseArray.clear();
        return;
      }
    }
    
    View get(int paramInt)
    {
      View localView = (View)this.mScrapHeap.get(paramInt);
      if (localView != null) {
        this.mScrapHeap.delete(paramInt);
      }
      return localView;
    }
    
    public void put(int paramInt, View paramView)
    {
      this.mScrapHeap.put(paramInt, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.AbsSpinner
 * JD-Core Version:    0.7.0.1
 */