import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.qphone.base.util.QLog;

public class ikm
  extends iki
{
  public static final String[] aM = { "params.dat" };
  
  public ikm(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.aN = aM;
  }
  
  public void Y(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "MuteByOthers, fromMuteKey[" + paramInt + "], data[" + paramString + "]");
    }
    if (paramInt == kU()) {
      return;
    }
    a(0L, null);
  }
  
  public iki.a a(int paramInt1, int paramInt2)
  {
    iki.a locala = super.a(paramInt1, paramInt2);
    if ((locala != null) && (locala.b != null) && (!locala.b.needHMirror)) {
      locala.b.needHMirror = true;
    }
    return locala;
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramString1 = (PendantItem)a();
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1.getId())));
    a(paramLong, null);
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    if ((bool) && (paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())) && (!TextUtils.equals("0", paramPendantItem.getId())))
    {
      ijt localijt = (ijt)this.mApp.a(12);
      if (localijt != null) {
        localijt.X(3005, paramPendantItem.getId());
      }
    }
    return bool;
  }
  
  public int getConfigID()
  {
    return 623;
  }
  
  public int kU()
  {
    return 3005;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikm
 * JD-Core Version:    0.7.0.1
 */