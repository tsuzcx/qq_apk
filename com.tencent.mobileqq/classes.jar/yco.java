import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class yco
  extends QQUIEventReceiver<yck, wqh>
{
  public yco(@NonNull yck paramyck)
  {
    super(paramyck);
  }
  
  public void a(@NonNull yck paramyck, @NonNull wqh paramwqh)
  {
    ykq.a(this.TAG, "receive feature event. %s.", paramwqh.toString());
    if ((paramwqh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwqh.jdField_a_of_type_JavaUtilList != null))
    {
      paramwqh = paramwqh.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwqh.hasNext())
      {
        wkv localwkv = (wkv)paramwqh.next();
        yck.a(paramyck).put(localwkv.a, localwkv);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wqh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yco
 * JD-Core Version:    0.7.0.1
 */