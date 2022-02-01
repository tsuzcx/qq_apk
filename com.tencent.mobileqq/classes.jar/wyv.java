import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class wyv
  extends vll<wyu, wbw>
{
  public wyv(wyu paramwyu)
  {
    super(paramwyu);
  }
  
  public void a(@NonNull wyu paramwyu, @NonNull wbw paramwbw)
  {
    if ((wyu.a(paramwyu) != null) && (paramwbw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwbw.jdField_a_of_type_JavaUtilList.contains(wyu.a(paramwyu).a)))
    {
      xvv.a("CaptureTogetherBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramwbw.b.toString());
      paramwyu.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wbw.class;
  }
  
  public void b(@NonNull wyu paramwyu, @NonNull wbw paramwbw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyv
 * JD-Core Version:    0.7.0.1
 */