import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

class wrr
  extends uhn
{
  wrr(wrh paramwrh) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((wrh.a(this.a) == null) || (wrh.a(this.a).a == null))
    {
      wsv.e("NewMyStorySegment", "onPushMessage MyStory feed is null!");
      return;
    }
    String str = wrh.a(this.a).a.a;
    if (!TextUtils.equals(str, paramStoryPushMsg.d))
    {
      wsv.a("NewMyStorySegment", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, str);
      return;
    }
    switch (paramStoryPushMsg.a)
    {
    case 16: 
    case 17: 
    default: 
      return;
    }
    this.a.a(new woq[] { new wol(wnt.a(str)), (woq)this.a.b.a(), new wok(new wrs(this, str)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrr
 * JD-Core Version:    0.7.0.1
 */