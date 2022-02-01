import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

public class aphs
  implements aprb.a
{
  public aphs(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.this$0.bF();
    if ((paramJSONObject != null) && (paramJSONObject.has("retcode")))
    {
      paramInt = paramJSONObject.optInt("retcode");
      if (paramInt == 0)
      {
        QQToast.a(this.this$0.getActivity(), 2131699657, 0).show();
        paramJSONObject = wja.a(new Intent(this.this$0.getActivity(), SplashActivity.class), new int[] { 2 });
        paramJSONObject.addFlags(268435456);
        paramJSONObject.putExtra("uin", this.this$0.mTroopUin);
        paramJSONObject.putExtra("uintype", 1);
        this.this$0.getActivity().startActivity(paramJSONObject);
        this.this$0.getActivity().overridePendingTransition(2130772002, 2130772369);
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
 * Qualified Name:     aphs
 * JD-Core Version:    0.7.0.1
 */