package com.tencent.mobileqq.ar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class DrawView2
  extends View
{
  public static int previewHeight;
  public static int previewWidth;
  public static float scaleX = 1.0F;
  public static float scaleY = 1.0F;
  public static int screenHeight;
  public static int screenWidth;
  private Paint aJ = new Paint();
  private Paint bz = new Paint();
  List<a> da;
  Handler mHandler;
  HandlerThread mHandlerThread;
  
  public DrawView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aJ.setARGB(255, 0, 255, 0);
    this.aJ.setStrokeWidth(10.0F);
    this.aJ.setStyle(Paint.Style.STROKE);
    this.bz.setStrokeWidth(10.0F);
    this.bz.setTextSize(30.0F);
    this.bz.setColor(-65536);
    setWillNotDraw(false);
    this.mHandlerThread = new HandlerThread("DrawViewThread");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a locala;
    int i;
    label60:
    float f1;
    float f2;
    if ((this.da != null) && (this.da.size() > 0))
    {
      Iterator localIterator = this.da.iterator();
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        paramCanvas.save();
        i = 0;
        if (i < 90) {
          if (scaleX != 1.0F)
          {
            f1 = locala.bV[(i * 2)];
            f2 = previewWidth / 2;
            float f3 = screenWidth / 2 / (previewWidth / 2 / scaleX);
            f2 = screenWidth / 2 + (f1 - f2) * f3;
            f1 = locala.bV[(i * 2 + 1)] * screenHeight / previewHeight;
          }
        }
      }
    }
    for (;;)
    {
      paramCanvas.drawPoint(f2, f1, this.aJ);
      if ((!TextUtils.isEmpty(locala.name)) && (i == 87)) {
        paramCanvas.drawText(locala.name, f2, f1, this.bz);
      }
      i += 1;
      break label60;
      if (scaleY != 1.0F)
      {
        f2 = locala.bV[(i * 2)] * screenWidth / previewWidth;
        f1 = (locala.bV[(i * 2 + 1)] - previewHeight / 2) * (screenHeight / 2 / (previewHeight / 2 / scaleY)) + screenHeight / 2;
        continue;
        paramCanvas.restore();
        break;
        return;
      }
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public void setFaceData(List<a> paramList)
  {
    this.da = paramList;
    postInvalidate();
  }
  
  public static class a
  {
    public RectF as;
    public boolean bMt;
    public boolean bMu;
    public boolean bMv;
    public boolean bMw;
    public float[] bV;
    public String bsv;
    public String bsw;
    public String bsx;
    public Rect by;
    public float confidence;
    public String enName;
    public int faceID;
    public String imgUrl;
    public boolean isStar;
    public String name;
    public String uin;
    public String url;
    
    public static RectF a(Rect paramRect, float[] paramArrayOfFloat)
    {
      if ((paramRect == null) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 180))
      {
        paramRect = null;
        return paramRect;
      }
      paramArrayOfFloat = (float[])paramArrayOfFloat.clone();
      float[] arrayOfFloat1 = new float[2];
      float[] arrayOfFloat2 = new float[2];
      float[] arrayOfFloat3 = new float[2];
      float[] arrayOfFloat4 = new float[2];
      arrayOfFloat1[0] = paramArrayOfFloat[12];
      arrayOfFloat1[1] = paramArrayOfFloat[13];
      arrayOfFloat2[0] = paramArrayOfFloat[28];
      arrayOfFloat2[1] = paramArrayOfFloat[29];
      arrayOfFloat3[0] = paramArrayOfFloat[64];
      arrayOfFloat3[1] = paramArrayOfFloat[65];
      arrayOfFloat4[0] = (arrayOfFloat1[0] + arrayOfFloat2[0] - arrayOfFloat3[0]);
      arrayOfFloat4[1] = (arrayOfFloat1[1] + arrayOfFloat2[1] - arrayOfFloat3[1]);
      float f2 = Math.min(paramRect.left, arrayOfFloat4[0]);
      float f3 = Math.max(paramRect.right, arrayOfFloat4[0]);
      float f4 = Math.min(paramRect.top, arrayOfFloat4[1]);
      float f5 = Math.max(paramRect.bottom, arrayOfFloat4[1]);
      float f1 = DrawView2.screenWidth / DrawView2.screenHeight;
      float f6 = Math.max(DrawView2.previewWidth, DrawView2.previewHeight);
      float f7 = Math.min(DrawView2.previewWidth, DrawView2.previewHeight);
      if (f1 > f7 / f6) {}
      for (f1 = DrawView2.screenWidth / f7;; f1 = DrawView2.screenHeight / f6)
      {
        float f8 = (f1 * f7 - DrawView2.screenWidth) / 2.0F;
        f7 = (f7 * f1 - DrawView2.screenWidth) / 2.0F;
        paramArrayOfFloat = new RectF(f2 * f1 - f8, f4 * f1 - (f1 * f6 - DrawView2.screenHeight) / 2.0F, f3 * f1 - f7, f5 * f1 - (f1 * f6 - DrawView2.screenHeight) / 2.0F);
        paramRect = paramArrayOfFloat;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("DrawView", 2, "mapFaceRect2Screen  result = " + paramArrayOfFloat.toString());
        return paramArrayOfFloat;
      }
    }
    
    public static RectF a(RectF paramRectF)
    {
      float f4 = 40.0F;
      if (paramRectF == null) {
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DrawView", 2, "faceRect  result = " + paramRectF.toString());
      }
      if ((paramRectF.left == 0.0F) && (paramRectF.top == 0.0F) && (paramRectF.right == 0.0F)) {
        return new RectF(DrawView2.screenWidth / 2 - 210, DrawView2.screenHeight / 2 - 210, DrawView2.screenWidth / 2 + 210, DrawView2.screenHeight / 2 + 210);
      }
      float f3 = paramRectF.left;
      float f5 = paramRectF.right;
      float f1 = paramRectF.top;
      float f2 = paramRectF.bottom;
      f3 = (f3 + f5) / 2.0F;
      f2 = (f1 + f2) / 2.0F;
      f1 = f3 * (DrawView2.screenWidth / 480);
      f2 *= DrawView2.screenHeight / 856;
      float f6 = f1 - 210.0F;
      f3 = f2 - 210.0F;
      float f7 = f1 + 210.0F;
      f5 = f2 + 210.0F;
      if (QLog.isColorLevel()) {
        QLog.d("DrawView", 2, "mapMigObjectRect2Screen1  result = " + f6 + "   ：" + f3 + "  ：" + f7 + "  ：" + f5);
      }
      f2 = f7;
      f1 = f6;
      if (f6 < 40.0F)
      {
        f2 = f7 - f6 + 40.0F;
        f1 = 40.0F;
      }
      if (f3 < 40.0F) {}
      for (f3 = f5 - f3 + 40.0F;; f3 = f5)
      {
        if (f2 > DrawView2.screenWidth - 40)
        {
          f6 = DrawView2.screenWidth - 40 - (f2 - f1);
          f5 = DrawView2.screenWidth - 40;
        }
        for (;;)
        {
          f2 = f3;
          f1 = f4;
          if (f3 > DrawView2.screenHeight - 40)
          {
            f1 = DrawView2.screenHeight - 40 - (f3 - f4);
            f2 = DrawView2.screenHeight - 40;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DrawView", 2, "mapMigObjectRect2Screen1  result = " + f6 + "   ：" + f1 + "  ：" + f5 + "  ：" + f2);
          }
          f4 = f5;
          f3 = f6;
          if ((f6 + f5) / 2.0F < DrawView2.screenWidth / 2 - 125)
          {
            f3 = DrawView2.screenWidth / 2 - 125 - 210;
            f4 = DrawView2.screenWidth / 2 - 125 + 210;
          }
          f6 = f4;
          f5 = f3;
          if ((f3 + f4) / 2.0F > DrawView2.screenWidth / 2 + 125)
          {
            f5 = DrawView2.screenWidth / 2 + 125 - 210;
            f6 = DrawView2.screenWidth / 2 + 125 + 210;
          }
          f4 = f2;
          f3 = f1;
          if ((f1 + f2) / 2.0F < DrawView2.screenHeight / 2 - 417)
          {
            f3 = DrawView2.screenHeight / 2 - 417 - 210;
            f4 = DrawView2.screenHeight / 2 - 417 + 210;
          }
          f2 = f4;
          f1 = f3;
          if ((f3 + f4) / 2.0F > DrawView2.screenHeight / 2 + 417)
          {
            f1 = DrawView2.screenHeight / 2 + 417 - 210;
            f2 = DrawView2.screenHeight / 2 + 417 + 210;
          }
          paramRectF = new RectF(f5, f1, f6, f2);
          if (QLog.isColorLevel()) {
            QLog.d("DrawView", 2, "mapMigObjectRect2Screen3  result = " + paramRectF.toString());
          }
          return paramRectF;
          f5 = f2;
          f6 = f1;
        }
        f4 = f3;
      }
    }
    
    public RectF h()
    {
      return this.as;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.DrawView2
 * JD-Core Version:    0.7.0.1
 */