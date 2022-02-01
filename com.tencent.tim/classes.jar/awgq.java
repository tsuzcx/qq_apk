import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class awgq
{
  protected static String aw(Context paramContext, String paramString)
  {
    paramString = paramString.replace("data:image/jpg;base64,", "").replace("data:image/jpeg;base64,", "").replace("data:image/png;base64,", "");
    paramContext = ax(paramContext, UUID.randomUUID().toString());
    if (TextUtils.isEmpty(paramContext))
    {
      QLog.e("js-upload: QzoneWebUploadInterface", 1, "getTempFilePath return null !");
      return null;
    }
    try
    {
      boolean bool = saveByteBufferToLocalFile(Base64.decode(paramString.getBytes(), 2), paramContext);
      QLog.d("js-upload: QzoneWebUploadInterface", 1, "saveByteBufferToLocalFile ret:" + bool);
      if (bool) {}
      for (;;)
      {
        return paramContext;
        paramContext = null;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      QLog.d("js-upload: QzoneWebUploadInterface", 1, "Base64.decode Exception: " + paramContext.toString());
    }
  }
  
  public static String ax(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return null;
        if (("mounted".equals(Environment.getExternalStorageState())) && (getSdCardAvailableSize() > 5))
        {
          File localFile = getExternalFilesDir(paramContext);
          if (localFile != null) {
            return cs(localFile.getAbsolutePath(), paramString);
          }
        }
      } while (getInternalAvailableSize() <= 5);
      paramContext = paramContext.getDir("uploader", 0);
    } while (paramContext == null);
    return cs(paramContext.getAbsolutePath(), paramString);
  }
  
  public static final String cs(String paramString1, String paramString2)
  {
    return 8 + paramString1 + File.separator + paramString2 + ".qtmp";
  }
  
  public static boolean cw(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.w("js-upload: QzoneWebUploadInterface", 1, "localPath: " + paramString1 + " bid:" + paramString2);
      return false;
    }
    if (!new File(paramString1).exists())
    {
      QLog.w("js-upload: QzoneWebUploadInterface", 1, "upload file not exist! localPath:" + paramString1);
      return false;
    }
    Object localObject2 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if (localObject2 == null)
    {
      QLog.w("js-upload: QzoneWebUploadInterface", 1, "app == null");
      return false;
    }
    Object localObject1 = (TicketManager)((AppInterface)localObject2).getManager(2);
    String str = ((AppInterface)localObject2).getAccount();
    localObject2 = ((TicketManager)localObject1).getSkey(str);
    localObject1 = ((TicketManager)localObject1).getA2(str);
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      QLog.w("js-upload: QzoneWebUploadInterface", 1, "mSkey == null || mA2 == null, mSkey=" + (String)localObject2 + " mA2=" + (String)localObject1);
      return false;
    }
    avzf.a().a().al(paramString1, paramString2);
    return true;
  }
  
  private static File getExternalFilesDir(Context paramContext)
  {
    paramContext = new File(aqul.getSDKPrivatePath("uploader"));
    if ((paramContext.isDirectory()) || (paramContext.mkdirs())) {
      return paramContext;
    }
    return null;
  }
  
  public static int getInternalAvailableSize()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    int i = localStatFs.getBlockSize();
    double d = localStatFs.getAvailableBlocks();
    return (int)(i * (1.0D * d) / 1024.0D / 1024.0D);
  }
  
  public static int getSdCardAvailableSize()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    int i = localStatFs.getBlockSize();
    double d = localStatFs.getAvailableBlocks();
    return (int)(i * (1.0D * d) / 1024.0D / 1024.0D);
  }
  
  /* Error */
  protected static boolean saveByteBufferToLocalFile(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 5
    //   17: aload 6
    //   19: astore 4
    //   21: new 109	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload 6
    //   32: astore 4
    //   34: aload_1
    //   35: invokevirtual 152	java/io/File:exists	()Z
    //   38: ifne +12 -> 50
    //   41: aload 6
    //   43: astore 4
    //   45: aload_1
    //   46: invokevirtual 248	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aload 6
    //   52: astore 4
    //   54: new 250	java/io/FileOutputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 253	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_0
    //   65: invokevirtual 257	java/io/FileOutputStream:write	([B)V
    //   68: iload_3
    //   69: istore_2
    //   70: aload_1
    //   71: ifnull +9 -> 80
    //   74: aload_1
    //   75: invokevirtual 260	java/io/FileOutputStream:close	()V
    //   78: iload_3
    //   79: istore_2
    //   80: iload_2
    //   81: ireturn
    //   82: astore_0
    //   83: ldc 43
    //   85: iconst_1
    //   86: new 67	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 262
    //   96: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: iload_3
    //   110: istore_2
    //   111: goto -31 -> 80
    //   114: astore_1
    //   115: aload 5
    //   117: astore_0
    //   118: aload_0
    //   119: astore 4
    //   121: ldc 43
    //   123: iconst_1
    //   124: new 67	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 267
    //   134: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload_0
    //   148: ifnull +104 -> 252
    //   151: aload_0
    //   152: invokevirtual 260	java/io/FileOutputStream:close	()V
    //   155: iconst_0
    //   156: istore_2
    //   157: goto -77 -> 80
    //   160: astore_0
    //   161: ldc 43
    //   163: iconst_1
    //   164: new 67	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 262
    //   174: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iconst_0
    //   188: istore_2
    //   189: goto -109 -> 80
    //   192: astore_0
    //   193: aload 4
    //   195: ifnull +8 -> 203
    //   198: aload 4
    //   200: invokevirtual 260	java/io/FileOutputStream:close	()V
    //   203: aload_0
    //   204: athrow
    //   205: astore_1
    //   206: ldc 43
    //   208: iconst_1
    //   209: new 67	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 262
    //   219: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_1
    //   223: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: goto -29 -> 203
    //   235: astore_0
    //   236: aload_1
    //   237: astore 4
    //   239: goto -46 -> 193
    //   242: astore 4
    //   244: aload_1
    //   245: astore_0
    //   246: aload 4
    //   248: astore_1
    //   249: goto -131 -> 118
    //   252: iconst_0
    //   253: istore_2
    //   254: goto -174 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramArrayOfByte	byte[]
    //   0	257	1	paramString	String
    //   69	185	2	bool1	boolean
    //   1	109	3	bool2	boolean
    //   19	219	4	localObject1	Object
    //   242	5	4	localIOException	java.io.IOException
    //   15	101	5	localObject2	Object
    //   12	39	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   74	78	82	java/lang/Exception
    //   21	30	114	java/io/IOException
    //   34	41	114	java/io/IOException
    //   45	50	114	java/io/IOException
    //   54	63	114	java/io/IOException
    //   151	155	160	java/lang/Exception
    //   21	30	192	finally
    //   34	41	192	finally
    //   45	50	192	finally
    //   54	63	192	finally
    //   121	147	192	finally
    //   198	203	205	java/lang/Exception
    //   63	68	235	finally
    //   63	68	242	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgq
 * JD-Core Version:    0.7.0.1
 */