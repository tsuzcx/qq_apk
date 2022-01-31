import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class ucs
  extends JobSegment<String, ucw>
{
  private szd jdField_a_of_type_Szd = new szd();
  
  public ucs(ucr paramucr, @NonNull String paramString)
  {
    this.jdField_a_of_type_Szd.a = new ArrayList();
    paramucr = new uiw(paramString, 0, "", "");
    this.jdField_a_of_type_Szd.a.add(paramucr);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    slv.a().a(this.jdField_a_of_type_Szd, new uct(this, paramJobContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucs
 * JD-Core Version:    0.7.0.1
 */