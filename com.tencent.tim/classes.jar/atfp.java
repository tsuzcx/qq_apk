import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tim.cloudfile.CloudFileListFragment;
import java.util.List;

public class atfp
  implements DialogInterface.OnClickListener
{
  public atfp(CloudFileListFragment paramCloudFileListFragment, List paramList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (CloudFileListFragment.a(this.this$0) != null)
    {
      CloudFileListFragment.a(this.this$0).notifyDataSetChanged();
      CloudFileListFragment.a(this.this$0).o(1, this.val$fileList.toArray());
      CloudFileListFragment.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfp
 * JD-Core Version:    0.7.0.1
 */