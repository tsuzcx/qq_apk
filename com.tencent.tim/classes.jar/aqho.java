import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class aqho
{
  @SuppressLint({"NewApi"})
  public static int O(Context paramContext)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      i = ((ActivityManager)paramContext.getSystemService("activity")).getLauncherLargeIconSize();
    }
    int j = (int)paramContext.getResources().getDimension(17104896);
    if (QLog.isColorLevel()) {
      QLog.d("DisplayUtils", 2, "launcher icon size = " + i + " , app icon size = " + j);
    }
    return Math.max(i, j);
  }
  
  public static int a(TextView paramTextView, int paramInt)
  {
    if ((paramTextView != null) && (paramTextView.getText() != null) && (paramInt > 0))
    {
      TextPaint localTextPaint = paramTextView.getPaint();
      return new StaticLayout(paramTextView.getText().toString(), localTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).getLineCount();
    }
    return -1;
  }
  
  public static float convertDpToPixel(Context paramContext, float paramFloat)
  {
    return paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqho
 * JD-Core Version:    0.7.0.1
 */