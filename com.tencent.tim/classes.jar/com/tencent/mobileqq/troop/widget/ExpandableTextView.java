package com.tencent.mobileqq.troop.widget;

import acfp;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import atau.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ExpandableTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private static float Av = 0.7F;
  private float Aw;
  private a jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$a;
  private b jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$b;
  protected TextView abg;
  protected TextView abh;
  private boolean cSw = true;
  private String crD;
  private String crE;
  private int dWP;
  private int dWQ;
  private int dWR;
  private int dWS;
  private boolean mAnimating;
  private int mAnimationDuration;
  private int mPosition;
  private boolean mRelayout;
  private SparseBooleanArray p;
  private CharSequence s;
  
  public ExpandableTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  @TargetApi(11)
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private void aDR()
  {
    this.abg = ((TextView)findViewById(2131366580));
    this.abg.setEllipsize(TextUtils.TruncateAt.END);
    this.abh = ((TextView)findViewById(2131366575));
    TextView localTextView = this.abh;
    if (this.cSw) {}
    for (String str = this.crD;; str = this.crE)
    {
      localTextView.setText(str);
      this.abh.setOnClickListener(this);
      return;
    }
  }
  
  private int b(TextView paramTextView)
  {
    return paramTextView.getLayout().getLineTop(paramTextView.getLineCount()) + (paramTextView.getCompoundPaddingTop() + paramTextView.getCompoundPaddingBottom());
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.qn);
    this.dWR = paramAttributeSet.getInt(4, 7);
    this.mAnimationDuration = paramAttributeSet.getInt(1, 400);
    this.Aw = paramAttributeSet.getFloat(0, Av);
    this.crD = paramAttributeSet.getString(3);
    this.crE = paramAttributeSet.getString(2);
    if (TextUtils.isEmpty(this.crD)) {
      this.crD = acfp.m(2131705971);
    }
    if (TextUtils.isEmpty(this.crE)) {
      this.crE = "";
    }
    paramAttributeSet.recycle();
    setOrientation(1);
    setVisibility(8);
  }
  
  public TextView ab()
  {
    return this.abg;
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    if (this.abh.getVisibility() != 0) {}
    label29:
    label52:
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.cSw) {
        break;
      }
      bool1 = true;
      this.cSw = bool1;
      if (!this.cSw) {
        break label128;
      }
      this.abh.setText(this.crD);
      if (this.p != null) {
        this.p.put(this.mPosition, this.cSw);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$a == null);
    a locala = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$a;
    TextView localTextView1 = this.abg;
    TextView localTextView2 = this.abh;
    if (!this.cSw) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.a(localTextView1, localTextView2, bool1);
      break;
      bool1 = false;
      break label29;
      label128:
      this.abh.setText(this.crE);
      if (this.abg.getText().equals(this.s)) {
        break label52;
      }
      this.abg.setText(this.s);
      break label52;
    }
  }
  
  @SuppressLint({"MissingSuperCall"})
  protected void onFinishInflate()
  {
    aDR();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mAnimating;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((!this.mRelayout) || (getVisibility() == 8)) {
      super.onMeasure(paramInt1, paramInt2);
    }
    do
    {
      do
      {
        return;
        this.mRelayout = false;
        this.abh.setVisibility(8);
        this.abg.setMaxLines(2147483647);
        super.onMeasure(paramInt1, paramInt2);
      } while (this.abg.getLineCount() <= this.dWR);
      this.dWQ = b(this.abg);
      if (this.cSw)
      {
        this.abg.setMaxLines(this.dWR);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$b == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$b = new b(this.abg, this.dWR);
        }
        this.abg.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$b);
      }
      this.abh.setVisibility(0);
      super.onMeasure(paramInt1, paramInt2);
    } while (!this.cSw);
    this.abg.post(new ExpandableTextView.1(this));
    this.dWP = getMeasuredHeight();
  }
  
  public void setOnExpandStateChangeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$a = parama;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
    }
    super.setOrientation(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.mRelayout = true;
    this.s = paramCharSequence;
    this.abg.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      return;
    }
  }
  
  public void setText(CharSequence paramCharSequence, SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    this.p = paramSparseBooleanArray;
    this.mPosition = paramInt;
    boolean bool = paramSparseBooleanArray.get(paramInt, true);
    clearAnimation();
    this.cSw = bool;
    TextView localTextView = this.abh;
    if (this.cSw) {}
    for (paramSparseBooleanArray = this.crD;; paramSparseBooleanArray = this.crE)
    {
      localTextView.setText(paramSparseBooleanArray);
      setText(paramCharSequence);
      getLayoutParams().height = -2;
      requestLayout();
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(TextView paramTextView, View paramView, boolean paramBoolean);
  }
  
  public static class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private int mMaxLines;
    private TextView mTextView;
    
    public b(TextView paramTextView, int paramInt)
    {
      this.mTextView = paramTextView;
      this.mMaxLines = paramInt;
      this.mTextView.setMaxLines(this.mMaxLines + 1);
      this.mTextView.setSingleLine(false);
    }
    
    public void onGlobalLayout()
    {
      int i;
      String str;
      CharSequence localCharSequence1;
      if (this.mTextView.getLineCount() > this.mMaxLines)
      {
        i = this.mTextView.getLayout().getLineEnd(this.mMaxLines - 1);
        str = "...";
        localCharSequence1 = this.mTextView.getText();
      }
      try
      {
        localCharSequence1 = localCharSequence1.subSequence(0, i - 3);
        this.mTextView.setText(localCharSequence1);
        this.mTextView.append(str);
        this.mTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          str = "";
          CharSequence localCharSequence2 = this.mTextView.getText();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ExpandableTextView
 * JD-Core Version:    0.7.0.1
 */