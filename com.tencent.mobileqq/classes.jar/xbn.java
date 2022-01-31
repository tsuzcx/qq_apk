import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDBHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDbManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public final class xbn
  implements Runnable
{
  public xbn(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    do
    {
      synchronized (GoldMsgDbManager.jdField_a_of_type_JavaLangObject)
      {
        if (GoldMsgDbManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDBHelper == null) {
          GoldMsgDbManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDBHelper = new GoldMsgDBHelper(BaseApplicationImpl.getContext());
        }
        ??? = QWalletTools.a();
        if (??? == null) {
          return;
        }
      }
    } while (GoldMsgDbManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDBHelper == null);
    if (this.jdField_a_of_type_Boolean)
    {
      GoldMsgDbManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDBHelper.a(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    GoldMsgDbManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDBHelper.b(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbn
 * JD-Core Version:    0.7.0.1
 */