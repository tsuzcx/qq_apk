import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.qphone.base.util.QLog;

public class anps
  extends anpr
{
  private static anps a;
  private boolean isBackground;
  
  public static anps a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      if (a == null) {
        a = new anps();
      }
      anps localanps = a;
      return localanps;
    }
    finally {}
  }
  
  public void onAppBackground()
  {
    if (this.isBackground) {
      return;
    }
    this.isBackground = true;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = (aops)((QQAppInterface)localObject).getManager(233);
      if (localObject != null) {
        ((aops)localObject).onAppBackground();
      }
    }
    anpq.a().onAppBackground();
  }
  
  public void onAppForeground()
  {
    this.isBackground = false;
    anpq.a().onAppForeground();
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = (aops)((QQAppInterface)localObject).getManager(233);
      if (localObject != null) {
        ((aops)localObject).dWz();
      }
    }
  }
  
  public void onProcessStart()
  {
    if ((BaseApplicationImpl.sProcessId != 4) && (BaseApplicationImpl.sProcessId != 1) && (ands.P(BaseApplicationImpl.sProcessId, BaseApplicationImpl.processName))) {}
    for (;;)
    {
      try
      {
        QLog.d("RecordTracer", 1, "SDK Init, processId:" + BaseApplicationImpl.sProcessId + ", processName:" + BaseApplicationImpl.processName);
        RecordTracer.a().step();
        Object localObject = MagnifierSDK.a().a().oC().split("\\|");
        if ((localObject.length < 11) || (TextUtils.isEmpty(localObject[10]))) {
          break label173;
        }
        localObject = localObject[10];
        anpq.a().Ri((String)localObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("RecordTracer", 2, "not init, processId:" + BaseApplicationImpl.sProcessId + ", processName:" + BaseApplicationImpl.processName);
        continue;
        label173:
        String str = "0.1;0.0002;10;5;10;5;2;0;500;1";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anps
 * JD-Core Version:    0.7.0.1
 */