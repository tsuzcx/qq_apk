import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class yga
  extends QQUIEventReceiver<yfw, yfz>
{
  public yga(yfw paramyfw)
  {
    super(paramyfw);
  }
  
  public void a(@NonNull yfw paramyfw, @NonNull yfz paramyfz)
  {
    if (paramyfz.jdField_a_of_type_Boolean)
    {
      if (paramyfz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        yfw.a(paramyfw, paramyfz.jdField_a_of_type_JavaUtilList, true);
        yfw.a(paramyfw).a(true);
      }
      return;
    }
    yfw.a(paramyfw, paramyfz);
    yfw.a(paramyfw).remove(yfw.b());
    yfw.a(paramyfw);
  }
  
  public Class acceptEventClass()
  {
    return yfz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yga
 * JD-Core Version:    0.7.0.1
 */