import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class ujk
  extends sth<uji, tkb>
{
  public ujk(uji paramuji)
  {
    super(paramuji);
  }
  
  public void a(@NonNull uji paramuji, @NonNull tkb paramtkb)
  {
    if ((uji.a(paramuji) != null) && (paramtkb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkb.jdField_a_of_type_JavaUtilList.contains(uji.a(paramuji).a)))
    {
      veg.a("WeiShiFlowBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramtkb.b.toString());
      paramuji.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkb.class;
  }
  
  public void b(@NonNull uji paramuji, @NonNull tkb paramtkb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujk
 * JD-Core Version:    0.7.0.1
 */