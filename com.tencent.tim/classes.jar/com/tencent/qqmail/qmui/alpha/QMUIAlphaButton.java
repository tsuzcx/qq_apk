package com.tencent.qqmail.qmui.alpha;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

public class QMUIAlphaButton
  extends TextView
{
  private static final float sDisabledAlpha = 0.5F;
  private static final float sNormalAlpha = 1.0F;
  private static final float sPressedAlpha = 0.6F;
  
  public QMUIAlphaButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMUIAlphaButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QMUIAlphaButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static QMUIAlphaButton generateRegularBtn(Context paramContext)
  {
    QMUIAlphaButton localQMUIAlphaButton = new QMUIAlphaButton(paramContext);
    localQMUIAlphaButton.setMinHeight(paramContext.getResources().getDimensionPixelSize(2131298515));
    localQMUIAlphaButton.setMinWidth(paramContext.getResources().getDimensionPixelSize(2131298516));
    localQMUIAlphaButton.setMinimumWidth(paramContext.getResources().getDimensionPixelSize(2131298516));
    localQMUIAlphaButton.setMinimumHeight(paramContext.getResources().getDimensionPixelSize(2131298515));
    localQMUIAlphaButton.setGravity(17);
    localQMUIAlphaButton.setPadding(paramContext.getResources().getDimensionPixelSize(2131298517), 0, paramContext.getResources().getDimensionPixelSize(2131298517), 0);
    localQMUIAlphaButton.setClickable(true);
    localQMUIAlphaButton.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131298518));
    localQMUIAlphaButton.setTextColor(ContextCompat.getColorStateList(paramContext, 2131167190));
    return localQMUIAlphaButton;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.5F)
    {
      setAlpha(f);
      return;
    }
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    if (isEnabled()) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (float f = 0.6F;; f = 1.0F)
    {
      setAlpha(f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.alpha.QMUIAlphaButton
 * JD-Core Version:    0.7.0.1
 */