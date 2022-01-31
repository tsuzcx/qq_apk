import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qqfav.widget.FavoriteActionSheet.DefaultActions;
import cooperation.qqfav.widget.LocationDetailActivity;
import java.lang.ref.WeakReference;

public class igi
  extends FavoriteActionSheet.DefaultActions
{
  private WeakReference a;
  
  public igi(LocationDetailActivity paramLocationDetailActivity)
  {
    this.a = new WeakReference(paramLocationDetailActivity);
  }
  
  public void a()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    if ((localLocationDetailActivity.s != null) && (localLocationDetailActivity.t != null))
    {
      Intent localIntent = LocationDetailActivity.a(localLocationDetailActivity);
      localIntent.setClass(localLocationDetailActivity, ForwardRecentActivity.class);
      localIntent.putExtra("forward_type", -2).putExtra("forward_latitude", localLocationDetailActivity.d).putExtra("forward_longitude", localLocationDetailActivity.e).putExtra("forward_location", localLocationDetailActivity.p).putExtra("forward_location_string", localLocationDetailActivity.p).putExtra("forward_thumb", AppConstants.aM + localLocationDetailActivity.s + "_" + localLocationDetailActivity.t + ".png").putExtra("isFromFavorites", true).putExtra("title", localLocationDetailActivity.o).putExtra("summary", localLocationDetailActivity.p);
      localLocationDetailActivity.startActivityForResult(localIntent, 103);
      return;
    }
    QQToast.a(localLocationDetailActivity, 2131560787, 1, 2000).b(5);
  }
  
  public void a(String paramString)
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {}
    while (localLocationDetailActivity.getString(2131560818).compareTo(paramString) != 0) {
      return;
    }
    LocationDetailActivity.a(localLocationDetailActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     igi
 * JD-Core Version:    0.7.0.1
 */