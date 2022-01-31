import com.tencent.biz.qqstory.base.ErrorMessage;

public class uzo
  extends ugz
{
  public final String a;
  public final String b;
  public final String c;
  
  public uzo(ErrorMessage paramErrorMessage, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.c = paramString3;
  }
  
  public String toString()
  {
    return "ReportEvent{vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", uin='" + this.b + '\'' + ", impeachType=" + this.c + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzo
 * JD-Core Version:    0.7.0.1
 */