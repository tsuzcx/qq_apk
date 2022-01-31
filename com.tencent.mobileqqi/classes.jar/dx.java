import com.dataline.mpfile.LiteMpFileMainActivity;
import com.dataline.mpfile.MpFileDataReportCenter;
import com.dataline.mpfile.MpFileDataReportCenter.MPFWorkType;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileDataReportInfo;
import com.dataline.util.DBNetworkUtil;

public class dx
  implements Runnable
{
  public dx(LiteMpFileMainActivity paramLiteMpFileMainActivity) {}
  
  public void run()
  {
    MpfileDataReportInfo localMpfileDataReportInfo = new MpfileDataReportInfo();
    localMpfileDataReportInfo.jdField_a_of_type_Int = MpFileDataReportCenter.MPFWorkType.connection.ordinal();
    localMpfileDataReportInfo.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
    localMpfileDataReportInfo.jdField_b_of_type_JavaLangString = DBNetworkUtil.a();
    localMpfileDataReportInfo.d = MpfileDataCenter.E;
    localMpfileDataReportInfo.jdField_b_of_type_Long = LiteMpFileMainActivity.b(this.a);
    localMpfileDataReportInfo.c = LiteMpFileMainActivity.c(this.a);
    localMpfileDataReportInfo.jdField_b_of_type_Int = 2;
    MpFileDataReportCenter.a(this.a.b, localMpfileDataReportInfo);
    this.a.a(MpfileDataCenter.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     dx
 * JD-Core Version:    0.7.0.1
 */