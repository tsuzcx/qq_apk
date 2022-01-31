import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class eke
  implements View.OnClickListener
{
  public eke(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296440)
    {
      paramView = (ActionSheet)ActionSheetHelper.a(this.a, null, 2131624119);
      paramView.a(2131363936, 3);
      paramView.d(2131362794);
      paramView.a(new ekf(this, paramView));
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eke
 * JD-Core Version:    0.7.0.1
 */