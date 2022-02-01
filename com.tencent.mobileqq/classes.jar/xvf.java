import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class xvf
  extends wag<StoryAtVideoFragment, ycr>
{
  public xvf(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull ycr paramycr)
  {
    if ((paramycr.jdField_a_of_type_Int == 2) || (!paramycr.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramStoryAtVideoFragment.jdField_a_of_type_Xwc == null))
    {
      ykq.b(this.TAG, "ignore this video cookie change event. %s.", paramycr.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Xwc.c())
    {
      ykq.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramycr.toString() });
      return;
    }
    paramycr = paramStoryAtVideoFragment.jdField_a_of_type_Ycq.a(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, paramStoryAtVideoFragment.jdField_a_of_type_Xwc.a().mVideoPullType);
    if (paramycr == null)
    {
      ykq.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, Integer.valueOf(paramStoryAtVideoFragment.jdField_a_of_type_Xwc.a().mVideoPullType) });
      return;
    }
    ykq.a(this.TAG, "receive video cookie change event. %s.", paramycr.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Xwc.a().updateVideoInfo(paramycr);
    paramStoryAtVideoFragment.jdField_a_of_type_Xwc.a(paramycr.mVideoItemList, true);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Xwn != null) {
      paramStoryAtVideoFragment.jdField_a_of_type_Xwn.a(paramycr.mVideoPullType, paramycr.mVideoNextCookie, paramycr.mVideoSeq);
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Xwc);
  }
  
  public Class acceptEventClass()
  {
    return ycr.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull ycr paramycr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvf
 * JD-Core Version:    0.7.0.1
 */