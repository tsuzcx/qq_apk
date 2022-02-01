import android.os.Handler;
import android.os.Looper;
import com.tencent.cloudfile.CloudUserInfo;
import com.tencent.tim.filemanager.core.WpsFileEditManager;
import com.tencent.tim.filemanager.core.WpsFileEditManager.4.1;

public class atvj
  extends atgg
{
  public atvj(WpsFileEditManager paramWpsFileEditManager) {}
  
  public void a(CloudUserInfo paramCloudUserInfo, int paramInt, String paramString)
  {
    paramString = Looper.getMainLooper();
    if (Thread.currentThread() != paramString.getThread())
    {
      new Handler(paramString).post(new WpsFileEditManager.4.1(this, paramCloudUserInfo, paramInt));
      return;
    }
    WpsFileEditManager.a(this.this$0, paramCloudUserInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvj
 * JD-Core Version:    0.7.0.1
 */