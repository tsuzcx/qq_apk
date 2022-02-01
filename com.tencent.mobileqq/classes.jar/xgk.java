import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class xgk
  extends vll<StoryAtVideoFragment, xnw>
{
  public xgk(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull xnw paramxnw)
  {
    if ((paramxnw.jdField_a_of_type_Int == 2) || (!paramxnw.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramStoryAtVideoFragment.jdField_a_of_type_Xhh == null))
    {
      xvv.b(this.TAG, "ignore this video cookie change event. %s.", paramxnw.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Xhh.c())
    {
      xvv.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramxnw.toString() });
      return;
    }
    paramxnw = paramStoryAtVideoFragment.jdField_a_of_type_Xnv.a(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, paramStoryAtVideoFragment.jdField_a_of_type_Xhh.a().mVideoPullType);
    if (paramxnw == null)
    {
      xvv.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, Integer.valueOf(paramStoryAtVideoFragment.jdField_a_of_type_Xhh.a().mVideoPullType) });
      return;
    }
    xvv.a(this.TAG, "receive video cookie change event. %s.", paramxnw.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Xhh.a().updateVideoInfo(paramxnw);
    paramStoryAtVideoFragment.jdField_a_of_type_Xhh.a(paramxnw.mVideoItemList, true);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Xhs != null) {
      paramStoryAtVideoFragment.jdField_a_of_type_Xhs.a(paramxnw.mVideoPullType, paramxnw.mVideoNextCookie, paramxnw.mVideoSeq);
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Xhh);
  }
  
  public Class acceptEventClass()
  {
    return xnw.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull xnw paramxnw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgk
 * JD-Core Version:    0.7.0.1
 */