import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;

final class ugp
  extends anxq
{
  ugp(Object paramObject, QQAppInterface paramQQAppInterface, String paramString, amyh paramamyh, boolean paramBoolean, Context paramContext) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      paramObject = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(11);
      if (paramObject != null) {
        paramObject.a(this.jdField_a_of_type_JavaLangObject);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Amyh != null) {
        this.jdField_a_of_type_Amyh.onUpdate(102, true, this.jdField_a_of_type_JavaLangString);
      }
      return;
      paramObject = (amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      paramObject.b(this.jdField_a_of_type_JavaLangString);
      paramObject.a(this.jdField_a_of_type_JavaLangString);
      StructLongMessageDownloadProcessor.deleteTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearHistory(this.jdField_a_of_type_JavaLangString, 1008);
      uda.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a());
      uaw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      paramObject = (ofx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      if (paramObject != null) {
        paramObject.a(this.jdField_a_of_type_JavaLangString, "unfollow");
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    if (this.jdField_a_of_type_Amyh != null) {
      this.jdField_a_of_type_Amyh.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean) {
      ugf.a(this.jdField_a_of_type_AndroidContentContext, 2131694775);
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugp
 * JD-Core Version:    0.7.0.1
 */