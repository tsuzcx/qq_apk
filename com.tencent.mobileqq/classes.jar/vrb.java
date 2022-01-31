import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;

public class vrb
  extends QQUIEventReceiver<StoryUserBadgeView, sxo>
{
  public vrb(@NonNull StoryUserBadgeView paramStoryUserBadgeView)
  {
    super(paramStoryUserBadgeView);
  }
  
  public void a(@NonNull StoryUserBadgeView paramStoryUserBadgeView, @NonNull sxo paramsxo)
  {
    if (paramsxo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    while (paramsxo.jdField_a_of_type_JavaUtilHashMap.get(paramStoryUserBadgeView.a()) == null) {
      return;
    }
    paramStoryUserBadgeView.a(paramStoryUserBadgeView.a());
  }
  
  public Class acceptEventClass()
  {
    return sxo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vrb
 * JD-Core Version:    0.7.0.1
 */