package com.tencent.qqmail.utilities.richeditor;

import android.os.Build.VERSION;
import android.text.Layout;
import android.widget.EditText;

public class EditTextHelper
{
  private static float convertToLocalHorizontalCoordinateOlderSDK(EditText paramEditText, float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - paramEditText.getTotalPaddingLeft());
    return Math.min(paramEditText.getWidth() - paramEditText.getTotalPaddingRight() - 1, paramFloat) + paramEditText.getScrollX();
  }
  
  private static int getLineAtCoordinateOlderSDK(EditText paramEditText, float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - paramEditText.getTotalPaddingTop());
    paramFloat = Math.min(paramEditText.getHeight() - paramEditText.getTotalPaddingBottom() - 1, paramFloat);
    float f = paramEditText.getScrollY();
    return paramEditText.getLayout().getLineForVertical((int)(paramFloat + f));
  }
  
  private static int getOffsetAtCoordinateOlderSDK(EditText paramEditText, int paramInt, float paramFloat)
  {
    paramFloat = convertToLocalHorizontalCoordinateOlderSDK(paramEditText, paramFloat);
    return paramEditText.getLayout().getOffsetForHorizontal(paramInt, paramFloat);
  }
  
  public static int getOffsetForPosition(EditText paramEditText, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT > 13) {
      return paramEditText.getOffsetForPosition(paramFloat1, paramFloat2);
    }
    return getOffsetForPositionOlderSdk(paramEditText, paramFloat1, paramFloat2);
  }
  
  private static int getOffsetForPositionOlderSdk(EditText paramEditText, float paramFloat1, float paramFloat2)
  {
    if (paramEditText.getLayout() == null) {
      return -1;
    }
    return getOffsetAtCoordinateOlderSDK(paramEditText, getLineAtCoordinateOlderSDK(paramEditText, paramFloat2), paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.EditTextHelper
 * JD-Core Version:    0.7.0.1
 */