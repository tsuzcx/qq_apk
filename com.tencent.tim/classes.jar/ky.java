import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ky
  implements EIPCResultCallback
{
  ky(kx paramkx) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      kx.a(this.this$0);
      this.this$0.notifyObservers(Integer.valueOf(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ky
 * JD-Core Version:    0.7.0.1
 */