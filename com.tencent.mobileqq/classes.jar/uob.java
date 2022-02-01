import UserGrowth.stWeishiDengtaReportRsp;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;

public class uob
  implements ukd
{
  public uob(WSStatisticsReporter paramWSStatisticsReporter) {}
  
  public void a(uko paramuko)
  {
    if (!paramuko.a())
    {
      uqf.d("beaconData2Server", "BeaconSendRequest onTaskResponse failed code:" + paramuko.jdField_a_of_type_Int + ", msg:" + paramuko.jdField_a_of_type_JavaLangString);
      WSStatisticsReporter.access$1400(this.a, String.valueOf(1), String.valueOf(paramuko.jdField_a_of_type_Int), paramuko.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      if (!(paramuko.jdField_a_of_type_JavaLangObject instanceof stWeishiDengtaReportRsp)) {
        break;
      }
      paramuko = (stWeishiDengtaReportRsp)paramuko.jdField_a_of_type_JavaLangObject;
      uqf.b("beaconData2Server", "BeaconSendRequest onTaskResponse succeed: " + paramuko.code + " , " + paramuko.msg);
    } while (paramuko.code == 0);
    WSStatisticsReporter.access$1400(this.a, String.valueOf(2), String.valueOf(paramuko.code), paramuko.msg);
    return;
    uqf.d("beaconData2Server", "BeaconSendRequest onTaskResponse failed");
    WSStatisticsReporter.access$1400(this.a, String.valueOf(3), "-1", "数据无法解析");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uob
 * JD-Core Version:    0.7.0.1
 */