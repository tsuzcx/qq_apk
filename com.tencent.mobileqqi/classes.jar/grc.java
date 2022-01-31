import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.NetworkUtil;

public class grc
  implements Runnable
{
  public grc(BuddyTransfileProcessor paramBuddyTransfileProcessor, String paramString, short paramShort, boolean paramBoolean) {}
  
  public void run()
  {
    FileMsg localFileMsg;
    if ((StreamDataManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString) != 0) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.k))
    {
      localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      BuddyTransfileProcessor localBuddyTransfileProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor;
      long l = System.nanoTime();
      localBuddyTransfileProcessor.jdField_a_of_type_Long = l;
      localFileMsg.jdField_e_of_type_Long = l;
      this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.k = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor), this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Short, BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor), BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor));
    this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), 2, 0, StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Short));
    if (!this.jdField_a_of_type_Boolean)
    {
      localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      localFileMsg.d += StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Short);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     grc
 * JD-Core Version:    0.7.0.1
 */