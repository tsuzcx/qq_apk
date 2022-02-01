import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class xdk
  extends ClickableSpan
{
  xdk(xci paramxci, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, Bundle paramBundle, String paramString4, int paramInt3, long paramLong, String paramString5, int paramInt4, String paramString6) {}
  
  public void onClick(View paramView)
  {
    if (this.val$actionType.compareToIgnoreCase("makePhoneCall") == 0)
    {
      anot.a(this.this$0.app, "P_CliOper", "Safe_SensMsg", this.aUN, "Tips_Click", "makePhoneCall", this.val$fid, this.bTb, "", "", "", "");
      paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.aUO));
      this.this$0.mContext.startActivity(paramView);
    }
    Object localObject1;
    label361:
    do
    {
      do
      {
        return;
        if (this.val$actionType.compareToIgnoreCase("showAlert") == 0)
        {
          paramView = this.ai.getString("AlertTitle");
          localObject1 = this.ai.getString("AlertText");
          localObject3 = this.ai.getString("AlertOtherBtnText");
          str = this.ai.getString("AlertCancelBtnText");
          arnn.a(this.aUP, this.bTa, this.IR, paramView, (String)localObject1, (String)localObject3, str);
          return;
        }
        if (this.val$actionType.compareToIgnoreCase("openURL") != 0) {
          break;
        }
        anot.a(this.this$0.app, "P_CliOper", "Safe_SensMsg", this.aUN, "Tips_Click", "openURL", this.val$fid, this.bTb, "", "", "", "");
        localObject3 = this.ai.getString("Action");
      } while (TextUtils.isEmpty((CharSequence)localObject3));
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        if (((String)localObject3).startsWith("http://")) {
          break label361;
        }
        paramView = "http://" + (String)localObject3;
      }
      for (;;)
      {
        localObject1 = paramView;
        if (paramView.contains("?")) {}
        paramView = new Intent(this.this$0.mContext, QQBrowserActivity.class);
        paramView.putExtra("url", (String)localObject1);
        paramView.putExtra("hide_left_button", true);
        paramView.putExtra("show_right_close_button", true);
        paramView.putExtra("finish_animation_up_down", true);
        this.this$0.mContext.startActivity(paramView);
        return;
        paramView = (View)localObject3;
        if (!((String)localObject3).startsWith("https://")) {
          paramView = "https://" + (String)localObject3;
        }
      }
      if (this.val$actionType.compareToIgnoreCase("transfer") == 0)
      {
        anot.a(this.this$0.app, "P_CliOper", "Safe_SensMsg", this.aUN, "Tips_Click", "transfer", this.val$fid, this.bTb, "", "", "", "");
        paramView = this.aUQ;
        if ((this.bTc == 1) || (this.bTc == 3000)) {
          paramView = aqgv.a(this.this$0.app, this.this$0.sessionInfo, false, this.aUN);
        }
        localObject1 = new Intent(this.this$0.mContext, TransactionActivity.class);
        ((Intent)localObject1).putExtra("come_from", 2);
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("targetUin", this.aUP);
          ((JSONObject)localObject3).put("targetNickname", paramView);
          ((JSONObject)localObject3).put("sign", "");
          ((Intent)localObject1).putExtra("extra_data", ((JSONObject)localObject3).toString());
          ((Intent)localObject1).putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#graytips");
          this.this$0.mContext.startActivity((Intent)localObject1);
          return;
        }
        catch (JSONException paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
          }
        }
      }
      if (this.val$actionType.compareToIgnoreCase("openDeviceLock") == 0)
      {
        anot.a(this.this$0.app, "P_CliOper", "Safe_SensMsg", this.aUN, "Tips_Click", "openDeviceLock", this.val$fid, this.bTb, "", "", "", "");
        paramView = new Intent();
        paramView.setFlags(268435456);
        paramView.setAction("android.intent.action.VIEW");
        paramView.putExtra("devlock_open_source", "Graytips");
        paramView.putExtra("enable_open_allowset_dev", true);
        paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
        this.this$0.mContext.startActivity(paramView);
        return;
      }
      if (this.val$actionType.compareToIgnoreCase("tipOff") == 0)
      {
        anot.a(this.this$0.app, "P_CliOper", "Safe_SensMsg", this.aUN, "Tips_Click", "tipOff", this.val$fid, this.bTb, "", "", "", "");
        stj.a((BaseActivity)this.this$0.mContext, this.this$0.sessionInfo.cZ, this.this$0.sessionInfo.aTl, this.this$0.app.getCurrentAccountUin());
        return;
      }
      if ((this.val$actionType.compareToIgnoreCase("QQCall") != 0) && (this.val$actionType.compareToIgnoreCase("videoCall") != 0)) {
        break;
      }
      anot.a(this.this$0.app, "P_CliOper", "Safe_SensMsg", this.aUN, "Tips_Click", this.val$actionType, this.val$fid, this.bTb, "", "", "", "");
    } while (!(this.this$0.mContext instanceof Activity));
    paramView = this.aUQ;
    int i = this.bTc;
    if ((this.bTc == 1) || (this.bTc == 3000))
    {
      paramView = aqgv.a(this.this$0.app, this.this$0.sessionInfo, false, this.aUN);
      i = 0;
    }
    String str = this.aUP;
    Object localObject3 = this.aUL;
    if ((i == 1006) && (this.aUP != null))
    {
      localObject1 = aqgv.x(this.this$0.app, this.aUP);
      if (localObject1 != null) {
        localObject3 = null;
      }
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = this.this$0.app;
      Activity localActivity = (Activity)this.this$0.mContext;
      if (this.bTc == 1006)
      {
        str = this.aUP;
        if (this.val$actionType.compareToIgnoreCase("QQCall") != 0) {
          break label1074;
        }
      }
      label1074:
      for (boolean bool = true;; bool = false)
      {
        ChatActivityUtils.a(localQQAppInterface, localActivity, i, (String)localObject1, paramView, str, bool, (String)localObject3, true, true, null, "from_internal");
        return;
        str = null;
        break;
      }
      if (this.val$actionType.compareToIgnoreCase("luckyMoney") != 0) {
        break;
      }
      anot.a(this.this$0.app, "P_CliOper", "Safe_SensMsg", this.aUN, "Tips_Click", "luckyMoney", this.val$fid, this.bTb, "", "", "", "");
      i = 1;
      if (this.bTc == 3000) {
        i = 2;
      }
      for (;;)
      {
        paramView = new JSONObject();
        try
        {
          paramView.put("recv_uin", this.this$0.sessionInfo.aTl);
          paramView.put("recv_nick", this.this$0.sessionInfo.aTn);
          paramView.put("recv_type", i);
          if (QLog.isColorLevel()) {
            QLog.d("PlusPanel", 2, "click HongBao:params=" + paramView.toString());
          }
          localObject1 = new Intent(BaseApplicationImpl.getContext(), SendHbActivity.class);
          ((Intent)localObject1).putExtra("come_from", 2);
          ((Intent)localObject1).putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
          ((Intent)localObject1).putExtra("extra_data", paramView.toString());
          ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + i, 0, null));
          this.this$0.mContext.startActivity((Intent)localObject1);
          return;
          if (this.bTc == 1) {
            i = 3;
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
      Object localObject2 = str;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14782465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xdk
 * JD-Core Version:    0.7.0.1
 */