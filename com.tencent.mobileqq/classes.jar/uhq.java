import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class uhq
  extends QQUIEventReceiver<uhj, tjr>
{
  public uhq(@NonNull uhj paramuhj)
  {
    super(paramuhj);
  }
  
  public void a(@NonNull uhj paramuhj, @NonNull tjr paramtjr)
  {
    if ((paramtjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjr.jdField_a_of_type_JavaUtilList != null) && (paramuhj.a != null))
    {
      paramtjr = paramtjr.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtjr.hasNext())
      {
        tef localtef = (tef)paramtjr.next();
        if (TextUtils.equals(paramuhj.a.b, localtef.a)) {
          paramuhj.i();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tjr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhq
 * JD-Core Version:    0.7.0.1
 */