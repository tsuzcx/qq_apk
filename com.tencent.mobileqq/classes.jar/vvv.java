import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class vvv
  extends uhw<vvu, uyq>
{
  public vvv(vvu paramvvu)
  {
    super(paramvvu);
  }
  
  public void a(@NonNull vvu paramvvu, @NonNull uyq paramuyq)
  {
    if ((vvu.a(paramvvu) != null) && (paramuyq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuyq.jdField_a_of_type_JavaUtilList.contains(vvu.a(paramvvu).a)))
    {
      wsv.a("CaptureTogetherBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramuyq.b.toString());
      paramvvu.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uyq.class;
  }
  
  public void b(@NonNull vvu paramvvu, @NonNull uyq paramuyq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvv
 * JD-Core Version:    0.7.0.1
 */