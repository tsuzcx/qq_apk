package com.tencent.qqmail.utilities.richeditor;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

class QMBulletSpan
  implements ParcelableSpan, LeadingMarginSpan
{
  private static final int BULLET_CHAR_MARGIN = 6;
  public static final int GRAPHIC_BULLET_SPAN = -1;
  public static final int GRAP_WIDTH = 24;
  public static final int SPAN_TYPE_ID = 10000;
  public static final int STANDARD_GAP_WIDTH = 2;
  private final int mColor;
  private final int mGapWidth;
  private int mGroup = 0;
  private int mIndex = 0;
  private int mLevel = 1;
  private final boolean mWantColor;
  
  public QMBulletSpan()
  {
    this.mGapWidth = 2;
    this.mWantColor = false;
    this.mColor = 0;
  }
  
  public QMBulletSpan(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mGapWidth = paramInt1;
    this.mWantColor = false;
    this.mColor = 0;
    this.mGroup = paramInt2;
    this.mLevel = paramInt3;
  }
  
  public QMBulletSpan(Parcel paramParcel)
  {
    this.mGapWidth = paramParcel.readInt();
    if (paramParcel.readInt() != 0) {}
    for (;;)
    {
      this.mWantColor = bool;
      this.mColor = paramParcel.readInt();
      this.mIndex = paramParcel.readInt();
      this.mGroup = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void drawLeadingMargin(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, Layout paramLayout)
  {
    if (((Spanned)paramCharSequence).getSpanStart(this) == paramInt6)
    {
      paramCharSequence = paramPaint.getStyle();
      paramInt2 = 0;
      if (this.mWantColor)
      {
        paramInt2 = paramPaint.getColor();
        paramPaint.setColor(this.mColor);
      }
      if (this.mGroup != -1) {
        break label106;
      }
      paramCanvas.drawCircle(getLeadingMargin(false) + paramInt1 - 6 - 6 - 6, (paramInt3 + paramInt5) / 2.0F, 6.0F, paramPaint);
    }
    for (;;)
    {
      if (this.mWantColor) {
        paramPaint.setColor(paramInt2);
      }
      paramPaint.setStyle(paramCharSequence);
      return;
      label106:
      paramLayout = Integer.toString(this.mIndex) + ".";
      paramInt3 = (int)paramPaint.measureText(paramLayout);
      paramCanvas.save();
      paramCanvas.drawText(paramLayout, getLeadingMargin(false) + paramInt1 + (this.mGapWidth + 12) * (this.mLevel - 1) - 6 - paramInt3, paramInt4, paramPaint);
      paramCanvas.restore();
    }
  }
  
  public int getGroup()
  {
    return this.mGroup;
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    return this.mGapWidth + 12;
  }
  
  public int getSpanTypeId()
  {
    return 10000;
  }
  
  public void setIndex(int paramInt)
  {
    this.mIndex = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mGapWidth);
    if (this.mWantColor) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.mColor);
      paramParcel.writeInt(this.mIndex);
      paramParcel.writeInt(this.mGroup);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.QMBulletSpan
 * JD-Core Version:    0.7.0.1
 */