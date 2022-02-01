import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class xtp
  extends wfr<xto, wwl>
{
  public xtp(xto paramxto)
  {
    super(paramxto);
  }
  
  public void a(@NonNull xto paramxto, @NonNull wwl paramwwl)
  {
    if ((xto.a(paramxto) != null) && (paramwwl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwwl.jdField_a_of_type_JavaUtilList.contains(xto.a(paramxto).a)))
    {
      yqp.a("CaptureTogetherBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramwwl.b.toString());
      paramxto.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wwl.class;
  }
  
  public void b(@NonNull xto paramxto, @NonNull wwl paramwwl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtp
 * JD-Core Version:    0.7.0.1
 */