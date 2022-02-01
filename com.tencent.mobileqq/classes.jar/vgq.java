import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public class vgq
  implements Callable<vgv>
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  public vgq(vgp paramvgp, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.c = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private Map<String, String> a()
  {
    int i = 0;
    for (;;)
    {
      HashMap localHashMap;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        String[] arrayOfString = BaseApplicationImpl.getApplication().getAssets().list("qqcircle");
        if (arrayOfString == null)
        {
          QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset():can not list file");
          return null;
        }
        localHashMap = new HashMap();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        int j = arrayOfString.length;
        if (i < j)
        {
          String str = arrayOfString[i];
          if ((str.contains("qcircle-pluginmanager")) && (str.endsWith(".jpg"))) {
            localArrayList1.add(str);
          } else if ((str.contains("qcircle-plugin")) && (str.endsWith(".jpg"))) {
            localArrayList2.add(str);
          }
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return null;
      }
      a(localArrayList1, "qcircle-pluginmanager");
      a(localArrayList2, "qcircle-plugin");
      localHashMap.put("qcircle-pluginmanager", localArrayList1.get(0));
      localHashMap.put("qcircle-plugin", localArrayList2.get(0));
      return localHashMap;
      i += 1;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0).edit();
    localEditor.putString("qcircle-plugin", paramString1);
    localEditor.putString("qcircle-pluginmanager", paramString2);
    localEditor.commit();
  }
  
  private void a(List<String> paramList, String paramString)
  {
    Collections.sort(paramList, new vgr(this, paramString));
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str1 = str2.substring(paramString.length(), str2.indexOf(".jpg"));
        paramList = str1;
        if (TextUtils.isEmpty(str1)) {
          paramList = "0";
        }
        paramList = new Date(Long.parseLong(paramList));
        paramList = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(paramList);
        QLog.i("QCIRCLE_PLUGIN", 1, str2 + ":" + paramList);
      }
      return;
    }
    catch (Exception paramList) {}
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_1
    //   7: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_2
    //   14: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: new 219	java/io/File
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 8
    //   32: aload 8
    //   34: invokevirtual 223	java/io/File:exists	()Z
    //   37: ifeq +9 -> 46
    //   40: aload 8
    //   42: invokevirtual 226	java/io/File:delete	()Z
    //   45: pop
    //   46: new 219	java/io/File
    //   49: dup
    //   50: new 204	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   57: aload_2
    //   58: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 228
    //   63: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 9
    //   74: aload 9
    //   76: invokevirtual 223	java/io/File:exists	()Z
    //   79: ifeq +9 -> 88
    //   82: aload 9
    //   84: invokevirtual 226	java/io/File:delete	()Z
    //   87: pop
    //   88: aload 9
    //   90: invokevirtual 231	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   93: invokestatic 236	com/tencent/mobileqq/utils/FileUtils:createFileIfNotExits	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield 17	vgq:jdField_a_of_type_Vgp	Lvgp;
    //   100: invokestatic 241	vgp:a	(Lvgp;)Landroid/content/Context;
    //   103: invokevirtual 244	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   106: new 204	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   113: ldc 246
    //   115: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokevirtual 250	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   128: astore_1
    //   129: new 252	java/io/FileOutputStream
    //   132: dup
    //   133: aload 9
    //   135: invokespecial 255	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   138: astore 6
    //   140: sipush 8192
    //   143: newarray byte
    //   145: astore_2
    //   146: aload_1
    //   147: aload_2
    //   148: invokevirtual 261	java/io/InputStream:read	([B)I
    //   151: istore_3
    //   152: iload_3
    //   153: iconst_m1
    //   154: if_icmpeq +93 -> 247
    //   157: aload 6
    //   159: aload_2
    //   160: iconst_0
    //   161: iload_3
    //   162: invokevirtual 267	java/io/OutputStream:write	([BII)V
    //   165: goto -19 -> 146
    //   168: astore_2
    //   169: aload_1
    //   170: astore_2
    //   171: aload 6
    //   173: astore_1
    //   174: aload_2
    //   175: invokestatic 273	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   178: aload_1
    //   179: invokestatic 273	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   182: aload 8
    //   184: invokevirtual 223	java/io/File:exists	()Z
    //   187: ifeq +123 -> 310
    //   190: aload 8
    //   192: invokevirtual 226	java/io/File:delete	()Z
    //   195: istore 4
    //   197: aload 9
    //   199: aload 8
    //   201: invokevirtual 277	java/io/File:renameTo	(Ljava/io/File;)Z
    //   204: istore 5
    //   206: ldc 52
    //   208: iconst_1
    //   209: new 204	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 279
    //   219: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: iload 5
    //   224: invokevirtual 282	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   227: ldc_w 284
    //   230: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: iload 4
    //   235: invokevirtual 282	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   238: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 60	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: iload 5
    //   246: ireturn
    //   247: aload_1
    //   248: invokestatic 273	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   251: aload 6
    //   253: invokestatic 273	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   256: goto -74 -> 182
    //   259: astore_2
    //   260: aconst_null
    //   261: astore_1
    //   262: aload 7
    //   264: astore 6
    //   266: aload_1
    //   267: invokestatic 273	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   270: aload 6
    //   272: invokestatic 273	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   275: aload_2
    //   276: athrow
    //   277: astore_2
    //   278: aload 7
    //   280: astore 6
    //   282: goto -16 -> 266
    //   285: astore_2
    //   286: goto -20 -> 266
    //   289: astore_1
    //   290: aconst_null
    //   291: astore_1
    //   292: aload 6
    //   294: astore_2
    //   295: goto -121 -> 174
    //   298: astore_2
    //   299: aconst_null
    //   300: astore 6
    //   302: aload_1
    //   303: astore_2
    //   304: aload 6
    //   306: astore_1
    //   307: goto -133 -> 174
    //   310: iconst_1
    //   311: istore 4
    //   313: goto -116 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	vgq
    //   0	316	1	paramString1	String
    //   0	316	2	paramString2	String
    //   151	11	3	i	int
    //   195	117	4	bool1	boolean
    //   204	41	5	bool2	boolean
    //   4	301	6	localObject1	Object
    //   1	278	7	localObject2	Object
    //   30	170	8	localFile1	File
    //   72	126	9	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   140	146	168	java/lang/Exception
    //   146	152	168	java/lang/Exception
    //   157	165	168	java/lang/Exception
    //   74	88	259	finally
    //   88	129	259	finally
    //   129	140	277	finally
    //   140	146	285	finally
    //   146	152	285	finally
    //   157	165	285	finally
    //   74	88	289	java/lang/Exception
    //   88	129	289	java/lang/Exception
    //   129	140	298	java/lang/Exception
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0);
    String str;
    boolean bool1;
    if (paramBoolean)
    {
      str = "qcircle-plugin";
      str = ((SharedPreferences)localObject).getString(str, "");
      localObject = new StringBuilder().append("checkAssetFileUpdate() :");
      if (paramString.equals(str)) {
        break label117;
      }
      bool1 = true;
      label71:
      QLog.i("QCIRCLE_PLUGIN", 1, bool1 + " ,isZip:" + paramBoolean);
      if (paramString.equals(str)) {
        break label122;
      }
    }
    label117:
    label122:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      return paramBoolean;
      str = "qcircle-pluginmanager";
      break;
      bool1 = false;
      break label71;
    }
  }
  
  private vgv b()
  {
    if ((!FileUtil.isFileExists(this.jdField_a_of_type_JavaLangString)) || (!FileUtil.isFileExists(this.b))) {}
    String str1;
    String str2;
    do
    {
      return null;
      str1 = vgp.a() + "test/" + "qcircle-plugin.jpg".replace(".jpg", ".zip");
      str2 = vgp.a() + "test/" + "qcircle-pluginmanager.jpg".replace(".jpg", ".apk");
      FileUtil.deleteFile(str1);
      FileUtils.copyFile(this.jdField_a_of_type_JavaLangString, str1);
      FileUtil.deleteFile(str2);
      FileUtils.copyFile(this.b, str2);
    } while ((!FileUtil.isFileExists(str1)) || (!FileUtil.isFileExists(str2)));
    return new vgv().d(this.c).a(str1).b(str2).a(this.jdField_a_of_type_Int);
  }
  
  private vgv c()
  {
    String str1 = vgp.a() + this.jdField_a_of_type_Int + "/" + "qcircle-plugin.jpg".replace(".jpg", ".zip");
    String str2 = vgp.a() + this.jdField_a_of_type_Int + "/" + "qcircle-pluginmanager.jpg".replace(".jpg", ".apk");
    if ((FileUtil.isFileExists(str1)) && (FileUtil.isFileExists(str2)))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseNet():net plugin has in folder");
      return new vgv().d(this.c).a(str1).b(str2).a(this.jdField_a_of_type_Int);
    }
    if ((!FileUtil.isFileExists(this.jdField_a_of_type_JavaLangString)) || (!FileUtil.isFileExists(this.b)))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseNet():net plugin source files are emptyzipFile:" + this.jdField_a_of_type_JavaLangString + "   mPluginManagerFile:" + this.b);
      return null;
    }
    boolean bool1 = FileUtils.copyFile(this.jdField_a_of_type_JavaLangString, str1);
    boolean bool2 = FileUtils.copyFile(this.b, str2);
    if ((bool1) && (bool2)) {
      return new vgv().d(this.c).a(str1).b(str2).a(this.jdField_a_of_type_Int);
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "parseNet():copy asset plugin fail");
    return null;
  }
  
  private vgv d()
  {
    String str1 = vgp.b() + AppSetting.f() + "/" + "qcircle-plugin.jpg".replace(".jpg", ".zip");
    String str2 = vgp.b() + AppSetting.f() + "/" + "qcircle-pluginmanager.jpg".replace(".jpg", ".apk");
    String str3 = vgp.b() + AppSetting.f() + "/";
    String str4 = vgp.b() + AppSetting.f() + "/" + "config.json";
    Object localObject = a();
    if (localObject != null)
    {
      String str5 = (String)((Map)localObject).get("qcircle-plugin");
      localObject = (String)((Map)localObject).get("qcircle-pluginmanager");
      boolean bool1 = a(str5, true);
      boolean bool2 = a((String)localObject, false);
      int i;
      if ((!FileUtils.fileExists(str1)) || (!FileUtil.isFileExists(str2)) || (!FileUtil.isFileExists(str4))) {
        i = 1;
      }
      while ((bool1) || (bool2) || (i != 0))
      {
        QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset():current file asset should unzip");
        FileUtils.delete(vgp.b(), false);
        bool1 = a(str5, str1);
        bool2 = a((String)localObject, str2);
        if ((bool1) && (bool2))
        {
          try
          {
            npo.a(new File(str1), str3);
            a(str5, (String)localObject);
            QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset():unZip asset plugin success");
            return a(str4, str1, str2, str3);
          }
          catch (IOException localIOException)
          {
            QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset():unZip asset plugin failed");
            localIOException.printStackTrace();
            return null;
          }
          i = 0;
          continue;
        }
        QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset():copy asset plugin fail");
      }
    }
    for (;;)
    {
      return null;
      QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset():current file asset has unzip already,version:" + this.jdField_a_of_type_Int);
      return a(str4, localIOException, str2, str3);
      QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset():no asset info");
    }
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 304	com/tencent/mobileqq/filemanager/util/FileUtil:isFileExists	(Ljava/lang/String;)Z
    //   4: ifne +7 -> 11
    //   7: ldc_w 287
    //   10: areturn
    //   11: new 219	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aconst_null
    //   21: astore_2
    //   22: new 204	java/lang/StringBuilder
    //   25: dup
    //   26: ldc_w 287
    //   29: invokespecial 401	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: astore_3
    //   33: new 403	java/io/BufferedReader
    //   36: dup
    //   37: new 405	java/io/InputStreamReader
    //   40: dup
    //   41: new 407	java/io/FileInputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 408	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 411	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   52: invokespecial 414	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 417	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +32 -> 94
    //   65: aload_3
    //   66: aload_2
    //   67: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 419
    //   73: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: goto -21 -> 56
    //   80: astore_2
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 422	java/io/BufferedReader:close	()V
    //   89: aload_3
    //   90: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: areturn
    //   94: aload_1
    //   95: ifnull -6 -> 89
    //   98: aload_1
    //   99: invokevirtual 422	java/io/BufferedReader:close	()V
    //   102: goto -13 -> 89
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   110: goto -21 -> 89
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   118: goto -29 -> 89
    //   121: astore_1
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 422	java/io/BufferedReader:close	()V
    //   130: aload_1
    //   131: athrow
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   137: goto -7 -> 130
    //   140: astore_3
    //   141: aload_1
    //   142: astore_2
    //   143: aload_3
    //   144: astore_1
    //   145: goto -23 -> 122
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_1
    //   151: goto -70 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	vgq
    //   0	154	1	paramString	String
    //   21	46	2	str1	String
    //   80	47	2	localException	Exception
    //   132	2	2	localIOException	IOException
    //   142	1	2	str2	String
    //   32	58	3	localStringBuilder	StringBuilder
    //   140	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   56	61	80	java/lang/Exception
    //   65	77	80	java/lang/Exception
    //   98	102	105	java/io/IOException
    //   85	89	113	java/io/IOException
    //   33	56	121	finally
    //   126	130	132	java/io/IOException
    //   56	61	140	finally
    //   65	77	140	finally
    //   33	56	148	java/lang/Exception
  }
  
  public vgv a()
  {
    if ("Q_CIRCLE_PLUGIN_ASSET".equals(this.c)) {
      return d();
    }
    if ("Q_CIRCLE_PLUGIN_NETWORK".equals(this.c)) {
      return c();
    }
    if ("Q_CIRCLE_PLUGIN_TEST".equals(this.c)) {
      return b();
    }
    return null;
  }
  
  public vgv a(String paramString)
  {
    paramString = new JSONObject(paramString);
    vgv localvgv = new vgv();
    localvgv.a(paramString.getInt("version"));
    return localvgv;
  }
  
  vgv a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = a(paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    try
    {
      localObject = a((String)localObject);
      ((vgv)localObject).a(paramString2);
      ((vgv)localObject).d(this.c);
      ((vgv)localObject).b(paramString3);
      ((vgv)localObject).e(paramString4);
      ((vgv)localObject).c(paramString1);
      return localObject;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgq
 * JD-Core Version:    0.7.0.1
 */