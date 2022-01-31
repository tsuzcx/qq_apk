package android.support.v7.internal.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;
import com.tencent.mobileqqi.R.styleable;

class SpinnerICS
  extends AbsSpinnerICS
  implements DialogInterface.OnClickListener
{
  private static final int MAX_ITEMS_MEASURED = 15;
  static final int MODE_DIALOG = 0;
  static final int MODE_DROPDOWN = 1;
  private static final int MODE_THEME = -1;
  private static final String TAG = "Spinner";
  int mDropDownWidth;
  private int mGravity;
  private SpinnerICS.SpinnerPopup mPopup;
  private SpinnerICS.DropDownAdapter mTempAdapter;
  private Rect mTempRect = new Rect();
  
  SpinnerICS(Context paramContext)
  {
    this(paramContext, null);
  }
  
  SpinnerICS(Context paramContext, int paramInt)
  {
    this(paramContext, null, 2130772055, paramInt);
  }
  
  SpinnerICS(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772055);
  }
  
  SpinnerICS(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  SpinnerICS(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Z, paramInt1, 0);
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = localTypedArray.getInt(7, 0);
    }
    switch (i)
    {
    }
    for (;;)
    {
      this.mGravity = localTypedArray.getInt(0, 17);
      this.mPopup.setPromptText(localTypedArray.getString(6));
      localTypedArray.recycle();
      if (this.mTempAdapter != null)
      {
        this.mPopup.setAdapter(this.mTempAdapter);
        this.mTempAdapter = null;
      }
      return;
      this.mPopup = new SpinnerICS.DialogPopup(this, null);
      continue;
      paramContext = new SpinnerICS.DropdownPopup(this, paramContext, paramAttributeSet, paramInt1);
      this.mDropDownWidth = localTypedArray.getLayoutDimension(3, -2);
      paramContext.setBackgroundDrawable(localTypedArray.getDrawable(2));
      paramInt1 = localTypedArray.getDimensionPixelOffset(5, 0);
      if (paramInt1 != 0) {
        paramContext.setVerticalOffset(paramInt1);
      }
      paramInt1 = localTypedArray.getDimensionPixelOffset(4, 0);
      if (paramInt1 != 0) {
        paramContext.setHorizontalOffset(paramInt1);
      }
      this.mPopup = paramContext;
    }
  }
  
  private View makeAndAddView(int paramInt)
  {
    if (!this.mDataChanged)
    {
      localView = this.mRecycler.get(paramInt);
      if (localView != null)
      {
        setUpChild(localView);
        return localView;
      }
    }
    View localView = this.mAdapter.getView(paramInt, null, this);
    setUpChild(localView);
    return localView;
  }
  
  private void setUpChild(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = generateDefaultLayoutParams();
    }
    addViewInLayout(paramView, 0, localLayoutParams1);
    paramView.setSelected(hasFocus());
    int i = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, localLayoutParams1.height);
    paramView.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, localLayoutParams1.width), i);
    i = this.mSpinnerPadding.top + (getMeasuredHeight() - this.mSpinnerPadding.bottom - this.mSpinnerPadding.top - paramView.getMeasuredHeight()) / 2;
    int j = paramView.getMeasuredHeight();
    paramView.layout(0, i, paramView.getMeasuredWidth() + 0, j + i);
  }
  
  public int getBaseline()
  {
    int j = -1;
    Object localObject2 = null;
    Object localObject1;
    if (getChildCount() > 0) {
      localObject1 = getChildAt(0);
    }
    for (;;)
    {
      int i = j;
      if (localObject1 != null)
      {
        int k = ((View)localObject1).getBaseline();
        i = j;
        if (k >= 0) {
          i = ((View)localObject1).getTop() + k;
        }
      }
      return i;
      localObject1 = localObject2;
      if (this.mAdapter != null)
      {
        localObject1 = localObject2;
        if (this.mAdapter.getCount() > 0)
        {
          localObject1 = makeAndAddView(0);
          this.mRecycler.put(0, (View)localObject1);
          removeAllViewsInLayout();
        }
      }
    }
  }
  
  public CharSequence getPrompt()
  {
    return this.mPopup.getHintText();
  }
  
  void layout(int paramInt, boolean paramBoolean)
  {
    paramInt = this.mSpinnerPadding.left;
    int i = getRight() - getLeft() - this.mSpinnerPadding.left - this.mSpinnerPadding.right;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0)
    {
      resetList();
      return;
    }
    if (this.mNextSelectedPosition >= 0) {
      setSelectedPositionInt(this.mNextSelectedPosition);
    }
    recycleAllViews();
    removeAllViewsInLayout();
    this.mFirstPosition = this.mSelectedPosition;
    View localView = makeAndAddView(this.mSelectedPosition);
    int j = localView.getMeasuredWidth();
    switch (this.mGravity & 0x7)
    {
    }
    for (;;)
    {
      localView.offsetLeftAndRight(paramInt);
      this.mRecycler.clear();
      invalidate();
      checkSelectionChanged();
      this.mDataChanged = false;
      this.mNeedSync = false;
      setNextSelectedPositionInt(this.mSelectedPosition);
      return;
      paramInt = paramInt + i / 2 - j / 2;
      continue;
      paramInt = paramInt + i - j;
    }
  }
  
  int measureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i = Math.max(0, getSelectedItemPosition());
    int i2 = Math.min(paramSpinnerAdapter.getCount(), i + 15);
    int j = Math.max(0, i - (15 - (i2 - i)));
    View localView = null;
    int k = 0;
    i = 0;
    if (j < i2)
    {
      int m = paramSpinnerAdapter.getItemViewType(j);
      if (m == i) {
        break label198;
      }
      localView = null;
      i = m;
    }
    label198:
    for (;;)
    {
      localView = paramSpinnerAdapter.getView(j, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.mTempRect);
        return this.mTempRect.left + this.mTempRect.right + k;
      }
      return k;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    setSelection(paramInt);
    paramDialogInterface.dismiss();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mPopup != null) && (this.mPopup.isShowing())) {
      this.mPopup.dismiss();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mInLayout = true;
    layout(0, false);
    this.mInLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean performClick()
  {
    boolean bool2 = super.performClick();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool2 = true;
      bool1 = bool2;
      if (!this.mPopup.isShowing())
      {
        this.mPopup.show();
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    super.setAdapter(paramSpinnerAdapter);
    if (this.mPopup != null)
    {
      this.mPopup.setAdapter(new SpinnerICS.DropDownAdapter(paramSpinnerAdapter));
      return;
    }
    this.mTempAdapter = new SpinnerICS.DropDownAdapter(paramSpinnerAdapter);
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      int i = paramInt;
      if ((paramInt & 0x7) == 0) {
        i = paramInt | 0x3;
      }
      this.mGravity = i;
      requestLayout();
    }
  }
  
  public void setOnItemClickListener(AdapterViewICS.OnItemClickListener paramOnItemClickListener)
  {
    throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
  }
  
  void setOnItemClickListenerInt(AdapterViewICS.OnItemClickListener paramOnItemClickListener)
  {
    super.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    this.mPopup.setPromptText(paramCharSequence);
  }
  
  public void setPromptId(int paramInt)
  {
    setPrompt(getContext().getText(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerICS
 * JD-Core Version:    0.7.0.1
 */