import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.a;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ajdt
{
  private static ajdt a;
  private String bQQ;
  private int bizType;
  private String token;
  
  public static ajdt a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ajdt();
      }
      return a;
    }
    finally {}
  }
  
  private String[] b(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext != null)
    {
      paramContext = alkz.a(paramContext);
      arrayOfString[0] = paramContext.getSSID();
      arrayOfString[1] = paramContext.getBSSID();
    }
    return arrayOfString;
  }
  
  public int Gi()
  {
    return this.bizType;
  }
  
  public void LS(boolean paramBoolean)
  {
    Object localObject2 = b(BaseApplicationImpl.getContext());
    Object localObject1 = new MsgBackupUserData.a();
    ((MsgBackupUserData.a)localObject1).c(localObject2[1]);
    ((MsgBackupUserData.a)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    ((MsgBackupUserData.a)localObject1).a(ajgv.ez(ajgp.b().d().ipv4));
    ((List)localObject2).add(Integer.valueOf(ajgp.b().d().port));
    ((List)localObject2).add(Integer.valueOf(ajgp.b().c().port));
    ((MsgBackupUserData.a)localObject1).a(9);
    ((MsgBackupUserData.a)localObject1).a((List)localObject2);
    localObject1 = ((MsgBackupUserData.a)localObject1).b();
    ((ajds)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(162)).a((MsgBackupUserData)localObject1, this.bizType, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, "requestQR, userData: " + localObject1 + ", biztype = " + this.bizType + ", ispush = " + paramBoolean);
    }
  }
  
  public void Mr(String paramString)
  {
    this.bQQ = paramString;
  }
  
  public void QE(int paramInt)
  {
    ajgt.dxs();
    ajgt.a.bizType = paramInt;
    this.bizType = paramInt;
  }
  
  public void dws()
  {
    Object localObject2 = b(BaseApplicationImpl.getContext());
    Object localObject1 = new MsgBackupUserData.a();
    ((MsgBackupUserData.a)localObject1).c(localObject2[1]);
    ((MsgBackupUserData.a)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    if (this.bizType == 1)
    {
      ((MsgBackupUserData.a)localObject1).a(ajgv.ez(ajgp.b().d().ipv4));
      ((List)localObject2).add(Integer.valueOf(ajgp.b().d().port));
      ((List)localObject2).add(Integer.valueOf(ajgp.b().c().port));
    }
    for (;;)
    {
      ((MsgBackupUserData.a)localObject1).a(9);
      ((MsgBackupUserData.a)localObject1).a((List)localObject2);
      localObject1 = ((MsgBackupUserData.a)localObject1).b();
      ((ajds)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(162)).a((MsgBackupUserData)localObject1, this.bQQ, this.bizType);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, "confirmQrReq, userData: " + localObject1 + ", biztype = " + this.bizType + ", qr_sig = " + this.bQQ);
      }
      return;
      if (this.bizType == 2)
      {
        ((MsgBackupUserData.a)localObject1).a(ajgv.ez(ajgp.b().b().ipv4));
        ((List)localObject2).add(Integer.valueOf(ajgp.b().b().port));
        ((List)localObject2).add(Integer.valueOf(ajgp.b().a().port));
      }
      else
      {
        ((MsgBackupUserData.a)localObject1).a(ajgv.ez(ajgp.b().b().ipv4));
        ((List)localObject2).add(Integer.valueOf(ajgp.b().b().port));
        ((List)localObject2).add(Integer.valueOf(ajgp.b().a().port));
      }
    }
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public String xj()
  {
    return this.bQQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajdt
 * JD-Core Version:    0.7.0.1
 */