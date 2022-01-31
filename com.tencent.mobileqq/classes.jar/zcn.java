import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.viewplugin.ViewPluginLoader.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

public class zcn
{
  public static final HashMap<String, zcn> a;
  int jdField_a_of_type_Int = 0;
  public SharedPreferences a;
  public ClassLoader a;
  public Object a;
  public String a;
  ncm jdField_a_of_type_Ncm = new ncm();
  public zcm a;
  public volatile boolean a;
  public String b;
  boolean b;
  public String c = null;
  public String d;
  public String e;
  private String f;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public zcn(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = (BaseApplicationImpl.getContext().getFilesDir() + "/pluginopt/" + paramString2 + "/opt");
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("viewplugin_sp", 0);
    jdField_a_of_type_JavaUtilHashMap.put(paramString2, this);
    this.f = (Environment.getExternalStorageDirectory().getPath() + "/tencent/plugins/");
  }
  
  public beaj a()
  {
    return ((beag)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(47)).a(1);
  }
  
  public void a()
  {
    bema localbema = (bema)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(107);
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localbema.notifyUI(3, true, Integer.valueOf(4));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      String str = "http://" + this.jdField_b_of_type_JavaLangString + "?_bid=" + this.jdField_a_of_type_JavaLangString;
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      long l = System.currentTimeMillis();
      if ((!nbv.a(BaseApplicationImpl.getContext(), str, new zco(this, l, localbema, localBaseApplication))) && (QLog.isColorLevel()))
      {
        QLog.i("ViewPluginLoader", 2, "plugin:" + this.jdField_b_of_type_JavaLangString + " transToLocalUrl: return false");
        return;
      }
    }
    finally {}
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    if (this.jdField_a_of_type_Zcm != null)
    {
      this.jdField_a_of_type_Zcm = new zcm(paramBaseActivity, 0, this.jdField_a_of_type_Zcm);
      return;
    }
    this.jdField_a_of_type_Zcm = new zcm(paramBaseActivity, 0, this.e, this.jdField_a_of_type_JavaLangClassLoader);
  }
  
  public void a(JSONObject paramJSONObject, QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = true;
    int i = paramJSONObject.optInt("code");
    paramQQAppInterface = ncb.b(this.jdField_a_of_type_JavaLangString);
    boolean bool2;
    if (!TextUtils.isEmpty(paramQQAppInterface)) {
      if (i == 4)
      {
        paramQQAppInterface = paramQQAppInterface + this.jdField_a_of_type_JavaLangString + ".7z";
        bool2 = false;
      }
    }
    for (;;)
    {
      ThreadManager.post(new ViewPluginLoader.5(this, paramJSONObject, paramQQAppInterface, new zcq(this, paramQQAppInterface, bool2, bool1)), 8, null, false);
      return;
      if ((i == 3) || (i == 2))
      {
        paramQQAppInterface = paramQQAppInterface + this.jdField_a_of_type_JavaLangString + ".zip";
        bool2 = true;
        bool1 = false;
      }
      else
      {
        QLog.e("ViewPluginLoader", 1, "do not know what format, use default zip name!");
        paramQQAppInterface = paramQQAppInterface + this.jdField_a_of_type_JavaLangString + ".zip";
        bool2 = false;
        bool1 = false;
        continue;
        bool1 = false;
        bool2 = false;
        paramQQAppInterface = null;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    b();
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    for (;;)
    {
      String str2;
      File localFile;
      String str1;
      Object localObject;
      try
      {
        str2 = this.jdField_a_of_type_JavaLangString;
        boolean bool = TextUtils.isEmpty(str2);
        if (bool)
        {
          paramBoolean2 = false;
          return paramBoolean2;
        }
        if (TextUtils.isEmpty(ncb.b(str2)))
        {
          paramBoolean2 = false;
          continue;
        }
        localFile = new File(paramString);
        if (!localFile.exists())
        {
          if (!QLog.isColorLevel()) {
            break label595;
          }
          QLog.i("ViewPluginLoader", 2, "doUnzipZip: no zip ! : businessId:" + str2);
          break label595;
        }
        long l = System.currentTimeMillis();
        str1 = localFile.getParent() + File.separator + str2;
        localObject = BidDownloader.a(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ViewPluginLoader", 2, "fileFormat: " + (String)localObject + ", path: " + paramString);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label378;
        }
        if (((String)localObject).equals("zip"))
        {
          i = ndr.a(paramString, str1);
          if (QLog.isColorLevel()) {
            QLog.i("ViewPluginLoader", 2, "now delete original download offline zip, path: " + paramString);
          }
          ndq.b(paramString);
          if (i <= 0) {
            break label440;
          }
          nbv.a(str2, 13, 0L, i, "lixian_update", "0");
          if (!QLog.isColorLevel()) {
            break label590;
          }
          QLog.i("ViewPluginLoader", 2, "unZipFolder fail!");
          paramBoolean1 = false;
          ndq.a(str1);
          paramBoolean2 = paramBoolean1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("ViewPluginLoader", 2, "time of unzip zip：" + (System.currentTimeMillis() - l) + ", isSuccess: " + paramBoolean1);
          paramBoolean2 = paramBoolean1;
          continue;
        }
        if (!((String)localObject).equals("7z")) {
          continue;
        }
      }
      finally {}
      i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, str1);
      continue;
      label378:
      QLog.w("ViewPluginLoader", 1, "can not recognize download compress file format, " + paramString);
      if (paramBoolean1)
      {
        i = ndr.a(paramString, str1);
      }
      else if (paramBoolean2)
      {
        i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, str1);
        continue;
        label440:
        paramString = str1 + File.separator + str2 + ".zip";
        localObject = new File(paramString);
        str2 = localFile.getParent() + File.separator + str2 + ".zip";
        if (QLog.isColorLevel()) {
          QLog.i("ViewPluginLoader", 2, "now move zip file to location: " + str2);
        }
        if (((File)localObject).exists())
        {
          paramBoolean2 = ((File)localObject).renameTo(new File(str2));
          paramBoolean1 = paramBoolean2;
          if (!paramBoolean2) {
            paramBoolean1 = bdhb.b(paramString, str2);
          }
        }
        else
        {
          label590:
          paramBoolean1 = false;
          continue;
          label595:
          paramBoolean2 = false;
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    nbv.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (localQQAppInterface.getLongAccountUin() % 10L == 6L)) {}
    for (boolean bool = true;; bool = false)
    {
      nbv.a = bool;
      String str = nbv.a(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginLoader", 2, "checkOfflineAndLoad version = " + str);
      }
      if ((!new File(ncb.a(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_JavaLangString + "/" + this.jdField_b_of_type_JavaLangString).exists()) && (!TextUtils.isEmpty(str)) && (!"0".equals(str))) {
        bdhb.a(ncb.a(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_JavaLangString);
      }
      if (localQQAppInterface != null) {
        break;
      }
      return;
    }
    nbv.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface, new zcp(this, localQQAppInterface), false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Zcm = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zcn
 * JD-Core Version:    0.7.0.1
 */