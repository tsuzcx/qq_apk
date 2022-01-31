import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

public class cfm
  implements Comparator
{
  public cfm(Conversation paramConversation) {}
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    if (((paramRecentBaseData1 instanceof RecentUserBaseData)) && ((paramRecentBaseData2 instanceof RecentUserBaseData)))
    {
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      int i;
      if (paramRecentBaseData1.jdField_a_of_type_ComTencentMobileqqDataRecentUser.showUpTime > 0L)
      {
        i = 1;
        if (paramRecentBaseData2.jdField_a_of_type_ComTencentMobileqqDataRecentUser.showUpTime <= 0L) {
          break label69;
        }
      }
      label69:
      for (int j = 1;; j = 0)
      {
        if ((i == 0) || (j != 0)) {
          break label75;
        }
        return -1;
        i = 0;
        break;
      }
      label75:
      if ((i == 0) && (j != 0)) {
        return 1;
      }
      long l2;
      long l1;
      if ((i == 0) && (j == 0))
      {
        l2 = Math.max(paramRecentBaseData1.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime, paramRecentBaseData1.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgdrafttime);
        l1 = Math.max(paramRecentBaseData2.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime, paramRecentBaseData2.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgdrafttime);
        if (l2 <= l1) {
          break label187;
        }
        l1 = 3L;
      }
      for (;;)
      {
        l1 = (int)(l1 | 0) - (int)(0 | 0x2);
        if (l1 != 0L) {
          break label209;
        }
        return 0;
        l2 = paramRecentBaseData1.jdField_a_of_type_Long;
        l1 = paramRecentBaseData2.jdField_a_of_type_Long;
        break;
        label187:
        if (l2 < l1) {
          l1 = 1L;
        } else {
          l1 = 2L;
        }
      }
      label209:
      if (l1 < 0L) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfm
 * JD-Core Version:    0.7.0.1
 */