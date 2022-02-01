import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.mobileqq.app.QQAppInterface;

class pvc
  implements DeviceProfileManager.a
{
  pvc(puz parampuz) {}
  
  public void sr(boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((pma)((QQAppInterface)localObject).getBusinessHandler(98)).notifyUI(1023, true, Boolean.valueOf(paramBoolean));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvc
 * JD-Core Version:    0.7.0.1
 */