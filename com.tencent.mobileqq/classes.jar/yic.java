import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class yic
  extends vwx
{
  yic(yib paramyib, vmd paramvmd, long paramLong)
  {
    super(paramvmd);
  }
  
  protected void a(vxa paramvxa)
  {
    if (paramvxa.jdField_a_of_type_Int == 0)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage success, cost:" + (l1 - l2));
      }
      yib.a().sendMessage(Message.obtain(yib.a(), 1, null));
    }
    for (;;)
    {
      yib.a(this.jdField_a_of_type_Yib);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage error:" + paramvxa.jdField_a_of_type_Int + ", errMsg:" + paramvxa.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yic
 * JD-Core Version:    0.7.0.1
 */