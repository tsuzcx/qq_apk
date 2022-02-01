import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class yez
  extends wjm<StoryAtVideoFragment, yml>
{
  public yez(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull yml paramyml)
  {
    if ((paramyml.jdField_a_of_type_Int == 2) || (!paramyml.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramStoryAtVideoFragment.jdField_a_of_type_Yfw == null))
    {
      yuk.b(this.TAG, "ignore this video cookie change event. %s.", paramyml.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Yfw.c())
    {
      yuk.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramyml.toString() });
      return;
    }
    paramyml = paramStoryAtVideoFragment.jdField_a_of_type_Ymk.a(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, paramStoryAtVideoFragment.jdField_a_of_type_Yfw.a().mVideoPullType);
    if (paramyml == null)
    {
      yuk.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, Integer.valueOf(paramStoryAtVideoFragment.jdField_a_of_type_Yfw.a().mVideoPullType) });
      return;
    }
    yuk.a(this.TAG, "receive video cookie change event. %s.", paramyml.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Yfw.a().updateVideoInfo(paramyml);
    paramStoryAtVideoFragment.jdField_a_of_type_Yfw.a(paramyml.mVideoItemList, true);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Ygh != null) {
      paramStoryAtVideoFragment.jdField_a_of_type_Ygh.a(paramyml.mVideoPullType, paramyml.mVideoNextCookie, paramyml.mVideoSeq);
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Yfw);
  }
  
  public Class acceptEventClass()
  {
    return yml.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull yml paramyml) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yez
 * JD-Core Version:    0.7.0.1
 */