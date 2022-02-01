package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.minigame.utils.GameLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

final class GamePreConnectManager$4
  implements Callback
{
  GamePreConnectManager$4(String paramString, long paramLong) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    GameLog.getInstance().e("GamePreConnectManager", "pre-connect onFailure: " + this.val$url);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
    throws IOException
  {
    long l = System.currentTimeMillis();
    GameLog.getInstance().i("GamePreConnectManager", "onResponse [timecost: " + (l - this.val$begin) + "] [url: " + this.val$url + "] [code: " + paramResponse.code() + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GamePreConnectManager.4
 * JD-Core Version:    0.7.0.1
 */