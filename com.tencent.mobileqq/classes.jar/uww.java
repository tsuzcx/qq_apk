import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class uww
  extends ste<uwq, uwe>
{
  public uww(uwq paramuwq)
  {
    super(paramuwq);
  }
  
  public void a(@NonNull uwq paramuwq, @NonNull uwe paramuwe)
  {
    if (paramuwe.jdField_a_of_type_Int == 0) {
      return;
    }
    Object localObject = paramuwq.a(paramuwe.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramuwe.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof uwf))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramuwe.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (uwf)localObject;
    FeedVideoInfo localFeedVideoInfo = ((uwd)tcz.a(12)).a(paramuwe.jdField_a_of_type_JavaLangString, ((GeneralFeedItem)((uwf)localObject).a).mVideoPullType);
    if (localFeedVideoInfo == null)
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find video info for feedId:%s, pullType:%d", new Object[] { paramuwe.jdField_a_of_type_JavaLangString, Integer.valueOf(((GeneralFeedItem)((uwf)localObject).a).mVideoPullType) });
      return;
    }
    ((uwf)localObject).c(localFeedVideoInfo.mVideoItemList, true);
    ((GeneralFeedItem)((uwf)localObject).a).updateVideoInfo(localFeedVideoInfo);
    ved.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video and cookie update after count:%d", paramuwe.jdField_a_of_type_JavaLangString, Integer.valueOf(((uwf)localObject).a().size()));
    uwq.a(paramuwq).a((uxo)localObject);
  }
  
  public Class acceptEventClass()
  {
    return uwe.class;
  }
  
  public void b(@NonNull uwq paramuwq, @NonNull uwe paramuwe) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uww
 * JD-Core Version:    0.7.0.1
 */