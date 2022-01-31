import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

public class uke
  extends sgl<ujx, udk>
{
  public uke(ujx paramujx)
  {
    super(paramujx);
  }
  
  public void a(@NonNull ujx paramujx, @NonNull udk paramudk)
  {
    Object localObject = paramujx.a(paramudk.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramudk.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof ukv))
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramudk.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (ukv)localObject;
    if (paramudk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ((ukv)localObject).c(paramudk.jdField_a_of_type_JavaUtilList, false);
      ((VideoListFeedItem)((ukv)localObject).a).updateVideoInfo(paramudk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
      urk.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramudk.jdField_a_of_type_JavaLangString, Integer.valueOf(((ukv)localObject).a().size()));
    }
    ujx.a(paramujx).a((ukv)localObject);
  }
  
  public Class acceptEventClass()
  {
    return udk.class;
  }
  
  public void b(@NonNull ujx paramujx, @NonNull udk paramudk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uke
 * JD-Core Version:    0.7.0.1
 */