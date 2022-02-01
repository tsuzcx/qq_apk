import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class ajin
{
  public static boolean coQ;
  public static int djl = 12;
  
  public static int ax(Context paramContext)
  {
    paramContext = paramContext.getResources();
    return paramContext.getDisplayMetrics().widthPixels - wja.dp2px(42.0F, paramContext) * 2;
  }
  
  public static int s(Context paramContext, int paramInt)
  {
    paramInt /= 5;
    int i = ax(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramContext.heightPixels * 1.0F / paramContext.widthPixels;
    if (QLog.isColorLevel()) {
      QLog.d("VelocityUtil", 2, "getInitVelocity() displayMetrics.widthPixels = " + paramContext.widthPixels + ", displayMetrics.heightPixels = " + paramContext.heightPixels + ", ratio = " + f + ", 16.F/9.F = " + 1.777778F + ",viewPagerClientWidth = " + i);
    }
    if ((f > 1.777778F) && (QLog.isColorLevel())) {
      QLog.d("VelocityUtil", 2, "getInitVelocity() ratio > 16.F/9.F");
    }
    QLog.d("VelocityUtil", 1, "getInitVelocity: pendingVelocity = " + paramInt + ", viewPagerClientWidth = " + i);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajin
 * JD-Core Version:    0.7.0.1
 */