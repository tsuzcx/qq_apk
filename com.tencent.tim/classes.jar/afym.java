import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class afym
  implements View.OnClickListener
{
  afym(Context paramContext, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.val$context, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://ti.qq.com/extend-friend/?_wv=536870912");
    this.val$context.startActivity(localIntent);
    anot.a(null, "dc00898", "", "", "kuolie", "0X80097DE", 0, 0, "", "", "", "");
    if ((this.ap != null) && (this.ap.isShowing())) {
      this.ap.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afym
 * JD-Core Version:    0.7.0.1
 */