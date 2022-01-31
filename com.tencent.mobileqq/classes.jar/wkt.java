import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class wkt
  extends QQUIEventReceiver<wkp, uyg>
{
  public wkt(@NonNull wkp paramwkp)
  {
    super(paramwkp);
  }
  
  public void a(@NonNull wkp paramwkp, @NonNull uyg paramuyg)
  {
    wsv.a(this.TAG, "receive feature event. %s.", paramuyg.toString());
    if ((paramuyg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuyg.jdField_a_of_type_JavaUtilList != null))
    {
      paramuyg = paramuyg.jdField_a_of_type_JavaUtilList.iterator();
      while (paramuyg.hasNext())
      {
        usu localusu = (usu)paramuyg.next();
        wkp.a(paramwkp).put(localusu.a, localusu);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return uyg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkt
 * JD-Core Version:    0.7.0.1
 */