import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class axrr
{
  private static long lastClickTime;
  
  public static String a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "humRecognitionResultText: humMusicItemInfo = " + paramMusicItemInfo);
    }
    Object localObject;
    if (paramMusicItemInfo == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = paramMusicItemInfo.mMusicName;
      if (paramMusicItemInfo.mMusicName.length() > 7) {
        str = paramMusicItemInfo.mMusicName.substring(0, 7) + "...";
      }
      localObject = str;
    } while (TextUtils.isEmpty(paramMusicItemInfo.mSingername));
    return paramMusicItemInfo.mSingername + "-" + str;
  }
  
  public static void a(String paramString1, String paramString2, axsf paramaxsf)
    throws FFmpegCommandAlreadyRunningException
  {
    eOs();
    rqa localrqa = rqa.a(BaseApplicationImpl.getApplication().getApplicationContext());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-f");
    localArrayList.add("s16le");
    localArrayList.add("-ar");
    localArrayList.add("44100");
    localArrayList.add("-ac");
    localArrayList.add("1");
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-f");
    localArrayList.add("s16le");
    localArrayList.add("-ar");
    localArrayList.add("8000");
    localArrayList.add("-ac");
    localArrayList.add("1");
    localArrayList.add("-acodec");
    localArrayList.add("pcm_s16le");
    localArrayList.add(paramString2);
    localrqa.a((String[])localArrayList.toArray(new String[0]), new axrs(paramString2, paramaxsf));
  }
  
  public static boolean aPE()
  {
    File localFile = new File(axse.cVT);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    try
    {
      new axrp(BaseApplicationImpl.getContext()).c("svm_snr15_random_noise", localFile);
      return true;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HumUtils", 2, "copyHumClassifier: Failed. exception = ", localIOException);
      }
    }
    return false;
  }
  
  public static void eOs()
    throws FFmpegCommandAlreadyRunningException
  {
    rqa localrqa = rqa.a(BaseApplicationImpl.getApplication().getApplicationContext());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-formats");
    localrqa.a((String[])localArrayList.toArray(new String[0]), new axrt());
  }
  
  /* Error */
  public static byte[] f(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 186	java/io/File:length	()J
    //   4: l2i
    //   5: istore_1
    //   6: iload_1
    //   7: newarray byte
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore_3
    //   15: new 188	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 191	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_0
    //   24: aload_0
    //   25: astore_2
    //   26: aload_0
    //   27: aload 4
    //   29: iconst_0
    //   30: iload_1
    //   31: invokevirtual 195	java/io/FileInputStream:read	([BII)I
    //   34: pop
    //   35: aload_0
    //   36: ifnull +7 -> 43
    //   39: aload_0
    //   40: invokevirtual 198	java/io/FileInputStream:close	()V
    //   43: aload 4
    //   45: areturn
    //   46: astore_0
    //   47: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq -7 -> 43
    //   53: ldc 16
    //   55: iconst_2
    //   56: ldc 200
    //   58: aload_0
    //   59: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   62: aload 4
    //   64: areturn
    //   65: astore_3
    //   66: aconst_null
    //   67: astore_0
    //   68: aload_0
    //   69: astore_2
    //   70: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +14 -> 87
    //   76: aload_0
    //   77: astore_2
    //   78: ldc 16
    //   80: iconst_2
    //   81: ldc 200
    //   83: aload_3
    //   84: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload_0
    //   88: ifnull -45 -> 43
    //   91: aload_0
    //   92: invokevirtual 198	java/io/FileInputStream:close	()V
    //   95: aload 4
    //   97: areturn
    //   98: astore_0
    //   99: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -59 -> 43
    //   105: ldc 16
    //   107: iconst_2
    //   108: ldc 200
    //   110: aload_0
    //   111: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload 4
    //   116: areturn
    //   117: astore_2
    //   118: aload_3
    //   119: astore_0
    //   120: aload_2
    //   121: astore_3
    //   122: aload_0
    //   123: astore_2
    //   124: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +14 -> 141
    //   130: aload_0
    //   131: astore_2
    //   132: ldc 16
    //   134: iconst_2
    //   135: ldc 200
    //   137: aload_3
    //   138: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload_0
    //   142: ifnull -99 -> 43
    //   145: aload_0
    //   146: invokevirtual 198	java/io/FileInputStream:close	()V
    //   149: aload 4
    //   151: areturn
    //   152: astore_0
    //   153: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -113 -> 43
    //   159: ldc 16
    //   161: iconst_2
    //   162: ldc 200
    //   164: aload_0
    //   165: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   168: aload 4
    //   170: areturn
    //   171: astore_0
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 198	java/io/FileInputStream:close	()V
    //   180: aload_0
    //   181: athrow
    //   182: astore_2
    //   183: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq -6 -> 180
    //   189: ldc 16
    //   191: iconst_2
    //   192: ldc 200
    //   194: aload_2
    //   195: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   198: goto -18 -> 180
    //   201: astore_0
    //   202: goto -30 -> 172
    //   205: astore_3
    //   206: goto -84 -> 122
    //   209: astore_3
    //   210: goto -142 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramFile	File
    //   5	26	1	i	int
    //   12	66	2	localFile1	File
    //   117	4	2	localIOException1	IOException
    //   123	54	2	localFile2	File
    //   182	13	2	localIOException2	IOException
    //   14	1	3	localObject	Object
    //   65	54	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   121	17	3	localIOException3	IOException
    //   205	1	3	localIOException4	IOException
    //   209	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   9	160	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   39	43	46	java/io/IOException
    //   15	24	65	java/io/FileNotFoundException
    //   91	95	98	java/io/IOException
    //   15	24	117	java/io/IOException
    //   145	149	152	java/io/IOException
    //   15	24	171	finally
    //   124	130	171	finally
    //   132	141	171	finally
    //   176	180	182	java/io/IOException
    //   26	35	201	finally
    //   70	76	201	finally
    //   78	87	201	finally
    //   26	35	205	java/io/IOException
    //   26	35	209	java/io/FileNotFoundException
  }
  
  /* Error */
  public static boolean qH()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   6: lstore_0
    //   7: getstatic 208	axrr:lastClickTime	J
    //   10: lstore_2
    //   11: lload_0
    //   12: lload_2
    //   13: lsub
    //   14: lstore_2
    //   15: lconst_0
    //   16: lload_2
    //   17: lcmp
    //   18: ifge +20 -> 38
    //   21: lload_2
    //   22: ldc2_w 209
    //   25: lcmp
    //   26: ifge +12 -> 38
    //   29: iconst_1
    //   30: istore 4
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload 4
    //   37: ireturn
    //   38: lload_0
    //   39: putstatic 208	axrr:lastClickTime	J
    //   42: iconst_0
    //   43: istore 4
    //   45: goto -13 -> 32
    //   48: astore 5
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload 5
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	33	0	l1	long
    //   10	12	2	l2	long
    //   30	14	4	bool	boolean
    //   48	6	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	11	48	finally
    //   38	42	48	finally
  }
  
  public static String sK(String paramString)
    throws UnsupportedEncodingException, NoSuchAlgorithmException
  {
    Object localObject = MessageDigest.getInstance("MD5");
    ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
    paramString = ((MessageDigest)localObject).digest();
    localObject = new StringBuilder();
    int i = 0;
    if (i < paramString.length)
    {
      if (Integer.toHexString(paramString[i] & 0xFF).length() == 1) {
        ((StringBuilder)localObject).append("0").append(Integer.toHexString(paramString[i] & 0xFF));
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject).append(Integer.toHexString(paramString[i] & 0xFF));
      }
    }
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axrr
 * JD-Core Version:    0.7.0.1
 */