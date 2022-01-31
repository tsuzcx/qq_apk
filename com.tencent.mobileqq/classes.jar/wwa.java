import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

class wwa
  extends ulw
{
  wwa(wvq paramwvq) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((wvq.a(this.a) == null) || (wvq.a(this.a).a == null))
    {
      wxe.e("NewMyStorySegment", "onPushMessage MyStory feed is null!");
      return;
    }
    String str = wvq.a(this.a).a.a;
    if (!TextUtils.equals(str, paramStoryPushMsg.d))
    {
      wxe.a("NewMyStorySegment", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, str);
      return;
    }
    switch (paramStoryPushMsg.a)
    {
    case 16: 
    case 17: 
    default: 
      return;
    }
    this.a.a(new wsz[] { new wsu(wsc.a(str)), (wsz)this.a.b.a(), new wst(new wwb(this, str)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwa
 * JD-Core Version:    0.7.0.1
 */