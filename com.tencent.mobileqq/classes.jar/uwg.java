import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;

public class uwg
{
  private ansy jdField_a_of_type_Ansy;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public uwg(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Ansy = new uwh(this);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Ansy);
    }
  }
  
  public long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      ansr localansr = (ansr)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      if (localansr != null)
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        return localansr.a(paramString, 0).longValue();
      }
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Ansy);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwg
 * JD-Core Version:    0.7.0.1
 */