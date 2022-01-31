import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class wfv
  extends uhw<wfn, wkw>
{
  public wfv(wfn paramwfn)
  {
    super(paramwfn);
  }
  
  public void a(@NonNull wfn paramwfn, @NonNull wkw paramwkw)
  {
    if ((paramwkw.jdField_a_of_type_Int == 2) || (!paramwkw.jdField_a_of_type_JavaLangString.equals(wfn.a(paramwfn))) || (wfn.a(paramwfn) == null))
    {
      wsv.b(this.TAG, "ignore this video cookie change event. %s.", paramwkw.toString());
      return;
    }
    if (!wfn.a(paramwfn).c())
    {
      wsv.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { paramwkw.toString() });
      return;
    }
    paramwkw = wfn.a(paramwfn).a(wfn.a(paramwfn), wfn.a(paramwfn).a().mVideoPullType);
    if (paramwkw == null)
    {
      wsv.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { wfn.a(paramwfn), Integer.valueOf(wfn.a(paramwfn).a().mVideoPullType) });
      return;
    }
    wsv.a(this.TAG, "receive video cookie change event. %s.", paramwkw.toString());
    wfn.a(paramwfn).a().updateVideoInfo(paramwkw);
    wfn.a(paramwfn).a(paramwkw.mVideoItemList, true);
    if (wfn.a(paramwfn) != null) {
      wfn.a(paramwfn).a(paramwkw.mVideoPullType, paramwkw.mVideoNextCookie, paramwkw.mVideoSeq);
    }
    wfn.a(paramwfn).c();
  }
  
  public Class acceptEventClass()
  {
    return wkw.class;
  }
  
  public void b(@NonNull wfn paramwfn, @NonNull wkw paramwkw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfv
 * JD-Core Version:    0.7.0.1
 */