import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adsh
  implements View.OnClickListener
{
  public adsh(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    ausj localausj = (ausj)auss.a(BaseActivity.sTopActivity, null);
    localausj.setMainTitle(BaseActivity.sTopActivity.getString(2131690497));
    localausj.addButton(2131690496, 3);
    localausj.addCancelButton(2131690495);
    localausj.setOnDismissListener(new adsi(this, localausj));
    localausj.a(new adsj(this, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsh
 * JD-Core Version:    0.7.0.1
 */