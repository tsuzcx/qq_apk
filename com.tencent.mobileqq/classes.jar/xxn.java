import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

public class xxn
  extends vzx
{
  public String a;
  private xxo a;
  
  public xxn(String paramString, @NonNull xxo paramxxo)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Xxo = paramxxo;
  }
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramStoryPushMsg.d))
    {
      ykq.a("DetailFeedPushObserver", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, this.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramStoryPushMsg.a == 15) || (paramStoryPushMsg.a == 19))
    {
      ykq.a("DetailFeedPushObserver", "Receive new comment PUSH: %s, refreshing comments......", paramStoryPushMsg);
      this.jdField_a_of_type_Xxo.a(1);
      return;
    }
    if ((paramStoryPushMsg.a == 14) || (paramStoryPushMsg.a == 16) || (paramStoryPushMsg.a == 18))
    {
      ykq.a("DetailFeedPushObserver", "Receive new like PUSH: %s, refreshing likes......", paramStoryPushMsg);
      this.jdField_a_of_type_Xxo.a(2);
      return;
    }
    this.jdField_a_of_type_Xxo.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxn
 * JD-Core Version:    0.7.0.1
 */