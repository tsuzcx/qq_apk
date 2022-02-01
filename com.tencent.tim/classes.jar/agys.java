import android.app.Activity;
import android.content.res.Resources;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.1;
import com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.2;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agys
  implements agyr<FileManagerEntity>
{
  private Activity mActivity;
  private QQAppInterface mApp;
  
  public agys(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = paramActivity;
  }
  
  private void a(List<FileManagerEntity> paramList, agyx paramagyx)
  {
    if (paramList == null)
    {
      QLog.w("OfflineFileMultiOperate", 1, "fileList == null");
      return;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      paramagyx = (FileManagerEntity)paramList.next();
      if (aviz.a().a(this.mApp, this.mActivity, paramagyx, null, true)) {
        break label96;
      }
      i = 1;
    }
    label96:
    for (;;)
    {
      break;
      if (i != 0)
      {
        ahav.JI(this.mActivity.getString(2131700298));
        return;
      }
      ahao.JE(this.mActivity.getString(2131720628));
      return;
    }
  }
  
  public void a(List<FileManagerEntity> paramList, int paramInt, agyx paramagyx)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("OfflineFileMultiOperate", 1, "doFileMultiOperate no any file");
      return;
    }
    switch (paramInt)
    {
    default: 
      QLog.e("OfflineFileMultiOperate", 1, "doFileMultiOperate unkonw optype:" + paramInt);
      return;
    case 3: 
      b(paramList, paramagyx);
      return;
    case 1: 
      c(paramList, paramagyx);
      return;
    case 2: 
      d(paramList, paramagyx);
      return;
    case 4: 
      e(paramList, paramagyx);
      return;
    }
    a(paramList, paramagyx);
  }
  
  protected void b(List<FileManagerEntity> paramList, agyx paramagyx)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FileManagerEntity)localIterator.next();
      localObject = this.mApp.b().b(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).uniseq);
      if (localObject != null) {
        localArrayList.add((ChatMessage)localObject);
      }
    }
    if (localArrayList.size() > 0)
    {
      ThreadManager.post(new OfflineFileMultiOperate.1(this, localArrayList, paramList, paramagyx), 8, null, true);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OfflineFileMultiOperate.2(this, paramList, paramagyx));
  }
  
  protected void c(List<FileManagerEntity> paramList, agyx paramagyx)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.mActivity, 2131696348, 1).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
    }
    long l;
    do
    {
      return;
      l = 0L;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      ahao.OS(2131693694);
    } while (paramagyx == null);
    paramagyx.gg(1, 2);
    return;
    Object localObject = paramList.iterator();
    label90:
    FileManagerEntity localFileManagerEntity;
    if (((Iterator)localObject).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!agzy.a(localFileManagerEntity).bd(true)) {
        break label237;
      }
      l = localFileManagerEntity.fileSize + l;
    }
    label237:
    for (;;)
    {
      break label90;
      localObject = this.mApp.a();
      if ((ahav.amK()) && (l > agmx.fJ()))
      {
        ahav.b(false, this.mActivity, new agyt(this, paramList, (aghw)localObject, paramagyx));
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          ((aghw)localObject).l(localFileManagerEntity);
        }
      }
      if (paramagyx == null) {
        break;
      }
      paramagyx.gg(1, 0);
      return;
    }
  }
  
  protected void d(List<FileManagerEntity> paramList, agyx paramagyx)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.mActivity, 2131696348, 1).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
    }
    do
    {
      return;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      ahao.OS(2131693695);
    } while (paramagyx == null);
    paramagyx.gg(2, 3);
    return;
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!agzy.a((FileManagerEntity)localIterator.next()).bd(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ahal.a(this.mActivity, 2131693826, 2131693832, new agyu(this, paramList, paramagyx));
        return;
      }
      ahav.b(paramList, this.mActivity);
      if (paramagyx == null) {
        break;
      }
      paramagyx.gg(2, 0);
      return;
    }
  }
  
  protected void e(List<FileManagerEntity> paramList, agyx paramagyx)
  {
    Object localObject1 = (FileManagerEntity)paramList.get(0);
    localObject1 = this.mApp.a();
    if ((paramList.size() == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      ahao.OS(2131693696);
      return;
    }
    Object localObject2 = paramList.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!agzy.a((FileManagerEntity)((Iterator)localObject2).next()).bd(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (!armm.a(this.mActivity, 5, new agyv(this, paramList, (aghw)localObject1, paramagyx))) {
          break;
        }
        ahal.a(this.mActivity, 2131693826, 2131693830, new agyw(this, paramList, (aghw)localObject1, paramagyx));
        return;
      }
      ahao.JG(this.mActivity.getString(2131694101));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (FileManagerEntity)paramList.next();
        if (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()) {
          if (aqhq.fileExistsAndNotEmpty(((FileManagerEntity)localObject2).getFilePath())) {
            ((aghw)localObject1).a(((FileManagerEntity)localObject2).getFilePath(), "", this.mApp.getCurrentAccountUin(), 0, false);
          } else {
            ((aghw)localObject1).a((FileManagerEntity)localObject2, String.valueOf(((FileManagerEntity)localObject2).peerUin));
          }
        }
      }
      if (paramagyx == null) {
        break;
      }
      paramagyx.gg(4, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agys
 * JD-Core Version:    0.7.0.1
 */