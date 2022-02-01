import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class xiv
  extends vll<xin, xnw>
{
  public xiv(xin paramxin)
  {
    super(paramxin);
  }
  
  public void a(@NonNull xin paramxin, @NonNull xnw paramxnw)
  {
    if ((paramxnw.jdField_a_of_type_Int == 2) || (!paramxnw.jdField_a_of_type_JavaLangString.equals(xin.a(paramxin))) || (xin.a(paramxin) == null))
    {
      xvv.b(this.TAG, "ignore this video cookie change event. %s.", paramxnw.toString());
      return;
    }
    if (!xin.a(paramxin).c())
    {
      xvv.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { paramxnw.toString() });
      return;
    }
    paramxnw = xin.a(paramxin).a(xin.a(paramxin), xin.a(paramxin).a().mVideoPullType);
    if (paramxnw == null)
    {
      xvv.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { xin.a(paramxin), Integer.valueOf(xin.a(paramxin).a().mVideoPullType) });
      return;
    }
    xvv.a(this.TAG, "receive video cookie change event. %s.", paramxnw.toString());
    xin.a(paramxin).a().updateVideoInfo(paramxnw);
    xin.a(paramxin).a(paramxnw.mVideoItemList, true);
    if (xin.a(paramxin) != null) {
      xin.a(paramxin).a(paramxnw.mVideoPullType, paramxnw.mVideoNextCookie, paramxnw.mVideoSeq);
    }
    xin.a(paramxin).c();
  }
  
  public Class acceptEventClass()
  {
    return xnw.class;
  }
  
  public void b(@NonNull xin paramxin, @NonNull xnw paramxnw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xiv
 * JD-Core Version:    0.7.0.1
 */