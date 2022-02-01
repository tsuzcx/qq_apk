import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.floatscr.ColorScreenManager.1;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class ahes
  extends aqrg<aher>
{
  public static boolean sEnable = true;
  protected AppInterface mApp;
  protected Context mContext;
  
  public ahes(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    this.mContext = paramAppInterface.getApp().getApplicationContext();
  }
  
  public File D()
  {
    File localFile = new File(this.mContext.getFilesDir(), "color_screen");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void OZ(int paramInt)
  {
    String str = "colorScreen.android." + paramInt;
    VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.mApp.getManager(184);
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.downloadItem(22L, str, "ColorScreenManager");
    }
  }
  
  public aher a(int paramInt)
  {
    for (;;)
    {
      File localFile3;
      File localFile2;
      try
      {
        File localFile1 = new File(e(paramInt), "unzip");
        if (!localFile1.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorScreenManager", 1, "getLocalConfig unzipDir not exist");
          }
          localFile1 = null;
          return localFile1;
        }
        localFile3 = new File(localFile1, "config.json");
        localFile2 = new File(localFile1, "fullscreen.json");
        if (!localFile3.exists())
        {
          QLog.e("ColorScreenManager", 1, "configFile do not exists.");
          aqri.a(BaseApplicationImpl.getApplication().getRuntime(), "individual_v2_colorscreen_parse_fail", "1", "", Integer.toString(paramInt), null, null, 0.0F, 0.0F);
          aqrh.is("individual_v2_colorscreen_parse_fail", "errCode:1, id:" + paramInt);
          deleteFiles("colorScreen.android." + paramInt);
          localFile1 = null;
          continue;
        }
        if (!localFile2.exists())
        {
          QLog.e("ColorScreenManager", 1, "animFile do not exists.");
          continue;
        }
        localaher = new aher();
      }
      finally {}
      aher localaher;
      localaher.bKj = localFile2.getAbsolutePath();
      localaher.bKk = (localObject1.getAbsolutePath() + File.separator + "images");
      try
      {
        Object localObject2 = new JSONObject(aqhq.readFileContent(localFile3));
        localaher.repeatCount = (((JSONObject)localObject2).optInt("repeatCount", localaher.repeatCount) - 1);
        localaher.aas = ((JSONObject)localObject2).optLong("eastInTime", localaher.aas);
        localaher.aat = ((JSONObject)localObject2).optLong("eastOutTime", localaher.aat);
        localObject2 = localaher;
        if (QLog.isColorLevel())
        {
          long l = IOUtil.getCRC32Value(localFile2);
          QLog.d("ColorScreenManager", 1, "getLocalConfig crc32: " + Long.toHexString(l));
          localObject2 = localaher;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ColorScreenManager", 1, "failed read config of " + paramInt, localException);
      }
    }
  }
  
  public void a(int paramInt, aqrg.a<aher> parama)
  {
    ThreadManager.post(new ColorScreenManager.1(this, paramInt, parama), 5, null, false);
  }
  
  public int ct(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("\\.");
      localObject1 = localObject2;
      if (arrayOfString.length >= 3) {
        try
        {
          int i = Integer.parseInt(arrayOfString[2]);
          return i;
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
    QLog.e("ColorScreenManager", 1, "getColorScreenId failed from " + paramString, localNumberFormatException);
    return 0;
  }
  
  public void deleteFiles(String paramString)
  {
    VasQuickUpdateEngine.safeDeleteFile(new File(D(), Integer.toString(ct(paramString))));
  }
  
  public File e(int paramInt)
  {
    File localFile = new File(D(), Integer.toString(paramInt));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  /* Error */
  public void eL(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 270	ahes:ct	(Ljava/lang/String;)I
    //   10: istore_3
    //   11: iload_3
    //   12: ifle +65 -> 77
    //   15: iload_2
    //   16: ifeq +64 -> 80
    //   19: ldc_w 284
    //   22: astore 4
    //   24: aload_0
    //   25: iload_3
    //   26: invokevirtual 286	ahes:a	(I)Laher;
    //   29: astore 5
    //   31: aload_0
    //   32: aload_1
    //   33: aload 5
    //   35: invokevirtual 290	ahes:A	(Ljava/lang/String;Ljava/lang/Object;)V
    //   38: aload 5
    //   40: ifnonnull +37 -> 77
    //   43: aload_0
    //   44: getfield 22	ahes:mApp	Lcom/tencent/common/app/AppInterface;
    //   47: ldc_w 292
    //   50: iload_2
    //   51: invokestatic 295	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   54: aload 4
    //   56: iload_3
    //   57: invokestatic 139	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   60: aconst_null
    //   61: aconst_null
    //   62: fconst_0
    //   63: fconst_0
    //   64: invokestatic 144	aqri:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FF)V
    //   67: ldc_w 292
    //   70: iload_2
    //   71: invokestatic 295	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   74: invokestatic 152	aqrh:is	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aload_0
    //   81: iload_3
    //   82: invokevirtual 97	ahes:e	(I)Ljava/io/File;
    //   85: astore 6
    //   87: new 40	java/io/File
    //   90: dup
    //   91: aload 6
    //   93: ldc_w 297
    //   96: invokespecial 50	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   99: astore 5
    //   101: aload 5
    //   103: invokevirtual 54	java/io/File:exists	()Z
    //   106: ifne +32 -> 138
    //   109: new 61	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 299
    //   119: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 5
    //   124: invokevirtual 164	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: astore 4
    //   135: goto -111 -> 24
    //   138: new 61	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   145: aload 6
    //   147: invokevirtual 164	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   150: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 171	java/io/File:separator	Ljava/lang/String;
    //   156: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc 99
    //   161: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: astore 6
    //   169: aload 5
    //   171: invokevirtual 164	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   174: aload 6
    //   176: iconst_0
    //   177: invokestatic 303	aqhq:W	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   180: goto -156 -> 24
    //   183: astore 6
    //   185: new 61	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 305
    //   195: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 5
    //   200: invokevirtual 164	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   203: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: astore 4
    //   211: ldc 85
    //   213: iconst_1
    //   214: new 61	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 307
    //   224: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 5
    //   229: invokevirtual 164	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   232: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: aload 6
    //   240: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   243: goto -219 -> 24
    //   246: astore_1
    //   247: aload_0
    //   248: monitorexit
    //   249: aload_1
    //   250: athrow
    //   251: astore 6
    //   253: new 61	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 309
    //   263: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 5
    //   268: invokevirtual 164	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   271: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: astore 4
    //   279: ldc 85
    //   281: iconst_1
    //   282: new 61	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 307
    //   292: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 5
    //   297: invokevirtual 164	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   300: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload 6
    //   308: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: goto -287 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	ahes
    //   0	314	1	paramString	String
    //   0	314	2	paramInt	int
    //   10	72	3	i	int
    //   1	277	4	str	String
    //   29	267	5	localObject1	Object
    //   85	90	6	localObject2	Object
    //   183	56	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   251	56	6	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   169	180	183	java/lang/OutOfMemoryError
    //   5	11	246	finally
    //   24	38	246	finally
    //   43	77	246	finally
    //   80	135	246	finally
    //   138	169	246	finally
    //   169	180	246	finally
    //   185	243	246	finally
    //   253	311	246	finally
    //   169	180	251	java/lang/Throwable
  }
  
  public boolean isFileExists(String paramString)
  {
    int i = ct(paramString);
    if (i > 0) {
      return new File(e(i), "config.zip").exists();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahes
 * JD-Core Version:    0.7.0.1
 */