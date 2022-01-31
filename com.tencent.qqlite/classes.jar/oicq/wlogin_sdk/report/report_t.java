package oicq.wlogin_sdk.report;

import android.content.Context;
import java.io.Serializable;

public class report_t
  implements Serializable
{
  public static String FILE_NAME = "report_data";
  private static final long serialVersionUID = 1L;
  
  public static void delete_file(Context paramContext)
  {
    try
    {
      paramContext.deleteFile(FILE_NAME);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public static report_t1 read_fromfile(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getstatic 18	oicq/wlogin_sdk/report/report_t:FILE_NAME	Ljava/lang/String;
    //   7: invokevirtual 38	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   10: astore_1
    //   11: new 40	java/io/ObjectInputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 43	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 47	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   24: checkcast 49	oicq/wlogin_sdk/report/report_t1
    //   27: astore_0
    //   28: aload_2
    //   29: invokevirtual 52	java/io/ObjectInputStream:close	()V
    //   32: aload_1
    //   33: invokevirtual 55	java/io/FileInputStream:close	()V
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: areturn
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_0
    //   50: goto -14 -> 36
    //   53: astore_1
    //   54: goto -18 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramContext	Context
    //   10	23	1	localFileInputStream	java.io.FileInputStream
    //   53	1	1	localException	java.lang.Exception
    //   19	10	2	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   3	28	41	finally
    //   28	36	41	finally
    //   3	28	47	java/lang/Exception
    //   28	36	53	java/lang/Exception
  }
  
  /* Error */
  public static int write_tofile(report_t1 paramreport_t1, Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_1
    //   6: getstatic 18	oicq/wlogin_sdk/report/report_t:FILE_NAME	Ljava/lang/String;
    //   9: iconst_0
    //   10: invokevirtual 61	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   13: astore_1
    //   14: new 63	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 66	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_3
    //   23: aload_3
    //   24: aload_0
    //   25: invokevirtual 70	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   28: aload_3
    //   29: invokevirtual 73	java/io/ObjectOutputStream:flush	()V
    //   32: aload_3
    //   33: invokevirtual 74	java/io/ObjectOutputStream:close	()V
    //   36: aload_1
    //   37: invokevirtual 77	java/io/FileOutputStream:close	()V
    //   40: ldc 2
    //   42: monitorexit
    //   43: iload_2
    //   44: ireturn
    //   45: astore_0
    //   46: iconst_m1
    //   47: istore_2
    //   48: goto -8 -> 40
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramreport_t1	report_t1
    //   0	57	1	paramContext	Context
    //   1	47	2	i	int
    //   22	11	3	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   5	40	45	java/lang/Exception
    //   5	40	51	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.report_t
 * JD-Core Version:    0.7.0.1
 */