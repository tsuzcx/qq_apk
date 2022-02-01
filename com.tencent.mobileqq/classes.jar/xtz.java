import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class xtz
  extends QQUIEventReceiver<xts, wwb>
{
  public xtz(@NonNull xts paramxts)
  {
    super(paramxts);
  }
  
  public void a(@NonNull xts paramxts, @NonNull wwb paramwwb)
  {
    if ((paramwwb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwwb.jdField_a_of_type_JavaUtilList != null) && (paramxts.a != null))
    {
      paramwwb = paramwwb.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwwb.hasNext())
      {
        wqp localwqp = (wqp)paramwwb.next();
        if (TextUtils.equals(paramxts.a.b, localwqp.a)) {
          paramxts.i();
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
 * Qualified Name:     xtz
 * JD-Core Version:    0.7.0.1
 */