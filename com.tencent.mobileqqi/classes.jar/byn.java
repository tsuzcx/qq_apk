import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

public class byn
  extends ShieldListObserver
{
  public byn(ChatActivity paramChatActivity) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    
    if (this.a.a == null) {
      return;
    }
    String str = this.a.a.jdField_a_of_type_JavaLangString;
    if (this.a.a.jdField_a_of_type_Int == 1006) {
      str = this.a.a.f;
    }
    for (;;)
    {
      if (paramList == null) {}
      int k;
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
      if (k == 0) {
        break;
      }
      ChatActivityUtils.a(this.a, paramBoolean, false);
      if (!paramBoolean) {
        break;
      }
      ChatActivity.e(this.a);
      return;
    }
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    int k = 0;
    ChatActivityUtils.a();
    if (this.a.a == null) {
      return;
    }
    String str = this.a.a.jdField_a_of_type_JavaLangString;
    if (this.a.a.jdField_a_of_type_Int == 1006) {
      str = this.a.a.f;
    }
    for (;;)
    {
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
      if (k == 0) {
        break;
      }
      ChatActivityUtils.a();
      if (!paramBoolean) {
        break;
      }
      ChatActivity.e(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byn
 * JD-Core Version:    0.7.0.1
 */