import com.tencent.mobileqq.activity.NearPeopleActivity;
import com.tencent.mobileqq.app.NearHornHandler;

public class cxj
  implements Runnable
{
  public cxj(NearPeopleActivity paramNearPeopleActivity) {}
  
  public void run()
  {
    if (NearPeopleActivity.a(this.a) != null) {
      NearPeopleActivity.a(this.a).a("", Long.valueOf(0L), "1", NearPeopleActivity.c(this.a), Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cxj
 * JD-Core Version:    0.7.0.1
 */