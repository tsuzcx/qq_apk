package com.tencent.qqmail.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class QMTopCropImageView
  extends ImageView
{
  public QMTopCropImageView(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Matrix localMatrix;
    int i;
    int j;
    int k;
    int m;
    if (getDrawable() != null)
    {
      localMatrix = getImageMatrix();
      i = paramInt3 - paramInt1;
      j = paramInt2 - paramInt4;
      k = getDrawable().getIntrinsicWidth();
      m = getDrawable().getIntrinsicHeight();
      if (k * j <= m * i) {
        break label89;
      }
    }
    label89:
    for (float f = j / m;; f = i / k)
    {
      localMatrix.setScale(f, f);
      setImageMatrix(localMatrix);
      return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMTopCropImageView
 * JD-Core Version:    0.7.0.1
 */