import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

class yjm
  extends vzx
{
  yjm(yjc paramyjc) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((yjc.a(this.a) == null) || (yjc.a(this.a).a == null))
    {
      ykq.e("NewMyStorySegment", "onPushMessage MyStory feed is null!");
      return;
    }
    String str = yjc.a(this.a).a.a;
    if (!TextUtils.equals(str, paramStoryPushMsg.d))
    {
      ykq.a("NewMyStorySegment", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, str);
      return;
    }
    switch (paramStoryPushMsg.a)
    {
    case 16: 
    case 17: 
    default: 
      return;
    }
    this.a.a(new ygl[] { new ygg(yfo.a(str)), (ygl)this.a.b.a(), new ygf(new yjn(this, str)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjm
 * JD-Core Version:    0.7.0.1
 */