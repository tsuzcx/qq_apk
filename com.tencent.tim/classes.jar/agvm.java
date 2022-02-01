import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import java.util.ArrayList;

public class agvm
  extends agvq
{
  private boolean aWg;
  private FileManagerEntity f;
  private Context mContext;
  private ArrayList<String> wK;
  
  public agvm(Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    this.mContext = paramContext;
    this.f = paramFileManagerEntity;
    this.aWg = false;
  }
  
  public void ep(ArrayList<String> paramArrayList)
  {
    this.wK = paramArrayList;
  }
  
  public Intent x()
  {
    if (this.f == null) {
      return null;
    }
    ForwardFileInfo localForwardFileInfo = ahhq.a(this.f);
    localForwardFileInfo.setType(10009);
    Intent localIntent = new Intent();
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    if ((this.wK != null) && (this.wK.size() > 0)) {
      localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", this.wK);
    }
    localIntent.putExtra("_from_aio_", this.aWg);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvm
 * JD-Core Version:    0.7.0.1
 */