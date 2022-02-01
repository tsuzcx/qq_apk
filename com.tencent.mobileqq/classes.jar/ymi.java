import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class ymi
  extends QQUIEventReceiver<yme, wzw>
{
  public ymi(@NonNull yme paramyme)
  {
    super(paramyme);
  }
  
  public void a(@NonNull yme paramyme, @NonNull wzw paramwzw)
  {
    yuk.a(this.TAG, "receive feature event. %s.", paramwzw.toString());
    if ((paramwzw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwzw.jdField_a_of_type_JavaUtilList != null))
    {
      paramwzw = paramwzw.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwzw.hasNext())
      {
        wuk localwuk = (wuk)paramwzw.next();
        yme.a(paramyme).put(localwuk.a, localwuk);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wzw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymi
 * JD-Core Version:    0.7.0.1
 */