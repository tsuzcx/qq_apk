import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class upl
  extends JobSegment<String, upp>
{
  private tlw jdField_a_of_type_Tlw = new tlw();
  
  public upl(upk paramupk, @NonNull String paramString)
  {
    this.jdField_a_of_type_Tlw.a = new ArrayList();
    paramupk = new uvp(paramString, 0, "", "");
    this.jdField_a_of_type_Tlw.a.add(paramupk);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    syo.a().a(this.jdField_a_of_type_Tlw, new upm(this, paramJobContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upl
 * JD-Core Version:    0.7.0.1
 */