import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class zxw
  implements ThreadExcutor.IThreadListener
{
  zxw(zxt paramzxt, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.uS.isEmpty())
    {
      aquz localaquz = new aquz(this.uS, this.iu, UUID.randomUUID().toString());
      localaquz.dy(this.val$bundle);
      if (this.this$0.b != null) {
        this.this$0.b.a(localaquz, zxt.a(this.this$0), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxw
 * JD-Core Version:    0.7.0.1
 */