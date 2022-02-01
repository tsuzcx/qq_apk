import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class xxu
  extends QQUIEventReceiver<xxn, wzw>
{
  public xxu(@NonNull xxn paramxxn)
  {
    super(paramxxn);
  }
  
  public void a(@NonNull xxn paramxxn, @NonNull wzw paramwzw)
  {
    if ((paramwzw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwzw.jdField_a_of_type_JavaUtilList != null) && (paramxxn.a != null))
    {
      paramwzw = paramwzw.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwzw.hasNext())
      {
        wuk localwuk = (wuk)paramwzw.next();
        if (TextUtils.equals(paramxxn.a.b, localwuk.a)) {
          paramxxn.i();
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
 * Qualified Name:     xxu
 * JD-Core Version:    0.7.0.1
 */