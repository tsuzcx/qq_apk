import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class vqv
  extends tez
{
  vqv(vqu paramvqu, stw paramstw, long paramLong)
  {
    super(paramstw);
  }
  
  protected void a(tfc paramtfc)
  {
    if (paramtfc.jdField_a_of_type_Int == 0)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage success, cost:" + (l1 - l2));
      }
      vqu.a().sendMessage(Message.obtain(vqu.a(), 1, null));
    }
    for (;;)
    {
      vqu.a(this.jdField_a_of_type_Vqu);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage error:" + paramtfc.jdField_a_of_type_Int + ", errMsg:" + paramtfc.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqv
 * JD-Core Version:    0.7.0.1
 */