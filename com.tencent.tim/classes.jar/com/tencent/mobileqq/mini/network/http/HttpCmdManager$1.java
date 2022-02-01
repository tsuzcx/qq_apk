package com.tencent.mobileqq.mini.network.http;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class HttpCmdManager$1
  extends HttpCallBack
{
  HttpCmdManager$1(HttpCmdManager paramHttpCmdManager, HttpCmdResult paramHttpCmdResult, HttpProtoBufRequest paramHttpProtoBufRequest) {}
  
  public void headersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void httpCallBack(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    if ((paramInt == 200) && (this.val$result != null))
    {
      paramArrayOfByte = this.val$request.onResponse(paramInt, paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        this.val$result.onCmdListener(true, paramArrayOfByte);
        return;
      }
      this.val$result.onCmdListener(false, new JSONObject());
      return;
    }
    if (this.val$result != null) {
      this.val$result.onCmdListener(false, new JSONObject());
    }
    QLog.e("HttpCmdManager", 1, "sendRequest, retCode: " + paramInt);
  }
  
  public void onProgressUpdate(int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.HttpCmdManager.1
 * JD-Core Version:    0.7.0.1
 */