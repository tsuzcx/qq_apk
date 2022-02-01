package com.tencent.qqmail.card.view.Gallery;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Interpolator;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import com.tencent.androidqqmail.R.styleable;
import java.util.ArrayList;
import java.util.List;

public abstract class EcoGalleryAbsSpinner
  extends EcoGalleryAdapterView<SpinnerAdapter>
{
  static boolean GalleryLog = false;
  private static final String TAG = "Gallery";
  SpinnerAdapter mAdapter;
  boolean mAdapterHasStableIds = false;
  boolean mBlockLayoutRequests;
  private DataSetObserver mDataSetObserver;
  int mHeightMeasureSpec;
  Interpolator mInterpolator;
  boolean[] mIsScraped = new boolean[1];
  RecycleBin1 mRecycler = new RecycleBin1();
  View mSelectedView = null;
  int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  Rect mSpinnerPadding = new Rect();
  private Rect mTouchFrame;
  int mWidthMeasureSpec;
  
  public EcoGalleryAbsSpinner(Context paramContext)
  {
    super(paramContext);
    initAbsSpinner();
  }
  
  public EcoGalleryAbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EcoGalleryAbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initAbsSpinner();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CustomAbsSpinner, paramInt, 0);
    CharSequence[] arrayOfCharSequence = paramAttributeSet.getTextArray(R.styleable.CustomAbsSpinner_entries);
    if (arrayOfCharSequence != null)
    {
      paramContext = new ArrayAdapter(paramContext, 17367048, arrayOfCharSequence);
      paramContext.setDropDownViewResource(17367049);
      setAdapter(paramContext);
    }
    paramAttributeSet.recycle();
  }
  
  private void initAbsSpinner()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  private void setItemViewLayoutParams(View paramView, int paramInt)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = generateDefaultLayoutParams();
    }
    for (;;)
    {
      if (this.mAdapterHasStableIds) {
        ((LayoutParams)localObject).itemId = this.mAdapter.getItemId(paramInt);
      }
      ((LayoutParams)localObject).viewType = this.mAdapter.getItemViewType(paramInt);
      this.mBlockLayoutRequests = true;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mBlockLayoutRequests = false;
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = (LayoutParams)generateLayoutParams((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (LayoutParams)localObject;
      }
    }
  }
  
  public void enableBlockLayout(boolean paramBoolean)
  {
    this.mBlockLayoutRequests = paramBoolean;
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -2);
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
  
  void handleDataChanged()
  {
    super.handleDataChanged();
  }
  
  abstract void layout(int paramInt, boolean paramBoolean);
  
  protected void logInGalleryD(String paramString)
  {
    if (GalleryLog) {
      Log.d("Gallery", paramString);
    }
  }
  
  protected void logInGalleryI(String paramString)
  {
    if (GalleryLog) {
      Log.i("Gallery", paramString);
    }
  }
  
  protected void logInGalleryV(String paramString)
  {
    if (GalleryLog) {
      Log.v("Gallery", paramString);
    }
  }
  
  protected void logInGalleryW(String paramString)
  {
    if (GalleryLog) {
      Log.w("Gallery", paramString);
    }
  }
  
  View obtainView(int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    View localView1 = this.mRecycler.getTransientStateView(paramInt);
    if (localView1 != null)
    {
      if (((LayoutParams)localView1.getLayoutParams()).viewType == this.mAdapter.getItemViewType(paramInt))
      {
        localView2 = this.mAdapter.getView(paramInt, localView1, this);
        if (localView2 != localView1)
        {
          setItemViewLayoutParams(localView2, paramInt);
          this.mRecycler.addScrapView(localView2, paramInt);
        }
      }
      paramArrayOfBoolean[0] = true;
      return localView1;
    }
    localView1 = this.mRecycler.getActiveView(paramInt);
    if (localView1 != null)
    {
      logInGalleryI("obtain from active, postition:" + paramInt);
      return localView1;
    }
    logInGalleryV("obtainView1, postition:" + paramInt);
    localView1 = this.mRecycler.getScrapView(paramInt);
    logInGalleryV("obtainView2, postition:" + paramInt);
    View localView2 = this.mAdapter.getView(paramInt, localView1, this);
    if (localView1 != null)
    {
      logInGalleryI("obtain from scrapView, postition:" + paramInt);
      if (localView2 != localView1) {
        this.mRecycler.addScrapView(localView1, paramInt);
      }
    }
    for (;;)
    {
      if (ViewCompat.getImportantForAccessibility(localView2) == 0) {
        ViewCompat.setImportantForAccessibility(localView2, 1);
      }
      setItemViewLayoutParams(localView2, paramInt);
      return localView2;
      paramArrayOfBoolean[0] = true;
      ViewCompat.dispatchFinishTemporaryDetach(localView2);
      continue;
      logInGalleryI("obtain new, postition:" + paramInt);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mRecycler.clear();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    int i = getPaddingLeft();
    int k = getPaddingRight();
    int m = getPaddingTop();
    int j = getPaddingBottom();
    Object localObject = this.mSpinnerPadding;
    if (i > this.mSelectionLeftPadding)
    {
      ((Rect)localObject).left = i;
      localObject = this.mSpinnerPadding;
      if (m <= this.mSelectionTopPadding) {
        break label450;
      }
      i = m;
      label67:
      ((Rect)localObject).top = i;
      localObject = this.mSpinnerPadding;
      if (k <= this.mSelectionRightPadding) {
        break label458;
      }
      i = k;
      label91:
      ((Rect)localObject).right = i;
      localObject = this.mSpinnerPadding;
      if (j <= this.mSelectionBottomPadding) {
        break label466;
      }
      i = j;
      label115:
      ((Rect)localObject).bottom = i;
      if (this.mDataChanged) {
        handleDataChanged();
      }
      k = getSelectedItemPosition();
      if ((k < 0) || (this.mAdapter == null)) {
        break label474;
      }
      localObject = null;
      if (this.mFirstPosition != -1) {
        localObject = getChildAt(k - this.mFirstPosition);
      }
      logInGalleryV("obtainView in measure, selectedPosition:" + k);
      if (localObject != null) {
        break label485;
      }
      localObject = obtainView(k, this.mIsScraped);
    }
    label450:
    label458:
    label466:
    label474:
    label485:
    for (i = 1;; i = 0)
    {
      if (localObject != null)
      {
        if (((View)localObject).getLayoutParams() == null)
        {
          this.mBlockLayoutRequests = true;
          ((View)localObject).setLayoutParams(generateDefaultLayoutParams());
          this.mBlockLayoutRequests = false;
        }
        measureChild((View)localObject, paramInt1, paramInt2);
        j = getChildHeight((View)localObject);
        m = this.mSpinnerPadding.top;
        j = this.mSpinnerPadding.bottom + (j + m);
        m = getChildWidth((View)localObject) + this.mSpinnerPadding.left + this.mSpinnerPadding.right;
        if (i != 0) {
          this.mRecycler.addScrapView((View)localObject, k);
        }
        k = 0;
        i = m;
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
        i = this.mSelectionTopPadding;
        break label67;
        i = this.mSelectionRightPadding;
        break label91;
        i = this.mSelectionBottomPadding;
        break label115;
        k = 1;
        i = 0;
        j = 0;
      }
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
    this.mRecycler.fillActiveViews(getChildCount(), this.mFirstPosition);
    if (this.mDataChanged) {
      this.mRecycler.scrapActiveViews();
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
    this.mRecycler.clear();
    this.mAdapter = paramSpinnerAdapter;
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    if (this.mAdapter != null)
    {
      this.mRecycler.setViewTypeCount(this.mAdapter.getViewTypeCount());
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.mAdapter.getCount();
      checkFocus();
      this.mDataSetObserver = new EcoGalleryAdapterView.AdapterDataSetObserver(this);
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
  
  public void setRecyclerListener(RecyclerListener paramRecyclerListener)
  {
    RecycleBin1.access$002(this.mRecycler, paramRecyclerListener);
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
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    long itemId = -1L;
    int scrappedFromPosition;
    int viewType;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  class RecycleBin
  {
    private SparseArray<View> mScrapHeap = new SparseArray();
    
    RecycleBin() {}
    
    public void add(int paramInt, View paramView)
    {
      this.mScrapHeap.put(this.mScrapHeap.size(), paramView);
    }
    
    void clear()
    {
      SparseArray localSparseArray = this.mScrapHeap;
      int j = localSparseArray.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)localSparseArray.valueAt(i);
        if (localView != null) {
          EcoGalleryAbsSpinner.this.removeDetachedView(localView, true);
        }
        i += 1;
      }
      localSparseArray.clear();
    }
    
    public View get()
    {
      Object localObject;
      if (this.mScrapHeap.size() < 1) {
        localObject = null;
      }
      View localView;
      int i;
      do
      {
        return localObject;
        localView = (View)this.mScrapHeap.valueAt(0);
        i = this.mScrapHeap.keyAt(0);
        localObject = localView;
      } while (localView == null);
      this.mScrapHeap.delete(i);
      return localView;
    }
    
    View get(int paramInt)
    {
      View localView = (View)this.mScrapHeap.get(paramInt);
      if (localView != null) {
        this.mScrapHeap.delete(paramInt);
      }
      return localView;
    }
    
    View peek(int paramInt)
    {
      return (View)this.mScrapHeap.get(paramInt);
    }
    
    public void put(int paramInt, View paramView)
    {
      this.mScrapHeap.put(paramInt, paramView);
    }
  }
  
  class RecycleBin1
  {
    private View[] mActiveViews = new View[0];
    private ArrayList<View> mCurrentScrap;
    private int mFirstActivePosition;
    private EcoGalleryAbsSpinner.RecyclerListener mRecyclerListener;
    private ArrayList<View>[] mScrapViews;
    private ArrayList<View> mSkippedScrap;
    private SparseArray<View> mTransientStateViews;
    private LongSparseArray<View> mTransientStateViewsById;
    private int mViewTypeCount;
    
    RecycleBin1() {}
    
    private void clearAccessibilityFromScrap(View paramView) {}
    
    private void clearScrap(ArrayList<View> paramArrayList)
    {
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        removeDetachedView((View)paramArrayList.remove(j - 1 - i), false);
        i += 1;
      }
    }
    
    private void pruneScrapViews()
    {
      int m = this.mActiveViews.length;
      int n = this.mViewTypeCount;
      Object localObject = this.mScrapViews;
      int i = 0;
      View localView;
      int j;
      while (i < n)
      {
        localView = localObject[i];
        int i1 = localView.size();
        j = i1 - 1;
        int k = 0;
        while (k < i1 - m)
        {
          removeDetachedView((View)localView.remove(j), false);
          k += 1;
          j -= 1;
        }
        i += 1;
      }
      localObject = this.mTransientStateViews;
      if (localObject != null) {
        for (i = 0; i < ((SparseArray)localObject).size(); i = j + 1)
        {
          localView = (View)((SparseArray)localObject).valueAt(i);
          j = i;
          if (!ViewCompat.hasTransientState(localView))
          {
            removeDetachedView(localView, false);
            ((SparseArray)localObject).remove(((SparseArray)localObject).keyAt(i));
            j = i - 1;
          }
        }
      }
      localObject = this.mTransientStateViewsById;
      if (localObject != null) {
        for (i = 0; i < ((LongSparseArray)localObject).size(); i = j + 1)
        {
          localView = (View)((LongSparseArray)localObject).valueAt(i);
          j = i;
          if (!ViewCompat.hasTransientState(localView))
          {
            removeDetachedView(localView, false);
            ((LongSparseArray)localObject).removeAt(i);
            j = i - 1;
          }
        }
      }
    }
    
    private void removeDetachedView(View paramView, boolean paramBoolean)
    {
      EcoGalleryAbsSpinner.this.removeDetachedView(paramView, paramBoolean);
    }
    
    private View retrieveFromScrap(ArrayList<View> paramArrayList, int paramInt)
    {
      int j = paramArrayList.size();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          EcoGalleryAbsSpinner.LayoutParams localLayoutParams = (EcoGalleryAbsSpinner.LayoutParams)((View)paramArrayList.get(i)).getLayoutParams();
          if (EcoGalleryAbsSpinner.this.mAdapterHasStableIds)
          {
            if (EcoGalleryAbsSpinner.this.mAdapter.getItemId(paramInt) == localLayoutParams.itemId) {
              return (View)paramArrayList.remove(i);
            }
          }
          else if (localLayoutParams.scrappedFromPosition == paramInt)
          {
            paramArrayList = (View)paramArrayList.remove(i);
            clearAccessibilityFromScrap(paramArrayList);
            return paramArrayList;
          }
          i += 1;
        }
        paramArrayList = (View)paramArrayList.remove(j - 1);
        clearAccessibilityFromScrap(paramArrayList);
        return paramArrayList;
      }
      return null;
    }
    
    void addScrapView(View paramView, int paramInt)
    {
      EcoGalleryAbsSpinner.this.logInGalleryW("addScrapView, position:" + paramInt);
      EcoGalleryAbsSpinner.LayoutParams localLayoutParams = (EcoGalleryAbsSpinner.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams == null) {}
      for (;;)
      {
        return;
        localLayoutParams.scrappedFromPosition = paramInt;
        int i = localLayoutParams.viewType;
        if (shouldRecycleViewType(i))
        {
          ViewCompat.dispatchStartTemporaryDetach(paramView);
          if (ViewCompat.hasTransientState(paramView))
          {
            if ((EcoGalleryAbsSpinner.this.mAdapter != null) && (EcoGalleryAbsSpinner.this.mAdapterHasStableIds))
            {
              if (this.mTransientStateViewsById == null) {
                this.mTransientStateViewsById = new LongSparseArray();
              }
              this.mTransientStateViewsById.put(localLayoutParams.itemId, paramView);
              return;
            }
            if (!EcoGalleryAbsSpinner.this.mDataChanged)
            {
              if (this.mTransientStateViews == null) {
                this.mTransientStateViews = new SparseArray();
              }
              this.mTransientStateViews.put(paramInt, paramView);
              return;
            }
            if (this.mSkippedScrap == null) {
              this.mSkippedScrap = new ArrayList();
            }
            this.mSkippedScrap.add(paramView);
            return;
          }
          if (this.mViewTypeCount == 1) {
            this.mCurrentScrap.add(paramView);
          }
          while (this.mRecyclerListener != null)
          {
            this.mRecyclerListener.onMovedToScrapHeap(paramView);
            return;
            this.mScrapViews[i].add(paramView);
          }
        }
      }
    }
    
    void clear()
    {
      if (this.mViewTypeCount == 1) {
        clearScrap(this.mCurrentScrap);
      }
      for (;;)
      {
        clearTransientStateViews();
        return;
        int j = this.mViewTypeCount;
        int i = 0;
        while (i < j)
        {
          clearScrap(this.mScrapViews[i]);
          i += 1;
        }
      }
    }
    
    void clearTransientStateViews()
    {
      Object localObject = this.mTransientStateViews;
      int j;
      int i;
      if (localObject != null)
      {
        j = ((SparseArray)localObject).size();
        i = 0;
        while (i < j)
        {
          removeDetachedView((View)((SparseArray)localObject).valueAt(i), false);
          i += 1;
        }
        ((SparseArray)localObject).clear();
      }
      localObject = this.mTransientStateViewsById;
      if (localObject != null)
      {
        j = ((LongSparseArray)localObject).size();
        i = 0;
        while (i < j)
        {
          removeDetachedView((View)((LongSparseArray)localObject).valueAt(i), false);
          i += 1;
        }
        ((LongSparseArray)localObject).clear();
      }
    }
    
    void fillActiveViews(int paramInt1, int paramInt2)
    {
      if (this.mActiveViews.length < paramInt1) {
        this.mActiveViews = new View[paramInt1];
      }
      this.mFirstActivePosition = paramInt2;
      View[] arrayOfView = this.mActiveViews;
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        View localView = EcoGalleryAbsSpinner.this.getChildAt(paramInt2);
        EcoGalleryAbsSpinner.LayoutParams localLayoutParams = (EcoGalleryAbsSpinner.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams != null) && (localLayoutParams.viewType != -2)) {
          arrayOfView[paramInt2] = localView;
        }
        paramInt2 += 1;
      }
    }
    
    View getActiveView(int paramInt)
    {
      paramInt -= this.mFirstActivePosition;
      View[] arrayOfView = this.mActiveViews;
      if ((paramInt >= 0) && (paramInt < arrayOfView.length))
      {
        View localView = arrayOfView[paramInt];
        arrayOfView[paramInt] = null;
        return localView;
      }
      return null;
    }
    
    View getScrapView(int paramInt)
    {
      if (this.mViewTypeCount == 1) {
        return retrieveFromScrap(this.mCurrentScrap, paramInt);
      }
      int i = EcoGalleryAbsSpinner.this.mAdapter.getItemViewType(paramInt);
      if ((i >= 0) && (i < this.mScrapViews.length)) {
        return retrieveFromScrap(this.mScrapViews[i], paramInt);
      }
      return null;
    }
    
    View getTransientStateView(int paramInt)
    {
      View localView;
      if ((EcoGalleryAbsSpinner.this.mAdapter != null) && (EcoGalleryAbsSpinner.this.mAdapterHasStableIds) && (this.mTransientStateViewsById != null))
      {
        long l = EcoGalleryAbsSpinner.this.mAdapter.getItemId(paramInt);
        localView = (View)this.mTransientStateViewsById.get(l);
        this.mTransientStateViewsById.remove(l);
        return localView;
      }
      if (this.mTransientStateViews != null)
      {
        paramInt = this.mTransientStateViews.indexOfKey(paramInt);
        if (paramInt >= 0)
        {
          localView = (View)this.mTransientStateViews.valueAt(paramInt);
          this.mTransientStateViews.remove(this.mTransientStateViews.keyAt(paramInt));
          return localView;
        }
      }
      return null;
    }
    
    public void markChildrenDirty()
    {
      int k = 0;
      ArrayList localArrayList;
      int j;
      if (this.mViewTypeCount == 1)
      {
        localArrayList = this.mCurrentScrap;
        j = localArrayList.size();
        i = 0;
        while (i < j)
        {
          ((View)localArrayList.get(i)).forceLayout();
          i += 1;
        }
      }
      int m = this.mViewTypeCount;
      int i = 0;
      while (i < m)
      {
        localArrayList = this.mScrapViews[i];
        int n = localArrayList.size();
        j = 0;
        while (j < n)
        {
          ((View)localArrayList.get(j)).forceLayout();
          j += 1;
        }
        i += 1;
      }
      if (this.mTransientStateViews != null)
      {
        j = this.mTransientStateViews.size();
        i = 0;
        while (i < j)
        {
          ((View)this.mTransientStateViews.valueAt(i)).forceLayout();
          i += 1;
        }
      }
      if (this.mTransientStateViewsById != null)
      {
        j = this.mTransientStateViewsById.size();
        i = k;
        while (i < j)
        {
          ((View)this.mTransientStateViewsById.valueAt(i)).forceLayout();
          i += 1;
        }
      }
    }
    
    void reclaimScrapViews(List<View> paramList)
    {
      if (this.mViewTypeCount == 1) {
        paramList.addAll(this.mCurrentScrap);
      }
      for (;;)
      {
        return;
        int j = this.mViewTypeCount;
        ArrayList[] arrayOfArrayList = this.mScrapViews;
        int i = 0;
        while (i < j)
        {
          paramList.addAll(arrayOfArrayList[i]);
          i += 1;
        }
      }
    }
    
    void removeSkippedScrap()
    {
      if (this.mSkippedScrap == null) {
        return;
      }
      int j = this.mSkippedScrap.size();
      int i = 0;
      while (i < j)
      {
        removeDetachedView((View)this.mSkippedScrap.get(i), false);
        i += 1;
      }
      this.mSkippedScrap.clear();
    }
    
    void scrapActiveViews()
    {
      View[] arrayOfView = this.mActiveViews;
      int i;
      int j;
      label25:
      Object localObject1;
      int k;
      label37:
      View localView;
      Object localObject2;
      int m;
      if (this.mRecyclerListener != null)
      {
        i = 1;
        if (this.mViewTypeCount <= 1) {
          break label180;
        }
        j = 1;
        localObject1 = this.mCurrentScrap;
        k = arrayOfView.length - 1;
        if (k < 0) {
          break label357;
        }
        localView = arrayOfView[k];
        localObject2 = localObject1;
        if (localView != null)
        {
          localObject2 = (EcoGalleryAbsSpinner.LayoutParams)localView.getLayoutParams();
          m = ((EcoGalleryAbsSpinner.LayoutParams)localObject2).viewType;
          arrayOfView[k] = null;
          if (!ViewCompat.hasTransientState(localView)) {
            break label260;
          }
          ViewCompat.dispatchStartTemporaryDetach(localView);
          if ((EcoGalleryAbsSpinner.this.mAdapter == null) || (!EcoGalleryAbsSpinner.this.mAdapterHasStableIds)) {
            break label185;
          }
          if (this.mTransientStateViewsById == null) {
            this.mTransientStateViewsById = new LongSparseArray();
          }
          long l = EcoGalleryAbsSpinner.this.mAdapter.getItemId(this.mFirstActivePosition + k);
          this.mTransientStateViewsById.put(l, localView);
          localObject2 = localObject1;
        }
      }
      label260:
      for (;;)
      {
        k -= 1;
        localObject1 = localObject2;
        break label37;
        i = 0;
        break;
        label180:
        j = 0;
        break label25;
        label185:
        if (!EcoGalleryAbsSpinner.this.mDataChanged)
        {
          if (this.mTransientStateViews == null) {
            this.mTransientStateViews = new SparseArray();
          }
          this.mTransientStateViews.put(this.mFirstActivePosition + k, localView);
          localObject2 = localObject1;
        }
        else
        {
          localObject2 = localObject1;
          if (m != -2)
          {
            removeDetachedView(localView, false);
            localObject2 = localObject1;
            continue;
            if (!shouldRecycleViewType(m))
            {
              localObject2 = localObject1;
              if (m != -2)
              {
                removeDetachedView(localView, false);
                localObject2 = localObject1;
              }
            }
            else
            {
              if (j != 0) {
                localObject1 = this.mScrapViews[m];
              }
              ViewCompat.dispatchStartTemporaryDetach(localView);
              ((EcoGalleryAbsSpinner.LayoutParams)localObject2).scrappedFromPosition = (this.mFirstActivePosition + k);
              ((ArrayList)localObject1).add(localView);
              localObject2 = localObject1;
              if (i != 0)
              {
                this.mRecyclerListener.onMovedToScrapHeap(localView);
                localObject2 = localObject1;
              }
            }
          }
        }
      }
      label357:
      pruneScrapViews();
    }
    
    void setCacheColorHint(int paramInt)
    {
      if (this.mViewTypeCount == 1)
      {
        localObject1 = this.mCurrentScrap;
        j = ((ArrayList)localObject1).size();
        i = 0;
        while (i < j)
        {
          ((View)((ArrayList)localObject1).get(i)).setDrawingCacheBackgroundColor(paramInt);
          i += 1;
        }
      }
      int k = this.mViewTypeCount;
      int i = 0;
      while (i < k)
      {
        localObject1 = this.mScrapViews[i];
        int m = ((ArrayList)localObject1).size();
        j = 0;
        while (j < m)
        {
          ((View)((ArrayList)localObject1).get(j)).setDrawingCacheBackgroundColor(paramInt);
          j += 1;
        }
        i += 1;
      }
      Object localObject1 = this.mActiveViews;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.setDrawingCacheBackgroundColor(paramInt);
        }
        i += 1;
      }
    }
    
    public void setViewTypeCount(int paramInt)
    {
      if (paramInt < 1) {
        throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
      }
      ArrayList[] arrayOfArrayList = new ArrayList[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        arrayOfArrayList[i] = new ArrayList();
        i += 1;
      }
      this.mViewTypeCount = paramInt;
      this.mCurrentScrap = arrayOfArrayList[0];
      this.mScrapViews = arrayOfArrayList;
    }
    
    public boolean shouldRecycleViewType(int paramInt)
    {
      return paramInt >= 0;
    }
  }
  
  public static abstract interface RecyclerListener
  {
    public abstract void onMovedToScrapHeap(View paramView);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new EcoGalleryAbsSpinner.SavedState.1();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.Gallery.EcoGalleryAbsSpinner
 * JD-Core Version:    0.7.0.1
 */