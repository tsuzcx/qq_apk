package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.widget.TextView;

public class AttachNamesHandlerTextView
  extends TextView
{
  private float endLength;
  private boolean isInited = false;
  private Paint mAttachNamePaint;
  private int mCalcuteCount;
  private float mCalcuteLength;
  private String mCalcuteStr;
  private int mColor = -16777216;
  private String mEnd = "";
  private float mFirstLineBaseLine;
  private float mFourSpaceLength;
  private int mHeight;
  private String[] mMiddle = new String[0];
  private float[] mNameLength = new float[0];
  private float mSecondLineBaseLine;
  private Paint mSideTextPaint;
  private float mSize = 42.0F;
  private String mStart = "";
  private float mThreePointLength;
  private float mTwoCommaLength;
  private boolean mUseFourSpaceEnd = true;
  private int mWidth;
  private int middleTotalCount = 0;
  private float middleTotalLength;
  private String middleTotalString = "";
  private float startLength;
  
  public AttachNamesHandlerTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AttachNamesHandlerTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AttachNamesHandlerTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void calculateBaseLine()
  {
    Paint.FontMetrics localFontMetrics = this.mAttachNamePaint.getFontMetrics();
    float f1 = localFontMetrics.descent;
    float f2 = localFontMetrics.ascent;
    this.mFirstLineBaseLine = (-1.0F * localFontMetrics.ascent);
    this.mSecondLineBaseLine = ((f1 - f2 + 2.0F) * 2.0F - localFontMetrics.descent);
  }
  
  private int calcuteHeightAndSureScheme()
  {
    Paint.FontMetrics localFontMetrics = this.mAttachNamePaint.getFontMetrics();
    float f1 = this.startLength;
    float f2 = this.middleTotalLength;
    f2 = this.endLength + (f1 + f2);
    if (f2 <= this.mWidth)
    {
      this.mCalcuteStr = this.middleTotalString;
      this.mCalcuteCount = this.middleTotalCount;
      this.mCalcuteLength = this.middleTotalLength;
      return (int)(this.mFirstLineBaseLine + localFontMetrics.descent + 2.0F);
    }
    float f3 = this.mWidth * 2;
    if (this.mUseFourSpaceEnd) {}
    for (f1 = this.mFourSpaceLength; f2 <= f3 - f1; f1 = 0.0F)
    {
      this.mCalcuteStr = this.middleTotalString;
      this.mCalcuteCount = this.middleTotalCount;
      this.mCalcuteLength = this.middleTotalLength;
      return (int)(this.mSecondLineBaseLine + localFontMetrics.descent + 2.0F);
    }
    if (this.mUseFourSpaceEnd) {
      f1 = this.mWidth * 2 - this.startLength - this.endLength - this.mTwoCommaLength - this.mFourSpaceLength;
    }
    while (this.mMiddle.length > 1)
    {
      f1 /= this.mMiddle.length;
      localObject = "";
      int i = 0;
      for (;;)
      {
        if (i < this.mMiddle.length)
        {
          String str = (String)localObject + filledAvaiableSpace(this.mMiddle[i], f1);
          localObject = str;
          if (i != this.mMiddle.length - 1) {
            localObject = str + "、";
          }
          i += 1;
          continue;
          f1 = this.mWidth * 2 - this.startLength - this.endLength - this.mTwoCommaLength;
          break;
        }
      }
      this.mCalcuteStr = ((String)localObject);
      this.mCalcuteCount = ((String)localObject).length();
      this.mCalcuteLength = this.mAttachNamePaint.measureText((String)localObject);
      if (this.mAttachNamePaint.measureText((String)localObject) > this.mWidth) {
        return (int)(this.mSecondLineBaseLine + localFontMetrics.descent + 2.0F);
      }
      return (int)(this.mSecondLineBaseLine + localFontMetrics.descent + 2.0F);
    }
    f2 = this.mTwoCommaLength;
    Object localObject = filledAvaiableSpace(this.middleTotalString, f1 + f2);
    this.mCalcuteStr = ((String)localObject);
    this.mCalcuteCount = ((String)localObject).length();
    this.mCalcuteLength = this.mAttachNamePaint.measureText((String)localObject);
    return (int)(this.mSecondLineBaseLine + localFontMetrics.descent + 2.0F);
  }
  
  private String filledAvaiableSpace(String paramString, float paramFloat)
  {
    if (this.mAttachNamePaint.measureText(paramString) < paramFloat) {
      return paramString;
    }
    paramFloat = paramFloat / 2.0F - this.mThreePointLength / 2.0F;
    int i = this.mAttachNamePaint.breakText(paramString, true, paramFloat, null);
    int j = this.mAttachNamePaint.breakText(paramString, false, paramFloat, null);
    return paramString.substring(0, i) + "..." + paramString.substring(paramString.length() - j);
  }
  
  private void init()
  {
    this.mSideTextPaint = new Paint();
    this.mSideTextPaint.setAntiAlias(true);
    this.mAttachNamePaint = new Paint();
    this.mAttachNamePaint.setAntiAlias(true);
    this.mAttachNamePaint.setFakeBoldText(true);
    this.mSize = getTextSize();
    this.mColor = getTextColors().getDefaultColor();
    this.mSideTextPaint.setColor(this.mColor);
    this.mAttachNamePaint.setColor(this.mColor);
    this.mAttachNamePaint.setTextSize(this.mSize);
    this.mSideTextPaint.setTextSize(this.mSize);
    calculateBaseLine();
    this.mTwoCommaLength = this.mAttachNamePaint.measureText("、、");
    this.mThreePointLength = this.mAttachNamePaint.measureText("...");
    this.mFourSpaceLength = this.mAttachNamePaint.measureText("    ");
  }
  
  public int getBaseline()
  {
    return super.getBaseline();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = this.startLength;
    float f2 = this.endLength;
    float f3 = this.mCalcuteLength;
    paramCanvas.drawText(this.mStart, 0, this.mStart.length(), 0.0F, this.mFirstLineBaseLine, this.mSideTextPaint);
    if (f1 + f2 + f3 <= this.mWidth)
    {
      paramCanvas.drawText(this.mCalcuteStr, 0, this.mCalcuteCount, this.startLength, this.mFirstLineBaseLine, this.mAttachNamePaint);
      String str = this.mEnd;
      i = this.mEnd.length();
      f1 = this.mCalcuteLength;
      paramCanvas.drawText(str, 0, i, this.startLength + f1, this.mFirstLineBaseLine, this.mSideTextPaint);
      return;
    }
    if (this.mCalcuteLength <= this.mWidth - this.startLength)
    {
      paramCanvas.drawText(this.mCalcuteStr, 0, this.mCalcuteCount, this.startLength, this.mFirstLineBaseLine, this.mAttachNamePaint);
      i = this.mSideTextPaint.breakText(this.mEnd, true, this.mWidth - this.startLength - this.mCalcuteLength, null);
      paramCanvas.drawText(this.mEnd, 0, i, this.mCalcuteLength + this.startLength, this.mFirstLineBaseLine, this.mSideTextPaint);
      paramCanvas.drawText(this.mEnd, i, this.mEnd.length(), 0.0F, this.mSecondLineBaseLine, this.mSideTextPaint);
      return;
    }
    int i = this.mAttachNamePaint.breakText(this.mCalcuteStr, true, this.mWidth - this.startLength, null);
    paramCanvas.drawText(this.mCalcuteStr, 0, i, this.startLength, this.mFirstLineBaseLine, this.mAttachNamePaint);
    paramCanvas.drawText(this.mCalcuteStr, i, this.mCalcuteCount, 0.0F, this.mSecondLineBaseLine, this.mAttachNamePaint);
    f1 = this.mAttachNamePaint.measureText(this.mCalcuteStr, i, this.mCalcuteCount);
    paramCanvas.drawText(this.mEnd, 0, this.mEnd.length(), f1, this.mSecondLineBaseLine, this.mSideTextPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mWidth = (getMeasuredWidth() - getPaddingRight() - getPaddingLeft());
    this.mHeight = calcuteHeightAndSureScheme();
    setMeasuredDimension(this.mWidth, this.mHeight);
  }
  
  public void setText(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    setText(paramString1, paramArrayOfString, paramString2, true);
  }
  
  public void setText(String paramString1, String[] paramArrayOfString, String paramString2, boolean paramBoolean)
  {
    this.mUseFourSpaceEnd = paramBoolean;
    this.mStart = paramString1;
    this.mMiddle = paramArrayOfString;
    this.mEnd = paramString2;
    this.startLength = this.mSideTextPaint.measureText(this.mStart);
    this.endLength = this.mSideTextPaint.measureText(this.mEnd);
    if (paramArrayOfString.length == 0) {
      throw new Error("传入文件名个数为0，请检查");
    }
    this.mNameLength = new float[paramArrayOfString.length];
    this.middleTotalString = "";
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      this.mNameLength[i] = this.mAttachNamePaint.measureText(this.mMiddle[i]);
      this.middleTotalString += this.mMiddle[i];
      if (i != paramArrayOfString.length - 1) {
        this.middleTotalString += "、";
      }
      i += 1;
    }
    this.middleTotalLength = this.mAttachNamePaint.measureText(this.middleTotalString);
    this.middleTotalCount = this.middleTotalString.length();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.AttachNamesHandlerTextView
 * JD-Core Version:    0.7.0.1
 */