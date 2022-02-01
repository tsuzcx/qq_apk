import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yon
  extends QQUIEventReceiver<yol, xbq>
{
  public yon(@NonNull yol paramyol)
  {
    super(paramyol);
  }
  
  public void a(@NonNull yol paramyol, @NonNull xbq paramxbq)
  {
    if ((paramxbq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramxbq.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramyol.b(paramxbq.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return xbq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yon
 * JD-Core Version:    0.7.0.1
 */