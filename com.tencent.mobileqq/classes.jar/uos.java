import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class uos
  extends ste<StoryAtVideoFragment, uwe>
{
  public uos(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull uwe paramuwe)
  {
    if ((paramuwe.jdField_a_of_type_Int == 2) || (!paramuwe.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramStoryAtVideoFragment.jdField_a_of_type_Upp == null))
    {
      ved.b(this.TAG, "ignore this video cookie change event. %s.", paramuwe.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Upp.c())
    {
      ved.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramuwe.toString() });
      return;
    }
    paramuwe = paramStoryAtVideoFragment.jdField_a_of_type_Uwd.a(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, paramStoryAtVideoFragment.jdField_a_of_type_Upp.a().mVideoPullType);
    if (paramuwe == null)
    {
      ved.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, Integer.valueOf(paramStoryAtVideoFragment.jdField_a_of_type_Upp.a().mVideoPullType) });
      return;
    }
    ved.a(this.TAG, "receive video cookie change event. %s.", paramuwe.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Upp.a().updateVideoInfo(paramuwe);
    paramStoryAtVideoFragment.jdField_a_of_type_Upp.a(paramuwe.mVideoItemList, true);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Uqa != null) {
      paramStoryAtVideoFragment.jdField_a_of_type_Uqa.a(paramuwe.mVideoPullType, paramuwe.mVideoNextCookie, paramuwe.mVideoSeq);
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Upp);
  }
  
  public Class acceptEventClass()
  {
    return uwe.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull uwe paramuwe) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uos
 * JD-Core Version:    0.7.0.1
 */