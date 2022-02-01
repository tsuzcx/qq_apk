import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class xaz
  extends vll<xax, wbw>
{
  public xaz(xax paramxax)
  {
    super(paramxax);
  }
  
  public void a(@NonNull xax paramxax, @NonNull wbw paramwbw)
  {
    if ((xax.a(paramxax) != null) && (paramwbw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwbw.jdField_a_of_type_JavaUtilList.contains(xax.a(paramxax).a)))
    {
      xvv.a("WeiShiFlowBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramwbw.b.toString());
      paramxax.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wbw.class;
  }
  
  public void b(@NonNull xax paramxax, @NonNull wbw paramwbw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xaz
 * JD-Core Version:    0.7.0.1
 */