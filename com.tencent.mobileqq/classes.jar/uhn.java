import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class uhn
  extends QQUIEventReceiver<uhg, tjo>
{
  public uhn(@NonNull uhg paramuhg)
  {
    super(paramuhg);
  }
  
  public void a(@NonNull uhg paramuhg, @NonNull tjo paramtjo)
  {
    if ((paramtjo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjo.jdField_a_of_type_JavaUtilList != null) && (paramuhg.a != null))
    {
      paramtjo = paramtjo.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtjo.hasNext())
      {
        tec localtec = (tec)paramtjo.next();
        if (TextUtils.equals(paramuhg.a.b, localtec.a)) {
          paramuhg.i();
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
 * Qualified Name:     uhn
 * JD-Core Version:    0.7.0.1
 */