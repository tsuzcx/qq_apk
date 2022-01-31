import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.SecUtil;

class hfo
  implements Runnable
{
  hfo(hfn paramhfn, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.jdField_a_of_type_Hfn.a.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    String str = SecUtil.a(AntiFraudConfigFileUtil.a(this.jdField_a_of_type_Hfn.a, this.jdField_a_of_type_JavaLangString));
    if (!this.b.equalsIgnoreCase(str))
    {
      AntiFraudConfigFileUtil.a(this.jdField_a_of_type_Hfn.a, this.jdField_a_of_type_JavaLangString, this.b, this.c);
      return;
    }
    this.jdField_a_of_type_Hfn.a.a(this.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfo
 * JD-Core Version:    0.7.0.1
 */