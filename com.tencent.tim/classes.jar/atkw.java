import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View.OnClickListener;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import tencent.cloud.history_file_extension.history_file_extension.FileExtension;

public class atkw
  implements atiu
{
  public CloudHistoryInfo a;
  public history_file_extension.FileExtension a;
  public String cGT;
  public Object fQ;
  public String fileName;
  public long fileSize;
  public long lastTime;
  public int operateType;
  public int relatedType;
  
  protected void T(Context paramContext, Intent paramIntent)
  {
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramIntent, 102);
      return;
    }
    paramContext.startActivity(paramIntent);
  }
  
  public ForwardFileInfo a()
  {
    return atyv.b(this.cGT);
  }
  
  public boolean a(CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    return false;
  }
  
  public void fZ(Context paramContext)
  {
    try
    {
      if (aueh.fileExistsAndNotEmpty(this.a.localPath)) {
        atxh.a(null, ahav.a(new FileInfo(this.a.localPath)), (Activity)paramContext, null).onClick(null);
      }
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void ga(Context paramContext)
  {
    ((ateh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(180)).notifyUI(30, true, new Object[] { new String(this.a.fileIdBytes, Charset.forName("UTF-8")), Integer.valueOf(0) });
  }
  
  public int getCloudFileType()
  {
    return 9;
  }
  
  public int getFileType()
  {
    return ahav.getFileType(this.cGT);
  }
  
  public long getSortSeq()
  {
    return 0L;
  }
  
  public long getSortTime()
  {
    return this.lastTime;
  }
  
  public boolean isClickable()
  {
    return true;
  }
  
  public void n(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    try
    {
      if (aueh.fileExistsAndNotEmpty(this.a.localPath))
      {
        paramQQAppInterface = new FileInfo(this.a.localPath);
        paramQQAppInterface.setName(this.a.fileName);
        Object localObject = ahav.a(paramQQAppInterface);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.p(((FileManagerEntity)localObject).nSessionId);
        localForwardFileInfo.Oj(3);
        localForwardFileInfo.setType(10000);
        localForwardFileInfo.setLocalPath(paramQQAppInterface.getPath());
        localForwardFileInfo.setFileName(paramQQAppInterface.getName());
        localForwardFileInfo.setFileSize(paramQQAppInterface.getSize());
        Intent localIntent = new Intent(paramContext, FileBrowserActivity.class);
        localIntent.putExtra("qfile_browser_entrance_type", 1);
        localIntent.putExtra("fileinfo", localForwardFileInfo);
        if (((FileManagerEntity)localObject).nFileType == 0)
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramQQAppInterface);
          atwb.en((ArrayList)localObject);
          localIntent.putExtra("clicked_file_hashcode", paramQQAppInterface.hashCode());
        }
        T(paramContext, localIntent);
      }
      return;
    }
    catch (FileNotFoundException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public String uZ()
  {
    return this.cGT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atkw
 * JD-Core Version:    0.7.0.1
 */