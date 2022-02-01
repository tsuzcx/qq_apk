import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.comic.VipComicJumpActivity;
import org.json.JSONObject;

class aaib
  implements View.OnClickListener
{
  aaib(aahb paramaahb, String paramString) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("from", "20");
      label17:
      Intent localIntent = new Intent(aahb.a(this.this$0), VipComicJumpActivity.class);
      localIntent.putExtra("options", localJSONObject.toString());
      aahb.a(this.this$0).startActivity(localIntent);
      avdb.a(aahb.a(this.this$0).getAppInterface(), "100007", "2", "40040", this.bdg, new String[0]);
      anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 2, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaib
 * JD-Core Version:    0.7.0.1
 */