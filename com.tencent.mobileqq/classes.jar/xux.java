import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class xux
  extends QQUIEventReceiver<xui, wwb>
{
  public xux(@NonNull xui paramxui)
  {
    super(paramxui);
  }
  
  public void a(@NonNull xui paramxui, @NonNull wwb paramwwb)
  {
    if ((paramwwb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwwb.jdField_a_of_type_JavaUtilList != null) && (paramxui.a != null))
    {
      paramwwb = paramwwb.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwwb.hasNext())
      {
        wqp localwqp = (wqp)paramwwb.next();
        if (TextUtils.equals(paramxui.a.b, localwqp.a)) {
          paramxui.i();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wwb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xux
 * JD-Core Version:    0.7.0.1
 */