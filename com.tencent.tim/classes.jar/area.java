import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.werewolves.WerewolvesHostInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class area
  implements BusinessObserver
{
  public area(WerewolvesHostInterface paramWerewolvesHostInterface, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      ((ajpj)this.val$app.getManager(106)).go.put(this.val$uin, Integer.valueOf(1));
      if (!paramBoolean) {
        break label348;
      }
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label348;
      }
      localObject = new WebSsoBody.WebSsoResponseBody();
      ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
      paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
      localObject = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
      if (paramInt != 0)
      {
        paramBundle = ((JSONObject)localObject).optString("msg");
        if ((TextUtils.isEmpty(paramBundle)) || (!QLog.isColorLevel())) {
          break label348;
        }
        QLog.d("Q.werewolf.WerewolvesHostInterfaceQ.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.val$uin + ", op:" + this.aMh + ", errMsg:" + paramBundle);
        QQToast.a(BaseApplicationImpl.getContext(), 1, paramBundle, 0).show();
        return;
      }
      paramBundle = ((JSONObject)localObject).getJSONObject("result");
      if (((JSONObject)localObject).optInt("retcode") != 0) {
        break label348;
      }
      if (this.apH) {
        this.a.manager.a().K(5, new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.apH) });
      }
      localObject = BaseApplicationImpl.getContext();
      localBaseApplication = BaseApplicationImpl.getContext();
      if (!this.aMh.equals("1")) {
        break label477;
      }
      paramInt = 2131696197;
    }
    catch (Exception paramBundle)
    {
      Object localObject;
      BaseApplication localBaseApplication;
      if (!QLog.isColorLevel()) {
        break label348;
      }
      QLog.d("Q.werewolf.WerewolvesHostInterface", 2, "sendOperateFollowUser, Exception");
      label348:
      paramBundle = BaseApplicationImpl.getContext();
      if (!this.aMh.equals("1")) {
        break label483;
      }
      label477:
      label483:
      for (paramInt = 2131696196;; paramInt = 2131696209)
      {
        paramBundle = paramBundle.getString(paramInt);
        QQToast.a(BaseApplicationImpl.getContext(), 1, paramBundle, 0).show();
        if (QLog.isColorLevel()) {
          QLog.d("Q.werewolf.WerewolvesHostInterfaceQ.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.val$uin + ", op:" + this.aMh + ", re:" + paramBundle);
        }
        this.a.manager.a().K(5, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.apH) });
        return;
        paramInt = 2131696210;
        break;
      }
    }
    QQToast.a((Context)localObject, 2, localBaseApplication.getString(paramInt), 0).show();
    if (QLog.isColorLevel())
    {
      QLog.d("Q.werewolf.WerewolvesHostInterfaceQ.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.val$uin + ", op:" + this.aMh + ", result:" + paramBundle.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     area
 * JD-Core Version:    0.7.0.1
 */