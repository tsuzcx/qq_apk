import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

public class khs
  implements TopGestureLayout.OnGestureListener
{
  public khs(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void flingLToR()
  {
    ReadInJoyChannelActivity.a(this.this$0, true);
    this.this$0.finish();
  }
  
  public void flingRToL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     khs
 * JD-Core Version:    0.7.0.1
 */