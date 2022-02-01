import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agpf
{
  private static agpf a;
  private QQAppInterface mApp;
  
  public static agpf a()
  {
    try
    {
      if (a == null) {
        a = new agpf();
      }
      agpf localagpf = a;
      return localagpf;
    }
    finally {}
  }
  
  public boolean alR()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().ahs();
    }
    return false;
  }
  
  public boolean alS()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().ahs();
    }
    return false;
  }
  
  public boolean alT()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().ahs();
    }
    return false;
  }
  
  public boolean alU()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().ahs();
    }
    return false;
  }
  
  public ExcitingTransferDownloadConfig b()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public ExcitingTransferUploadChnConfigInfo b()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().a();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public ExcitingTransferDownloadConfig c()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public ExcitingTransferUploadChnConfigInfo c()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().a();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public long fT()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().fx();
    }
    return 20971520L;
  }
  
  public long fU()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().fx();
    }
    return 20971520L;
  }
  
  public long fV()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().fx();
    }
    return 20971520L;
  }
  
  public long fW()
  {
    agiq localagiq = (agiq)this.mApp.getManager(317);
    if (localagiq.a() != null) {
      return localagiq.a().fx();
    }
    return 20971520L;
  }
  
  @Deprecated
  public boolean getConfigFromServer()
  {
    return false;
  }
  
  @Deprecated
  public ExcitingTransferDownloadConfig getMuiltDownloadConfig()
  {
    return ((agiq)this.mApp.getManager(317)).a().b();
  }
  
  public long getSelfUin()
  {
    if (this.mApp == null) {
      return 0L;
    }
    return this.mApp.getLongAccountUin();
  }
  
  public void release()
  {
    this.mApp = null;
  }
  
  public List<ExcitingTransferHostInfo> t(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ConfigManager.getInstance(this.mApp.getApp().getBaseContext(), this.mApp.getHwEngine());
    if (localObject1 != null)
    {
      Object localObject2 = ((ConfigManager)localObject1).getIpList(this.mApp.getApp().getBaseContext(), paramBoolean);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          EndPoint localEndPoint = (EndPoint)((Iterator)localObject2).next();
          if ((localEndPoint != null) && (!TextUtils.isEmpty(localEndPoint.host))) {
            if (paramBoolean) {
              localArrayList.add(new ExcitingTransferHostInfo("[" + localEndPoint.host + "]", localEndPoint.port));
            } else {
              localArrayList.add(new ExcitingTransferHostInfo(localEndPoint.host, localEndPoint.port));
            }
          }
        }
      }
      if (localArrayList.size() == 0)
      {
        localObject1 = ((ConfigManager)localObject1).getNextSrvAddr(this.mApp.getApp().getBaseContext(), this.mApp, this.mApp.getCurrentAccountUin(), paramBoolean);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((EndPoint)localObject1).host)))
        {
          if (!paramBoolean) {
            break label328;
          }
          if (!aoln.qc(((EndPoint)localObject1).host)) {
            break label304;
          }
          localArrayList.add(new ExcitingTransferHostInfo("[" + ((EndPoint)localObject1).host + "]", ((EndPoint)localObject1).port));
        }
      }
    }
    return localArrayList;
    label304:
    localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject1).host, ((EndPoint)localObject1).port));
    return localArrayList;
    label328:
    localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject1).host, ((EndPoint)localObject1).port));
    return localArrayList;
  }
  
  public void z(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpf
 * JD-Core Version:    0.7.0.1
 */