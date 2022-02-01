import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.WpsFileEditToastStyleDlg;

public class aufv
  implements View.OnClickListener
{
  public aufv(WpsFileEditToastStyleDlg paramWpsFileEditToastStyleDlg) {}
  
  public void onClick(View paramView)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface))) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      auen.bl((QQAppInterface)localObject, "0X8008B7E");
      localObject = new Intent();
      ((Intent)localObject).setClass(this.this$0, SplashActivity.class);
      ((Intent)localObject).setFlags(67108864);
      ((Intent)localObject).putExtra("tab_index", 5);
      ((Intent)localObject).putExtra("fragment_id", 1);
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_guide_type", 6);
      ((Intent)localObject).putExtra("key_frame_bundle", localBundle);
      this.this$0.startActivity((Intent)localObject);
      this.this$0.overridePendingTransition(0, 0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufv
 * JD-Core Version:    0.7.0.1
 */