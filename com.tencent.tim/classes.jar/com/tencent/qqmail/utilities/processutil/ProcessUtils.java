package com.tencent.qqmail.utilities.processutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class ProcessUtils
{
  public static final String FIX_PROCESS_NAME = ":Fix";
  public static final String PUSH_PROCESS_NAME = ":Push";
  private static String TAG = "ProcessUtils";
  public static final String TIM_MAIL = ":mail";
  public static final String TOOLS_PROCESS_NAME = ":Tools";
  public static final String UNINSTALL_WATCH_PROCESS_NAME = ":Uninstall";
  
  /* Error */
  public static String getFdSize()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 41	android/os/Process:myPid	()I
    //   5: istore_0
    //   6: new 43	java/io/BufferedReader
    //   9: dup
    //   10: new 45	java/io/InputStreamReader
    //   13: dup
    //   14: new 47	java/io/FileInputStream
    //   17: dup
    //   18: new 49	java/io/File
    //   21: dup
    //   22: new 51	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   29: ldc 54
    //   31: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_0
    //   35: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc 63
    //   40: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: invokespecial 72	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: invokespecial 75	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   55: invokespecial 78	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: astore_2
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: invokevirtual 81	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull +14 -> 81
    //   70: aload_2
    //   71: astore_1
    //   72: aload_3
    //   73: ldc 83
    //   75: invokevirtual 89	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   78: ifeq -19 -> 59
    //   81: aload_2
    //   82: astore_1
    //   83: iconst_4
    //   84: getstatic 27	com/tencent/qqmail/utilities/processutil/ProcessUtils:TAG	Ljava/lang/String;
    //   87: new 51	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   94: ldc 91
    //   96: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: iload_0
    //   100: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: ldc 93
    //   105: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_3
    //   109: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 99	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   118: aload_2
    //   119: ifnull +7 -> 126
    //   122: aload_2
    //   123: invokevirtual 102	java/io/BufferedReader:close	()V
    //   126: aload_3
    //   127: areturn
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   133: aload_3
    //   134: areturn
    //   135: astore_3
    //   136: aconst_null
    //   137: astore_2
    //   138: aload_2
    //   139: astore_1
    //   140: aload_3
    //   141: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 102	java/io/BufferedReader:close	()V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   159: goto -7 -> 152
    //   162: astore_3
    //   163: aload_1
    //   164: astore_2
    //   165: aload_3
    //   166: astore_1
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 102	java/io/BufferedReader:close	()V
    //   175: aload_1
    //   176: athrow
    //   177: astore_2
    //   178: aload_2
    //   179: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   182: goto -7 -> 175
    //   185: astore_3
    //   186: aload_1
    //   187: astore_2
    //   188: aload_3
    //   189: astore_1
    //   190: goto -23 -> 167
    //   193: astore_3
    //   194: goto -56 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	95	0	i	int
    //   1	82	1	localObject1	Object
    //   128	2	1	localIOException1	java.io.IOException
    //   139	1	1	localObject2	Object
    //   154	10	1	localIOException2	java.io.IOException
    //   166	24	1	localObject3	Object
    //   58	114	2	localObject4	Object
    //   177	2	2	localIOException3	java.io.IOException
    //   187	1	2	localObject5	Object
    //   65	69	3	str	String
    //   135	6	3	localIOException4	java.io.IOException
    //   162	4	3	localObject6	Object
    //   185	4	3	localObject7	Object
    //   193	1	3	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   122	126	128	java/io/IOException
    //   6	59	135	java/io/IOException
    //   148	152	154	java/io/IOException
    //   6	59	162	finally
    //   171	175	177	java/io/IOException
    //   61	66	185	finally
    //   72	81	185	finally
    //   83	118	185	finally
    //   140	144	185	finally
    //   61	66	193	java/io/IOException
    //   72	81	193	java/io/IOException
    //   83	118	193	java/io/IOException
  }
  
  public static ActivityManager.RunningAppProcessInfo getProcessInfo(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    int i = android.os.Process.myPid();
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i) {
          return localRunningAppProcessInfo;
        }
      }
    }
    return null;
  }
  
  public static String getProcessName(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    int i = android.os.Process.myPid();
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i) {
          return localRunningAppProcessInfo.processName;
        }
      }
    }
    return null;
  }
  
  public static boolean isProcessExist(String paramString)
  {
    boolean bool2;
    if ((paramString == null) || (paramString.equals("")))
    {
      bool2 = false;
      return bool2;
    }
    for (;;)
    {
      try
      {
        Object localObject = Runtime.getRuntime().exec("ps");
        if (localObject == null) {
          break label192;
        }
        localObject = new BufferedReader(new InputStreamReader(((java.lang.Process)localObject).getInputStream()));
        String str = ((BufferedReader)localObject).readLine();
        if (str != null)
        {
          if (!str.contains(paramString)) {
            continue;
          }
          QMLog.log(4, TAG, "isProcessExist. " + paramString + " exist");
          bool1 = true;
          ((BufferedReader)localObject).close();
          bool2 = bool1;
          if (bool1) {
            break;
          }
          QMLog.log(4, TAG, "isProcessExist. " + paramString + " not exist!");
          return bool1;
        }
      }
      catch (Exception localException)
      {
        QMLog.log(6, TAG, "isProcessExist byname err:" + localException.toString() + ",pname:" + paramString);
        return false;
      }
      boolean bool1 = false;
      continue;
      label192:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.processutil.ProcessUtils
 * JD-Core Version:    0.7.0.1
 */