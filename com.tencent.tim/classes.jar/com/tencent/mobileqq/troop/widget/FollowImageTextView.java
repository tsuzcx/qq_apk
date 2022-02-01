package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FollowImageTextView
  extends LinearLayout
{
  private ImageView EL;
  private FirstTextView jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView;
  private b jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$b;
  private c jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$c;
  private TextView abi;
  private boolean cJG = true;
  private int dWT = 10;
  private LinearLayout kZ;
  private LinearLayout la;
  private int mMaxLines = 2147483647;
  private CharSequence mText = "";
  
  public FollowImageTextView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public FollowImageTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public FollowImageTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  @RequiresApi(api=21)
  public FollowImageTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext);
  }
  
  private void Sk(boolean paramBoolean)
  {
    int i = this.la.getVisibility();
    if (((paramBoolean) && (i == 0)) || ((!paramBoolean) && (i == 8))) {
      return;
    }
    if (paramBoolean)
    {
      this.la.setVisibility(0);
      this.kZ.removeView(this.EL);
      this.la.addView(this.EL);
      return;
    }
    this.la.setVisibility(8);
    this.la.removeView(this.EL);
    this.kZ.addView(this.EL);
  }
  
  private c a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$c == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$c = new c(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$c;
  }
  
  private void init(Context paramContext)
  {
    setOrientation(1);
    this.kZ = new LinearLayout(paramContext);
    this.kZ.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.kZ.setOrientation(0);
    addView(this.kZ);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView = new FirstTextView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setId(2131374464);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.kZ.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView);
    this.la = new LinearLayout(paramContext);
    this.la.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.la.setOrientation(0);
    this.la.setVisibility(8);
    addView(this.la);
    this.abi = new TextView(paramContext);
    this.abi.setId(2131374465);
    this.abi.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.abi.setSingleLine(true);
    this.abi.setEllipsize(TextUtils.TruncateAt.END);
    this.abi.setIncludeFontPadding(false);
    this.la.addView(this.abi);
    this.EL = new ImageView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    localLayoutParams.leftMargin = ((int)(paramContext.getResources().getDisplayMetrics().density * this.dWT + 0.5F));
    this.EL.setLayoutParams(localLayoutParams);
    this.EL.setVisibility(8);
    this.kZ.addView(this.EL);
  }
  
  private void setup()
  {
    boolean bool2 = this.cJG;
    boolean bool1;
    if (this.mMaxLines < 2)
    {
      bool1 = true;
      this.cJG = bool1;
      if (!this.cJG) {
        break label95;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setMaxLines(1);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setText(this.mText);
      if (((this.cJG ^ bool2)) && (this.cJG) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$b != null)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$b.Xc(1);
      }
      return;
      bool1 = false;
      break;
      label95:
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setMaxLines(this.mMaxLines - 1);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setEllipsize(null);
    }
  }
  
  public void setAllChildOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setOnClickListener(paramOnClickListener);
    this.abi.setOnClickListener(paramOnClickListener);
    this.EL.setOnClickListener(paramOnClickListener);
  }
  
  public void setAllChildOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setOnTouchListener(paramOnTouchListener);
    this.abi.setOnTouchListener(paramOnTouchListener);
    this.EL.setOnTouchListener(paramOnTouchListener);
  }
  
  public void setAllChildTag(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setTag(paramObject);
    this.abi.setTag(paramObject);
    this.EL.setTag(paramObject);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setContentDescription(paramCharSequence);
    this.abi.setContentDescription(paramCharSequence);
  }
  
  public void setFollowImageResource(int paramInt)
  {
    this.EL.setImageResource(paramInt);
  }
  
  public void setFollowImageVisibility(int paramInt)
  {
    this.EL.setVisibility(paramInt);
  }
  
  public void setFollowImageWH(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.EL.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    this.EL.setLayoutParams(localLayoutParams);
  }
  
  public void setMaxLines(int paramInt)
  {
    this.mMaxLines = paramInt;
    setup();
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setMaxWidth(paramInt);
    this.abi.setMaxWidth(paramInt);
  }
  
  public void setOnTextLineChangeListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$b = paramb;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (TextUtils.equals(this.mText, paramCharSequence)) {
      return;
    }
    this.mText = paramCharSequence;
    setup();
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setTextColor(paramInt);
    this.abi.setTextColor(paramInt);
  }
  
  public void setTextSize(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setTextSize(paramFloat);
    this.abi.setTextSize(paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView$FirstTextView.setTextSize(paramInt, paramFloat);
    this.abi.setTextSize(paramInt, paramFloat);
  }
  
  class FirstTextView
    extends TextView
  {
    public FirstTextView(Context paramContext)
    {
      super();
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      if (FollowImageTextView.a(FollowImageTextView.this))
      {
        super.onDraw(paramCanvas);
        return;
      }
      Object localObject = getPaint();
      ((TextPaint)localObject).setColor(getCurrentTextColor());
      ((TextPaint)localObject).drawableState = getDrawableState();
      localObject = FollowImageTextView.a(FollowImageTextView.this);
      ((FollowImageTextView.c)localObject).Xd(FollowImageTextView.a(FollowImageTextView.this) - 1);
      ((FollowImageTextView.c)localObject).draw(paramCanvas);
    }
  }
  
  static class a
  {
    int adh;
    int ahi;
    CharSequence text;
    int width;
  }
  
  public static abstract interface b
  {
    public abstract void Xc(int paramInt);
  }
  
  static class c
  {
    private List<FollowImageTextView.a> It = new ArrayList();
    private int aXy;
    private int ahe;
    private FollowImageTextView c;
    private int mLeftPadding;
    private int mLineHeight;
    private int mMaxLines;
    private TextPaint mPaint;
    private int mRightPadding;
    private CharSequence mText;
    private int mTopPadding;
    
    public c(FollowImageTextView paramFollowImageTextView)
    {
      this.c = paramFollowImageTextView;
    }
    
    private int c(CharSequence paramCharSequence)
    {
      return (int)this.mPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
    }
    
    private void ecb()
    {
      this.It.clear();
      int n = getContentWidth();
      if (n <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FollowImageTextView", 2, "lineWidth=" + n);
        }
        return;
      }
      int i1 = this.mText.length();
      int j = 0;
      int k = 0;
      int i = 0;
      label70:
      FollowImageTextView.a locala;
      if (j < i1) {
        if (this.mText.charAt(j) == '\n')
        {
          locala = new FollowImageTextView.a(null);
          locala.ahi = i;
          locala.adh = (j - 1);
          locala.width = k;
          locala.text = this.mText.subSequence(i, j);
          this.It.add(locala);
          i = j + 1;
          k = 0;
        }
      }
      for (;;)
      {
        j += 1;
        break label70;
        int m = c(this.mText.subSequence(i, j + 1));
        if (m > n)
        {
          locala = new FollowImageTextView.a(null);
          locala.ahi = i;
          locala.adh = (j - 1);
          locala.width = k;
          locala.text = this.mText.subSequence(i, j);
          this.It.add(locala);
          if (this.It.size() >= i1)
          {
            if (FollowImageTextView.a(this.c) == null) {
              break;
            }
            FollowImageTextView.a(this.c).Xc(this.It.size());
            return;
          }
          i = j;
          j -= 1;
          k = 0;
          continue;
        }
        if (j == i1 - 1)
        {
          locala = new FollowImageTextView.a(null);
          locala.ahi = i;
          locala.adh = (j - 1);
          locala.width = m;
          locala.text = this.mText.subSequence(i, i1);
          this.It.add(locala);
        }
        else
        {
          k = m;
        }
      }
    }
    
    private int getContentWidth()
    {
      return this.ahe - this.mRightPadding - this.mLeftPadding;
    }
    
    public void Xd(int paramInt)
    {
      FollowImageTextView.FirstTextView localFirstTextView = FollowImageTextView.a(this.c);
      this.mText = localFirstTextView.getText();
      this.mPaint = localFirstTextView.getPaint();
      this.ahe = localFirstTextView.getMeasuredWidth();
      this.mLineHeight = localFirstTextView.getLineHeight();
      this.mLeftPadding = localFirstTextView.getPaddingLeft();
      this.mTopPadding = localFirstTextView.getPaddingTop();
      this.mRightPadding = localFirstTextView.getPaddingRight();
      this.aXy = localFirstTextView.getPaddingBottom();
      this.mMaxLines = paramInt;
      ecb();
    }
    
    public void draw(Canvas paramCanvas)
    {
      int j = this.It.size();
      int i;
      if ((this.mMaxLines > 0) && (this.mMaxLines < j))
      {
        i = 1;
        if (i == 0) {
          break label260;
        }
        j = this.mMaxLines;
      }
      label260:
      for (;;)
      {
        int k = 0;
        for (;;)
        {
          if (k < j)
          {
            CharSequence localCharSequence = ((FollowImageTextView.a)this.It.get(k)).text;
            float f1 = this.mPaint.getTextSize();
            int m = localCharSequence.length();
            float f2 = this.mLeftPadding + 0;
            float f3 = this.mLineHeight * k;
            paramCanvas.drawText(localCharSequence, 0, m, f2, this.mTopPadding + (f1 + f3), this.mPaint);
            k += 1;
            continue;
            i = 0;
            break;
          }
        }
        if ((i != 0) && (j < this.It.size()))
        {
          paramCanvas = (FollowImageTextView.a)this.It.get(j);
          i = this.mText.length();
          if ((paramCanvas.ahi > -1) && (paramCanvas.ahi < i))
          {
            paramCanvas = this.mText.subSequence(paramCanvas.ahi, i);
            FollowImageTextView.a(this.c).setText(paramCanvas);
            FollowImageTextView.a(this.c, true);
            return;
          }
          FollowImageTextView.a(this.c, false);
          return;
        }
        FollowImageTextView.a(this.c, false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FollowImageTextView
 * JD-Core Version:    0.7.0.1
 */