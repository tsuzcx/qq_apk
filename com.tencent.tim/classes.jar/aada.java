import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper.OnConvertListener;
import eipc.EIPCResult;

class aada
  implements EmojiGifHelper.OnConvertListener
{
  aada(aacv paramaacv, int paramInt) {}
  
  public void onConvertResult(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("res", paramBoolean);
    localBundle.putString("path", paramString);
    this.this$0.callbackResult(this.val$callbackId, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aada
 * JD-Core Version:    0.7.0.1
 */