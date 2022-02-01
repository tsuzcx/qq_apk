import android.app.Activity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.4.1;
import java.util.Arrays;

public class auan
  implements aths.a
{
  auan(auaj paramauaj) {}
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt1, int paramInt2, String paramString)
  {
    paramString = this.this$0.c.b();
    if ((Arrays.equals(paramFileManagerEntity.pDirKey, paramString.pDirKey)) && (Arrays.equals(paramFileManagerEntity.cloudId, paramString.cloudId)) && (aqhq.fileExistsAndNotEmpty(paramString.strLargeThumPath))) {
      this.this$0.mContext.runOnUiThread(new TIMCloudFileModel.4.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auan
 * JD-Core Version:    0.7.0.1
 */