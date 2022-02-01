import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class xnq
  extends wag<xnp, wqr>
{
  public xnq(xnp paramxnp)
  {
    super(paramxnp);
  }
  
  public void a(@NonNull xnp paramxnp, @NonNull wqr paramwqr)
  {
    if ((xnp.a(paramxnp) != null) && (paramwqr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwqr.jdField_a_of_type_JavaUtilList.contains(xnp.a(paramxnp).a)))
    {
      ykq.a("CaptureTogetherBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramwqr.b.toString());
      paramxnp.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wqr.class;
  }
  
  public void b(@NonNull xnp paramxnp, @NonNull wqr paramwqr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnq
 * JD-Core Version:    0.7.0.1
 */