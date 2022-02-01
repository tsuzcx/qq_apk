import android.os.Bundle;
import mqq.observer.SSOAccountObserver;

class arog
  extends SSOAccountObserver
{
  arog(aroe paramaroe, int paramInt) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    aroe.a(this.a, paramString, this.val$callbackId, paramInt2, -102);
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    arod.a().WE(paramString);
    aroe.WG(paramString);
    aroe.a(this.a, paramString, this.val$callbackId, 0, 0);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    aroe.a(this.a, paramString, this.val$callbackId, 2006, -100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arog
 * JD-Core Version:    0.7.0.1
 */