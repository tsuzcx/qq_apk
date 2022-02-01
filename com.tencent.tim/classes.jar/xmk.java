import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.aio.item.SSODataRequest.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;

public class xmk
  extends xav
{
  private static int bVr;
  private final String TAG = "ArkApp.SSODataRequest";
  protected String aUD;
  private int bVq;
  private WeakReference<QQAppInterface> ec;
  
  xmk(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.ec = new WeakReference(paramQQAppInterface);
    this.aUD = paramString;
  }
  
  private void Dk(int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(this);
    ArkAppCenter.a().post(this.aUD, new SSODataRequest.2(this, localWeakReference, paramInt));
  }
  
  static String hy(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.substring(0, 6).equalsIgnoreCase("sso://")) {
      return null;
    }
    int i = paramString.indexOf('/', 6);
    if (i == -1) {
      return paramString.substring(6);
    }
    return paramString.substring(6, i);
  }
  
  public void abort()
  {
    this.bVq = 0;
    this.aUH = null;
    this.bSW = -1;
    this.aUI = null;
    a(null);
  }
  
  protected boolean c(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)this.ec.get();
    if (localObject == null)
    {
      ArkAppCenter.r("ArkApp.SSODataRequest", String.format("# fail to send, app is null, url=%s, req=%s", new Object[] { this.aUH, paramString2 }));
      return false;
    }
    localObject = ((ArkAppCenter)((QQAppInterface)localObject).getManager(121)).a();
    WeakReference localWeakReference = new WeakReference(this);
    return ((adrc)localObject).a(paramString1, paramString2, this.bSV, paramInt2, new xml(this, localWeakReference));
  }
  
  public boolean open(String paramString)
  {
    if (!super.open(paramString))
    {
      ArkAppCenter.r("ArkApp.SSODataRequest", String.format("# fail to open, url=%s", new Object[] { paramString }));
      return false;
    }
    return true;
  }
  
  public boolean send(String paramString)
  {
    boolean bool = true;
    if ((this.bVq != 0) || (TextUtils.isEmpty(this.aUH)))
    {
      ArkAppCenter.r("ArkApp.SSODataRequest", String.format("# fail to send, cookie=%d, url=%s, req=%s", new Object[] { Integer.valueOf(this.bVq), this.aUH, paramString }));
      bool = false;
    }
    int i;
    String str;
    do
    {
      return bool;
      i = bVr + 1;
      bVr = i;
      this.bVq = i;
      str = hy(this.aUH);
      if (TextUtils.isEmpty(str))
      {
        ArkAppCenter.r("ArkApp.SSODataRequest", String.format("# fail to send, cmd is empty, cookie=%d, url=%s, reqData=%s", new Object[] { Integer.valueOf(i), this.aUH, paramString }));
        Dk(i);
        return true;
      }
    } while (c(str, paramString, this.bSV, i));
    ArkAppCenter.r("ArkApp.SSODataRequest", String.format("# fail to send, sso.sendAppMsg fail, cookie=%d, url=%s, reqData=%s", new Object[] { Integer.valueOf(i), this.aUH, paramString }));
    Dk(i);
    return true;
  }
  
  public void v(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 != this.bVq) {
      ArkAppCenter.r("ArkApp.SSODataRequest", String.format("# onComplete, req canceled, cookie=%d-%d, ret=%d, rsp=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.bVq), Integer.valueOf(paramInt2), paramString }));
    }
    do
    {
      return;
      this.bSW = paramInt2;
      this.aUI = paramString;
      this.bVq = 0;
      paramString = this.a;
      this.a = null;
    } while (paramString == null);
    paramString.onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmk
 * JD-Core Version:    0.7.0.1
 */