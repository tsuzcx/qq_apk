import android.os.Handler;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class xnf
  implements Runnable
{
  public xnf(VACDReportMgr paramVACDReportMgr, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    synchronized ()
    {
      try
      {
        while ((VACDReportMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletReportVACDReportMgr).isEmpty()) && (VACDReportMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletReportVACDReportMgr).isEmpty())) {
          VACDReportMgr.a().wait();
        }
        try
        {
          synchronized (this.jdField_a_of_type_ArrayOfByte)
          {
            this.jdField_a_of_type_ArrayOfByte.wait(2000L);
          }
          do
          {
            synchronized (VACDReportMgr.a())
            {
              VACDReportMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletReportVACDReportMgr, 2);
              if (VACDReportMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletReportVACDReportMgr))
              {
                VACDReportMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletReportVACDReportMgr).post(this);
                return;
                localObject1 = finally;
                throw localObject1;
                localObject2 = finally;
                throw localObject2;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.d("VACDReport", 2, "WriteDBThread exit.");
          return;
        }
        catch (Exception localException2)
        {
          break label61;
        }
      }
      catch (Exception localException1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xnf
 * JD-Core Version:    0.7.0.1
 */