import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class ailz
  extends QIPCModule
{
  private static ailz a;
  
  private ailz(String paramString)
  {
    super(paramString);
  }
  
  public static ailz a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ailz("JubaoIPCServer");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JubaoIPCServer", 2, "jubaoIpcServer onCall= " + paramString + ",callbackId = " + paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ailz
 * JD-Core Version:    0.7.0.1
 */