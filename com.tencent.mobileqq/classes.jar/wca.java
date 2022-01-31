import android.os.Message;
import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;

public class wca
  implements Runnable
{
  public wca(BlessResultActivity paramBlessResultActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      long l = FileUtils.a(this.jdField_a_of_type_JavaLangString);
      if (l < 25600L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity.a.obtainMessage(1004);
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity.a.sendMessage((Message)localObject);
        return;
      }
      Object localObject = BlessResultActivity.a(this.jdField_a_of_type_JavaLangString);
      ImageUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, (String)localObject, 160, 160);
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "share ptv to FC. srcLen:" + l + " ,objLen:" + FileUtils.a((String)localObject) + " , thumbPath:" + (String)localObject);
      }
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity.a.obtainMessage(1004);
      localMessage.obj = localObject;
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity.a.sendMessage(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wca
 * JD-Core Version:    0.7.0.1
 */