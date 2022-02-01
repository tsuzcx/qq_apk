import UserGrowth.stWeishiDengtaReportRsp;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;

public class uvv
  implements uqy
{
  public uvv(WSStatisticsReporter paramWSStatisticsReporter) {}
  
  public void a(urj paramurj)
  {
    if (!paramurj.a())
    {
      uya.d("beaconData2Server", "BeaconSendRequest onTaskResponse failed code:" + paramurj.jdField_a_of_type_Int + ", msg:" + paramurj.jdField_a_of_type_JavaLangString);
      WSStatisticsReporter.access$1400(this.a, String.valueOf(1), String.valueOf(paramurj.jdField_a_of_type_Int), paramurj.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      if (!(paramurj.jdField_a_of_type_JavaLangObject instanceof stWeishiDengtaReportRsp)) {
        break;
      }
      paramurj = (stWeishiDengtaReportRsp)paramurj.jdField_a_of_type_JavaLangObject;
      uya.b("beaconData2Server", "BeaconSendRequest onTaskResponse succeed: " + paramurj.code + " , " + paramurj.msg);
    } while (paramurj.code == 0);
    WSStatisticsReporter.access$1400(this.a, String.valueOf(2), String.valueOf(paramurj.code), paramurj.msg);
    return;
    uya.d("beaconData2Server", "BeaconSendRequest onTaskResponse failed");
    WSStatisticsReporter.access$1400(this.a, String.valueOf(3), "-1", "数据无法解析");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvv
 * JD-Core Version:    0.7.0.1
 */