import UserGrowth.stWeishiDengtaReportRsp;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;

public class tjy
  implements tgt
{
  public tjy(WSStatisticsReporter paramWSStatisticsReporter) {}
  
  public void a(the paramthe)
  {
    if (!paramthe.a())
    {
      tlo.d("beaconData2Server", "BeaconSendRequest onTaskResponse failed code:" + paramthe.jdField_a_of_type_Int + ", msg:" + paramthe.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramthe.jdField_a_of_type_JavaLangObject instanceof stWeishiDengtaReportRsp))
    {
      paramthe = (stWeishiDengtaReportRsp)paramthe.jdField_a_of_type_JavaLangObject;
      tlo.b("beaconData2Server", "BeaconSendRequest onTaskResponse succeed: " + paramthe.code + " , " + paramthe.msg);
      return;
    }
    tlo.d("beaconData2Server", "BeaconSendRequest onTaskResponse failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tjy
 * JD-Core Version:    0.7.0.1
 */