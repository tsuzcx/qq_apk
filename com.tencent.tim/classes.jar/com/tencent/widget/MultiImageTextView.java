package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView.BufferType;
import auvc;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiImageTextView
  extends ColorNickTextView
{
  private ArrayList<auvc> EE = new ArrayList();
  private StringBuilder ac = new StringBuilder();
  public boolean dkI;
  
  public MultiImageTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MultiImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MultiImageTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public MultiImageTextView a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    b localb = new b(null);
    localb.drawable = paramDrawable;
    localb.drawable.setBounds(0, 0, paramInt1, paramInt2);
    a(localb);
    return this;
  }
  
  public void a(auvc paramauvc)
  {
    paramauvc.cIX = ("[" + this.EE.size() + "]");
    paramauvc.start = this.ac.length();
    paramauvc.end = (paramauvc.start + paramauvc.cIX.length());
    this.ac.append(paramauvc.cIX);
    this.EE.add(paramauvc);
  }
  
  public void abj(int paramInt)
  {
    d locald = new d(null);
    locald.etS = paramInt;
    a(locald);
  }
  
  public void append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this.ac.append(paramCharSequence, paramInt1, paramInt2);
    this.dkI = true;
    super.append(paramCharSequence, paramInt1, paramInt2);
  }
  
  public void bl(float paramFloat)
  {
    abj((int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F));
  }
  
  public void exh()
  {
    SpannableString localSpannableString = new SpannableString(this.ac);
    Iterator localIterator = this.EE.iterator();
    while (localIterator.hasNext()) {
      ((auvc)localIterator.next()).c(localSpannableString);
    }
    setText(localSpannableString);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (!this.dkI)
    {
      if (this.EE != null) {
        this.EE.clear();
      }
      this.ac = new StringBuilder(paramCharSequence);
    }
    for (;;)
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
      this.dkI = false;
    }
  }
  
  static class a
    extends ImageSpan
  {
    public a(Drawable paramDrawable, int paramInt)
    {
      super(paramInt);
    }
    
    public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
    {
      paramCharSequence = getDrawable();
      paramPaint = paramPaint.getFontMetricsInt();
      paramInt1 = paramPaint.descent;
      paramInt1 = (paramPaint.ascent + (paramInt1 + paramInt4 + paramInt4)) / 2;
      paramInt2 = paramCharSequence.getBounds().bottom / 2;
      paramCanvas.save();
      paramCanvas.translate(paramFloat, paramInt1 - paramInt2);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  static class b
    extends auvc
  {
    public Drawable drawable;
    
    public void c(SpannableString paramSpannableString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("spanStyle", 2, "[ImageStyle] start:" + this.start + " end:" + this.end);
      }
      paramSpannableString.setSpan(new MultiImageTextView.a(this.drawable, 1), this.start, this.end, 17);
    }
  }
  
  static class c
    extends ReplacementSpan
  {
    private int aKb;
    
    public c(int paramInt)
    {
      this.aKb = paramInt;
    }
    
    public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint) {}
    
    public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      return this.aKb;
    }
  }
  
  static class d
    extends auvc
  {
    public int etS;
    
    public void c(SpannableString paramSpannableString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("spanStyle", 2, "[MarginStyle] start:" + this.start + " end:" + this.end + " marginPix:" + this.etS);
      }
      paramSpannableString.setSpan(new MultiImageTextView.c(this.etS), this.start, this.end, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView
 * JD-Core Version:    0.7.0.1
 */