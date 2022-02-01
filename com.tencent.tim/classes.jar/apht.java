import android.os.Bundle;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

public class apht
  implements aprb.a
{
  public apht(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.this$0.bF();
    if ((paramJSONObject != null) && (paramJSONObject.has("retcode")))
    {
      paramInt = paramJSONObject.optInt("retcode");
      if (paramInt == 0) {
        this.this$0.dZH();
      }
    }
    else
    {
      return;
    }
    if (paramInt == 111000)
    {
      QQToast.a(this.this$0.getActivity(), 2131699656, 0).show();
      return;
    }
    QQToast.a(this.this$0.getActivity(), 2131699716, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apht
 * JD-Core Version:    0.7.0.1
 */