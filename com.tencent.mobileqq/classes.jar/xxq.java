import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class xxq
  extends wag<xxi, ycr>
{
  public xxq(xxi paramxxi)
  {
    super(paramxxi);
  }
  
  public void a(@NonNull xxi paramxxi, @NonNull ycr paramycr)
  {
    if ((paramycr.jdField_a_of_type_Int == 2) || (!paramycr.jdField_a_of_type_JavaLangString.equals(xxi.a(paramxxi))) || (xxi.a(paramxxi) == null))
    {
      ykq.b(this.TAG, "ignore this video cookie change event. %s.", paramycr.toString());
      return;
    }
    if (!xxi.a(paramxxi).c())
    {
      ykq.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { paramycr.toString() });
      return;
    }
    paramycr = xxi.a(paramxxi).a(xxi.a(paramxxi), xxi.a(paramxxi).a().mVideoPullType);
    if (paramycr == null)
    {
      ykq.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { xxi.a(paramxxi), Integer.valueOf(xxi.a(paramxxi).a().mVideoPullType) });
      return;
    }
    ykq.a(this.TAG, "receive video cookie change event. %s.", paramycr.toString());
    xxi.a(paramxxi).a().updateVideoInfo(paramycr);
    xxi.a(paramxxi).a(paramycr.mVideoItemList, true);
    if (xxi.a(paramxxi) != null) {
      xxi.a(paramxxi).a(paramycr.mVideoPullType, paramycr.mVideoNextCookie, paramycr.mVideoSeq);
    }
    xxi.a(paramxxi).c();
  }
  
  public Class acceptEventClass()
  {
    return ycr.class;
  }
  
  public void b(@NonNull xxi paramxxi, @NonNull ycr paramycr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxq
 * JD-Core Version:    0.7.0.1
 */