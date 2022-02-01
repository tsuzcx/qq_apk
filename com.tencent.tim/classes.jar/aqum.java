import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.FileSchemeResolver;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.Editor;
import com.tencent.mm.vfs.MigrationFileSystem;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class aqum
{
  private aquk a = new aquk();
  private String cxj;
  private String cxk;
  
  private void VJ(String paramString)
  {
    File localFile1 = new File(paramString);
    if (localFile1.isDirectory())
    {
      paramString = new File(aqul.getSDKPrivatePath(paramString));
      File localFile2 = paramString.getParentFile();
      if ((localFile2 != null) && (!localFile2.exists())) {
        localFile2.mkdirs();
      }
      if ((localFile1.renameTo(paramString)) && (QLog.isColorLevel())) {
        QLog.i("VFSRegisterProxy", 2, "executeLightMigrate Fast moved '" + localFile1 + "' -> '" + paramString + "'");
      }
    }
  }
  
  public static aqum a()
  {
    return aqum.a.a;
  }
  
  private boolean aFE()
  {
    boolean bool = false;
    if (BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4).getInt("vfs_version", 0) < 10) {
      bool = true;
    }
    QLog.d("VFSRegisterProxy", 1, "initConfig checkSP is called, return val = " + bool);
    return bool;
  }
  
  private boolean aFF()
  {
    boolean bool = BaseApplicationImpl.sApplication.getSharedPreferences("VFS_Config_Register_Proxy", 4).getBoolean("state_account_registered", true);
    if (QLog.isColorLevel()) {
      QLog.d("VFSRegisterProxy", 2, "isFirstRegisterAccount is called, return val = " + bool);
    }
    return bool;
  }
  
  private void efJ()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4).edit().putInt("vfs_version", 10).apply();
    QLog.d("VFSRegisterProxy", 1, "initConfig updateSP is called, version = 10");
  }
  
  private void efL()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("VFS_Config_Register_Proxy", 4).edit().putBoolean("state_account_registered", false).apply();
  }
  
  private void efM()
  {
    for (;;)
    {
      try
      {
        File[] arrayOfFile = new File(acbn.SDCARD_PATH).listFiles();
        if (arrayOfFile == null) {
          return;
        }
        int j = arrayOfFile.length;
        i = 0;
        if (i >= j) {
          break;
        }
        localFile = arrayOfFile[i];
        str = localFile.getName().trim();
        int k = str.length();
        if (k >= 5) {
          if (k <= 15) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          int i;
          String str;
          Long.parseLong(str);
          File localFile = new File(localFile, "ppt");
          if (!localFile.exists()) {
            continue;
          }
          VJ(localFile.getAbsolutePath());
        }
        catch (NumberFormatException localNumberFormatException) {}
        localException = localException;
        localException.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  private void fK(Context paramContext)
  {
    setContext(paramContext);
    FileSystemManager.Editor localEditor = FileSystemManager.instance().edit();
    localEditor.scheme("", FileSchemeResolver.instance());
    localEditor.scheme("file", FileSchemeResolver.instance());
    localEditor.scheme(null, FileSchemeResolver.instance());
    Iterator localIterator = aquo.bG.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!TextUtils.isEmpty(str1))
      {
        if ((str1.startsWith("/")) || (str1.indexOf(":") > 0)) {}
        for (paramContext = str1;; paramContext = up() + File.separator + str1)
        {
          String str2 = aqul.getSDKPrivatePath(str1);
          Object localObject = new File(str2).getParentFile();
          if ((localObject != null) && (!((File)localObject).exists())) {
            ((File)localObject).mkdirs();
          }
          localObject = new MigrationFileSystem(true, new NativeFileSystem(str2, false), new FileSystem[] { new NativeFileSystem(paramContext, false) });
          if (QLog.isColorLevel()) {
            QLog.d("VFSRegisterProxy", 2, "initConfig filesystem key is " + str1);
          }
          localEditor.install(str1, (FileSystem)localObject).mount(str2, str1).mount(paramContext, str1);
          break;
        }
      }
    }
    localEditor.commit();
  }
  
  private List<String> p(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    localArrayList.add(acbn.SDCARD_PATH + paramQQAppInterface + File.separator);
    return localArrayList;
  }
  
  private void publishOnEditorCommit(boolean paramBoolean) {}
  
  public void eG(QQAppInterface paramQQAppInterface)
  {
    if ((aFF()) && (paramQQAppInterface != null))
    {
      Object localObject = p(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("VFSRegisterProxy", 2, "registerAccountPath is called later! account relate length = " + ((List)localObject).size());
      }
      paramQQAppInterface = FileSystemManager.instance().edit();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = aqul.getSDKPrivatePath(str1);
        File localFile = new File(str2).getParentFile();
        if ((localFile != null) && (!localFile.exists())) {
          localFile.mkdirs();
        }
        paramQQAppInterface.install(str1, new MigrationFileSystem(true, new NativeFileSystem(str2, false), new FileSystem[] { new NativeFileSystem(str1, false) })).mount(str2, str1).mount(str1, str1);
      }
      paramQQAppInterface.commit();
      efL();
    }
    this.a.efI();
  }
  
  public final void efK()
  {
    Iterator localIterator = aquo.bH.iterator();
    while (localIterator.hasNext()) {
      VJ((String)localIterator.next());
    }
  }
  
  public void fJ(Context paramContext)
  {
    setContext(paramContext);
    QLog.d("VFSRegisterProxy", 1, "initConfig start!");
    try
    {
      if (aFE())
      {
        fK(paramContext);
        if (!FileSystemManager.instance().isValidConfigFile(paramContext)) {
          fK(paramContext);
        }
        if (FileSystemManager.instance().isValidConfigFile(paramContext)) {
          efJ();
        }
        efK();
        efM();
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        this.a.reportError(new Throwable("FileSystemManager proxy", paramContext));
        QLog.e("VFSRegisterProxy", 1, paramContext, new Object[0]);
      }
    }
    QLog.d("VFSRegisterProxy", 1, "initConfig end!");
  }
  
  @Nullable
  public final String getExternalPath()
  {
    if (this.cxj == null)
    {
      File localFile = BaseApplicationImpl.sApplication.getExternalCacheDir();
      if (localFile != null) {
        this.cxj = localFile.getParent();
      }
    }
    return this.cxj;
  }
  
  public void setContext(Context paramContext)
  {
    boolean bool = true;
    FileSystemManager.setContext(paramContext);
    if (BaseApplicationImpl.sProcessId == 1) {
      FileSystemManager.setStatisticsCallback(this.a);
    }
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      publishOnEditorCommit(bool);
      return;
      bool = false;
    }
  }
  
  public final String up()
  {
    if (this.cxk == null) {
      this.cxk = Environment.getExternalStorageDirectory().getPath();
    }
    return this.cxk;
  }
  
  static final class a
  {
    static final aqum a = new aqum(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqum
 * JD-Core Version:    0.7.0.1
 */