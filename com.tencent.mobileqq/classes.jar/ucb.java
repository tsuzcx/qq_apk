import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.qphone.base.util.QLog;

public class ucb
  extends ufi
  implements ulo
{
  public ucb(Context paramContext, Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramContext, paramActivity, paramInt1, paramInt2);
    super.a(this);
  }
  
  public static void a(Activity paramActivity, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem)
  {
    StringBuilder localStringBuilder1 = null;
    StringBuilder localStringBuilder2;
    if ((paramVideoListFeedItem != null) && (paramStoryVideoItem != null))
    {
      localStringBuilder2 = new StringBuilder();
      if (paramStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L)
      {
        localStringBuilder2.append(vms.a(paramStoryVideoItem.mCreateTime, paramStoryVideoItem.mTimeZoneOffsetMillis));
        paramStoryVideoItem = localStringBuilder2;
        paramVideoListFeedItem = localStringBuilder1;
        if (localStringBuilder2.length() > 0)
        {
          paramVideoListFeedItem = new Intent();
          paramVideoListFeedItem.putExtra("at_video_text", localStringBuilder2.toString());
          paramStoryVideoItem = localStringBuilder2;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder().append("set result ok. At video text is:");
        if (paramStoryVideoItem != null) {
          break label146;
        }
      }
      label146:
      for (paramStoryVideoItem = "";; paramStoryVideoItem = paramStoryVideoItem.toString())
      {
        QLog.d("Q.qqstory.detail.FeedItemThumbAdapter", 2, paramStoryVideoItem);
        paramActivity.setResult(-1, paramVideoListFeedItem);
        return;
        localStringBuilder2.append(vms.b(paramStoryVideoItem.mCreateTime));
        break;
      }
      paramStoryVideoItem = null;
      paramVideoListFeedItem = localStringBuilder1;
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (vms.b()) {
      return;
    }
    a(this.a, paramVideoListFeedItem, paramStoryVideoItem);
    urp.a("home_page", "choose_video", 0, 0, new String[0]);
    this.a.finish();
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucb
 * JD-Core Version:    0.7.0.1
 */