import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class wyn
  extends QQUIEventReceiver<wyc, wbm>
{
  public wyn(@NonNull wyc paramwyc)
  {
    super(paramwyc);
  }
  
  public void a(@NonNull wyc paramwyc, @NonNull wbm paramwbm)
  {
    if ((paramwbm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwbm.jdField_a_of_type_JavaUtilList != null) && (paramwyc.a != null))
    {
      paramwbm = paramwbm.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwbm.hasNext())
      {
        vwa localvwa = (vwa)paramwbm.next();
        if (TextUtils.equals(paramwyc.a.b, localvwa.a)) {
          paramwyc.i();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wbm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyn
 * JD-Core Version:    0.7.0.1
 */