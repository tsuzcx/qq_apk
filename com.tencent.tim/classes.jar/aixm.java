import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.3;
import com.tencent.qphone.base.util.QLog;

public class aixm
  extends aquy
{
  public aixm(PngFrameManager.3 param3) {}
  
  public void onDone(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【aio preview】");
    }
    synchronized (this.a.this$0)
    {
      if (this.a.this$0.mHandler != null)
      {
        if (paramaquz.getStatus() != 3) {
          this.a.this$0.mHandler.obtainMessage(226, this.a.a).sendToTarget();
        }
      }
      else {
        return;
      }
      paramaquz = aixp.F(this.a.val$path);
      this.a.a.object = paramaquz;
      this.a.this$0.mHandler.obtainMessage(227, this.a.a).sendToTarget();
      BaseApplicationImpl.sImageCache.put(this.a.val$path, paramaquz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixm
 * JD-Core Version:    0.7.0.1
 */