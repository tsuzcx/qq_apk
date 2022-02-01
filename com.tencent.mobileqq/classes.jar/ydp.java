import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class ydp
  extends wfr<ydh, yiq>
{
  public ydp(ydh paramydh)
  {
    super(paramydh);
  }
  
  public void a(@NonNull ydh paramydh, @NonNull yiq paramyiq)
  {
    if ((paramyiq.jdField_a_of_type_Int == 2) || (!paramyiq.jdField_a_of_type_JavaLangString.equals(ydh.a(paramydh))) || (ydh.a(paramydh) == null))
    {
      yqp.b(this.TAG, "ignore this video cookie change event. %s.", paramyiq.toString());
      return;
    }
    if (!ydh.a(paramydh).c())
    {
      yqp.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { paramyiq.toString() });
      return;
    }
    paramyiq = ydh.a(paramydh).a(ydh.a(paramydh), ydh.a(paramydh).a().mVideoPullType);
    if (paramyiq == null)
    {
      yqp.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { ydh.a(paramydh), Integer.valueOf(ydh.a(paramydh).a().mVideoPullType) });
      return;
    }
    yqp.a(this.TAG, "receive video cookie change event. %s.", paramyiq.toString());
    ydh.a(paramydh).a().updateVideoInfo(paramyiq);
    ydh.a(paramydh).a(paramyiq.mVideoItemList, true);
    if (ydh.a(paramydh) != null) {
      ydh.a(paramydh).a(paramyiq.mVideoPullType, paramyiq.mVideoNextCookie, paramyiq.mVideoSeq);
    }
    ydh.a(paramydh).c();
  }
  
  public Class acceptEventClass()
  {
    return yiq.class;
  }
  
  public void b(@NonNull ydh paramydh, @NonNull yiq paramyiq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydp
 * JD-Core Version:    0.7.0.1
 */