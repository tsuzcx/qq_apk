import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;

public class atgu
  implements atdt.a
{
  public atgu(CloudFileSendRecvActivity paramCloudFileSendRecvActivity) {}
  
  public void Vu(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.this$0.dhF)
    {
      CloudFileSendRecvActivity.a(this.this$0, paramBoolean);
      localTextView = this.this$0.leftView;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (String str = this.this$0.getString(2131691566);; str = this.this$0.getString(2131691565))
    {
      localTextView.setText(str);
      return;
    }
  }
  
  public void etm()
  {
    int i = atiz.Ou();
    if (this.this$0.dhF) {
      if (i == 0)
      {
        CloudFileSendRecvActivity.a(this.this$0).setEnabled(false);
        CloudFileSendRecvActivity.b(this.this$0).setEnabled(false);
        this.this$0.dfI();
      }
    }
    while (CloudFileSendRecvActivity.a(this.this$0) == null) {
      for (;;)
      {
        return;
        CloudFileSendRecvActivity.a(this.this$0).setEnabled(true);
        CloudFileSendRecvActivity.b(this.this$0).setEnabled(true);
      }
    }
    CloudFileSendRecvActivity.a(this.this$0).dmH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgu
 * JD-Core Version:    0.7.0.1
 */