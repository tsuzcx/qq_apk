package com.tencent.mobileqq.redtouch;

import affz;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class RedTouchWebviewHandler$1$1
  implements Runnable
{
  RedTouchWebviewHandler$1$1(RedTouchWebviewHandler.1 param1, String paramString1, JSONObject paramJSONObject, BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt1, int paramInt2, ArrayList paramArrayList, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.a.this$0.callJs(this.val$callbackId, new String[] { this.bG.toString() });
    Object localObject = "";
    if (this.w != null) {
      localObject = RedTouchWebviewHandler.access$100(this.a.this$0, this.w.buffer.get());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ret", String.valueOf(this.dxx));
    localBundle.putString("buffer", (String)localObject);
    localBundle.putString("red", String.valueOf(this.dxy));
    localBundle.putStringArrayList("missions", this.yW);
    localBundle.putString("path", this.bYl);
    localBundle.putString("serial", this.bYm);
    localBundle.putString("callback", this.val$callbackId);
    localObject = affz.a("redTouch_getAppInfo_report", this.val$callbackId, this.a.this$0.mOnRemoteResp.key, localBundle);
    this.a.this$0.sendRemoteReq((Bundle)localObject, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.1.1
 * JD-Core Version:    0.7.0.1
 */