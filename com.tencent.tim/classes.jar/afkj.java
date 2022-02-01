import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;

class afkj
  extends afko
{
  afkj(afke paramafke, String paramString, Object paramObject) {}
  
  public void a(EmoticonPackage arg1, int paramInt, Bundle paramBundle)
  {
    if (???.epId.equals(this.aMY)) {
      synchronized (this.bk)
      {
        this.bk.notify();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkj
 * JD-Core Version:    0.7.0.1
 */