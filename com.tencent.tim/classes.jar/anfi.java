import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.PendantVersionManager.1;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class anfi
{
  private static final String[] gA = { "libimage_filter_common.so", "libimage_filter_gpu.so", "libpitu_tools.so", "libimage_filter_cpu.so", "libalgo_youtu_jni.so", "libformat_convert.so" };
  private static final String[] gz = { "art_res_cache", "other_res_cache", "portrait_res_cache", "ptu_res" };
  
  static void PG(boolean paramBoolean) {}
  
  static boolean aj(String paramString, int paramInt)
  {
    String str = paramString.trim();
    VideoEnvironment.k("PendantVersionManager", "checkSignatureVersionIsOK signature=" + paramString, null);
    paramString = angr.a(str);
    int i = paramString.Jm();
    VideoEnvironment.k("PendantVersionManager", "checkSignatureVersionIsOK errCode=" + i + ",trimSignature=" + str, null);
    if (i == 0)
    {
      paramString = paramString.getVersion().trim();
      VideoEnvironment.k("PendantVersionManager", "checkSignatureVersionIsOK versionValid=" + paramString, null);
      i = Integer.parseInt(paramString);
      VideoEnvironment.k("PendantVersionManager", "checkSignatureVersionIsOK version=" + i + ",limitVersion=" + paramInt, null);
      if (i >= paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean awy()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("pendant_short_video_mgr_sp", 4).getString("pendant_sv_md5_version_soname_key", "Pendant000_0");
    boolean bool = aj(str, 83606);
    VideoEnvironment.k("PendantVersionManager", "checkPendantVersionOk success=" + bool + ", md5Version=" + str, null);
    return bool;
  }
  
  /* Error */
  private static ArrayList<String> b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: new 149	java/util/ArrayList
    //   7: dup
    //   8: iconst_1
    //   9: invokespecial 152	java/util/ArrayList:<init>	(I)V
    //   12: astore 4
    //   14: new 154	java/io/FileReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 157	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   22: astore_0
    //   23: new 159	java/io/BufferedReader
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 162	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_2
    //   32: aload_2
    //   33: invokevirtual 165	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull +18 -> 56
    //   41: aload 4
    //   43: aload_1
    //   44: invokevirtual 169	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   47: pop
    //   48: aload_2
    //   49: invokevirtual 165	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_1
    //   53: goto -16 -> 37
    //   56: aload_2
    //   57: ifnull +7 -> 64
    //   60: aload_2
    //   61: invokevirtual 172	java/io/BufferedReader:close	()V
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 173	java/io/FileReader:close	()V
    //   72: aload 4
    //   74: areturn
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   80: goto -16 -> 64
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   88: aload 4
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_2
    //   94: aload_0
    //   95: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   98: ldc 53
    //   100: ldc 179
    //   102: aload_0
    //   103: invokestatic 73	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 172	java/io/BufferedReader:close	()V
    //   114: aload_1
    //   115: ifnull -43 -> 72
    //   118: aload_1
    //   119: invokevirtual 173	java/io/FileReader:close	()V
    //   122: aload 4
    //   124: areturn
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   130: aload 4
    //   132: areturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   138: goto -24 -> 114
    //   141: astore_0
    //   142: aconst_null
    //   143: astore_3
    //   144: aload_2
    //   145: astore_1
    //   146: aload_3
    //   147: astore_2
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 172	java/io/BufferedReader:close	()V
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 173	java/io/FileReader:close	()V
    //   164: aload_0
    //   165: athrow
    //   166: astore_2
    //   167: aload_2
    //   168: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   171: goto -15 -> 156
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   179: goto -15 -> 164
    //   182: astore_3
    //   183: aconst_null
    //   184: astore_2
    //   185: aload_0
    //   186: astore_1
    //   187: aload_3
    //   188: astore_0
    //   189: goto -41 -> 148
    //   192: astore_3
    //   193: aload_0
    //   194: astore_1
    //   195: aload_3
    //   196: astore_0
    //   197: goto -49 -> 148
    //   200: astore_0
    //   201: goto -53 -> 148
    //   204: astore_3
    //   205: aconst_null
    //   206: astore_2
    //   207: aload_0
    //   208: astore_1
    //   209: aload_3
    //   210: astore_0
    //   211: goto -117 -> 94
    //   214: astore_3
    //   215: aload_0
    //   216: astore_1
    //   217: aload_3
    //   218: astore_0
    //   219: goto -125 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramFile	File
    //   3	50	1	str	String
    //   75	44	1	localIOException1	java.io.IOException
    //   145	16	1	localObject1	Object
    //   174	2	1	localIOException2	java.io.IOException
    //   186	31	1	localFile	File
    //   1	152	2	localObject2	Object
    //   166	2	2	localIOException3	java.io.IOException
    //   184	23	2	localObject3	Object
    //   143	4	3	localObject4	Object
    //   182	6	3	localObject5	Object
    //   192	4	3	localObject6	Object
    //   204	6	3	localException1	Exception
    //   214	4	3	localException2	Exception
    //   12	119	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   60	64	75	java/io/IOException
    //   68	72	83	java/io/IOException
    //   14	23	91	java/lang/Exception
    //   118	122	125	java/io/IOException
    //   110	114	133	java/io/IOException
    //   14	23	141	finally
    //   152	156	166	java/io/IOException
    //   160	164	174	java/io/IOException
    //   23	32	182	finally
    //   32	37	192	finally
    //   41	53	192	finally
    //   94	106	200	finally
    //   23	32	204	java/lang/Exception
    //   32	37	214	java/lang/Exception
    //   41	53	214	java/lang/Exception
  }
  
  static boolean bw(String paramString1, String paramString2)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    bool1 = true;
    for (;;)
    {
      try
      {
        String str = ankq.aK(VideoEnvironment.getContext());
        str = str + paramString1 + File.separator;
        File localFile = new File(str);
        if (localFile.exists())
        {
          if ((zt().equals(paramString1)) && (bx(str, "pendant_config_file")))
          {
            VideoEnvironment.k("PendantVersionManager", "uncompressPendantZip:[checkUnzipFileListSizeIsOK]success=true", null);
            bool1 = false;
            return bool1;
          }
          aqhq.cn(str);
          VideoEnvironment.k("PendantVersionManager", "uncompressPendantZip:[deleteDirectory|already exists]unzipPath=" + str, null);
        }
        boolean bool4 = localFile.mkdirs();
        VideoEnvironment.k("PendantVersionManager", "uncompressPendantZip:[exists]mkOK=" + bool4, null);
        if (!localFile.exists())
        {
          VideoEnvironment.k("PendantVersionManager", "uncompressPendantZip:unzipFile.exists=false[error]", null);
          continue;
        }
        try
        {
          aqhq.W(paramString2, str, false);
          bool1 = bx(str, "pendant_config_file");
          VideoEnvironment.k("PendantVersionManager", "uncompressPendantZip:checkUnzipFileListSizeIsOK success=" + bool1, null);
          if (!bool1) {
            break label432;
          }
          bool1 = oT(str);
          VideoEnvironment.k("PendantVersionManager", "uncompressPendantZip:copyResFileToFinalDir copyOK=" + bool1, null);
          if (!bool1) {
            break;
          }
          bool4 = oS(paramString1);
          VideoEnvironment.k("PendantVersionManager", "uncompressPendantZip:checkUnzipFileListSizeIsOK saveOK=" + bool4, null);
          bool1 = bool3;
          if (!bool4)
          {
            bool4 = oS(paramString1);
            VideoEnvironment.k("PendantVersionManager", "uncompressPendantZip:checkUnzipFileListSizeIsOK[two]saveOK=" + bool4, null);
            bool1 = bool3;
            if (!bool4)
            {
              VideoEnvironment.k("PendantVersionManager", "uncompressPendantZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
              bool1 = oS("Pendant000_0");
              VideoEnvironment.k("PendantVersionManager", "uncompressPendantZip:checkUnzipFileListSizeIsOK clearMemoryOK=" + bool1 + ",signature=" + paramString1, null);
              bool1 = true;
            }
          }
          dPe();
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            continue;
            bool1 = true;
            continue;
            bool1 = true;
          }
        }
      }
      finally {}
      bool2 = bool1;
      bool1 = bool2;
      if (bool2)
      {
        aqhq.cn(str);
        bool1 = bool2;
      }
    }
  }
  
  private static boolean bx(String paramString1, String paramString2)
  {
    if (!ankq.pn(paramString1))
    {
      VideoEnvironment.k("PendantVersionManager", "checkUnzipFileListSizeIsOK[isFilterSoExist] exists=false", null);
      return false;
    }
    return by(paramString1, paramString2);
  }
  
  static boolean by(String paramString1, String paramString2)
  {
    paramString2 = paramString1 + paramString2;
    VideoEnvironment.k("PendantVersionManager", "checkUnzipFileListSizeIsOK configPath=" + paramString2, null);
    Object localObject = new File(paramString2);
    if (!((File)localObject).exists())
    {
      VideoEnvironment.k("PendantVersionManager", "checkUnzipFileListSizeIsOK configPath=" + paramString2 + ",exists=false", null);
      return false;
    }
    paramString2 = b((File)localObject);
    if (paramString2.size() <= 0)
    {
      VideoEnvironment.k("PendantVersionManager", "checkUnzipFileListSizeIsOK configData.size()=" + paramString2.size(), null);
      return false;
    }
    int i = 0;
    if (i < paramString2.size())
    {
      VideoEnvironment.k("PendantVersionManager", "checkUnzipFileListSizeIsOK itemLineValue=" + (String)paramString2.get(i), null);
      if (TextUtils.isEmpty((CharSequence)paramString2.get(i))) {}
      String str;
      int j;
      long l;
      do
      {
        do
        {
          i += 1;
          break;
          str = ((String)paramString2.get(i)).trim();
        } while (TextUtils.isEmpty(str));
        VideoEnvironment.k("PendantVersionManager", "checkUnzipFileListSizeIsOK trimValue=" + str, null);
        localObject = angr.a(str);
        j = ((angr.a)localObject).d('|');
        if (j != 0) {
          break label407;
        }
        str = paramString1 + ((angr.a)localObject).getKey();
        File localFile = new File(str);
        if (!localFile.exists())
        {
          VideoEnvironment.k("PendantVersionManager", "checkUnzipFileListSizeIsOK[exists=false] fileName=" + str, null);
          return false;
        }
        j = Integer.parseInt(((angr.a)localObject).getValue());
        l = localFile.length();
      } while (j == l);
      VideoEnvironment.k("PendantVersionManager", "checkUnzipFileListSizeIsOK sizeConfig=" + j + ",fileSize=" + l, null);
      return false;
      label407:
      VideoEnvironment.k("PendantVersionManager", "checkUnzipFileListSizeIsOK[CfgParser] errCode=" + j + ",trimValue=" + str, null);
      return false;
    }
    VideoEnvironment.k("PendantVersionManager", "checkUnzipFileListSizeIsOK[OK]", null);
    return true;
  }
  
  private static void dPe()
  {
    ThreadManager.excute(new PendantVersionManager.1(), 64, null, false);
  }
  
  public static void dPf()
  {
    int j = 0;
    String str1 = ankq.aK(VideoEnvironment.getContext());
    String[] arrayOfString = gA;
    int k = arrayOfString.length;
    int i = 0;
    String str2;
    while (i < k)
    {
      str2 = arrayOfString[i];
      aqhq.deleteFile(str1 + str2);
      i += 1;
    }
    aqhq.deleteFile(str1 + "libartfilter.so");
    aqhq.deleteFile(str1 + "262_8_model");
    aqhq.deleteFile(str1 + "262_8_md04_reshape");
    str1 = str1 + "bakcup/";
    if (aqhq.fileExists(str1))
    {
      arrayOfString = gA;
      k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        str2 = arrayOfString[i];
        aqhq.deleteFile(str1 + str2);
        i += 1;
      }
      aqhq.deleteFile(str1 + "libartfilter.so");
      aqhq.deleteFile(str1 + "262_8_model");
      aqhq.deleteFile(str1 + "262_8_md04_reshape");
    }
  }
  
  private static boolean oS(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("pendant_short_video_mgr_sp", 4).edit();
    localEditor.putString("pendant_sv_md5_version_soname_key", paramString);
    boolean bool = localEditor.commit();
    VideoEnvironment.k("PendantVersionManager", "storeNewPendantUnzipPath commitValue=" + bool + ",pathName=" + paramString, null);
    return bool;
  }
  
  public static boolean oT(String paramString)
  {
    boolean bool = true;
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      bool = false;
    }
    int i;
    do
    {
      return bool;
      i = aqhq.a(paramString, awtn.b.c.cSU, false, true, QLog.isColorLevel());
      VideoEnvironment.k("PendantVersionManager", "copyResFileToFinalDir errorcode:" + i + ", fromPath:" + paramString, null);
    } while (i == 0);
    return false;
  }
  
  private static boolean oU(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < gz.length)
      {
        if (paramString.equals(gz[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String zt()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("pendant_short_video_mgr_sp", 4).getString("pendant_sv_md5_version_soname_key", "Pendant000_0");
    boolean bool = aj(str, 83606);
    VideoEnvironment.k("PendantVersionManager", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "Pendant000_0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfi
 * JD-Core Version:    0.7.0.1
 */