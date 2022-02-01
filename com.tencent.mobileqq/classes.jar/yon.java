import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class yon
  extends xnj<xoe>
{
  public yon(@Nullable xnn paramxnn)
  {
    super(paramxnn);
  }
  
  protected JobSegment<xnm, xoe> a()
  {
    return new xnz();
  }
  
  protected JobSegment<Integer, xnm> a(xnl paramxnl)
  {
    return new yoo(paramxnl);
  }
  
  protected xoe a()
  {
    xnp localxnp = (xnp)vux.a(11);
    List localList = localxnp.b();
    xoe localxoe = new xoe(new ErrorMessage());
    localxoe.jdField_b_of_type_JavaUtilList = localxnp.b(localList);
    localxoe.jdField_b_of_type_Boolean = true;
    localxoe.a = localxoe.jdField_b_of_type_JavaUtilList.isEmpty();
    return localxoe;
  }
  
  protected xoe a(ErrorMessage paramErrorMessage)
  {
    return new xoe(paramErrorMessage);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((xnp)vux.a(11)).b(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yon
 * JD-Core Version:    0.7.0.1
 */