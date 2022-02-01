import com.tencent.cloudfile.CloudUserInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.CloudFileAsyncStep;
import com.tencent.qphone.base.util.QLog;

public class acoz
  extends atgg
{
  public acoz(CloudFileAsyncStep paramCloudFileAsyncStep) {}
  
  public void a(CloudUserInfo paramCloudUserInfo, int paramInt, String paramString)
  {
    super.a(paramCloudUserInfo, paramInt, paramString);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileAsyncStep", 2, "doStep RESULT_OK");
      }
      this.a.setResult(7);
      return;
    }
    if (CloudFileAsyncStep.a(this.a) <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileAsyncStep", 2, "doStep RESULT_FAIL");
      }
      this.a.setResult(6);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileAsyncStep", 2, "doStep RESULT_RETRY retryCount:" + CloudFileAsyncStep.a(this.a));
    }
    CloudFileAsyncStep.b(this.a);
    ((ateh)this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(180)).a(this.a.jdField_a_of_type_Atgg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acoz
 * JD-Core Version:    0.7.0.1
 */