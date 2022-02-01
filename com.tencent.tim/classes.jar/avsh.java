import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.UploadSoDownloader.1;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONArray;
import org.json.JSONObject;

public class avsh
{
  private static File bf = BaseApplicationImpl.getContext().getDir("qzoneupload", 0);
  private static volatile boolean doC;
  private static boolean doD;
  private static int eyo = 5;
  
  private int PJ()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_upload_so", 0);
    if (localSharedPreferences != null)
    {
      String str = localSharedPreferences.getString("upload_so_ver", "");
      int i = localSharedPreferences.getInt(str, 0);
      QLog.d("UploadEnv", 1, "getRetryCnt ver " + str + " cnt:" + i);
      return i;
    }
    QLog.d("UploadEnv", 1, "getRetryCnt 0");
    return 0;
  }
  
  private void WK(boolean paramBoolean)
  {
    QLog.d("UploadEnv", 1, "saveSoDownloadState " + paramBoolean);
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_upload_so", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("upload_so_download_success", paramBoolean).commit();
    }
  }
  
  private boolean aLt()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_upload_so", 0);
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("upload_so_download_success", false);
    }
    QLog.d("UploadEnv", 1, "getSoDownloadState " + bool);
    return bool;
  }
  
  private void aak(String paramString)
  {
    String str = "";
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_upload_so", 0);
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("upload_so_ver", "");
    }
    QLog.d("UploadEnv", 1, "last ver " + str + " curUrl:" + paramString);
    if (TextUtils.isEmpty(str)) {}
    while ((str.equals(paramString)) || (localSharedPreferences == null)) {
      return;
    }
    localSharedPreferences.edit().remove(str);
    localSharedPreferences.edit().remove("upload_so_ver");
  }
  
  private void aal(String paramString)
  {
    QLog.d("UploadEnv", 1, "recordRetryCnt " + paramString);
    aak(paramString);
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_upload_so", 0);
    if (localSharedPreferences != null)
    {
      if (TextUtils.isEmpty(localSharedPreferences.getString("upload_so_ver", ""))) {
        localSharedPreferences.edit().putString("upload_so_ver", paramString).commit();
      }
      int i = localSharedPreferences.getInt(paramString, 0);
      localSharedPreferences.edit().putInt(paramString, i + 1).commit();
    }
  }
  
  private boolean ty(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramString == null) {}
    Object localObject1;
    int i;
    Object localObject2;
    String str2;
    do
    {
      String str1;
      File localFile;
      for (;;)
      {
        return bool2;
        localObject1 = new File(paramString + File.separator + "md5.json");
        if (((File)localObject1).exists()) {
          try
          {
            localObject1 = new JSONObject(aqhq.readFileContent((File)localObject1)).getJSONArray("so_lib");
            i = 0;
            bool2 = bool1;
            if (i < ((JSONArray)localObject1).length())
            {
              localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
              str1 = ((JSONObject)localObject2).getString("name");
              localObject2 = ((JSONObject)localObject2).getString("md5");
              localFile = new File(paramString + File.separator + str1);
              if (!localFile.exists())
              {
                QLog.d("UploadEnv", 1, "so not exists " + str1);
                return bool1;
              }
            }
          }
          catch (Exception paramString)
          {
            QLog.d("UploadEnv", 1, "checkSoMd5 error : " + paramString.getMessage());
            return false;
          }
        }
      }
      str2 = MD5.getFileMD5(localFile);
      QLog.d("UploadEnv", 1, new Object[] { "src md5 : ", str2, " dst md5 : ", localObject2, " file size :", Long.valueOf(localFile.length()), " file : ", str1 });
      bool2 = bool1;
    } while (!str2.equals(localObject2));
    int j = ((JSONArray)localObject1).length();
    if (i == j - 1) {
      bool1 = true;
    }
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  public void eBL()
  {
    for (;;)
    {
      try
      {
        if (!avpw.aKX())
        {
          doC = false;
          QLog.d("UploadEnv", 1, "not in qzone process do not download");
          return;
        }
        boolean bool1 = QzoneModuleManager.getInstance().checkIfNeedUpdate("upload.so");
        boolean bool2 = aLt();
        QLog.d("UploadEnv", 1, "downloadUploadSo needUpdate:" + bool1 + " saveState:" + bool2 + " isSoDownloading:" + doD + " process:" + Process.myPid());
        if ((!bool1) && (bool2))
        {
          QLog.d("UploadEnv", 1, "start check so md5");
          doC = false;
          ThreadManager.post(new UploadSoDownloader.1(this), 5, null, true);
          continue;
        }
        if (doD) {
          continue;
        }
      }
      finally {}
      QLog.d("UploadEnv", 1, "upload so need update");
      doD = true;
      doC = false;
      WK(false);
      avwe.a locala = avwe.a().a("upload.so");
      Object localObject2 = QzoneModuleManager.getInstance().getModuleFilePath("upload.so");
      if (locala == null)
      {
        doD = false;
        doC = false;
        continue;
      }
      int i = PJ();
      if ((i > eyo / 2) && (i < eyo)) {
        localObject2 = new File((String)localObject2);
      }
      try
      {
        ((File)localObject2).delete();
        label248:
        if (i > eyo)
        {
          QLog.d("UploadEnv", 1, "upload so has retry:" + PJ());
          doD = false;
          continue;
        }
        aal(locala.a.mUrl);
        QzoneModuleManager.getInstance().downloadModule("upload.so", new avsi(this));
      }
      catch (Exception localException)
      {
        break label248;
      }
    }
  }
  
  /* Error */
  public boolean loadLibrary(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 342	avcc:a	()Lavcc;
    //   7: ldc_w 344
    //   10: ldc_w 346
    //   13: iconst_0
    //   14: invokevirtual 350	avcc:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   17: istore_2
    //   18: ldc 63
    //   20: iconst_1
    //   21: new 65	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 352
    //   31: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_2
    //   35: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc_w 354
    //   41: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: getstatic 167	avsh:doC	Z
    //   47: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iload_2
    //   57: iconst_1
    //   58: if_icmpeq +7 -> 65
    //   61: iconst_0
    //   62: putstatic 167	avsh:doC	Z
    //   65: aload_0
    //   66: invokespecial 271	avsh:aLt	()Z
    //   69: istore 4
    //   71: ldc 63
    //   73: iconst_1
    //   74: new 65	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 356
    //   84: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: iload 4
    //   89: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   92: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: iload 4
    //   100: ifne +7 -> 107
    //   103: iconst_0
    //   104: putstatic 167	avsh:doC	Z
    //   107: getstatic 167	avsh:doC	Z
    //   110: ifeq +149 -> 259
    //   113: new 173	java/io/File
    //   116: dup
    //   117: new 65	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   124: getstatic 31	avsh:bf	Ljava/io/File;
    //   127: invokevirtual 359	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   130: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: getstatic 177	java/io/File:separator	Ljava/lang/String;
    //   136: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 361
    //   142: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 363
    //   152: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: astore 5
    //   163: aload 5
    //   165: invokevirtual 184	java/io/File:exists	()Z
    //   168: istore 4
    //   170: iload 4
    //   172: ifeq +94 -> 266
    //   175: aload 5
    //   177: invokevirtual 359	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: invokestatic 368	java/lang/System:load	(Ljava/lang/String;)V
    //   183: ldc 63
    //   185: iconst_1
    //   186: new 65	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 370
    //   196: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_1
    //   200: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload_0
    //   210: monitorexit
    //   211: iload_3
    //   212: ireturn
    //   213: astore_1
    //   214: ldc 63
    //   216: iconst_1
    //   217: new 65	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 372
    //   227: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_1
    //   231: invokevirtual 373	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: iconst_0
    //   244: putstatic 167	avsh:doC	Z
    //   247: aload_0
    //   248: iconst_0
    //   249: invokespecial 116	avsh:WK	(Z)V
    //   252: getstatic 31	avsh:bf	Ljava/io/File;
    //   255: invokevirtual 315	java/io/File:delete	()Z
    //   258: pop
    //   259: getstatic 167	avsh:doC	Z
    //   262: istore_3
    //   263: goto -54 -> 209
    //   266: iconst_0
    //   267: putstatic 167	avsh:doC	Z
    //   270: ldc 63
    //   272: iconst_1
    //   273: new 65	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 375
    //   283: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_1
    //   287: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aload_0
    //   297: iconst_0
    //   298: invokespecial 116	avsh:WK	(Z)V
    //   301: getstatic 31	avsh:bf	Ljava/io/File;
    //   304: invokevirtual 315	java/io/File:delete	()Z
    //   307: pop
    //   308: goto -49 -> 259
    //   311: astore_1
    //   312: goto -53 -> 259
    //   315: astore_1
    //   316: aload_0
    //   317: monitorexit
    //   318: aload_1
    //   319: athrow
    //   320: astore_1
    //   321: goto -62 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	avsh
    //   0	324	1	paramString	String
    //   17	42	2	i	int
    //   1	262	3	bool1	boolean
    //   69	102	4	bool2	boolean
    //   161	15	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   175	209	213	java/lang/Throwable
    //   301	308	311	java/lang/Exception
    //   4	56	315	finally
    //   61	65	315	finally
    //   65	98	315	finally
    //   103	107	315	finally
    //   107	170	315	finally
    //   175	209	315	finally
    //   214	252	315	finally
    //   252	259	315	finally
    //   259	263	315	finally
    //   266	301	315	finally
    //   301	308	315	finally
    //   252	259	320	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsh
 * JD-Core Version:    0.7.0.1
 */