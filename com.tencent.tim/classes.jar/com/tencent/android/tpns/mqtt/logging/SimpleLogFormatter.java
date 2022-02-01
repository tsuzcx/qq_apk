package com.tencent.android.tpns.mqtt.logging;

import java.util.logging.Formatter;

public class SimpleLogFormatter
  extends Formatter
{
  private static final String LS = System.getProperty("line.separator");
  
  public static String left(String paramString, int paramInt, char paramChar)
  {
    if (paramString.length() >= paramInt) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramInt);
    localStringBuffer.append(paramString);
    paramInt -= paramString.length();
    for (;;)
    {
      paramInt -= 1;
      if (paramInt < 0) {
        break;
      }
      localStringBuffer.append(paramChar);
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public String format(java.util.logging.LogRecord paramLogRecord)
  {
    // Byte code:
    //   0: new 32	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 51	java/lang/StringBuffer:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: invokevirtual 57	java/util/logging/LogRecord:getLevel	()Ljava/util/logging/Level;
    //   15: invokevirtual 62	java/util/logging/Level:getName	()Ljava/lang/String;
    //   18: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   21: ldc 64
    //   23: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   26: pop
    //   27: aload 4
    //   29: new 66	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   36: ldc 69
    //   38: iconst_1
    //   39: anewarray 71	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: new 73	java/util/Date
    //   47: dup
    //   48: aload_1
    //   49: invokevirtual 77	java/util/logging/LogRecord:getMillis	()J
    //   52: invokespecial 80	java/util/Date:<init>	(J)V
    //   55: aastore
    //   56: invokestatic 85	java/text/MessageFormat:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   59: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 64
    //   64: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   73: pop
    //   74: aload_1
    //   75: invokevirtual 92	java/util/logging/LogRecord:getSourceClassName	()Ljava/lang/String;
    //   78: astore 5
    //   80: ldc 94
    //   82: astore_3
    //   83: aload 5
    //   85: ifnull +27 -> 112
    //   88: aload 5
    //   90: invokevirtual 30	java/lang/String:length	()I
    //   93: istore_2
    //   94: iload_2
    //   95: bipush 20
    //   97: if_icmple +155 -> 252
    //   100: aload_1
    //   101: invokevirtual 92	java/util/logging/LogRecord:getSourceClassName	()Ljava/lang/String;
    //   104: iload_2
    //   105: bipush 19
    //   107: isub
    //   108: invokevirtual 98	java/lang/String:substring	(I)Ljava/lang/String;
    //   111: astore_3
    //   112: aload 4
    //   114: aload_3
    //   115: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   118: ldc 64
    //   120: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   123: ldc 100
    //   125: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   128: pop
    //   129: aload 4
    //   131: aload_1
    //   132: invokevirtual 103	java/util/logging/LogRecord:getSourceMethodName	()Ljava/lang/String;
    //   135: bipush 23
    //   137: bipush 32
    //   139: invokestatic 105	com/tencent/android/tpns/mqtt/logging/SimpleLogFormatter:left	(Ljava/lang/String;IC)Ljava/lang/String;
    //   142: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   145: ldc 64
    //   147: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   150: pop
    //   151: aload 4
    //   153: aload_1
    //   154: invokevirtual 108	java/util/logging/LogRecord:getThreadID	()I
    //   157: invokevirtual 111	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   160: ldc 64
    //   162: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   165: pop
    //   166: aload 4
    //   168: aload_0
    //   169: aload_1
    //   170: invokevirtual 114	com/tencent/android/tpns/mqtt/logging/SimpleLogFormatter:formatMessage	(Ljava/util/logging/LogRecord;)Ljava/lang/String;
    //   173: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   176: getstatic 18	com/tencent/android/tpns/mqtt/logging/SimpleLogFormatter:LS	Ljava/lang/String;
    //   179: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   182: pop
    //   183: aload_1
    //   184: invokevirtual 118	java/util/logging/LogRecord:getThrown	()Ljava/lang/Throwable;
    //   187: ifnull +59 -> 246
    //   190: aload 4
    //   192: ldc 120
    //   194: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   197: pop
    //   198: aload_1
    //   199: invokevirtual 118	java/util/logging/LogRecord:getThrown	()Ljava/lang/Throwable;
    //   202: astore_1
    //   203: new 122	java/io/StringWriter
    //   206: dup
    //   207: invokespecial 123	java/io/StringWriter:<init>	()V
    //   210: astore 5
    //   212: new 125	java/io/PrintWriter
    //   215: dup
    //   216: aload 5
    //   218: invokespecial 128	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   221: astore_3
    //   222: aload_1
    //   223: aload_3
    //   224: invokevirtual 132	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   227: aload 4
    //   229: aload 5
    //   231: invokevirtual 133	java/io/StringWriter:toString	()Ljava/lang/String;
    //   234: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   237: pop
    //   238: aload_3
    //   239: ifnull +7 -> 246
    //   242: aload_3
    //   243: invokevirtual 136	java/io/PrintWriter:close	()V
    //   246: aload 4
    //   248: invokevirtual 46	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   251: areturn
    //   252: new 32	java/lang/StringBuffer
    //   255: dup
    //   256: invokespecial 51	java/lang/StringBuffer:<init>	()V
    //   259: aload 5
    //   261: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   264: iconst_1
    //   265: newarray char
    //   267: dup
    //   268: iconst_0
    //   269: bipush 32
    //   271: castore
    //   272: iconst_0
    //   273: iconst_1
    //   274: invokevirtual 139	java/lang/StringBuffer:append	([CII)Ljava/lang/StringBuffer;
    //   277: invokevirtual 46	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   280: astore_3
    //   281: goto -169 -> 112
    //   284: astore_1
    //   285: aconst_null
    //   286: astore_3
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 136	java/io/PrintWriter:close	()V
    //   295: aload_1
    //   296: athrow
    //   297: astore_1
    //   298: goto -52 -> 246
    //   301: astore_3
    //   302: goto -7 -> 295
    //   305: astore_1
    //   306: goto -19 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	SimpleLogFormatter
    //   0	309	1	paramLogRecord	java.util.logging.LogRecord
    //   93	15	2	i	int
    //   82	210	3	localObject1	java.lang.Object
    //   301	1	3	localThrowable	java.lang.Throwable
    //   7	240	4	localStringBuffer	StringBuffer
    //   78	182	5	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   203	222	284	finally
    //   242	246	297	java/lang/Throwable
    //   291	295	301	java/lang/Throwable
    //   222	238	305	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.logging.SimpleLogFormatter
 * JD-Core Version:    0.7.0.1
 */