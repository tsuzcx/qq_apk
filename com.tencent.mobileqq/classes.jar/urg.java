import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class urg
  extends sth<uqy, uwh>
{
  public urg(uqy paramuqy)
  {
    super(paramuqy);
  }
  
  public void a(@NonNull uqy paramuqy, @NonNull uwh paramuwh)
  {
    if ((paramuwh.jdField_a_of_type_Int == 2) || (!paramuwh.jdField_a_of_type_JavaLangString.equals(uqy.a(paramuqy))) || (uqy.a(paramuqy) == null))
    {
      veg.b(this.TAG, "ignore this video cookie change event. %s.", paramuwh.toString());
      return;
    }
    if (!uqy.a(paramuqy).c())
    {
      veg.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { paramuwh.toString() });
      return;
    }
    paramuwh = uqy.a(paramuqy).a(uqy.a(paramuqy), uqy.a(paramuqy).a().mVideoPullType);
    if (paramuwh == null)
    {
      veg.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { uqy.a(paramuqy), Integer.valueOf(uqy.a(paramuqy).a().mVideoPullType) });
      return;
    }
    veg.a(this.TAG, "receive video cookie change event. %s.", paramuwh.toString());
    uqy.a(paramuqy).a().updateVideoInfo(paramuwh);
    uqy.a(paramuqy).a(paramuwh.mVideoItemList, true);
    if (uqy.a(paramuqy) != null) {
      uqy.a(paramuqy).a(paramuwh.mVideoPullType, paramuwh.mVideoNextCookie, paramuwh.mVideoSeq);
    }
    uqy.a(paramuqy).c();
  }
  
  public Class acceptEventClass()
  {
    return uwh.class;
  }
  
  public void b(@NonNull uqy paramuqy, @NonNull uwh paramuwh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urg
 * JD-Core Version:    0.7.0.1
 */