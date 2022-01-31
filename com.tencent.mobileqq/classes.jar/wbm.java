import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class wbm
  extends QQUIEventReceiver<wax, vcp>
{
  public wbm(@NonNull wax paramwax)
  {
    super(paramwax);
  }
  
  public void a(@NonNull wax paramwax, @NonNull vcp paramvcp)
  {
    if ((paramvcp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramvcp.jdField_a_of_type_JavaUtilList != null) && (paramwax.a != null))
    {
      paramvcp = paramvcp.jdField_a_of_type_JavaUtilList.iterator();
      while (paramvcp.hasNext())
      {
        uxd localuxd = (uxd)paramvcp.next();
        if (TextUtils.equals(paramwax.a.b, localuxd.a)) {
          paramwax.i();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return vcp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbm
 * JD-Core Version:    0.7.0.1
 */