import android.text.TextUtils;
import com.tencent.common.app.AppInterface;

public class uij
{
  private amqk jdField_a_of_type_Amqk;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public uij(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Amqk = new uik(this);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Amqk);
    }
  }
  
  public long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      amqd localamqd = (amqd)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(8);
      if (localamqd != null)
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        return localamqd.a(paramString, 0).longValue();
      }
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Amqk);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uij
 * JD-Core Version:    0.7.0.1
 */