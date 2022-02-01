import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.b;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class sjo
  implements View.OnClickListener
{
  public sjo(ServiceFolderFollowPBHeadView.b paramb, nyi paramnyi, int paramInt) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramView.getContext()).app;
    Object localObject = new Intent(paramView.getContext(), ChatActivity.class);
    ((Intent)localObject).putExtra("uintype", 1008);
    ((Intent)localObject).putExtra("uin", this.b.mUin);
    ((Intent)localObject).putExtra("uinname", this.b.mTitleName);
    ((Intent)localObject).putExtra("start_time", System.currentTimeMillis());
    ((Intent)localObject).putExtra("red_hot_count", this.b.mUnreadNum);
    ((Intent)localObject).putExtra("INTENT_KEY_FROM", 2);
    paramView.getContext().startActivity((Intent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(ServiceFolderFollowPBHeadView.access$100(), 2, "onClickFeedItem->uin:" + this.b.mUin + ", name:" + this.b.mTitleName);
    }
    localObject = "0X80067F1";
    int i = this.b.mUnreadFlag;
    String str2;
    int j;
    if (i == 1)
    {
      localObject = "0X80067EF";
      long l = nyn.a().a(this.b);
      anot.a(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + this.b.mUin, (String)localObject, (String)localObject, 0, 0, "" + i, "" + l, "" + (this.val$position + 1), "" + this.b.mUnreadNum);
      aakp.a(localQQAppInterface, this.b.mUin, this.b.mUnreadFlag, this.b.mUnreadNum, 2, this.b.mTitleName);
      str1 = "";
      localObject = str1;
      if (this.b.d != null)
      {
        localObject = str1;
        if (this.b.d.mExJsonObject != null) {
          localObject = this.b.d.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
        }
      }
      str2 = this.b.mUin;
      i = this.b.mUnreadFlag;
      j = this.b.mUnreadNum;
      if (this.b.d != null) {
        break label585;
      }
    }
    label585:
    for (String str1 = "";; str1 = this.b.d.msg)
    {
      adak.b(localQQAppInterface, str2, i, j, str1, (String)localObject);
      if (xki.hN(this.b.mUin)) {
        anot.a(localQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "3.4.4", "");
      }
      sqn.b(this.b.mUin, "auth_follow", "new_s_clk", 0, 0, new String[] { "", "", this.b.mTitleName, this.b.v.toString() });
      odd.bU(null, "SUBSCRIPT_AIO_COST");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i != 2) {
        break;
      }
      localObject = "0X80067F0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjo
 * JD-Core Version:    0.7.0.1
 */