import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.a;

class aonb
  implements DeviceProfileManager.a
{
  aonb(aona.d paramd) {}
  
  public void sr(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.HttpTimeoutParam.name());
      this.c.Sb(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonb
 * JD-Core Version:    0.7.0.1
 */