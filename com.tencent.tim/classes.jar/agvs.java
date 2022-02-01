import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class agvs
  extends agvq
{
  private WeiYunFileInfo e;
  private FileManagerEntity m;
  private QQAppInterface mApp;
  private Context mContext;
  private ArrayList<WeiYunFileInfo> wL;
  
  public agvs(QQAppInterface paramQQAppInterface, Context paramContext, WeiYunFileInfo paramWeiYunFileInfo)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.e = paramWeiYunFileInfo;
  }
  
  public void F(FileManagerEntity paramFileManagerEntity)
  {
    this.m = paramFileManagerEntity;
  }
  
  public boolean SG()
  {
    return false;
  }
  
  public void cC(Bundle paramBundle) {}
  
  public void eq(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.wL = paramArrayList;
  }
  
  public Intent x()
  {
    Object localObject1 = this.m;
    if (localObject1 != null)
    {
      if (localObject1 != null) {
        break label103;
      }
      QLog.i("WeiYunFileBrowserParams<FileAssistant>", 1, "");
      localObject1 = new Intent(this.mContext, FileBrowserActivity.class);
    }
    Object localObject2;
    label103:
    do
    {
      do
      {
        return localObject1;
        if (this.e == null) {
          break;
        }
        localObject2 = this.mApp.a().f(this.e.bIk);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject2 = this.mApp.a().c(this.e.bIk);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = ahav.b(this.e);
        break;
        if (QLog.isColorLevel()) {
          QLog.i("WeiYunFileBrowserParams<FileAssistant>", 1, "open a weiyun file with filebrowser, fileSessionId[" + ((FileManagerEntity)localObject1).nSessionId + "] fileName[" + this.e.strFileName + "]fileId[" + this.e.bIk + "]");
        }
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.Oj(2);
        localForwardFileInfo.setType(10003);
        localForwardFileInfo.p(((FileManagerEntity)localObject1).nSessionId);
        localForwardFileInfo.setFileName(((FileManagerEntity)localObject1).fileName);
        localForwardFileInfo.setFileId(((FileManagerEntity)localObject1).WeiYunFileId);
        localForwardFileInfo.Oi(((FileManagerEntity)localObject1).nWeiYunSrcType);
        localForwardFileInfo.setFileSize(((FileManagerEntity)localObject1).fileSize);
        localObject2 = new Intent(this.mContext, FileBrowserActivity.class);
        ((Intent)localObject2).putExtra("fileinfo", localForwardFileInfo);
        localObject1 = localObject2;
      } while (this.wL == null);
      localObject1 = localObject2;
    } while (this.wL.size() <= 0);
    ((Intent)localObject2).putParcelableArrayListExtra("local_weiyun_list", this.wL);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvs
 * JD-Core Version:    0.7.0.1
 */