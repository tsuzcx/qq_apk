import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class yin
  extends QQUIEventReceiver<yij, wwb>
{
  public yin(@NonNull yij paramyij)
  {
    super(paramyij);
  }
  
  public void a(@NonNull yij paramyij, @NonNull wwb paramwwb)
  {
    yqp.a(this.TAG, "receive feature event. %s.", paramwwb.toString());
    if ((paramwwb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwwb.jdField_a_of_type_JavaUtilList != null))
    {
      paramwwb = paramwwb.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwwb.hasNext())
      {
        wqp localwqp = (wqp)paramwwb.next();
        yij.a(paramyij).put(localwqp.a, localwqp);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wwb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yin
 * JD-Core Version:    0.7.0.1
 */