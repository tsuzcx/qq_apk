import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.tips.ComicTipsBar.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.comic.VipComicJumpActivity;
import org.json.JSONObject;

public class yib
  implements View.OnClickListener
{
  yib(yia paramyia, View paramView) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject;
    if (this.a.bmK) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("from", "19");
      label27:
      Intent localIntent = new Intent(this.a.mActivity, VipComicJumpActivity.class);
      localIntent.putExtra("options", localJSONObject.toString());
      this.a.mActivity.startActivity(localIntent);
      this.xI.postDelayed(new ComicTipsBar.1.1(this), 2500L);
      if (this.a.bmK) {
        avdb.a(this.a.mApp, "3009", "2", "40039", this.a.aYg, new String[0]);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.a.mActivity.finish();
        break;
        avdb.a(this.a.mApp, "3006", "2", "40025", this.a.aYg, new String[] { "2" });
      }
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yib
 * JD-Core Version:    0.7.0.1
 */