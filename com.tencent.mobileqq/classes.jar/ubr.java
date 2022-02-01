import android.text.TextUtils;
import com.tencent.common.app.AppInterface;

public class ubr
{
  private anke jdField_a_of_type_Anke;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public ubr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Anke = new ubs(this);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Anke);
    }
  }
  
  public long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      anjx localanjx = (anjx)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(8);
      if (localanjx != null)
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        return localanjx.a(paramString, 0).longValue();
      }
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Anke);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ubr
 * JD-Core Version:    0.7.0.1
 */