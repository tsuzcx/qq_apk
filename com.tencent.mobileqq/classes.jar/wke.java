import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class wke
  extends umf<wjw, wpf>
{
  public wke(wjw paramwjw)
  {
    super(paramwjw);
  }
  
  public void a(@NonNull wjw paramwjw, @NonNull wpf paramwpf)
  {
    if ((paramwpf.jdField_a_of_type_Int == 2) || (!paramwpf.jdField_a_of_type_JavaLangString.equals(wjw.a(paramwjw))) || (wjw.a(paramwjw) == null))
    {
      wxe.b(this.TAG, "ignore this video cookie change event. %s.", paramwpf.toString());
      return;
    }
    if (!wjw.a(paramwjw).c())
    {
      wxe.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { paramwpf.toString() });
      return;
    }
    paramwpf = wjw.a(paramwjw).a(wjw.a(paramwjw), wjw.a(paramwjw).a().mVideoPullType);
    if (paramwpf == null)
    {
      wxe.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { wjw.a(paramwjw), Integer.valueOf(wjw.a(paramwjw).a().mVideoPullType) });
      return;
    }
    wxe.a(this.TAG, "receive video cookie change event. %s.", paramwpf.toString());
    wjw.a(paramwjw).a().updateVideoInfo(paramwpf);
    wjw.a(paramwjw).a(paramwpf.mVideoItemList, true);
    if (wjw.a(paramwjw) != null) {
      wjw.a(paramwjw).a(paramwpf.mVideoPullType, paramwpf.mVideoNextCookie, paramwpf.mVideoSeq);
    }
    wjw.a(paramwjw).c();
  }
  
  public Class acceptEventClass()
  {
    return wpf.class;
  }
  
  public void b(@NonNull wjw paramwjw, @NonNull wpf paramwpf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wke
 * JD-Core Version:    0.7.0.1
 */