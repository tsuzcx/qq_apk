import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class jto
  implements View.OnClickListener
{
  jto(jtg paramjtg, int paramInt, String paramString, jts paramjts) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject;
    if (this.aBm == 1)
    {
      if ((!TextUtils.isEmpty(this.val$jumpUrl)) && (this.this$0.a != null)) {
        this.this$0.a.lp(this.val$jumpUrl);
      }
      anot.a(this.this$0.app, "dc00899", "Pb_account_lifeservice", this.this$0.uin, "0X8006981", "0X8006981", 0, 0, String.valueOf(this.a.a.qJ), String.valueOf(this.a.a.qK), String.valueOf(this.a.a.msgtype), String.valueOf(this.a.a.aDr));
      localJSONObject = new JSONObject();
      if (this.this$0.abF) {}
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("cha_1", this.a.a.rowkey);
        localJSONObject.put("cha_2", jtg.a(this.this$0));
        QQAppInterface localQQAppInterface = this.this$0.app;
        String str2 = this.this$0.uin;
        int i = this.a.a.msgtype;
        long l = this.a.a.qJ;
        if (this.this$0.b.followType != 1) {
          continue;
        }
        str1 = "02";
        anot.a(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str2, "0X80077FA", "0X80077FA", 0, 0, String.valueOf(i), String.valueOf(l), str1, localJSONObject.toString());
      }
      catch (JSONException localJSONException)
      {
        String str1;
        localJSONException.printStackTrace();
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.aBm != 2) || (this.this$0.a == null)) {
        break;
      }
      this.this$0.a.a(this.a);
      break;
      str1 = "01";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jto
 * JD-Core Version:    0.7.0.1
 */