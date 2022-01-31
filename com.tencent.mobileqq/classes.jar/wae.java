import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class wae
  extends umf<wad, vcz>
{
  public wae(wad paramwad)
  {
    super(paramwad);
  }
  
  public void a(@NonNull wad paramwad, @NonNull vcz paramvcz)
  {
    if ((wad.a(paramwad) != null) && (paramvcz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramvcz.jdField_a_of_type_JavaUtilList.contains(wad.a(paramwad).a)))
    {
      wxe.a("CaptureTogetherBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramvcz.b.toString());
      paramwad.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return vcz.class;
  }
  
  public void b(@NonNull wad paramwad, @NonNull vcz paramvcz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wae
 * JD-Core Version:    0.7.0.1
 */