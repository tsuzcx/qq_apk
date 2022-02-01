import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abzx
{
  public static void a(boolean paramBoolean, Activity paramActivity, yjh paramyjh, AppInterface paramAppInterface, String paramString, abzx.a parama)
  {
    a(paramBoolean, paramActivity, paramyjh, paramAppInterface, paramString, parama, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, yjh paramyjh, AppInterface paramAppInterface, String paramString, abzx.a parama, boolean paramBoolean2)
  {
    if (parama == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloGameWrapper", 2, "checkApolloGame listener is null");
      }
      return;
    }
    if ((paramActivity == null) || (paramAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloGameWrapper", 2, "checkApolloGame activity is null OR appInterface is null");
      }
      parama.a(false, null);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramyjh = aboy.a(paramString);
      if ((paramyjh == null) || (paramyjh.mContextRef == null) || (paramyjh.mContextRef.get() != paramActivity))
      {
        parama.a(false, paramyjh);
        return;
      }
      parama.a(true, paramyjh);
      return;
    }
    paramActivity.runOnUiThread(new ApolloGameWrapper.1(paramString, paramActivity, parama));
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, aboy paramaboy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abzx
 * JD-Core Version:    0.7.0.1
 */