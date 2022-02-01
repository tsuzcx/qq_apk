import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class xoo
  extends vll<xoi, xnw>
{
  public xoo(xoi paramxoi)
  {
    super(paramxoi);
  }
  
  public void a(@NonNull xoi paramxoi, @NonNull xnw paramxnw)
  {
    if (paramxnw.jdField_a_of_type_Int == 0) {
      return;
    }
    Object localObject = paramxoi.a(paramxnw.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramxnw.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof xnx))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramxnw.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (xnx)localObject;
    FeedVideoInfo localFeedVideoInfo = ((xnv)vux.a(12)).a(paramxnw.jdField_a_of_type_JavaLangString, ((GeneralFeedItem)((xnx)localObject).a).mVideoPullType);
    if (localFeedVideoInfo == null)
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find video info for feedId:%s, pullType:%d", new Object[] { paramxnw.jdField_a_of_type_JavaLangString, Integer.valueOf(((GeneralFeedItem)((xnx)localObject).a).mVideoPullType) });
      return;
    }
    ((xnx)localObject).c(localFeedVideoInfo.mVideoItemList, true);
    ((GeneralFeedItem)((xnx)localObject).a).updateVideoInfo(localFeedVideoInfo);
    xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video and cookie update after count:%d", paramxnw.jdField_a_of_type_JavaLangString, Integer.valueOf(((xnx)localObject).a().size()));
    xoi.a(paramxoi).a((xpg)localObject);
  }
  
  public Class acceptEventClass()
  {
    return xnw.class;
  }
  
  public void b(@NonNull xoi paramxoi, @NonNull xnw paramxnw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoo
 * JD-Core Version:    0.7.0.1
 */