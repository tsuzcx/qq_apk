import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

public class ura
  extends ssv
{
  public String a;
  private urb a;
  
  public ura(String paramString, @NonNull urb paramurb)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Urb = paramurb;
  }
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramStoryPushMsg.d))
    {
      ved.a("DetailFeedPushObserver", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, this.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramStoryPushMsg.a == 15) || (paramStoryPushMsg.a == 19))
    {
      ved.a("DetailFeedPushObserver", "Receive new comment PUSH: %s, refreshing comments......", paramStoryPushMsg);
      this.jdField_a_of_type_Urb.a(1);
      return;
    }
    if ((paramStoryPushMsg.a == 14) || (paramStoryPushMsg.a == 16) || (paramStoryPushMsg.a == 18))
    {
      ved.a("DetailFeedPushObserver", "Receive new like PUSH: %s, refreshing likes......", paramStoryPushMsg);
      this.jdField_a_of_type_Urb.a(2);
      return;
    }
    this.jdField_a_of_type_Urb.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ura
 * JD-Core Version:    0.7.0.1
 */