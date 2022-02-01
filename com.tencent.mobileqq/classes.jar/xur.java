import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

class xur
  extends vlc
{
  xur(xuh paramxuh) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((xuh.a(this.a) == null) || (xuh.a(this.a).a == null))
    {
      xvv.e("NewMyStorySegment", "onPushMessage MyStory feed is null!");
      return;
    }
    String str = xuh.a(this.a).a.a;
    if (!TextUtils.equals(str, paramStoryPushMsg.d))
    {
      xvv.a("NewMyStorySegment", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, str);
      return;
    }
    switch (paramStoryPushMsg.a)
    {
    case 16: 
    case 17: 
    default: 
      return;
    }
    this.a.a(new xrq[] { new xrl(xqt.a(str)), (xrq)this.a.b.a(), new xrk(new xus(this, str)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xur
 * JD-Core Version:    0.7.0.1
 */