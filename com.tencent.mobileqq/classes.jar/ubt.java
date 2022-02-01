import android.text.TextUtils;
import com.tencent.common.app.AppInterface;

public class ubt
{
  private anwb jdField_a_of_type_Anwb;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public ubt(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Anwb = new ubu(this);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Anwb);
    }
  }
  
  public long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      anvu localanvu = (anvu)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(8);
      if (localanvu != null)
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        return localanvu.a(paramString, 0).longValue();
      }
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Anwb);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ubt
 * JD-Core Version:    0.7.0.1
 */