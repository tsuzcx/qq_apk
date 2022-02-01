import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;

public class agzy
{
  private final String TAG = "FileModel<FileAssistant>";
  private FileManagerEntity c;
  
  public static agzy a(MessageForFile paramMessageForFile)
  {
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface1 == null) {
        throw new NullPointerException("newFileModel entity app null!");
      }
    }
    catch (Exception localException)
    {
      QQAppInterface localQQAppInterface2;
      for (;;)
      {
        localQQAppInterface2 = null;
      }
      return a(ahav.a(localQQAppInterface2, paramMessageForFile));
    }
  }
  
  public static agzy a(FileManagerEntity paramFileManagerEntity)
  {
    agzy localagzy = new agzy();
    if ((paramFileManagerEntity == null) && (QLog.isDevelopLevel())) {
      throw new NullPointerException("newFileModel entity is null!");
    }
    localagzy.c = paramFileManagerEntity;
    return localagzy;
  }
  
  public static agzy a(String paramString)
  {
    try
    {
      paramString = a(ahav.a(new FileInfo(paramString)));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("check localPath");
      }
    }
    return null;
  }
  
  private void d(Activity paramActivity, int paramInt1, int paramInt2)
  {
    ForwardFileInfo localForwardFileInfo;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null)
      {
        QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = null;
      }
      localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.setType(paramInt2);
      if (!this.c.bSend) {}
    }
    for (Object localObject = ((QQAppInterface)localObject).getAccount();; localObject = this.c.peerUin)
    {
      localForwardFileInfo.Oj(this.c.getCloudType());
      if (localObject != null) {
        localForwardFileInfo.jA(Long.valueOf(((String)localObject).replace("+", "")).longValue());
      }
      localForwardFileInfo.jB(this.c.uniseq);
      localForwardFileInfo.p(this.c.nSessionId);
      localForwardFileInfo.setFileName(this.c.fileName);
      localForwardFileInfo.setFileSize(this.c.fileSize);
      localForwardFileInfo.setUuid(this.c.Uuid);
      localForwardFileInfo.setLocalPath(this.c.getFilePath());
      localObject = new Intent(paramActivity, FileBrowserActivity.class);
      ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
      ((Intent)localObject).putExtra("file_enter_file_browser_type", paramInt1);
      ((Intent)localObject).putExtra("selfSet_leftViewText", acfp.m(2131706277));
      paramActivity.startActivityForResult((Intent)localObject, 102);
      paramActivity.overridePendingTransition(2130772077, 2130772079);
      return;
    }
  }
  
  private void fU(String paramString1, String paramString2)
  {
    QLog.i("FileModel<FileAssistant>" + paramString1, 1, "Id[" + this.c.nSessionId + "]" + paramString2);
  }
  
  private void r(Activity paramActivity, int paramInt)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null)
      {
        QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        localObject = null;
      }
      if (((this.c.status == 0) || (this.c.status == 3)) && (((paramActivity instanceof ChatActivity)) || ((paramActivity instanceof SplashActivity))) && (!this.c.bSend))
      {
        localObject.a().jk(this.c.nSessionId);
        return;
      }
      d(paramActivity, paramInt, 10004);
    }
  }
  
  public void a(boolean paramBoolean, Context paramContext, ahal.a parama)
  {
    int j = 2;
    if (!aqiw.bW(BaseApplicationImpl.getContext())) {
      ahao.OS(2131694663);
    }
    boolean bool1;
    label48:
    label91:
    do
    {
      return;
      if (paramBoolean) {
        break;
      }
      bool1 = true;
      if (!bd(bool1)) {
        break label160;
      }
      Activity localActivity = (Activity)paramContext;
      if (!paramBoolean) {
        break label140;
      }
      i = 3;
      boolean bool2 = aqux.a(localActivity, i, new agzz(this, parama), "");
      bool1 = bool2;
      if (bool2)
      {
        localActivity = (Activity)paramContext;
        if (!paramBoolean) {
          break label146;
        }
        i = j;
        bool1 = armm.a(localActivity, i, new ahaa(this, parama));
      }
    } while (!bool1);
    if (paramBoolean) {}
    for (int i = 2131693832;; i = 2131693828)
    {
      ahal.a(paramContext, 2131693826, i, parama);
      return;
      bool1 = false;
      break;
      label140:
      i = 2;
      break label48;
      label146:
      i = 1;
      break label91;
    }
    label160:
    parama.aD();
  }
  
  public boolean bd(boolean paramBoolean)
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {}
    long l2;
    long l1;
    do
    {
      do
      {
        return false;
        if (!ahav.amK())
        {
          fU("FlowShow", " donot ShowFlowDialog! Wi-Fi");
          return false;
        }
        l2 = agmx.fJ();
        l1 = agmx.fK();
        fU("FlowShow", "fileSize " + this.c.fileSize + ",limit  " + l2);
      } while (this.c.fileSize < l2);
      if (paramBoolean)
      {
        fU("FlowShow", "download model so Show!");
        return true;
      }
      if ((this.c.cloudType != 3) && (this.c.cloudType != 6))
      {
        fU("FlowShow", "cloudeType " + this.c.cloudType + " is not local File donot show!");
        return false;
      }
      l2 = anaz.gQ();
      fU("FlowShow", "last Succ " + this.c.lastSuccessTime + " now " + anaz.gQ() + " = " + (l2 - this.c.lastSuccessTime) + " limit[" + l1 + "]");
    } while (l2 - this.c.lastSuccessTime < l1);
    fU("FlowShow", "Must show!");
    return true;
  }
  
  public void e(Activity paramActivity, int paramInt1, int paramInt2)
  {
    d(paramActivity, paramInt2, paramInt1);
  }
  
  public void q(Activity paramActivity, int paramInt)
  {
    if (this.c.nFileType == 2)
    {
      if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
        ahao.OS(2131696743);
      }
      ahab localahab;
      boolean bool1;
      do
      {
        return;
        if ((this.c.getCloudType() != 1) || (!ahav.amK()) || (this.c.status == 2) || (this.c.fileSize <= 1048576L)) {
          break;
        }
        localahab = new ahab(this, paramActivity, paramInt);
        boolean bool2 = aqux.a(paramActivity, 2, new ahac(this, paramActivity, paramInt), "");
        bool1 = bool2;
        if (bool2) {
          bool1 = armm.a(paramActivity, 3, new ahad(this, paramActivity, paramInt));
        }
      } while (!bool1);
      ahal.a(paramActivity, paramActivity.getString(2131693826), paramActivity.getString(2131693828), localahab);
      return;
      r(paramActivity, paramInt);
      return;
    }
    d(paramActivity, paramInt, 10004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agzy
 * JD-Core Version:    0.7.0.1
 */