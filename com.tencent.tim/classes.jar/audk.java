import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class audk
{
  private final String TAG = "FileModel<FileAssistant>";
  private FileManagerEntity c;
  private int mEntranceType = -1;
  
  public static audk a(FileManagerEntity paramFileManagerEntity)
  {
    audk localaudk = new audk();
    if ((paramFileManagerEntity == null) && (QLog.isDevelopLevel())) {
      throw new NullPointerException("newFileModel entity is null!");
    }
    localaudk.c = paramFileManagerEntity;
    return localaudk;
  }
  
  private void cC(Activity paramActivity)
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
      cD(paramActivity);
    }
  }
  
  private void cD(Activity paramActivity)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label14:
      Object localObject3;
      break label14;
    }
    if (localObject1 == null)
    {
      QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
      return;
    }
    localObject3 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject3).setType(10004);
    if (this.c.bSend) {}
    for (localObject2 = ((QQAppInterface)localObject1).getAccount();; localObject2 = this.c.peerUin)
    {
      ((ForwardFileInfo)localObject3).Oj(this.c.getCloudType());
      ((ForwardFileInfo)localObject3).jA(Long.valueOf(((String)localObject2).replace("+", "")).longValue());
      ((ForwardFileInfo)localObject3).jB(this.c.uniseq);
      ((ForwardFileInfo)localObject3).p(this.c.nSessionId);
      ((ForwardFileInfo)localObject3).setFileName(this.c.fileName);
      ((ForwardFileInfo)localObject3).setFileSize(this.c.fileSize);
      ((ForwardFileInfo)localObject3).setUuid(this.c.Uuid);
      ((ForwardFileInfo)localObject3).setLocalPath(this.c.getFilePath());
      ((ForwardFileInfo)localObject3).setFileType(this.c.nFileType);
      if (this.c.getCloudType() == 9)
      {
        this.c.cloudFile = athu.a(this.c);
        ((QQAppInterface)localObject1).a().v(this.c);
      }
      localObject2 = new Intent(paramActivity, FileBrowserActivity.class);
      ((Intent)localObject2).putExtra("qfile_browser_entrance_type", this.mEntranceType);
      ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject3);
      if (audx.fM(this.c.fileName) != 0) {
        break label390;
      }
      localObject3 = ((QQAppInterface)localObject1).b().f(this.c.peerUin, this.c.peerType);
      if ((localObject3 == null) || (((List)localObject3).size() == 0)) {
        break;
      }
      localObject1 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject3).next();
        if ((localChatMessage.msgtype == -2005) || (localChatMessage.msgtype == -2014)) {
          ((ArrayList)localObject1).add(String.valueOf(localChatMessage.uniseq));
        }
      }
    }
    ((Intent)localObject2).putStringArrayListExtra("Aio_Uinseq_ImageList", (ArrayList)localObject1);
    label390:
    ((Intent)localObject2).putExtra("selfSet_leftViewText", "返回");
    paramActivity.startActivityForResult((Intent)localObject2, 102);
    paramActivity.overridePendingTransition(2130772077, 2130772079);
  }
  
  private void fU(String paramString1, String paramString2)
  {
    QLog.i("FileModel<FileAssistant>" + paramString1, 1, "Id[" + this.c.nSessionId + "]" + paramString2);
  }
  
  public void Oy(int paramInt)
  {
    this.mEntranceType = paramInt;
  }
  
  public void a(boolean paramBoolean, Context paramContext, ahal.a parama)
  {
    if (!aqiw.bW(BaseApplicationImpl.getContext()))
    {
      auds.OS(2131694663);
      return;
    }
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      if (!bd(bool)) {
        break label66;
      }
      if (!paramBoolean) {
        break label58;
      }
    }
    label58:
    for (int i = 2131693832;; i = 2131693828)
    {
      ahal.a(paramContext, 2131693826, i, parama);
      return;
      bool = false;
      break;
    }
    label66:
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
        if (!audx.amK())
        {
          fU("FlowShow", " donot ShowFlowDialog! Wi-Fi");
          return false;
        }
        l2 = atvz.fJ();
        l1 = atvz.fK();
        fU("FlowShow", "fileSize " + this.c.fileSize + ",limit  " + l2);
      } while (this.c.fileSize < l2);
      if (paramBoolean)
      {
        fU("FlowShow", "download model so Show!");
        return true;
      }
      if ((this.c.cloudType != 3) || (this.c.cloudType != 6))
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
  
  public void cB(Activity paramActivity)
  {
    if (this.c.nFileType == 2)
    {
      if (this.c.getCloudType() == 1)
      {
        if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
        {
          auds.OS(2131696743);
          return;
        }
        if ((this.c.status != 2) && (bd(true)))
        {
          ahal.a(paramActivity, 2131693826, 2131693828, new audl(this, paramActivity));
          return;
        }
      }
      cC(paramActivity);
      return;
    }
    cD(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     audk
 * JD-Core Version:    0.7.0.1
 */