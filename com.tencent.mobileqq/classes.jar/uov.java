import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class uov
  extends sth<StoryAtVideoFragment, uwh>
{
  public uov(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull uwh paramuwh)
  {
    if ((paramuwh.jdField_a_of_type_Int == 2) || (!paramuwh.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramStoryAtVideoFragment.jdField_a_of_type_Ups == null))
    {
      veg.b(this.TAG, "ignore this video cookie change event. %s.", paramuwh.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Ups.c())
    {
      veg.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramuwh.toString() });
      return;
    }
    paramuwh = paramStoryAtVideoFragment.jdField_a_of_type_Uwg.a(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, paramStoryAtVideoFragment.jdField_a_of_type_Ups.a().mVideoPullType);
    if (paramuwh == null)
    {
      veg.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, Integer.valueOf(paramStoryAtVideoFragment.jdField_a_of_type_Ups.a().mVideoPullType) });
      return;
    }
    veg.a(this.TAG, "receive video cookie change event. %s.", paramuwh.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Ups.a().updateVideoInfo(paramuwh);
    paramStoryAtVideoFragment.jdField_a_of_type_Ups.a(paramuwh.mVideoItemList, true);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Uqd != null) {
      paramStoryAtVideoFragment.jdField_a_of_type_Uqd.a(paramuwh.mVideoPullType, paramuwh.mVideoNextCookie, paramuwh.mVideoSeq);
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Ups);
  }
  
  public Class acceptEventClass()
  {
    return uwh.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull uwh paramuwh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uov
 * JD-Core Version:    0.7.0.1
 */