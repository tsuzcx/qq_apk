import MQQ.VipUserInfo;
import com.tencent.qphone.base.util.QLog;

public class acnz
  implements acci
{
  protected void av(boolean paramBoolean, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipInfoObserver", 2, "onUpdate-isSuccess:" + paramBoolean);
    }
    if (paramInt == 1)
    {
      int i = -1;
      paramInt = i;
      if (paramBoolean)
      {
        paramObject = (VipUserInfo)paramObject;
        paramInt = i;
        if (paramObject != null)
        {
          paramInt = i;
          if (paramObject.bUpdate == 1) {
            paramInt = paramObject.iGrowthValue;
          }
        }
      }
      av(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acnz
 * JD-Core Version:    0.7.0.1
 */