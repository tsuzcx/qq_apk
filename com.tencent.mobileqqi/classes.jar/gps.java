import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;

public class gps
  extends FriendListObserver
{
  public gps(NearbyTroopsActivity paramNearbyTroopsActivity) {}
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (!this.a.b)) {
      return;
    }
    this.a.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gps
 * JD-Core Version:    0.7.0.1
 */