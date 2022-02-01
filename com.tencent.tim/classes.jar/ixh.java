import android.os.Handler;
import android.os.Message;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;

public class ixh
  extends Handler
{
  public ixh(AVActivity paramAVActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    }
    long l = jlc.a(paramMessage.obj);
    this.this$0.d(l, "handleMessage", true);
    if (this.this$0.a != null) {
      this.this$0.a.auF();
    }
    if (this.this$0.b != null) {
      this.this$0.b.ne(this.this$0.a.axi);
    }
    this.this$0.cP(-1031L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixh
 * JD-Core Version:    0.7.0.1
 */