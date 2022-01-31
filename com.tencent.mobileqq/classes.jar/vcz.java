import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

class vcz
  extends ssv
{
  vcz(vcp paramvcp) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((vcp.a(this.a) == null) || (vcp.a(this.a).a == null))
    {
      ved.e("NewMyStorySegment", "onPushMessage MyStory feed is null!");
      return;
    }
    String str = vcp.a(this.a).a.a;
    if (!TextUtils.equals(str, paramStoryPushMsg.d))
    {
      ved.a("NewMyStorySegment", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, str);
      return;
    }
    switch (paramStoryPushMsg.a)
    {
    case 16: 
    case 17: 
    default: 
      return;
    }
    this.a.a(new uzy[] { new uzt(uzb.a(str)), (uzy)this.a.b.a(), new uzs(new vda(this, str)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcz
 * JD-Core Version:    0.7.0.1
 */