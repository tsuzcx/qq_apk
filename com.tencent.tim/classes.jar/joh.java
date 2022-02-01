import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;

class joh
  implements Handler.Callback
{
  joh(jog paramjog) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i;
    if (paramMessage.what == 291) {
      switch (this.this$0.aCx)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      this.this$0.np.setText(this.this$0.mContext.getResources().getString(i));
      paramMessage = this.this$0;
      paramMessage.aCx += 1;
      if (this.this$0.aCx == 4) {
        this.this$0.aCx = 0;
      }
      this.this$0.mHandler.sendEmptyMessageDelayed(291, 1000L);
      return false;
      i = 2131698285;
      continue;
      i = 2131698286;
      continue;
      i = 2131698287;
      continue;
      i = 2131698288;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     joh
 * JD-Core Version:    0.7.0.1
 */