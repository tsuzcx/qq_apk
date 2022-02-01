import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class xni
  extends QQUIEventReceiver<xmx, wqh>
{
  public xni(@NonNull xmx paramxmx)
  {
    super(paramxmx);
  }
  
  public void a(@NonNull xmx paramxmx, @NonNull wqh paramwqh)
  {
    if ((paramwqh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwqh.jdField_a_of_type_JavaUtilList != null) && (paramxmx.a != null))
    {
      paramwqh = paramwqh.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwqh.hasNext())
      {
        wkv localwkv = (wkv)paramwqh.next();
        if (TextUtils.equals(paramxmx.a.b, localwkv.a)) {
          paramxmx.i();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wqh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xni
 * JD-Core Version:    0.7.0.1
 */