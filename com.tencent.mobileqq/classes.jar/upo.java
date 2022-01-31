import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class upo
  extends JobSegment<String, ups>
{
  private tlz jdField_a_of_type_Tlz = new tlz();
  
  public upo(upn paramupn, @NonNull String paramString)
  {
    this.jdField_a_of_type_Tlz.a = new ArrayList();
    paramupn = new uvs(paramString, 0, "", "");
    this.jdField_a_of_type_Tlz.a.add(paramupn);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    syr.a().a(this.jdField_a_of_type_Tlz, new upp(this, paramJobContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upo
 * JD-Core Version:    0.7.0.1
 */