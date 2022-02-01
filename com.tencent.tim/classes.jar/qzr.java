import android.text.TextUtils;
import com.tencent.biz.qqstory.notification.StoryPushMsg;

class qzr
  extends pmd
{
  qzr(qzh paramqzh) {}
  
  public void b(StoryPushMsg paramStoryPushMsg)
  {
    if ((qzh.a(this.this$0) == null) || (qzh.a(this.this$0).a == null))
    {
      ram.e("NewMyStorySegment", "onPushMessage MyStory feed is null!");
      return;
    }
    String str = qzh.a(this.this$0).a.feedId;
    if (!TextUtils.equals(str, paramStoryPushMsg.mFeedId))
    {
      ram.b("NewMyStorySegment", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.mFeedId, str);
      return;
    }
    switch (paramStoryPushMsg.type)
    {
    case 16: 
    case 17: 
    default: 
      return;
    }
    this.this$0.a(new qxo[] { new qxm.b(qxd.a.a(str)), (qxo)this.this$0.b.call(), new qxm.a(new qzs(this, str)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzr
 * JD-Core Version:    0.7.0.1
 */