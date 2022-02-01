package com.tencent.biz.qqstory.takevideo.artfilter;

import acbn;
import alab;
import android.text.TextUtils;
import aopo;
import aqhq;
import aquy;
import aszr;
import aurf;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import rfb;
import rfd;
import rfe;

public class ArtFilterManager
  implements Manager
{
  public static final String aAa = acbn.SDCARD_PATH + "artfilter/";
  public static final String aAb = acbn.SDCARD_PATH + "pddata/prd/picedit/artfilter/";
  public static int bqK;
  public rfd a;
  public boolean aHy;
  private aquy jdField_b_of_type_Aquy;
  private aurf jdField_b_of_type_Aurf;
  private AppInterface mApp;
  private List<rfb> oH;
  
  /* Error */
  public ArtFilterManager(AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokespecial 59	java/lang/Object:<init>	()V
    //   7: aload_0
    //   8: new 61	rff
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 64	rff:<init>	(Lcom/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager;)V
    //   16: putfield 66	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_b_of_type_Aquy	Laquy;
    //   19: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +11 -> 33
    //   25: ldc 74
    //   27: iconst_2
    //   28: ldc 76
    //   30: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: aload_1
    //   35: putfield 82	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:mApp	Lcom/tencent/common/app/AppInterface;
    //   38: aload_0
    //   39: new 84	aurf
    //   42: dup
    //   43: invokestatic 90	com/tencent/mobileqq/app/ThreadManager:getFileThreadLooper	()Landroid/os/Looper;
    //   46: aconst_null
    //   47: invokespecial 93	aurf:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   50: putfield 95	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_b_of_type_Aurf	Laurf;
    //   53: aload_1
    //   54: invokevirtual 100	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   57: invokestatic 104	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:fu	(Ljava/lang/String;)Z
    //   60: ifeq +139 -> 199
    //   63: new 106	java/io/File
    //   66: dup
    //   67: new 30	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   74: getstatic 50	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:aAa	Ljava/lang/String;
    //   77: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 108
    //   82: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 115	java/io/File:length	()J
    //   96: l2i
    //   97: newarray byte
    //   99: astore 5
    //   101: new 117	java/io/FileInputStream
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   109: astore_2
    //   110: new 122	java/io/BufferedInputStream
    //   113: dup
    //   114: aload_2
    //   115: invokespecial 125	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   118: astore_1
    //   119: aload_1
    //   120: astore 4
    //   122: aload_2
    //   123: astore_3
    //   124: aload_1
    //   125: aload 5
    //   127: invokevirtual 129	java/io/BufferedInputStream:read	([B)I
    //   130: pop
    //   131: aload_1
    //   132: astore 4
    //   134: aload_2
    //   135: astore_3
    //   136: new 131	java/lang/String
    //   139: dup
    //   140: aload 5
    //   142: invokespecial 134	java/lang/String:<init>	([B)V
    //   145: astore 5
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   155: aload 5
    //   157: astore_1
    //   158: aload_2
    //   159: ifnull +10 -> 169
    //   162: aload_2
    //   163: invokevirtual 138	java/io/FileInputStream:close	()V
    //   166: aload 5
    //   168: astore_1
    //   169: aload_0
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual 142	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:parse	(Ljava/lang/String;)Ljava/util/List;
    //   175: putfield 144	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:oH	Ljava/util/List;
    //   178: aload_0
    //   179: getfield 144	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:oH	Ljava/util/List;
    //   182: ifnonnull +145 -> 327
    //   185: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +11 -> 199
    //   191: ldc 74
    //   193: iconst_2
    //   194: ldc 146
    //   196: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +11 -> 213
    //   205: ldc 74
    //   207: iconst_2
    //   208: ldc 148
    //   210: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: return
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   219: goto -64 -> 155
    //   222: astore_1
    //   223: aload_1
    //   224: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   227: aload 5
    //   229: astore_1
    //   230: goto -61 -> 169
    //   233: astore 5
    //   235: aconst_null
    //   236: astore_1
    //   237: aconst_null
    //   238: astore_2
    //   239: aload_1
    //   240: astore 4
    //   242: aload_2
    //   243: astore_3
    //   244: aload 5
    //   246: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   249: aload_1
    //   250: ifnull +7 -> 257
    //   253: aload_1
    //   254: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   257: aload_2
    //   258: ifnull +99 -> 357
    //   261: aload_2
    //   262: invokevirtual 138	java/io/FileInputStream:close	()V
    //   265: aconst_null
    //   266: astore_1
    //   267: goto -98 -> 169
    //   270: astore_1
    //   271: aload_1
    //   272: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   275: goto -18 -> 257
    //   278: astore_1
    //   279: aload_1
    //   280: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   283: aconst_null
    //   284: astore_1
    //   285: goto -116 -> 169
    //   288: astore_1
    //   289: aconst_null
    //   290: astore_2
    //   291: aload 4
    //   293: ifnull +8 -> 301
    //   296: aload 4
    //   298: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 138	java/io/FileInputStream:close	()V
    //   309: aload_1
    //   310: athrow
    //   311: astore_3
    //   312: aload_3
    //   313: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   316: goto -15 -> 301
    //   319: astore_2
    //   320: aload_2
    //   321: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   324: goto -15 -> 309
    //   327: aload_0
    //   328: iconst_0
    //   329: invokevirtual 155	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:tH	(Z)V
    //   332: goto -133 -> 199
    //   335: astore_1
    //   336: goto -45 -> 291
    //   339: astore_1
    //   340: aload_3
    //   341: astore_2
    //   342: goto -51 -> 291
    //   345: astore 5
    //   347: aconst_null
    //   348: astore_1
    //   349: goto -110 -> 239
    //   352: astore 5
    //   354: goto -115 -> 239
    //   357: aconst_null
    //   358: astore_1
    //   359: goto -190 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	ArtFilterManager
    //   0	362	1	paramAppInterface	AppInterface
    //   109	197	2	localFileInputStream1	java.io.FileInputStream
    //   319	2	2	localIOException1	IOException
    //   341	1	2	localObject1	Object
    //   123	121	3	localFileInputStream2	java.io.FileInputStream
    //   311	30	3	localIOException2	IOException
    //   1	296	4	localAppInterface	AppInterface
    //   99	129	5	localObject2	Object
    //   233	12	5	localIOException3	IOException
    //   345	1	5	localIOException4	IOException
    //   352	1	5	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   151	155	214	java/io/IOException
    //   162	166	222	java/io/IOException
    //   63	110	233	java/io/IOException
    //   253	257	270	java/io/IOException
    //   261	265	278	java/io/IOException
    //   63	110	288	finally
    //   296	301	311	java/io/IOException
    //   305	309	319	java/io/IOException
    //   110	119	335	finally
    //   124	131	339	finally
    //   136	147	339	finally
    //   244	249	339	finally
    //   110	119	345	java/io/IOException
    //   124	131	352	java/io/IOException
    //   136	147	352	java/io/IOException
  }
  
  private void P(String paramString1, String paramString2, String paramString3)
  {
    File localFile = new File(paramString2);
    paramString3 = new rfe(this, (QQAppInterface)this.mApp, paramString2, paramString1, paramString2, localFile, paramString3);
    boolean bool = ((aopo)this.mApp.getManager(193)).a(10015, "prd", paramString1, 0, paramString1, paramString2, 2, 0, true, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "PreDownloadController ret:" + bool);
    }
  }
  
  private void a(List<rfb> paramList, rfd paramrfd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "[deleteOldResources] start");
    }
    Object localObject1 = new File(aAb);
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).isDirectory()) {
        break label740;
      }
      if (paramList != null) {
        break label53;
      }
      aqhq.cn(aAb);
    }
    label53:
    do
    {
      return;
      localObject1 = ((File)localObject1).listFiles();
    } while (localObject1 == null);
    int k = localObject1.length;
    int i = 0;
    label72:
    Object localObject2;
    String str;
    int m;
    Object localObject3;
    int n;
    int j;
    rfb localrfb;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (!localObject2.isDirectory()) {
        break label682;
      }
      str = localObject2.getName();
      if (str.equals("loading"))
      {
        if (paramrfd != null)
        {
          m = paramrfd.version;
          str = paramrfd.version + ".zip";
          localObject3 = localObject2.listFiles();
          if (localObject3 != null)
          {
            n = localObject3.length;
            j = 0;
            if (j < n)
            {
              localrfb = localObject3[j];
              if (localrfb.isDirectory()) {
                if (!localrfb.getName().equals(String.valueOf(m)))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old loading dir: " + localObject2.getName() + File.separator + localrfb.getName());
                  }
                  aqhq.cn(localrfb.getAbsolutePath());
                }
              }
              for (;;)
              {
                j += 1;
                break;
                if (!localrfb.getName().equals(str))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old loading file: " + localObject2.getName() + File.separator + localrfb.getName());
                  }
                  localrfb.delete();
                }
              }
            }
          }
        }
      }
      else {
        if (!str.equals("artfiltertemp")) {
          break label355;
        }
      }
    }
    label355:
    label740:
    label766:
    for (;;)
    {
      i += 1;
      break label72;
      break;
      localObject3 = paramList.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localrfb = (rfb)((Iterator)localObject3).next();
          if (str.equals(localrfb.name))
          {
            m = localrfb.version;
            str = localrfb.version + ".zip";
            localObject3 = localObject2.listFiles();
            if (localObject3 != null)
            {
              n = localObject3.length;
              j = 0;
              if (j < n)
              {
                localrfb = localObject3[j];
                if (localrfb.isDirectory()) {
                  if (!localrfb.getName().equals(String.valueOf(m)))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old dir: " + localObject2.getName() + File.separator + localrfb.getName());
                    }
                    aqhq.cn(localrfb.getAbsolutePath());
                  }
                }
                for (;;)
                {
                  j += 1;
                  break;
                  if (!localrfb.getName().equals(str))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old file: " + localObject2.getName() + File.separator + localrfb.getName());
                    }
                    localrfb.delete();
                  }
                }
              }
            }
          }
        }
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label766;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old dir: " + localObject2.getName());
        }
        aqhq.cn(localObject2.getAbsolutePath());
        break;
        if (localObject2.getName().endsWith("artfilter.config")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete error file: " + localObject2.getName());
        }
        localObject2.delete();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete photo plus root directory");
        }
        ((File)localObject1).delete();
        return;
      }
    }
  }
  
  private static boolean fu(String paramString)
  {
    return new File(aAa + "artfilter.config").exists();
  }
  
  public static int to()
  {
    if (bqK < 640) {
      return 640;
    }
    return bqK;
  }
  
  public List<rfb> cc()
  {
    if (this.oH == null) {
      return null;
    }
    return new ArrayList(this.oH);
  }
  
  public String dU(String paramString)
  {
    try
    {
      str1 = alab.getFileMD5String(paramString);
      paramString = str1;
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      String str1;
      paramString = new File(paramString);
      bool = paramString.exists();
      if (!bool) {
        break label81;
      }
      for (;;)
      {
        try
        {
          paramString = aszr.getFileMD5String(paramString);
          if (paramString == null) {
            continue;
          }
        }
        catch (IOException paramString)
        {
          paramString = null;
          continue;
        }
        str2 = paramString;
        if (paramString != null) {
          break;
        }
        return "";
        paramString = "";
      }
    }
    finally
    {
      if (0 != 0) {
        break label79;
      }
      return "";
      label79:
      return null;
    }
    return str1;
    for (;;)
    {
      boolean bool;
      String str2;
      label81:
      paramString = null;
    }
  }
  
  public String mU()
  {
    if (this.a != null) {
      return this.a.mU();
    }
    return null;
  }
  
  public void onDestroy()
  {
    if (this.jdField_b_of_type_Aurf != null)
    {
      this.jdField_b_of_type_Aurf.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_Aurf = null;
    }
  }
  
  public List<rfb> parse(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      Object localObject = paramString.getString("artisticFilter_switch");
      if ((localObject != null) && (((String)localObject).equals("1"))) {
        this.aHy = true;
      }
      if (!this.aHy) {
        return null;
      }
      this.a = rfd.a(paramString.getJSONObject("artisticFilter_loading"));
      bqK = Integer.parseInt(paramString.getString("artisticFilter_maxside"));
      paramString = paramString.getJSONArray("artisticFilter_templates");
      localObject = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        ((List)localObject).add(new rfb(localJSONObject.getString("id"), localJSONObject.getInt("version"), localJSONObject.getInt("priority"), localJSONObject.getString("url"), localJSONObject.getString("name"), localJSONObject.optString("md5"), localJSONObject.optString("pron")));
        i += 1;
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
  }
  
  public void sv(String paramString)
  {
    String str = paramString.substring(0, paramString.indexOf(".zip")) + File.separator;
    try
    {
      aqhq.W(paramString, str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterManager", 2, "[unzip] success: " + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArtFilterManager", 2, "[unzip]", paramString);
    }
  }
  
  public void tH(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "[updateFilterResource] isDelete=" + paramBoolean);
    }
    this.jdField_b_of_type_Aurf.post(new UpdateTask(this.oH, paramBoolean, this.a));
  }
  
  class UpdateTask
    implements Runnable
  {
    private rfd b;
    private boolean isDelete;
    private List<rfb> oI;
    
    public UpdateTask(boolean paramBoolean, rfd paramrfd)
    {
      if (paramBoolean != null) {
        this.oI = new ArrayList(paramBoolean);
      }
      Object localObject;
      if (localObject != null) {}
      try
      {
        this.b = ((rfd)localObject.clone());
        this.isDelete = paramrfd;
        return;
      }
      catch (CloneNotSupportedException this$1)
      {
        for (;;)
        {
          ArtFilterManager.this.printStackTrace();
          this.b = null;
        }
      }
    }
    
    public void run()
    {
      int i;
      Object localObject2;
      Object localObject3;
      boolean bool;
      try
      {
        if (this.isDelete) {
          ArtFilterManager.a(ArtFilterManager.this, this.oI, this.b);
        }
        if (this.oI != null) {
          break label827;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[updateFilterResource] saved filters = null");
        }
        return;
      }
      finally {}
      String str;
      if (i < this.oI.size())
      {
        rfb localrfb = (rfb)this.oI.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[updateFilterResource] saved artFilter:" + localrfb);
        }
        localObject2 = ArtFilterManager.aAb + localrfb.getZipFilePath();
        localObject3 = new File((String)localObject2);
        if (!((File)localObject3).exists())
        {
          File localFile = new File(ArtFilterManager.aAa + localrfb.getZipFilePath());
          if (localFile.exists())
          {
            bool = aqhq.copyFile(localFile.getAbsolutePath(), ((File)localObject3).getAbsolutePath());
            if (bool) {
              aqhq.cn(localFile.getParentFile().getAbsolutePath());
            }
            if (QLog.isColorLevel()) {
              QLog.e("ArtFilterManager", 2, "copy artfilter resource result:" + bool);
            }
          }
        }
        if (!((File)localObject3).exists())
        {
          ArtFilterManager.a(ArtFilterManager.this, localrfb.url, (String)localObject2, localrfb.md5);
        }
        else
        {
          localObject3 = localrfb.getUnzippedDir();
          if (!new File(ArtFilterManager.aAb + (String)localObject3 + localrfb.getThumbImageFileName()).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.e("ArtFilterManager", 2, "[updateFilterResource] zip exist but resource not exist:" + localrfb.getZipFilePath());
            }
            if (TextUtils.isEmpty(localrfb.md5))
            {
              ArtFilterManager.this.sv((String)localObject2);
            }
            else
            {
              localObject3 = ArtFilterManager.this.dU((String)localObject2);
              if (localObject1.md5.equalsIgnoreCase((String)localObject3))
              {
                ArtFilterManager.this.sv((String)localObject2);
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ArtFilterManager", 2, "[updateFilterResource] checkMd5 failed: " + (String)localObject2);
                }
                aqhq.deleteFile((String)localObject2);
              }
            }
          }
        }
      }
      else if (this.b != null)
      {
        str = this.b.getZipPath();
        localObject2 = new File(str);
        if (!((File)localObject2).exists())
        {
          localObject3 = new File(ArtFilterManager.aAa + this.b.mW());
          if (((File)localObject3).exists())
          {
            bool = aqhq.copyFile(((File)localObject3).getAbsolutePath(), ((File)localObject2).getAbsolutePath());
            if (bool) {
              aqhq.cn(((File)localObject3).getParentFile().getAbsolutePath());
            }
            if (QLog.isColorLevel()) {
              QLog.e("ArtFilterManager", 2, "copy loading resource result:" + bool);
            }
          }
        }
        if (((File)localObject2).exists()) {
          break label635;
        }
        ArtFilterManager.a(ArtFilterManager.this, this.b.url, str, this.b.md5);
      }
      label822:
      label827:
      label839:
      label844:
      label847:
      for (;;)
      {
        label631:
        return;
        label635:
        localObject2 = new File(this.b.mV());
        if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory()))
        {
          if (!QLog.isColorLevel()) {
            break label839;
          }
          QLog.e("ArtFilterManager", 2, "[updateFilterResource] loading zip exist but loading resource not exist:" + str);
        }
        for (;;)
        {
          if (i == 0) {
            break label847;
          }
          localObject2 = ArtFilterManager.this.dU(str);
          if (this.b.md5.equalsIgnoreCase((String)localObject2))
          {
            ArtFilterManager.this.sv(str);
            break label631;
            localObject2 = ((File)localObject2).listFiles();
            if ((localObject2 != null) && (localObject2.length == this.b.frameCount)) {
              break label822;
            }
            if (!QLog.isColorLevel()) {
              break label844;
            }
            QLog.e("ArtFilterManager", 2, "[updateFilterResource] loading resource null or count is wrong");
            break label844;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ArtFilterManager", 2, "[updateFilterResource] check loading Md5 failed: " + str);
          }
          aqhq.deleteFile(str);
          break label631;
          i = 0;
          continue;
          i = 0;
          break;
          i += 1;
          break;
          i = 1;
          continue;
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager
 * JD-Core Version:    0.7.0.1
 */