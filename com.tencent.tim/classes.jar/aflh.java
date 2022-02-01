import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class aflh
{
  private final aquz b;
  private AtomicBoolean cS = new AtomicBoolean();
  private String epId;
  private float fj;
  
  public aflh(String paramString, aquz paramaquz)
  {
    this.epId = paramString;
    this.b = paramaquz;
  }
  
  public Bundle a(QQAppInterface paramQQAppInterface)
  {
    if (this.b != null) {
      return this.b.getParams();
    }
    return (Bundle)((aqrc)paramQQAppInterface.getManager(235)).a.fl.get(this.epId);
  }
  
  public float ba()
  {
    if (this.b != null) {
      return this.b.fj;
    }
    return this.fj;
  }
  
  public void cN(QQAppInterface paramQQAppInterface)
  {
    this.cS.set(true);
    if (this.b != null) {
      this.b.cancel(true);
    }
    String str;
    do
    {
      return;
      str = "bqmall.android.h5magic." + this.epId + ".zip";
      paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(184);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.cancelDwonloadItem(1004L, str);
  }
  
  public boolean isCancel()
  {
    return this.cS.get();
  }
  
  public void setPercent(float paramFloat)
  {
    this.fj = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflh
 * JD-Core Version:    0.7.0.1
 */