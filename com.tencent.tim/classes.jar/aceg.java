import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aceg
  implements acci
{
  protected void EL(boolean paramBoolean) {}
  
  protected void ag(boolean paramBoolean, Object paramObject) {}
  
  protected void iK(List<CustomEmotionData> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (paramObject == null);
      EL(((Boolean)paramObject).booleanValue());
      return;
    case 1: 
      try
      {
        iK((ArrayList)paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("FavEmoRoamingObserver", 1, "onUploadReq error, ", paramObject);
        return;
      }
    case 2: 
      ag(paramBoolean, paramObject);
      return;
    }
    x(paramBoolean, paramObject);
  }
  
  protected void x(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aceg
 * JD-Core Version:    0.7.0.1
 */