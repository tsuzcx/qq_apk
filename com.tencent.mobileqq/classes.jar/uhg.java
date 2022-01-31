import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class uhg
  extends sth<uhf, tkb>
{
  public uhg(uhf paramuhf)
  {
    super(paramuhf);
  }
  
  public void a(@NonNull uhf paramuhf, @NonNull tkb paramtkb)
  {
    if ((uhf.a(paramuhf) != null) && (paramtkb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkb.jdField_a_of_type_JavaUtilList.contains(uhf.a(paramuhf).a)))
    {
      veg.a("CaptureTogetherBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramtkb.b.toString());
      paramuhf.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkb.class;
  }
  
  public void b(@NonNull uhf paramuhf, @NonNull tkb paramtkb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhg
 * JD-Core Version:    0.7.0.1
 */