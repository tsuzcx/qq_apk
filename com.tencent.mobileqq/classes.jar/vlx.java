import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.widget.TextView;

public class vlx
{
  public static int a(Rect[] paramArrayOfRect, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramArrayOfRect == null) || (paramArrayOfRect.length == 0)) {
      i = -1;
    }
    Rect localRect;
    do
    {
      return i;
      localRect = paramArrayOfRect[0];
    } while ((paramInt2 >= 0) && (paramInt2 <= localRect.bottom) && (paramInt1 >= 0) && (paramInt1 <= localRect.right));
    int j = 1;
    for (;;)
    {
      if (j >= paramArrayOfRect.length) {
        break label110;
      }
      localRect = paramArrayOfRect[j];
      if ((paramInt2 >= localRect.top) && (paramInt2 <= localRect.bottom) && (paramInt1 >= localRect.left))
      {
        i = j;
        if (paramInt1 <= localRect.right) {
          break;
        }
      }
      j += 1;
    }
    label110:
    return -1;
  }
  
  public static String a(TextView paramTextView, int paramInt)
  {
    Layout localLayout = paramTextView.getLayout();
    String str = paramTextView.getText().toString();
    paramTextView = str;
    if (localLayout != null)
    {
      paramTextView = str;
      if (localLayout.getLineCount() > paramInt) {
        paramTextView = str.substring(0, localLayout.getLineStart(paramInt));
      }
    }
    return paramTextView;
  }
  
  public static vly a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    return new vmi(paramContext);
  }
  
  public static float[] a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new float[] { (float)(paramFloat1 * Math.cos(paramFloat3 * 3.141592653589793D / 180.0D)) - (float)(paramFloat2 * Math.sin(paramFloat3 * 3.141592653589793D / 180.0D)), (float)(paramFloat1 * Math.sin(paramFloat3 * 3.141592653589793D / 180.0D)) + (float)(paramFloat2 * Math.cos(paramFloat3 * 3.141592653589793D / 180.0D)) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vlx
 * JD-Core Version:    0.7.0.1
 */