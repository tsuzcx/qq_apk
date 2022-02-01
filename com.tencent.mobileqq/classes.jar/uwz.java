import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import qqcircle.QQCircleFeedBase.StBusiInfoData;

public class uwz
{
  private static volatile Uri jdField_a_of_type_AndroidNetUri;
  private static volatile uwz jdField_a_of_type_Uwz;
  private static vis jdField_a_of_type_Vis;
  private int jdField_a_of_type_Int;
  private zwi jdField_a_of_type_Zwi;
  private boolean jdField_a_of_type_Boolean = e();
  private boolean b;
  
  private int a()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_Int = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return this.jdField_a_of_type_Int;
  }
  
  public static SharedPreferences a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "sp_qqcirlce_business" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0);
  }
  
  private String a()
  {
    int i = a();
    if (i > 720) {
      return "https://d3g.qq.com/sngapp/app/update/20200420145917_1860/qcircle_splash2_1080p.mp4.zip";
    }
    if (i > 480) {
      return "https://d3g.qq.com/sngapp/app/update/20200420145909_3211/qcircle_splash2_720p.mp4.zip";
    }
    return "https://d3g.qq.com/sngapp/app/update/20200420145902_9462/qcircle_splash2_480p.mp4.zip";
  }
  
  public static uwz a()
  {
    if (jdField_a_of_type_Uwz == null) {}
    try
    {
      if (jdField_a_of_type_Uwz == null) {
        jdField_a_of_type_Uwz = new uwz();
      }
      return jdField_a_of_type_Uwz;
    }
    finally {}
  }
  
  public static vis a()
  {
    if (jdField_a_of_type_Vis == null) {
      jdField_a_of_type_Vis = new vis();
    }
    return jdField_a_of_type_Vis;
  }
  
  public static void a()
  {
    QLog.d("QCircleConfig", 4, "release");
    jdField_a_of_type_Uwz = null;
  }
  
  private String b()
  {
    int i = a();
    if (i > 720) {
      return "qcircle_splash2_1080p.mp4";
    }
    if (i > 480) {
      return "qcircle_splash2_720p.mp4";
    }
    return "qcircle_splash2_480p.mp4";
  }
  
  private boolean e()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("show_first_guide", true);
    }
    return bool;
  }
  
  public long a()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("close_banner_time", 0L);
    }
    return l;
  }
  
  public Uri a()
  {
    return jdField_a_of_type_AndroidNetUri;
  }
  
  public QQCircleFeedBase.StBusiInfoData a()
  {
    Object localObject = a();
    if (localObject != null) {
      try
      {
        localObject = ((SharedPreferences)localObject).getString("tab_busi_info_data", "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = Base64.decode(((String)localObject).getBytes(), 0);
          QQCircleFeedBase.StBusiInfoData localStBusiInfoData = new QQCircleFeedBase.StBusiInfoData();
          localStBusiInfoData.mergeFrom((byte[])localObject);
          QLog.d("QCircleConfig", 2, "getBusiInfoData() success!");
          return localStBusiInfoData;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("sp_last_getfollowuser_time", paramLong).apply();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null)
    {
      paramArrayOfByte = new String(Base64.encode(paramArrayOfByte, 0));
      localSharedPreferences.edit().putString("tab_busi_info_data", paramArrayOfByte).apply();
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public long b()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("sp_last_getfollowuser_time", 0L);
    }
    return l;
  }
  
  public void b()
  {
    this.b = b();
  }
  
  public boolean b()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("show_splash_switch", true);
    }
    return bool;
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("tryGetSplashVideoAsync ");
    if (jdField_a_of_type_AndroidNetUri != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleConfig", 1, bool);
      if (jdField_a_of_type_AndroidNetUri == null) {
        break;
      }
      return;
    }
    try
    {
      this.jdField_a_of_type_Zwi = new uxa(this);
      zwj.a(a()).a(a(), this.jdField_a_of_type_Zwi);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleConfig", 1, "tryGetSplashVideoAsync error:", localException);
    }
  }
  
  public boolean c()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("show_top_auth_banner_switch", true);
    }
    return bool;
  }
  
  public void d()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("show_splash_switch", false).apply();
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void e()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("show_top_auth_banner_switch", false).apply();
    }
  }
  
  public void f()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("close_banner_time", System.currentTimeMillis()).apply();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = false;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("show_first_guide", false).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwz
 * JD-Core Version:    0.7.0.1
 */