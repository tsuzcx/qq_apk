import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class wed
  extends JobSegment<String, weh>
{
  private vao jdField_a_of_type_Vao = new vao();
  
  public wed(wec paramwec, @NonNull String paramString)
  {
    this.jdField_a_of_type_Vao.a = new ArrayList();
    paramwec = new wkh(paramString, 0, "", "");
    this.jdField_a_of_type_Vao.a.add(paramwec);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    ung.a().a(this.jdField_a_of_type_Vao, new wee(this, paramJobContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wed
 * JD-Core Version:    0.7.0.1
 */