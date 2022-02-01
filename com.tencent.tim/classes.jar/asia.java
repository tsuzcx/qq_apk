import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qidian.proto.mobileqq_qidian.CompanyShowCaseInfo;

public class asia
{
  public String cEQ = "";
  public String cER = "";
  public String title = "";
  
  public asia() {}
  
  public asia(mobileqq_qidian.CompanyShowCaseInfo paramCompanyShowCaseInfo)
  {
    a(paramCompanyShowCaseInfo);
  }
  
  public mobileqq_qidian.CompanyShowCaseInfo a()
  {
    mobileqq_qidian.CompanyShowCaseInfo localCompanyShowCaseInfo = new mobileqq_qidian.CompanyShowCaseInfo();
    localCompanyShowCaseInfo.string_show_case_title.set(this.title);
    localCompanyShowCaseInfo.string_show_case_link.set(this.cEQ);
    localCompanyShowCaseInfo.string_show_case_image.set(this.cER);
    return localCompanyShowCaseInfo;
  }
  
  public void a(mobileqq_qidian.CompanyShowCaseInfo paramCompanyShowCaseInfo)
  {
    if (paramCompanyShowCaseInfo.string_show_case_title.has()) {
      this.title = paramCompanyShowCaseInfo.string_show_case_title.get();
    }
    if (paramCompanyShowCaseInfo.string_show_case_link.has()) {
      this.cEQ = paramCompanyShowCaseInfo.string_show_case_link.get();
    }
    if (paramCompanyShowCaseInfo.string_show_case_image.has()) {
      this.cER = paramCompanyShowCaseInfo.string_show_case_image.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asia
 * JD-Core Version:    0.7.0.1
 */