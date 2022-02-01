import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class xdm
  extends ClickableSpan
{
  xdm(xci paramxci) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j;
    if ((this.this$0.mContext instanceof Activity))
    {
      if (this.this$0.sessionInfo.cZ != 0) {
        break label225;
      }
      j = 0;
    }
    for (;;)
    {
      paramView = new JSONObject();
      try
      {
        paramView.put("recv_uin", this.this$0.sessionInfo.aTl);
        paramView.put("recv_nick", this.this$0.sessionInfo.aTn);
        if (j > 0) {
          paramView.put("people_num", j);
        }
        paramView.put("recv_type", i);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Intent localIntent;
          localJSONException.printStackTrace();
        }
        i = 0;
        j = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "click HongBao:params=" + paramView.toString());
      }
      localIntent = new Intent(this.this$0.mContext, SendHbActivity.class);
      localIntent.putExtra("come_from", 2);
      localIntent.putExtra("extra_data", paramView.toString());
      localIntent.addFlags(536870912);
      localIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + i, 0, null));
      this.this$0.mContext.startActivity(localIntent);
      return;
      label225:
      if (this.this$0.sessionInfo.cZ == 3000)
      {
        j = ((acdu)this.this$0.app.getManager(53)).cn(this.this$0.sessionInfo.aTl);
        i = 2;
      }
      else if (this.this$0.sessionInfo.cZ == 1)
      {
        i = 3;
        j = 0;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14782465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xdm
 * JD-Core Version:    0.7.0.1
 */