import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterActivity;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class dn
  implements View.OnClickListener
{
  dn(dm paramdm) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (PrinterItemMsgRecord)((dl)paramView.getTag()).getTag();
    if (localObject != null)
    {
      FileManagerEntity localFileManagerEntity = ahav.a((PrinterItemMsgRecord)localObject);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.setType(10009);
      localForwardFileInfo.Oj(6);
      localForwardFileInfo.p(localFileManagerEntity.nSessionId);
      localForwardFileInfo.setFileName(localFileManagerEntity.fileName);
      localForwardFileInfo.jB(((PrinterItemMsgRecord)localObject).uSessionID);
      localForwardFileInfo.setFileSize(localFileManagerEntity.fileSize);
      localForwardFileInfo.setLocalPath(localFileManagerEntity.getFilePath());
      localObject = new Intent(this.a.b.getApplicationContext(), FileBrowserActivity.class);
      if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 1))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
        ((Intent)localObject).putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
      }
      ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
      this.a.b.startActivityForResult((Intent)localObject, 102);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dn
 * JD-Core Version:    0.7.0.1
 */