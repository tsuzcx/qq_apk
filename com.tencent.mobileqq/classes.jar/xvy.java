import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class xvy
  extends JobSegment<String, xwc>
{
  private wsp jdField_a_of_type_Wsp = new wsp();
  
  public xvy(xvx paramxvx, @NonNull String paramString)
  {
    this.jdField_a_of_type_Wsp.a = new ArrayList();
    paramxvx = new ycc(paramString, 0, "", "");
    this.jdField_a_of_type_Wsp.a.add(paramxvx);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    wfi.a().a(this.jdField_a_of_type_Wsp, new xvz(this, paramJobContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvy
 * JD-Core Version:    0.7.0.1
 */