import android.os.Handler;
import com.tencent.mobileqq.activity.CloudFileActivity;
import com.tencent.mobileqq.activity.CloudFileActivity.13.1;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.GridListView;

public class urd
  extends atgd
{
  public urd(CloudFileActivity paramCloudFileActivity) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, long paramLong, FileManagerEntity paramFileManagerEntity, int paramInt, String paramString) {}
  
  public void bLQ()
  {
    super.bLQ();
    if (this.this$0.a.getFirstVisiblePosition() > 0) {
      this.this$0.a.setSelection(0);
    }
    new Handler().postDelayed(new CloudFileActivity.13.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     urd
 * JD-Core Version:    0.7.0.1
 */