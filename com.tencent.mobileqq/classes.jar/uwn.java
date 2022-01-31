import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class uwn
  extends uvr<uwm>
{
  public uwn(@Nullable uvv paramuvv)
  {
    super(paramuvv);
  }
  
  protected JobSegment<uvu, uwm> a()
  {
    return new uwh();
  }
  
  protected JobSegment<Integer, uvu> a(uvt paramuvt)
  {
    return new uwo(paramuvt, this.a);
  }
  
  protected uwm a()
  {
    uvx localuvx = (uvx)tcz.a(11);
    List localList = localuvx.a();
    uwm localuwm = new uwm(new ErrorMessage());
    localuwm.jdField_b_of_type_JavaUtilList = localuvx.b(localList);
    localuwm.jdField_b_of_type_Boolean = true;
    localuwm.a = localuwm.jdField_b_of_type_JavaUtilList.isEmpty();
    return localuwm;
  }
  
  protected uwm a(ErrorMessage paramErrorMessage)
  {
    return new uwm(paramErrorMessage);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((uvx)tcz.a(11)).a(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwn
 * JD-Core Version:    0.7.0.1
 */