import UserGrowth.stWeishiDengtaReportRsp;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;

public class vkj
  implements vfg
{
  public vkj(WSStatisticsReporter paramWSStatisticsReporter) {}
  
  public void a(vfr paramvfr)
  {
    if (!paramvfr.a())
    {
      vmp.d("beaconData2Server", "BeaconSendRequest onTaskResponse failed code:" + paramvfr.jdField_a_of_type_Int + ", msg:" + paramvfr.jdField_a_of_type_JavaLangString);
      WSStatisticsReporter.access$1700(this.a, String.valueOf(1), String.valueOf(paramvfr.jdField_a_of_type_Int), paramvfr.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      if (!(paramvfr.jdField_a_of_type_JavaLangObject instanceof stWeishiDengtaReportRsp)) {
        break;
      }
      paramvfr = (stWeishiDengtaReportRsp)paramvfr.jdField_a_of_type_JavaLangObject;
      vmp.b("beaconData2Server", "BeaconSendRequest onTaskResponse succeed: " + paramvfr.code + " , " + paramvfr.msg);
    } while (paramvfr.code == 0);
    WSStatisticsReporter.access$1700(this.a, String.valueOf(2), String.valueOf(paramvfr.code), paramvfr.msg);
    return;
    vmp.d("beaconData2Server", "BeaconSendRequest onTaskResponse failed");
    WSStatisticsReporter.access$1700(this.a, String.valueOf(3), "-1", "数据无法解析");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkj
 * JD-Core Version:    0.7.0.1
 */