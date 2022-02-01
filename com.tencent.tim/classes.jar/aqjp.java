import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomArkDialog.2.1;
import com.tencent.mobileqq.utils.QQCustomArkDialog.2.2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aqjp
  implements ArkViewImplement.LoadCallback
{
  aqjp(aqjn paramaqjn) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(this.this$0);
    ThreadManager.getUIHandler().post(new QQCustomArkDialog.2.1(this, localWeakReference, paramInt));
    if (paramInt == 0) {}
    do
    {
      return;
      aqjn.a(this.this$0, true);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, new Object[] { "arkView init finish,load state = ", Integer.valueOf(paramInt), ";outsideShowDialog = ", Boolean.valueOf(aqjn.a(this.this$0)), ";alreadyShowDialog:", Boolean.valueOf(aqjn.b(this.this$0)) });
      }
    } while (!aqjn.a(this.this$0));
    ThreadManager.getUIHandler().post(new QQCustomArkDialog.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjp
 * JD-Core Version:    0.7.0.1
 */