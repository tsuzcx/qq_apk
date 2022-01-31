package taiji;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class bw
  extends bu
{
  private int f;
  private int g;
  
  bw(Context paramContext)
  {
    super(paramContext);
    try
    {
      this.f = this.d;
      paramContext = AppOpsManager.class.getField("MODE_ASK");
      paramContext.setAccessible(true);
      this.g = paramContext.getInt(AppOpsManager.class);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  @TargetApi(19)
  private int a(String paramString)
  {
    if ((Build.VERSION.SDK_INT < 19) || (this.a == null) || (this.b == null) || (this.c == null)) {
      return 0;
    }
    try
    {
      paramString = AppOpsManager.class.getField(paramString);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        int i = paramString.getInt(AppOpsManager.class);
        i = ((Integer)this.c.invoke(this.b, new Object[] { Integer.valueOf(i), Integer.valueOf(Process.myUid()), this.a.getPackageName() })).intValue();
        if (i == this.g) {
          return 1;
        }
        int j = this.f;
        if (i != j) {
          return -1;
        }
      }
    }
    catch (Throwable paramString)
    {
      return 0;
    }
    return 0;
  }
  
  public int checkPermission(int paramInt)
  {
    int j = 0;
    if (Build.VERSION.SDK_INT < 19) {
      return 0;
    }
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 25: 
    case 33: 
    case 34: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      return i;
      i = a("OP_READ_PHONE_STATE");
      break;
      i = a("OP_WRITE_EXTERNAL_STORAGE");
      break;
      i = a("OP_PROCESS_OUTGOING_CALLS");
      break;
      i = a("OP_CALL_PHONE");
      break;
      i = a("OP_READ_CALL_LOG");
      break;
      i = a("OP_WRITE_CALL_LOG");
      break;
      i = a("OP_READ_SMS");
      break;
      i = a("OP_WRITE_SMS");
      break;
      i = a("OP_SEND_SMS");
      break;
      i = a("OP_READ_NOTIFICATION_SMS");
      break;
      i = a("OP_READ_MMS");
      break;
      i = a("OP_WRITE_MMS");
      break;
      i = a("OP_SEND_MMS");
      break;
      i = a("OP_READ_CONTACTS");
      break;
      i = a("OP_WRITE_CONTACTS");
      break;
      i = a("OP_DELETE_CONTACTS");
      break;
      i = a("OP_FINE_LOCATION");
      break;
      i = a("OP_INSTALL_SHORTCUT");
      break;
      i = a("OP_READ_CALENDAR");
      break;
      i = a("OP_WRITE_CALENDAR");
      break;
      i = a("OP_CAMERA");
      break;
      i = a("OP_RECORD_AUDIO");
      break;
      i = a("OP_WRITE_SETTINGS");
      break;
      i = a("OP_GET_ACCOUNTS");
      break;
      i = a("OP_BLUETOOTH_CHANGE");
      break;
      return a("OP_AUTO_START");
      return a("OP_SHOW_WHEN_LOCKED");
      return a("OP_BACKGROUND_START_ACTIVITY");
      return super.checkPermission(paramInt);
    } while (super.checkPermission(paramInt) != -1);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bw
 * JD-Core Version:    0.7.0.1
 */