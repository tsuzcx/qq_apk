import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abyc
  implements AdapterView.OnItemClickListener
{
  abyc(abyb paramabyb, String paramString) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Message localMessage = this.this$0.handler.obtainMessage();
    localMessage.what = ((int)paramLong);
    localMessage.obj = this.azt;
    localMessage.sendToTarget();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abyc
 * JD-Core Version:    0.7.0.1
 */