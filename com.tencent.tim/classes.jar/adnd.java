import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.1.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;

public class adnd
  implements adnc.b
{
  adnd(adnc paramadnc, long paramLong) {}
  
  public void dT(ArrayList<WadlResult> paramArrayList)
  {
    ArkAppCenter.a().post(this.this$0.mAppName, new ArkAppDownloadModule.1.1(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adnd
 * JD-Core Version:    0.7.0.1
 */