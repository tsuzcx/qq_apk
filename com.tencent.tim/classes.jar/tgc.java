import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.gdtad.aditem.GdtAdLoader.1;
import com.tencent.gdtad.aditem.GdtAdLoader.2;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

public class tgc
{
  private tgc.b a;
  private WeakReference<tgc.a> du;
  
  public tgc(tgc.b paramb, WeakReference<tgc.a> paramWeakReference)
  {
    this.a = paramb;
    this.du = paramWeakReference;
  }
  
  private void bCS()
  {
    new Handler(Looper.getMainLooper()).post(new GdtAdLoader.2(this));
  }
  
  public tgc.b a()
  {
    return this.a;
  }
  
  public void c(WeakReference<Context> paramWeakReference)
  {
    ThreadManager.post(new GdtAdLoader.1(this, paramWeakReference), 5, null, true);
  }
  
  public static abstract interface a
  {
    public abstract void onResponse(tgc paramtgc);
  }
  
  public static class b
  {
    public qq_ad_get.QQAdGet a;
    public qq_ad_get.QQAdGetRsp a;
    public int httpResponseCode = -2147483648;
    public long timeMillis = -2147483648L;
    
    public boolean canSend()
    {
      return this.a != null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgc
 * JD-Core Version:    0.7.0.1
 */