import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class yca
  implements BusinessObserver
{
  yca(ybt paramybt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label452;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt != 0)
        {
          paramBundle = paramBundle.optString("msg");
          if (!TextUtils.isEmpty(paramBundle))
          {
            QQToast.a(this.this$0.mContext, 1, paramBundle, 0).show(this.this$0.getTitleBarHeight());
            QLog.d(this.this$0.TAG + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.this$0.sessionInfo.aTl + ", op:" + "1" + ", errMsg:" + paramBundle);
            return;
          }
          paramBoolean = false;
          if (!paramBoolean) {
            QQToast.a(this.this$0.mContext, 1, this.this$0.mContext.getString(2131696196), 0).show(this.this$0.getTitleBarHeight());
          }
          if (this.this$0.mIsFollowed == paramBoolean) {
            continue;
          }
          this.this$0.mIsFollowed = paramBoolean;
          this.this$0.bGP();
          return;
        }
        localObject = paramBundle.getJSONObject("result");
        paramInt = paramBundle.optInt("retcode");
        if (paramInt != 0) {
          continue;
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        boolean bool = false;
        continue;
        bool = false;
        continue;
      }
      try
      {
        QQToast.a(this.this$0.mContext, 2, this.this$0.mContext.getString(2131696197), 0).show(this.this$0.getTitleBarHeight());
        bool = true;
        paramBoolean = bool;
        try
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(this.this$0.TAG + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.this$0.sessionInfo.aTl + "result:" + ((JSONObject)localObject).toString());
          paramBoolean = bool;
        }
        catch (Exception paramBundle) {}
      }
      catch (Exception paramBundle)
      {
        bool = true;
        continue;
      }
      paramBoolean = bool;
      if (QLog.isColorLevel())
      {
        QLog.d(this.this$0.TAG + "Q.nearby.follow", 2, "sendOperateFollowUser Exception");
        paramBoolean = bool;
        continue;
        label452:
        paramBoolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yca
 * JD-Core Version:    0.7.0.1
 */