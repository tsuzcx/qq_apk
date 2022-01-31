import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class tvs
  extends QQUIEventReceiver<tvd, swv>
{
  public tvs(@NonNull tvd paramtvd)
  {
    super(paramtvd);
  }
  
  public void a(@NonNull tvd paramtvd, @NonNull swv paramswv)
  {
    if ((paramswv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramswv.jdField_a_of_type_JavaUtilList != null) && (paramtvd.a != null))
    {
      paramswv = paramswv.jdField_a_of_type_JavaUtilList.iterator();
      while (paramswv.hasNext())
      {
        srj localsrj = (srj)paramswv.next();
        if (TextUtils.equals(paramtvd.a.b, localsrj.a)) {
          paramtvd.i();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return swv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvs
 * JD-Core Version:    0.7.0.1
 */