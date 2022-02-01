import android.content.Context;

public class arvr
{
  private com.tencent.smtt.sdk.CookieSyncManager a;
  private android.webkit.CookieSyncManager b;
  
  public arvr(Context paramContext)
  {
    this.a = com.tencent.smtt.sdk.CookieSyncManager.createInstance(paramContext);
    this.b = android.webkit.CookieSyncManager.createInstance(paramContext);
  }
  
  public void sync()
  {
    if (this.a != null) {
      this.a.sync();
    }
    if (this.b != null) {
      this.b.sync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvr
 * JD-Core Version:    0.7.0.1
 */