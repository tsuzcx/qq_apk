import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.qphone.base.util.QLog;

public class alij
{
  public static boolean cxi;
  
  /* Error */
  public static boolean X(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: invokestatic 16	imm:getCpuArchitecture	()I
    //   6: istore_2
    //   7: invokestatic 20	alij:xY	()Ljava/lang/String;
    //   10: astore 7
    //   12: ldc 22
    //   14: astore 6
    //   16: iload_2
    //   17: iconst_2
    //   18: if_icmple +34 -> 52
    //   21: new 24	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   28: aload 7
    //   30: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 34
    //   35: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 36
    //   44: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 6
    //   52: ldc 41
    //   54: monitorenter
    //   55: new 43	java/io/File
    //   58: dup
    //   59: aload 6
    //   61: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: invokevirtual 50	java/io/File:exists	()Z
    //   67: istore_3
    //   68: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +38 -> 109
    //   74: ldc 41
    //   76: iconst_2
    //   77: new 24	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   84: ldc 57
    //   86: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 6
    //   91: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 59
    //   96: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: iload_3
    //   100: invokevirtual 62	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   103: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_1
    //   110: ldc 68
    //   112: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: istore 5
    //   117: iload 5
    //   119: ifeq +5 -> 124
    //   122: iconst_0
    //   123: istore_3
    //   124: iload_3
    //   125: ifeq +116 -> 241
    //   128: aload 6
    //   130: invokestatic 79	java/lang/System:load	(Ljava/lang/String;)V
    //   133: iconst_1
    //   134: putstatic 81	alij:cxi	Z
    //   137: iload 4
    //   139: istore_3
    //   140: ldc 41
    //   142: monitorexit
    //   143: getstatic 81	alij:cxi	Z
    //   146: aload_1
    //   147: invokestatic 87	aomq:aM	(ZLjava/lang/String;)V
    //   150: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +40 -> 193
    //   156: ldc 41
    //   158: iconst_2
    //   159: new 24	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   166: ldc 89
    //   168: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 6
    //   173: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 91
    //   178: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: getstatic 81	alij:cxi	Z
    //   184: invokevirtual 62	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   187: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iload_3
    //   194: ireturn
    //   195: astore 7
    //   197: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +32 -> 232
    //   203: ldc 41
    //   205: iconst_2
    //   206: new 24	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   213: ldc 93
    //   215: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 7
    //   220: invokevirtual 96	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   223: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aload_0
    //   233: aload_1
    //   234: invokestatic 101	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   237: istore_3
    //   238: goto -98 -> 140
    //   241: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +11 -> 255
    //   247: ldc 41
    //   249: iconst_2
    //   250: ldc 103
    //   252: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_0
    //   256: aload_1
    //   257: invokestatic 101	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   260: istore_3
    //   261: goto -121 -> 140
    //   264: astore_0
    //   265: ldc 41
    //   267: monitorexit
    //   268: aload_0
    //   269: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramContext	android.content.Context
    //   0	270	1	paramString	String
    //   6	13	2	i	int
    //   67	194	3	bool1	boolean
    //   1	137	4	bool2	boolean
    //   115	3	5	bool3	boolean
    //   14	158	6	str1	String
    //   10	19	7	str2	String
    //   195	24	7	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   128	137	195	java/lang/UnsatisfiedLinkError
    //   55	109	264	finally
    //   109	117	264	finally
    //   128	137	264	finally
    //   140	143	264	finally
    //   197	232	264	finally
    //   232	238	264	finally
    //   241	255	264	finally
    //   255	261	264	finally
    //   265	268	264	finally
  }
  
  public static String xX()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplicationImpl.sApplication);
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return str + "/UnCompressPttSoTemp/";
  }
  
  public static String xY()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplicationImpl.sApplication);
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return str + "/txPttlib/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alij
 * JD-Core Version:    0.7.0.1
 */