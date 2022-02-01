import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class abay
  extends ackl
{
  public abay(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity) {}
  
  public void ax(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onSpecialSoundEvent data: " + paramObject);
    }
    if (paramObject != null)
    {
      this.a.stopTitleProgress();
      ((Integer)paramObject).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abay
 * JD-Core Version:    0.7.0.1
 */