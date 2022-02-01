package com.tencent.mobileqq.teamwork;

import acfp;
import android.os.Bundle;
import android.text.TextUtils;
import aobk;
import aobx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public class TenDocOCRExportHandler$1
  implements Runnable
{
  public TenDocOCRExportHandler$1(aobx paramaobx, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.val$imagePath))) {
      return;
    }
    aobx localaobx = (aobx)this.this$0.app.getBusinessHandler(157);
    JSONObject localJSONObject = aobk.a(this.this$0.app, this.val$imagePath, this.this$0.app.getCurrentAccountUin());
    if (localJSONObject != null)
    {
      String str = localJSONObject.optString("url");
      int i = localJSONObject.optInt("ret");
      try
      {
        str = URLDecoder.decode(str, "UTF-8");
        if ((i == 0) && (str.length() > 0))
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("url", str);
          localaobx.notifyUI(3, true, new Object[] { localJSONObject });
          QIPCClientHelper.getInstance().callServer("Module_TDFileChangeNameQIPCModule", "Action_url_2_fmdb", localBundle);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localaobx.notifyUI(1, true, new Object[] { acfp.m(2131715236), this.val$imagePath });
        localUnsupportedEncodingException.printStackTrace();
        return;
      }
      localaobx.notifyUI(1, true, new Object[] { acfp.m(2131715235), this.val$imagePath });
      return;
    }
    localaobx.notifyUI(1, true, new Object[] { acfp.m(2131715234), this.val$imagePath });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocOCRExportHandler.1
 * JD-Core Version:    0.7.0.1
 */