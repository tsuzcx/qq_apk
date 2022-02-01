import com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.1;
import com.tencent.qphone.base.util.QLog;

public class abxf
  implements abhh.g
{
  public abxf(ApolloConfigDataReport.1 param1) {}
  
  public void gE(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloConfigDataReport", 2, new Object[] { "checkReportConfigJson errorCode:", Integer.valueOf(paramInt1), ", httpCode:", Integer.valueOf(paramInt2) });
    }
    if ((paramInt1 == 0) && (paramInt2 == 200)) {
      abxe.access$000();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxf
 * JD-Core Version:    0.7.0.1
 */