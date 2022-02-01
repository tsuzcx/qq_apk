import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.pubaccount.AccountDetailBounceScrollView;

class jsg
  extends Handler
{
  jsg(jsf paramjsf) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.lastY == this.a.a.a.getScrollY())
    {
      if ((this.a.lastY > 0) && (!this.a.a.a.yx()))
      {
        int i = this.a.lastY;
        i = (int)(this.a.a.screenHeight * (1.0D - LebaSearchPluginManagerActivity.aM) + this.a.lastY);
        int j = (int)(this.a.lastY - (this.a.a.ns.getHeight() + this.a.a.density * 56.0F - this.a.a.screenHeight * (1.0D - LebaSearchPluginManagerActivity.aM)));
        if ((i > this.a.a.ns.getHeight() + this.a.a.density * 56.0F) || (i > this.a.a.ns.getHeight())) {
          this.a.a.a.scrollBy(0, -j);
        }
      }
      return;
    }
    this.a.lastY = this.a.a.a.getScrollY();
    this.a.handler.sendMessageDelayed(this.a.handler.obtainMessage(), 5L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsg
 * JD-Core Version:    0.7.0.1
 */