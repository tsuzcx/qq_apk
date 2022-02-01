import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.2.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;

public class adng
  implements adnc.c
{
  adng(adnc paramadnc, long paramLong) {}
  
  public void dU(ArrayList<WadlResult> paramArrayList)
  {
    ArkAppCenter.a().post(this.this$0.mAppName, new ArkAppDownloadModule.2.1(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adng
 * JD-Core Version:    0.7.0.1
 */