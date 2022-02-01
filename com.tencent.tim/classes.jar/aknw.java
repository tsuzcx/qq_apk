import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.qphone.base.util.QLog;

final class aknw
  implements DeviceProfileManager.a
{
  public void sr(boolean paramBoolean)
  {
    if (paramBoolean) {
      aknv.load();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.dpc", 2, "onDpcPullFinished, hasChanged=" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknw
 * JD-Core Version:    0.7.0.1
 */