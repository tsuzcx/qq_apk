import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDBHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDBHelper.GoldMsgNotifyRecord;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDbManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class xer
  implements Runnable
{
  public void run()
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
    if (GoldMsgDbManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDBHelper != null) {
      GoldMsgDbManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDBHelper.a(((QQAppInterface)???).c(), GoldMsgDbManager.jdField_a_of_type_JavaUtilHashMap);
    }
    ??? = new ArrayList();
    Object localObject3 = new ArrayList();
    Iterator localIterator = GoldMsgDbManager.b.iterator();
    while (localIterator.hasNext())
    {
      GoldMsgDBHelper.GoldMsgNotifyRecord localGoldMsgNotifyRecord1 = (GoldMsgDBHelper.GoldMsgNotifyRecord)localIterator.next();
      GoldMsgDBHelper.GoldMsgNotifyRecord localGoldMsgNotifyRecord2 = (GoldMsgDBHelper.GoldMsgNotifyRecord)GoldMsgDbManager.jdField_a_of_type_JavaUtilHashMap.get(localGoldMsgNotifyRecord1.jdField_a_of_type_JavaLangString);
      if (localGoldMsgNotifyRecord2 != null)
      {
        localGoldMsgNotifyRecord2.a(localGoldMsgNotifyRecord1.jdField_a_of_type_JavaUtilArrayList);
        if ((localGoldMsgNotifyRecord2.jdField_a_of_type_Int != 1) && (localGoldMsgNotifyRecord1.jdField_a_of_type_Int == 1)) {
          localGoldMsgNotifyRecord2.jdField_a_of_type_Int = 1;
        }
        ((ArrayList)localObject3).add(localGoldMsgNotifyRecord2);
      }
      else
      {
        GoldMsgDbManager.jdField_a_of_type_JavaUtilHashMap.put(localGoldMsgNotifyRecord1.jdField_a_of_type_JavaLangString, localGoldMsgNotifyRecord1);
        ((ArrayList)???).add(localGoldMsgNotifyRecord1);
      }
    }
    if (((ArrayList)???).size() > 0) {
      GoldMsgDbManager.a((ArrayList)???, true);
    }
    if (((ArrayList)localObject3).size() > 0) {
      GoldMsgDbManager.a((ArrayList)localObject3, false);
    }
    GoldMsgDbManager.jdField_a_of_type_Int = 2;
    ??? = GoldMsgDbManager.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)???).next();
      if (localObject3 != null) {
        GoldMsgDbManager.a((MessageRecord)localObject3);
      }
    }
    GoldMsgDbManager.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xer
 * JD-Core Version:    0.7.0.1
 */