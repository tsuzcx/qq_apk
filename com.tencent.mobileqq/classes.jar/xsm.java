import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;

public class xsm
  extends QQUIEventReceiver<StoryUserBadgeView, uyz>
{
  public xsm(@NonNull StoryUserBadgeView paramStoryUserBadgeView)
  {
    super(paramStoryUserBadgeView);
  }
  
  public void a(@NonNull StoryUserBadgeView paramStoryUserBadgeView, @NonNull uyz paramuyz)
  {
    if (paramuyz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    while (paramuyz.jdField_a_of_type_JavaUtilHashMap.get(paramStoryUserBadgeView.a()) == null) {
      return;
    }
    paramStoryUserBadgeView.a(paramStoryUserBadgeView.a());
  }
  
  public Class acceptEventClass()
  {
    return uyz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xsm
 * JD-Core Version:    0.7.0.1
 */