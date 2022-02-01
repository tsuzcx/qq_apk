import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Paint;
import android.os.PowerManager;
import android.view.View;
import com.tencent.util.VersionUtils;

@Deprecated
public class aqey
{
  public static int getMemoryClass(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
  }
  
  public static boolean isScreenOn(Context paramContext)
  {
    try
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  @TargetApi(11)
  public static void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    if (VersionUtils.isHoneycomb()) {
      paramView.setLayerType(paramInt, paramPaint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqey
 * JD-Core Version:    0.7.0.1
 */