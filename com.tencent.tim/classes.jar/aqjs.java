import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomArkDialogForAio.2.1;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aqjs
  implements ArkViewImplement.LoadCallback
{
  aqjs(aqjq paramaqjq) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(this.this$0);
    ThreadManager.getUIHandler().post(new QQCustomArkDialogForAio.2.1(this, localWeakReference, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjs
 * JD-Core Version:    0.7.0.1
 */