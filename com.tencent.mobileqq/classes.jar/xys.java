import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class xys
  extends QQUIEventReceiver<xyd, wzw>
{
  public xys(@NonNull xyd paramxyd)
  {
    super(paramxyd);
  }
  
  public void a(@NonNull xyd paramxyd, @NonNull wzw paramwzw)
  {
    if ((paramwzw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwzw.jdField_a_of_type_JavaUtilList != null) && (paramxyd.a != null))
    {
      paramwzw = paramwzw.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwzw.hasNext())
      {
        wuk localwuk = (wuk)paramwzw.next();
        if (TextUtils.equals(paramxyd.a.b, localwuk.a)) {
          paramxyd.i();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wzw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xys
 * JD-Core Version:    0.7.0.1
 */