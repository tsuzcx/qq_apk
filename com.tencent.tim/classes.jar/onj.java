import UserGrowth.stWeishiDengtaReportRsp;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;

public class onj
  implements oko
{
  public onj(WSStatisticsReporter paramWSStatisticsReporter) {}
  
  public void a(okz paramokz)
  {
    if (!paramokz.succeeded())
    {
      ooz.e("beaconData2Server", "BeaconSendRequest onTaskResponse failed code:" + paramokz.bfj + ", msg:" + paramokz.msg);
      return;
    }
    if ((paramokz.bb instanceof stWeishiDengtaReportRsp))
    {
      paramokz = (stWeishiDengtaReportRsp)paramokz.bb;
      ooz.d("beaconData2Server", "BeaconSendRequest onTaskResponse succeed: " + paramokz.code + " , " + paramokz.msg);
      return;
    }
    ooz.e("beaconData2Server", "BeaconSendRequest onTaskResponse failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onj
 * JD-Core Version:    0.7.0.1
 */