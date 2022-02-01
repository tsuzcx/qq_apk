import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class jwj
  implements BusinessObserver
{
  public jwj(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow isSuccess:" + String.valueOf(paramBoolean));
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
      return;
      Object localObject = new JSONObject();
      if (this.this$0.uin != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.this$0.uin);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.mp.qq.com");
        localArrayList.add("post.mp.qq.com");
        localArrayList.add("article.mp.qq.com");
        aija.a("unfollow", (JSONObject)localObject, localArrayList, null);
        if (!paramBoolean) {
          break label350;
        }
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            continue;
          }
          localObject = new mobileqq_mp.UnFollowResponse();
          ((mobileqq_mp.UnFollowResponse)localObject).mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)((mobileqq_mp.UnFollowResponse)localObject).ret_info.get()).ret_code.get() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow success");
            }
            this.this$0.azv();
            kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", this.this$0.uin, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
            StructLongMessageDownloadProcessor.aP(this.this$0.app, this.this$0.uin);
            if (this.this$0.a == null) {
              continue;
            }
            ((apsa)this.this$0.app.getManager(132)).TL(this.this$0.a.uin);
          }
        }
        catch (Exception paramBundle) {}
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        this.this$0.oh(2131697432);
      }
      continue;
      label350:
      this.this$0.oh(2131697432);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwj
 * JD-Core Version:    0.7.0.1
 */