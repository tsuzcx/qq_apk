import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3.1.1;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class adoi
  implements tgc.a
{
  public adoi(ArkAppNotifyCenter.GdtNotify.3 param3) {}
  
  public void onResponse(tgc paramtgc)
  {
    ArkAppCenter.a().postToArkThread(new ArkAppNotifyCenter.GdtNotify.3.1.1(this, paramtgc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adoi
 * JD-Core Version:    0.7.0.1
 */