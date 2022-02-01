package com.tencent.mobileqq.mini.apkg;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class BaseLibManager$1$1
  implements MiniAppCmdInterface
{
  BaseLibManager$1$1(BaseLibManager.1 param1, String paramString1, String paramString2) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      ThreadManagerV2.executeOnFileThread(new BaseLibManager.1.1.1(this, paramJSONObject));
      Object localObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(1)));
      if (BaseLibManager.access$000(this.this$1.this$0, (BaseLibInfo)localObject).booleanValue())
      {
        paramJSONObject = ((BaseLibInfo)localObject).baseLibVersion;
        localObject = ((BaseLibInfo)localObject).baseLibUrl;
        QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] updateBaseLib end : version : " + paramJSONObject + "; url : " + (String)localObject);
        this.this$1.this$0.doDownloadBaselib((String)localObject, paramJSONObject, this.val$baseLibUrl, this.val$baseLibVersion, this.this$1.val$listener);
      }
    }
    do
    {
      do
      {
        return;
        QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] updateBaseLib, no update");
      } while (this.this$1.val$listener == null);
      this.this$1.val$listener.onUpdateResult(1);
      return;
      QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] updateBaseLib failed!");
    } while (this.this$1.val$listener == null);
    this.this$1.val$listener.onUpdateResult(1100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager.1.1
 * JD-Core Version:    0.7.0.1
 */