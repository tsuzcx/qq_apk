import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.FavOpenTroopActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class gpp
  implements View.OnClickListener
{
  public gpp(FavOpenTroopActivity paramFavOpenTroopActivity) {}
  
  public void onClick(View paramView)
  {
    if ((FavOpenTroopActivity.a(this.a) != null) && (FavOpenTroopActivity.a(this.a).isShowing())) {
      FavOpenTroopActivity.a(this.a).dismiss();
    }
    if (this.a.a != null) {
      this.a.a.b();
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gpp
 * JD-Core Version:    0.7.0.1
 */