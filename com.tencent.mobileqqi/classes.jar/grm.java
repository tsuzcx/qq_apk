import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class grm
  implements View.OnClickListener
{
  public grm(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131230986)
    {
      paramView = (ActionSheet)ActionSheetHelper.a(this.a, null);
      paramView.a(2131561928, 3);
      paramView.d(2131561746);
      paramView.a(new grn(this, paramView));
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     grm
 * JD-Core Version:    0.7.0.1
 */