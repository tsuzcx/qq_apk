import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import java.util.ArrayList;

public class atkx
  extends atkw
{
  public ForwardFileInfo a()
  {
    if (this.fQ != null) {
      return atyv.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (FileManagerEntity)this.fQ);
    }
    return super.a();
  }
  
  public boolean a(CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.i("TeamCloudRecentInfo", 1, "create. fileName[" + paramCloudHistoryInfo.fileName + "] filePath[" + paramCloudHistoryInfo.localPath + "]");
    }
    boolean bool1 = aueh.fileExistsAndNotEmpty(paramCloudHistoryInfo.localPath);
    this.fQ = paramObject;
    if ((!bool1) && (paramObject == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      paramCloudHistoryInfo = athu.a((CloudFile)paramObject);
      this.fQ = paramCloudHistoryInfo;
      if (paramCloudHistoryInfo.nFileType == 0) {
        break;
      }
      bool1 = bool2;
    } while (paramCloudHistoryInfo.nFileType != 2);
    aths.a().U(paramCloudHistoryInfo);
    return true;
  }
  
  public void fZ(Context paramContext)
  {
    if (this.fQ != null)
    {
      Object localObject = new Bundle();
      Intent localIntent = new Intent();
      ArrayList localArrayList = new ArrayList();
      localIntent.putExtra("k_dataline", false);
      FileManagerEntity localFileManagerEntity = audx.c((FileManagerEntity)this.fQ);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.setType(10014);
      localForwardFileInfo.Oj(localFileManagerEntity.getCloudType());
      localForwardFileInfo.p(localFileManagerEntity.nSessionId);
      localForwardFileInfo.setFileName(localFileManagerEntity.fileName);
      localForwardFileInfo.jB(localFileManagerEntity.uniseq);
      localForwardFileInfo.bf(localFileManagerEntity.cloudId);
      localForwardFileInfo.bg(localFileManagerEntity.pDirKey);
      localForwardFileInfo.setFileSize(localFileManagerEntity.fileSize);
      localForwardFileInfo.setLocalPath(localFileManagerEntity.getFilePath());
      localForwardFileInfo.setUuid(localFileManagerEntity.Uuid);
      long l = localForwardFileInfo.getFileSize();
      localArrayList.add(localForwardFileInfo);
      ((Bundle)localObject).putInt("forward_type", 0);
      ((Bundle)localObject).putParcelableArrayList("fileinfo_array", localArrayList);
      ((Bundle)localObject).putBoolean("not_forward", true);
      localIntent.putExtra("foward_editbar", true);
      localIntent.putExtra("sendMultiple", true);
      localIntent.putExtras((Bundle)localObject);
      localIntent.putExtra("forward_type", 0);
      localObject = "转发文件";
      if (localArrayList.size() == 1) {
        localObject = "已选择" + audx.kY(((ForwardFileInfo)localArrayList.get(0)).getFileName()) + "，大小" + aueh.g(((ForwardFileInfo)localArrayList.get(0)).getFileSize()) + "。";
      }
      for (;;)
      {
        localIntent.putExtra("forward_text", (String)localObject);
        localIntent.putExtra("k_favorites", false);
        localIntent.setClass(paramContext, ForwardRecentActivity.class);
        athu.h(paramContext, localIntent, 103);
        return;
        if (localArrayList.size() > 1) {
          localObject = "已选择" + audx.kY(((ForwardFileInfo)localArrayList.get(0)).getFileName()) + "等" + localArrayList.size() + "个文件，大小" + aueh.g(0L + l) + "。";
        }
      }
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
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.fQ;
    if (localFileManagerEntity != null)
    {
      if (localFileManagerEntity.nSessionId == 0L) {
        localFileManagerEntity.nSessionId = audx.d().longValue();
      }
      paramQQAppInterface.a().v(localFileManagerEntity);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.Oj(9);
      localForwardFileInfo.setType(10001);
      localForwardFileInfo.setFileName(localFileManagerEntity.fileName);
      localForwardFileInfo.setFileSize(localFileManagerEntity.fileSize);
      localForwardFileInfo.bg(localFileManagerEntity.pDirKey);
      localForwardFileInfo.bf(localFileManagerEntity.cloudId);
      localForwardFileInfo.p(localFileManagerEntity.nSessionId);
      Intent localIntent = new Intent(paramContext, FileBrowserActivity.class);
      localIntent.putExtra("qfile_browser_entrance_type", 1);
      localIntent.putExtra("fileinfo", localForwardFileInfo);
      paramQQAppInterface = (atgc)paramQQAppInterface.getManager(373);
      if (audx.fM(localForwardFileInfo.getFileName()) == 2) {
        paramQQAppInterface.y(localFileManagerEntity);
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
 * Qualified Name:     atkx
 * JD-Core Version:    0.7.0.1
 */