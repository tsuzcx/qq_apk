import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class vxd
  extends QQUIEventReceiver<vwo, uyg>
{
  public vxd(@NonNull vwo paramvwo)
  {
    super(paramvwo);
  }
  
  public void a(@NonNull vwo paramvwo, @NonNull uyg paramuyg)
  {
    if ((paramuyg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuyg.jdField_a_of_type_JavaUtilList != null) && (paramvwo.a != null))
    {
      paramuyg = paramuyg.jdField_a_of_type_JavaUtilList.iterator();
      while (paramuyg.hasNext())
      {
        usu localusu = (usu)paramuyg.next();
        if (TextUtils.equals(paramvwo.a.b, localusu.a)) {
          paramvwo.i();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return uyg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxd
 * JD-Core Version:    0.7.0.1
 */