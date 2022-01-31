import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

public class bzr
  extends ShieldListObserver
{
  public bzr(StrangerChatPie paramStrangerChatPie) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    
    if (StrangerChatPie.a(this.a) == null) {
      return;
    }
    String str = StrangerChatPie.b(this.a).jdField_a_of_type_JavaLangString;
    if (StrangerChatPie.c(this.a).jdField_a_of_type_Int == 1006) {
      str = StrangerChatPie.d(this.a).f;
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
      ChatActivityUtils.a(StrangerChatPie.a(this.a), paramBoolean, false);
      if (!paramBoolean) {
        break;
      }
      this.a.h();
      return;
    }
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    int k = 0;
    ChatActivityUtils.a();
    if (StrangerChatPie.e(this.a) == null) {
      return;
    }
    String str = StrangerChatPie.f(this.a).jdField_a_of_type_JavaLangString;
    if (StrangerChatPie.g(this.a).jdField_a_of_type_Int == 1006) {
      str = StrangerChatPie.h(this.a).f;
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
      this.a.h();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzr
 * JD-Core Version:    0.7.0.1
 */