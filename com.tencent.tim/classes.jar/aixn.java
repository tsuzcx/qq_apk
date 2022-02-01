import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.4;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class aixn
  extends aquy
{
  public aixn(PngFrameManager.4 param4, String paramString) {}
  
  public void onDone(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【pngZip】");
    }
    for (;;)
    {
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
      }
      try
      {
        aqhq.W(this.bPS, afnu.bEC.replace("[epId]", this.a.a.epId), false);
        new File(this.bPS).delete();
        this.a.this$0.b(this.a.a.c.c.e.epId);
        this.a.this$0.mHandler.obtainMessage(225, this.a.a).sendToTarget();
        continue;
        paramaquz = finally;
        throw paramaquz;
      }
      catch (IOException paramaquz)
      {
        for (;;)
        {
          paramaquz.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixn
 * JD-Core Version:    0.7.0.1
 */