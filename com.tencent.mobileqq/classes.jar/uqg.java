import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

class uqg
  extends sgc
{
  uqg(upw paramupw) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((upw.a(this.a) == null) || (upw.a(this.a).a == null))
    {
      urk.e("NewMyStorySegment", "onPushMessage MyStory feed is null!");
      return;
    }
    String str = upw.a(this.a).a.a;
    if (!TextUtils.equals(str, paramStoryPushMsg.d))
    {
      urk.a("NewMyStorySegment", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, str);
      return;
    }
    switch (paramStoryPushMsg.a)
    {
    case 16: 
    case 17: 
    default: 
      return;
    }
    this.a.a(new unf[] { new una(umi.a(str)), (unf)this.a.b.a(), new umz(new uqh(this, str)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqg
 * JD-Core Version:    0.7.0.1
 */