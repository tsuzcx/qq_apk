import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uln
  extends QQUIEventReceiver<ull, syp>
{
  public uln(@NonNull ull paramull)
  {
    super(paramull);
  }
  
  public void a(@NonNull ull paramull, @NonNull syp paramsyp)
  {
    if ((paramsyp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramsyp.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramull.b(paramsyp.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return syp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uln
 * JD-Core Version:    0.7.0.1
 */