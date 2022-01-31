package btmsdkobf;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class dm
{
  /* Error */
  public static PendingIntent a(Context paramContext, String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 10
    //   2: new 12	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   9: ldc 18
    //   11: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 24
    //   20: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_2
    //   24: ldc2_w 25
    //   27: ldiv
    //   28: invokevirtual 29	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   31: ldc 31
    //   33: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 41	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: new 43	android/content/Intent
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 46	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload_1
    //   52: invokestatic 52	btmsdkobf/bc:n	()Landroid/content/Context;
    //   55: invokevirtual 57	android/content/Context:getPackageName	()Ljava/lang/String;
    //   58: invokevirtual 61	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   61: pop
    //   62: aload_0
    //   63: iconst_0
    //   64: aload_1
    //   65: iconst_0
    //   66: invokestatic 67	android/app/PendingIntent:getBroadcast	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   69: astore_1
    //   70: aload_0
    //   71: ldc 69
    //   73: invokevirtual 73	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   76: checkcast 75	android/app/AlarmManager
    //   79: iconst_0
    //   80: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   83: lload_2
    //   84: ladd
    //   85: aload_1
    //   86: invokevirtual 85	android/app/AlarmManager:set	(IJLandroid/app/PendingIntent;)V
    //   89: aload_1
    //   90: areturn
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_0
    //   94: ldc 10
    //   96: new 12	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   103: ldc 87
    //   105: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_1
    //   109: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 93	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: areturn
    //   120: astore 4
    //   122: aload_1
    //   123: astore_0
    //   124: aload 4
    //   126: astore_1
    //   127: goto -33 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramContext	Context
    //   0	130	1	paramString	String
    //   0	130	2	paramLong	long
    //   120	5	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   42	70	91	java/lang/Throwable
    //   70	89	120	java/lang/Throwable
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      paramString = new Intent(paramString);
      paramString.setPackage(bc.n().getPackageName());
      paramString = PendingIntent.getBroadcast(paramContext, 0, paramString, 0);
      ((AlarmManager)paramContext.getSystemService("alarm")).cancel(paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      eh.h("AlarmerUtil", "delAlarm exception: " + paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dm
 * JD-Core Version:    0.7.0.1
 */