import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

class ypl
  extends wfi
{
  ypl(ypb paramypb) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((ypb.a(this.a) == null) || (ypb.a(this.a).a == null))
    {
      yqp.e("NewMyStorySegment", "onPushMessage MyStory feed is null!");
      return;
    }
    String str = ypb.a(this.a).a.a;
    if (!TextUtils.equals(str, paramStoryPushMsg.d))
    {
      yqp.a("NewMyStorySegment", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, str);
      return;
    }
    switch (paramStoryPushMsg.a)
    {
    case 16: 
    case 17: 
    default: 
      return;
    }
    this.a.a(new ymk[] { new ymf(yln.a(str)), (ymk)this.a.b.a(), new yme(new ypm(this, str)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypl
 * JD-Core Version:    0.7.0.1
 */