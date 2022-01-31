import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class xjw
  extends uya
{
  xjw(xjv paramxjv, umx paramumx, long paramLong)
  {
    super(paramumx);
  }
  
  protected void a(uyd paramuyd)
  {
    if (paramuyd.jdField_a_of_type_Int == 0)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage success, cost:" + (l1 - l2));
      }
      xjv.a().sendMessage(Message.obtain(xjv.a(), 1, null));
    }
    for (;;)
    {
      xjv.a(this.jdField_a_of_type_Xjv);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage error:" + paramuyd.jdField_a_of_type_Int + ", errMsg:" + paramuyd.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjw
 * JD-Core Version:    0.7.0.1
 */