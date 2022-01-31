import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class vqy
  extends tfc
{
  vqy(vqx paramvqx, stz paramstz, long paramLong)
  {
    super(paramstz);
  }
  
  protected void a(tff paramtff)
  {
    if (paramtff.jdField_a_of_type_Int == 0)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage success, cost:" + (l1 - l2));
      }
      vqx.a().sendMessage(Message.obtain(vqx.a(), 1, null));
    }
    for (;;)
    {
      vqx.a(this.jdField_a_of_type_Vqx);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage error:" + paramtff.jdField_a_of_type_Int + ", errMsg:" + paramtff.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqy
 * JD-Core Version:    0.7.0.1
 */