import com.tencent.mobileqq.activity.NearPeopleActivity;
import com.tencent.mobileqq.app.NearHornHandler;

public class dda
  implements Runnable
{
  public dda(NearPeopleActivity paramNearPeopleActivity) {}
  
  public void run()
  {
    if (NearPeopleActivity.a(this.a) != null) {
      NearPeopleActivity.a(this.a).a("", Long.valueOf(0L), "1", NearPeopleActivity.c(this.a), Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dda
 * JD-Core Version:    0.7.0.1
 */