import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class mcq
  implements View.OnClickListener
{
  public mcq(ComponentJump paramComponentJump, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    kgw.a(this.b.getContext(), this.d.mChannelInfoId, this.d.mChannelInfoName, this.d.mChannelInfoType, 1);
    if (this.d.hasChannelInfo()) {
      i = this.d.mChannelInfoId;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feeds_channel_entrance", i);
      kbp.a(null, "CliOper", "", "", "0X8006DF3", "0X8006DF3", 0, 0, "", "", "", localJSONObject.toString(), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mcq
 * JD-Core Version:    0.7.0.1
 */