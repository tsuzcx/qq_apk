import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class uji
  extends QQUIEventReceiver<uje, swv>
{
  public uji(@NonNull uje paramuje)
  {
    super(paramuje);
  }
  
  public void a(@NonNull uje paramuje, @NonNull swv paramswv)
  {
    urk.a(this.TAG, "receive feature event. %s.", paramswv.toString());
    if ((paramswv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramswv.jdField_a_of_type_JavaUtilList != null))
    {
      paramswv = paramswv.jdField_a_of_type_JavaUtilList.iterator();
      while (paramswv.hasNext())
      {
        srj localsrj = (srj)paramswv.next();
        uje.a(paramuje).put(localsrj.a, localsrj);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return swv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uji
 * JD-Core Version:    0.7.0.1
 */