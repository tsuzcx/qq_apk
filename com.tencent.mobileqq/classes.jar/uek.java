import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class uek
  extends sgl<uec, ujl>
{
  public uek(uec paramuec)
  {
    super(paramuec);
  }
  
  public void a(@NonNull uec paramuec, @NonNull ujl paramujl)
  {
    if ((paramujl.jdField_a_of_type_Int == 2) || (!paramujl.jdField_a_of_type_JavaLangString.equals(uec.a(paramuec))) || (uec.a(paramuec) == null))
    {
      urk.b(this.TAG, "ignore this video cookie change event. %s.", paramujl.toString());
      return;
    }
    if (!uec.a(paramuec).c())
    {
      urk.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { paramujl.toString() });
      return;
    }
    paramujl = uec.a(paramuec).a(uec.a(paramuec), uec.a(paramuec).a().mVideoPullType);
    if (paramujl == null)
    {
      urk.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { uec.a(paramuec), Integer.valueOf(uec.a(paramuec).a().mVideoPullType) });
      return;
    }
    urk.a(this.TAG, "receive video cookie change event. %s.", paramujl.toString());
    uec.a(paramuec).a().updateVideoInfo(paramujl);
    uec.a(paramuec).a(paramujl.mVideoItemList, true);
    if (uec.a(paramuec) != null) {
      uec.a(paramuec).a(paramujl.mVideoPullType, paramujl.mVideoNextCookie, paramujl.mVideoSeq);
    }
    uec.a(paramuec).c();
  }
  
  public Class acceptEventClass()
  {
    return ujl.class;
  }
  
  public void b(@NonNull uec paramuec, @NonNull ujl paramujl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uek
 * JD-Core Version:    0.7.0.1
 */