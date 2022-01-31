import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

public class asc
  implements Runnable
{
  public asc(Leba paramLeba, String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("key_web_plugin_click_num" + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.a(), 0);
    localEditor.putInt("key_web_plugin_click_num" + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.a(), i + 1);
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0)
    {
      i = localSharedPreferences.getInt("key_web_plugin_click_red_num" + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.a(), 0);
      localEditor.putInt("key_web_plugin_click_red_num" + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.a(), i + 1);
    }
    localEditor.putLong("key_come_webview_time" + this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.a(), System.currentTimeMillis());
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     asc
 * JD-Core Version:    0.7.0.1
 */