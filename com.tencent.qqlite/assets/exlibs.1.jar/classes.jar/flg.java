import android.app.Activity;
import android.view.View;
import com.tencent.widget.FadeIconImageView;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.FavoriteActionSheet;
import cooperation.qqfav.widget.FavoriteActionSheet.Actions;
import cooperation.qqfav.widget.LocationDetailActivity;
import mqq.app.AppRuntime;

public class flg
  extends FavoriteActionSheet
{
  public flg(LocationDetailActivity paramLocationDetailActivity, Activity paramActivity, FavoriteActionSheet.Actions paramActions, int paramInt1, int paramInt2, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    super(paramActivity, paramActions, paramInt1, paramInt2, paramAppRuntime, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (LocationDetailActivity.a(this.a))
    {
      QfavUtil.a(true);
      if (LocationDetailActivity.a(this.a) != null) {
        LocationDetailActivity.a(this.a).setVisibility(8);
      }
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     flg
 * JD-Core Version:    0.7.0.1
 */