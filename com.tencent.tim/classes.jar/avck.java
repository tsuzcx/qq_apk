import android.os.Bundle;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;

class avck
  extends SosoInterface.a
{
  avck(avcj paramavcj, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      String str = paramSosoLbsInfo.a.province;
      paramSosoLbsInfo = paramSosoLbsInfo.a.city;
      this.N.putString("province", str);
      this.N.putString("city", paramSosoLbsInfo);
      if (this.c != null) {
        this.c.onInvokeFinish(this.N);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avck
 * JD-Core Version:    0.7.0.1
 */