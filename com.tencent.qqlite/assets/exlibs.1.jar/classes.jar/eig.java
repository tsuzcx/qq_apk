import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;

public class eig
  extends FriendListObserver
{
  public eig(NearbyTroopsView paramNearbyTroopsView) {}
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (!this.a.d)) {
      return;
    }
    this.a.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eig
 * JD-Core Version:    0.7.0.1
 */