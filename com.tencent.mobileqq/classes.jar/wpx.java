import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class wpx
  extends umf<wpr, wpf>
{
  public wpx(wpr paramwpr)
  {
    super(paramwpr);
  }
  
  public void a(@NonNull wpr paramwpr, @NonNull wpf paramwpf)
  {
    if (paramwpf.jdField_a_of_type_Int == 0) {
      return;
    }
    Object localObject = paramwpr.a(paramwpf.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramwpf.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof wpg))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramwpf.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (wpg)localObject;
    FeedVideoInfo localFeedVideoInfo = ((wpe)uwa.a(12)).a(paramwpf.jdField_a_of_type_JavaLangString, ((GeneralFeedItem)((wpg)localObject).a).mVideoPullType);
    if (localFeedVideoInfo == null)
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find video info for feedId:%s, pullType:%d", new Object[] { paramwpf.jdField_a_of_type_JavaLangString, Integer.valueOf(((GeneralFeedItem)((wpg)localObject).a).mVideoPullType) });
      return;
    }
    ((wpg)localObject).c(localFeedVideoInfo.mVideoItemList, true);
    ((GeneralFeedItem)((wpg)localObject).a).updateVideoInfo(localFeedVideoInfo);
    wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video and cookie update after count:%d", paramwpf.jdField_a_of_type_JavaLangString, Integer.valueOf(((wpg)localObject).a().size()));
    wpr.a(paramwpr).a((wqp)localObject);
  }
  
  public Class acceptEventClass()
  {
    return wpf.class;
  }
  
  public void b(@NonNull wpr paramwpr, @NonNull wpf paramwpf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpx
 * JD-Core Version:    0.7.0.1
 */