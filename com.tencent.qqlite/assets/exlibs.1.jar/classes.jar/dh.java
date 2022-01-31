import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.dataline.util.ItemHolder;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class dh
  implements View.OnClickListener
{
  public dh(DatalineSessionAdapter paramDatalineSessionAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = ((ItemHolder)paramView.getTag()).a();
    paramView = ((DataLineMsgSet)localObject1).getFirstItem();
    if (((DataLineMsgSet)localObject1).isSingle())
    {
      if (-1000 == paramView.msgtype) {
        return;
      }
      localObject1 = FileManagerUtil.a(paramView);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.a(10009);
      localForwardFileInfo.c(6);
      localForwardFileInfo.b(((FileManagerEntity)localObject1).nSessionId);
      localForwardFileInfo.d(paramView.filename);
      localForwardFileInfo.c(paramView.sessionid);
      localForwardFileInfo.d(paramView.filesize);
      localForwardFileInfo.a(paramView.path);
      Intent localIntent = new Intent(DatalineSessionAdapter.a(this.a).getApplicationContext(), FileBrowserActivity.class);
      ArrayList localArrayList = new ArrayList();
      if ((((FileManagerEntity)localObject1).nFileType == 0) || (((FileManagerEntity)localObject1).nFileType == 1))
      {
        Iterator localIterator = DatalineSessionAdapter.a(this.a).iterator();
        label274:
        while (localIterator.hasNext())
        {
          Object localObject2 = (DataLineMsgSet)localIterator.next();
          if (((DataLineMsgSet)localObject2).isSingle())
          {
            localObject2 = ((DataLineMsgSet)localObject2).values().iterator();
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label274;
              }
              DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject2).next();
              if (FileManagerUtil.a(localDataLineMsgRecord.filename) != ((FileManagerEntity)localObject1).nFileType) {
                break;
              }
              if (localDataLineMsgRecord != paramView) {
                localArrayList.add(String.valueOf(FileManagerUtil.a(localDataLineMsgRecord).nSessionId));
              } else {
                localArrayList.add(String.valueOf(((FileManagerEntity)localObject1).nSessionId));
              }
            }
          }
        }
        if (localArrayList.size() == 0) {
          localArrayList.add(String.valueOf(((FileManagerEntity)localObject1).nSessionId));
        }
        localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
      }
      localIntent.putExtra("fileinfo", localForwardFileInfo);
      DatalineSessionAdapter.a(this.a).startActivityForResult(localIntent, 102);
      return;
    }
    if (((DataLineMsgSet)localObject1).getGroupType() == -2000)
    {
      paramView = new Intent(DatalineSessionAdapter.a(this.a), LiteMutiPicViewerActivity.class);
      paramView.putExtra("dataline_group_id", ((DataLineMsgSet)localObject1).getGroupId());
      DatalineSessionAdapter.a(this.a).startActivity(paramView);
      return;
    }
    paramView = new Intent(DatalineSessionAdapter.a(this.a), DLFilesViewerActivity.class);
    paramView.putExtra("dl_files_groupid", ((DataLineMsgSet)localObject1).getGroupId());
    DatalineSessionAdapter.a(this.a).startActivityForResult(paramView, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dh
 * JD-Core Version:    0.7.0.1
 */