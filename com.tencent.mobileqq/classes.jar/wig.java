import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class wig
  extends QQUIEventReceiver<wic, wif>
{
  public wig(wic paramwic)
  {
    super(paramwic);
  }
  
  public void a(@NonNull wic paramwic, @NonNull wif paramwif)
  {
    if (paramwif.jdField_a_of_type_Boolean)
    {
      if (paramwif.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        wic.a(paramwic, paramwif.jdField_a_of_type_JavaUtilList, true);
        wic.a(paramwic).a(true);
      }
      return;
    }
    wic.a(paramwic, paramwif);
    wic.a(paramwic).remove(wic.b());
    wic.a(paramwic);
  }
  
  public Class acceptEventClass()
  {
    return wif.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wig
 * JD-Core Version:    0.7.0.1
 */