import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uyj
  extends QQUIEventReceiver<uyh, tll>
{
  public uyj(@NonNull uyh paramuyh)
  {
    super(paramuyh);
  }
  
  public void a(@NonNull uyh paramuyh, @NonNull tll paramtll)
  {
    if ((paramtll.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramtll.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramuyh.b(paramtll.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return tll.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyj
 * JD-Core Version:    0.7.0.1
 */