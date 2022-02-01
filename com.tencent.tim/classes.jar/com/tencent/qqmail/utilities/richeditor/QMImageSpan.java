package com.tencent.qqmail.utilities.richeditor;

import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.widget.TextView;

public class QMImageSpan
  extends ImageSpan
{
  private Drawable mDrawable = null;
  private final TextView mTextView;
  
  public QMImageSpan(TextView paramTextView, String paramString, int paramInt)
  {
    super((Drawable)null, paramString, paramInt);
    this.mTextView = paramTextView;
  }
  
  public Drawable getDrawable()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.QMImageSpan
 * JD-Core Version:    0.7.0.1
 */