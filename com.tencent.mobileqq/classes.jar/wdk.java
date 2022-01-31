import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class wdk
  extends uhw<StoryAtVideoFragment, wkw>
{
  public wdk(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull wkw paramwkw)
  {
    if ((paramwkw.jdField_a_of_type_Int == 2) || (!paramwkw.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramStoryAtVideoFragment.jdField_a_of_type_Weh == null))
    {
      wsv.b(this.TAG, "ignore this video cookie change event. %s.", paramwkw.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Weh.c())
    {
      wsv.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramwkw.toString() });
      return;
    }
    paramwkw = paramStoryAtVideoFragment.jdField_a_of_type_Wkv.a(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, paramStoryAtVideoFragment.jdField_a_of_type_Weh.a().mVideoPullType);
    if (paramwkw == null)
    {
      wsv.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, Integer.valueOf(paramStoryAtVideoFragment.jdField_a_of_type_Weh.a().mVideoPullType) });
      return;
    }
    wsv.a(this.TAG, "receive video cookie change event. %s.", paramwkw.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Weh.a().updateVideoInfo(paramwkw);
    paramStoryAtVideoFragment.jdField_a_of_type_Weh.a(paramwkw.mVideoItemList, true);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Wes != null) {
      paramStoryAtVideoFragment.jdField_a_of_type_Wes.a(paramwkw.mVideoPullType, paramwkw.mVideoNextCookie, paramwkw.mVideoSeq);
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Weh);
  }
  
  public Class acceptEventClass()
  {
    return wkw.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull wkw paramwkw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdk
 * JD-Core Version:    0.7.0.1
 */