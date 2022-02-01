package com.tencent.mobileqq.conditionsearch.data;

public class AddressHelper
{
  public static final String a = "ConditionSearch.AddressHelper";
  
  /* Error */
  public static AddressData a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +11 -> 16
    //   8: ldc 8
    //   10: iconst_2
    //   11: ldc 26
    //   13: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: new 32	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 35	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_2
    //   25: new 37	java/io/BufferedReader
    //   28: dup
    //   29: new 39	java/io/InputStreamReader
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 42	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   37: invokespecial 45	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore 4
    //   42: aconst_null
    //   43: astore_1
    //   44: aload 4
    //   46: invokevirtual 49	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +264 -> 317
    //   56: aload_1
    //   57: ifnonnull +257 -> 314
    //   60: new 51	com/tencent/mobileqq/conditionsearch/data/AddressData
    //   63: dup
    //   64: invokespecial 52	com/tencent/mobileqq/conditionsearch/data/AddressData:<init>	()V
    //   67: astore_1
    //   68: aload_1
    //   69: aload_0
    //   70: aload 5
    //   72: invokevirtual 55	com/tencent/mobileqq/conditionsearch/data/AddressData:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   75: ifne +99 -> 174
    //   78: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +11 -> 92
    //   84: ldc 8
    //   86: iconst_2
    //   87: ldc 57
    //   89: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_1
    //   93: astore_0
    //   94: aload 4
    //   96: invokevirtual 60	java/io/BufferedReader:close	()V
    //   99: aload_2
    //   100: invokevirtual 63	java/io/InputStream:close	()V
    //   103: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +11 -> 117
    //   109: ldc 8
    //   111: iconst_2
    //   112: ldc 65
    //   114: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_0
    //   118: areturn
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_2
    //   122: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +31 -> 156
    //   128: ldc 8
    //   130: iconst_2
    //   131: new 67	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   138: ldc 70
    //   140: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: invokestatic 80	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   147: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: new 85	java/lang/NullPointerException
    //   159: dup
    //   160: invokespecial 86	java/lang/NullPointerException:<init>	()V
    //   163: athrow
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: aload_0
    //   173: athrow
    //   174: goto -130 -> 44
    //   177: astore 5
    //   179: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +32 -> 214
    //   185: ldc 8
    //   187: iconst_2
    //   188: new 67	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   195: ldc 91
    //   197: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 5
    //   202: invokestatic 80	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   205: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: goto -170 -> 44
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   222: goto -119 -> 103
    //   225: astore_0
    //   226: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +31 -> 260
    //   232: ldc 8
    //   234: iconst_2
    //   235: new 67	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   242: ldc 93
    //   244: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_0
    //   248: invokestatic 80	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   251: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload 4
    //   262: invokevirtual 60	java/io/BufferedReader:close	()V
    //   265: aload_2
    //   266: invokevirtual 63	java/io/InputStream:close	()V
    //   269: aload_3
    //   270: astore_0
    //   271: goto -168 -> 103
    //   274: astore_0
    //   275: aload_0
    //   276: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   279: aload_3
    //   280: astore_0
    //   281: goto -178 -> 103
    //   284: astore_0
    //   285: aload 4
    //   287: invokevirtual 60	java/io/BufferedReader:close	()V
    //   290: aload_2
    //   291: invokevirtual 63	java/io/InputStream:close	()V
    //   294: aload_0
    //   295: athrow
    //   296: astore_1
    //   297: aload_1
    //   298: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   301: goto -7 -> 294
    //   304: astore_1
    //   305: aload_2
    //   306: astore_0
    //   307: aload_0
    //   308: astore_2
    //   309: aload_1
    //   310: astore_0
    //   311: goto -189 -> 122
    //   314: goto -246 -> 68
    //   317: aload_1
    //   318: astore_0
    //   319: goto -225 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	322	1	paramFile	java.io.File
    //   24	285	2	localObject1	Object
    //   1	279	3	localObject2	Object
    //   40	246	4	localBufferedReader	java.io.BufferedReader
    //   49	22	5	str	String
    //   177	24	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   16	25	119	java/io/IOException
    //   156	164	164	java/lang/Exception
    //   16	25	171	finally
    //   25	42	171	finally
    //   122	156	171	finally
    //   68	92	177	java/lang/Exception
    //   94	103	217	java/lang/Exception
    //   44	51	225	java/lang/Exception
    //   60	68	225	java/lang/Exception
    //   179	214	225	java/lang/Exception
    //   260	269	274	java/lang/Exception
    //   44	51	284	finally
    //   60	68	284	finally
    //   68	92	284	finally
    //   179	214	284	finally
    //   226	260	284	finally
    //   285	294	296	java/lang/Exception
    //   25	42	304	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.data.AddressHelper
 * JD-Core Version:    0.7.0.1
 */