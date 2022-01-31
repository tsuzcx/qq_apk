import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class uwe
  extends QQUIEventReceiver<uwa, tjr>
{
  public uwe(@NonNull uwa paramuwa)
  {
    super(paramuwa);
  }
  
  public void a(@NonNull uwa paramuwa, @NonNull tjr paramtjr)
  {
    veg.a(this.TAG, "receive feature event. %s.", paramtjr.toString());
    if ((paramtjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjr.jdField_a_of_type_JavaUtilList != null))
    {
      paramtjr = paramtjr.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtjr.hasNext())
      {
        tef localtef = (tef)paramtjr.next();
        uwa.a(paramuwa).put(localtef.a, localtef);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tjr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwe
 * JD-Core Version:    0.7.0.1
 */