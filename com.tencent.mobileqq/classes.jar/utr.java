import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class utr
  extends QQUIEventReceiver<utn, utq>
{
  public utr(utn paramutn)
  {
    super(paramutn);
  }
  
  public void a(@NonNull utn paramutn, @NonNull utq paramutq)
  {
    if (paramutq.jdField_a_of_type_Boolean)
    {
      if (paramutq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        utn.a(paramutn, paramutq.jdField_a_of_type_JavaUtilList, true);
        utn.a(paramutn).a(true);
      }
      return;
    }
    utn.a(paramutn, paramutq);
    utn.a(paramutn).remove(utn.b());
    utn.a(paramutn);
  }
  
  public Class acceptEventClass()
  {
    return utq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utr
 * JD-Core Version:    0.7.0.1
 */