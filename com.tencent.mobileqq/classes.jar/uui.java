import android.text.TextUtils;
import android.util.Log;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.ark.Application;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.qphone.base.util.QLog;

public class uui
  implements Runnable
{
  public uui(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2) {}
  
  public void run()
  {
    ark.Application localApplication = ark.Application.Create(this.jdField_a_of_type_JavaLangString);
    int i;
    if ((TextUtils.isEmpty(localApplication.GetUrlWhiteList())) && (!TextUtils.isEmpty(this.b))) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.b != 1008) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.d) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(this.b)))
      {
        ArkAppDataReport.a(null, ArkAppContainer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer).name, ArkAppContainer.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer).view);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(this.jdField_a_of_type_JavaLangString, -1, "非法内容，无法正常显示。");
        i = 0;
        j = i;
        if (QLog.isColorLevel()) {
          Log.d("ArkApp.Cntnr.chkUrl", "onLoadApp curType=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.b);
        }
      }
    }
    for (int j = i;; j = 1)
    {
      if (j != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a.a = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a.b = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp.ArkAppContainer", 2, String.format("getAppPathByNameFromLocal.in.wrapper: %h", new Object[] { this }));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(this.jdField_a_of_type_JavaLangString, 0, null);
      }
      localApplication.Release();
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uui
 * JD-Core Version:    0.7.0.1
 */