import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class elk
  implements View.OnClickListener
{
  public elk(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296443)
    {
      paramView = (ActionSheet)ActionSheetHelper.a(this.a, null, 2131624120);
      paramView.a(2131363947, 3);
      paramView.d(2131362801);
      paramView.a(new ell(this, paramView));
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     elk
 * JD-Core Version:    0.7.0.1
 */