import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class uto
  extends QQUIEventReceiver<utk, utn>
{
  public uto(utk paramutk)
  {
    super(paramutk);
  }
  
  public void a(@NonNull utk paramutk, @NonNull utn paramutn)
  {
    if (paramutn.jdField_a_of_type_Boolean)
    {
      if (paramutn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        utk.a(paramutk, paramutn.jdField_a_of_type_JavaUtilList, true);
        utk.a(paramutk).a(true);
      }
      return;
    }
    utk.a(paramutk, paramutn);
    utk.a(paramutk).remove(utk.b());
    utk.a(paramutk);
  }
  
  public Class acceptEventClass()
  {
    return utn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uto
 * JD-Core Version:    0.7.0.1
 */