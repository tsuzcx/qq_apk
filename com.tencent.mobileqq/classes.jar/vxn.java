import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class vxn
  extends uvu<uwp>
{
  public vxn(@Nullable uvy paramuvy)
  {
    super(paramuvy);
  }
  
  protected JobSegment<uvx, uwp> a()
  {
    return new uwk();
  }
  
  protected JobSegment<Integer, uvx> a(uvw paramuvw)
  {
    return new vxo(paramuvw);
  }
  
  protected uwp a()
  {
    uwa localuwa = (uwa)tdc.a(11);
    List localList = localuwa.b();
    uwp localuwp = new uwp(new ErrorMessage());
    localuwp.jdField_b_of_type_JavaUtilList = localuwa.b(localList);
    localuwp.jdField_b_of_type_Boolean = true;
    localuwp.a = localuwp.jdField_b_of_type_JavaUtilList.isEmpty();
    return localuwp;
  }
  
  protected uwp a(ErrorMessage paramErrorMessage)
  {
    return new uwp(paramErrorMessage);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((uwa)tdc.a(11)).b(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxn
 * JD-Core Version:    0.7.0.1
 */