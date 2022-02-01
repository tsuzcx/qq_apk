import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class cw
  implements View.OnClickListener
{
  cw(cv paramcv) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (cv.a)paramView.getTag();
    if (((cv.a)localObject1).a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = DataLineMsgRecord.getDevTypeBySeId(((cv.a)localObject1).a.sessionid);
      Object localObject2 = cv.a(this.b).b().a(i).a(((cv.a)localObject1).a.sessionid);
      if (localObject2 != null)
      {
        localObject1 = ahav.a((DataLineMsgRecord)localObject2);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.setType(10009);
        localForwardFileInfo.Oj(6);
        localForwardFileInfo.p(((FileManagerEntity)localObject1).nSessionId);
        localForwardFileInfo.setFileName(((DataLineMsgRecord)localObject2).filename);
        localForwardFileInfo.jB(((DataLineMsgRecord)localObject2).sessionid);
        localForwardFileInfo.setFileSize(((DataLineMsgRecord)localObject2).filesize);
        localForwardFileInfo.setLocalPath(((DataLineMsgRecord)localObject2).path);
        localObject2 = new Intent(cv.a(this.b).getApplicationContext(), FileBrowserActivity.class);
        if ((((FileManagerEntity)localObject1).nFileType == 0) || (((FileManagerEntity)localObject1).nFileType == 1))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(String.valueOf(((FileManagerEntity)localObject1).nSessionId));
          ((Intent)localObject2).putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
        }
        ((Intent)localObject2).putExtra("fileinfo", localForwardFileInfo);
        cv.a(this.b).startActivityForResult((Intent)localObject2, 102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cw
 * JD-Core Version:    0.7.0.1
 */