import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vbw
  extends QQUIEventReceiver<vbd, tll>
{
  public vbw(@NonNull vbd paramvbd)
  {
    super(paramvbd);
  }
  
  public void a(@NonNull vbd paramvbd, @NonNull tll paramtll)
  {
    if ((paramtll.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramtll.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramvbd.a(paramtll);
  }
  
  public Class acceptEventClass()
  {
    return tll.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbw
 * JD-Core Version:    0.7.0.1
 */