import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class urd
  extends ste<uqv, uwe>
{
  public urd(uqv paramuqv)
  {
    super(paramuqv);
  }
  
  public void a(@NonNull uqv paramuqv, @NonNull uwe paramuwe)
  {
    if ((paramuwe.jdField_a_of_type_Int == 2) || (!paramuwe.jdField_a_of_type_JavaLangString.equals(uqv.a(paramuqv))) || (uqv.a(paramuqv) == null))
    {
      ved.b(this.TAG, "ignore this video cookie change event. %s.", paramuwe.toString());
      return;
    }
    if (!uqv.a(paramuqv).c())
    {
      ved.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { paramuwe.toString() });
      return;
    }
    paramuwe = uqv.a(paramuqv).a(uqv.a(paramuqv), uqv.a(paramuqv).a().mVideoPullType);
    if (paramuwe == null)
    {
      ved.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { uqv.a(paramuqv), Integer.valueOf(uqv.a(paramuqv).a().mVideoPullType) });
      return;
    }
    ved.a(this.TAG, "receive video cookie change event. %s.", paramuwe.toString());
    uqv.a(paramuqv).a().updateVideoInfo(paramuwe);
    uqv.a(paramuqv).a(paramuwe.mVideoItemList, true);
    if (uqv.a(paramuqv) != null) {
      uqv.a(paramuqv).a(paramuwe.mVideoPullType, paramuwe.mVideoNextCookie, paramuwe.mVideoSeq);
    }
    uqv.a(paramuqv).c();
  }
  
  public Class acceptEventClass()
  {
    return uwe.class;
  }
  
  public void b(@NonNull uqv paramuqv, @NonNull uwe paramuwe) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urd
 * JD-Core Version:    0.7.0.1
 */