import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity.12.1;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class jsw
  implements BusinessObserver
{
  public jsw(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "follow isSuccess:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.this$0.oh(2131697432);
    }
    for (;;)
    {
      EqqAccountDetailActivity.c(this.this$0);
      if (EqqAccountDetailActivity.d(this.this$0) == 0) {
        EqqAccountDetailActivity.d(this.this$0);
      }
      EqqAccountDetailActivity.b(this.this$0).postDelayed(new EqqAccountDetailActivity.12.1(this), 1000L);
      return;
      Object localObject = new JSONObject();
      ((FriendListHandler)EqqAccountDetailActivity.j(this.this$0).getBusinessHandler(1)).by(true, false);
      if (this.this$0.b != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.this$0.b.uin);
        ((JSONObject)localObject).put("name", this.this$0.b.name);
        ((JSONObject)localObject).put("summary", this.this$0.b.summary);
        ((JSONObject)localObject).put("certified", this.this$0.b.certifiedGrade);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.mp.qq.com");
        localArrayList.add("post.mp.qq.com");
        localArrayList.add("article.mp.qq.com");
        aija.a("follow", (JSONObject)localObject, localArrayList, null);
        if (!paramBoolean) {
          break label557;
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
          if (paramInt == 0)
          {
            this.this$0.b.followType = 1;
            EqqAccountDetailActivity.a(this.this$0).setEnabled(false);
            EqqAccountDetailActivity.b(this.this$0);
            this.this$0.azw();
            EqqAccountDetailActivity.c(this.this$0);
            AccountDetailActivity.a(EqqAccountDetailActivity.k(this.this$0), EqqAccountDetailActivity.k(this.this$0), EqqAccountDetailActivity.a(this.this$0));
            if ((TextUtils.isEmpty(this.this$0.Uq)) || (TextUtils.isEmpty(this.this$0.Ur))) {
              continue;
            }
            anot.a(EqqAccountDetailActivity.l(this.this$0), "CliOper", "", "", this.this$0.Uq, this.this$0.Ur, 0, 0, "", "", EqqAccountDetailActivity.m(this.this$0).getCurrentAccountUin(), EqqAccountDetailActivity.l(this.this$0));
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(this.this$0.TAG, 2, "----[follow report done]----");
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
        if (paramInt == 20)
        {
          this.this$0.oh(2131697403);
          continue;
        }
        this.this$0.oh(2131697432);
      }
      continue;
      label557:
      this.this$0.oh(2131697432);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsw
 * JD-Core Version:    0.7.0.1
 */