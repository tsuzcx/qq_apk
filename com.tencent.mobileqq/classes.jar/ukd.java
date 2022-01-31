import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class ukd
  extends sgl<ujx, ujl>
{
  public ukd(ujx paramujx)
  {
    super(paramujx);
  }
  
  public void a(@NonNull ujx paramujx, @NonNull ujl paramujl)
  {
    if (paramujl.jdField_a_of_type_Int == 0) {
      return;
    }
    Object localObject = paramujx.a(paramujl.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramujl.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof ujm))
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramujl.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (ujm)localObject;
    FeedVideoInfo localFeedVideoInfo = ((ujk)sqg.a(12)).a(paramujl.jdField_a_of_type_JavaLangString, ((GeneralFeedItem)((ujm)localObject).a).mVideoPullType);
    if (localFeedVideoInfo == null)
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find video info for feedId:%s, pullType:%d", new Object[] { paramujl.jdField_a_of_type_JavaLangString, Integer.valueOf(((GeneralFeedItem)((ujm)localObject).a).mVideoPullType) });
      return;
    }
    ((ujm)localObject).c(localFeedVideoInfo.mVideoItemList, true);
    ((GeneralFeedItem)((ujm)localObject).a).updateVideoInfo(localFeedVideoInfo);
    urk.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video and cookie update after count:%d", paramujl.jdField_a_of_type_JavaLangString, Integer.valueOf(((ujm)localObject).a().size()));
    ujx.a(paramujx).a((ukv)localObject);
  }
  
  public Class acceptEventClass()
  {
    return ujl.class;
  }
  
  public void b(@NonNull ujx paramujx, @NonNull ujl paramujl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukd
 * JD-Core Version:    0.7.0.1
 */