import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class uwb
  extends QQUIEventReceiver<uvx, tjo>
{
  public uwb(@NonNull uvx paramuvx)
  {
    super(paramuvx);
  }
  
  public void a(@NonNull uvx paramuvx, @NonNull tjo paramtjo)
  {
    ved.a(this.TAG, "receive feature event. %s.", paramtjo.toString());
    if ((paramtjo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjo.jdField_a_of_type_JavaUtilList != null))
    {
      paramtjo = paramtjo.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtjo.hasNext())
      {
        tec localtec = (tec)paramtjo.next();
        uvx.a(paramuvx).put(localtec.a, localtec);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tjo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwb
 * JD-Core Version:    0.7.0.1
 */