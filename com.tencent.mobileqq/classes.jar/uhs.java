import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class uhs
  extends sth<uhj, tkb>
{
  public uhs(uhj paramuhj)
  {
    super(paramuhj);
  }
  
  public void a(@NonNull uhj paramuhj, @NonNull tkb paramtkb)
  {
    if ((paramuhj.a != null) && (paramtkb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkb.jdField_a_of_type_JavaUtilList.contains(paramuhj.a.a)))
    {
      veg.a(this.TAG, "receive tag info change event. %s", paramtkb.toString());
      paramuhj.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkb.class;
  }
  
  public void b(@NonNull uhj paramuhj, @NonNull tkb paramtkb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhs
 * JD-Core Version:    0.7.0.1
 */