import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class uwz
  extends sth<uwt, uwh>
{
  public uwz(uwt paramuwt)
  {
    super(paramuwt);
  }
  
  public void a(@NonNull uwt paramuwt, @NonNull uwh paramuwh)
  {
    if (paramuwh.jdField_a_of_type_Int == 0) {
      return;
    }
    Object localObject = paramuwt.a(paramuwh.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramuwh.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof uwi))
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramuwh.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (uwi)localObject;
    FeedVideoInfo localFeedVideoInfo = ((uwg)tdc.a(12)).a(paramuwh.jdField_a_of_type_JavaLangString, ((GeneralFeedItem)((uwi)localObject).a).mVideoPullType);
    if (localFeedVideoInfo == null)
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find video info for feedId:%s, pullType:%d", new Object[] { paramuwh.jdField_a_of_type_JavaLangString, Integer.valueOf(((GeneralFeedItem)((uwi)localObject).a).mVideoPullType) });
      return;
    }
    ((uwi)localObject).c(localFeedVideoInfo.mVideoItemList, true);
    ((GeneralFeedItem)((uwi)localObject).a).updateVideoInfo(localFeedVideoInfo);
    veg.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video and cookie update after count:%d", paramuwh.jdField_a_of_type_JavaLangString, Integer.valueOf(((uwi)localObject).a().size()));
    uwt.a(paramuwt).a((uxr)localObject);
  }
  
  public Class acceptEventClass()
  {
    return uwh.class;
  }
  
  public void b(@NonNull uwt paramuwt, @NonNull uwh paramuwh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwz
 * JD-Core Version:    0.7.0.1
 */