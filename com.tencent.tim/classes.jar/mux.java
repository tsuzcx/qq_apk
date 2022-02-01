import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

class mux
  extends QIPCModule
{
  mux(muw parammuw, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (muw.a(this.b))
    {
      Iterator localIterator = muw.a(this.b).iterator();
      if (localIterator.hasNext()) {
        ((muw.a)localIterator.next()).d(paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mux
 * JD-Core Version:    0.7.0.1
 */