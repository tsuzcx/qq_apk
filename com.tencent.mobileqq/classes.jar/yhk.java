import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class yhk
  extends wjm<yhc, yml>
{
  public yhk(yhc paramyhc)
  {
    super(paramyhc);
  }
  
  public void a(@NonNull yhc paramyhc, @NonNull yml paramyml)
  {
    if ((paramyml.jdField_a_of_type_Int == 2) || (!paramyml.jdField_a_of_type_JavaLangString.equals(yhc.a(paramyhc))) || (yhc.a(paramyhc) == null))
    {
      yuk.b(this.TAG, "ignore this video cookie change event. %s.", paramyml.toString());
      return;
    }
    if (!yhc.a(paramyhc).c())
    {
      yuk.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { paramyml.toString() });
      return;
    }
    paramyml = yhc.a(paramyhc).a(yhc.a(paramyhc), yhc.a(paramyhc).a().mVideoPullType);
    if (paramyml == null)
    {
      yuk.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { yhc.a(paramyhc), Integer.valueOf(yhc.a(paramyhc).a().mVideoPullType) });
      return;
    }
    yuk.a(this.TAG, "receive video cookie change event. %s.", paramyml.toString());
    yhc.a(paramyhc).a().updateVideoInfo(paramyml);
    yhc.a(paramyhc).a(paramyml.mVideoItemList, true);
    if (yhc.a(paramyhc) != null) {
      yhc.a(paramyhc).a(paramyml.mVideoPullType, paramyml.mVideoNextCookie, paramyml.mVideoSeq);
    }
    yhc.a(paramyhc).c();
  }
  
  public Class acceptEventClass()
  {
    return yml.class;
  }
  
  public void b(@NonNull yhc paramyhc, @NonNull yml paramyml) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhk
 * JD-Core Version:    0.7.0.1
 */