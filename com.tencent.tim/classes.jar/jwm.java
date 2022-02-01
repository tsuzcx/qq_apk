import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity.9.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

public class jwm
  extends adai.a
{
  public jwm(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject)
  {
    paramObject = this.this$0;
    paramObject.aDG -= 1;
    if (this.this$0.aDG == 0) {
      this.this$0.aAt();
    }
    this.this$0.iS.postDelayed(new AccountDetailActivity.9.1(this), 1000L);
  }
  
  public int dI()
  {
    return 4;
  }
  
  public void onSuccess(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      paramObject = new JSONObject();
      if (this.this$0.a == null) {}
    }
    try
    {
      paramObject.put("uin", this.this$0.a.uin);
      paramObject.put("name", this.this$0.a.name);
      paramObject.put("summary", this.this$0.a.summary);
      paramObject.put("certified", this.this$0.a.certifiedGrade);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("find.mp.qq.com");
      localArrayList.add("post.mp.qq.com");
      localArrayList.add("article.mp.qq.com");
      aija.a("follow", paramObject, localArrayList, null);
      if (this.this$0.abW)
      {
        if (this.this$0.a != null)
        {
          paramObject = this.this$0.a.uin;
          anot.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", this.this$0.uin, "mp_msg_sys_12", "scan_via", 0, 0, paramObject, "", "", this.this$0.Ut);
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
        if (this.this$0.mIntent.hasExtra("report_business_tvalue"))
        {
          int i = this.this$0.mIntent.getIntExtra("report_business_tvalue", -1);
          paramObject = this.this$0.mIntent.getStringExtra("strp1");
          if (i != -1) {
            ((kec)this.this$0.app.getBusinessHandler(88)).a(i, this.this$0.uin, paramObject, null, null, 0L, false);
          }
        }
        return;
      }
    }
    catch (JSONException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
        continue;
        paramObject = "";
      }
    }
  }
  
  public void p(Object paramObject)
  {
    this.this$0.oh(2131697432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwm
 * JD-Core Version:    0.7.0.1
 */