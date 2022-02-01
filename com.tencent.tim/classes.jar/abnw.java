import android.util.Log;
import com.tencent.TMG.sdk.AVRoomMulti.RequestViewListCompleteCallback;
import com.tencent.TMG.sdk.AVView;

class abnw
  implements AVRoomMulti.RequestViewListCompleteCallback
{
  abnw(abnq paramabnq) {}
  
  public void OnComplete(String[] paramArrayOfString, AVView[] paramArrayOfAVView, int paramInt1, int paramInt2, String paramString)
  {
    Log.d("CmGameAvHandler", "RequestViewListCompleteCallback.OnComplete result: " + paramInt2 + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abnw
 * JD-Core Version:    0.7.0.1
 */