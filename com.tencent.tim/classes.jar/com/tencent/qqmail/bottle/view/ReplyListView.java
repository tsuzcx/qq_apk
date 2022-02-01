package com.tencent.qqmail.bottle.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.InsertionListView;
import java.lang.reflect.Field;

public class ReplyListView
  extends InsertionListView
{
  private static final int MIN_HEIGHT = 1;
  private static final int STATUS_ANIMATING = 3;
  private static final int STATUS_EDITING = 4;
  private static final int STATUS_INIT = 0;
  private static final int STATUS_RELEASE_TO_ACTION = 2;
  private static final int STATUS_RELEASE_TO_FOLD = 1;
  private static final String TAG = ReplyListView.class.getSimpleName();
  private boolean loadOnce = false;
  private int mAlbePullOffsetLandscape;
  private ImageView mDescriptionArrow;
  private View mDescriptionContainer;
  private TextView mDescriptionText;
  private View mDescriptionView;
  private View mDivider;
  private EditText mEditText;
  private View mEditTextContainer;
  private View mHeaderView;
  private AbsListView.LayoutParams mHeaderViewParams;
  private boolean mHeaderViewVisibility;
  private boolean mIsPullEnabled = true;
  private boolean mIsTouchMoving = false;
  private TextView mNotifyCountView;
  private OnEditListener mOnEditListener;
  private OnExpandCompleteListener mOnExpandCompleteListener;
  private OnFoldCompleteListener mOnFoldCompleteListener;
  private OnTextChangeWatcher mOnTextChangeWatcher;
  private float mStartDownX;
  private float mStartDownY;
  private float mStartY = -1.0F;
  private int mStatus = 0;
  private final TextWatcher mTextWatcher = new ReplyListView.1(this);
  private int mWillSetCurrentHeight = 1;
  private onResizeListener resizeListener;
  
  public ReplyListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReplyListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ReplyListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void animateHeader(int paramInt, boolean paramBoolean)
  {
    if (this.mOnEditListener == null) {
      return;
    }
    this.mStatus = 3;
    int i = getHeaderViewHeight();
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = true;
    ReplyListView.2 local2 = new ReplyListView.2(this, arrayOfBoolean, paramInt, i);
    local2.setInterpolator(new AccelerateDecelerateInterpolator());
    local2.setAnimationListener(new ReplyListView.3(this, paramBoolean, arrayOfBoolean));
    local2.setDuration('È');
    this.mHeaderView.startAnimation(local2);
  }
  
  private void animationPullArrow(boolean paramBoolean)
  {
    float f2 = 180.0F;
    float f1;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label73;
      }
    }
    for (;;)
    {
      RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
      localRotateAnimation.setDuration('È');
      localRotateAnimation.setFillAfter(true);
      this.mDescriptionArrow.startAnimation(localRotateAnimation);
      return;
      f1 = 180.0F;
      break;
      label73:
      f2 = 0.0F;
    }
  }
  
  private boolean canPulled()
  {
    boolean bool = true;
    if (getResources().getConfiguration().orientation == 2) {
      return this.mHeaderViewParams.height > 10;
    }
    if (this.mAlbePullOffsetLandscape == 0)
    {
      Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplay.getMetrics(localDisplayMetrics);
      this.mAlbePullOffsetLandscape = ((localDisplayMetrics.heightPixels - getResources().getDimensionPixelSize(2131299664) - getResources().getDimensionPixelSize(2131297365)) / 5);
    }
    Log.v(TAG, "topMargin=" + this.mHeaderViewParams.height + " mAlbePullOffsetLandscape=" + this.mAlbePullOffsetLandscape);
    if (this.mHeaderViewParams.height > this.mAlbePullOffsetLandscape) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void cancelPressed(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null)
    {
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
    }
    int j = getHeaderViewsCount();
    int i = getFirstVisiblePosition();
    while (i < getLastVisiblePosition())
    {
      paramMotionEvent = getChildAt(i + j);
      if (paramMotionEvent != null)
      {
        paramMotionEvent.setPressed(false);
        paramMotionEvent.setSelected(false);
      }
      i += 1;
    }
    try
    {
      paramMotionEvent = AbsListView.class.getDeclaredField("mMotionPosition");
      paramMotionEvent.setAccessible(true);
      paramMotionEvent.set(this, Integer.valueOf(-1));
      return;
    }
    catch (Exception paramMotionEvent)
    {
      QMLog.log(6, "mMotionPosition:", paramMotionEvent.toString());
    }
  }
  
  private void drawDescriptionText(boolean paramBoolean)
  {
    TextView localTextView = this.mDescriptionText;
    if (paramBoolean) {}
    for (int i = 2131718734;; i = 2131697499)
    {
      localTextView.setText(i);
      return;
    }
  }
  
  private void drawDescriptionView()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mDescriptionView.getLayoutParams();
    localLayoutParams.topMargin = (this.mHeaderViewParams.height - 60);
    this.mDescriptionView.setLayoutParams(localLayoutParams);
  }
  
  private int getHeaderViewHeight()
  {
    if (this.mHeaderViewParams.height == -2) {
      return this.mHeaderView.getMeasuredHeight();
    }
    return this.mHeaderViewParams.height;
  }
  
  private void init()
  {
    setVerticalFadingEdgeEnabled(false);
    setDividerHeight(0);
    this.mHeaderView = LayoutInflater.from(getContext()).inflate(2131558780, null);
    super.addHeaderView(this.mHeaderView);
    this.mEditTextContainer = this.mHeaderView.findViewById(2131377144);
    this.mEditText = ((EditText)this.mHeaderView.findViewById(2131377143));
    this.mEditText.addTextChangedListener(this.mTextWatcher);
    this.mDescriptionView = this.mHeaderView.findViewById(2131377142);
    this.mDescriptionContainer = this.mHeaderView.findViewById(2131377140);
    this.mDescriptionText = ((TextView)this.mHeaderView.findViewById(2131377141));
    this.mDescriptionArrow = ((ImageView)this.mHeaderView.findViewById(2131373840));
    this.mDivider = this.mHeaderView.findViewById(2131373857);
    this.mNotifyCountView = ((TextView)this.mHeaderView.findViewById(2131377152));
  }
  
  private int measureEditTextHeight()
  {
    this.mEditText.measure(0, 0);
    int i = this.mEditText.getMeasuredHeight();
    Log.v(TAG, "measureEditTextHeight: " + i);
    return i;
  }
  
  private void setHeaderViewHeight(int paramInt)
  {
    if (this.mHeaderViewParams != null)
    {
      AbsListView.LayoutParams localLayoutParams = this.mHeaderViewParams;
      if (paramInt != -2) {
        break label66;
      }
      localLayoutParams.height = paramInt;
      this.mHeaderView.setLayoutParams(this.mHeaderViewParams);
      if (this.mHeaderViewParams.height != 1) {
        break label75;
      }
      if (this.mHeaderViewVisibility)
      {
        this.mHeaderView.setVisibility(4);
        this.mHeaderViewVisibility = false;
      }
    }
    label66:
    label75:
    while (this.mHeaderViewVisibility)
    {
      return;
      paramInt = Math.max(1, paramInt);
      break;
    }
    this.mHeaderView.setVisibility(0);
    this.mHeaderViewVisibility = true;
  }
  
  private void showEditText(boolean paramBoolean)
  {
    int j = 0;
    Object localObject = this.mDescriptionContainer;
    if (paramBoolean)
    {
      i = 8;
      ((View)localObject).setVisibility(i);
      localObject = this.mEditTextContainer;
      if (!paramBoolean) {
        break label83;
      }
      i = 0;
      label33:
      ((View)localObject).setVisibility(i);
      localObject = this.mEditText;
      if (!paramBoolean) {
        break label89;
      }
    }
    label83:
    label89:
    for (int i = j;; i = 8)
    {
      ((EditText)localObject).setVisibility(i);
      if ((paramBoolean) && (this.mOnEditListener != null)) {
        this.mOnEditListener.onEdit();
      }
      return;
      i = 0;
      break;
      i = 8;
      break label33;
    }
  }
  
  public void clearEditFocus()
  {
    this.mEditText.clearFocus();
    if (this.mEditText.isFocused())
    {
      this.mEditText.setFocusable(false);
      this.mEditText.setFocusable(true);
      this.mEditText.setFocusableInTouchMode(true);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (IndexOutOfBoundsException paramCanvas) {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((this.mOnEditListener == null) || (this.mHeaderView == null) || (!this.mIsPullEnabled) || (this.mStatus == 3) || (this.mStatus == 4)) {
      try
      {
        bool1 = super.dispatchTouchEvent(paramMotionEvent);
        return bool1;
      }
      catch (Throwable paramMotionEvent)
      {
        return false;
      }
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        try
        {
          bool2 = super.dispatchTouchEvent(paramMotionEvent);
          bool1 = bool2;
        }
        catch (Exception paramMotionEvent)
        {
          int i;
          float f;
          QMLog.log(6, TAG, "dispatchTouchEvent exception : " + paramMotionEvent.getMessage());
          continue;
        }
        return bool1;
        if ((getFirstVisiblePosition() == 0) && ((getChildAt(0) == null) || (getChildAt(0).getTop() == 0)))
        {
          i = 1;
          if (Math.abs(paramMotionEvent.getRawX() - this.mStartDownX) > 200.0F)
          {
            QMLog.log(2, TAG, "PtrListView LR_move:" + (int)(paramMotionEvent.getRawX() - this.mStartDownX));
            cancelPressed(null);
          }
          if ((this.mStatus != 1) && (this.mStatus != 2) && ((i == 0) || ((int)(paramMotionEvent.getRawY() - this.mStartDownY) <= 15))) {
            continue;
          }
          if ((this.mStatus != 1) && (this.mStatus != 2)) {
            QMLog.log(2, TAG, "ReplyListView move:" + (int)(paramMotionEvent.getRawY() - this.mStartDownY));
          }
          if (this.mStartY == -1.0F)
          {
            this.mStartY = paramMotionEvent.getRawY();
            cancelPressed(paramMotionEvent);
          }
          f = (paramMotionEvent.getRawY() - this.mStartY) * 0.33F;
          setHeaderViewHeight((int)f);
          drawDescriptionView();
          if (f <= 0.0F) {
            continue;
          }
          if (!canPulled()) {
            continue;
          }
          bool1 = bool2;
          if (this.mStatus == 2) {
            break;
          }
          this.mStatus = 2;
          drawDescriptionText(true);
          animationPullArrow(true);
          return true;
        }
        i = 0;
        continue;
        bool1 = bool2;
        if (this.mStatus == 1) {
          break;
        }
        this.mStatus = 1;
        drawDescriptionText(false);
        animationPullArrow(false);
        return true;
        if (this.mStatus != 0)
        {
          this.mStatus = 0;
          showEditText(false);
          continue;
          this.mIsTouchMoving = true;
          this.mStartDownX = paramMotionEvent.getRawX();
          this.mStartDownY = paramMotionEvent.getRawY();
          this.mStartY = -1.0F;
          showEditText(false);
        }
      }
      this.mIsTouchMoving = false;
      this.mStartY = -1.0F;
    } while ((this.mStatus != 1) && (this.mStatus != 2));
    if (this.mStatus == 2)
    {
      showEditText(true);
      animateHeader(measureEditTextHeight(), true);
    }
    for (;;)
    {
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
      animateHeader(0, false);
    }
  }
  
  public void enableToPull(boolean paramBoolean)
  {
    this.mIsPullEnabled = paramBoolean;
  }
  
  public void expand()
  {
    if (this.mStatus == 0)
    {
      showEditText(true);
      animateHeader(measureEditTextHeight(), true);
    }
  }
  
  public void expandWithoutAnimation()
  {
    if (this.mStatus == 0)
    {
      showEditText(true);
      this.mStatus = 4;
      if (this.mOnExpandCompleteListener != null) {
        this.mOnExpandCompleteListener.onExpandComplete();
      }
      this.mWillSetCurrentHeight = -2;
      setHeaderViewHeight(-2);
    }
  }
  
  public void fold()
  {
    if (this.mStatus == 4)
    {
      KeyBoardHelper.hideKeyBoard(this.mEditText);
      animateHeader(0, false);
    }
  }
  
  public void foldWithoutAnimation()
  {
    if (this.mStatus == 4)
    {
      KeyBoardHelper.hideKeyBoard(this.mEditText);
      this.mWillSetCurrentHeight = 1;
      setHeaderViewHeight(1);
    }
  }
  
  public String getEditTextContent()
  {
    return this.mEditText.getText().toString();
  }
  
  public void hideSoftInput()
  {
    if ((this.mStatus == 4) && (this.mEditText.getVisibility() == 0)) {
      KeyBoardHelper.hideKeyBoard(this.mEditText);
    }
  }
  
  public boolean isEditFocus()
  {
    return this.mEditText.isFocused();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((!this.loadOnce) && (this.mHeaderView != null))
    {
      this.loadOnce = true;
      this.mHeaderViewParams = ((AbsListView.LayoutParams)this.mHeaderView.getLayoutParams());
      setHeaderViewHeight(this.mWillSetCurrentHeight);
      clearEditFocus();
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mIsTouchMoving)
    {
      super.onOverScrolled(0, 0, false, false);
      return;
    }
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.resizeListener != null) {
      this.resizeListener.onSizeChange(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void requestEditFocus()
  {
    this.mEditText.requestFocus();
  }
  
  public void reset()
  {
    if (this.mStatus != 0)
    {
      if (this.mHeaderView != null) {
        this.mHeaderView.clearAnimation();
      }
      this.mStatus = 0;
    }
    if ((this.mHeaderView != null) && (this.mHeaderViewParams != null)) {
      setHeaderViewHeight(1);
    }
  }
  
  public void setEditOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mEditText.setOnFocusChangeListener(paramOnFocusChangeListener);
  }
  
  public void setEditOnKeyListener(View.OnKeyListener paramOnKeyListener)
  {
    this.mEditText.setOnKeyListener(paramOnKeyListener);
  }
  
  public void setEditTextContent(CharSequence paramCharSequence)
  {
    this.mEditText.setText(paramCharSequence);
    if (paramCharSequence != null) {
      this.mEditText.setSelection(paramCharSequence.length());
    }
  }
  
  public void setEditTextHint(String paramString)
  {
    this.mEditText.setHint(paramString);
  }
  
  public void setEditTextMinHeight(int paramInt)
  {
    int i = this.mEditText.getLineHeight();
    int j = this.mEditText.getLineCount();
    int k = this.mEditText.getPaddingTop();
    int m = this.mEditText.getPaddingBottom();
    this.mEditText.setMinHeight(Math.max(i * (j + 1) + k + m, paramInt));
  }
  
  public void setEditTextMinLines(int paramInt)
  {
    this.mEditText.setMinLines(paramInt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.mIsPullEnabled = paramBoolean;
  }
  
  public void setOnEditListener(OnEditListener paramOnEditListener)
  {
    this.mOnEditListener = paramOnEditListener;
  }
  
  public void setOnExpandCompleteListener(OnExpandCompleteListener paramOnExpandCompleteListener)
  {
    this.mOnExpandCompleteListener = paramOnExpandCompleteListener;
  }
  
  public void setOnFoldCompleteListener(OnFoldCompleteListener paramOnFoldCompleteListener)
  {
    this.mOnFoldCompleteListener = paramOnFoldCompleteListener;
  }
  
  public void setOnResizeListener(onResizeListener paramonResizeListener)
  {
    this.resizeListener = paramonResizeListener;
  }
  
  public void setOnTextChangeWatcher(OnTextChangeWatcher paramOnTextChangeWatcher)
  {
    this.mOnTextChangeWatcher = paramOnTextChangeWatcher;
  }
  
  public void showDivider(boolean paramBoolean)
  {
    View localView = this.mDivider;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void showSoftInput()
  {
    if ((this.mStatus == 4) && (this.mEditText.getVisibility() == 0))
    {
      KeyBoardHelper.showKeyBoard(this.mEditText, 1);
      KeyBoardHelper.showSoftInputDelay(this.mEditText, 300L);
    }
  }
  
  public static abstract interface OnEditListener
  {
    public abstract void onEdit();
  }
  
  public static abstract interface OnExpandCompleteListener
  {
    public abstract void onExpandComplete();
  }
  
  public static abstract interface OnFoldCompleteListener
  {
    public abstract void onFoldComplete();
  }
  
  public static abstract interface OnTextChangeWatcher
  {
    public abstract void onEmpty();
    
    public abstract void onHasContent();
    
    public abstract void onOverContent();
  }
  
  public static abstract interface onResizeListener
  {
    public abstract void onSizeChange(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.ReplyListView
 * JD-Core Version:    0.7.0.1
 */