import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

public class ueh
  extends sgc
{
  public String a;
  private uei a;
  
  public ueh(String paramString, @NonNull uei paramuei)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Uei = paramuei;
  }
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramStoryPushMsg.d))
    {
      urk.a("DetailFeedPushObserver", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, this.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramStoryPushMsg.a == 15) || (paramStoryPushMsg.a == 19))
    {
      urk.a("DetailFeedPushObserver", "Receive new comment PUSH: %s, refreshing comments......", paramStoryPushMsg);
      this.jdField_a_of_type_Uei.a(1);
      return;
    }
    if ((paramStoryPushMsg.a == 14) || (paramStoryPushMsg.a == 16) || (paramStoryPushMsg.a == 18))
    {
      urk.a("DetailFeedPushObserver", "Receive new like PUSH: %s, refreshing likes......", paramStoryPushMsg);
      this.jdField_a_of_type_Uei.a(2);
      return;
    }
    this.jdField_a_of_type_Uei.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ueh
 * JD-Core Version:    0.7.0.1
 */