import android.os.Handler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.cloudfile.feeds.CloudPhotoListActivity;

public class atly
  implements aths.a
{
  public atly(CloudPhotoListActivity paramCloudPhotoListActivity) {}
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.Pp()) {
      CloudPhotoListActivity.a(this.a).sendEmptyMessage(100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atly
 * JD-Core Version:    0.7.0.1
 */