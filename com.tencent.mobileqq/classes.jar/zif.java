import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;

public class zif
  extends QQUIEventReceiver<StoryUserBadgeView, wra>
{
  public zif(@NonNull StoryUserBadgeView paramStoryUserBadgeView)
  {
    super(paramStoryUserBadgeView);
  }
  
  public void a(@NonNull StoryUserBadgeView paramStoryUserBadgeView, @NonNull wra paramwra)
  {
    if (paramwra.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    while (paramwra.jdField_a_of_type_JavaUtilHashMap.get(paramStoryUserBadgeView.a()) == null) {
      return;
    }
    paramStoryUserBadgeView.a(paramStoryUserBadgeView.a());
  }
  
  public Class acceptEventClass()
  {
    return wra.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zif
 * JD-Core Version:    0.7.0.1
 */