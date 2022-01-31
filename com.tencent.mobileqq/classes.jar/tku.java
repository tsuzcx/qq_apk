import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tku
  extends QQUIEventReceiver<tks, tkr>
{
  public tku(tks paramtks)
  {
    super(paramtks);
  }
  
  public void a(@NonNull tks paramtks, @NonNull tkr paramtkr)
  {
    if (paramtks.a()) {}
    do
    {
      return;
      if (paramtkr.jdField_a_of_type_Boolean)
      {
        tks.a(paramtks);
        return;
      }
      if ((paramtkr.a() != null) && (!paramtkr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HaloResponseReceiver", 2, "onEvent: failed. Message: exception: " + paramtkr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    return;
    tks.a(paramtks);
  }
  
  public Class acceptEventClass()
  {
    return tkr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tku
 * JD-Core Version:    0.7.0.1
 */