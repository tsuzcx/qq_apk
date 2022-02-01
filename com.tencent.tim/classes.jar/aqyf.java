import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class aqyf
  extends acbw
{
  public aqyf(WebProcessManager paramWebProcessManager) {}
  
  protected void V(boolean paramBoolean, Object paramObject)
  {
    int j = -1;
    int i = j;
    if (paramObject != null)
    {
      i = j;
      if ((paramObject instanceof Bundle))
      {
        paramObject = (Bundle)paramObject;
        i = paramObject.getInt("ad_bbq_code", -1);
        if (i == 0)
        {
          paramObject = paramObject.getString("ad_bbq_message");
          Object localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject instanceof QQAppInterface))
          {
            localObject = (acbs)((QQAppInterface)localObject).getBusinessHandler(53);
            if (localObject != null) {
              ((acbs)localObject).Do(paramObject);
            }
          }
        }
      }
    }
    paramObject = new Intent("com.tencent.mobileqq.babyq.added");
    paramObject.setPackage(BaseApplicationImpl.getApplication().getPackageName());
    paramObject.putExtra("result", i);
    BaseApplicationImpl.getApplication().sendBroadcast(paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "babyq observer return result=" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqyf
 * JD-Core Version:    0.7.0.1
 */