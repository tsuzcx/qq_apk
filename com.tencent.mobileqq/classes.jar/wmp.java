import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class wmp
  extends QQUIEventReceiver<wml, wmo>
{
  public wmp(wml paramwml)
  {
    super(paramwml);
  }
  
  public void a(@NonNull wml paramwml, @NonNull wmo paramwmo)
  {
    if (paramwmo.jdField_a_of_type_Boolean)
    {
      if (paramwmo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        wml.a(paramwml, paramwmo.jdField_a_of_type_JavaUtilList, true);
        wml.a(paramwml).a(true);
      }
      return;
    }
    wml.a(paramwml, paramwmo);
    wml.a(paramwml).remove(wml.b());
    wml.a(paramwml);
  }
  
  public Class acceptEventClass()
  {
    return wmo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmp
 * JD-Core Version:    0.7.0.1
 */