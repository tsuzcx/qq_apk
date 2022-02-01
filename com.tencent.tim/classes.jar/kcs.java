import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class kcs
  implements acci
{
  protected void o(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (Bundle)paramObject;
      if (paramObject.getInt("VALUE_OBSERVER_TAG") == hashCode()) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      try
      {
        o(paramBoolean, paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
    }
    QLog.e("VideoPlayRecommendObserver", 2, "onUpdate: error, data null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kcs
 * JD-Core Version:    0.7.0.1
 */