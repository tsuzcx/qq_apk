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

public final class xkl
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
    ArrayList localArrayList1 = new ArrayList();
    Object localObject4 = new ArrayList();
    for (;;)
    {
      GoldMsgDBHelper.GoldMsgNotifyRecord localGoldMsgNotifyRecord1;
      synchronized (GoldMsgDbManager.b)
      {
        Iterator localIterator2 = GoldMsgDbManager.b.iterator();
        if (!localIterator2.hasNext()) {
          break;
        }
        localGoldMsgNotifyRecord1 = (GoldMsgDBHelper.GoldMsgNotifyRecord)localIterator2.next();
        GoldMsgDBHelper.GoldMsgNotifyRecord localGoldMsgNotifyRecord2 = (GoldMsgDBHelper.GoldMsgNotifyRecord)GoldMsgDbManager.jdField_a_of_type_JavaUtilHashMap.get(localGoldMsgNotifyRecord1.jdField_a_of_type_JavaLangString);
        if (localGoldMsgNotifyRecord2 != null)
        {
          localGoldMsgNotifyRecord2.a(localGoldMsgNotifyRecord1.jdField_a_of_type_JavaUtilArrayList);
          if ((localGoldMsgNotifyRecord2.jdField_a_of_type_Int != 1) && (localGoldMsgNotifyRecord1.jdField_a_of_type_Int == 1)) {
            localGoldMsgNotifyRecord2.jdField_a_of_type_Int = 1;
          }
          ((ArrayList)localObject4).add(localGoldMsgNotifyRecord2);
        }
      }
      GoldMsgDbManager.jdField_a_of_type_JavaUtilHashMap.put(localGoldMsgNotifyRecord1.jdField_a_of_type_JavaLangString, localGoldMsgNotifyRecord1);
      localArrayList2.add(localGoldMsgNotifyRecord1);
    }
    if (localArrayList2.size() > 0) {
      GoldMsgDbManager.a(localArrayList2, true);
    }
    if (((ArrayList)localObject4).size() > 0) {
      GoldMsgDbManager.a((ArrayList)localObject4, false);
    }
    GoldMsgDbManager.jdField_a_of_type_Int = 2;
    synchronized (GoldMsgDbManager.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator1 = GoldMsgDbManager.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator1.hasNext())
      {
        localObject4 = (MessageRecord)localIterator1.next();
        if (localObject4 != null) {
          GoldMsgDbManager.a((MessageRecord)localObject4);
        }
      }
    }
    GoldMsgDbManager.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xkl
 * JD-Core Version:    0.7.0.1
 */