import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDManualGuideActivity;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

public class coz
  implements View.OnClickListener
{
  public coz(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131231746: 
    case 2131231747: 
    case 2131231750: 
    case 2131231751: 
    default: 
      return;
    case 2131231745: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.b.a(), 20);
      this.a.a();
      return;
    case 2131231749: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.b.a(), 21);
      this.a.a();
      return;
    case 2131231748: 
      paramView = new Intent(this.a, GesturePWDManualGuideActivity.class);
      this.a.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a, GesturePWDCreateActivity.class);
    this.a.startActivityForResult(paramView, 11);
    this.a.overridePendingTransition(2130968598, 2130968595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     coz
 * JD-Core Version:    0.7.0.1
 */