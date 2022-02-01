import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView.a;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class ncr
  implements View.OnClickListener
{
  public ncr(ChannelClassificationListView.a parama, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (ChannelClassificationListView.a(this.b.b) != null) {
      ChannelClassificationListView.a(this.b.b).onItemClick((AdapterView)this.val$parent, paramView, i, this.b.getItemId(i));
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("subchannelid", this.b.a(i).jq());
      localJSONObject.put("subchannelname", this.b.a(i).getName());
      localJSONObject.put("channelid", ChannelClassificationListView.a(this.b.b));
      kbp.a(null, kxm.getLongAccountUin() + "", "0X8009933", "0X8009933", 0, 0, "", "", "", localJSONObject.toString(), false);
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
 * Qualified Name:     ncr
 * JD-Core Version:    0.7.0.1
 */