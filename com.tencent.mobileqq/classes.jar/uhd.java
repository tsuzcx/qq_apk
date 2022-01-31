import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class uhd
  extends ste<uhc, tjy>
{
  public uhd(uhc paramuhc)
  {
    super(paramuhc);
  }
  
  public void a(@NonNull uhc paramuhc, @NonNull tjy paramtjy)
  {
    if ((uhc.a(paramuhc) != null) && (paramtjy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjy.jdField_a_of_type_JavaUtilList.contains(uhc.a(paramuhc).a)))
    {
      ved.a("CaptureTogetherBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramtjy.b.toString());
      paramuhc.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tjy.class;
  }
  
  public void b(@NonNull uhc paramuhc, @NonNull tjy paramtjy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhd
 * JD-Core Version:    0.7.0.1
 */