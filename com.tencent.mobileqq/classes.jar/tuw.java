import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class tuw
  extends sgl<tun, sxf>
{
  public tuw(tun paramtun)
  {
    super(paramtun);
  }
  
  public void a(@NonNull tun paramtun, @NonNull sxf paramsxf)
  {
    if ((paramtun.a != null) && (paramsxf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramsxf.jdField_a_of_type_JavaUtilList.contains(paramtun.a.a)))
    {
      urk.a(this.TAG, "receive tag info change event. %s", paramsxf.toString());
      paramtun.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return sxf.class;
  }
  
  public void b(@NonNull tun paramtun, @NonNull sxf paramsxf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuw
 * JD-Core Version:    0.7.0.1
 */