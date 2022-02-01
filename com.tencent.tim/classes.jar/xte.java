import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.util.Locale;

class xte
  implements MessageQueue.IdleHandler
{
  xte(xsk paramxsk) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.this$0.b.c();
    if ((localObject != null) && (AIOImageData.class.isInstance(((xuf)localObject).e)))
    {
      AIOImageData localAIOImageData = (AIOImageData)((xuf)localObject).e;
      if ((localAIOImageData != null) && (localAIOImageData.gF(4)) && (localAIOImageData.c(4) == null))
      {
        this.this$0.gm(true);
        this.this$0.updateUI();
      }
    }
    if ((localObject != null) && (AIOFilePicData.class.isInstance(((xuf)localObject).e)))
    {
      localObject = (AIOFilePicData)((xuf)localObject).e;
      if ((localObject != null) && (((AIOFilePicData)localObject).gF(20)) && (((AIOFilePicData)localObject).c(20) == null))
      {
        if ((!((AIOFilePicData)localObject).bip) || (!aqiu.ms(((AIOFilePicData)localObject).issend))) {
          break label211;
        }
        this.this$0.gm(true);
        this.this$0.zA(false);
        this.this$0.a = null;
      }
    }
    for (;;)
    {
      if (this.this$0.Kk != null) {
        this.this$0.Kk.setText(String.format(Locale.CHINA, xsk.d(this.this$0).getString(2131697154), new Object[] { ahbj.g(((AIOFilePicData)localObject).mFileSize) }));
      }
      return false;
      label211:
      if (((AIOFilePicData)localObject).biq) {
        this.this$0.gm(false);
      } else {
        this.this$0.gm(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xte
 * JD-Core Version:    0.7.0.1
 */