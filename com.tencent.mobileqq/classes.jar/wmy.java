import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wmy
  extends QQUIEventReceiver<wmw, vaa>
{
  public wmy(@NonNull wmw paramwmw)
  {
    super(paramwmw);
  }
  
  public void a(@NonNull wmw paramwmw, @NonNull vaa paramvaa)
  {
    if ((paramvaa.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramvaa.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramwmw.b(paramvaa.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return vaa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmy
 * JD-Core Version:    0.7.0.1
 */