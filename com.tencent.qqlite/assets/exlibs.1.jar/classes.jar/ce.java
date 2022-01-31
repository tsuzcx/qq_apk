import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.mpfile.LiteMpFileDownloadActivity;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.mpfile.MpfileTaskListAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;

public class ce
  implements View.OnClickListener
{
  public ce(LiteMpFileDownloadActivity paramLiteMpFileDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (MpfileTaskListAdapter.ItemHolder)paramView.getTag();
    if (paramView != null)
    {
      Object localObject = paramView.a;
      if (localObject != null)
      {
        paramView = FileManagerUtil.a((MpfileTaskInfo)localObject);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.a(10009);
        localForwardFileInfo.c(7);
        localForwardFileInfo.b(paramView.nSessionId);
        localForwardFileInfo.d(((MpfileTaskInfo)localObject).jdField_d_of_type_JavaLangString);
        localForwardFileInfo.c(((MpfileTaskInfo)localObject).jdField_d_of_type_Long);
        localForwardFileInfo.d(((MpfileTaskInfo)localObject).b);
        localForwardFileInfo.a(((MpfileTaskInfo)localObject).e);
        localObject = new Intent(this.a.getApplicationContext(), FileBrowserActivity.class);
        if ((paramView.nFileType == 0) || (paramView.nFileType == 1))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(String.valueOf(paramView.nSessionId));
          ((Intent)localObject).putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
        }
        ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
        this.a.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ce
 * JD-Core Version:    0.7.0.1
 */