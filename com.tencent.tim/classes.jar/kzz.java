import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.Reporting;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.cmd0xe13.oidb_cmd0xe13.ReportInfo;
import tencent.im.oidb.cmd0xe13.oidb_cmd0xe13.ReqBody;
import tencent.im.oidb.cmd0xe13.oidb_cmd0xe13.RspBody;

public class kzz
  extends lir
  implements anot.a
{
  private AtomicInteger J = new AtomicInteger(new Random().nextInt(10000));
  private ArrayList<String> kr = new ArrayList();
  
  public kzz()
  {
    super(null, null, null, lun.a(), null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    paramToServiceMsg.extraData.putInt("request_req", paramInt1);
    paramToServiceMsg.extraData.putInt("request_retry_time", paramInt2);
    paramToServiceMsg.extraData.putByteArray("request_report_datas", paramArrayOfByte);
    paramToServiceMsg.setTimeout(30000L);
  }
  
  private void bQ(ArrayList<String> paramArrayList)
  {
    oidb_cmd0xe13.ReqBody localReqBody = new oidb_cmd0xe13.ReqBody();
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i = this.J.incrementAndGet();
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      oidb_cmd0xe13.ReportInfo localReportInfo = new oidb_cmd0xe13.ReportInfo();
      localReportInfo.uint64_time.set(l);
      localReportInfo.bytes_report.set(ByteStringMicro.copyFromUtf8(str));
      localReqBody.msg_report_info.add(localReportInfo);
    }
    localReqBody.uint32_seq.set(i);
    localObject = lup.makeOIDBPkg("OidbSvc.0xe13", 3603, 0, localReqBody.toByteArray());
    a((ToServiceMsg)localObject, i, 0, localReqBody.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
    QLog.d("RIJNewReporter", 1, "send report data to servlet, size : " + paramArrayList.size() + ", seq : " + i + ", contents : " + paramArrayList);
  }
  
  public void a(Reporting paramReporting)
  {
    if ((paramReporting == null) || (TextUtils.isEmpty(paramReporting.mDetail))) {}
    do
    {
      return;
      String str = paramReporting.mDetail.replace("${count_unknown}", String.valueOf(paramReporting.mCount));
      paramReporting = str;
      if (str.startsWith("${report_seq_prefix}")) {
        paramReporting = str.substring(str.indexOf("|") + 1);
      }
      QLog.d("RIJNewReporter", 1, "report data : " + paramReporting);
      this.kr.add(paramReporting);
    } while (this.kr.size() < 20);
    bQ(this.kr);
    this.kr.clear();
  }
  
  public void aIl()
  {
    QLog.d("RIJNewReporter", 1, "notifyCurrentReportLoopFinish");
    if (this.kr.size() > 0)
    {
      bQ(this.kr);
      this.kr.clear();
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("request_req");
    int j = paramToServiceMsg.extraData.getInt("request_retry_time");
    QLog.d("RIJNewReporter", 1, "receive servlet oxe13 resp ! seq : " + i + ", retryTime : " + j);
    oidb_cmd0xe13.RspBody localRspBody = new oidb_cmd0xe13.RspBody();
    int k = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (k == 0)
    {
      QLog.d("RIJNewReporter", 1, "receive servlet oxe13 resp success !  businessCode : " + localRspBody.uint32_result.get());
      return;
    }
    if (j < 2)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("request_report_datas");
      paramFromServiceMsg = lup.makeOIDBPkg("OidbSvc.0xe13", 3603, 0, paramToServiceMsg);
      a(paramFromServiceMsg, i, j + 1, paramToServiceMsg);
      sendPbReq(paramFromServiceMsg);
      QLog.d("RIJNewReporter", 1, "receive servlet oxe13 resp error ! code : " + k + ", toRertry ：" + true);
      return;
    }
    QLog.d("RIJNewReporter", 1, "receive servlet oxe13 resp error ! code : " + k + ", toRertry ：" + false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kzz
 * JD-Core Version:    0.7.0.1
 */