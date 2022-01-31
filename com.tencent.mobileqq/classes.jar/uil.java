import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class uil
  extends QQUIEventReceiver<uhw, tjo>
{
  public uil(@NonNull uhw paramuhw)
  {
    super(paramuhw);
  }
  
  public void a(@NonNull uhw paramuhw, @NonNull tjo paramtjo)
  {
    if ((paramtjo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjo.jdField_a_of_type_JavaUtilList != null) && (paramuhw.a != null))
    {
      paramtjo = paramtjo.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtjo.hasNext())
      {
        tec localtec = (tec)paramtjo.next();
        if (TextUtils.equals(paramuhw.a.b, localtec.a)) {
          paramuhw.i();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tjo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uil
 * JD-Core Version:    0.7.0.1
 */