import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class znb
  implements Runnable
{
  public znb(SignatureManager paramSignatureManager, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(this.jdField_a_of_type_Int);
    SignatureTemplateInfo localSignatureTemplateInfo = SignatureTemplateConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
    if (localSignatureTemplateInfo != null) {
      SignatureManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localSignatureTemplateInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znb
 * JD-Core Version:    0.7.0.1
 */