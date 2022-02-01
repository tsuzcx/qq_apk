package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.FontMetrics;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import aqnm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordNavView
  extends View
{
  private b a;
  private Map<Float, String> eP;
  private float lf;
  private ArrayList<String> lo = new ArrayList();
  private GestureDetector mGestureDetector;
  private TextPaint mPaint;
  private float mTextSize = aqnm.dpToPx(15.0F);
  
  public WordNavView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initPaint();
  }
  
  private void initPaint()
  {
    this.mPaint = new TextPaint();
    this.mPaint.setFlags(1);
    this.mPaint.setColor(Color.parseColor("#878B99"));
    this.mPaint.setTextSize(this.mTextSize);
    this.lf = Math.abs(this.mPaint.getFontMetrics().top);
    this.mGestureDetector = new GestureDetector(getContext(), new a(null));
  }
  
  private float m(int paramInt)
  {
    return getPaddingLeft() + getWidth() / 2 - this.mPaint.measureText((String)this.lo.get(paramInt)) / 2.0F;
  }
  
  private float n(int paramInt)
  {
    return getPaddingTop() + getHeight() / this.lo.size() * (paramInt + 1) - this.lf / 2.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.eP = new HashMap();
    int i = 0;
    while (i < this.lo.size())
    {
      float f = n(i);
      paramCanvas.drawText((String)this.lo.get(i), m(i), f, this.mPaint);
      this.eP.put(Float.valueOf(f), this.lo.get(i));
      i += 1;
    }
    super.onDraw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setIndexList(ArrayList<String> paramArrayList)
  {
    this.lo.clear();
    this.lo.addAll(paramArrayList);
    getLayoutParams().height = (this.lo.size() * (int)(this.mTextSize + aqnm.dpToPx(5.0F)));
    requestLayout();
    invalidate();
  }
  
  public void setOnTouchingWordChangedListener(b paramb)
  {
    this.a = paramb;
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      float f = paramMotionEvent.getY();
      Iterator localIterator = WordNavView.a(WordNavView.this).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((f >= ((Float)localEntry.getKey()).floatValue() - WordNavView.this.getHeight() / WordNavView.a(WordNavView.this).size() / 2) && (f <= ((Float)localEntry.getKey()).floatValue() + WordNavView.this.getHeight() / WordNavView.a(WordNavView.this).size() / 2)) {
          if (WordNavView.a(WordNavView.this) != null) {
            WordNavView.a(WordNavView.this).nd((String)localEntry.getValue());
          }
        }
      }
      return super.onSingleTapUp(paramMotionEvent);
    }
  }
  
  public static abstract interface b
  {
    public abstract void nd(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.WordNavView
 * JD-Core Version:    0.7.0.1
 */