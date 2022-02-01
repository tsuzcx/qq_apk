import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

public class yhh
  extends wjd
{
  public String a;
  private yhi a;
  
  public yhh(String paramString, @NonNull yhi paramyhi)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Yhi = paramyhi;
  }
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramStoryPushMsg.d))
    {
      yuk.a("DetailFeedPushObserver", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, this.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramStoryPushMsg.a == 15) || (paramStoryPushMsg.a == 19))
    {
      yuk.a("DetailFeedPushObserver", "Receive new comment PUSH: %s, refreshing comments......", paramStoryPushMsg);
      this.jdField_a_of_type_Yhi.a(1);
      return;
    }
    if ((paramStoryPushMsg.a == 14) || (paramStoryPushMsg.a == 16) || (paramStoryPushMsg.a == 18))
    {
      yuk.a("DetailFeedPushObserver", "Receive new like PUSH: %s, refreshing likes......", paramStoryPushMsg);
      this.jdField_a_of_type_Yhi.a(2);
      return;
    }
    this.jdField_a_of_type_Yhi.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhh
 * JD-Core Version:    0.7.0.1
 */