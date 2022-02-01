import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class adcm
  implements QQPermissionCallback
{
  adcm(adcl paramadcl) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(adcl.a(this.this$0), paramArrayOfString, paramArrayOfInt);
    QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION deny");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION allow restart it");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcm
 * JD-Core Version:    0.7.0.1
 */