import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

public class xop
  extends vll<xoi, xhv>
{
  public xop(xoi paramxoi)
  {
    super(paramxoi);
  }
  
  public void a(@NonNull xoi paramxoi, @NonNull xhv paramxhv)
  {
    Object localObject = paramxoi.a(paramxhv.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramxhv.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof xpg))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramxhv.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (xpg)localObject;
    if (paramxhv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ((xpg)localObject).c(paramxhv.jdField_a_of_type_JavaUtilList, false);
      ((VideoListFeedItem)((xpg)localObject).a).updateVideoInfo(paramxhv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
      xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramxhv.jdField_a_of_type_JavaLangString, Integer.valueOf(((xpg)localObject).a().size()));
    }
    xoi.a(paramxoi).a((xpg)localObject);
  }
  
  public Class acceptEventClass()
  {
    return xhv.class;
  }
  
  public void b(@NonNull xoi paramxoi, @NonNull xhv paramxhv) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xop
 * JD-Core Version:    0.7.0.1
 */