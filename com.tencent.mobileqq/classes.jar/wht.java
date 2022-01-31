import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class wht
  extends umf<StoryAtVideoFragment, wpf>
{
  public wht(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull wpf paramwpf)
  {
    if ((paramwpf.jdField_a_of_type_Int == 2) || (!paramwpf.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramStoryAtVideoFragment.jdField_a_of_type_Wiq == null))
    {
      wxe.b(this.TAG, "ignore this video cookie change event. %s.", paramwpf.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Wiq.c())
    {
      wxe.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramwpf.toString() });
      return;
    }
    paramwpf = paramStoryAtVideoFragment.jdField_a_of_type_Wpe.a(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, paramStoryAtVideoFragment.jdField_a_of_type_Wiq.a().mVideoPullType);
    if (paramwpf == null)
    {
      wxe.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, Integer.valueOf(paramStoryAtVideoFragment.jdField_a_of_type_Wiq.a().mVideoPullType) });
      return;
    }
    wxe.a(this.TAG, "receive video cookie change event. %s.", paramwpf.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Wiq.a().updateVideoInfo(paramwpf);
    paramStoryAtVideoFragment.jdField_a_of_type_Wiq.a(paramwpf.mVideoItemList, true);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Wjb != null) {
      paramStoryAtVideoFragment.jdField_a_of_type_Wjb.a(paramwpf.mVideoPullType, paramwpf.mVideoNextCookie, paramwpf.mVideoSeq);
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Wiq);
  }
  
  public Class acceptEventClass()
  {
    return wpf.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull wpf paramwpf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wht
 * JD-Core Version:    0.7.0.1
 */