import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class yfs
  extends JobSegment<String, yfw>
{
  private xce jdField_a_of_type_Xce = new xce();
  
  public yfs(yfr paramyfr, @NonNull String paramString)
  {
    this.jdField_a_of_type_Xce.a = new ArrayList();
    paramyfr = new ylw(paramString, 0, "", "");
    this.jdField_a_of_type_Xce.a.add(paramyfr);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    wow.a().a(this.jdField_a_of_type_Xce, new yft(this, paramJobContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfs
 * JD-Core Version:    0.7.0.1
 */