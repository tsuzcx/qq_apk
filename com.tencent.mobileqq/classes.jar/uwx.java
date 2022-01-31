import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

public class uwx
  extends ste<uwq, uqd>
{
  public uwx(uwq paramuwq)
  {
    super(paramuwq);
  }
  
  public void a(@NonNull uwq paramuwq, @NonNull uqd paramuqd)
  {
    Object localObject = paramuwq.a(paramuqd.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramuqd.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof uxo))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramuqd.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (uxo)localObject;
    if (paramuqd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ((uxo)localObject).c(paramuqd.jdField_a_of_type_JavaUtilList, false);
      ((VideoListFeedItem)((uxo)localObject).a).updateVideoInfo(paramuqd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
      ved.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramuqd.jdField_a_of_type_JavaLangString, Integer.valueOf(((uxo)localObject).a().size()));
    }
    uwq.a(paramuwq).a((uxo)localObject);
  }
  
  public Class acceptEventClass()
  {
    return uqd.class;
  }
  
  public void b(@NonNull uwq paramuwq, @NonNull uqd paramuqd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwx
 * JD-Core Version:    0.7.0.1
 */