import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class kiy
  implements CompoundButton.OnCheckedChangeListener
{
  public kiy(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      odj.ux(i);
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        i = j;
      }
      try
      {
        for (;;)
        {
          localJSONObject.put("click_opt", i);
          kbp.a(null, "", "0X800A80B", "0X800A80B", 0, 0, "", "", "", localJSONObject.toString(), false);
          EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
          return;
          i = 1;
          break;
          i = 2;
        }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kiy
 * JD-Core Version:    0.7.0.1
 */