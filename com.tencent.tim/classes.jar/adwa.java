import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.qphone.base.util.QLog;

public class adwa
  implements anil.a
{
  public adwa(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
  
  public void d(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "[onCameraException]", paramException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adwa
 * JD-Core Version:    0.7.0.1
 */