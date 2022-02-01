import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AVActivity.10.1;
import com.tencent.av.ui.AVActivity.10.2;

public class ixc
  extends aqxa
{
  public ixc(AVActivity paramAVActivity) {}
  
  public void F(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.mApp != null) {
      this.this$0.mApp.getHandler().post(new AVActivity.10.2(this));
    }
  }
  
  public void arP()
  {
    if (this.this$0.mApp != null) {
      this.this$0.mApp.getHandler().postDelayed(new AVActivity.10.1(this), 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixc
 * JD-Core Version:    0.7.0.1
 */