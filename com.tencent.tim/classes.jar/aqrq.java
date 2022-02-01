import android.annotation.TargetApi;
import android.os.Handler;

class aqrq
  extends aquy
{
  aqrq(aqrp paramaqrp) {}
  
  @TargetApi(9)
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    aqrp.a(this.this$0).sendMessage(aqrp.a(this.this$0).obtainMessage(10002, paramaquz.getStatus(), 0, paramaquz.getParams()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrq
 * JD-Core Version:    0.7.0.1
 */