package cooperation.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import iaf;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class PluginInstaller
  implements Handler.Callback
{
  private static final String jdField_a_of_type_JavaLangString = "installed_plugin";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BuiltinPluginManager jdField_a_of_type_CooperationPluginBuiltinPluginManager;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public PluginInstaller(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.b = paramString;
    this.jdField_a_of_type_CooperationPluginBuiltinPluginManager = BuiltinPluginManager.a(this.jdField_a_of_type_AndroidContentContext);
    a();
  }
  
  public static PluginInfo a(String paramString, PluginInfoParser paramPluginInfoParser)
  {
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new ByteArrayInputStream(paramString.getBytes()), paramPluginInfoParser);
      paramString = paramPluginInfoParser.a();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  static File a(Context paramContext)
  {
    return paramContext.getDir("installed_plugin", 0);
  }
  
  public static File a(Context paramContext, String paramString)
  {
    File localFile = a(paramContext);
    if (localFile == null) {
      return null;
    }
    int i = paramString.lastIndexOf('.');
    if ((i != -1) && (!paramString.substring(i).equalsIgnoreCase(".apk"))) {
      paramContext = paramString.substring(0, i) + ".apk";
    }
    for (;;)
    {
      return new File(localFile, paramContext);
      paramContext = paramString;
      if (i == -1) {
        paramContext = paramString + ".apk";
      }
    }
  }
  
  private void a(PluginInfo paramPluginInfo)
  {
    PluginInfoUtil.a(paramPluginInfo, a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void a(String paramString)
  {
    PluginInfoUtil.a(paramString, a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private boolean a()
  {
    if (TextUtils.isEmpty(this.b)) {}
    while (!new File(this.b).exists()) {
      return false;
    }
    return true;
  }
  
  private boolean a(PluginInfo paramPluginInfo)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1;
    if (paramPluginInfo != null)
    {
      File localFile = a(this.jdField_a_of_type_AndroidContentContext, paramPluginInfo.mID);
      bool1 = bool3;
      if (localFile != null)
      {
        bool1 = bool3;
        if (localFile.exists())
        {
          bool1 = bool3;
          if (localFile.isFile())
          {
            if (!PluginInfoUtil.a(paramPluginInfo, localFile)) {
              break label117;
            }
            bool1 = true;
            paramPluginInfo.mState = 4;
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
      label117:
      d(paramPluginInfo.mID);
      paramPluginInfo.mState = 0;
      bool1 = bool3;
    }
  }
  
  private void b(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    String str = paramPluginInfo.mID;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doSetupPlugin." + str);
    }
    if (PluginInfoUtil.a(paramPluginInfo, this.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(str);
      }
      return;
    }
    if (!c(str)) {}
    for (int i = 1; i != 0; i = 0)
    {
      a(str, paramOnPluginSetupListener);
      return;
    }
    a(paramPluginInfo, paramOnPluginSetupListener);
  }
  
  private boolean c(String paramString)
  {
    if (!a()) {}
    do
    {
      return false;
      paramString = new File(this.b).list(new iaf(this, paramString));
    } while ((paramString == null) || (paramString.length <= 0));
    return true;
  }
  
  private boolean d(String paramString)
  {
    PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localPluginInfo != null) && (PluginInfoUtil.a(localPluginInfo, this.jdField_a_of_type_AndroidContentContext)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    a(paramString);
    paramString = a(this.jdField_a_of_type_AndroidContentContext, paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    return true;
  }
  
  public PluginInfo a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    return (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    File[] arrayOfFile = PluginInfoUtil.a(a(this.jdField_a_of_type_AndroidContentContext));
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isFile())
        {
          PluginInfo localPluginInfo = PluginInfoUtil.a(localFile);
          if (localPluginInfo == null) {
            break label81;
          }
          if (a(localPluginInfo)) {
            this.jdField_a_of_type_JavaUtilHashMap.put(localPluginInfo.mID, localPluginInfo);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label81:
          localFile.delete();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "load installed plugin info. size:" + this.jdField_a_of_type_JavaUtilHashMap.size());
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    paramPluginInfo = new Pair(paramPluginInfo, paramOnPluginSetupListener);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(66816, paramPluginInfo).sendToTarget();
  }
  
  public boolean a(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
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
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(str1);
      }
      return false;
    }
    File localFile = a(this.jdField_a_of_type_AndroidContentContext, str1);
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
    int i;
    if ((localObject != null) && (!paramPluginInfo.mMD5.equals(((PluginInfo)localObject).mMD5)))
    {
      i = 1;
      label137:
      if (!localFile.exists()) {
        break label477;
      }
    }
    label477:
    for (boolean bool = a((PluginInfo)localObject);; bool = false)
    {
      if ((bool) && (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "plugin installed.");
        }
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
        i = 0;
        break label137;
      }
      if (!a())
      {
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
      }
      localObject = new File(new File(this.b), str1);
      if (!PluginInfoUtil.a(paramPluginInfo, (File)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. download file invalid.");
        }
        ((File)localObject).delete();
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(str1);
      }
      paramPluginInfo.mState = 3;
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
      FileUtils.a((File)localObject, localFile);
      if (!PluginInfoUtil.a(paramPluginInfo, localFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. copy file invalid.");
        }
        localFile.delete();
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.b(false, str1);
        return false;
      }
      try
      {
        String str2 = PluginUtils.getLibPath(this.jdField_a_of_type_AndroidContentContext).getCanonicalPath();
        PluginUtils.extractLibs(localFile.getCanonicalPath(), str2);
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(true, str1);
        }
        paramPluginInfo.mState = 4;
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
        a(paramPluginInfo);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install finish.");
        }
        return true;
      }
      catch (Exception paramPluginInfo)
      {
        paramPluginInfo.printStackTrace();
        localFile.delete();
      }
      if (paramOnPluginSetupListener == null) {
        break;
      }
      paramOnPluginSetupListener.b(false, str1);
      return false;
    }
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not containsKey of :" + paramString);
      }
      b(paramString);
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "installBuiltinPlugin." + paramString);
    }
    if (!this.jdField_a_of_type_Boolean) {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(paramString);
      }
    }
    do
    {
      return false;
      if (this.jdField_a_of_type_CooperationPluginBuiltinPluginManager.a(paramString)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not built in plugin.");
      }
    } while (paramOnPluginSetupListener == null);
    paramOnPluginSetupListener.e(paramString);
    return false;
    File localFile = a(this.jdField_a_of_type_AndroidContentContext, paramString);
    Object localObject1 = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    Object localObject2 = this.jdField_a_of_type_CooperationPluginBuiltinPluginManager.a(paramString);
    int i;
    if ((localObject2 != null) && (localObject1 != null) && (!((PluginInfo)localObject2).mMD5.equals(((PluginInfo)localObject1).mMD5)))
    {
      i = 1;
      label152:
      if (!localFile.exists()) {
        break label479;
      }
    }
    label479:
    for (boolean bool = a((PluginInfo)localObject1);; bool = false)
    {
      if ((bool) && (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "plugin already installed.");
        }
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(true, paramString);
        }
        return true;
        i = 0;
        break label152;
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(paramString);
      }
      PluginInfo localPluginInfo = ((PluginInfo)localObject2).a();
      localPluginInfo.mState = 3;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localPluginInfo);
      localObject1 = "";
      try
      {
        localObject2 = PluginUtils.extractPluginAndGetMd5Code(this.jdField_a_of_type_AndroidContentContext, paramString, localFile);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          try
          {
            localObject2 = PluginUtils.getLibPath(this.jdField_a_of_type_AndroidContentContext).getCanonicalPath();
            PluginUtils.extractLibs(localFile.getCanonicalPath(), (String)localObject2);
            if (paramOnPluginSetupListener != null) {
              paramOnPluginSetupListener.b(true, paramString);
            }
            localPluginInfo.mLength = localFile.length();
            localPluginInfo.mState = 4;
            localPluginInfo.mMD5 = ((String)localObject1);
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localPluginInfo);
            a(localPluginInfo);
            if (QLog.isColorLevel()) {
              QLog.d("plugin_tag", 2, "install finish");
            }
            return true;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            localFile.delete();
          }
          localException2 = localException2;
          localException2.printStackTrace();
        }
      }
      localObject2 = localPluginInfo.mMD5;
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "md5:" + (String)localObject2 + " vs " + (String)localObject1);
      }
      bool = ((String)localObject1).equals(localObject2);
      if ((0 == 0) && (bool))
      {
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.b(false, paramString);
        return false;
      }
      if (paramOnPluginSetupListener == null) {
        break;
      }
      paramOnPluginSetupListener.b(false, paramString);
      return false;
    }
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "uninstallPlugin." + paramString);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return d(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    paramMessage = (Pair)paramMessage.obj;
    b((PluginInfo)paramMessage.first, (PluginInstaller.OnPluginSetupListener)paramMessage.second);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.plugin.PluginInstaller
 * JD-Core Version:    0.7.0.1
 */