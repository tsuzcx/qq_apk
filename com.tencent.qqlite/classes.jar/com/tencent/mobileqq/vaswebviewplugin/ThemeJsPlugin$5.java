package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;

class ThemeJsPlugin$5
  implements DialogInterface.OnClickListener
{
  ThemeJsPlugin$5(ThemeJsPlugin paramThemeJsPlugin, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "not wifi network confirm continue to download");
      }
      String str = ThemeUtil.getThemeDownloadFilePath(ThemeJsPlugin.access$000(this.this$0), this.val$id, this.val$version);
      ThemeJsPlugin.access$502(this.this$0, true);
      Object localObject = (ThemeUtil.ThemeInfo)ThemeJsPlugin.access$300(this.this$0).get(this.val$id);
      paramDialogInterface = (DialogInterface)localObject;
      if (localObject == null)
      {
        localObject = ThemeUtil.getThemeInfo(ThemeJsPlugin.access$000(this.this$0), this.val$id);
        paramDialogInterface = (DialogInterface)localObject;
        if (localObject != null)
        {
          ((ThemeUtil.ThemeInfo)localObject).downloadUrl = this.val$url;
          paramDialogInterface = (DialogInterface)localObject;
        }
      }
      if (paramDialogInterface != null)
      {
        localObject = paramDialogInterface;
        if (paramDialogInterface.version.equals(this.val$version)) {}
      }
      else
      {
        localObject = new ThemeUtil.ThemeInfo();
        ((ThemeUtil.ThemeInfo)localObject).themeId = this.val$id;
        ((ThemeUtil.ThemeInfo)localObject).downloadUrl = this.val$url;
        ((ThemeUtil.ThemeInfo)localObject).size = this.val$size;
        ((ThemeUtil.ThemeInfo)localObject).downsize = 0L;
        ((ThemeUtil.ThemeInfo)localObject).version = this.val$version;
        ((ThemeUtil.ThemeInfo)localObject).status = "1";
        if (this.val$voiceFlag != 1) {
          break label328;
        }
      }
      for (;;)
      {
        ((ThemeUtil.ThemeInfo)localObject).isVoiceTheme = bool;
        ThemeJsPlugin.access$300(this.this$0).put(this.val$id, localObject);
        ThemeJsPlugin.access$602(this.this$0, this.val$id);
        paramDialogInterface = new Bundle();
        paramDialogInterface.putString("url", this.val$url);
        paramDialogInterface.putString("themeZipPath", str);
        paramDialogInterface.putString("id", this.val$id);
        paramDialogInterface.putString("version", this.val$version);
        paramDialogInterface.putLong("size", this.val$size);
        paramDialogInterface.putSerializable("themeInfo", (Serializable)localObject);
        paramDialogInterface = DataFactory.makeIPCRequestPacket("startDownloadTheme", this.val$callbackId, this.this$0.mOnRemoteResp.key, paramDialogInterface);
        this.this$0.sendRemoteReq(paramDialogInterface, true, true);
        return;
        label328:
        bool = false;
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */