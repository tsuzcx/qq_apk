import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View.OnClickListener;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import java.util.ArrayList;

public class atld
  extends atkw
{
  public ForwardFileInfo a()
  {
    if (this.fQ != null) {
      return atyv.c((FileManagerEntity)this.fQ);
    }
    return super.a();
  }
  
  public boolean a(CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunRecentInfo", 1, "create. fileName[" + paramCloudHistoryInfo.fileName + "] filePath[" + paramCloudHistoryInfo.localPath + "]");
    }
    boolean bool3 = aueh.fileExistsAndNotEmpty(paramCloudHistoryInfo.localPath);
    this.fQ = paramObject;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (paramObject == null) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void fZ(Context paramContext)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.fQ;
    if (localFileManagerEntity != null)
    {
      atxh.a(null, localFileManagerEntity, (Activity)paramContext, null).onClick(null);
      return;
    }
    super.fZ(paramContext);
  }
  
  public int getFileType()
  {
    if (this.fQ != null) {
      return ((FileManagerEntity)this.fQ).nFileType;
    }
    return super.getFileType();
  }
  
  public void n(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.fQ != null)
    {
      paramQQAppInterface = (FileManagerEntity)this.fQ;
      Object localObject = new ForwardFileInfo();
      ((ForwardFileInfo)localObject).Oj(2);
      ((ForwardFileInfo)localObject).setType(10003);
      ((ForwardFileInfo)localObject).p(paramQQAppInterface.nSessionId);
      ((ForwardFileInfo)localObject).setFileName(paramQQAppInterface.fileName);
      ((ForwardFileInfo)localObject).setFileId(paramQQAppInterface.WeiYunFileId);
      ((ForwardFileInfo)localObject).Oi(paramQQAppInterface.nWeiYunSrcType);
      ((ForwardFileInfo)localObject).setFileSize(paramQQAppInterface.fileSize);
      Intent localIntent = new Intent(paramContext, FileBrowserActivity.class);
      localIntent.putExtra("qfile_browser_entrance_type", 1);
      localIntent.putExtra("fileinfo", (Parcelable)localObject);
      if (audx.fM(((ForwardFileInfo)localObject).getFileName()) == 0)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(audx.a(paramQQAppInterface));
        localIntent.putParcelableArrayListExtra("local_weiyun_list", (ArrayList)localObject);
      }
      T(paramContext, localIntent);
      return;
    }
    super.n(paramQQAppInterface, paramContext);
  }
  
  public String uZ()
  {
    if (this.fQ != null) {
      return athu.j((FileManagerEntity)this.fQ);
    }
    return super.uZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atld
 * JD-Core Version:    0.7.0.1
 */