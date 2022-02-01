import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class ybx
  extends JobSegment<String, ycb>
{
  private wyj jdField_a_of_type_Wyj = new wyj();
  
  public ybx(ybw paramybw, @NonNull String paramString)
  {
    this.jdField_a_of_type_Wyj.a = new ArrayList();
    paramybw = new yib(paramString, 0, "", "");
    this.jdField_a_of_type_Wyj.a.add(paramybw);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    wlb.a().a(this.jdField_a_of_type_Wyj, new yby(this, paramJobContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybx
 * JD-Core Version:    0.7.0.1
 */