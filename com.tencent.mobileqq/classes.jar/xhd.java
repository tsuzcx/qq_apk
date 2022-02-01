import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class xhd
  extends JobSegment<String, xhh>
{
  private wdu jdField_a_of_type_Wdu = new wdu();
  
  public xhd(xhc paramxhc, @NonNull String paramString)
  {
    this.jdField_a_of_type_Wdu.a = new ArrayList();
    paramxhc = new xnh(paramString, 0, "", "");
    this.jdField_a_of_type_Wdu.a.add(paramxhc);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    vqn.a().a(this.jdField_a_of_type_Wdu, new xhe(this, paramJobContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhd
 * JD-Core Version:    0.7.0.1
 */