package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.LinearInterpolator;
import aynr;
import ayoa;
import ayog;
import ayoi;
import java.util.ArrayList;
import java.util.Iterator;
import wja;

public class SecondDemoView
  extends View
{
  private ArrayList<Bitmap> GA = new ArrayList();
  public ArrayList<Integer> Gv = null;
  private ArrayList<Bitmap> Gx = new ArrayList();
  private ArrayList<Bitmap> Gy = new ArrayList();
  private ArrayList<Bitmap> Gz = new ArrayList();
  aynr a = new aynr();
  ayog c;
  private String cXq = "05:36";
  private String cXr = "2017 SEPTEMBER 30";
  ayog d;
  int lineIndex = 0;
  private Paint mPaint = new Paint();
  private TextPaint mTextPaint = new TextPaint();
  
  public SecondDemoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SecondDemoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SecondDemoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private ayog a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Typeface paramTypeface, aynr paramaynr)
  {
    paramTypeface = new ayog(paramInt1, paramInt2, paramTypeface, paramInt3, paramInt4, paramInt5, paramInt6);
    paramTypeface.a(paramCharSequence, paramaynr);
    return paramTypeface;
  }
  
  private void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = this.c.Gw.iterator();
      ayoa localayoa;
      Bitmap localBitmap;
      TextPaint localTextPaint;
      while (paramArrayList.hasNext())
      {
        localayoa = (ayoa)paramArrayList.next();
        localBitmap = localayoa.mBitmap;
        localTextPaint = this.c.mPaint;
        localTextPaint.setAlpha(((Integer)this.Gv.get(localayoa.eLM)).intValue());
        i = this.c.mStartX;
        paramCanvas.drawBitmap(localBitmap, localayoa.eLL + i, this.c.mStartY, localTextPaint);
      }
      this.mPaint.setStrokeWidth(wja.dp2px(2.0F, getResources()));
      int i = wja.dp2px(55.0F, getResources());
      paramCanvas.drawLine(0.0F, i, ((Integer)this.Gv.get(this.lineIndex)).intValue(), i, this.mPaint);
      paramArrayList = this.d.Gw.iterator();
      while (paramArrayList.hasNext())
      {
        localayoa = (ayoa)paramArrayList.next();
        localBitmap = localayoa.mBitmap;
        localTextPaint = this.d.mPaint;
        localTextPaint.setAlpha(((Integer)this.Gv.get(localayoa.eLM)).intValue());
        i = this.d.mStartX;
        paramCanvas.drawBitmap(localBitmap, localayoa.eLL + i, this.d.mStartY, localTextPaint);
      }
    }
  }
  
  private void eSU()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofObject(this.a, new Object[] { this.a.eQ(), this.a.eP() });
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.setRepeatCount(100);
    localValueAnimator.addUpdateListener(new ayoi(this));
    localValueAnimator.setDuration(this.a.getDuration());
    localValueAnimator.start();
  }
  
  private void init()
  {
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setColor(-1);
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setDither(true);
    this.mTextPaint.setColor(-1);
    this.c = a(this.cXq, wja.dp2px(48.0F, getResources()), -1, 0, 0, 0, 600, Typeface.DEFAULT_BOLD, this.a);
    this.lineIndex = this.a.a("", 500L, 500L, 0, wja.dp2px(135.0F, getResources()), new AnticipateOvershootInterpolator());
    this.d = a(this.cXr, wja.dp2px(11.0F, getResources()), -1, 0, wja.dp2px(60.0F, getResources()), 700, 1000, Typeface.DEFAULT_BOLD, this.a);
    eSU();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas, this.Gv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.SecondDemoView
 * JD-Core Version:    0.7.0.1
 */