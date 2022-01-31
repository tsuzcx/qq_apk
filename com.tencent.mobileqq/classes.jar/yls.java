import com.tencent.mobileqq.apollo.utils.ApolloHttpCallBack;
import com.tencent.mobileqq.apollo.utils.ApolloHttpUtil;

public final class yls
  implements Runnable
{
  public yls(String paramString1, String paramString2, String[] paramArrayOfString, ApolloHttpCallBack paramApolloHttpCallBack, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString.toUpperCase();
    if (str.equals("GET")) {
      ApolloHttpUtil.a(this.b, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpCallBack);
    }
    while (!str.equals("POST")) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ApolloHttpUtil.a(this.b, this.c, this.d, this.e, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpCallBack);
      return;
    }
    ApolloHttpUtil.a(this.b, this.c, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yls
 * JD-Core Version:    0.7.0.1
 */