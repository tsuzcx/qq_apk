import QQService.InstanceInfo;
import RegisterProxySvcPack.OnlineInfos;
import RegisterProxySvcPack.SvcRespParam;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import mqq.manager.Manager;

public class rwp
  implements Manager
{
  private QQAppInterface mApp;
  private ArrayList<rwo> nQ;
  private ArrayList<rwp.a> nR;
  
  public rwp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private void bxi()
  {
    if ((this.nQ != null) && (this.nQ.size() > 1)) {
      Collections.sort(this.nQ, new rwq(this));
    }
  }
  
  public void a(rwp.a parama)
  {
    try
    {
      if (this.nR == null) {
        this.nR = new ArrayList();
      }
      if (!this.nR.contains(parama)) {
        this.nR.add(parama);
      }
      if (parama != null) {
        parama.cw(this.nQ);
      }
      return;
    }
    finally {}
  }
  
  public boolean a(SvcRespParam paramSvcRespParam)
  {
    boolean bool = true;
    if ((paramSvcRespParam == null) || (paramSvcRespParam.onlineinfos == null))
    {
      bool = false;
      return bool;
    }
    if (this.nQ == null) {
      this.nQ = new ArrayList();
    }
    this.nQ.clear();
    Iterator localIterator = paramSvcRespParam.onlineinfos.iterator();
    int i = 0;
    label56:
    while (localIterator.hasNext())
    {
      OnlineInfos localOnlineInfos = (OnlineInfos)localIterator.next();
      if (localOnlineInfos.onlineStatus != 0)
      {
        int j = (int)localOnlineInfos.uClientType;
        if (rwr.fc(j))
        {
          rwo localrwo = new rwo(j);
          localrwo.Cz = localOnlineInfos.instanceId;
          this.nQ.add(localrwo);
          if (QLog.isDevelopLevel()) {
            QLog.d("LoginDevicesManager", 4, localrwo.toString());
          }
        }
        if ((j != 66818) && (j != 66831)) {
          break label326;
        }
        i = 1;
      }
    }
    label326:
    for (;;)
    {
      break label56;
      if ((i == 0) && (paramSvcRespParam.PCstat != 0) && ((paramSvcRespParam.iPCClientType == 65793) || (paramSvcRespParam.iPCClientType == 77313)))
      {
        paramSvcRespParam = new rwo(paramSvcRespParam.iPCClientType);
        this.nQ.add(0, paramSvcRespParam);
        if (QLog.isDevelopLevel()) {
          QLog.d("LoginDevicesManager", 4, paramSvcRespParam.toString());
        }
      }
      bxi();
      if (QLog.isColorLevel()) {
        QLog.d("LoginDevicesManager", 2, new Object[] { "updateDevListByRegPrxy size:", Integer.valueOf(this.nQ.size()) });
      }
      if (this.nR != null)
      {
        paramSvcRespParam = this.nR.iterator();
        while (paramSvcRespParam.hasNext()) {
          ((rwp.a)paramSvcRespParam.next()).cw(this.nQ);
        }
      }
      if (this.nQ.size() > 0) {
        break;
      }
      return false;
    }
  }
  
  public String ao(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.nQ != null)
    {
      Iterator localIterator = this.nQ.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((rwo)localIterator.next()).mDeviceName).append("、");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf("、"));
    }
    return paramContext.getString(2131717159, new Object[] { localStringBuilder.toString() });
  }
  
  public void b(rwp.a parama)
  {
    try
    {
      if (this.nR != null) {
        this.nR.remove(parama);
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public String nj()
  {
    if ((this.nQ == null) || (this.nQ.size() < 1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = (aejn)aeif.a().o(528);
    if ((this.mApp != null) && (((aejn)localObject).cNu == 1)) {}
    for (boolean bool = SettingCloneUtil.readValue(this.mApp.getApplication(), this.mApp.getCurrentUin(), null, "qqsetting_qrlogin_set_mute", false);; bool = false)
    {
      if (this.nQ.size() == 1)
      {
        localObject = (rwo)this.nQ.get(0);
        localStringBuilder.append(((rwo)localObject).mDeviceName).append(" ").append(((rwo)localObject).mAppName).append(" ").append(acfp.m(2131695505));
        if (bool) {
          localStringBuilder.append("，").append(acfp.m(2131696839));
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append(acfp.m(2131701306));
        localObject = this.nQ.iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append(((rwo)((Iterator)localObject).next()).mDeviceName).append("、");
        }
        if (bool)
        {
          localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), "，");
          localStringBuilder.append(acfp.m(2131696839));
        }
        else
        {
          localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), "。");
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.nQ != null)
    {
      this.nQ.clear();
      this.nQ = null;
    }
    if (this.nR != null)
    {
      this.nR.clear();
      this.nR = null;
    }
  }
  
  public int uc()
  {
    if ((this.nQ == null) || (this.nQ.size() < 1)) {
      return 0;
    }
    if (this.nQ.size() > 1) {
      return 4;
    }
    return ((rwo)this.nQ.get(0)).xN;
  }
  
  public boolean w(ArrayList<InstanceInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    if (this.nQ == null) {
      this.nQ = new ArrayList();
    }
    this.nQ.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      InstanceInfo localInstanceInfo = (InstanceInfo)paramArrayList.next();
      int i = (int)localInstanceInfo.iClientType;
      if (rwr.fc(i))
      {
        rwo localrwo = new rwo(i);
        localrwo.Cz = localInstanceInfo.iAppId;
        this.nQ.add(localrwo);
        if (QLog.isDevelopLevel()) {
          QLog.d("LoginDevicesManager", 4, localrwo.toString());
        }
      }
    }
    bxi();
    if (QLog.isColorLevel()) {
      QLog.d("LoginDevicesManager", 2, new Object[] { "updateDevListByOnlinePush size:", Integer.valueOf(this.nQ.size()) });
    }
    if (this.nR != null)
    {
      paramArrayList = this.nR.iterator();
      while (paramArrayList.hasNext()) {
        ((rwp.a)paramArrayList.next()).cw(this.nQ);
      }
    }
    if (this.nQ.size() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cw(ArrayList<rwo> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwp
 * JD-Core Version:    0.7.0.1
 */