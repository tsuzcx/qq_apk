import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

public class vop
  extends ShieldListObserver
{
  public vop(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {}
    do
    {
      int k;
      do
      {
        return;
        String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        if (paramList == null) {}
        for (int i = 0;; i = paramList.size())
        {
          int j = 0;
          k = 0;
          while ((k == 0) && (j < i))
          {
            if (Utils.a(String.valueOf(paramList.get(j)), str)) {
              k = 1;
            }
            j += 1;
          }
        }
      } while (k == 0);
      ChatActivityUtils.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramBoolean, false);
    } while (!paramBoolean);
    this.a.aX();
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    int k = 0;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {}
    do
    {
      do
      {
        return;
        String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        if (paramList == null) {}
        for (int i = 0;; i = paramList.size())
        {
          int j = 0;
          while ((k == 0) && (j < i))
          {
            if (Utils.a(String.valueOf(paramList.get(j)), str)) {
              k = 1;
            }
            j += 1;
          }
        }
      } while (k == 0);
      ChatActivityUtils.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramBoolean, true);
    } while (!paramBoolean);
    this.a.aX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vop
 * JD-Core Version:    0.7.0.1
 */