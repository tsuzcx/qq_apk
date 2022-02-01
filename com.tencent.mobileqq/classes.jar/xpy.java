import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xpy
  extends QQUIEventReceiver<xpw, wdg>
{
  public xpy(@NonNull xpw paramxpw)
  {
    super(paramxpw);
  }
  
  public void a(@NonNull xpw paramxpw, @NonNull wdg paramwdg)
  {
    if ((paramwdg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramwdg.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramxpw.b(paramwdg.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return wdg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpy
 * JD-Core Version:    0.7.0.1
 */