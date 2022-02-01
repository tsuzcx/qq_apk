package com.tencent.mobileqq.ocr.view;

import ahqx;
import aklz.a;
import akoq;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import ankt;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class OcrImageTextView
  extends ImageView
{
  private static String TAG = "OcrImageTextView";
  private List<akoq> Ej = new ArrayList();
  private aklz.a a;
  private boolean ctr;
  private boolean cts;
  private Bitmap fC;
  public Runnable hi = new OcrImageTextView.2(this);
  private Context mContext;
  private Paint paint;
  private float scaleX;
  private float scaleY;
  
  public OcrImageTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OcrImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OcrImageTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  public static float a(int paramInt1, String paramString, Paint paramPaint, int paramInt2)
  {
    float f2 = paramPaint.getTextSize();
    float f1 = paramPaint.measureText(paramString);
    paramInt1 = (int)(paramInt1 * 0.95D);
    paramInt2 = (int)(paramInt2 * 0.95D);
    if (f1 > paramInt1)
    {
      f2 -= 1.0F;
      for (f3 = f1;; f3 = paramPaint.measureText(paramString))
      {
        f1 = f2;
        if (f3 <= paramInt1) {
          break;
        }
        f2 -= 1.0F;
        paramPaint.setTextSize(f2);
      }
    }
    f2 += 1.0F;
    for (float f3 = f1;; f3 = paramPaint.measureText(paramString))
    {
      f1 = f2;
      if (f3 >= paramInt1) {
        break;
      }
      f2 += 1.0F;
      paramPaint.setTextSize(f2);
    }
    paramString = paramPaint.getFontMetrics();
    f2 = paramString.descent;
    f3 = paramString.ascent;
    f3 = f2 - f3;
    f2 = f1;
    for (f1 = f3; f1 > paramInt2; f1 = paramString.descent - paramString.ascent)
    {
      f2 -= 1.0F;
      paramPaint.setTextSize(f2);
      paramString = paramPaint.getFontMetrics();
    }
    return f2 - 1.0F;
  }
  
  private void a(List<ahqx> paramList, int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new OcrImageTextView.1(this, paramList, paramString, paramInt2, paramInt1));
  }
  
  private void init()
  {
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-38294);
    this.paint.setTextSize(30.0F);
  }
  
  public void MX(boolean paramBoolean)
  {
    this.cts = paramBoolean;
    requestLayout();
  }
  
  public List<akoq> a(List<ahqx> paramList, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    clear();
    if ((paramList == null) || (paramList.isEmpty()) || (getDrawable() == null) || (!(getDrawable() instanceof BitmapDrawable))) {
      return null;
    }
    int i;
    if (QLog.isColorLevel())
    {
      i = 0;
      while (i < paramList.size())
      {
        QLog.d(TAG, 2, new Object[] { paramList.get(i) });
        i += 1;
      }
    }
    if (this.fC == null)
    {
      this.fC = ((BitmapDrawable)getDrawable()).getBitmap();
      this.scaleX = (ankt.aE(getContext()) / this.fC.getWidth());
      this.scaleY = this.scaleX;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "scaleX=" + this.scaleX + " scaleY=" + this.scaleY + " getWidth=" + this.fC.getWidth() + ", " + getWidth() + " getHeight=" + this.fC.getHeight() + ", " + getHeight() + " ocrWidth=" + paramInt1 + " ocrHeight=" + paramInt2 + " hardware accelerate: " + isHardwareAccelerated());
      }
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ahqx localahqx = (ahqx)localIterator.next();
      i = this.fC.getWidth();
      if (i != paramInt1)
      {
        float f = i / paramInt1;
        if ((paramInt3 == 90) || (paramInt3 == 270)) {
          f = i / paramInt2;
        }
        localahqx.aQ(f);
      }
    }
    a(paramList, this.fC.getWidth(), this.fC.getHeight(), paramString);
    return this.Ej;
  }
  
  public void a(int paramInt1, akoq paramakoq, int paramInt2)
  {
    this.paint.getTextSize();
    if (paramInt1 <= 0) {
      return;
    }
    if (paramakoq.textSize > 0.0F)
    {
      this.paint.setTextSize(paramakoq.textSize);
      return;
    }
    paramakoq.textSize = a(paramInt1, paramakoq.text, this.paint, paramInt2);
    Rect localRect = new Rect();
    this.paint.getTextBounds(paramakoq.text, 0, paramakoq.text.length(), localRect);
    paramakoq.marginLeft = ((paramInt1 - localRect.width()) / 2);
    paramakoq.marginTop = ((paramInt2 - localRect.height()) / 2);
    this.paint.setTextSize(paramakoq.textSize);
  }
  
  public boolean ase()
  {
    return this.ctr;
  }
  
  public boolean asf()
  {
    if ((this.Ej == null) || (this.Ej.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.Ej.iterator();
    while (localIterator.hasNext()) {
      if (((akoq)localIterator.next()).isSelected) {
        return true;
      }
    }
    return false;
  }
  
  public void clear()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.hi);
    Iterator localIterator = this.Ej.iterator();
    while (localIterator.hasNext())
    {
      akoq localakoq = (akoq)localIterator.next();
      if ((localakoq != null) && (localakoq.fB != null))
      {
        localakoq.fB.recycle();
        localakoq.fB = null;
      }
    }
    this.Ej.clear();
    if (this.fC != null)
    {
      this.fC.recycle();
      this.fC = null;
    }
  }
  
  public boolean kK(int paramInt)
  {
    if (this.fC == null) {
      this.fC = ((BitmapDrawable)getDrawable()).getBitmap();
    }
    return this.fC.getHeight() * this.scaleY <= paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.ctr) {}
    akoq localakoq;
    Rect localRect;
    int i;
    for (;;)
    {
      return;
      if ((this.fC != null) && (this.Ej != null) && (this.Ej.size() > 0))
      {
        Iterator localIterator = this.Ej.iterator();
        while (localIterator.hasNext())
        {
          localakoq = (akoq)localIterator.next();
          if (localakoq.fB != null)
          {
            a(localakoq.showWidth, localakoq, localakoq.showHeight);
            if (localakoq.ci == null)
            {
              localRect = new Rect();
              this.paint.getTextBounds(localakoq.text, 0, localakoq.text.length(), localRect);
              localakoq.ci = localRect;
            }
            paramCanvas.save();
            paramCanvas.translate(((Point)localakoq.Ei.get(0)).x, ((Point)localakoq.Ei.get(0)).y);
            paramCanvas.rotate(localakoq.dod);
            localRect = new Rect();
            localRect.set(0, 0, localakoq.showWidth, localakoq.showHeight);
            i = localakoq.ci.height();
            if (!localakoq.ctq) {
              break label328;
            }
            this.paint.setColor(localakoq.dog);
            paramCanvas.drawRect(localRect, this.paint);
            if (localakoq.isSelected)
            {
              this.paint.setColor(-15550475);
              paramCanvas.drawRect(localRect, this.paint);
            }
            this.paint.setColor(localakoq.textColor);
            paramCanvas.drawText(localakoq.text, localakoq.marginLeft, i, this.paint);
            paramCanvas.restore();
          }
        }
      }
    }
    label328:
    paramCanvas.drawBitmap(localakoq.fB, localRect, localRect, this.paint);
    if (localakoq.isSelected)
    {
      this.paint.setColor(-15550475);
      paramCanvas.drawRect(localRect, this.paint);
    }
    if (localakoq.ctp) {
      this.paint.setColor(-1);
    }
    for (;;)
    {
      paramCanvas.drawText(localakoq.text, localakoq.marginLeft, i, this.paint);
      break;
      this.paint.setColor(-16777216);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onMeasure isRequestOcr=" + this.cts);
    }
    if ((getDrawable() == null) || (((BitmapDrawable)getDrawable()).getBitmap() == null))
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    if (this.cts)
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    Bitmap localBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
    if (localBitmap == null)
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    paramInt1 = localBitmap.getWidth();
    paramInt2 = localBitmap.getHeight();
    float f = ankt.aE(getContext()) / paramInt1;
    paramInt1 = (int)(paramInt2 * f);
    super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(ankt.aE(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
  }
  
  public CharSequence p()
  {
    if ((this.Ej == null) || (this.Ej.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.Ej.iterator();
    int i = -2;
    akoq localakoq;
    if (localIterator.hasNext())
    {
      localakoq = (akoq)localIterator.next();
      if (!localakoq.isSelected) {
        break label156;
      }
      if (i < 0)
      {
        localStringBuilder.append(localakoq.text.trim());
        i = localakoq.daM;
      }
    }
    label156:
    for (;;)
    {
      break;
      if (localakoq.daM == i)
      {
        localStringBuilder.append(localakoq.text.trim());
      }
      else
      {
        localStringBuilder.append("\n\n").append(localakoq.text.trim());
        i = localakoq.daM;
        continue;
        return localStringBuilder.toString();
      }
    }
  }
  
  public void setHideAnimLisnter(aklz.a parama)
  {
    this.a = parama;
  }
  
  public void setShowTextMask(boolean paramBoolean)
  {
    this.ctr = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView
 * JD-Core Version:    0.7.0.1
 */