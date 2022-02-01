import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class zhc
  extends wvh
{
  zhc(zhb paramzhb, wke paramwke, long paramLong)
  {
    super(paramwke);
  }
  
  protected void a(wvk paramwvk)
  {
    if (paramwvk.jdField_a_of_type_Int == 0)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage success, cost:" + (l1 - l2));
      }
      zhb.a().sendMessage(Message.obtain(zhb.a(), 1, null));
    }
    for (;;)
    {
      zhb.a(this.jdField_a_of_type_Zhb);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage error:" + paramwvk.jdField_a_of_type_Int + ", errMsg:" + paramwvk.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhc
 * JD-Core Version:    0.7.0.1
 */