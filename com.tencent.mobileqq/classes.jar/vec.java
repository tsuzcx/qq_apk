import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class vec
  extends ssg
{
  vec(veb paramveb, shd paramshd, long paramLong)
  {
    super(paramshd);
  }
  
  protected void a(ssj paramssj)
  {
    if (paramssj.jdField_a_of_type_Int == 0)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage success, cost:" + (l1 - l2));
      }
      veb.a().sendMessage(Message.obtain(veb.a(), 1, null));
    }
    for (;;)
    {
      veb.a(this.jdField_a_of_type_Veb);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage error:" + paramssj.jdField_a_of_type_Int + ", errMsg:" + paramssj.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vec
 * JD-Core Version:    0.7.0.1
 */