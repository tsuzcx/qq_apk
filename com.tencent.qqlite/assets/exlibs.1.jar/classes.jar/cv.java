import com.dataline.mpfile.LiteMpFileMainActivity;
import com.dataline.mpfile.MpFileDataReportCenter;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileDataReportInfo;
import com.dataline.util.DBNetworkUtil;

class cv
  implements Runnable
{
  cv(cu paramcu) {}
  
  public void run()
  {
    MpfileDataReportInfo localMpfileDataReportInfo = new MpfileDataReportInfo();
    localMpfileDataReportInfo.jdField_b_of_type_Int = 254;
    localMpfileDataReportInfo.jdField_a_of_type_Int = 1;
    localMpfileDataReportInfo.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
    localMpfileDataReportInfo.jdField_b_of_type_JavaLangString = DBNetworkUtil.b();
    localMpfileDataReportInfo.d = MpfileDataCenter.E;
    localMpfileDataReportInfo.jdField_b_of_type_Long = LiteMpFileMainActivity.b(this.a.a);
    localMpfileDataReportInfo.c = LiteMpFileMainActivity.c(this.a.a);
    MpFileDataReportCenter.a(this.a.a.app, localMpfileDataReportInfo);
    this.a.a.a(MpfileDataCenter.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cv
 * JD-Core Version:    0.7.0.1
 */