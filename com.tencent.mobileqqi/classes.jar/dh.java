import com.dataline.mpfile.LiteMpFileFileListActivity;
import com.dataline.mpfile.MpFileDataReportCenter;
import com.dataline.mpfile.MpFileDataReportCenter.MPFWorkType;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileDataReportInfo;
import com.dataline.util.DBNetworkUtil;

public class dh
  implements Runnable
{
  public dh(LiteMpFileFileListActivity paramLiteMpFileFileListActivity) {}
  
  public void run()
  {
    MpfileDataReportInfo localMpfileDataReportInfo = new MpfileDataReportInfo();
    localMpfileDataReportInfo.jdField_b_of_type_Int = 253;
    localMpfileDataReportInfo.jdField_a_of_type_Int = MpFileDataReportCenter.MPFWorkType.fileList.ordinal();
    localMpfileDataReportInfo.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
    localMpfileDataReportInfo.jdField_b_of_type_JavaLangString = DBNetworkUtil.a();
    localMpfileDataReportInfo.d = MpfileDataCenter.E;
    localMpfileDataReportInfo.jdField_b_of_type_Long = LiteMpFileFileListActivity.b(this.a);
    localMpfileDataReportInfo.c = LiteMpFileFileListActivity.c(this.a);
    MpFileDataReportCenter.a(this.a.b, localMpfileDataReportInfo);
    this.a.a(MpfileDataCenter.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     dh
 * JD-Core Version:    0.7.0.1
 */