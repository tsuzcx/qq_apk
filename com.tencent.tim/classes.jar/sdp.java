import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import java.util.HashMap;
import java.util.regex.Pattern;

public class sdp
{
  public static final Pattern A = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b", 2);
  public static final short[] a;
  public static String aDL = ".gif";
  public static HashMap<Integer, Bitmap> fH = new HashMap();
  
  static
  {
    a = new short[] { 13, 12, 56, 73, 88, 87, 97, 59, 33, 5, 9, 82, 51, 53, 106, 72, 92, 112, 74, 2, 6, 4, 54, 14, 11, 10, 55, 96, 36, 116, 75, 76, 50, 0, 81, 8, 109, 57, 27, 85, 1, 108, 79, 3, 103, 62, 101, 21, 105, 83, 58, 111, 46, 47, 71, 95, 118, 34, 64, 38, 32, 113, 117, 119, 124, 122, 63, 89, 45, 16, 93, 25, 121, 120, 37, 42, 39, 29, 86, 129, 91, 77, 78, 80, 84, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 23, 26, 125, 196, 127, 128, 130, 131, 132, 133, 134, 7 };
  }
  
  public static Drawable a(int paramInt, float paramFloat, Context paramContext, Drawable.Callback paramCallback)
  {
    int i = (int)(22.0D * paramFloat + 0.5D);
    try
    {
      paramInt = sdy.eA[paramInt];
      paramContext = paramContext.getResources().getDrawable(paramInt);
      paramContext.setBounds(0, 0, i, i);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder)
  {
    try
    {
      if (TextUtils.isEmpty(paramSpannableStringBuilder)) {
        return;
      }
      float f = paramContext.getResources().getDisplayMetrics().density;
      String str = paramSpannableStringBuilder.toString();
      int i = 0;
      while (i < sdy.EMO_FAST_SYMBOL.length)
      {
        for (int j = str.indexOf(sdy.EMO_FAST_SYMBOL[i]); j >= 0; j = str.indexOf(sdy.EMO_FAST_SYMBOL[i], j + sdy.EMO_FAST_SYMBOL[i].length())) {
          paramSpannableStringBuilder.setSpan(new VerticalCenterImageSpan(a(i, f, paramContext, null), 0), j, sdy.EMO_FAST_SYMBOL[i].length() + j, 33);
        }
        i += 1;
      }
      return;
    }
    catch (OutOfMemoryError paramContext) {}
  }
  
  public static Drawable b(int paramInt, float paramFloat, Context paramContext, Drawable.Callback paramCallback)
  {
    int i = (int)(22.0D * paramFloat + 0.5D);
    try
    {
      paramInt = sdy.ez[paramInt];
      paramContext = paramContext.getResources().getDrawable(paramInt);
      paramContext.setBounds(0, 0, i, i);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdp
 * JD-Core Version:    0.7.0.1
 */