import com.tencent.biz.qqstory.base.ErrorMessage;

public class tku
  extends ssh
{
  public final int a;
  public final String a;
  public final String b;
  
  public tku(tkt paramtkt, ErrorMessage paramErrorMessage, String paramString1, String paramString2, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tku
 * JD-Core Version:    0.7.0.1
 */