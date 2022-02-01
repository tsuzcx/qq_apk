import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;

public class arie
{
  private Handler handler = new arif(this, Looper.getMainLooper());
  Context mContext = BaseApplication.getContext();
  Toast mToast = null;
  
  public arie(Context paramContext) {}
  
  public void V(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    arie.a locala = new arie.a(null);
    locala.icon = paramInt4;
    locala.msgId = paramInt1;
    locala.duration = paramInt3;
    locala.offset = paramInt2;
    localMessage.obj = locala;
    this.handler.removeMessages(1);
    this.handler.sendMessage(localMessage);
  }
  
  public void eiG()
  {
    if (this.mToast != null) {
      this.mToast.cancel();
    }
  }
  
  public void p(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    arie.a locala = new arie.a(null);
    locala.icon = paramInt3;
    locala.cAx = paramString;
    locala.duration = paramInt2;
    locala.offset = paramInt1;
    localMessage.obj = locala;
    this.handler.sendMessage(localMessage);
  }
  
  static class a
  {
    String cAx;
    int duration;
    int icon;
    int msgId;
    int offset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     arie
 * JD-Core Version:    0.7.0.1
 */