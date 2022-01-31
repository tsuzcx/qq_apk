import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.qqcircle.report.QCircleReporter.3;
import com.tencent.biz.qqcircle.report.QCircleReporter.4;
import com.tencent.biz.qqcircle.report.QCircleReporter.5;
import com.tencent.biz.qqcircle.report.QCircleReporter.6;
import com.tencent.biz.qqcircle.requests.QCircleClientReportRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import qqcircle.QQCircleReport.SingleDcData;

public class typ
{
  private static final int jdField_a_of_type_Int;
  private static final long jdField_a_of_type_Long = TimeUnit.SECONDS.toMillis(QzoneConfig.getQQCircleReportInterval());
  private static volatile typ jdField_a_of_type_Typ;
  private static final int jdField_b_of_type_Int = QzoneConfig.getQQCircleQualityReportBufferLength();
  private static final long jdField_b_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private List<QQCircleReport.SingleDcData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<QQCircleReport.SingleDcData> jdField_b_of_type_JavaUtilList = new ArrayList();
  private long jdField_c_of_type_Long = System.currentTimeMillis();
  private List<QQCircleReport.SingleDcData> jdField_c_of_type_JavaUtilList = new ArrayList();
  private long jdField_d_of_type_Long = System.currentTimeMillis();
  private List<QQCircleReport.SingleDcData> jdField_d_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_Int = QzoneConfig.getQQCircleReportBufferLength();
    jdField_b_of_type_Long = TimeUnit.SECONDS.toMillis(QzoneConfig.getQQCircleQualityReportInterval());
  }
  
  private typ()
  {
    HandlerThread localHandlerThread = new HandlerThread("qqcircle_report");
    localHandlerThread.setPriority(10);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new tyq(this, localHandlerThread.getLooper());
  }
  
  public static typ a()
  {
    if (jdField_a_of_type_Typ == null) {}
    try
    {
      if (jdField_a_of_type_Typ == null) {
        jdField_a_of_type_Typ = new typ();
      }
      return jdField_a_of_type_Typ;
    }
    finally {}
  }
  
  private void a(List<QQCircleReport.SingleDcData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = new QCircleClientReportRequest(paramList);
      VSNetworkHelper.a().a(paramList, new tyr(this, paramList));
    }
  }
  
  private void b()
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void c()
  {
    a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  private void d()
  {
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    a(this.jdField_c_of_type_JavaUtilList);
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() > 0) || (this.jdField_c_of_type_JavaUtilList.size() > 0)) {}
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
      }
      if ((!this.jdField_a_of_type_AndroidOsHandler.hasMessages(4097)) && ((i != 0) || (System.currentTimeMillis() - this.jdField_c_of_type_Long <= 10L * jdField_a_of_type_Long))) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4097, jdField_a_of_type_Long);
  }
  
  private void f()
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
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleReporter.6(this));
  }
  
  public void a(QQCircleReport.SingleDcData paramSingleDcData)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleReporter.4(this, paramSingleDcData));
  }
  
  public void a(QQCircleReport.SingleDcData paramSingleDcData, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleReporter.3(this, paramBoolean, paramSingleDcData));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_d_of_type_JavaUtilList.size() == 0) {
      return;
    }
    QLog.w("QCircleReporter", 2, "reportCacheDataListToServer size:" + this.jdField_d_of_type_JavaUtilList.size());
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QQCircleReport.SingleDcData)localIterator.next()).byteExtinfo.add(tym.a("SessionID", paramArrayOfByte));
    }
    a(this.jdField_d_of_type_JavaUtilList);
    this.jdField_d_of_type_JavaUtilList.clear();
  }
  
  public void b(QQCircleReport.SingleDcData paramSingleDcData)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleReporter.5(this, paramSingleDcData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     typ
 * JD-Core Version:    0.7.0.1
 */