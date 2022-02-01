import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

public class yjj
  extends wfr<yjc, ycp>
{
  public yjj(yjc paramyjc)
  {
    super(paramyjc);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull ycp paramycp)
  {
    Object localObject = paramyjc.a(paramycp.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramycp.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof yka))
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramycp.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (yka)localObject;
    if (paramycp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ((yka)localObject).c(paramycp.jdField_a_of_type_JavaUtilList, false);
      ((VideoListFeedItem)((yka)localObject).a).updateVideoInfo(paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
      yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramycp.jdField_a_of_type_JavaLangString, Integer.valueOf(((yka)localObject).a().size()));
    }
    yjc.a(paramyjc).a((yka)localObject);
  }
  
  public Class acceptEventClass()
  {
    return ycp.class;
  }
  
  public void b(@NonNull yjc paramyjc, @NonNull ycp paramycp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjj
 * JD-Core Version:    0.7.0.1
 */