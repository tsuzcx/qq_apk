import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class yab
  extends QQUIEventReceiver<xzx, yaa>
{
  public yab(xzx paramxzx)
  {
    super(paramxzx);
  }
  
  public void a(@NonNull xzx paramxzx, @NonNull yaa paramyaa)
  {
    if (paramyaa.jdField_a_of_type_Boolean)
    {
      if (paramyaa.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        xzx.a(paramxzx, paramyaa.jdField_a_of_type_JavaUtilList, true);
        xzx.a(paramxzx).a(true);
      }
      return;
    }
    xzx.a(paramxzx, paramyaa);
    xzx.a(paramxzx).remove(xzx.b());
    xzx.a(paramxzx);
  }
  
  public Class acceptEventClass()
  {
    return yaa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yab
 * JD-Core Version:    0.7.0.1
 */