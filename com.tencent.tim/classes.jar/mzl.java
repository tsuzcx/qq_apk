import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;

public class mzl
  implements myj.a
{
  private static final String TAG = mzl.class.getSimpleName();
  private mzl.a a;
  private HashMap<String, String> mCallbackMap = new HashMap();
  
  private void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (paramInt1 == 2) {
      kxv.a().a(paramString1, "PubAccountArticleCenter.GetUrlByVid", new mzm(this, paramString1, paramInt2, paramLong));
    }
    do
    {
      do
      {
        return;
        if (!b(paramString2, paramString1, paramInt2))
        {
          c(paramString2, paramString1, paramLong, paramInt2);
          return;
        }
      } while (this.a == null);
      paramString2 = (String)this.mCallbackMap.get(paramString1);
    } while (TextUtils.isEmpty(paramString2));
    this.a.r(paramString1, 1, paramString2);
  }
  
  private void aUM() {}
  
  private boolean b(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  private void c(String paramString1, String paramString2, long paramLong, int paramInt) {}
  
  public void a(mzl.a parama)
  {
    this.a = parama;
  }
  
  public void aUL() {}
  
  public void b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3)
  {
    this.mCallbackMap.put(paramString1, paramString3);
    ThreadManager.post(new VideoWebPreDownload.1(this, paramString1, paramInt1, paramLong, paramInt2, paramString2), 5, null, true);
  }
  
  public void destory() {}
  
  public void ns(boolean paramBoolean)
  {
    aUM();
  }
  
  public static abstract interface a
  {
    public abstract void r(String paramString1, int paramInt, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzl
 * JD-Core Version:    0.7.0.1
 */