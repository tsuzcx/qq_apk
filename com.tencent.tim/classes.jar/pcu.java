import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.qqcircle.report.QCircleReporter.2;
import com.tencent.biz.qqcircle.report.QCircleReporter.4;
import com.tencent.biz.qqcircle.report.QCircleReporter.5;
import com.tencent.biz.qqcircle.report.QCircleReporter.6;
import com.tencent.biz.qqcircle.report.QCircleReporter.7;
import com.tencent.biz.qqcircle.requests.QCircleClientReportRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import qqcircle.QQCircleReport.SingleDcData;

public class pcu
{
  private static volatile pcu a;
  private static final int bhj;
  private static final int bhk = QzoneConfig.getQQCircleQualityReportBufferLength();
  private static final long zH = TimeUnit.SECONDS.toMillis(QzoneConfig.getQQCircleReportInterval());
  private static final long zI;
  private List<QQCircleReport.SingleDcData> lA = new ArrayList();
  private List<QQCircleReport.SingleDcData> lB = new ArrayList();
  private List<QQCircleReport.SingleDcData> ly = new ArrayList();
  private List<QQCircleReport.SingleDcData> lz = new ArrayList();
  private Handler reportHandler;
  private long zJ = System.currentTimeMillis();
  private long zK = System.currentTimeMillis();
  
  static
  {
    bhj = QzoneConfig.getQQCircleReportBufferLength();
    zI = TimeUnit.SECONDS.toMillis(QzoneConfig.getQQCircleQualityReportInterval());
  }
  
  private pcu()
  {
    HandlerThread localHandlerThread = new HandlerThread("qqcircle_report");
    localHandlerThread.setPriority(10);
    localHandlerThread.start();
    this.reportHandler = new pcv(this, localHandlerThread.getLooper());
  }
  
  public static pcu a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new pcu();
      }
      return a;
    }
    finally {}
  }
  
  private void bjB()
  {
    this.zJ = System.currentTimeMillis();
    dF(this.ly);
    this.ly.clear();
  }
  
  private void bjC()
  {
    dF(this.lz);
    this.lz.clear();
  }
  
  private void bjD()
  {
    this.zK = System.currentTimeMillis();
    dF(this.lA);
    this.lA.clear();
  }
  
  private void bjE()
  {
    if (!this.reportHandler.hasMessages(4098)) {
      this.reportHandler.sendEmptyMessageDelayed(4098, 1000L);
    }
  }
  
  private void checkShouldReportToServer()
  {
    if ((this.ly.size() > 0) || (this.lA.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((System.currentTimeMillis() - this.zJ > zH) || (this.ly.size() >= bhj)) {
          bjB();
        }
        if ((System.currentTimeMillis() - this.zK > zI) || (this.lA.size() >= bhk)) {
          bjD();
        }
      }
      if ((!this.reportHandler.hasMessages(4097)) && ((i != 0) || (System.currentTimeMillis() - this.zJ <= 10L * zH))) {
        break;
      }
      return;
    }
    this.reportHandler.sendEmptyMessageDelayed(4097, zH);
  }
  
  private void dF(List<QQCircleReport.SingleDcData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = new QCircleClientReportRequest(paramList);
      VSNetworkHelper.a().a(paramList, new pcw(this, paramList));
    }
  }
  
  public void M(byte[] paramArrayOfByte)
  {
    this.reportHandler.post(new QCircleReporter.2(this, paramArrayOfByte));
  }
  
  public void a(QQCircleReport.SingleDcData paramSingleDcData)
  {
    this.reportHandler.post(new QCircleReporter.5(this, paramSingleDcData));
  }
  
  public void a(QQCircleReport.SingleDcData paramSingleDcData, boolean paramBoolean)
  {
    this.reportHandler.post(new QCircleReporter.4(this, paramBoolean, paramSingleDcData));
  }
  
  public void b(QQCircleReport.SingleDcData paramSingleDcData)
  {
    this.reportHandler.post(new QCircleReporter.6(this, paramSingleDcData));
  }
  
  public void flush()
  {
    this.reportHandler.post(new QCircleReporter.7(this));
  }
  
  public Handler getReportHandler()
  {
    return this.reportHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcu
 * JD-Core Version:    0.7.0.1
 */