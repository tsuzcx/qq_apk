import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;

class asva
  implements aswu.a
{
  asva(asuz paramasuz, AsyncResult paramAsyncResult) {}
  
  public void onAddResult(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.val$result.onReceiveResult(true, null);
      return;
    }
    this.val$result.onReceiveResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asva
 * JD-Core Version:    0.7.0.1
 */