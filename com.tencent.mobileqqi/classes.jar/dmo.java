import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class dmo
  implements View.OnClickListener
{
  public dmo(SubAccountSettingActivity paramSubAccountSettingActivity) {}
  
  public void onClick(View paramView)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a.a(), null);
    switch (paramView.getId())
    {
    case 2131234576: 
    default: 
      return;
    case 2131234575: 
      localActionSheet.a(2131561668);
      localActionSheet.a(2131562539, 3);
      localActionSheet.d(2131561746);
      localActionSheet.a(new dmp(this, localActionSheet));
      localActionSheet.show();
      return;
    case 2131234577: 
      localActionSheet.a(2131561628);
      localActionSheet.a(2131561946, 3);
      localActionSheet.d(2131561746);
      localActionSheet.a(new dmq(this, localActionSheet));
      localActionSheet.show();
      return;
    }
    SubAccountAssistantForward.a(this.a.b, this.a.a(), this.a.b.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmo
 * JD-Core Version:    0.7.0.1
 */