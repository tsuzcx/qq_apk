import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xac4.oidb_0xac4.MailInfo;
import tencent.im.oidb.cmd0xac4.oidb_0xac4.UinInfo;

public class augr
  implements acci
{
  public static String TAG = "MailPluginObserver";
  
  public void VL(boolean paramBoolean) {}
  
  public void VM(boolean paramBoolean) {}
  
  public void Y(boolean paramBoolean, List<oidb_0xac4.MailInfo> paramList) {}
  
  public void Z(boolean paramBoolean, List<oidb_0xac4.UinInfo> paramList) {}
  
  public void cH(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "MailPluginObserver type=" + paramInt + ", isSuccess=" + paramBoolean);
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          VL(paramBoolean);
          return;
          VM(paramBoolean);
          return;
        } while ((paramObject == null) || (!(paramObject instanceof List)));
        Y(paramBoolean, (List)paramObject);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof List)));
      Z(paramBoolean, (List)paramObject);
      return;
    } while ((paramObject == null) || (!(paramObject instanceof Boolean)));
    cH(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augr
 * JD-Core Version:    0.7.0.1
 */