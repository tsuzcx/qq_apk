import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;

public class atgv
  implements View.OnLongClickListener
{
  public atgv(CloudFileSendRecvActivity paramCloudFileSendRecvActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!this.this$0.akK())
    {
      this.this$0.IP(true);
      paramView.performClick();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgv
 * JD-Core Version:    0.7.0.1
 */