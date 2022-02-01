import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class kz
  implements EIPCResultCallback
{
  kz(kx paramkx) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (paramEIPCResult.data.getInt("font_type"))
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1)
      {
        kx.b(this.this$0);
        this.this$0.notifyObservers(Integer.valueOf(1));
      }
      return;
      bool1 = kx.a(this.this$0, false);
      continue;
      bool1 = kx.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kz
 * JD-Core Version:    0.7.0.1
 */