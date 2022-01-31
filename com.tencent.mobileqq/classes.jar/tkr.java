import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tkr
  extends QQUIEventReceiver<tkp, tko>
{
  public tkr(tkp paramtkp)
  {
    super(paramtkp);
  }
  
  public void a(@NonNull tkp paramtkp, @NonNull tko paramtko)
  {
    if (paramtkp.a()) {}
    do
    {
      return;
      if (paramtko.jdField_a_of_type_Boolean)
      {
        tkp.a(paramtkp);
        return;
      }
      if ((paramtko.a() != null) && (!paramtko.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HaloResponseReceiver", 2, "onEvent: failed. Message: exception: " + paramtko.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    return;
    tkp.a(paramtkp);
  }
  
  public Class acceptEventClass()
  {
    return tko.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkr
 * JD-Core Version:    0.7.0.1
 */