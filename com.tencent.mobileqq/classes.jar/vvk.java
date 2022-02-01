import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
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

public class vvk
  implements Callable<vvp>
{
  int jdField_a_of_type_Int;
  QCirclePluginInfo jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  public vvk(vvj paramvvj, String paramString, QCirclePluginInfo paramQCirclePluginInfo)
  {
    this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo = paramQCirclePluginInfo;
    this.c = paramString;
    this.jdField_a_of_type_JavaLangString = paramQCirclePluginInfo.pluginZipPath;
    this.b = paramQCirclePluginInfo.pluginManagerPath;
    this.jdField_a_of_type_Int = paramQCirclePluginInfo.version;
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
        if ((arrayOfString == null) || (arrayOfString.length == 0))
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
      }
      for (;;)
      {
        return null;
        a(localArrayList1, "qcircle-pluginmanager");
        a(localArrayList2, "qcircle-plugin");
        if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
        {
          localHashMap.put("qcircle-pluginmanager", localArrayList1.get(0));
          localHashMap.put("qcircle-plugin", localArrayList2.get(0));
          return localHashMap;
        }
        QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset():empty list");
      }
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
    Collections.sort(paramList, new vvl(this, paramString));
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
        paramList = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(paramList);
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
    //   7: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_2
    //   14: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: new 238	java/io/File
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 239	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 8
    //   32: aload 8
    //   34: invokevirtual 242	java/io/File:exists	()Z
    //   37: ifeq +9 -> 46
    //   40: aload 8
    //   42: invokevirtual 245	java/io/File:delete	()Z
    //   45: pop
    //   46: new 238	java/io/File
    //   49: dup
    //   50: new 223	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   57: aload_2
    //   58: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 247
    //   63: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 239	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 9
    //   74: aload 9
    //   76: invokevirtual 242	java/io/File:exists	()Z
    //   79: ifeq +9 -> 88
    //   82: aload 9
    //   84: invokevirtual 245	java/io/File:delete	()Z
    //   87: pop
    //   88: aload 9
    //   90: invokevirtual 250	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   93: invokestatic 255	com/tencent/mobileqq/utils/FileUtils:createFileIfNotExits	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield 18	vvk:jdField_a_of_type_Vvj	Lvvj;
    //   100: invokestatic 260	vvj:a	(Lvvj;)Landroid/content/Context;
    //   103: invokevirtual 263	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   106: new 223	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 265
    //   116: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokevirtual 269	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   129: astore_1
    //   130: new 271	java/io/FileOutputStream
    //   133: dup
    //   134: aload 9
    //   136: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   139: astore 6
    //   141: sipush 8192
    //   144: newarray byte
    //   146: astore_2
    //   147: aload_1
    //   148: aload_2
    //   149: invokevirtual 280	java/io/InputStream:read	([B)I
    //   152: istore_3
    //   153: iload_3
    //   154: iconst_m1
    //   155: if_icmpeq +93 -> 248
    //   158: aload 6
    //   160: aload_2
    //   161: iconst_0
    //   162: iload_3
    //   163: invokevirtual 286	java/io/OutputStream:write	([BII)V
    //   166: goto -19 -> 147
    //   169: astore_2
    //   170: aload_1
    //   171: astore_2
    //   172: aload 6
    //   174: astore_1
    //   175: aload_2
    //   176: invokestatic 292	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   179: aload_1
    //   180: invokestatic 292	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   183: aload 8
    //   185: invokevirtual 242	java/io/File:exists	()Z
    //   188: ifeq +123 -> 311
    //   191: aload 8
    //   193: invokevirtual 245	java/io/File:delete	()Z
    //   196: istore 4
    //   198: aload 9
    //   200: aload 8
    //   202: invokevirtual 296	java/io/File:renameTo	(Ljava/io/File;)Z
    //   205: istore 5
    //   207: ldc 66
    //   209: iconst_1
    //   210: new 223	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 298
    //   220: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload 5
    //   225: invokevirtual 301	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   228: ldc_w 303
    //   231: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: iload 4
    //   236: invokevirtual 301	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   239: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: iload 5
    //   247: ireturn
    //   248: aload_1
    //   249: invokestatic 292	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   252: aload 6
    //   254: invokestatic 292	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   257: goto -74 -> 183
    //   260: astore_2
    //   261: aconst_null
    //   262: astore_1
    //   263: aload 7
    //   265: astore 6
    //   267: aload_1
    //   268: invokestatic 292	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   271: aload 6
    //   273: invokestatic 292	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   276: aload_2
    //   277: athrow
    //   278: astore_2
    //   279: aload 7
    //   281: astore 6
    //   283: goto -16 -> 267
    //   286: astore_2
    //   287: goto -20 -> 267
    //   290: astore_1
    //   291: aconst_null
    //   292: astore_1
    //   293: aload 6
    //   295: astore_2
    //   296: goto -121 -> 175
    //   299: astore_2
    //   300: aconst_null
    //   301: astore 6
    //   303: aload_1
    //   304: astore_2
    //   305: aload 6
    //   307: astore_1
    //   308: goto -133 -> 175
    //   311: iconst_1
    //   312: istore 4
    //   314: goto -116 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	vvk
    //   0	317	1	paramString1	String
    //   0	317	2	paramString2	String
    //   152	11	3	i	int
    //   196	117	4	bool1	boolean
    //   205	41	5	bool2	boolean
    //   4	302	6	localObject1	Object
    //   1	279	7	localObject2	Object
    //   30	171	8	localFile1	File
    //   72	127	9	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   141	147	169	java/lang/Exception
    //   147	153	169	java/lang/Exception
    //   158	166	169	java/lang/Exception
    //   74	88	260	finally
    //   88	130	260	finally
    //   130	141	278	finally
    //   141	147	286	finally
    //   147	153	286	finally
    //   158	166	286	finally
    //   74	88	290	java/lang/Exception
    //   88	130	290	java/lang/Exception
    //   130	141	299	java/lang/Exception
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
  
  private vvp b()
  {
    if ((!FileUtil.isFileExists(this.jdField_a_of_type_JavaLangString)) || (!FileUtil.isFileExists(this.b))) {}
    String str1;
    String str2;
    do
    {
      return null;
      str1 = vvj.a() + "test/" + "qcircle-plugin.jpg".replace(".jpg", ".zip");
      str2 = vvj.a() + "test/" + "qcircle-pluginmanager.jpg".replace(".jpg", ".apk");
      FileUtil.deleteFile(str1);
      FileUtils.copyFile(this.jdField_a_of_type_JavaLangString, str1);
      FileUtil.deleteFile(str2);
      FileUtils.copyFile(this.b, str2);
    } while ((!FileUtil.isFileExists(str1)) || (!FileUtil.isFileExists(str2)));
    return new vvp().d(this.c).a(str1).b(str2).a(this.jdField_a_of_type_Int);
  }
  
  private vvp c()
  {
    String str1 = this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginZipPath;
    String str2 = this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginManagerPath;
    if ((FileUtil.isFileExists(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginZipPath)) && (FileUtil.isFileExists(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginManagerPath)) && (vvj.a(this.jdField_a_of_type_Vvj, this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo)))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseNet():net plugin has in folder");
      return new vvp().d(this.c).a(str1).b(str2).a(this.jdField_a_of_type_Int);
    }
    return null;
  }
  
  private vvp d()
  {
    String str1 = vvj.b() + AppSetting.f() + "/" + "qcircle-plugin.jpg".replace(".jpg", ".zip");
    String str2 = vvj.b() + AppSetting.f() + "/" + "qcircle-pluginmanager.jpg".replace(".jpg", ".apk");
    String str3 = vvj.b() + AppSetting.f() + "/";
    String str4 = vvj.b() + AppSetting.f() + "/" + "config.json";
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
        FileUtils.delete(vvj.b(), false);
        bool1 = a(str5, str1);
        bool2 = a((String)localObject, str2);
        if ((bool1) && (bool2))
        {
          try
          {
            nwp.a(new File(str1), str3);
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
    //   1: invokestatic 323	com/tencent/mobileqq/filemanager/util/FileUtil:isFileExists	(Ljava/lang/String;)Z
    //   4: ifne +7 -> 11
    //   7: ldc_w 306
    //   10: areturn
    //   11: new 238	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 239	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aconst_null
    //   21: astore_2
    //   22: new 223	java/lang/StringBuilder
    //   25: dup
    //   26: ldc_w 306
    //   29: invokespecial 417	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: astore_3
    //   33: new 419	java/io/BufferedReader
    //   36: dup
    //   37: new 421	java/io/InputStreamReader
    //   40: dup
    //   41: new 423	java/io/FileInputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 424	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 427	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   52: invokespecial 430	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 433	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +32 -> 94
    //   65: aload_3
    //   66: aload_2
    //   67: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 435
    //   73: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: goto -21 -> 56
    //   80: astore_2
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 438	java/io/BufferedReader:close	()V
    //   89: aload_3
    //   90: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: areturn
    //   94: aload_1
    //   95: ifnull -6 -> 89
    //   98: aload_1
    //   99: invokevirtual 438	java/io/BufferedReader:close	()V
    //   102: goto -13 -> 89
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   110: goto -21 -> 89
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   118: goto -29 -> 89
    //   121: astore_1
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 438	java/io/BufferedReader:close	()V
    //   130: aload_1
    //   131: athrow
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 103	java/io/IOException:printStackTrace	()V
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
    //   0	154	0	this	vvk
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
  
  public vvp a()
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
  
  public vvp a(String paramString)
  {
    paramString = new JSONObject(paramString);
    vvp localvvp = new vvp();
    localvvp.a(paramString.getInt("version"));
    return localvvp;
  }
  
  vvp a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = a(paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    try
    {
      localObject = a((String)localObject);
      ((vvp)localObject).a(paramString2);
      ((vvp)localObject).d(this.c);
      ((vvp)localObject).b(paramString3);
      ((vvp)localObject).e(paramString4);
      ((vvp)localObject).c(paramString1);
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
 * Qualified Name:     vvk
 * JD-Core Version:    0.7.0.1
 */