import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class tuc
  extends QQUIEventReceiver<ttr, swv>
{
  public tuc(@NonNull ttr paramttr)
  {
    super(paramttr);
  }
  
  public void a(@NonNull ttr paramttr, @NonNull swv paramswv)
  {
    if ((paramswv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramswv.jdField_a_of_type_JavaUtilList != null) && (paramttr.a != null))
    {
      paramswv = paramswv.jdField_a_of_type_JavaUtilList.iterator();
      while (paramswv.hasNext())
      {
        srj localsrj = (srj)paramswv.next();
        if (TextUtils.equals(paramttr.a.b, localsrj.a)) {
          paramttr.i();
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
 * Qualified Name:     tuc
 * JD-Core Version:    0.7.0.1
 */