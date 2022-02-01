import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class abpd
  implements EIPCResultCallback
{
  abpd(String paramString, long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("type");
    if (i == 1)
    {
      paramEIPCResult = paramEIPCResult.getString("nickName");
      abmt.a().callbackGetNick(paramEIPCResult, this.val$openId, i, this.Od);
    }
    while (i != 2) {
      return;
    }
    paramEIPCResult = (Bitmap)paramEIPCResult.getParcelable("head");
    abmt.a().callbackGetHead(paramEIPCResult, this.val$openId, i, this.Od);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpd
 * JD-Core Version:    0.7.0.1
 */