package com.tencent.qqmail.ftn.request;

import com.tencent.qqmail.ftn.callback.FileSignCallback;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.io.File;

public class FileSignRequest
  implements FtnRequest, Runnable
{
  private static final String TAG = "FileSignTask";
  private boolean isRunning;
  private boolean mAbort;
  private final FileSignCallback mCallback;
  private final FtnUploadInfo mUploadItemData;
  
  public FileSignRequest(FtnUploadInfo paramFtnUploadInfo, FileSignCallback paramFileSignCallback)
  {
    ValidateHelper.notNull(paramFtnUploadInfo);
    ValidateHelper.notNull(paramFileSignCallback);
    this.mUploadItemData = paramFtnUploadInfo;
    this.mCallback = paramFileSignCallback;
    this.mAbort = true;
    this.isRunning = false;
    if (paramFtnUploadInfo.getFileSize() > 0L) {
      goOn();
    }
  }
  
  /* Error */
  private String calculateDigest(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 36	com/tencent/qqmail/ftn/request/FileSignRequest:mAbort	Z
    //   7: ifeq +8 -> 15
    //   10: aload 7
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: sipush 8192
    //   18: newarray byte
    //   20: astore 6
    //   22: new 56	java/io/FileInputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 59	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore 5
    //   32: aload 5
    //   34: astore_1
    //   35: aload_2
    //   36: invokestatic 65	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   39: astore_2
    //   40: aload 5
    //   42: astore_1
    //   43: aload 5
    //   45: aload 6
    //   47: invokevirtual 69	java/io/FileInputStream:read	([B)I
    //   50: istore_3
    //   51: iload_3
    //   52: ifle +57 -> 109
    //   55: aload 5
    //   57: astore_1
    //   58: aload_2
    //   59: aload 6
    //   61: iconst_0
    //   62: iload_3
    //   63: invokevirtual 73	java/security/MessageDigest:update	([BII)V
    //   66: aload 5
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 36	com/tencent/qqmail/ftn/request/FileSignRequest:mAbort	Z
    //   73: istore 4
    //   75: iload 4
    //   77: ifeq -37 -> 40
    //   80: aload 7
    //   82: astore_1
    //   83: aload 5
    //   85: ifnull -72 -> 13
    //   88: aload 5
    //   90: invokevirtual 76	java/io/FileInputStream:close	()V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_1
    //   96: bipush 6
    //   98: ldc 12
    //   100: aload_1
    //   101: invokestatic 82	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   104: invokestatic 88	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   107: aconst_null
    //   108: areturn
    //   109: aload 5
    //   111: astore_1
    //   112: new 90	java/math/BigInteger
    //   115: dup
    //   116: iconst_1
    //   117: aload_2
    //   118: invokevirtual 94	java/security/MessageDigest:digest	()[B
    //   121: invokespecial 97	java/math/BigInteger:<init>	(I[B)V
    //   124: bipush 16
    //   126: invokevirtual 101	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   129: astore_2
    //   130: aload_2
    //   131: astore_1
    //   132: aload 5
    //   134: ifnull -121 -> 13
    //   137: aload 5
    //   139: invokevirtual 76	java/io/FileInputStream:close	()V
    //   142: aload_2
    //   143: areturn
    //   144: astore_1
    //   145: bipush 6
    //   147: ldc 12
    //   149: aload_1
    //   150: invokestatic 82	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   153: invokestatic 88	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   156: aload_2
    //   157: areturn
    //   158: astore 6
    //   160: aconst_null
    //   161: astore_2
    //   162: aload_2
    //   163: astore_1
    //   164: bipush 6
    //   166: ldc 12
    //   168: aload 6
    //   170: invokestatic 82	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   173: invokestatic 88	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   176: aload 7
    //   178: astore_1
    //   179: aload_2
    //   180: ifnull -167 -> 13
    //   183: aload_2
    //   184: invokevirtual 76	java/io/FileInputStream:close	()V
    //   187: aconst_null
    //   188: areturn
    //   189: astore_1
    //   190: bipush 6
    //   192: ldc 12
    //   194: aload_1
    //   195: invokestatic 82	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   198: invokestatic 88	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   201: aconst_null
    //   202: areturn
    //   203: astore_2
    //   204: aconst_null
    //   205: astore_1
    //   206: aload_1
    //   207: ifnull +7 -> 214
    //   210: aload_1
    //   211: invokevirtual 76	java/io/FileInputStream:close	()V
    //   214: aload_2
    //   215: athrow
    //   216: astore_1
    //   217: bipush 6
    //   219: ldc 12
    //   221: aload_1
    //   222: invokestatic 82	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   225: invokestatic 88	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   228: goto -14 -> 214
    //   231: astore_2
    //   232: goto -26 -> 206
    //   235: astore 6
    //   237: aload 5
    //   239: astore_2
    //   240: goto -78 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	FileSignRequest
    //   0	243	1	paramFile	File
    //   0	243	2	paramString	String
    //   50	13	3	i	int
    //   73	3	4	bool	boolean
    //   30	208	5	localFileInputStream	java.io.FileInputStream
    //   20	40	6	arrayOfByte	byte[]
    //   158	11	6	localException1	java.lang.Exception
    //   235	1	6	localException2	java.lang.Exception
    //   1	176	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   88	93	95	java/io/IOException
    //   137	142	144	java/io/IOException
    //   22	32	158	java/lang/Exception
    //   183	187	189	java/io/IOException
    //   22	32	203	finally
    //   210	214	216	java/io/IOException
    //   35	40	231	finally
    //   43	51	231	finally
    //   58	66	231	finally
    //   69	75	231	finally
    //   112	130	231	finally
    //   164	176	231	finally
    //   35	40	235	java/lang/Exception
    //   43	51	235	java/lang/Exception
    //   58	66	235	java/lang/Exception
    //   69	75	235	java/lang/Exception
    //   112	130	235	java/lang/Exception
  }
  
  private String tryToFixSha(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    int j = paramString.length();
    String str = "";
    int i = 0;
    while (i < 40 - j)
    {
      str = str + "0";
      i += 1;
    }
    return str + paramString;
  }
  
  public void abort()
  {
    this.mAbort = true;
  }
  
  public void goOn()
  {
    if (this.mAbort) {}
    try
    {
      if (!this.isRunning)
      {
        Thread localThread = new Thread(this);
        localThread.setPriority(3);
        this.isRunning = true;
        localThread.start();
      }
      this.mAbort = false;
      return;
    }
    finally {}
  }
  
  public boolean isAborted()
  {
    return this.mAbort;
  }
  
  public void run()
  {
    Object localObject = new File(this.mUploadItemData.getAbsolutePath());
    if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
      return;
    }
    String str = calculateDigest((File)localObject, "MD5");
    localObject = tryToFixSha(calculateDigest((File)localObject, "SHA-1"));
    if ((str != null) && (localObject != null))
    {
      this.mUploadItemData.setMd5(str);
      this.mUploadItemData.setSha((String)localObject);
      this.mCallback.onSuccess(this.mUploadItemData);
    }
    for (;;)
    {
      this.isRunning = false;
      return;
      this.mCallback.onError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.request.FileSignRequest
 * JD-Core Version:    0.7.0.1
 */