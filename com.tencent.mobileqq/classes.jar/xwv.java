import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;

public class xwv
  extends QQUIEventReceiver<StoryUserBadgeView, vdi>
{
  public xwv(@NonNull StoryUserBadgeView paramStoryUserBadgeView)
  {
    super(paramStoryUserBadgeView);
  }
  
  public void a(@NonNull StoryUserBadgeView paramStoryUserBadgeView, @NonNull vdi paramvdi)
  {
    if (paramvdi.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    while (paramvdi.jdField_a_of_type_JavaUtilHashMap.get(paramStoryUserBadgeView.a()) == null) {
      return;
    }
    paramStoryUserBadgeView.a(paramStoryUserBadgeView.a());
  }
  
  public Class acceptEventClass()
  {
    return vdi.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xwv
 * JD-Core Version:    0.7.0.1
 */