import android.os.Bundle;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajss
  implements aprb.a
{
  public ajss(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null)
    {
      paramInt = paramJSONObject.optInt("retcode", -1);
      paramBundle = new ArrayList();
      if (paramInt == 0)
      {
        paramJSONObject = paramJSONObject.optJSONObject("data");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optJSONArray("rpt_board_items");
          if (paramJSONObject != null)
          {
            paramInt = 0;
            while (paramInt < paramJSONObject.length())
            {
              paramBundle.add(paramJSONObject.optJSONObject(paramInt).optString("uint64_uin"));
              paramInt += 1;
            }
          }
        }
      }
      this.this$0.a.a(this.this$0.OG, "" + this.this$0.adj, paramBundle, new ajst(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajss
 * JD-Core Version:    0.7.0.1
 */