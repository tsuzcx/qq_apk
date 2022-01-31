import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;

public class zgr
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private QQFrameZipDecoder jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public void a(QQFrameZipDecoder paramQQFrameZipDecoder, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder = paramQQFrameZipDecoder;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zgr
 * JD-Core Version:    0.7.0.1
 */