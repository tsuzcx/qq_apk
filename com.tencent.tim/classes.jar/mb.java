import android.text.TextUtils;
import com.immersion.touchsensesdk.AsyncConnectionProxy;
import com.immersion.touchsensesdk.IConnection;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mb
  extends AsyncConnectionProxy
{
  private WeakReference<QQAppInterface> n;
  
  public mb()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      this.n = new WeakReference((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
  }
  
  public void connect(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    mc localmc = (mc)((QQAppInterface)this.n.get()).getBusinessHandler(116);
    localmc.a(this);
    localmc.V(paramString);
  }
  
  public void setConnection(IConnection paramIConnection)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("HapticMediaPlayer connection == NULL -->");
      if (paramIConnection != null) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ImmerIConnectionProxy", 2, bool);
      super.setConnection(paramIConnection);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mb
 * JD-Core Version:    0.7.0.1
 */