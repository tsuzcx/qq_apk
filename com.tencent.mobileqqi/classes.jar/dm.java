import com.dataline.mpfile.LiteMpFileFileListActivity;
import com.dataline.mpfile.MpFileDataReportCenter;
import com.dataline.mpfile.MpFileDataReportCenter.MPFWorkType;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileDataReportInfo;
import com.dataline.util.DBNetworkUtil;

class dm
  implements Runnable
{
  dm(dl paramdl) {}
  
  public void run()
  {
    MpfileDataReportInfo localMpfileDataReportInfo = new MpfileDataReportInfo();
    localMpfileDataReportInfo.jdField_b_of_type_Int = 254;
    localMpfileDataReportInfo.jdField_a_of_type_Int = MpFileDataReportCenter.MPFWorkType.fileList.ordinal();
    localMpfileDataReportInfo.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
    localMpfileDataReportInfo.d = MpfileDataCenter.E;
    localMpfileDataReportInfo.jdField_b_of_type_JavaLangString = DBNetworkUtil.a();
    localMpfileDataReportInfo.jdField_b_of_type_Long = LiteMpFileFileListActivity.b(this.a.a);
    localMpfileDataReportInfo.c = LiteMpFileFileListActivity.c(this.a.a);
    MpFileDataReportCenter.a(this.a.a.b, localMpfileDataReportInfo);
    this.a.a.a(MpfileDataCenter.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     dm
 * JD-Core Version:    0.7.0.1
 */