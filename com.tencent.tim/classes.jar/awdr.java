import android.text.TextUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class awdr
{
  private static awdr a;
  private static String cPs = QzoneConfig.getInstance().getConfig("QZoneSetting", "xmpcoreUrl", "https://d3g.qq.com/sngapp/app/update/20171220130606_8640/xmpcore.jar");
  private static String cPt = QzoneConfig.getInstance().getConfig("QZoneSetting", "XMPcoreJarMD5", "a0c5ac44fc2d0e35187f0c1479db48b2");
  private ConcurrentHashMap<String, Boolean> ke = new ConcurrentHashMap();
  private boolean mE;
  
  public static awdr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new awdr();
      }
      return a;
    }
    finally {}
  }
  
  private HashMap<String, Object> a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0) || (!this.mE)) {
      paramString1 = null;
    }
    Object localObject1;
    HashMap localHashMap;
    int j;
    int i;
    do
    {
      do
      {
        return paramString1;
        localObject1 = awcj.callSpecifiedStaticMethod("com.adobe.xmp.XmpUtil", "extractXMPMeta", false, getParamsClass(new Class[] { String.class }), new Object[] { paramString1 });
        localHashMap = new HashMap();
        paramString1 = localHashMap;
      } while (localObject1 == null);
      j = paramArrayOfString.length;
      i = 0;
      paramString1 = localHashMap;
    } while (i >= j);
    paramString1 = paramArrayOfString[i];
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      i += 1;
      break;
      Object localObject2 = awcj.callSpecifiedMethod(localObject1, "getProperty", false, getParamsClass(new Class[] { String.class, String.class }), new Object[] { paramString2, paramString1 });
      if (localObject2 != null)
      {
        localObject2 = awcj.callSpecifiedMethod(localObject2, "getValue", false, new Class[0], new Object[0]);
        if (localObject2 != null) {
          localHashMap.put(paramString1, localObject2);
        }
      }
    }
  }
  
  private boolean aMs()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("xmpcore.jar");
    QZLog.i("XMPCoreUtil", 4, new Object[] { "isXMPCoreJarExit path = ", str });
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return new File(str).exists();
  }
  
  private void eDl()
  {
    QZLog.i("XMPCoreUtil", "loadXMPCoreModule");
    if (aMs())
    {
      QZLog.i("XMPCoreUtil", 4, new Object[] { "xmpCoreModulePath =", QzoneModuleManager.getInstance().getModuleFilePath("xmpcore.jar") });
      this.mE = QzoneModuleManager.getInstance().loadModule("xmpcore.jar", getClass().getClassLoader(), false, false);
      if (this.mE) {
        QZLog.i("XMPCoreUtil", "loadXMPCoreModule success");
      }
    }
    else
    {
      return;
    }
    QZLog.i("XMPCoreUtil", "loadXMPCoreModule fail");
  }
  
  private boolean isNeedUpdate()
  {
    String str = LocalMultiProcConfig.getString("xmp_core_file_md5", null);
    if (TextUtils.isEmpty(str)) {}
    while (!str.equalsIgnoreCase(cPt)) {
      return true;
    }
    return false;
  }
  
  public void a(awdr.a parama)
  {
    if (parama == null) {
      return;
    }
    if (this.mE)
    {
      parama.bX(this.mE);
      return;
    }
    if ((isNeedUpdate()) || (!aMs())) {}
    for (int i = 1; i == 0; i = 0)
    {
      eDl();
      parama.bX(this.mE);
      return;
    }
    QzoneModuleManager.getInstance().downloadModule("xmpcore.jar", new awds(this, parama));
  }
  
  public Class[] getParamsClass(Class... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfClass[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfClass;
  }
  
  public boolean tO(String paramString)
  {
    if (this.ke.get(paramString) != null) {
      return ((Boolean)this.ke.get(paramString)).booleanValue();
    }
    Object localObject = a(paramString, "http://ns.google.com/photos/1.0/panorama/", new String[] { "GPano:UsePanoramaViewer" });
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).get("GPano:UsePanoramaViewer");
      if ((localObject != null) && ((localObject instanceof String)))
      {
        boolean bool = ((String)localObject).equalsIgnoreCase("true");
        QZLog.i("XMPCoreUtil", 4, new Object[] { "isPanorama: ", Boolean.valueOf(bool) });
        this.ke.put(paramString, Boolean.valueOf(bool));
        return bool;
      }
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void bX(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdr
 * JD-Core Version:    0.7.0.1
 */