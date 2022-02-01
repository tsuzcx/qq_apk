package com.tencent.mobileqq.mini.appbrand.utils;

import com.tencent.mobileqq.mini.network.http.HttpCallBack;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Map;

class MiniLogManager$7$1
  extends HttpCallBack
{
  MiniLogManager$7$1(MiniLogManager.7 param7) {}
  
  public void headersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void httpCallBack(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    if (paramInt == 200) {
      if (QLog.isDebugVersion()) {
        QLog.d(MiniLogManager.access$100(), 2, "log upload success " + this.this$0.val$targetUrl);
      }
    }
    for (;;)
    {
      new File(this.this$0.val$filePath).delete();
      return;
      if (QLog.isDebugVersion()) {
        QLog.d(MiniLogManager.access$100(), 2, "log upload failed " + this.this$0.val$targetUrl);
      }
    }
  }
  
  public void onProgressUpdate(int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.7.1
 * JD-Core Version:    0.7.0.1
 */