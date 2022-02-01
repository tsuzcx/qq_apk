import UserGrowth.stWeishiDengtaReportRsp;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;

public class una
  implements ujj
{
  public una(WSStatisticsReporter paramWSStatisticsReporter) {}
  
  public void a(uju paramuju)
  {
    if (!paramuju.a())
    {
      upe.d("beaconData2Server", "BeaconSendRequest onTaskResponse failed code:" + paramuju.jdField_a_of_type_Int + ", msg:" + paramuju.jdField_a_of_type_JavaLangString);
      WSStatisticsReporter.access$1400(this.a, String.valueOf(1), String.valueOf(paramuju.jdField_a_of_type_Int), paramuju.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      if (!(paramuju.jdField_a_of_type_JavaLangObject instanceof stWeishiDengtaReportRsp)) {
        break;
      }
      paramuju = (stWeishiDengtaReportRsp)paramuju.jdField_a_of_type_JavaLangObject;
      upe.b("beaconData2Server", "BeaconSendRequest onTaskResponse succeed: " + paramuju.code + " , " + paramuju.msg);
    } while (paramuju.code == 0);
    WSStatisticsReporter.access$1400(this.a, String.valueOf(2), String.valueOf(paramuju.code), paramuju.msg);
    return;
    upe.d("beaconData2Server", "BeaconSendRequest onTaskResponse failed");
    WSStatisticsReporter.access$1400(this.a, String.valueOf(3), "-1", "数据无法解析");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     una
 * JD-Core Version:    0.7.0.1
 */