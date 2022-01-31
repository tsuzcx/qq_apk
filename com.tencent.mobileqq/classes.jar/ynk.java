import android.util.Log;
import com.tencent.TMG.sdk.AVRoomMulti.RequestViewListCompleteCallback;
import com.tencent.TMG.sdk.AVView;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;

public class ynk
  implements AVRoomMulti.RequestViewListCompleteCallback
{
  public ynk(CmGameAvHandler paramCmGameAvHandler) {}
  
  public void OnComplete(String[] paramArrayOfString, AVView[] paramArrayOfAVView, int paramInt1, int paramInt2, String paramString)
  {
    Log.d("CmGameAvHandler", "RequestViewListCompleteCallback.OnComplete result: " + paramInt2 + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ynk
 * JD-Core Version:    0.7.0.1
 */