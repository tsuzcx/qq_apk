import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;

final class acid
  extends aczc.b
{
  acid(String paramString, ToServiceMsg paramToServiceMsg)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo arg2)
  {
    synchronized (this.f)
    {
      this.f.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acid
 * JD-Core Version:    0.7.0.1
 */