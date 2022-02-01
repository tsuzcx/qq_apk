import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import java.util.Locale;

class amdu
  implements MessageQueue.IdleHandler
{
  amdu(amdr paramamdr) {}
  
  public boolean queueIdle()
  {
    AIOFilePictureData localAIOFilePictureData = this.this$0.b.a();
    if (localAIOFilePictureData != null)
    {
      amco localamco = new amco();
      if ((localamco.a(localAIOFilePictureData, 20)) && (localamco.a(localAIOFilePictureData, 20) == null))
      {
        if ((!localAIOFilePictureData.bip) || (!aqiu.ms(localAIOFilePictureData.issend))) {
          break label116;
        }
        this.this$0.OS(true);
        this.this$0.updateUI();
      }
    }
    for (;;)
    {
      this.this$0.Px(String.format(Locale.CHINA, this.this$0.mContext.getString(2131697154), new Object[] { ahbj.g(localAIOFilePictureData.mFileSize) }));
      return false;
      label116:
      if (localAIOFilePictureData.biq) {
        this.this$0.OS(false);
      } else {
        this.this$0.OS(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdu
 * JD-Core Version:    0.7.0.1
 */