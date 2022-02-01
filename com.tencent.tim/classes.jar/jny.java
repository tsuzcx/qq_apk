import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_search_searchtab.searchtab.ReqBody;
import tencent.im.troop_search_searchtab.searchtab.RspBody;
import tencent.im.troop_search_userinfo.userinfo.AppInfo;
import tencent.im.troop_search_userinfo.userinfo.GPS;
import tencent.im.troop_search_userinfo.userinfo.UserInfo;

public class jny
{
  protected QQAppInterface mApp;
  
  public jny(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private userinfo.UserInfo a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    userinfo.UserInfo localUserInfo = new userinfo.UserInfo();
    Object localObject;
    if (paramSosoLbsInfo != null)
    {
      localObject = new userinfo.GPS();
      ((userinfo.GPS)localObject).uint32_lat.set(Double.valueOf(paramSosoLbsInfo.a.cd * 1000000.0D).intValue());
      ((userinfo.GPS)localObject).uint32_lon.set(Double.valueOf(paramSosoLbsInfo.a.ce * 1000000.0D).intValue());
      localUserInfo.gps.set((MessageMicro)localObject);
    }
    try
    {
      if (!TextUtils.isEmpty(this.mApp.getCurrentAccountUin())) {
        localUserInfo.uin.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
      }
      paramSosoLbsInfo = new userinfo.AppInfo();
      paramSosoLbsInfo.plat_type.set(2);
      paramSosoLbsInfo.str_app_version.set(aqgz.getQQVersion());
      localUserInfo.app_info.set(paramSosoLbsInfo);
      localUserInfo.bytes_client_version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
      paramSosoLbsInfo = (TicketManager)this.mApp.getManager(2);
      localObject = this.mApp.getAccount();
      if (!TextUtils.isEmpty(paramSosoLbsInfo.getSkey((String)localObject))) {
        localUserInfo.skey.set(paramSosoLbsInfo.getSkey((String)localObject));
      }
      return localUserInfo;
    }
    catch (Exception paramSosoLbsInfo)
    {
      for (;;)
      {
        paramSosoLbsInfo.printStackTrace();
      }
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactTroopHandler", 2, "sendRequest:" + paramString);
    }
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), jnl.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.setObserver(paramBusinessObserver);
    this.mApp.startServlet(localNewIntent);
  }
  
  private void a(userinfo.UserInfo paramUserInfo, jny.a parama)
  {
    searchtab.ReqBody localReqBody = new searchtab.ReqBody();
    localReqBody.user_info.set(paramUserInfo);
    localReqBody.uint32_label_style.set(1);
    a("SearchAsmTab.GetPopClassific", localReqBody.toByteArray(), new jny.b(parama, this.mApp, 1));
  }
  
  public void a(jny.a parama)
  {
    try
    {
      a(a(null), parama);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      parama.ayE();
    }
  }
  
  public static abstract interface a
  {
    public abstract void ayD();
    
    public abstract void ayE();
  }
  
  public static class b
    implements BusinessObserver
  {
    protected WeakReference<jny.a> bU;
    protected WeakReference<QQAppInterface> bV;
    protected int reqType;
    
    public b(jny.a parama, QQAppInterface paramQQAppInterface, int paramInt)
    {
      this.bU = new WeakReference(parama);
      this.bV = new WeakReference(paramQQAppInterface);
      this.reqType = paramInt;
    }
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      boolean bool2 = false;
      jny.a locala = (jny.a)this.bU.get();
      Object localObject1 = (QQAppInterface)this.bV.get();
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("InfoReqObserver: type=").append(paramInt).append(", reqType=").append(this.reqType).append(", isSucc=").append(paramBoolean).append(", cbIsNull=");
        if (locala != null) {
          break label270;
        }
      }
      label269:
      label270:
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject2 = ((StringBuilder)localObject2).append(bool1).append(", appIsNull=");
        bool1 = bool2;
        if (localObject1 == null) {
          bool1 = true;
        }
        QLog.d("AddContactTroopHandler", 2, bool1);
        if ((locala != null) && (localObject1 != null)) {
          if ((paramBoolean) && (paramBundle != null)) {
            try
            {
              paramBundle = paramBundle.getByteArray("data");
              if (paramBundle != null)
              {
                localObject1 = (jnz)((QQAppInterface)localObject1).getManager(80);
                if (this.reqType == 1)
                {
                  localObject2 = new popclassifc.RspBody();
                  ((popclassifc.RspBody)localObject2).mergeFrom(paramBundle);
                  ((jnz)localObject1).a((popclassifc.RspBody)localObject2);
                  locala.ayD();
                  return;
                }
                if (this.reqType != 2) {
                  break label269;
                }
                localObject2 = new searchtab.RspBody();
                ((searchtab.RspBody)localObject2).mergeFrom(paramBundle);
                ((jnz)localObject1).a((searchtab.RspBody)localObject2);
                locala.ayD();
                return;
              }
            }
            catch (Exception paramBundle)
            {
              if (QLog.isColorLevel()) {
                QLog.e("AddContactTroopHandler", 2, "InfoReqObserver exp:", paramBundle);
              }
            }
          } else {
            locala.ayE();
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jny
 * JD-Core Version:    0.7.0.1
 */