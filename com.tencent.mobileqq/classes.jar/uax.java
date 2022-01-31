import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uax
  extends QQUIEventReceiver<uau, tli>
{
  public uax(@NonNull uau paramuau)
  {
    super(paramuau);
  }
  
  public void a(@NonNull uau paramuau, @NonNull tli paramtli)
  {
    if ((paramtli.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramtli.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (uau.b(paramuau))
    {
      uau.b(paramuau, true);
      ved.b("VideoCoverListGroupHolder", "base info return , notify list while idle");
      return;
    }
    paramuau.d();
    ved.b("VideoCoverListGroupHolder", "base info return , notify list now");
  }
  
  public Class acceptEventClass()
  {
    return tli.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uax
 * JD-Core Version:    0.7.0.1
 */