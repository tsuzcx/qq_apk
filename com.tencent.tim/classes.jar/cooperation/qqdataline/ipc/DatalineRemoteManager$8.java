package cooperation.qqdataline.ipc;

import agmz;
import ahav;
import android.content.Context;
import android.content.Intent;
import aviq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class DatalineRemoteManager$8
  implements Runnable
{
  public DatalineRemoteManager$8(aviq paramaviq, FileManagerEntity paramFileManagerEntity, ForwardFileInfo paramForwardFileInfo) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$0.app.getApplication().getApplicationContext(), FileBrowserActivity.class);
    localIntent.addFlags(268435456);
    Object localObject;
    if ((this.b.nFileType == 0) || (this.b.nFileType == 1))
    {
      if (!ahav.mI(this.b.getFilePath())) {
        break label163;
      }
      localObject = new FileInfo();
      ((FileInfo)localObject).setSize(this.c.getFileSize());
      ((FileInfo)localObject).setName(this.c.getFileName());
      ((FileInfo)localObject).setPath(this.c.getLocalPath());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      agmz.en(localArrayList);
      localIntent.putExtra("clicked_file_hashcode", ((FileInfo)localObject).hashCode());
    }
    for (;;)
    {
      localIntent.putExtra("fileinfo", this.c);
      this.this$0.app.getApplication().getApplicationContext().startActivity(localIntent);
      return;
      label163:
      localObject = new ArrayList();
      ((ArrayList)localObject).add(String.valueOf(this.b.nSessionId));
      localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager.8
 * JD-Core Version:    0.7.0.1
 */