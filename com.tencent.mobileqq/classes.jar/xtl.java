import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xtl
  extends QQUIEventReceiver<xss, wdg>
{
  public xtl(@NonNull xss paramxss)
  {
    super(paramxss);
  }
  
  public void a(@NonNull xss paramxss, @NonNull wdg paramwdg)
  {
    if ((paramwdg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramwdg.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramxss.a(paramwdg);
  }
  
  public Class acceptEventClass()
  {
    return wdg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtl
 * JD-Core Version:    0.7.0.1
 */