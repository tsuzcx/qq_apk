import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class ddx
  implements Runnable
{
  public ddx(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    int j = 1;
    if (QLog.isDevelopLevel()) {
      QLog.i("ReportController", 4, "reportSettingStatusDaily run");
    }
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e() == 1)
    {
      i = 1;
      if (i == 0) {
        break label415;
      }
      i = 1;
      label43:
      localHashMap.put("Clk_notice_shake", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() != 1) {
        break label420;
      }
      i = 1;
      label67:
      if (i == 0) {
        break label425;
      }
      i = 1;
      label73:
      localHashMap.put("Clk_notice_grpshake", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d() != 1) {
        break label430;
      }
      i = 1;
      label97:
      if (i == 0) {
        break label435;
      }
      i = 1;
      label103:
      localHashMap.put("Clk_notice_sound", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b() != 1) {
        break label440;
      }
      i = 1;
      label127:
      if (i == 0) {
        break label445;
      }
      i = 1;
      label133:
      localHashMap.put("Clk_notice_gupsound", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false)) {
        break label450;
      }
      i = 1;
      label165:
      localHashMap.put("Clk_night_mode", Integer.valueOf(i));
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e()) {
        break label455;
      }
      i = 1;
      label188:
      localHashMap.put("Clk_hide_text", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562526), "qqsetting_notify_blncontrol_key", true)) {
        break label460;
      }
      i = 1;
      label233:
      localHashMap.put("Led_blinking", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561654), "qqsetting_receivemsg_whenexit_key", true)) {
        break label465;
      }
      i = 1;
      label278:
      localHashMap.put("Logout_msg", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563433), "qqsetting_notify_myfeedpush_key", true)) {
        break label470;
      }
    }
    label415:
    label420:
    label425:
    label430:
    label435:
    label440:
    label445:
    label450:
    label455:
    label460:
    label465:
    label470:
    for (int i = j;; i = 0)
    {
      localHashMap.put("Clk_about_me", Integer.valueOf(i));
      Object localObject = localHashMap.keySet();
      try
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "Setting_tab", str, 0, 0, String.valueOf(localHashMap.get(str)), "", "", "");
        }
        return;
      }
      catch (Exception localException) {}
      i = 0;
      break;
      i = 0;
      break label43;
      i = 0;
      break label67;
      i = 0;
      break label73;
      i = 0;
      break label97;
      i = 0;
      break label103;
      i = 0;
      break label127;
      i = 0;
      break label133;
      i = 0;
      break label165;
      i = 0;
      break label188;
      i = 0;
      break label233;
      i = 0;
      break label278;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ddx
 * JD-Core Version:    0.7.0.1
 */