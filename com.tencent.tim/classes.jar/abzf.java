import com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener.1;
import com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abzf
  extends aqrd
  implements abja
{
  private int cqU = 0;
  private WeakReference<abrs> fN;
  
  public abzf(abrs paramabrs, int paramInt)
  {
    this.fN = new WeakReference(paramabrs);
    this.cqU = paramInt;
  }
  
  protected void onApolloDressChange(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    ThreadManager.post(new ApolloDrawerInfoViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, new Object[] { "[onNotifyStatusChanged], clickPart:", Integer.valueOf(paramInt), ",apolloId:", paramString });
    }
    if (this.fN.get() != null)
    {
      abqt localabqt = ((abrs)this.fN.get()).a();
      if (localabqt != null) {
        localabqt.A(abrj.ge(paramInt), null, paramString);
      }
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, "[onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    ThreadManager.post(new ApolloDrawerInfoViewListener.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abzf
 * JD-Core Version:    0.7.0.1
 */