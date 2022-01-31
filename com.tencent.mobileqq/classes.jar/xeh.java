import VACDReport.ReportHeader;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class xeh
  implements Runnable
{
  public xeh(VACDReportMgr paramVACDReportMgr, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "handleReponse headers is null or empty");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VACDReport", 2, "handleReponse, headers= " + this.jdField_a_of_type_JavaUtilList);
    }
    synchronized (VACDReportMgr.a())
    {
      ArrayList localArrayList = new ArrayList(8);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ReportHeader localReportHeader = (ReportHeader)localIterator.next();
        if (localReportHeader != null)
        {
          if (localReportHeader.result == 0)
          {
            localArrayList.add(Long.valueOf(localReportHeader.seqno));
            VACDReportMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletReportVACDReportMgr).remove(Long.valueOf(localReportHeader.seqno));
          }
          VACDReportMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletReportVACDReportMgr).remove(Long.valueOf(localReportHeader.seqno));
        }
      }
    }
    if (!localList.isEmpty()) {
      VACDReportMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletReportVACDReportMgr).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xeh
 * JD-Core Version:    0.7.0.1
 */