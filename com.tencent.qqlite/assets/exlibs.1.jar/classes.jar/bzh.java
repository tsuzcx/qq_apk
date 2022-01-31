import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;

public class bzh
  extends DiscussionObserver
{
  public bzh(DiscussChatPie paramDiscussChatPie) {}
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    if ((DiscussChatPie.a(this.a).jdField_a_of_type_JavaLangString.equals(str)) && (paramBoolean))
    {
      if (bool) {
        this.a.d(false);
      }
      if (DiscussChatPie.b(this.a).jdField_a_of_type_Int == 3000)
      {
        paramArrayOfObject = ((FriendsManagerImp)DiscussChatPie.a(this.a).getManager(8)).a(str);
        if ((paramArrayOfObject != null) && (paramArrayOfObject.discussionName != null))
        {
          DiscussChatPie.c(this.a).d = paramArrayOfObject.discussionName;
          this.a.a(DiscussChatPie.d(this.a).d, paramArrayOfObject.uin, DiscussChatPie.a(this.a));
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((DiscussChatPie.e(this.a).jdField_a_of_type_JavaLangString.equals(paramString)) && (DiscussChatPie.f(this.a).jdField_a_of_type_Int == 3000))
    {
      paramString = ((FriendsManagerImp)DiscussChatPie.b(this.a).getManager(8)).a(paramString);
      if ((paramString != null) && (paramString.discussionName != null))
      {
        DiscussChatPie.g(this.a).d = paramString.discussionName;
        this.a.a(DiscussChatPie.h(this.a).d, paramString.uin, DiscussChatPie.b(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzh
 * JD-Core Version:    0.7.0.1
 */