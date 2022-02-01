import com.tencent.biz.qqstory.base.ErrorMessage;

public class wrn
  extends vzj
{
  public final int a;
  public final String a;
  public final String b;
  
  public wrn(wrm paramwrm, ErrorMessage paramErrorMessage, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    return "ReportEvent{vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", uin='" + this.b + '\'' + ", impeachType=" + this.jdField_a_of_type_Int + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrn
 * JD-Core Version:    0.7.0.1
 */