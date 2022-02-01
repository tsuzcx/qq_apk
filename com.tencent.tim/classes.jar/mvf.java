import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class mvf
  implements View.OnClickListener
{
  mvf(mve parammve) {}
  
  public void onClick(View paramView)
  {
    muj.a(mve.a(this.a), mve.a(this.a).b);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", mve.a(this.a).getCurrentAccountUin());
      label45:
      kbp.a(null, null, "0X8009BF2", "0X8009BF2", 0, 0, "", "", "", kct.a(null, null, mve.a(this.a).a.d.vid, mve.a(this.a).a.d.Wz, localJSONObject), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvf
 * JD-Core Version:    0.7.0.1
 */