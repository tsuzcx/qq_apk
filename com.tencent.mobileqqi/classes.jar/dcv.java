import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.activity.NearPeopleActivity;

public class dcv
  implements Runnable
{
  public dcv(NearPeopleActivity paramNearPeopleActivity) {}
  
  public void run()
  {
    if (HtmlOffline.a(NearPeopleActivity.a(this.a)) == null) {
      HtmlOffline.a(this.a.a, NearPeopleActivity.b(this.a), this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dcv
 * JD-Core Version:    0.7.0.1
 */