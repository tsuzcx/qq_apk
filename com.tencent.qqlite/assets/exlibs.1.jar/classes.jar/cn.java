import com.dataline.mpfile.LiteMpFileFileListActivity;
import com.dataline.mpfile.MpFileDataReportCenter;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileDataReportInfo;
import com.dataline.util.DBNetworkUtil;

public class cn
  implements Runnable
{
  public cn(LiteMpFileFileListActivity paramLiteMpFileFileListActivity) {}
  
  public void run()
  {
    MpfileDataReportInfo localMpfileDataReportInfo = new MpfileDataReportInfo();
    localMpfileDataReportInfo.jdField_b_of_type_Int = 253;
    localMpfileDataReportInfo.jdField_a_of_type_Int = 0;
    localMpfileDataReportInfo.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
    localMpfileDataReportInfo.jdField_b_of_type_JavaLangString = DBNetworkUtil.b();
    localMpfileDataReportInfo.d = MpfileDataCenter.E;
    localMpfileDataReportInfo.jdField_b_of_type_Long = LiteMpFileFileListActivity.b(this.a);
    localMpfileDataReportInfo.c = LiteMpFileFileListActivity.c(this.a);
    MpFileDataReportCenter.a(this.a.app, localMpfileDataReportInfo);
    this.a.a(MpfileDataCenter.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cn
 * JD-Core Version:    0.7.0.1
 */