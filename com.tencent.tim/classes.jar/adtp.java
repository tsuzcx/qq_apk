import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ark.setting.ArkAppListActivity;
import com.tencent.mobileqq.ark.setting.ArkAuthorityInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adtp
  implements View.OnClickListener
{
  public adtp(ArkAppListActivity paramArkAppListActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, ArkAuthorityInfoActivity.class);
    localIntent.putExtra("intent_extra_authority_app_name", this.bvx);
    this.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adtp
 * JD-Core Version:    0.7.0.1
 */