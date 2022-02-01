import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.DexReleasor;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.startup.step.InstallPlugins;
import com.tencent.mobileqq.startup.step.UpdatePluginVersion;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;
import cooperation.plugin.PluginInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;

public class avgh
  implements Handler.Callback
{
  public static HandlerThread ai;
  public static String cKO = Build.FINGERPRINT;
  private avfs b;
  private String cKN;
  private Handler eb;
  private Context mContext;
  private boolean mIsReady;
  private HashMap<String, PluginInfo> qy;
  
  public avgh(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.qy = new HashMap();
    this.eb = new Handler(g().getLooper(), this);
    this.cKN = paramString;
    this.b = avfs.a(this.mContext);
    init();
  }
  
  public static String FP()
  {
    if (cKO == null) {
      return "";
    }
    return cKO;
  }
  
  private void ZP(String paramString)
  {
    avgf.c(paramString, getPluginInstallDir(this.mContext));
  }
  
  private void a(PluginInfo paramPluginInfo)
  {
    avgf.a(paramPluginInfo, getPluginInstallDir(this.mContext));
  }
  
  private boolean a(PluginInfo paramPluginInfo)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (paramPluginInfo != null)
    {
      bool2 = bool1;
      if (paramPluginInfo.mInstalledPath != null)
      {
        File localFile = new File(paramPluginInfo.mInstalledPath);
        bool1 = bool3;
        if (localFile != null)
        {
          bool1 = bool3;
          if (localFile.exists())
          {
            bool1 = bool3;
            if (localFile.isFile())
            {
              if (!avgf.a(paramPluginInfo, localFile)) {
                break label137;
              }
              bool1 = true;
              paramPluginInfo.mState = 4;
              paramPluginInfo.mInstalledPath = localFile.getAbsolutePath();
            }
          }
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("plugin_tag", 2, "verifyInstalledPlugin :" + paramPluginInfo.mID + "," + bool1);
        bool2 = bool1;
      }
      return bool2;
      label137:
      tq(paramPluginInfo.mID);
      paramPluginInfo.mState = 0;
      bool1 = bool3;
    }
  }
  
  /* Error */
  private static boolean a(File paramFile, QZipFile paramQZipFile, ZipEntry paramZipEntry)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: iconst_1
    //   13: istore 4
    //   15: aload_1
    //   16: aload_2
    //   17: invokevirtual 168	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   20: astore_1
    //   21: aload_1
    //   22: astore 6
    //   24: aload 7
    //   26: astore 5
    //   28: aload 8
    //   30: astore_1
    //   31: aload 6
    //   33: astore_2
    //   34: aload_0
    //   35: invokevirtual 111	java/io/File:exists	()Z
    //   38: ifne +53 -> 91
    //   41: aload 7
    //   43: astore 5
    //   45: aload 8
    //   47: astore_1
    //   48: aload 6
    //   50: astore_2
    //   51: aload_0
    //   52: invokevirtual 172	java/io/File:getParentFile	()Ljava/io/File;
    //   55: astore 9
    //   57: aload 7
    //   59: astore 5
    //   61: aload 8
    //   63: astore_1
    //   64: aload 6
    //   66: astore_2
    //   67: aload 9
    //   69: invokevirtual 111	java/io/File:exists	()Z
    //   72: ifne +19 -> 91
    //   75: aload 7
    //   77: astore 5
    //   79: aload 8
    //   81: astore_1
    //   82: aload 6
    //   84: astore_2
    //   85: aload 9
    //   87: invokevirtual 175	java/io/File:mkdirs	()Z
    //   90: pop
    //   91: aload 7
    //   93: astore 5
    //   95: aload 8
    //   97: astore_1
    //   98: aload 6
    //   100: astore_2
    //   101: new 177	java/io/BufferedOutputStream
    //   104: dup
    //   105: new 179	java/io/FileOutputStream
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   113: invokespecial 185	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   116: invokestatic 190	awdj:a	(Ljava/io/OutputStream;)Lawdj;
    //   119: astore_0
    //   120: aload_0
    //   121: astore 5
    //   123: aload_0
    //   124: astore_1
    //   125: aload 6
    //   127: astore_2
    //   128: sipush 8192
    //   131: newarray byte
    //   133: astore 7
    //   135: aload_0
    //   136: astore 5
    //   138: aload_0
    //   139: astore_1
    //   140: aload 6
    //   142: astore_2
    //   143: aload 6
    //   145: aload 7
    //   147: invokevirtual 196	java/io/InputStream:read	([B)I
    //   150: istore_3
    //   151: iload_3
    //   152: ifle +66 -> 218
    //   155: aload_0
    //   156: astore 5
    //   158: aload_0
    //   159: astore_1
    //   160: aload 6
    //   162: astore_2
    //   163: aload_0
    //   164: aload 7
    //   166: iconst_0
    //   167: iload_3
    //   168: invokevirtual 202	java/io/OutputStream:write	([BII)V
    //   171: goto -36 -> 135
    //   174: astore_0
    //   175: aload 5
    //   177: astore_1
    //   178: aload 6
    //   180: astore_2
    //   181: ldc 131
    //   183: iconst_1
    //   184: aload_0
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   192: aload 6
    //   194: ifnull +8 -> 202
    //   197: aload 6
    //   199: invokevirtual 209	java/io/InputStream:close	()V
    //   202: aload 5
    //   204: ifnull +8 -> 212
    //   207: aload 5
    //   209: invokevirtual 210	java/io/OutputStream:close	()V
    //   212: iconst_0
    //   213: istore 4
    //   215: iload 4
    //   217: ireturn
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 209	java/io/InputStream:close	()V
    //   228: aload_0
    //   229: ifnull -14 -> 215
    //   232: aload_0
    //   233: invokevirtual 210	java/io/OutputStream:close	()V
    //   236: iconst_1
    //   237: ireturn
    //   238: astore_0
    //   239: iconst_1
    //   240: ireturn
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_2
    //   244: aload 6
    //   246: astore_1
    //   247: aload_2
    //   248: ifnull +7 -> 255
    //   251: aload_2
    //   252: invokevirtual 209	java/io/InputStream:close	()V
    //   255: aload_1
    //   256: ifnull +7 -> 263
    //   259: aload_1
    //   260: invokevirtual 210	java/io/OutputStream:close	()V
    //   263: aload_0
    //   264: athrow
    //   265: astore_1
    //   266: goto -38 -> 228
    //   269: astore_0
    //   270: goto -68 -> 202
    //   273: astore_0
    //   274: goto -62 -> 212
    //   277: astore_2
    //   278: goto -23 -> 255
    //   281: astore_1
    //   282: goto -19 -> 263
    //   285: astore_0
    //   286: goto -39 -> 247
    //   289: astore_0
    //   290: aconst_null
    //   291: astore 6
    //   293: goto -118 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramFile	File
    //   0	296	1	paramQZipFile	QZipFile
    //   0	296	2	paramZipEntry	ZipEntry
    //   150	18	3	i	int
    //   13	203	4	bool	boolean
    //   1	207	5	localObject1	Object
    //   4	288	6	localQZipFile	QZipFile
    //   10	155	7	arrayOfByte	byte[]
    //   7	89	8	localObject2	Object
    //   55	31	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   34	41	174	java/io/IOException
    //   51	57	174	java/io/IOException
    //   67	75	174	java/io/IOException
    //   85	91	174	java/io/IOException
    //   101	120	174	java/io/IOException
    //   128	135	174	java/io/IOException
    //   143	151	174	java/io/IOException
    //   163	171	174	java/io/IOException
    //   232	236	238	java/io/IOException
    //   15	21	241	finally
    //   223	228	265	java/io/IOException
    //   197	202	269	java/io/IOException
    //   207	212	273	java/io/IOException
    //   251	255	277	java/io/IOException
    //   259	263	281	java/io/IOException
    //   34	41	285	finally
    //   51	57	285	finally
    //   67	75	285	finally
    //   85	91	285	finally
    //   101	120	285	finally
    //   128	135	285	finally
    //   143	151	285	finally
    //   163	171	285	finally
    //   181	192	285	finally
    //   15	21	289	java/io/IOException
  }
  
  private static boolean a(String paramString1, String paramString2, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, String.format("unzip %s of file %s  into %s ", new Object[] { paramString2, paramString1, String.valueOf(paramFile) }));
    }
    Object localObject = null;
    try
    {
      QZipFile localQZipFile = new QZipFile(paramString1);
      localObject = localQZipFile;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("plugin_tag", 1, localIOException, new Object[0]);
      }
      paramString1 = localObject.entries();
      ZipEntry localZipEntry;
      do
      {
        if (!paramString1.hasMoreElements()) {
          break;
        }
        localZipEntry = (ZipEntry)paramString1.nextElement();
      } while ((localZipEntry.getName().contains("..")) || (!localZipEntry.getName().equals(paramString2)));
      return a(paramFile, localObject, localZipEntry);
    }
    if (localObject == null)
    {
      QLog.e("plugin_tag", 1, String.format("unzip %s error", new Object[] { paramString1 }));
      return false;
    }
    return false;
  }
  
  private boolean aKC()
  {
    boolean bool = false;
    if (TextUtils.isEmpty(this.cKN)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "verifyDownloadPath." + this.cKN + ", " + bool);
      }
      return bool;
      if (new File(this.cKN).exists()) {
        bool = true;
      }
    }
  }
  
  private void b(PluginInfo paramPluginInfo, avgh.a parama)
  {
    int i = 1;
    String str = paramPluginInfo.mID;
    QLog.d("plugin_tag", 1, "doSetupPlugin." + str);
    if (avgf.a(paramPluginInfo, this.mContext))
    {
      QLog.d("plugin_tag", 1, "plugin still running");
      if (parama != null) {
        parama.ZQ(str);
      }
      return;
    }
    if (!tp(str)) {}
    while (i != 0)
    {
      a(str, parama);
      return;
      i = 0;
    }
    a(paramPluginInfo, parama);
  }
  
  public static boolean cp(String paramString1, String paramString2)
  {
    if (!PluginUtils.isOsNeedReleaseDex()) {
      return true;
    }
    int j = avgc.fS(paramString1);
    Object localObject2;
    Object localObject1;
    label281:
    boolean bool;
    if (j > 1)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      DexReleasor localDexReleasor = new DexReleasor(paramString2, PluginUtils.getPluginInstallDir(localBaseApplicationImpl).getAbsolutePath() + File.separator);
      int i = 1;
      for (;;)
      {
        if (i < j)
        {
          localObject2 = String.format("classes%d.dex", new Object[] { Integer.valueOf(i + 1) });
          localObject1 = PluginUtils.getMultiDexName(paramString1, i + 1);
          if (-1L == localDexReleasor.getEntryCrcCode((String)localObject2))
          {
            QLog.d("plugin_tag", 1, "releaseMultiDexIfNeeded noDex " + (String)localObject2 + " " + paramString1);
            i += 1;
          }
          else
          {
            localObject1 = new File(PluginUtils.getPluginInstallDir(localBaseApplicationImpl).getAbsolutePath(), (String)localObject1);
            if (((File)localObject1).exists())
            {
              QLog.d("plugin_tag", 1, "releaseMultiDexIfNeeded  " + ((File)localObject1).getAbsolutePath() + " exsit,delete first");
              ((File)localObject1).delete();
            }
            a(paramString2, (String)localObject2, (File)localObject1);
            if ((localObject1 == null) || (!((File)localObject1).exists()))
            {
              paramString2 = new StringBuilder().append("releaseMultiDexIfNeeded failed ").append(i).append(" ");
              if (localObject1 != null)
              {
                paramString1 = ((File)localObject1).getAbsolutePath();
                QLog.d("plugin_tag", 1, paramString1);
                bool = false;
                label298:
                localDexReleasor.destroy();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return bool;
      paramString1 = " ";
      break label281;
      localObject2 = new StringBuilder(256);
      ((StringBuilder)localObject2).append("releaseMultiDexIfNeeded ");
      ((StringBuilder)localObject2).append(true);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      QLog.d("plugin_tag", 1, ((StringBuilder)localObject2).toString());
      break;
      bool = true;
      break label298;
      bool = true;
    }
  }
  
  public static HandlerThread g()
  {
    if (ai == null) {}
    try
    {
      if (ai == null)
      {
        ai = ThreadManager.newFreeHandlerThread("QQ_PLUGIN", 0);
        ai.start();
      }
      return ai;
    }
    finally {}
  }
  
  static File getPluginInstallDir(Context paramContext)
  {
    return PluginUtils.getPluginInstallDir(paramContext);
  }
  
  private boolean tp(String paramString)
  {
    if (!aKC()) {}
    do
    {
      return false;
      paramString = new File(this.cKN).list(new avgi(this, paramString));
    } while ((paramString == null) || (paramString.length <= 0));
    return true;
  }
  
  private boolean tq(String paramString)
  {
    PluginInfo localPluginInfo = (PluginInfo)this.qy.get(paramString);
    if ((localPluginInfo != null) && (avgf.a(localPluginInfo, this.mContext)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      return false;
    }
    this.qy.remove(paramString);
    ZP(paramString);
    if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
    {
      paramString = new File(localPluginInfo.mInstalledPath);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
    return true;
  }
  
  public void a(PluginInfo paramPluginInfo, avgh.a parama)
  {
    paramPluginInfo = new Pair(paramPluginInfo, parama);
    this.eb.obtainMessage(66816, paramPluginInfo).sendToTarget();
  }
  
  public void a(String paramString, File paramFile, avgh.a parama)
  {
    int i = 1;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFile);
    if ((PluginUtils.isOsNeedReleaseDex()) && (avgc.fS(paramString) > 1)) {
      localArrayList.add(PluginUtils.getMultiDexSecondDex(this.mContext, paramString));
    }
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        paramFile = Dex2Oat.getCurrentInstructionSet();
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "dex2Oat targetISA = " + paramFile + " " + paramString + " " + localArrayList.size());
        }
        if (!TextUtils.isEmpty(paramFile))
        {
          File localFile = new File(PluginUtils.getOptimizedDexPath(this.mContext).getCanonicalPath());
          long l2 = System.currentTimeMillis();
          boolean bool = Dex2Oat.a(localArrayList, localFile, true, paramFile, new avgj(this));
          l2 = System.currentTimeMillis() - l2;
          paramFile = new StringBuilder("dex2Oat ");
          paramFile.append(l2);
          paramFile.append(", ");
          paramFile.append(bool);
          paramFile.append(", ");
          paramFile.append(paramString);
          QLog.w("plugin_tag", 1, paramFile.toString());
          if (!bool) {
            break label312;
          }
          anoo.J(paramString, i, l2);
          l2 = System.currentTimeMillis();
          if (parama != null) {
            parama.z(paramString, "pluginOatCost", l2 - l1);
          }
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "install finish " + paramString);
          }
        }
        else
        {
          anoo.J(paramString, 3, 0L);
          continue;
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      label312:
      i = 2;
    }
  }
  
  public boolean a(PluginInfo paramPluginInfo, avgh.a parama)
  {
    if (paramPluginInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installDownLoadPlugin. info null.");
      }
      throw new NullPointerException("specified PluginInfo is null");
    }
    String str1 = paramPluginInfo.mID;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "installDownLoadPlugin." + str1);
    }
    if (!this.mIsReady)
    {
      if (parama != null) {
        parama.ZQ(str1);
      }
      return false;
    }
    File localFile = new File(PluginUtils.getPluginInstallDir(this.mContext), str1);
    Object localObject = (PluginInfo)this.qy.get(str1);
    int i;
    if ((localObject != null) && (!paramPluginInfo.mMD5.equals(((PluginInfo)localObject).mMD5)))
    {
      i = 1;
      label144:
      if (!localFile.exists()) {
        break label627;
      }
    }
    label622:
    label627:
    for (boolean bool = a((PluginInfo)localObject);; bool = false)
    {
      if ((bool) && (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "plugin installed.");
        }
        if (parama == null) {
          break;
        }
        parama.ZQ(str1);
        return false;
        i = 0;
        break label144;
      }
      if (!aKC())
      {
        if (parama == null) {
          break;
        }
        parama.ZQ(str1);
        return false;
      }
      localObject = new File(new File(this.cKN), str1);
      if (!avgf.a(paramPluginInfo, (File)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. download file invalid.");
        }
        ((File)localObject).delete();
        if (parama == null) {
          break;
        }
        parama.ZQ(str1);
        return false;
      }
      if (parama != null) {
        parama.ZR(str1);
      }
      paramPluginInfo.mState = 3;
      this.qy.put(str1, paramPluginInfo);
      aqhq.copyFile((File)localObject, localFile);
      if (!avgf.a(paramPluginInfo, localFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. copy file invalid.");
        }
        localFile.delete();
        if (parama != null) {
          parama.be(false, str1);
        }
        this.qy.put(str1, paramPluginInfo);
        return false;
      }
      for (;;)
      {
        try
        {
          String str2 = PluginUtils.getPluginLibPath(this.mContext, str1).getCanonicalPath();
          str2 = PluginUtils.extractLibs(localFile.getCanonicalPath(), str2);
          if (str2 == null) {
            break label622;
          }
          QLog.d("plugin_tag", 1, "extractLibs " + str2);
          i = 1;
        }
        catch (Throwable localThrowable)
        {
          QLog.d("plugin_tag", 1, "extractLibs ", localThrowable);
          i = 1;
          continue;
          int j = 0;
          continue;
          if (!avgl.aKD()) {
            continue;
          }
          a(str1, localFile, parama);
          paramPluginInfo.mState = 4;
          paramPluginInfo.mInstalledPath = localFile.getAbsolutePath();
          paramPluginInfo.mFingerPrint = FP();
          this.qy.put(str1, paramPluginInfo);
          a(paramPluginInfo);
          if (!((File)localObject).exists()) {
            continue;
          }
          ((File)localObject).delete();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("plugin_tag", 2, "install finish.");
          if (parama == null) {
            continue;
          }
          parama.be(true, str1);
          return true;
        }
        j = i;
        if (i == 0)
        {
          if (!cp(str1, localFile.getAbsolutePath())) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            continue;
          }
          localFile.delete();
          if (parama != null) {
            parama.be(false, str1);
          }
          this.qy.put(str1, paramPluginInfo);
          return false;
        }
        i = 0;
      }
    }
  }
  
  public boolean a(String paramString, avgh.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "installBuiltinPlugin." + paramString);
    }
    if (!this.mIsReady)
    {
      if (parama != null) {
        parama.ZQ(paramString);
      }
      return false;
    }
    if (!this.b.tl(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not built in plugin.");
      }
      if (parama != null) {
        parama.ZQ(paramString);
      }
      return false;
    }
    Object localObject1 = new File(PluginUtils.getPluginInstallDir(this.mContext), paramString);
    PluginInfo localPluginInfo1 = (PluginInfo)this.qy.get(paramString);
    boolean bool = false;
    Object localObject3 = this.b.a(paramString);
    if (localObject3 == null)
    {
      QLog.d("plugin_tag", 1, "plugin not builtin");
      if (parama != null) {
        parama.be(false, paramString);
      }
      return false;
    }
    if ((localObject3 != null) && (localPluginInfo1 != null) && (!((PluginInfo)localObject3).mMD5.equals(localPluginInfo1.mMD5))) {}
    for (int i = 1;; i = 0)
    {
      if (((File)localObject1).exists()) {
        bool = a(localPluginInfo1);
      }
      if ((!bool) || (i != 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin already installed.");
      }
      if (parama != null) {
        parama.be(true, paramString);
      }
      return true;
    }
    if (parama != null) {
      parama.ZR(paramString);
    }
    PluginInfo localPluginInfo2 = ((PluginInfo)localObject3).a();
    localPluginInfo2.mState = 3;
    this.qy.put(paramString, localPluginInfo2);
    long l1 = System.currentTimeMillis();
    Object localObject5 = "";
    try
    {
      localObject7 = paramString.substring(0, paramString.indexOf(".apk"));
      localObject3 = SoLoadCore.getReleasedSoFilePath(this.mContext, (String)localObject7);
      if (localObject3 != null) {
        break label865;
      }
      localObject3 = SoLoadCore.releaseSo(this.mContext, (String)localObject7);
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject7;
        Object localObject6;
        label735:
        Object localObject4 = localObject6;
        continue;
        localObject4 = localObject6;
      }
    }
    if (localObject3 != null)
    {
      localObject7 = new File((String)localObject3);
      try
      {
        localObject3 = localPluginInfo2.mMD5;
        localObject1 = localObject7;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject4 = localObject6;
          Object localObject2 = localObject7;
        }
      }
      localObject5 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {}
      try
      {
        localObject5 = PluginUtils.extractPluginAndGetMd5Code(this.mContext, paramString, (File)localObject1);
        localObject3 = localPluginInfo2.mMD5;
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "md5:" + (String)localObject3 + " vs " + (String)localObject5);
        }
        bool = ((String)localObject5).equals(localObject3);
        if ((0 == 0) && (bool))
        {
          long l2 = System.currentTimeMillis();
          if (parama != null) {
            parama.z(paramString, "pluginApkCost", l2 - l1);
          }
          i = 0;
          try
          {
            localObject3 = PluginUtils.getPluginLibPath(this.mContext, paramString).getCanonicalPath();
            l1 = System.currentTimeMillis();
            localObject3 = PluginUtils.extractLibs(((File)localObject1).getCanonicalPath(), (String)localObject3);
            l2 = System.currentTimeMillis();
            if (parama != null) {
              parama.z(paramString, "pluginLibCost", l2 - l1);
            }
            if (localObject3 != null)
            {
              QLog.d("plugin_tag", 1, "extractLibs " + (String)localObject3);
              i = 1;
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              float f;
              QLog.d("plugin_tag", 1, "extractLibs ", localThrowable);
              i = 1;
              continue;
              int j = 0;
            }
          }
          j = i;
          if (i == 0)
          {
            if (!cp(paramString, ((File)localObject1).getAbsolutePath())) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              break label735;
            }
            ((File)localObject1).delete();
            if (parama != null) {
              parama.be(false, paramString);
            }
            this.qy.put(paramString, localPluginInfo1);
            return false;
          }
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          f = aqhq.getAvailableInnernalMemorySize();
          QLog.d("plugin_tag", 1, "extractPluginAndGetMd5Code failed installPath = " + localObject1 + ", leftSpace = " + f, localException3);
          localObject6 = localObject3;
        }
        if (parama != null) {
          parama.be(false, paramString);
        }
        this.qy.put(paramString, localPluginInfo1);
        return false;
      }
      if (avgl.aKD()) {
        a(paramString, (File)localObject1, parama);
      }
      localPluginInfo2.mLength = ((File)localObject1).length();
      localPluginInfo2.mState = 4;
      localPluginInfo2.mInstalledPath = ((File)localObject1).getAbsolutePath();
      localPluginInfo2.mMD5 = localObject6;
      localPluginInfo2.mFingerPrint = FP();
      this.qy.put(paramString, localPluginInfo2);
      a(localPluginInfo2);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "install finish");
      }
      if (parama != null) {
        parama.be(true, paramString);
      }
      return true;
    }
  }
  
  public boolean b(PluginInfo paramPluginInfo, avgh.a parama)
  {
    String str = paramPluginInfo.mID;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doDex2OatPlugin." + str);
    }
    PluginInfo localPluginInfo = c(str);
    if ((localPluginInfo != null) && (localPluginInfo.mState == 4)) {
      QLog.d("plugin_tag", 1, "doDex2OatPlugin. already " + str);
    }
    for (;;)
    {
      if (parama != null) {
        parama.be(true, str);
      }
      return true;
      if (avgf.a(paramPluginInfo, this.mContext))
      {
        QLog.d("plugin_tag", 1, "doDex2OatPlugin. isPluginRunning " + str);
      }
      else
      {
        a(str, new File(PluginUtils.getPluginInstallDir(this.mContext), str), parama);
        paramPluginInfo.mState = 4;
        paramPluginInfo.mFingerPrint = FP();
        a(paramPluginInfo);
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doDex2OatPlugin finish");
        }
      }
    }
  }
  
  public PluginInfo c(String paramString)
  {
    if (!this.mIsReady) {
      return null;
    }
    return (PluginInfo)this.qy.get(paramString);
  }
  
  public void c(PluginInfo paramPluginInfo, avgh.a parama)
  {
    paramPluginInfo = new Pair(paramPluginInfo, parama);
    this.eb.obtainMessage(67072, paramPluginInfo).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 66816: 
      paramMessage = (Pair)paramMessage.obj;
      b((PluginInfo)paramMessage.first, (avgh.a)paramMessage.second);
      return true;
    }
    paramMessage = (Pair)paramMessage.obj;
    b((PluginInfo)paramMessage.first, (avgh.a)paramMessage.second);
    return true;
  }
  
  public void init()
  {
    File localFile1 = getPluginInstallDir(this.mContext);
    boolean bool = avgf.K(localFile1);
    File[] arrayOfFile = avgf.e(localFile1);
    int i;
    File localFile2;
    Object localObject;
    if (arrayOfFile != null)
    {
      int k = arrayOfFile.length;
      i = 0;
      if (i < k)
      {
        localFile2 = arrayOfFile[i];
        if (localFile2.isFile())
        {
          if (!bool) {
            break label149;
          }
          localObject = UpdatePluginVersion.gV;
          int m = localObject.length;
          j = 0;
          label70:
          if (j >= m) {
            break label251;
          }
          String str = localObject[j];
          if ((InstallPlugins.ps(str)) || (!localFile2.getName().equals(str + ".cfg"))) {
            break label142;
          }
          tq(str);
        }
      }
    }
    label142:
    label149:
    label251:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {}
      for (;;)
      {
        i += 1;
        break;
        j += 1;
        break label70;
        localObject = avgf.a(localFile2);
        if (localObject != null)
        {
          if (a((PluginInfo)localObject)) {
            this.qy.put(((PluginInfo)localObject).mID, localObject);
          }
        }
        else {
          localFile2.delete();
        }
      }
      if (bool) {
        avgf.D(localFile1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "load installed plugin info. size:" + this.qy.size());
      }
      this.mIsReady = true;
      return;
    }
  }
  
  public boolean isPluginInstalled(String paramString)
  {
    if (!this.mIsReady) {
      return false;
    }
    paramString = (PluginInfo)this.qy.get(paramString);
    if ((paramString != null) && (paramString.mState == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "isPluginInstalled installed = " + bool);
      }
      return bool;
    }
  }
  
  public boolean tr(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "uninstallPlugin." + paramString);
    }
    if (!this.mIsReady) {
      return false;
    }
    return tq(paramString);
  }
  
  public static abstract interface a
    extends avgh.b
  {
    public abstract void ZQ(String paramString);
    
    public abstract void ZR(String paramString);
    
    public abstract void be(boolean paramBoolean, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void z(String paramString1, String paramString2, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgh
 * JD-Core Version:    0.7.0.1
 */