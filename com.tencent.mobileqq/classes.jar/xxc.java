import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class xxc
  extends QQUIEventReceiver<xwr, wzw>
{
  public xxc(@NonNull xwr paramxwr)
  {
    super(paramxwr);
  }
  
  public void a(@NonNull xwr paramxwr, @NonNull wzw paramwzw)
  {
    if ((paramwzw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwzw.jdField_a_of_type_JavaUtilList != null) && (paramxwr.a != null))
    {
      paramwzw = paramwzw.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwzw.hasNext())
      {
        wuk localwuk = (wuk)paramwzw.next();
        if (TextUtils.equals(paramxwr.a.b, localwuk.a)) {
          paramxwr.i();
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
 * Qualified Name:     xxc
 * JD-Core Version:    0.7.0.1
 */