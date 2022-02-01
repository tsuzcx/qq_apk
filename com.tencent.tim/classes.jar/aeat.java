import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.qphone.base.util.QLog;

public class aeat
  extends acfd
{
  public aeat(MessageNotificationSettingFragment paramMessageNotificationSettingFragment) {}
  
  protected void onSetMessageNotification(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingFragment", 2, new Object[] { "onSetMessageNotification: invoked. ", " isSuccess: ", Boolean.valueOf(paramBoolean), " data: " + paramArrayOfObject });
    }
    boolean[] arrayOfBoolean;
    if ((paramBoolean) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      localObject = (String[])paramArrayOfObject[0];
      arrayOfBoolean = (boolean[])paramArrayOfObject[1];
      if ((localObject != null) && (localObject.length >= 1) && (arrayOfBoolean != null) && (arrayOfBoolean.length >= 1)) {}
    }
    else
    {
      return;
    }
    Object localObject = localObject[0];
    paramBoolean = arrayOfBoolean[0];
    ((Integer)paramArrayOfObject[2]).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeat
 * JD-Core Version:    0.7.0.1
 */