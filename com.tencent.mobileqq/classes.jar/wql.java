import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wql
  extends QQUIEventReceiver<wps, vaa>
{
  public wql(@NonNull wps paramwps)
  {
    super(paramwps);
  }
  
  public void a(@NonNull wps paramwps, @NonNull vaa paramvaa)
  {
    if ((paramvaa.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramvaa.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramwps.a(paramvaa);
  }
  
  public Class acceptEventClass()
  {
    return vaa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wql
 * JD-Core Version:    0.7.0.1
 */