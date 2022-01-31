import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vbt
  extends QQUIEventReceiver<vba, tli>
{
  public vbt(@NonNull vba paramvba)
  {
    super(paramvba);
  }
  
  public void a(@NonNull vba paramvba, @NonNull tli paramtli)
  {
    if ((paramtli.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramtli.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramvba.a(paramtli);
  }
  
  public Class acceptEventClass()
  {
    return tli.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbt
 * JD-Core Version:    0.7.0.1
 */