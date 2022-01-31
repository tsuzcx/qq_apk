import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class uhp
  extends ste<uhg, tjy>
{
  public uhp(uhg paramuhg)
  {
    super(paramuhg);
  }
  
  public void a(@NonNull uhg paramuhg, @NonNull tjy paramtjy)
  {
    if ((paramuhg.a != null) && (paramtjy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjy.jdField_a_of_type_JavaUtilList.contains(paramuhg.a.a)))
    {
      ved.a(this.TAG, "receive tag info change event. %s", paramtjy.toString());
      paramuhg.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tjy.class;
  }
  
  public void b(@NonNull uhg paramuhg, @NonNull tjy paramtjy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhp
 * JD-Core Version:    0.7.0.1
 */