import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class tuk
  extends sgl<tuj, sxf>
{
  public tuk(tuj paramtuj)
  {
    super(paramtuj);
  }
  
  public void a(@NonNull tuj paramtuj, @NonNull sxf paramsxf)
  {
    if ((tuj.a(paramtuj) != null) && (paramsxf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramsxf.jdField_a_of_type_JavaUtilList.contains(tuj.a(paramtuj).a)))
    {
      urk.a("CaptureTogetherBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramsxf.b.toString());
      paramtuj.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return sxf.class;
  }
  
  public void b(@NonNull tuj paramtuj, @NonNull sxf paramsxf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuk
 * JD-Core Version:    0.7.0.1
 */