import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

class ytg
  extends wjd
{
  ytg(ysw paramysw) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((ysw.a(this.a) == null) || (ysw.a(this.a).a == null))
    {
      yuk.e("NewMyStorySegment", "onPushMessage MyStory feed is null!");
      return;
    }
    String str = ysw.a(this.a).a.a;
    if (!TextUtils.equals(str, paramStoryPushMsg.d))
    {
      yuk.a("NewMyStorySegment", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, str);
      return;
    }
    switch (paramStoryPushMsg.a)
    {
    case 16: 
    case 17: 
    default: 
      return;
    }
    this.a.a(new yqf[] { new yqa(ypi.a(str)), (yqf)this.a.b.a(), new ypz(new yth(this, str)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytg
 * JD-Core Version:    0.7.0.1
 */