import PayMQQ.UniPayRequest;
import PayMQQ.UniPayResponse;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class acnj
  extends accg
{
  private ArrayList<acnj.a> mObservers = new ArrayList();
  
  public acnj(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void cNb()
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((acnj.a)localIterator.next()).update();
    }
  }
  
  public void FH(String paramString)
  {
    UniPayRequest localUniPayRequest;
    if (this.app == null) {
      localUniPayRequest = new UniPayRequest(this.mApp.getCurrentAccountUin(), "android" + paramString);
    }
    for (paramString = new ToServiceMsg("mobileqq.service", this.mApp.getCurrentAccountUin(), "VipSTCheckServer.UinPay");; paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "VipSTCheckServer.UinPay"))
    {
      paramString.extraData.putSerializable("UniPayRequest", localUniPayRequest);
      super.send(paramString);
      return;
      localUniPayRequest = new UniPayRequest(this.app.getCurrentAccountUin(), "android" + paramString);
    }
  }
  
  public void a(acnj.a parama)
  {
    if (parama == null) {}
    while (this.mObservers.contains(parama)) {
      return;
    }
    this.mObservers.add(parama);
  }
  
  public void b(acnj.a parama)
  {
    if ((parama != null) && (this.mObservers.contains(parama))) {
      this.mObservers.remove(parama);
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {}
    do
    {
      do
      {
        return;
        str1 = paramToServiceMsg.getServiceCmd();
      } while (TextUtils.isEmpty(str1));
      if ((str1.compareTo("VipSTCheckServer.UinPay") == 0) && (QLog.isColorLevel())) {
        QLog.i("UniPayHandler", 2, "req---" + paramToServiceMsg + ",res----" + paramFromServiceMsg + ",data-----" + paramObject);
      }
    } while (str1.compareTo("VipSTCheckServer.UinPay") != 0);
    paramFromServiceMsg = (UniPayResponse)paramObject;
    paramToServiceMsg = paramFromServiceMsg.getSUin();
    int i = paramFromServiceMsg.getIShowOpen();
    int j = paramFromServiceMsg.getIUniPayType();
    new HashMap();
    Object localObject = paramFromServiceMsg.getMapResponse();
    paramFromServiceMsg = (String)((Map)localObject).get("cur_st");
    paramObject = (String)((Map)localObject).get("net_mobile_club");
    String str1 = (String)((Map)localObject).get("open_month");
    String str2 = (String)((Map)localObject).get("platform");
    String str3 = (String)((Map)localObject).get("ret");
    String str4 = (String)((Map)localObject).get("show_open");
    String str5 = (String)((Map)localObject).get("uin");
    localObject = (String)((Map)localObject).get("uin_pay_type");
    if (QLog.isColorLevel()) {
      QLog.d("UniPayHandler", 2, "sUin==" + paramToServiceMsg + ",isShowOpen==" + i + ",iUniPayType==" + j);
    }
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences("uniPaySp_" + paramToServiceMsg, 4).edit();
    localEditor.putString("sUin", paramToServiceMsg);
    localEditor.putInt("isShowOpen", i);
    localEditor.putInt("iUinpPayType", j);
    localEditor.putString("cur_st", paramFromServiceMsg);
    localEditor.putString("net_mobile_club", paramObject);
    localEditor.putString("open_month", str1);
    localEditor.putString("platform", str2);
    localEditor.putString("ret", str3);
    localEditor.putString("show_open", str4);
    localEditor.putString("uin", str5);
    localEditor.putString("uin_pay_type", (String)localObject);
    localEditor.commit();
    cNb();
  }
  
  public static abstract class a
  {
    public abstract void update();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acnj
 * JD-Core Version:    0.7.0.1
 */