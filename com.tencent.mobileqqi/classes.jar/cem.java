import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;

public class cem
  extends DiscussionObserver
{
  public cem(ChatActivity paramChatActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.a.jdField_a_of_type_JavaLangString.equals(paramString)) && (this.a.a.jdField_a_of_type_Int == 3000))
    {
      paramString = ((FriendsManagerImp)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString);
      if ((paramString != null) && (paramString.discussionName != null))
      {
        this.a.a.d = paramString.discussionName;
        ChatActivity.a(this.a, this.a.a.d, paramString.uin, this.a.jdField_b_of_type_AndroidWidgetTextView);
      }
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    if ((this.a.a.jdField_a_of_type_JavaLangString.equals(str)) && (paramBoolean))
    {
      if (bool) {
        this.a.b(false);
      }
      if (this.a.a.jdField_a_of_type_Int == 3000)
      {
        paramArrayOfObject = ((FriendsManagerImp)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(str);
        if ((paramArrayOfObject != null) && (paramArrayOfObject.discussionName != null))
        {
          this.a.a.d = paramArrayOfObject.discussionName;
          ChatActivity.a(this.a, this.a.a.d, paramArrayOfObject.uin, this.a.jdField_b_of_type_AndroidWidgetTextView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cem
 * JD-Core Version:    0.7.0.1
 */