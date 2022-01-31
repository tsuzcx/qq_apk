import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class ubz
  extends sgl<StoryAtVideoFragment, ujl>
{
  public ubz(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull ujl paramujl)
  {
    if ((paramujl.jdField_a_of_type_Int == 2) || (!paramujl.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramStoryAtVideoFragment.jdField_a_of_type_Ucw == null))
    {
      urk.b(this.TAG, "ignore this video cookie change event. %s.", paramujl.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Ucw.c())
    {
      urk.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramujl.toString() });
      return;
    }
    paramujl = paramStoryAtVideoFragment.jdField_a_of_type_Ujk.a(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, paramStoryAtVideoFragment.jdField_a_of_type_Ucw.a().mVideoPullType);
    if (paramujl == null)
    {
      urk.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString, Integer.valueOf(paramStoryAtVideoFragment.jdField_a_of_type_Ucw.a().mVideoPullType) });
      return;
    }
    urk.a(this.TAG, "receive video cookie change event. %s.", paramujl.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Ucw.a().updateVideoInfo(paramujl);
    paramStoryAtVideoFragment.jdField_a_of_type_Ucw.a(paramujl.mVideoItemList, true);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Udh != null) {
      paramStoryAtVideoFragment.jdField_a_of_type_Udh.a(paramujl.mVideoPullType, paramujl.mVideoNextCookie, paramujl.mVideoSeq);
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Ucw);
  }
  
  public Class acceptEventClass()
  {
    return ujl.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull ujl paramujl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ubz
 * JD-Core Version:    0.7.0.1
 */