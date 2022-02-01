import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class ybe
  extends wfr<StoryAtVideoFragment, yiq>
{
  public ybe(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull yiq paramyiq)
  {
    if ((paramyiq.jdField_a_of_type_Int == 2) || (!paramyiq.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramStoryAtVideoFragment.jdField_a_of_type_Ycb == null))
    {
      yqp.b(this.TAG, "ignore this video cookie change event. %s.", paramyiq.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Ycb.c())
    {
      yqp.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramyiq.toString() });
      return;
    }
    paramyiq = paramStoryAtVideoFragment.jdField_a_of_type_Yip.a(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, paramStoryAtVideoFragment.jdField_a_of_type_Ycb.a().mVideoPullType);
    if (paramyiq == null)
    {
      yqp.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, Integer.valueOf(paramStoryAtVideoFragment.jdField_a_of_type_Ycb.a().mVideoPullType) });
      return;
    }
    yqp.a(this.TAG, "receive video cookie change event. %s.", paramyiq.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Ycb.a().updateVideoInfo(paramyiq);
    paramStoryAtVideoFragment.jdField_a_of_type_Ycb.a(paramyiq.mVideoItemList, true);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Ycm != null) {
      paramStoryAtVideoFragment.jdField_a_of_type_Ycm.a(paramyiq.mVideoPullType, paramyiq.mVideoNextCookie, paramyiq.mVideoSeq);
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Ycb);
  }
  
  public Class acceptEventClass()
  {
    return yiq.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull yiq paramyiq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybe
 * JD-Core Version:    0.7.0.1
 */