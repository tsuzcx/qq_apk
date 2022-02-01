import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import java.lang.ref.WeakReference;

public class xef
  extends xmk
{
  public xef(String paramString)
  {
    super(null, paramString);
  }
  
  protected boolean c(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    WeakReference localWeakReference = new WeakReference(this);
    IArkDelegateNet localIArkDelegateNet = ArkDelegateManager.getInstance().getNetDelegate();
    if (localIArkDelegateNet == null) {
      return false;
    }
    localIArkDelegateNet.sendAppMsg(paramString1, paramString2, this.bSV, paramInt2, new xeg(this, localWeakReference));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xef
 * JD-Core Version:    0.7.0.1
 */