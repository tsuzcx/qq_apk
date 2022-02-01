import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ysa
  extends QQUIEventReceiver<yrh, xbq>
{
  public ysa(@NonNull yrh paramyrh)
  {
    super(paramyrh);
  }
  
  public void a(@NonNull yrh paramyrh, @NonNull xbq paramxbq)
  {
    if ((paramxbq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramxbq.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramyrh.a(paramxbq);
  }
  
  public Class acceptEventClass()
  {
    return xbq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysa
 * JD-Core Version:    0.7.0.1
 */