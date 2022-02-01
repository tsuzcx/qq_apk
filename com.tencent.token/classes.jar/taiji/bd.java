package taiji;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class bd
  extends bb
{
  private int f;
  private int g;
  
  bd(Context paramContext)
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
    int k = Build.VERSION.SDK_INT;
    int j = 0;
    int i = j;
    if (k >= 19)
    {
      i = j;
      if (this.a != null)
      {
        i = j;
        if (this.b != null) {
          if (this.c == null) {
            return 0;
          }
        }
      }
    }
    try
    {
      paramString = AppOpsManager.class.getField(paramString);
      i = j;
      if (paramString != null)
      {
        paramString.setAccessible(true);
        i = paramString.getInt(AppOpsManager.class);
        k = ((Integer)this.c.invoke(this.b, new Object[] { Integer.valueOf(i), Integer.valueOf(Process.myUid()), this.a.getPackageName() })).intValue();
        if (k == this.g) {
          return 1;
        }
        int m = this.f;
        i = j;
        if (k != m) {
          i = -1;
        }
      }
      return i;
    }
    catch (Throwable paramString) {}
    return 0;
  }
  
  public int checkPermission(int paramInt)
  {
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if (j < 19) {
      return 0;
    }
    String str;
    if (paramInt != 4) {
      if (paramInt != 35) {
        if (paramInt != 42)
        {
          if (paramInt != 48)
          {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  break;
                case 32: 
                  str = "OP_GET_ACCOUNTS";
                  break;
                case 31: 
                  str = "OP_WRITE_SETTINGS";
                  break;
                case 30: 
                  str = "OP_RECORD_AUDIO";
                  break;
                case 29: 
                  str = "OP_CAMERA";
                  break;
                case 28: 
                  str = "OP_WRITE_CALENDAR";
                  break;
                case 27: 
                  str = "OP_READ_CALENDAR";
                  break;
                case 26: 
                  str = "OP_INSTALL_SHORTCUT";
                }
                break;
              case 24: 
                str = "OP_FINE_LOCATION";
                break;
              case 23: 
                str = "OP_DELETE_CONTACTS";
                break;
              case 22: 
                str = "OP_WRITE_CONTACTS";
                break;
              case 21: 
                str = "OP_READ_CONTACTS";
                break;
              case 20: 
                str = "OP_SEND_MMS";
                break;
              case 19: 
                str = "OP_WRITE_MMS";
                break;
              case 18: 
                str = "OP_READ_MMS";
                break;
              case 17: 
                str = "OP_READ_NOTIFICATION_SMS";
                break;
              case 16: 
                str = "OP_SEND_SMS";
                break;
              case 15: 
                str = "OP_WRITE_SMS";
                break;
              case 14: 
                str = "OP_READ_SMS";
                break;
              case 12: 
              case 13: 
                str = "OP_WRITE_CALL_LOG";
                break;
              case 11: 
                str = "OP_READ_CALL_LOG";
                break;
              case 10: 
                str = "OP_CALL_PHONE";
                break;
              case 9: 
                str = "OP_PROCESS_OUTGOING_CALLS";
              }
              break;
            case 2: 
              str = "OP_WRITE_EXTERNAL_STORAGE";
              break;
            case 1: 
              str = "OP_READ_PHONE_STATE";
            }
            i = a(str);
            break label387;
          }
          str = "OP_BACKGROUND_START_ACTIVITY";
        }
      }
    }
    for (;;)
    {
      return a(str);
      str = "OP_SHOW_WHEN_LOCKED";
      continue;
      str = "OP_BLUETOOTH_CHANGE";
      break;
      switch (i)
      {
      default: 
        return i;
      case 1: 
        if (super.checkPermission(paramInt) == -1) {
          return -1;
        }
        break;
      case 0: 
        label387:
        i = super.checkPermission(paramInt);
      }
      return i;
      str = "OP_AUTO_START";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bd
 * JD-Core Version:    0.7.0.1
 */