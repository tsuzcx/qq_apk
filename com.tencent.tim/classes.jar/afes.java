import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ArNativeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class afes
  extends afeu
{
  public afes(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ar.native.so_v8.3.6", paramQQAppInterface);
  }
  
  public void HL(boolean paramBoolean)
  {
    bS(false, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_NativeSoDownloadHandler", 2, "restartDownload " + paramBoolean);
    }
  }
  
  public void HO(String paramString)
  {
    int i = adeq.e(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_NativeSoDownloadHandler", 2, "download success: " + paramString + ",result=" + i);
    }
    if (i == 0) {
      BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit().putInt("ar_native_so_version", getVersion()).commit();
    }
    for (;;)
    {
      try
      {
        str = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("ar_native_ArMapEngine836", "");
        if (!TextUtils.isEmpty(str))
        {
          QQAppInterface localQQAppInterface = this.app;
          i = b().Version;
          if (!TextUtils.isEmpty(str)) {
            continue;
          }
          localObject = "0";
          anot.a(localQQAppInterface, "dc01440", "", "", "0X8007A3D", "0X8007A3D", 0, 0, "", String.valueOf(i), (String)localObject, "qq.android.ar.native.so_v8.3.6");
          localObject = new HashMap();
          ((HashMap)localObject).put("config_version", String.valueOf(b().Version));
          ((HashMap)localObject).put("md5", str);
          ((HashMap)localObject).put("res_name", "qq.android.ar.native.so_v8.3.6");
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "armap_so_update_rate", true, 0L, 0L, (HashMap)localObject, "", false);
        }
      }
      catch (Exception localException)
      {
        String str;
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localException.printStackTrace();
        continue;
      }
      super.HO(paramString);
      return;
      b().loadState = 0;
      b().Version = 0;
      afel.a(b(), new String[0]);
      continue;
      localObject = str;
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public void bS(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      super.HL(paramBoolean2);
    }
    do
    {
      return;
      if ((b() == null) || (b().loadState != 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ArConfig_NativeSoDownloadHandler", 2, "restartDownloadForce is in downloading");
    return;
    super.HL(paramBoolean2);
  }
  
  public void f(XmlData paramXmlData)
  {
    int i = 0;
    try
    {
      Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("ArNativeSoDownloadHandler", 4);
      if (((SharedPreferences)localObject1).getBoolean("qq.android.ar.native.so_v8.3.6", true))
      {
        ((SharedPreferences)localObject1).edit().putBoolean("qq.android.ar.native.so_v8.3.6", false).commit();
        localObject1 = new File(adeq.sm() + File.separator).listFiles();
        int j = localObject1.length;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_NativeSoDownloadHandler", 2, "File name=" + localObject2.getAbsolutePath());
          }
          if ((localObject2.isFile()) && (localObject2.getName().startsWith("libArMapEngine")) && (!localObject2.getName().contains("ArMapEngine836")))
          {
            localObject2.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ArConfig_NativeSoDownloadHandler", 2, "delete f=" + localObject2.getName());
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_NativeSoDownloadHandler", 2, "exception =" + localException.getMessage());
        localException.printStackTrace();
      }
      super.f(paramXmlData);
    }
  }
  
  public Class<? extends XmlData> g()
  {
    return ArNativeSoData.class;
  }
  
  public int getBusinessId()
  {
    return 10024;
  }
  
  public String un()
  {
    return "ArConfig_NativeSoDownloadHandler";
  }
  
  public String uo()
  {
    return "prd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afes
 * JD-Core Version:    0.7.0.1
 */