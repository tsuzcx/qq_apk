import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class aqrc
  implements Manager
{
  public afli a;
  public ahes a;
  public aqpm a;
  private aqrc.a a;
  public aqsz a;
  public VasFaceManager a;
  public ahxg b;
  public alco b;
  public afhl c;
  public QQAppInterface mApp;
  
  public aqrc(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Afli = new afli(paramQQAppInterface);
    this.jdField_a_of_type_Ahes = new ahes(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager = new VasFaceManager(paramQQAppInterface);
    this.c = new afhl(paramQQAppInterface);
    this.jdField_b_of_type_Alco = new alco(paramQQAppInterface);
    this.jdField_a_of_type_Aqpm = new aqpm(paramQQAppInterface);
    this.jdField_b_of_type_Ahxg = new ahxg(paramQQAppInterface);
    this.jdField_a_of_type_Aqsz = new aqsz(paramQQAppInterface, paramQQAppInterface.a().createEntityManager());
    this.jdField_a_of_type_Aqrc$a = new aqrc.a();
    try
    {
      AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApp(), this.jdField_a_of_type_Aqrc$a);
      return;
    }
    catch (Error paramQQAppInterface) {}
  }
  
  public static boolean aFx()
  {
    if (aqvn.a().aFK())
    {
      if (aqiw.getNetworkType(BaseApplicationImpl.getApplication()) == 0)
      {
        aqvn.a().a(null, false);
        return true;
      }
      QLog.d("KC.TMSManager", 1, "can only query in mobile connection");
      return true;
    }
    QLog.d("KC.TMSManager", 1, "tms can not work");
    return false;
  }
  
  public static String gi(int paramInt)
  {
    int i = paramInt & 0xF;
    String str = null;
    if (i == 1)
    {
      str = aeqy.c().mNotifyPaymentText;
      if (TextUtils.isEmpty(str)) {
        break label112;
      }
      i = 0;
      switch (paramInt >> 4)
      {
      default: 
        paramInt = i;
      }
    }
    for (;;)
    {
      if (paramInt == 0) {
        break label112;
      }
      return str.replace("[vip]", BaseApplicationImpl.getContext().getResources().getString(paramInt));
      if (i != 2) {
        break;
      }
      str = aeqy.c().mExpiredNotifyPaymentText;
      break;
      paramInt = 2131697320;
      continue;
      paramInt = 2131720669;
      continue;
      paramInt = 2131690842;
    }
    label112:
    return "";
  }
  
  public static String gj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 17: 
    case 33: 
      return "mvip.n.a.qlevel_cuifei";
    case 18: 
    case 34: 
      return "mvip.n.a.qlevel_guoqi";
    case 49: 
      return "jhan_qlevel_cuifei";
    }
    return "jhan_qlevel_guoqi";
  }
  
  public static String gk(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 17: 
    case 18: 
      return "LTMCLUB";
    case 33: 
    case 34: 
      return "CJCLUBT";
    }
    return "SVHHZLH";
  }
  
  public int Ms()
  {
    String str = this.mApp.getCurrentAccountUin();
    return BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).getInt("is_show_qq_level_notice", 0);
  }
  
  public void SQ(boolean paramBoolean)
  {
    String str = this.mApp.getCurrentAccountUin();
    BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).edit().putBoolean("is_show_host_qq_level_guide", paramBoolean).commit();
  }
  
  public void XR(int paramInt)
  {
    String str = this.mApp.getCurrentAccountUin();
    QLog.e("QQLevelNotice", 1, "setShowQQLevelNoticeValue: " + paramInt + ", " + str);
    BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).edit().putInt("is_show_qq_level_notice", paramInt).commit();
  }
  
  public boolean aFy()
  {
    String str = this.mApp.getCurrentAccountUin();
    return BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).getBoolean("is_show_host_qq_level_guide", true);
  }
  
  public void onDestroy()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Aqrc$a);
    this.jdField_a_of_type_Ahes.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager.onDestroy();
    this.jdField_a_of_type_Aqsz.onDestroy();
    this.jdField_a_of_type_Aqpm.onDestroy();
    this.jdField_b_of_type_Ahxg.onDestory();
  }
  
  static class a
    implements INetInfoHandler
  {
    public void onNetMobile2None() {}
    
    public void onNetMobile2Wifi(String paramString) {}
    
    public void onNetNone2Mobile(String paramString)
    {
      aqrc.aFx();
    }
    
    public void onNetNone2Wifi(String paramString) {}
    
    public void onNetWifi2Mobile(String paramString)
    {
      aqrc.aFx();
    }
    
    public void onNetWifi2None() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrc
 * JD-Core Version:    0.7.0.1
 */