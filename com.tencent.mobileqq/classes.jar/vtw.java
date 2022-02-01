import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.qqcircle.report.QCircleReporter.10;
import com.tencent.biz.qqcircle.report.QCircleReporter.2;
import com.tencent.biz.qqcircle.report.QCircleReporter.5;
import com.tencent.biz.qqcircle.report.QCircleReporter.6;
import com.tencent.biz.qqcircle.report.QCircleReporter.7;
import com.tencent.biz.qqcircle.report.QCircleReporter.8;
import com.tencent.biz.qqcircle.report.QCircleReporter.9;
import com.tencent.biz.qqcircle.requests.CommandReportRequest;
import com.tencent.biz.qqcircle.requests.QCircleClientReportRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import qqcircle.QQCircleReport.SingleDcData;

public class vtw
{
  private static final int jdField_a_of_type_Int;
  private static final long jdField_a_of_type_Long = TimeUnit.SECONDS.toMillis(QzoneConfig.getQQCircleReportInterval());
  private static volatile vtw jdField_a_of_type_Vtw;
  private static final int jdField_b_of_type_Int = QzoneConfig.getQQCircleQualityReportBufferLength();
  private static final long jdField_b_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private List<QQCircleReport.SingleDcData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<QQCircleReport.SingleDcData> jdField_b_of_type_JavaUtilList = new ArrayList();
  private long jdField_c_of_type_Long = System.currentTimeMillis();
  private List<QQCircleReport.SingleDcData> jdField_c_of_type_JavaUtilList = new ArrayList();
  private long jdField_d_of_type_Long = System.currentTimeMillis();
  private List<APP_REPORT_TRANSFER.SingleDcData> jdField_d_of_type_JavaUtilList = new ArrayList();
  private long jdField_e_of_type_Long = System.currentTimeMillis();
  private List<QQCircleReport.SingleDcData> jdField_e_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_Int = QzoneConfig.getQQCircleReportBufferLength();
    jdField_b_of_type_Long = TimeUnit.SECONDS.toMillis(QzoneConfig.getQQCircleQualityReportInterval());
  }
  
  private vtw()
  {
    HandlerThread localHandlerThread = new HandlerThread("qqcircle_report");
    localHandlerThread.setPriority(10);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new vtx(this, localHandlerThread.getLooper());
  }
  
  public static vtw a()
  {
    if (jdField_a_of_type_Vtw == null) {}
    try
    {
      if (jdField_a_of_type_Vtw == null) {
        jdField_a_of_type_Vtw = new vtw();
      }
      return jdField_a_of_type_Vtw;
    }
    finally {}
  }
  
  private void b()
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    c(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void c()
  {
    c(this.jdField_b_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  private void c(List<QQCircleReport.SingleDcData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = new QCircleClientReportRequest(paramList);
      VSNetworkHelper.a().a(paramList, new vty(this, paramList));
    }
  }
  
  private void d()
  {
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    c(this.jdField_c_of_type_JavaUtilList);
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  private void d(List<APP_REPORT_TRANSFER.SingleDcData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = new CommandReportRequest(paramList);
      VSNetworkHelper.a().a(paramList, new vtz(this, paramList));
    }
  }
  
  private void e()
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    d(this.jdField_d_of_type_JavaUtilList);
    this.jdField_d_of_type_JavaUtilList.clear();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() > 0) || (this.jdField_c_of_type_JavaUtilList.size() > 0) || (this.jdField_d_of_type_JavaUtilList.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((System.currentTimeMillis() - this.jdField_c_of_type_Long > jdField_a_of_type_Long) || (this.jdField_a_of_type_JavaUtilList.size() >= jdField_a_of_type_Int)) {
          b();
        }
        if ((System.currentTimeMillis() - this.jdField_d_of_type_Long > jdField_b_of_type_Long) || (this.jdField_c_of_type_JavaUtilList.size() >= jdField_b_of_type_Int)) {
          d();
        }
        if ((System.currentTimeMillis() - this.jdField_e_of_type_Long > jdField_b_of_type_Long) || (this.jdField_d_of_type_JavaUtilList.size() >= jdField_b_of_type_Int)) {
          e();
        }
      }
      if ((!this.jdField_a_of_type_AndroidOsHandler.hasMessages(4097)) && ((i != 0) || (System.currentTimeMillis() - this.jdField_c_of_type_Long <= 10L * jdField_a_of_type_Long))) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4097, jdField_a_of_type_Long);
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(4098)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4098, 1000L);
    }
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleReporter.9(this));
  }
  
  public void a(APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleReporter.7(this, paramSingleDcData));
  }
  
  public void a(List<QQCircleReport.SingleDcData> paramList)
  {
    c(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      QQCircleReport.SingleDcData localSingleDcData = (QQCircleReport.SingleDcData)paramList.next();
    }
  }
  
  public void a(QQCircleReport.SingleDcData paramSingleDcData)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleReporter.6(this, paramSingleDcData));
  }
  
  public void a(QQCircleReport.SingleDcData paramSingleDcData, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleReporter.5(this, paramBoolean, paramSingleDcData));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleReporter.2(this, paramArrayOfByte));
  }
  
  public void b(List<QQCircleReport.SingleDcData> paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleReporter.10(this, paramList));
  }
  
  public void b(QQCircleReport.SingleDcData paramSingleDcData)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleReporter.8(this, paramSingleDcData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtw
 * JD-Core Version:    0.7.0.1
 */