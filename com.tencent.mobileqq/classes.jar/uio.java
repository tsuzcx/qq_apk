import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class uio
  extends QQUIEventReceiver<uhz, tjr>
{
  public uio(@NonNull uhz paramuhz)
  {
    super(paramuhz);
  }
  
  public void a(@NonNull uhz paramuhz, @NonNull tjr paramtjr)
  {
    if ((paramtjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjr.jdField_a_of_type_JavaUtilList != null) && (paramuhz.a != null))
    {
      paramtjr = paramtjr.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtjr.hasNext())
      {
        tef localtef = (tef)paramtjr.next();
        if (TextUtils.equals(paramuhz.a.b, localtef.a)) {
          paramuhz.i();
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
 * Qualified Name:     uio
 * JD-Core Version:    0.7.0.1
 */