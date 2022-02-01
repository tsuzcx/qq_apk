package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import atau.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinIgnoreTypeface;
import java.util.ArrayList;

public class EllipsizingTextView
  extends TextView
  implements ISkinIgnoreTypeface
{
  private a a;
  private boolean cSt;
  private boolean cSu;
  private boolean cSv;
  private int dWM;
  private int mMaxLines = 1;
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qk);
      int i = 0;
      int j = paramContext.getIndexCount();
      if (i < j)
      {
        int k = paramContext.getIndex(i);
        switch (k)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          this.dWM = paramContext.getDimensionPixelOffset(k, this.dWM);
          continue;
          this.mMaxLines = paramContext.getInt(k, this.mMaxLines);
          continue;
          this.cSt = paramContext.getBoolean(k, this.cSt);
        }
      }
      paramContext.recycle();
    }
    setTypeface(null);
  }
  
  private a a()
  {
    if (this.a == null) {
      this.a = new a();
    }
    return this.a;
  }
  
  public void eca()
  {
    this.cSv = true;
  }
  
  public int getLineCount()
  {
    return a().getLineCount();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getPaint();
    ((TextPaint)localObject).setColor(getCurrentTextColor());
    ((TextPaint)localObject).drawableState = getDrawableState();
    localObject = a();
    ((a)localObject).a(getText(), this, this.mMaxLines, this.dWM, this.cSt);
    if (getEllipsize() == TextUtils.TruncateAt.END)
    {
      ((a)localObject).a(paramCanvas, TextUtils.TruncateAt.END);
      return;
    }
    if (getEllipsize() == TextUtils.TruncateAt.MIDDLE)
    {
      ((a)localObject).a(paramCanvas, TextUtils.TruncateAt.MIDDLE);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setEndStrWidth(int paramInt)
  {
    this.dWM = paramInt;
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.mMaxLines = paramInt;
  }
  
  class a
  {
    private ArrayList<String> Ct = new ArrayList();
    private ArrayList<Integer> Cu = new ArrayList();
    private ArrayList<CharSequence> Cv = new ArrayList();
    private CharSequence aA;
    private int aXy;
    private int ahe;
    private boolean cSt;
    private int dWN;
    private int dWO;
    private int mLeftPadding;
    private int mLineHeight;
    private int mMaxLines;
    private TextPaint mPaint;
    private String mText;
    private int mTopPadding;
    
    a() {}
    
    private float a(int paramInt, TextUtils.TruncateAt paramTruncateAt)
    {
      int i = getContentWidth() - (int)this.mPaint.measureText("...");
      if (paramTruncateAt == TextUtils.TruncateAt.MIDDLE)
      {
        if (this.dWO <= 0) {
          return i / 2;
        }
        if (paramInt == 1)
        {
          if (i < this.dWO) {
            return i;
          }
          return this.dWO;
        }
        if (i < this.dWO) {
          return 0.0F;
        }
        return i - this.dWO;
      }
      if (paramTruncateAt == TextUtils.TruncateAt.END)
      {
        if (this.dWO <= 0) {
          return i;
        }
        if (i < this.dWO) {
          return i;
        }
        return i - this.dWO;
      }
      return i;
    }
    
    private int aq(String paramString, int paramInt)
    {
      if ((paramString == null) || (paramInt < 0) || (paramInt > paramString.length() - 1)) {
        return 0;
      }
      char c = paramString.charAt(paramInt);
      paramString = new float[1];
      this.mPaint.getTextWidths(String.valueOf(c), paramString);
      return (int)Math.ceil(paramString[0]);
    }
    
    private int eW(String paramString)
    {
      return (int)this.mPaint.measureText(paramString, 0, paramString.length());
    }
    
    private void ecb()
    {
      this.Ct.clear();
      this.Cu.clear();
      this.Cv.clear();
      int n = getContentWidth();
      if (n <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EllipsizingTextView", 2, "lineWidth=" + n);
        }
        return;
      }
      int i = 0;
      int j = 0;
      int k = 0;
      label71:
      if (i < this.mText.length())
      {
        if (this.mText.charAt(i) != '\n') {
          break label166;
        }
        this.Ct.add(this.mText.substring(k, i));
        if (EllipsizingTextView.b(EllipsizingTextView.this)) {
          this.Cv.add(this.aA.subSequence(k, i));
        }
        this.Cu.add(Integer.valueOf(j));
        k = i + 1;
        j = 0;
      }
      for (;;)
      {
        i += 1;
        break label71;
        break;
        label166:
        int m = eW(this.mText.substring(k, i + 1));
        if (m > n)
        {
          this.Ct.add(this.mText.substring(k, i));
          if (EllipsizingTextView.b(EllipsizingTextView.this)) {
            this.Cv.add(this.aA.subSequence(k, i));
          }
          this.Cu.add(Integer.valueOf(j));
          if (this.Ct.size() >= this.mText.length()) {
            break;
          }
          k = i;
          i -= 1;
          j = 0;
          continue;
        }
        if (i == this.mText.length() - 1)
        {
          this.Ct.add(this.mText.substring(k, this.mText.length()));
          if (EllipsizingTextView.b(EllipsizingTextView.this)) {
            this.Cv.add(this.aA.subSequence(k, this.aA.length()));
          }
          this.Cu.add(Integer.valueOf(m));
        }
        else
        {
          j = m;
        }
      }
    }
    
    private String fQ(int paramInt)
    {
      int k = (int)a(0, TextUtils.TruncateAt.MIDDLE);
      int m = this.mText.length();
      int j = 0;
      int i = paramInt;
      for (;;)
      {
        if (i < m)
        {
          j += aq(this.mText, i);
          if (j <= k) {}
        }
        else
        {
          return this.mText.substring(paramInt, i);
        }
        i += 1;
      }
    }
    
    private String fR(int paramInt)
    {
      int k = (int)a(1, TextUtils.TruncateAt.MIDDLE);
      int j = 0;
      int i = paramInt;
      for (;;)
      {
        if (i > 0)
        {
          j += aq(this.mText, i);
          if (j <= k) {}
        }
        else
        {
          return this.mText.substring(i + 1, paramInt + 1);
        }
        i -= 1;
      }
    }
    
    private String fS(int paramInt)
    {
      int k = this.mText.length();
      int m = (int)a(1, TextUtils.TruncateAt.END);
      int j = 0;
      int i = paramInt;
      for (;;)
      {
        if ((i >= k) || (j > m))
        {
          if (i - 1 >= paramInt) {
            break;
          }
          return "";
        }
        j += aq(this.mText, i);
        i += 1;
      }
      if (i - 1 > k) {
        return this.mText.substring(paramInt, k);
      }
      return this.mText.substring(paramInt, i - 1);
    }
    
    private int getContentWidth()
    {
      return this.ahe - this.dWN - this.mLeftPadding;
    }
    
    public void a(Canvas paramCanvas, TextUtils.TruncateAt paramTruncateAt)
    {
      int j;
      int m;
      Object localObject1;
      int k;
      label39:
      String str;
      Object localObject2;
      int i;
      if ((this.mMaxLines > 0) && (this.mMaxLines <= this.Ct.size()))
      {
        j = this.mMaxLines;
        m = getContentWidth();
        localObject1 = null;
        k = 0;
        if (k >= j) {
          break label758;
        }
        str = (String)this.Ct.get(k);
        localObject2 = localObject1;
        if (EllipsizingTextView.b(EllipsizingTextView.this))
        {
          localObject2 = localObject1;
          if (this.Cv.size() > k) {
            localObject2 = (CharSequence)this.Cv.get(k);
          }
        }
        i = ((Integer)this.Cu.get(k)).intValue();
        if (paramTruncateAt != TextUtils.TruncateAt.END) {
          break label462;
        }
        if ((j < 2) || (k != j - 1) || (k >= this.Ct.size() - 1)) {
          break label359;
        }
        i = getLineEnd(j - 2);
        str = fS(i + 1) + "...";
        localObject1 = str;
        if (!this.cSt) {
          break label759;
        }
        i = (m - eW(str)) / 2;
        localObject1 = str;
      }
      for (;;)
      {
        label219:
        if ((EllipsizingTextView.b(EllipsizingTextView.this)) && (localObject2 != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EllipsizingTextView", 2, "text is " + ((CharSequence)localObject2).toString() + "and i is" + k + " offset: " + i);
          }
          if (k == 0)
          {
            paramCanvas.translate(i + this.mLeftPadding, 0.0F);
            new StaticLayout((CharSequence)localObject2, this.mPaint, paramCanvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).draw(paramCanvas);
          }
        }
        for (;;)
        {
          label307:
          k += 1;
          localObject1 = localObject2;
          break label39;
          j = this.Ct.size();
          break;
          label359:
          if ((k == j - 1) && (k < this.Ct.size() - 1))
          {
            str = fS(0) + "...";
            localObject1 = str;
            if (!this.cSt) {
              break label759;
            }
            i = (m - eW(str)) / 2;
            localObject1 = str;
            break label219;
          }
          localObject1 = str;
          if (!this.cSt) {
            break label759;
          }
          i = (m - i) / 2;
          localObject1 = str;
          break label219;
          label462:
          localObject1 = str;
          if (paramTruncateAt != TextUtils.TruncateAt.MIDDLE) {
            break label759;
          }
          if ((j >= 2) && (k == j - 1) && (k < this.Ct.size() - 1))
          {
            i = getLineEnd(j - 2);
            str = fQ(i + 1) + "..." + fR(this.mText.length() - 1);
            localObject1 = str;
            if (!this.cSt) {
              break label759;
            }
            i = (m - eW(str)) / 2;
            localObject1 = str;
            break label219;
          }
          if ((k == j - 1) && (k < this.Ct.size() - 1))
          {
            str = fQ(0) + "..." + fR(this.mText.length() - 1);
            localObject1 = str;
            if (!this.cSt) {
              break label759;
            }
            i = (m - eW(str)) / 2;
            localObject1 = str;
            break label219;
          }
          localObject1 = str;
          if (!this.cSt) {
            break label759;
          }
          i = (m - i) / 2;
          localObject1 = str;
          break label219;
          paramCanvas.translate(0.0F, this.mLineHeight);
          break label307;
          paramCanvas.drawText(localObject1, i + this.mLeftPadding, this.mPaint.getTextSize() + this.mLineHeight * k + this.mTopPadding, this.mPaint);
        }
        label758:
        return;
        label759:
        i = 0;
      }
    }
    
    public void a(CharSequence paramCharSequence, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if ((paramCharSequence == null) || (paramTextView == null)) {
        return;
      }
      this.aA = paramCharSequence;
      if (EllipsizingTextView.a(EllipsizingTextView.this))
      {
        if (!(paramCharSequence instanceof SpannableString)) {
          break label128;
        }
        EllipsizingTextView.a(EllipsizingTextView.this, true);
      }
      for (;;)
      {
        this.mText = paramCharSequence.toString();
        this.mPaint = paramTextView.getPaint();
        this.ahe = paramTextView.getMeasuredWidth();
        this.mLineHeight = paramTextView.getLineHeight();
        this.mLeftPadding = paramTextView.getPaddingLeft();
        this.mTopPadding = paramTextView.getPaddingTop();
        this.dWN = paramTextView.getPaddingRight();
        this.aXy = paramTextView.getPaddingBottom();
        this.mMaxLines = paramInt1;
        this.dWO = paramInt2;
        this.cSt = paramBoolean;
        ecb();
        return;
        label128:
        if ((paramCharSequence instanceof SpannedString)) {
          EllipsizingTextView.a(EllipsizingTextView.this, true);
        }
      }
    }
    
    public int getLineCount()
    {
      return this.Ct.size();
    }
    
    public int getLineEnd(int paramInt)
    {
      int i = 0;
      int j = 0;
      while (i <= paramInt)
      {
        j += ((String)this.Ct.get(i)).length();
        i += 1;
      }
      if (j <= 0) {
        return 0;
      }
      return j - 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.EllipsizingTextView
 * JD-Core Version:    0.7.0.1
 */