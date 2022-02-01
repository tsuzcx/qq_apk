import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class xnt
  extends QQUIEventReceiver<xnp, wbm>
{
  public xnt(@NonNull xnp paramxnp)
  {
    super(paramxnp);
  }
  
  public void a(@NonNull xnp paramxnp, @NonNull wbm paramwbm)
  {
    xvv.a(this.TAG, "receive feature event. %s.", paramwbm.toString());
    if ((paramwbm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwbm.jdField_a_of_type_JavaUtilList != null))
    {
      paramwbm = paramwbm.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwbm.hasNext())
      {
        vwa localvwa = (vwa)paramwbm.next();
        xnp.a(paramxnp).put(localvwa.a, localvwa);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wbm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnt
 * JD-Core Version:    0.7.0.1
 */