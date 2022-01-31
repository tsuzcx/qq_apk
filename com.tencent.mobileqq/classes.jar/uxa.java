import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

public class uxa
  extends sth<uwt, uqg>
{
  public uxa(uwt paramuwt)
  {
    super(paramuwt);
  }
  
  public void a(@NonNull uwt paramuwt, @NonNull uqg paramuqg)
  {
    Object localObject = paramuwt.a(paramuqg.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramuqg.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof uxr))
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramuqg.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (uxr)localObject;
    if (paramuqg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ((uxr)localObject).c(paramuqg.jdField_a_of_type_JavaUtilList, false);
      ((VideoListFeedItem)((uxr)localObject).a).updateVideoInfo(paramuqg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
      veg.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramuqg.jdField_a_of_type_JavaLangString, Integer.valueOf(((uxr)localObject).a().size()));
    }
    uwt.a(paramuwt).a((uxr)localObject);
  }
  
  public Class acceptEventClass()
  {
    return uqg.class;
  }
  
  public void b(@NonNull uwt paramuwt, @NonNull uqg paramuqg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxa
 * JD-Core Version:    0.7.0.1
 */