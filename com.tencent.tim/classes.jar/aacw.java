import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.e;
import eipc.EIPCResult;
import java.util.HashMap;

class aacw
  implements PreloadManager.e
{
  aacw(aacv paramaacv, int paramInt) {}
  
  public void b(int paramInt, HashMap<String, PreloadManager.PathResult> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramHashMap);
    this.this$0.callbackResult(this.val$callbackId, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacw
 * JD-Core Version:    0.7.0.1
 */