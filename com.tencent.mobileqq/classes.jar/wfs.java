import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

public class wfs
  extends uhn
{
  public String a;
  private wft a;
  
  public wfs(String paramString, @NonNull wft paramwft)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Wft = paramwft;
  }
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramStoryPushMsg.d))
    {
      wsv.a("DetailFeedPushObserver", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, this.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramStoryPushMsg.a == 15) || (paramStoryPushMsg.a == 19))
    {
      wsv.a("DetailFeedPushObserver", "Receive new comment PUSH: %s, refreshing comments......", paramStoryPushMsg);
      this.jdField_a_of_type_Wft.a(1);
      return;
    }
    if ((paramStoryPushMsg.a == 14) || (paramStoryPushMsg.a == 16) || (paramStoryPushMsg.a == 18))
    {
      wsv.a("DetailFeedPushObserver", "Receive new like PUSH: %s, refreshing likes......", paramStoryPushMsg);
      this.jdField_a_of_type_Wft.a(2);
      return;
    }
    this.jdField_a_of_type_Wft.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfs
 * JD-Core Version:    0.7.0.1
 */