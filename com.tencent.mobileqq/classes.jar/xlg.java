import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class xlg
  extends QQUIEventReceiver<xlc, xlf>
{
  public xlg(xlc paramxlc)
  {
    super(paramxlc);
  }
  
  public void a(@NonNull xlc paramxlc, @NonNull xlf paramxlf)
  {
    if (paramxlf.jdField_a_of_type_Boolean)
    {
      if (paramxlf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        xlc.a(paramxlc, paramxlf.jdField_a_of_type_JavaUtilList, true);
        xlc.a(paramxlc).a(true);
      }
      return;
    }
    xlc.a(paramxlc, paramxlf);
    xlc.a(paramxlc).remove(xlc.b());
    xlc.a(paramxlc);
  }
  
  public Class acceptEventClass()
  {
    return xlf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlg
 * JD-Core Version:    0.7.0.1
 */