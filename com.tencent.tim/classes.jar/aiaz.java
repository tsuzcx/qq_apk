import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aiaz
  implements EIPCResultCallback
{
  aiaz(aiay paramaiay) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    aiay.a(paramEIPCResult, "action");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      aiay.a(this.a).o(2, paramEIPCResult.data);
      return;
    }
    aiay.a(this.a).o(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiaz
 * JD-Core Version:    0.7.0.1
 */