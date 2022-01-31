import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wrh
  extends QQUIEventReceiver<wrf, vej>
{
  public wrh(@NonNull wrf paramwrf)
  {
    super(paramwrf);
  }
  
  public void a(@NonNull wrf paramwrf, @NonNull vej paramvej)
  {
    if ((paramvej.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramvej.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramwrf.b(paramvej.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return vej.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrh
 * JD-Core Version:    0.7.0.1
 */