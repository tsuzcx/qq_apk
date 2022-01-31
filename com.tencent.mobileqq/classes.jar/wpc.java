import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class wpc
  extends QQUIEventReceiver<woy, vcp>
{
  public wpc(@NonNull woy paramwoy)
  {
    super(paramwoy);
  }
  
  public void a(@NonNull woy paramwoy, @NonNull vcp paramvcp)
  {
    wxe.a(this.TAG, "receive feature event. %s.", paramvcp.toString());
    if ((paramvcp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramvcp.jdField_a_of_type_JavaUtilList != null))
    {
      paramvcp = paramvcp.jdField_a_of_type_JavaUtilList.iterator();
      while (paramvcp.hasNext())
      {
        uxd localuxd = (uxd)paramvcp.next();
        woy.a(paramwoy).put(localuxd.a, localuxd);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return vcp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpc
 * JD-Core Version:    0.7.0.1
 */