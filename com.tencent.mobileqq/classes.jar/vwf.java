import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class vwf
  extends QQUIEventReceiver<vvy, uyg>
{
  public vwf(@NonNull vvy paramvvy)
  {
    super(paramvvy);
  }
  
  public void a(@NonNull vvy paramvvy, @NonNull uyg paramuyg)
  {
    if ((paramuyg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuyg.jdField_a_of_type_JavaUtilList != null) && (paramvvy.a != null))
    {
      paramuyg = paramuyg.jdField_a_of_type_JavaUtilList.iterator();
      while (paramuyg.hasNext())
      {
        usu localusu = (usu)paramuyg.next();
        if (TextUtils.equals(paramvvy.a.b, localusu.a)) {
          paramvvy.i();
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
 * Qualified Name:     vwf
 * JD-Core Version:    0.7.0.1
 */