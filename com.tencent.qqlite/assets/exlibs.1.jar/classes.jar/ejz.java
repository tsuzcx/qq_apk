import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class ejz
  implements View.OnClickListener
{
  public ejz(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296440)
    {
      paramView = (ActionSheet)ActionSheetHelper.a(this.a, null);
      paramView.a(2131363947, 3);
      paramView.d(2131362790);
      paramView.a(new eka(this, paramView));
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ejz
 * JD-Core Version:    0.7.0.1
 */