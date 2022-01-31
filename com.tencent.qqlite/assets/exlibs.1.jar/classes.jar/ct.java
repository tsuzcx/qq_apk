import com.dataline.mpfile.LiteMpFileMainActivity;
import com.dataline.mpfile.MpFileDataReportCenter;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileDataReportInfo;
import com.dataline.util.DBNetworkUtil;

public class ct
  implements Runnable
{
  public ct(LiteMpFileMainActivity paramLiteMpFileMainActivity) {}
  
  public void run()
  {
    MpfileDataReportInfo localMpfileDataReportInfo = new MpfileDataReportInfo();
    localMpfileDataReportInfo.jdField_b_of_type_Int = 253;
    localMpfileDataReportInfo.jdField_a_of_type_Int = 1;
    localMpfileDataReportInfo.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
    localMpfileDataReportInfo.jdField_b_of_type_JavaLangString = DBNetworkUtil.b();
    localMpfileDataReportInfo.d = MpfileDataCenter.E;
    localMpfileDataReportInfo.jdField_b_of_type_Long = LiteMpFileMainActivity.b(this.a);
    localMpfileDataReportInfo.c = LiteMpFileMainActivity.c(this.a);
    MpFileDataReportCenter.a(this.a.app, localMpfileDataReportInfo);
    this.a.a(MpfileDataCenter.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ct
 * JD-Core Version:    0.7.0.1
 */