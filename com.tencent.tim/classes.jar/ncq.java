import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.widget.HorizontalListView.d;
import org.json.JSONException;
import org.json.JSONObject;

public class ncq
  implements HorizontalListView.d
{
  public ncq(ChannelClassificationListView paramChannelClassificationListView) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    JSONObject localJSONObject;
    if (paramInt == 4098) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("channelid", ChannelClassificationListView.a(this.b));
      kbp.a(null, kxm.getLongAccountUin() + "", "0X8009934", "0X8009934", 0, 0, "", "", "", localJSONObject.toString(), false);
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
 * Qualified Name:     ncq
 * JD-Core Version:    0.7.0.1
 */