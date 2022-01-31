import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uyg
  extends QQUIEventReceiver<uye, tli>
{
  public uyg(@NonNull uye paramuye)
  {
    super(paramuye);
  }
  
  public void a(@NonNull uye paramuye, @NonNull tli paramtli)
  {
    if ((paramtli.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramtli.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramuye.b(paramtli.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return tli.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyg
 * JD-Core Version:    0.7.0.1
 */