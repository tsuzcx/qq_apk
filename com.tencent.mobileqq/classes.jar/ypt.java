import android.content.Context;
import android.text.Layout;
import android.widget.TextView;

public class ypt
{
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
  
  public static ypu a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    return new yqe(paramContext);
  }
  
  public static float[] a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new float[] { (float)(paramFloat1 * Math.cos(paramFloat3 * 3.141592653589793D / 180.0D)) - (float)(paramFloat2 * Math.sin(paramFloat3 * 3.141592653589793D / 180.0D)), (float)(paramFloat1 * Math.sin(paramFloat3 * 3.141592653589793D / 180.0D)) + (float)(paramFloat2 * Math.cos(paramFloat3 * 3.141592653589793D / 180.0D)) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypt
 * JD-Core Version:    0.7.0.1
 */