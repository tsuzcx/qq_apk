import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.call.qcall.PstnCardInfo;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class atdc
  implements Manager
{
  private atde a;
  private QQAppInterface app;
  private int eoV = -1;
  public int eoW = 30;
  private int eoX = -1;
  private int eoY = -1;
  private int eoZ = -1;
  private int epa = -1;
  private int epb = 3;
  private int epc = 3;
  private ConcurrentHashMap<String, Entity> jI = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> jJ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> jK;
  private ConcurrentHashMap<String, MessageRecord> jL = new ConcurrentHashMap();
  
  public atdc(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    this.epb = paramQQAppInterface.getInt("key_c2c_warning_time", 3);
    this.epc = paramQQAppInterface.getInt("key_multi_warning_time", 3);
  }
  
  private void etf()
  {
    if (this.app == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PstnManager", 2, "=== app is null ===");
      }
    }
    Resources localResources;
    do
    {
      return;
      this.jK = new ConcurrentHashMap();
      localResources = this.app.getApplication().getResources();
    } while ((this.jK == null) || (localResources == null));
    this.jK.put("key_pstn_multi_no_try_chance_tips", localResources.getString(2131697910));
    this.jK.put("key_pstn_multi_has_try_chance_tips", localResources.getString(2131697909));
    this.jK.put("key_pstn_tried_c2c_recharge_title", localResources.getString(2131697920));
    this.jK.put("key_pstn_tried_c2c_recharge_content", localResources.getString(2131697919));
    this.jK.put("key_pstn_tried_c2c_recharge_confirm_text", localResources.getString(2131697918));
    this.jK.put("key_pstn_tried_multi_recharge_title", localResources.getString(2131697923));
    this.jK.put("key_pstn_tried_multi_recharge_content", localResources.getString(2131697922));
    this.jK.put("key_pstn_tried_multi_recharge_confirm_text", localResources.getString(2131697921));
    this.jK.put("key_pstn_untried_c2c_recharge_title", localResources.getString(2131697926));
    this.jK.put("key_pstn_untried_c2c_recharge_content", localResources.getString(2131697925));
    this.jK.put("key_pstn_untried_c2c_recharge_confirm_text", localResources.getString(2131697924));
    this.jK.put("key_pstn_untried_multi_recharge_title", localResources.getString(2131697929));
    this.jK.put("key_pstn_untried_multi_recharge_content", localResources.getString(2131697928));
    this.jK.put("key_pstn_untried_multi_recharge_confirm_text", localResources.getString(2131697927));
    this.jK.put("key_pstn_c2c_try_over_recharge_title", localResources.getString(2131697907));
    this.jK.put("key_pstn_c2c_try_over_recharge_content", localResources.getString(2131697906));
    this.jK.put("key_pstn_c2c_try_over_recharge_confirm_text", localResources.getString(2131697905));
    this.jK.put("key_pstn_multi_try_over_recharge_title", localResources.getString(2131697916));
    this.jK.put("key_pstn_multi_try_over_recharge_content", localResources.getString(2131697915));
    this.jK.put("key_pstn_multi_try_over_recharge_confirm_text", localResources.getString(2131697914));
    this.jK.put("pstn_c2c_trans_wording", localResources.getString(2131697904));
    this.jK.put("pstn_c2c_trans_check_wording", localResources.getString(2131697902));
    this.jK.put("pstn_c2c_trans_setting_wording", localResources.getString(2131697903));
    this.jK.put("pstn_multi_trans_wording", localResources.getString(2131697913));
    this.jK.put("pstn_multi_trans_check_wording", localResources.getString(2131697911));
    this.jK.put("pstn_multi_trans_setting_wording", localResources.getString(2131697912));
  }
  
  public int Og()
  {
    if (this.eoV == -1) {
      this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("user_pstn_gray_flag", 0);
    }
    return 0;
  }
  
  public int Oh()
  {
    int j = this.eoX;
    int i = j;
    if (j == -1) {
      i = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("user_pstn_c2c_trial_authority", 0);
    }
    return i;
  }
  
  public int Oi()
  {
    int j = this.eoY;
    int i = j;
    if (j == -1) {
      i = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("user_pstn_multi_trial_authority", 0);
    }
    return i;
  }
  
  public int Oj()
  {
    if (this.eoZ == -1) {
      this.eoZ = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("key_gray_switch_need_popup_confirm", 0);
    }
    return this.eoZ;
  }
  
  public int Ok()
  {
    return this.epb;
  }
  
  public int Ol()
  {
    return this.epc;
  }
  
  public void Vm(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("key_pstn_c2c_switch_setting", paramBoolean);
    localEditor.commit();
  }
  
  public void Vn(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("key_pstn_multi_switch_setting", paramBoolean);
    localEditor.commit();
  }
  
  public atde a()
  {
    if (this.a == null)
    {
      this.a = new atde();
      SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      this.a.epe = localSharedPreferences.getInt("key_pstn_c2c_aio_flag", 0);
      this.a.epg = localSharedPreferences.getInt("key_pstn_c2c_ip_call_flag", 0);
      this.a.epf = localSharedPreferences.getInt("key_pstn_c2c_profile_card_flag", 0);
      this.a.eph = localSharedPreferences.getInt("key_pstn_multi_aio_flag", 0);
      this.a.epi = localSharedPreferences.getInt("key_pstn_auto_trans_time", 100000);
      this.a.epj = localSharedPreferences.getInt("key_pstn_miss_delay_time", 20);
      this.a.epk = localSharedPreferences.getInt("key_pstn_miss_show_time", 60);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PstnManager", 2, "getPstnSwitchConfig, " + this.a.toString());
    }
    return this.a;
  }
  
  public PstnCardInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("PstnManager", 1, " getPstnCardInfo uin is null ");
      paramString = null;
    }
    PstnCardInfo localPstnCardInfo;
    do
    {
      do
      {
        return paramString;
        localPstnCardInfo = (PstnCardInfo)this.jI.get(paramString);
        paramString = localPstnCardInfo;
      } while (localPstnCardInfo == null);
      paramString = localPstnCardInfo;
    } while (!QLog.isColorLevel());
    QLog.d("PstnManager", 2, "getPstnCardInfo, " + localPstnCardInfo.toString());
    return localPstnCardInfo;
  }
  
  public boolean aJb()
  {
    return this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("key_pstn_c2c_switch_setting", false);
  }
  
  public boolean aJc()
  {
    return this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("key_pstn_multi_switch_setting", false);
  }
  
  public void onDestroy() {}
  
  public String ro(String paramString)
  {
    Object localObject = "";
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("PstnManager", 1, " getPstnTips key is null");
    }
    String str;
    do
    {
      do
      {
        do
        {
          return localObject;
          if (this.jJ == null) {
            this.jJ = new ConcurrentHashMap();
          }
          if (this.jK == null) {
            etf();
          }
          str = (String)this.jJ.get(paramString);
          localObject = str;
        } while (!TextUtils.isEmpty(str));
        localObject = str;
      } while (this.jK == null);
      str = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getString(paramString, (String)this.jK.get(paramString));
      localObject = str;
    } while (TextUtils.isEmpty(str));
    this.jJ.put(paramString, str);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdc
 * JD-Core Version:    0.7.0.1
 */