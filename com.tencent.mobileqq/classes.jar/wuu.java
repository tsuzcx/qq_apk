import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wuu
  extends QQUIEventReceiver<wub, vej>
{
  public wuu(@NonNull wub paramwub)
  {
    super(paramwub);
  }
  
  public void a(@NonNull wub paramwub, @NonNull vej paramvej)
  {
    if ((paramvej.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramvej.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramwub.a(paramvej);
  }
  
  public Class acceptEventClass()
  {
    return vej.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wuu
 * JD-Core Version:    0.7.0.1
 */