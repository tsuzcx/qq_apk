import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class upa
  extends QQUIEventReceiver<uoh, syp>
{
  public upa(@NonNull uoh paramuoh)
  {
    super(paramuoh);
  }
  
  public void a(@NonNull uoh paramuoh, @NonNull syp paramsyp)
  {
    if ((paramsyp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramsyp.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramuoh.a(paramsyp);
  }
  
  public Class acceptEventClass()
  {
    return syp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upa
 * JD-Core Version:    0.7.0.1
 */