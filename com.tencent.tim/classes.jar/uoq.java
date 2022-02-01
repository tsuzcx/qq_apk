import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.ChatHistoryImageView.DownloadAndSaveTask;

public class uoq
  implements DialogInterface.OnClickListener
{
  public uoq(ChatHistoryImageView paramChatHistoryImageView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.this$0.G != null) && (this.this$0.G.isShowing()))
    {
      this.this$0.G.cancel();
      if (this.this$0.a != null) {
        this.this$0.a.wt(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uoq
 * JD-Core Version:    0.7.0.1
 */