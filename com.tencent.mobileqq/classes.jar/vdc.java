import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

class vdc
  extends ssy
{
  vdc(vcs paramvcs) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((vcs.a(this.a) == null) || (vcs.a(this.a).a == null))
    {
      veg.e("NewMyStorySegment", "onPushMessage MyStory feed is null!");
      return;
    }
    String str = vcs.a(this.a).a.a;
    if (!TextUtils.equals(str, paramStoryPushMsg.d))
    {
      veg.a("NewMyStorySegment", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, str);
      return;
    }
    switch (paramStoryPushMsg.a)
    {
    case 16: 
    case 17: 
    default: 
      return;
    }
    this.a.a(new vab[] { new uzw(uze.a(str)), (vab)this.a.b.a(), new uzv(new vdd(this, str)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdc
 * JD-Core Version:    0.7.0.1
 */