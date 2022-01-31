import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class xfn
  extends utr
{
  xfn(xfm paramxfm, uio paramuio, long paramLong)
  {
    super(paramuio);
  }
  
  protected void a(utu paramutu)
  {
    if (paramutu.jdField_a_of_type_Int == 0)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage success, cost:" + (l1 - l2));
      }
      xfm.a().sendMessage(Message.obtain(xfm.a(), 1, null));
    }
    for (;;)
    {
      xfm.a(this.jdField_a_of_type_Xfm);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage error:" + paramutu.jdField_a_of_type_Int + ", errMsg:" + paramutu.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xfn
 * JD-Core Version:    0.7.0.1
 */