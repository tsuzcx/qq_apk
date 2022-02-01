import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity.8.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class jwl
  implements BusinessObserver
{
  public jwl(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow isSuccess:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.this$0.oh(2131697432);
    }
    for (;;)
    {
      paramBundle = this.this$0;
      paramBundle.aDG -= 1;
      if (this.this$0.aDG == 0) {
        this.this$0.aAt();
      }
      this.this$0.iS.postDelayed(new AccountDetailActivity.8.1(this), 2000L);
      return;
      Object localObject = new JSONObject();
      if (this.this$0.a != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.this$0.a.uin);
        ((JSONObject)localObject).put("name", this.this$0.a.name);
        ((JSONObject)localObject).put("summary", this.this$0.a.summary);
        ((JSONObject)localObject).put("certified", this.this$0.a.certifiedGrade);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.mp.qq.com");
        localArrayList.add("post.mp.qq.com");
        localArrayList.add("article.mp.qq.com");
        aija.a("follow", (JSONObject)localObject, localArrayList, null);
        if (!paramBoolean) {
          break label749;
        }
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            continue;
          }
          localObject = new mobileqq_mp.FollowResponse();
          ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
          paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
          if (paramInt == 0) {
            if (this.this$0.abW)
            {
              if (this.this$0.a != null)
              {
                paramBundle = this.this$0.a.uin;
                anot.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", this.this$0.uin, "mp_msg_sys_12", "scan_via", 0, 0, paramBundle, "", "", this.this$0.Ut);
              }
            }
            else
            {
              this.this$0.a.followType = 1;
              this.this$0.iS.setEnabled(false);
              this.this$0.aAq();
              this.this$0.azw();
              this.this$0.aAi();
              AccountDetailActivity.a(this.this$0.app, this.this$0.uin, this.this$0.mIntent);
              if ((!TextUtils.isEmpty(this.this$0.Uq)) && (!TextUtils.isEmpty(this.this$0.Ur)))
              {
                anot.a(this.this$0.app, "CliOper", "", "", this.this$0.Uq, this.this$0.Ur, 0, 0, "", "", this.this$0.app.getCurrentAccountUin(), this.this$0.uin);
                if (QLog.isColorLevel()) {
                  QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "----[follow report done]----");
                }
              }
              if (this.this$0.aDI == 50) {
                AccountDetailActivity.a(this.this$0, 1);
              }
              if ((this.this$0.mSource == 115) && (this.this$0.app != null)) {
                ((kec)this.this$0.app.getBusinessHandler(88)).a(134247140, this.this$0.uin, null, null, null, 0L, false);
              }
              if (!this.this$0.mIntent.hasExtra("report_business_tvalue")) {
                continue;
              }
              paramInt = this.this$0.mIntent.getIntExtra("report_business_tvalue", -1);
              paramBundle = this.this$0.mIntent.getStringExtra("strp1");
              if (paramInt == -1) {
                continue;
              }
              ((kec)this.this$0.app.getBusinessHandler(88)).a(paramInt, this.this$0.uin, paramBundle, null, null, 0L, false);
            }
          }
        }
        catch (Exception paramBundle) {}
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          continue;
          paramBundle = "";
        }
        if (paramInt == 58)
        {
          this.this$0.oh(2131697429);
          continue;
        }
        if (paramInt == 65)
        {
          this.this$0.oh(2131697402);
          continue;
        }
        this.this$0.oh(2131697432);
      }
      continue;
      label749:
      this.this$0.oh(2131697432);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwl
 * JD-Core Version:    0.7.0.1
 */