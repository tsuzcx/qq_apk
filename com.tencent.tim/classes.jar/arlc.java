import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class arlc
{
  private static int ekh;
  
  public static void a(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, new Object[] { "sendWindowVisibleBroadcast:", Boolean.valueOf(paramBoolean), " ,busiType:", Integer.valueOf(paramInt1) });
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_concern_floating_type", paramInt2);
    if (paramBoolean) {}
    for (paramInt2 = 103;; paramInt2 = 102)
    {
      localIntent.putExtra("param_curr_window_status", paramInt2);
      localIntent.putExtra("param_busitype", paramInt1);
      paramContext.sendBroadcast(localIntent);
      return;
    }
  }
  
  public static void aT(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, "sendWindowClosedBroadcast");
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_curr_window_status", 104);
    localIntent.putExtra("param_busitype", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void b(Context paramContext, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, new Object[] { "sendWindowVisibleBroadcast:", Boolean.valueOf(paramBoolean), " ,busiType:", Integer.valueOf(paramInt) });
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    if (paramBoolean) {}
    for (int i = 103;; i = 102)
    {
      localIntent.putExtra("param_curr_window_status", i);
      localIntent.putExtra("param_busitype", paramInt);
      paramContext.sendBroadcast(localIntent);
      return;
    }
  }
  
  public static boolean ck(Context paramContext)
  {
    if (ekh == 0)
    {
      if ((Build.VERSION.SDK_INT < 26) || (Build.VERSION.SDK_INT >= 28) || (!ayxa.hasNotchInScreen_AndroidO(paramContext))) {
        break label56;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FloatingScreenUtils", 2, "AndroidO With Notch in Screen.");
      }
    }
    label56:
    for (ekh = 1; ekh == 1; ekh = 2) {
      return true;
    }
    return false;
  }
  
  @Deprecated
  public static void sendWindowClosedBroadcast(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, "sendWindowClosedBroadcast");
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_curr_window_status", 104);
    paramContext.sendBroadcast(localIntent);
  }
  
  @Deprecated
  public static void sendWindowVisibleBroadcast(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, new Object[] { "sendWindowVisibleBroadcast:", Boolean.valueOf(paramBoolean) });
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    if (paramBoolean) {}
    for (int i = 103;; i = 102)
    {
      localIntent.putExtra("param_curr_window_status", i);
      paramContext.sendBroadcast(localIntent);
      return;
    }
  }
  
  public static void y(Context paramContext, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, "sendWindowClosedBroadcast");
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_concern_floating_type", paramInt2);
    localIntent.putExtra("param_curr_window_status", 104);
    localIntent.putExtra("param_busitype", paramInt1);
    paramContext.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     arlc
 * JD-Core Version:    0.7.0.1
 */