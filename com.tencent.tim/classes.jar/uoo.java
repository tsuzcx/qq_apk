import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.ChatHistoryImageView.DownloadAndSaveTask;
import com.tencent.mobileqq.app.ThreadManager;

public class uoo
  implements DialogInterface.OnClickListener
{
  public uoo(ChatHistoryImageView paramChatHistoryImageView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.this$0;
    ChatHistoryImageView.DownloadAndSaveTask localDownloadAndSaveTask = new ChatHistoryImageView.DownloadAndSaveTask(this.this$0, this.this$0.dQ, true, false);
    paramDialogInterface.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask = localDownloadAndSaveTask;
    ThreadManager.post(localDownloadAndSaveTask, 5, null, true);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.bKc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uoo
 * JD-Core Version:    0.7.0.1
 */