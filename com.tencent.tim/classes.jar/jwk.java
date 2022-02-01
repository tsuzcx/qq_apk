import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

public class jwk
  extends adai.a
{
  public jwk(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject)
  {
    paramObject = this.this$0;
    paramObject.aDG -= 1;
    if (this.this$0.aDG == 0) {
      this.this$0.aAt();
    }
  }
  
  public int dI()
  {
    return 5;
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
      if (this.this$0.uin == null) {}
    }
    try
    {
      paramObject.put("uin", this.this$0.uin);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("find.mp.qq.com");
      localArrayList.add("post.mp.qq.com");
      localArrayList.add("article.mp.qq.com");
      aija.a("unFollow", paramObject, localArrayList, null);
      this.this$0.azv();
      kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", this.this$0.uin, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
      StructLongMessageDownloadProcessor.aP(this.this$0.app, this.this$0.uin);
      ((apsa)this.this$0.app.getManager(132)).TL(this.this$0.a.uin);
      return;
    }
    catch (JSONException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  public void p(Object paramObject)
  {
    this.this$0.oh(2131697432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwk
 * JD-Core Version:    0.7.0.1
 */