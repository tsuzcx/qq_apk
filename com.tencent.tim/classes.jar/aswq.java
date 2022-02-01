import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShareProxyImpl.4.2;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCClient;
import org.json.JSONObject;

public class aswq
  implements MiniAppCmdInterface
{
  aswq(aswo paramaswo, Activity paramActivity, InnerShareData paramInnerShareData, int paramInt, String paramString, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    boolean bool = false;
    QLog.d("AppBrandRuntime", 1, "startShareToWeChat. isSuc:" + paramBoolean);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      String str = paramJSONObject.optString("jump_url");
      if (paramJSONObject.optBoolean("needShareCallBack", false)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      try
      {
        paramJSONObject = URLDrawable.URLDrawableOptions.obtain();
        if (this.val$activity != null) {
          paramJSONObject.mFailedDrawable = this.val$activity.getResources().getDrawable(2130849280);
        }
        paramJSONObject = URLDrawable.getDrawable(this.val$shareData.sharePicPath, paramJSONObject);
        paramJSONObject.setURLDrawableListener(new aswr(this, str));
        if (paramJSONObject.getStatus() == 1)
        {
          paramJSONObject = ImageUtil.drawableToBitmap(paramJSONObject.getCurrDrawable());
          aswo.a(this.this$0, this.val$shareType, this.val$finalDescription, this.val$miniAppInfo.name, paramJSONObject, str);
          return;
        }
        if (paramJSONObject.getStatus() == 1) {
          return;
        }
        paramJSONObject.startDownload();
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("AppBrandRuntime", 1, "startShareToWeChat. get an exception when handling URLbmp:" + paramJSONObject);
        aswo.a(this.this$0, this.val$activity, this.val$shareType, this.val$finalDescription, this.val$miniAppInfo.name, str);
        return;
      }
    }
    else
    {
      long l = -1L;
      if (paramJSONObject != null)
      {
        paramBoolean = paramJSONObject.optBoolean("needShareCallBack", false);
        l = paramJSONObject.optLong("retCode");
        paramJSONObject = paramJSONObject.optString("errMsg");
      }
      for (;;)
      {
        if (!paramBoolean) {
          QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
        }
        if (this.val$activity == null)
        {
          QLog.e("ShareProxyImpl", 1, "startShareToWe activity is null?!!");
          return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.4.2(this, l, paramJSONObject));
        return;
        paramJSONObject = null;
        paramBoolean = bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswq
 * JD-Core Version:    0.7.0.1
 */