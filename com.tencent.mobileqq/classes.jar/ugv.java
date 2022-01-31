import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class ugv
  extends QQUIEventReceiver<ugr, ugu>
{
  public ugv(ugr paramugr)
  {
    super(paramugr);
  }
  
  public void a(@NonNull ugr paramugr, @NonNull ugu paramugu)
  {
    if (paramugu.jdField_a_of_type_Boolean)
    {
      if (paramugu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        ugr.a(paramugr, paramugu.jdField_a_of_type_JavaUtilList, true);
        ugr.a(paramugr).a(true);
      }
      return;
    }
    ugr.a(paramugr, paramugu);
    ugr.a(paramugr).remove(ugr.b());
    ugr.a(paramugr);
  }
  
  public Class acceptEventClass()
  {
    return ugu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugv
 * JD-Core Version:    0.7.0.1
 */