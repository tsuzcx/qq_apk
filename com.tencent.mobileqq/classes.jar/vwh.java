import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class vwh
  extends uhw<vvy, uyq>
{
  public vwh(vvy paramvvy)
  {
    super(paramvvy);
  }
  
  public void a(@NonNull vvy paramvvy, @NonNull uyq paramuyq)
  {
    if ((paramvvy.a != null) && (paramuyq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuyq.jdField_a_of_type_JavaUtilList.contains(paramvvy.a.a)))
    {
      wsv.a(this.TAG, "receive tag info change event. %s", paramuyq.toString());
      paramvvy.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uyq.class;
  }
  
  public void b(@NonNull vvy paramvvy, @NonNull uyq paramuyq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwh
 * JD-Core Version:    0.7.0.1
 */