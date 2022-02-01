import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class abvt
  implements asrt.a
{
  abvt(abvq paramabvq, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onError(int paramInt, String paramString)
  {
    if (this.b.b != null) {
      this.b.b.bN(1, "ctrl Params download failed!!!!");
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte)
  {
    ThreadManager.getUIHandler().post(new AVEngineWalper.3.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvt
 * JD-Core Version:    0.7.0.1
 */