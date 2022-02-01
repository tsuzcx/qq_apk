import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.3.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import cooperation.wadl.ipc.WadlResult;

public class adnh
  implements adnc.a
{
  adnh(adnc paramadnc) {}
  
  public void j(WadlResult paramWadlResult)
  {
    ArkAppCenter.a().post(this.this$0.mAppName, new ArkAppDownloadModule.3.1(this, paramWadlResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adnh
 * JD-Core Version:    0.7.0.1
 */