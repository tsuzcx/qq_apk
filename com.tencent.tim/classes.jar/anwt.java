import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;

public class anwt
  implements anws
{
  private final String TAG = "shadow::PluginManagerWrapper";
  private final DynamicPluginManager b;
  private final String bME;
  
  public anwt(String paramString, DynamicPluginManager paramDynamicPluginManager)
  {
    this.b = paramDynamicPluginManager;
    this.bME = paramString;
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("shadow::PluginManagerWrapper", 2, "enter formId:" + paramLong + " enterCallback:" + paramEnterCallback);
    }
    aice.a().a(this.bME, this.b);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (anwh)((QQAppInterface)localObject).getManager(362);
      if (localObject != null) {
        ((anwh)localObject).a(this.b);
      }
    }
    this.b.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwt
 * JD-Core Version:    0.7.0.1
 */