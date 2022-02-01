package moai.rx;

import android.util.Log;
import rx.functions.Action1;

class TransformerPerformance$3
  implements Action1<Long>
{
  TransformerPerformance$3(TransformerPerformance paramTransformerPerformance) {}
  
  public void call(Long paramLong)
  {
    Log.v("trace", String.format("<%s> cost +%sms", new Object[] { TransformerPerformance.access$000(this.this$0), Long.valueOf(System.currentTimeMillis() - paramLong.longValue()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.TransformerPerformance.3
 * JD-Core Version:    0.7.0.1
 */