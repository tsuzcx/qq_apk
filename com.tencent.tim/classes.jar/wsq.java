import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.qphone.base.util.QLog;

final class wsq
  implements DeviceProfileManager.a
{
  public void sr(boolean paramBoolean)
  {
    if (paramBoolean) {
      wsp.access$000(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIODrawerDpc", 2, "onDpcPullFinished, hasChanged = " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsq
 * JD-Core Version:    0.7.0.1
 */