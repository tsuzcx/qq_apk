package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import java.util.ArrayList;
import java.util.Iterator;

public class GLTextView
  extends GLImageView
{
  private Bitmap mBitmap;
  private Canvas mCanvas;
  private boolean mNeedDrawText;
  private ArrayList<StringItem> mStringList = new ArrayList();
  private Paint paint = new Paint();
  private int pixelHeightSize = 0;
  private float totalWidth = 0.0F;
  
  public GLTextView(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    initView(4);
  }
  
  private void drawText()
  {
    float f1 = getTextWidth();
    if (this.pixelHeightSize == 0) {
      return;
    }
    this.mBitmap = Bitmap.createBitmap((int)f1, this.pixelHeightSize, Bitmap.Config.ARGB_8888);
    this.mCanvas = new Canvas(this.mBitmap);
    this.paint.setTextSize(this.pixelHeightSize);
    this.paint.setAntiAlias(true);
    this.paint.setDither(true);
    float f2 = Math.abs(this.paint.getFontMetrics().ascent);
    Iterator localIterator = this.mStringList.iterator();
    StringItem localStringItem;
    for (f1 = 0.0F; localIterator.hasNext(); f1 = localStringItem.measureSize + f1)
    {
      localStringItem = (StringItem)localIterator.next();
      this.paint.setColor(localStringItem.color);
      this.mCanvas.drawText(localStringItem.data, f1, f2, this.paint);
    }
    super.setImageBitmap(this.mBitmap);
    this.mNeedDrawText = false;
  }
  
  public void clearTextCache()
  {
    this.mStringList.clear();
    this.totalWidth = 0.0F;
  }
  
  public void draw()
  {
    if (this.mNeedDrawText) {
      drawText();
    }
    super.draw();
  }
  
  public int getTextHeight()
  {
    return this.pixelHeightSize;
  }
  
  public float getTextWidth()
  {
    if (this.totalWidth == 0.0F)
    {
      this.paint.setTextSize(this.pixelHeightSize);
      Iterator localIterator = this.mStringList.iterator();
      while (localIterator.hasNext())
      {
        StringItem localStringItem = (StringItem)localIterator.next();
        localStringItem.measureSize = this.paint.measureText(localStringItem.data);
        float f = this.totalWidth;
        this.totalWidth = (localStringItem.measureSize + f);
      }
    }
    return this.totalWidth;
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {}
  
  public void setImageRes(String paramString) {}
  
  public void setText(String paramString, int paramInt1, int paramInt2)
  {
    StringItem localStringItem = new StringItem();
    localStringItem.data = paramString;
    localStringItem.count = paramInt1;
    localStringItem.color = paramInt2;
    this.mStringList.add(localStringItem);
    this.mNeedDrawText = true;
  }
  
  public void setTextSize(int paramInt)
  {
    this.pixelHeightSize = paramInt;
  }
  
  public class StringItem
  {
    public int color;
    public int count;
    public String data;
    public float measureSize;
    
    public StringItem() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLTextView
 * JD-Core Version:    0.7.0.1
 */