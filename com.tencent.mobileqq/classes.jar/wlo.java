import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class wlo
  extends uhw<wli, wkw>
{
  public wlo(wli paramwli)
  {
    super(paramwli);
  }
  
  public void a(@NonNull wli paramwli, @NonNull wkw paramwkw)
  {
    if (paramwkw.jdField_a_of_type_Int == 0) {
      return;
    }
    Object localObject = paramwli.a(paramwkw.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramwkw.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof wkx))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramwkw.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (wkx)localObject;
    FeedVideoInfo localFeedVideoInfo = ((wkv)urr.a(12)).a(paramwkw.jdField_a_of_type_JavaLangString, ((GeneralFeedItem)((wkx)localObject).a).mVideoPullType);
    if (localFeedVideoInfo == null)
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find video info for feedId:%s, pullType:%d", new Object[] { paramwkw.jdField_a_of_type_JavaLangString, Integer.valueOf(((GeneralFeedItem)((wkx)localObject).a).mVideoPullType) });
      return;
    }
    ((wkx)localObject).c(localFeedVideoInfo.mVideoItemList, true);
    ((GeneralFeedItem)((wkx)localObject).a).updateVideoInfo(localFeedVideoInfo);
    wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video and cookie update after count:%d", paramwkw.jdField_a_of_type_JavaLangString, Integer.valueOf(((wkx)localObject).a().size()));
    wli.a(paramwli).a((wmg)localObject);
  }
  
  public Class acceptEventClass()
  {
    return wkw.class;
  }
  
  public void b(@NonNull wli paramwli, @NonNull wkw paramwkw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlo
 * JD-Core Version:    0.7.0.1
 */