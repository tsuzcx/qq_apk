import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;
import qqcircle.QQCircleFeedBase.StBusiInfoData;

public class uyk
{
  private static volatile Uri jdField_a_of_type_AndroidNetUri;
  private static volatile uyk jdField_a_of_type_Uyk;
  private static vkw jdField_a_of_type_Vkw;
  private int jdField_a_of_type_Int;
  private aaad jdField_a_of_type_Aaad;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  private uyk()
  {
    i();
  }
  
  public static SharedPreferences a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "sp_qqcirlce_business" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0);
  }
  
  public static uyk a()
  {
    if (jdField_a_of_type_Uyk == null) {}
    try
    {
      if (jdField_a_of_type_Uyk == null) {
        jdField_a_of_type_Uyk = new uyk();
      }
      return jdField_a_of_type_Uyk;
    }
    finally {}
  }
  
  public static vkw a()
  {
    if (jdField_a_of_type_Vkw == null) {
      jdField_a_of_type_Vkw = new vkw();
    }
    return jdField_a_of_type_Vkw;
  }
  
  public static void a()
  {
    QLog.d("QCircleConfig", 4, "release");
    jdField_a_of_type_Uyk = null;
  }
  
  public static SharedPreferences b()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "sp_qqcirlce_business" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 4);
  }
  
  private String b()
  {
    String str1 = QzoneConfig.getQQCircleSplashGuideVideoDir();
    String str2 = c();
    str2 = str1 + str2 + ".zip";
    if (QLog.isColorLevel()) {
      QLog.d("QCircleConfig", 1, "splashGuideVideoDir: " + str1);
    }
    return str2;
  }
  
  private int c()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_Int = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return this.jdField_a_of_type_Int;
  }
  
  private String c()
  {
    int i = c();
    if (i > 720) {
      return "qcircle_splash2_1080p.mp4";
    }
    if (i > 480) {
      return "qcircle_splash2_720p.mp4";
    }
    return "qcircle_splash2_480p.mp4";
  }
  
  private void i()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null)
    {
      this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("show_first_guide", true);
      this.jdField_b_of_type_Boolean = localSharedPreferences.getBoolean("key_sp_need_show_consume_toast", true);
    }
  }
  
  public int a()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_b_of_type_Int;
    }
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getInt("qcircle_fuel_count", 2147483647);
    }
    return 0;
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
  
  public String a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("qcircle_auth_tip_action_url", "");
    }
    return "";
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
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("qcircle_fuel_count", paramInt).apply();
    }
  }
  
  public void a(long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("sp_last_getfollowuser_time", paramLong).apply();
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("qcircle_auth_tip_action_url", paramString).apply();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = b();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("qcircle_show_publish_feed_guide_bubble", paramBoolean).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleConfig", 1, "setNeedShowPublishGuideBubble: " + paramBoolean);
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
    return this.c;
  }
  
  public int b()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt("qcircle_is_authenticated_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    }
    return i;
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
    this.c = b();
  }
  
  public void b(int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("qcircle_is_authenticated_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramInt).apply();
    }
  }
  
  public void b(long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("qcircle_fule_count_push_time", paramLong).apply();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = b();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("qcircle_show_publish_label_guide_bubble", paramBoolean).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleConfig", 1, "setNeedShowPublishLabelGuideBubble: " + paramBoolean);
    }
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
  
  public long c()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("qcircle_fule_count_push_time", 0L);
    }
    return l;
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
      this.jdField_a_of_type_Aaad = new uyl(this);
      aaae.a(a()).a(b(), this.jdField_a_of_type_Aaad);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleConfig", 1, "tryGetSplashVideoAsync error:", localException);
    }
  }
  
  public boolean c()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = b();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("qcircle_show_publish_feed_guide_bubble", true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleConfig", 1, "isNeedShowPublishGuideBubble: " + bool);
    }
    return bool;
  }
  
  public void d()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("show_splash_switch", false).apply();
    }
    this.c = false;
  }
  
  public boolean d()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = b();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("qcircle_show_publish_label_guide_bubble", true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleConfig", 1, "isNeedShowPublishLabelGuideBubble: " + bool);
    }
    return bool;
  }
  
  public void e()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("show_top_auth_banner_switch", false).apply();
    }
  }
  
  public boolean e()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("show_top_auth_banner_switch", true);
    }
    return bool;
  }
  
  public void f()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("close_banner_time", System.currentTimeMillis()).apply();
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = false;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("show_first_guide", false).apply();
    }
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void h()
  {
    this.jdField_b_of_type_Boolean = false;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("key_sp_need_show_consume_toast", false).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyk
 * JD-Core Version:    0.7.0.1
 */