import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class wim
  extends JobSegment<String, wiq>
{
  private vex jdField_a_of_type_Vex = new vex();
  
  public wim(wil paramwil, @NonNull String paramString)
  {
    this.jdField_a_of_type_Vex.a = new ArrayList();
    paramwil = new woq(paramString, 0, "", "");
    this.jdField_a_of_type_Vex.a.add(paramwil);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    urp.a().a(this.jdField_a_of_type_Vex, new win(this, paramJobContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wim
 * JD-Core Version:    0.7.0.1
 */