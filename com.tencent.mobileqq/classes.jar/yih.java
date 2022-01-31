import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class yih
  implements Runnable
{
  public yih(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame, List paramList1, int paramInt1, int paramInt2, String paramString1, String paramString2, Map paramMap, List paramList2, AtomicInteger paramAtomicInteger) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.subList(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    int j = 0;
    TroopMemberInfo localTroopMemberInfo;
    label127:
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
      if (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_b_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread, curTroopUin != mTroopUin, return, " + this.jdField_a_of_type_JavaLangString + "," + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_b_of_type_JavaLangString);
        }
        return;
      }
    } while (((!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s) && (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(localTroopMemberInfo.memberuin))) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h.contains(localTroopMemberInfo.memberuin)) || (!Utils.d(localTroopMemberInfo.memberuin)));
    for (;;)
    {
      try
      {
        for (;;)
        {
          for (;;)
          {
            long l = Long.valueOf(localTroopMemberInfo.memberuin).longValue();
            if (l < 0L) {
              break;
            }
            localObject1 = null;
            label274:
            int i;
            if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.f == TroopAddFrdsInnerFrame.d)
            {
              localTroopMemberInfo.displayedNamePinyinFirst = ChnToSpell.a(ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin), 2);
              if ((localTroopMemberInfo.displayedNamePinyinFirst == null) || (localTroopMemberInfo.displayedNamePinyinFirst.length() == 0))
              {
                localObject1 = "#";
                i = ((String)localObject1).charAt(0);
                if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
                  break label439;
                }
                localObject1 = ((String)localObject1).toUpperCase();
                label312:
                if ((localTroopMemberInfo.commonFrdCnt == -2147483648) && (!localTroopMemberInfo.memberuin.equals(this.jdField_b_of_type_JavaLangString))) {
                  localArrayList.add(localTroopMemberInfo.memberuin);
                }
              }
            }
            synchronized (this.jdField_a_of_type_JavaUtilMap)
            {
              if (this.jdField_a_of_type_JavaUtilMap.get(localObject1) == null) {
                this.jdField_a_of_type_JavaUtilMap.put(localObject1, new ArrayList());
              }
              ((List)this.jdField_a_of_type_JavaUtilMap.get(localObject1)).add(localTroopMemberInfo);
              j += 1;
              break;
              localObject1 = localTroopMemberInfo.displayedNamePinyinFirst.substring(0, 1);
              break label274;
              label439:
              localObject1 = "#";
              break label312;
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.f != TroopAddFrdsInnerFrame.e) {
                break label312;
              }
              boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(localTroopMemberInfo.memberuin);
              if (bool2) {
                break label776;
              }
              bool1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(localTroopMemberInfo.memberuin);
              if (bool2) {}
              for (i = 3;; i = 2)
              {
                localTroopMemberInfo.addState = i;
                localObject1 = "" + localTroopMemberInfo.addState;
                break;
                if (!bool1) {
                  break label549;
                }
              }
              label549:
              i = 1;
            }
          }
          synchronized (this.jdField_b_of_type_JavaUtilList)
          {
            this.jdField_b_of_type_JavaUtilList.addAll(localArrayList);
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread end, id=" + Thread.currentThread().getId() + ", threadCnt=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", curTroopUin=" + this.jdField_a_of_type_JavaLangString);
            }
            if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndDecrement() > 1) {
              break label127;
            }
            ??? = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_b_of_type_AndroidOsHandler.obtainMessage(3);
            ((Message)???).arg1 = j;
            ((Message)???).obj = new Object[] { this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString };
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)???);
            if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
              break label127;
            }
            ??? = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
            ((Message)???).obj = this.jdField_b_of_type_JavaUtilList;
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)???);
            return;
          }
        }
      }
      catch (Exception localException) {}
      label776:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yih
 * JD-Core Version:    0.7.0.1
 */