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

public class oue
{
  private static volatile oue jdField_a_of_type_Oue;
  private static volatile Uri g;
  private ozq.a jdField_a_of_type_Ozq$a;
  private boolean ayy = Hx();
  private boolean ayz;
  private int uf;
  
  private boolean Hx()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("show_first_guide", true);
    }
    return bool;
  }
  
  public static oue a()
  {
    if (jdField_a_of_type_Oue == null) {}
    try
    {
      if (jdField_a_of_type_Oue == null) {
        jdField_a_of_type_Oue = new oue();
      }
      return jdField_a_of_type_Oue;
    }
    finally {}
  }
  
  public static SharedPreferences i()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "sp_qqcirlce_business" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0);
  }
  
  private String lO()
  {
    int i = rV();
    if (i > 720) {
      return "https://d3g.qq.com/sngapp/app/update/20200420145917_1860/qcircle_splash2_1080p.mp4.zip";
    }
    if (i > 480) {
      return "https://d3g.qq.com/sngapp/app/update/20200420145909_3211/qcircle_splash2_720p.mp4.zip";
    }
    return "https://d3g.qq.com/sngapp/app/update/20200420145902_9462/qcircle_splash2_480p.mp4.zip";
  }
  
  private String lP()
  {
    int i = rV();
    if (i > 720) {
      return "qcircle_splash2_1080p.mp4";
    }
    if (i > 480) {
      return "qcircle_splash2_720p.mp4";
    }
    return "qcircle_splash2_480p.mp4";
  }
  
  private int rV()
  {
    if (this.uf > 0) {
      return this.uf;
    }
    this.uf = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return this.uf;
  }
  
  public static void release()
  {
    QLog.d("QCircleConfig", 4, "release");
    jdField_a_of_type_Oue = null;
  }
  
  public boolean Ht()
  {
    return this.ayz;
  }
  
  public boolean Hu()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("show_splash_switch", true);
    }
    return bool;
  }
  
  public boolean Hv()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("show_top_auth_banner_switch", true);
    }
    return bool;
  }
  
  public boolean Hw()
  {
    return this.ayy;
  }
  
  public void L(byte[] paramArrayOfByte)
  {
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences != null)
    {
      paramArrayOfByte = new String(Base64.encode(paramArrayOfByte, 0));
      localSharedPreferences.edit().putString("tab_busi_info_data", paramArrayOfByte).apply();
    }
  }
  
  public QQCircleFeedBase.StBusiInfoData a()
  {
    Object localObject = i();
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
  
  public Uri b()
  {
    return g;
  }
  
  public void bhA()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("tryGetSplashVideoAsync ");
    if (g != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleConfig", 1, bool);
      if (g == null) {
        break;
      }
      return;
    }
    try
    {
      this.jdField_a_of_type_Ozq$a = new ouf(this);
      ozq.a().a(lO(), this.jdField_a_of_type_Ozq$a);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleConfig", 1, "tryGetSplashVideoAsync error:", localException);
    }
  }
  
  public void bhB()
  {
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("show_splash_switch", false).apply();
    }
  }
  
  public void bhC()
  {
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("show_top_auth_banner_switch", false).apply();
    }
  }
  
  public void bhD()
  {
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("close_banner_time", System.currentTimeMillis()).apply();
    }
  }
  
  public void bhE()
  {
    this.ayy = false;
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("show_first_guide", false).apply();
    }
  }
  
  public void bhz()
  {
    this.ayz = Hu();
  }
  
  public long du()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("close_banner_time", 0L);
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oue
 * JD-Core Version:    0.7.0.1
 */