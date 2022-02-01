package me.ele.uetool.colorpicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.uetool.colorpicker.listener.OnAlphaChangedListenter;

public class AlphaPicker
  extends ImageView
{
  private Bitmap AlpBitmap;
  private Bitmap AlpBitmapCopy;
  private int alpha = -1;
  private int beginColor;
  ColorPaint colorPaint = ColorPaint.getInstance();
  private int curColorX = (int)this.markPoint;
  private int endColor;
  private ArrayList<OnAlphaChangedListenter> listeners = new ArrayList();
  private float markPoint = 10.0F;
  private int panelHeight = 1;
  private int panelWidth = 1;
  private float pes = -1.0F;
  private int selectColor;
  
  public AlphaPicker(Context paramContext)
  {
    super(paramContext);
  }
  
  public AlphaPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AlphaPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void callListener(boolean paramBoolean)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((OnAlphaChangedListenter)localIterator.next()).onAlphaChanged(this.selectColor, paramBoolean);
    }
  }
  
  private void deal(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int i = j;
    if (j < this.markPoint) {
      i = (int)this.markPoint;
    }
    j = i;
    if (i > this.panelWidth - this.markPoint) {
      j = (int)(this.panelWidth - this.markPoint);
    }
    getChange(j);
  }
  
  private void getChange(int paramInt)
  {
    this.curColorX = paramInt;
    this.pes = ((paramInt - this.markPoint) / (this.panelWidth - this.markPoint * 2.0F));
    this.alpha = ((int)(255.0F * this.pes));
    this.selectColor = (this.selectColor & 0xFFFFFF | this.alpha << 24);
    makeMarkedAlphaBitmap();
    callListener(true);
  }
  
  @RequiresApi(api=21)
  private Bitmap makeHueBitmap()
  {
    Canvas localCanvas = new Canvas();
    this.AlpBitmap = Bitmap.createBitmap(this.panelWidth, this.panelHeight, Bitmap.Config.ARGB_8888);
    localCanvas.setBitmap(this.AlpBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    int i = this.beginColor;
    int j = this.endColor;
    float f1 = this.markPoint;
    float f2 = this.panelHeight;
    float f3 = this.panelWidth;
    float f4 = this.markPoint;
    float f5 = this.panelHeight;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    localPaint.setShader(new LinearGradient(f1, f2 * 0.5F, f3 + f4, f5 * 0.5F, new int[] { i, j }, new float[] { 0.0F, 1.0F }, localTileMode));
    localCanvas.drawRoundRect(this.markPoint, this.markPoint / 2.0F, this.panelWidth - this.markPoint, this.panelHeight - this.markPoint / 2.0F, 10.0F, 10.0F, localPaint);
    return this.AlpBitmap;
  }
  
  public void addListener(OnAlphaChangedListenter paramOnAlphaChangedListenter)
  {
    this.listeners.add(paramOnAlphaChangedListenter);
  }
  
  public float getAplha(int paramInt)
  {
    this.beginColor = (paramInt & 0xFFFFFF);
    this.endColor = (paramInt | 0xFF000000);
    if (this.alpha == -1) {}
    for (this.selectColor = paramInt;; this.selectColor = (paramInt & 0xFFFFFF | this.alpha << 24))
    {
      this.alpha = ((this.selectColor & 0xFF000000) >>> 24);
      this.pes = (this.alpha / 255.0F);
      return this.pes;
    }
  }
  
  public float getPes()
  {
    return this.pes;
  }
  
  @RequiresApi(api=21)
  public void initColor(int paramInt)
  {
    getAplha(paramInt);
    makeHueBitmap();
    this.selectColor = paramInt;
    this.curColorX = ((int)(this.pes * (this.panelWidth - 2.0F * this.markPoint) + this.markPoint));
    makeMarkedAlphaBitmap();
    callListener(false);
  }
  
  public void makeMarkedAlphaBitmap()
  {
    this.AlpBitmapCopy = Bitmap.createBitmap(this.AlpBitmap);
    Canvas localCanvas = new Canvas(this.AlpBitmapCopy);
    this.colorPaint.paintSelectedHueColorForHueMarker.setColor(this.selectColor);
    localCanvas.drawCircle(this.curColorX, this.markPoint, this.markPoint - 10.0F, this.colorPaint.paintWhite);
    localCanvas.drawCircle(this.curColorX, this.markPoint, this.markPoint - 10.0F, this.colorPaint.paintSelectedHueColorForHueMarker);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    setImageBitmap(this.AlpBitmapCopy);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = paramInt2;
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default: 
      i = 0;
    case 0: 
      paramInt2 = paramInt1;
      switch (j)
      {
      default: 
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, i);
      return;
      i = this.panelHeight;
      break;
      i = View.MeasureSpec.getSize(paramInt2);
      break;
      paramInt2 = this.panelWidth;
      continue;
      paramInt2 = View.MeasureSpec.getSize(paramInt1);
    }
  }
  
  @RequiresApi(api=21)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.panelWidth = getMeasuredWidth();
    this.panelHeight = getMeasuredHeight();
    this.markPoint = (this.panelHeight / 2);
    getAplha(this.selectColor);
    makeHueBitmap();
    this.curColorX = ((int)(this.pes * (this.panelWidth - 2.0F * this.markPoint) + this.markPoint));
    makeMarkedAlphaBitmap();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      deal(paramMotionEvent);
      return true;
      deal(paramMotionEvent);
    }
  }
  
  @RequiresApi(api=21)
  public void setColor(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.alpha = -1;
    }
    getAplha(paramInt);
    this.curColorX = ((int)(this.pes * (this.panelWidth - 2.0F * this.markPoint) + this.markPoint));
    makeHueBitmap();
    makeMarkedAlphaBitmap();
    callListener(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.colorpicker.AlphaPicker
 * JD-Core Version:    0.7.0.1
 */