import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;

final class uum
  extends apas
{
  uum(Object paramObject, QQAppInterface paramQQAppInterface, String paramString, aoav paramaoav, boolean paramBoolean, Context paramContext) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      paramObject = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (paramObject != null) {
        paramObject.a(this.jdField_a_of_type_JavaLangObject);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aoav != null) {
        this.jdField_a_of_type_Aoav.onUpdate(102, true, this.jdField_a_of_type_JavaLangString);
      }
      return;
      paramObject = (aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      paramObject.b(this.jdField_a_of_type_JavaLangString);
      paramObject.a(this.jdField_a_of_type_JavaLangString);
      StructLongMessageDownloadProcessor.deleteTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearHistory(this.jdField_a_of_type_JavaLangString, 1008);
      uqx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a());
      uot.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      paramObject = (onq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      if (paramObject != null) {
        paramObject.a(this.jdField_a_of_type_JavaLangString, "unfollow");
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    if (this.jdField_a_of_type_Aoav != null) {
      this.jdField_a_of_type_Aoav.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean) {
      uuc.a(this.jdField_a_of_type_AndroidContentContext, 2131694983);
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uum
 * JD-Core Version:    0.7.0.1
 */