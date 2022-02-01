import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;

class avet
  implements AVCallback
{
  avet(aveo paramaveo) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      QLog.e("AVEngineWalper", 1, "AVCallback make connection successfully!!!");
      aveo.a(this.b, true);
    }
    for (;;)
    {
      if (this.b.b != null) {
        this.b.b.bM(paramInt, paramString);
      }
      return;
      QLog.e("AVEngineWalper", 1, "AVCallback result=" + paramInt + ", errorInfo=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avet
 * JD-Core Version:    0.7.0.1
 */