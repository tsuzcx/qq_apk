import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.qphone.base.util.QLog;

public class yfi
  extends QvipSpecialCareObserver
{
  public yfi(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onSpecialSoundEvent data: " + paramObject);
    }
    if (paramObject != null) {
      this.a.stopTitleProgress();
    }
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    }
    QQSpecialFriendSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yfi
 * JD-Core Version:    0.7.0.1
 */