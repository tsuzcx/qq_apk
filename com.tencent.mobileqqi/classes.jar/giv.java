import QQService.CARDSETTYPE;
import SummaryCardTaf.SSummaryCardSetReq;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileCardTemplateInfo;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class giv
  implements Runnable
{
  public giv(ProfileCardBrowserActivity paramProfileCardBrowserActivity, long paramLong, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "downloadAndSetupCard, mIsRequesting : " + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference == null) {
        break label298;
      }
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "downloadAndSetupCard, mCurrentSetupCard, cardId : " + ((Pair)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).first + ", position : " + ((Pair)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).second);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference == null) {
        break label309;
      }
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "downloadAndSetupCard, mLatestSetupCard, cardId : " + ((Pair)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).first + ", position : " + ((Pair)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).second);
    }
    Object localObject1;
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_AndroidOsHandler.obtainMessage(17);
        ((Message)localObject1).arg1 = ((Integer)((Pair)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).second).intValue();
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(new Pair(Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_Int)));
      if (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label320;
      }
      return;
      label298:
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "downloadAndSetupCard, mCurrentSetupCard is null.");
      break;
      label309:
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "downloadAndSetupCard, mLatestSetupCard is null.");
    }
    label320:
    label378:
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(new Pair(Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_Int)));
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      localObject2 = new giw(this);
      localObject1 = (ProfileCardTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      i = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.a(((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, (HttpDownloadUtil.HttpDownloadListener)localObject2);
      if ((i != 18) && (i != 19)) {
        break label740;
      }
      ((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_Int = 2;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      ((Message)localObject2).arg1 = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, String.format("Template resource Zip download success , url : %s, cardId : %d ", new Object[] { ((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.e, Long.valueOf(((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_Long) }));
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(((Pair)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).first), String.valueOf(((Pair)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).second));
        localObject1 = new SSummaryCardSetReq(2, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()), this.jdField_a_of_type_Long, "6.0.0", 109L);
        localObject2 = new UniPacket(true);
        ((UniPacket)localObject2).setEncodeName("utf-8");
        ((UniPacket)localObject2).setFuncName("set");
        ((UniPacket)localObject2).setServantName("MCardSvc");
        ((UniPacket)localObject2).put("req", localObject1);
        localObject1 = ((UniPacket)localObject2).encode();
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), CARDSETTYPE.TYPE_SET_TEMPLATE.value(), (byte)0, null, null, null, null, (byte[])localObject1);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference;
      break label378;
      label740:
      if (i == 17)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
        ((Message)localObject2).arg1 = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, String.format("Template resource Zip unzip fail , url : %s, cardId : %d ", new Object[] { ((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.e, Long.valueOf(((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_Long) }));
        }
        i = 0;
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
        ((Message)localObject2).arg1 = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, String.format("Template resource Zip download fail , url : %s, cardId : %d ", new Object[] { ((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.e, Long.valueOf(((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_Long) }));
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     giv
 * JD-Core Version:    0.7.0.1
 */