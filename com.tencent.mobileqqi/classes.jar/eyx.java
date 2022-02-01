import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.antiphing.AntiphishingUrlConfig;
import com.tencent.mobileqq.antiphing.DownloadFileHelper;
import com.tencent.qphone.base.util.QLog;

public class eyx
  extends Thread
{
  public eyx(AntiphishingUrlConfig paramAntiphishingUrlConfig, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (AntiphishingUrlConfig.a() > 3000000L)
    {
      if (new DownloadFileHelper(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, AntiphishingUrlConfig.b(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig), this.b, false))
      {
        QLog.d(AntiphishingUrlConfig.a(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig), 1, "Successfully Update Config!");
        AntiphishingUrlConfig.a(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig).sendEmptyMessage(AntiphishingUrlConfig.a(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig));
      }
    }
    else {
      return;
    }
    AntiphishingUrlConfig.a(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig).sendEmptyMessage(AntiphishingUrlConfig.b(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig));
    QLog.d(AntiphishingUrlConfig.a(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig), 1, "Update Config Error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     eyx
 * JD-Core Version:    0.7.0.1
 */