package com.tencent.qqmini.minigame.debug;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class QQDebugWebSocket$1
  implements DebugWebSocket.DebugSocketListener
{
  QQDebugWebSocket$1(QQDebugWebSocket paramQQDebugWebSocket) {}
  
  public void onSocketClose(DebugWebSocket paramDebugWebSocket, int paramInt)
  {
    QMLog.e(this.this$0.TAG, "qq onSocketClose:" + paramInt);
    QQDebugWebSocket.access$100(this.this$0, paramInt);
  }
  
  public void onSocketFailure(DebugWebSocket paramDebugWebSocket, int paramInt)
  {
    QMLog.e(this.this$0.TAG, "qq onSocketFailure:" + paramInt);
    QQDebugWebSocket.access$100(this.this$0, paramInt);
  }
  
  public void onSocketMessage(DebugWebSocket paramDebugWebSocket, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      paramDebugWebSocket = paramString.getString("cmd");
      paramString = paramString.getString("data");
      QQDebugWebSocket.access$000(this.this$0, paramDebugWebSocket, paramString);
      return;
    }
    catch (JSONException paramDebugWebSocket)
    {
      QMLog.e(this.this$0.TAG, "qq onSocketMessage:", paramDebugWebSocket);
    }
  }
  
  public void onSocketOpened(DebugWebSocket paramDebugWebSocket)
  {
    QMLog.i(this.this$0.TAG, "qq onSocketOpened");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.debug.QQDebugWebSocket.1
 * JD-Core Version:    0.7.0.1
 */