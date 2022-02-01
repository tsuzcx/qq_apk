import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class yjv
  extends QQUIEventReceiver<yjr, yju>
{
  public yjv(yjr paramyjr)
  {
    super(paramyjr);
  }
  
  public void a(@NonNull yjr paramyjr, @NonNull yju paramyju)
  {
    if (paramyju.jdField_a_of_type_Boolean)
    {
      if (paramyju.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        yjr.a(paramyjr, paramyju.jdField_a_of_type_JavaUtilList, true);
        yjr.a(paramyjr).a(true);
      }
      return;
    }
    yjr.a(paramyjr, paramyju);
    yjr.a(paramyjr).remove(yjr.b());
    yjr.a(paramyjr);
  }
  
  public Class acceptEventClass()
  {
    return yju.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjv
 * JD-Core Version:    0.7.0.1
 */