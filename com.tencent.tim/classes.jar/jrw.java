import android.content.Context;
import android.content.Intent;
import com.tencent.biz.huanjiplugin.TranslucentActivty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;

public class jrw
{
  private static volatile jrw jdField_a_of_type_Jrw;
  String Uh;
  private avfw jdField_a_of_type_Avfw;
  OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new jrx(this);
  jry jdField_a_of_type_Jry;
  int mAction = 0;
  QQAppInterface mApp;
  
  public static jrw a()
  {
    if (jdField_a_of_type_Jrw == null) {}
    try
    {
      if (jdField_a_of_type_Jrw == null) {
        jdField_a_of_type_Jrw = new jrw();
      }
      return jdField_a_of_type_Jrw;
    }
    finally {}
  }
  
  public void J(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Jry != null) {
      this.jdField_a_of_type_Jry.K(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public jrv a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "queryStatuspackageName = " + paramString1 + "pluginId =" + paramString2 + "version = " + paramString3);
    }
    if ((this.jdField_a_of_type_Avfw == null) || (this.mApp == null)) {
      return null;
    }
    paramString1 = this.jdField_a_of_type_Avfw.b("qhuanji_plugin.apk");
    if ((paramString1 != null) && (QLog.isColorLevel())) {
      QLog.w("HuanjiPlugin", 2, "queryPluginstate = " + paramString1.mState + "pluginSize =" + paramString1.mLength + "version = " + paramString1.mVersion);
    }
    paramString2 = new jrv();
    if (paramString1 != null)
    {
      if (paramString1.mState == 0) {
        jrv.aCR = 0;
      }
      for (;;)
      {
        jrv.qw = paramString1.mLength;
        return paramString2;
        if (paramString1.mState == 2) {
          jrv.aCR = 1;
        } else if ((paramString1.mState == 4) && (paramString1.mVersion.equals(paramString3))) {
          jrv.aCR = 2;
        } else if ((paramString1.mState == 4) && (!paramString1.mVersion.equals(paramString3))) {
          jrv.aCR = 3;
        }
      }
    }
    jrv.aCR = 0;
    return paramString2;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, jry paramjry)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "huanjiDownloadstartParam = " + paramString2);
    }
    anov localanov = new anov(this.mApp).a("dc00899").b("Grp_huanji").c("Grp_download");
    String str;
    if (paramInt == 2)
    {
      str = "Clk_start";
      localanov.d(str).a(new String[] { paramString1 }).report();
      this.mAction = paramInt;
      this.Uh = paramString2;
      paramString1 = this.jdField_a_of_type_Avfw.b("qhuanji_plugin.apk");
      this.jdField_a_of_type_Jry = paramjry;
      if ((paramString1 == null) || (paramString1.mState == 4)) {
        break label163;
      }
      if (QLog.isColorLevel()) {
        QLog.w("HuanjiPlugin", 2, "换机插件还未安装 installPlugin");
      }
      this.jdField_a_of_type_Avfw.installPlugin("qhuanji_plugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
    }
    label163:
    do
    {
      return true;
      str = "Clk_download";
      break;
      if (paramInt == 2)
      {
        paramString1 = new Intent(BaseApplicationImpl.getApplication().getApplicationContext(), TranslucentActivty.class);
        paramString1.putExtra("startParam", paramString2);
        paramString1.addFlags(268435456);
        paramString1.putExtras(paramString1);
        BaseApplicationImpl.getApplication().getApplicationContext().startActivity(paramString1);
        return true;
      }
    } while (this.jdField_a_of_type_Jry == null);
    this.jdField_a_of_type_Jry.K(3, 4, 100);
    return true;
  }
  
  public void z(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Avfw = ((avfw)paramQQAppInterface.getManager(27));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrw
 * JD-Core Version:    0.7.0.1
 */