package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import atau.a;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import pey;

public class QCircleExpandableTextView
  extends LinearLayout
{
  public b a;
  AsyncRichTextView a;
  public boolean apU = false;
  public String asG;
  public String asH;
  boolean azN = false;
  public boolean azO = true;
  int bih = 0;
  public int bii = 0;
  public int bij = 0;
  int duration = 0;
  public int lastHeight = 0;
  public TextView wn;
  
  public QCircleExpandableTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleExpandableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleExpandableTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private int a(TextView paramTextView)
  {
    return paramTextView.getLayout().getLineTop(paramTextView.getLineCount()) + paramTextView.getCompoundPaddingBottom() + paramTextView.getCompoundPaddingTop();
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    setOrientation(1);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qo);
    this.bih = paramContext.getInteger(2, 3);
    this.duration = paramContext.getInteger(0, 250);
    this.asG = paramContext.getString(1);
    this.asH = paramContext.getString(3);
    paramContext.recycle();
  }
  
  public boolean isCollapsed()
  {
    return this.azO;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() < 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)getChildAt(0));
    this.wn = ((TextView)getChildAt(1));
    this.wn.setText(this.asH);
    this.wn.setOnClickListener(new pey(this));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.apU;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((getVisibility() == 8) || (!this.azN)) {
      super.onMeasure(paramInt1, paramInt2);
    }
    do
    {
      do
      {
        return;
        this.azN = false;
        this.wn.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setMaxLines(2147483647);
        super.onMeasure(paramInt1, paramInt2);
      } while (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.getLineCount() <= this.bih);
      this.bii = a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView);
      if (this.azO) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setMaxLines(this.bih);
      }
      this.wn.setVisibility(0);
      super.onMeasure(paramInt1, paramInt2);
    } while (!this.azO);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.post(new QCircleExpandableTextView.2(this));
  }
  
  public void setListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView$b = paramb;
  }
  
  public void setText(String paramString)
  {
    this.azN = true;
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramString);
  }
  
  public void setText(String paramString, boolean paramBoolean)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      this.azO = bool;
      if (!this.azO) {
        break label70;
      }
      this.wn.setText(this.asH);
    }
    for (;;)
    {
      clearAnimation();
      setText(paramString);
      getLayoutParams().height = -2;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView$b != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView$b.ro(paramBoolean);
      }
      return;
      bool = false;
      break;
      label70:
      this.wn.setText(this.asG);
    }
  }
  
  public TextView w()
  {
    return this.wn;
  }
  
  public TextView x()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  }
  
  public class a
    extends Animation
  {
    int bik = 0;
    int bil = 0;
    
    private a(int paramInt1, int paramInt2)
    {
      setDuration(QCircleExpandableTextView.this.duration);
      this.bik = paramInt1;
      this.bil = paramInt2;
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      super.applyTransformation(paramFloat, paramTransformation);
      int i = (int)((this.bil - this.bik) * paramFloat + this.bik);
      QCircleExpandableTextView.this.a.setMaxHeight(i - QCircleExpandableTextView.this.lastHeight);
      QCircleExpandableTextView.this.getLayoutParams().height = i;
      QCircleExpandableTextView.this.requestLayout();
    }
    
    public boolean willChangeBounds()
    {
      return true;
    }
  }
  
  public static abstract interface b
  {
    public abstract void ro(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView
 * JD-Core Version:    0.7.0.1
 */