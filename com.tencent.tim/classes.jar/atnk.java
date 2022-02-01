import android.content.Intent;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.dingdong.DingdongPluginBizObserver;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.b;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.c;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.f;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.g;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.h;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.i;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.j;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.l;
import com.tencent.tim.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import com.tencent.tim.dingdong.DingdongPluginRemoteCmdHandler;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class atnk
  extends DingdongPluginBizObserver
  implements Manager
{
  public static final long ayA = ;
  private acfd jdField_a_of_type_Acfd = new atnl(this);
  private atnq jdField_a_of_type_Atnq;
  private final DingdongPluginRemoteCmdHandler jdField_a_of_type_ComTencentTimDingdongDingdongPluginRemoteCmdHandler;
  private int eqB;
  private int eqC;
  private int eqD;
  private QQAppInterface mApp;
  private boolean mDestroyed;
  private final HashMap<Long, Object> qf = new HashMap(10);
  
  public atnk(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentTimDingdongDingdongPluginRemoteCmdHandler = new DingdongPluginRemoteCmdHandler();
    this.jdField_a_of_type_ComTencentTimDingdongDingdongPluginRemoteCmdHandler.euj();
    this.mApp.addObserver(this);
    this.mApp.addObserver(this.jdField_a_of_type_Acfd);
    this.jdField_a_of_type_Atnq = new atnq(this.mApp);
  }
  
  private boolean bH(boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("actionType", 1);
      if (paramBoolean)
      {
        localJSONObject.put("actionUin", acbn.blq);
        localJSONObject.put("actionUinType", 9999);
      }
      this.mApp.b().as(localJSONObject);
      return true;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }
  
  public void L(String paramString, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("_source_id_", paramString);
    localIntent.putExtra("_from_uin_", String.valueOf(paramLong));
    localIntent.putExtra("_source_type_", paramInt);
    atni.K(2, localIntent);
  }
  
  public int Ow()
  {
    return this.eqD;
  }
  
  public void YT(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("_source_id_", paramString);
    atni.K(5, localIntent);
  }
  
  public void YU(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("_source_id_", paramString);
    atni.K(7, localIntent);
  }
  
  public void YV(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("_source_id_", paramString);
    atni.K(6, localIntent);
  }
  
  public void YW(String paramString)
  {
    String str = aqgv.s(this.mApp, paramString);
    if ((str != null) && (!str.equalsIgnoreCase(paramString)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("_uin_", paramString);
      localIntent.putExtra("_nick_", str);
      atni.K(4, localIntent);
    }
  }
  
  public void a(atnq.a parama)
  {
    this.jdField_a_of_type_Atnq.b(parama);
  }
  
  public void a(DingdongPluginBizObserver.b paramb)
  {
    if (!this.mDestroyed)
    {
      if (paramb.errCode == 0) {}
      Object localObject1;
      switch (paramb.eqv)
      {
      default: 
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("_source_type_", paramb.sourceType);
        ((Intent)localObject1).putExtra("_source_id_", paramb.sourceId);
        ((Intent)localObject1).putExtra("_from_uin_", paramb.fromUin);
        ((Intent)localObject1).putExtra("_changed_type_", paramb.eqv);
        ((Intent)localObject1).putExtra("_feed_id_", paramb.feedId);
        ((Intent)localObject1).putExtra("_push_proto_", 1);
        atni.K(1, (Intent)localObject1);
        if (atni.aJj()) {
          QQToast.a(BaseApplication.getContext(), "事项确认变化push，errCode[" + paramb.errCode + "].", 1).show();
        }
        return;
      }
      boolean bool2 = false;
      String str;
      boolean bool1;
      if (this.mApp.getCurrentAccountUin().equals(paramb.authorUin))
      {
        str = atni.c(paramb.sourceType, paramb.sourceId, paramb.fromUin) + this.mApp.getApplication().getString(2131692683);
        bool1 = bool2;
        localObject1 = str;
        if (2 == paramb.eqv)
        {
          localObject1 = str + this.mApp.getApplication().getString(2131692682);
          bool1 = bool2;
        }
      }
      for (;;)
      {
        str = this.mApp.getApplication().getString(2131692684);
        int i = ((String)localObject1).lastIndexOf(str);
        Object localObject2 = "mqqapi://asyncmsg/showdetail?src_type=internal&version=1&feedsid=" + paramb.feedId + "&fsc=" + paramb.sourceId + "&fst=" + paramb.sourceType;
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 3);
        localBundle.putString("key_action_DATA", (String)localObject2);
        localBundle.putString("key_a_action_DATA", (String)localObject2);
        localObject2 = (MessageForGrayTips)anbi.d(-2034);
        ((MessageForGrayTips)localObject2).init(this.mApp.getCurrentAccountUin(), paramb.sourceId, paramb.fromUin, (String)localObject1, NetConnInfoCenter.getServerTime(), -2034, atni.lb(paramb.sourceType), 0L);
        ((MessageForGrayTips)localObject2).msg = ((String)localObject1);
        ((MessageForGrayTips)localObject2).addHightlightItem(i, str.length() + i, localBundle);
        ((MessageForGrayTips)localObject2).isread = bool1;
        this.mApp.b().b((MessageRecord)localObject2, this.mApp.getCurrentAccountUin());
        break;
        bool1 = true;
        localObject1 = String.format(this.mApp.getApplication().getString(2131692685), new Object[] { atni.c(paramb.sourceType, paramb.sourceId, paramb.authorUin) });
      }
    }
    QLog.e("DingdongPluginManager", 1, "onFeedConfirmNotify error: manager has been destroyed!");
  }
  
  public void a(DingdongPluginBizObserver.c paramc)
  {
    Object localObject;
    boolean bool2;
    if (!this.mDestroyed)
    {
      if (paramc.errCode == 0) {}
      switch (paramc.updateType)
      {
      case 2: 
      case 3: 
      default: 
        localObject = new Intent();
        ((Intent)localObject).putExtra("_source_type_", paramc.sourceType);
        ((Intent)localObject).putExtra("_source_id_", paramc.sourceId);
        ((Intent)localObject).putExtra("_from_uin_", paramc.fromUin);
        ((Intent)localObject).putExtra("_changed_type_", paramc.updateType);
        ((Intent)localObject).putExtra("_feed_id_", paramc.feedId);
        ((Intent)localObject).putExtra("_del_index_list_", paramc.Ee);
        ((Intent)localObject).putExtra("_push_proto_", 2);
        atni.K(1, (Intent)localObject);
        if (atni.aJj()) {
          QQToast.a(BaseApplication.getContext(), "事项状态变化push，errCode[" + paramc.errCode + "].", 1).show();
        }
        return;
      }
      bool2 = this.mApp.getCurrentAccountUin().equals(paramc.fromUin);
      if ((!bool2) || (1 != paramc.updateType) || (this.mApp.a().a().b(acbn.blq, 9999) != null)) {
        break label385;
      }
    }
    label385:
    for (boolean bool1 = false;; bool1 = true)
    {
      ((atnf)this.mApp.getBusinessHandler(75)).VD(bool1);
      if ((!bool2) || (6 != paramc.updateType)) {
        break;
      }
      localObject = this.mApp.getApplication().getString(2131692686);
      MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)anbi.d(-2034);
      localMessageForGrayTips.init(this.mApp.getCurrentAccountUin(), paramc.sourceId, paramc.fromUin, (String)localObject, NetConnInfoCenter.getServerTime(), -2034, atni.lb(paramc.sourceType), 0L);
      localMessageForGrayTips.msg = ((String)localObject);
      this.mApp.b().b(localMessageForGrayTips, this.mApp.getCurrentAccountUin());
      break;
      QLog.e("DingdongPluginManager", 1, "onFeedStateUpdate error: manager has been destroyed!");
      return;
    }
  }
  
  public void a(DingdongPluginBizObserver.g paramg)
  {
    if (!this.mDestroyed)
    {
      if ((paramg.errCode == 0) && (((paramg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$f == null) || (paramg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$f.errCode != 0)) || ((paramg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$l != null) && (paramg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$l.errCode == 0)))) {
        kQ(paramg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$l.unreadNum, paramg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$l.eqx);
      }
      if (atni.aJj()) {
        QQToast.a(BaseApplication.getContext(), "节点数据更新，errCode[" + paramg.errCode + "].", 1).show();
      }
      return;
    }
    QLog.e("DingdongPluginManager", 1, "onLastMessageUpdate error: manager has been destroyed!");
  }
  
  public void a(DingdongPluginBizObserver.h paramh)
  {
    if (paramh.errCode == 0) {
      switch (paramh.changeType)
      {
      }
    }
    for (;;)
    {
      super.a(paramh);
      return;
      synchronized (this.qf)
      {
        int i = paramh.changeType;
        DingdongPluginBizObserver.i locali = new DingdongPluginBizObserver.i();
        DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = new DingdongPluginDataFactory.ScheduleSummaryData();
        localScheduleSummaryData.id = paramh.id;
        locali.summaryData = localScheduleSummaryData;
      }
    }
  }
  
  public void a(DingdongPluginBizObserver.l paraml)
  {
    if (!this.mDestroyed)
    {
      if (paraml.errCode == 0) {
        kQ(paraml.unreadNum, paraml.eqx);
      }
      if (atni.aJj()) {
        QQToast.a(BaseApplication.getContext(), "未读数变化push，errCode[" + paraml.errCode + "].", 1).show();
      }
      return;
    }
    QLog.e("DingdongPluginManager", 1, "onUnreadNumUpdate error: manager has been destroyed!");
  }
  
  public void aay(int paramInt)
  {
    this.eqD = paramInt;
  }
  
  public void b(DingdongPluginBizObserver.j paramj)
  {
    if ((paramj.errCode == 0) && (paramj.summaryData != null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DingdongPluginManager", 2, "onScheduleNotification:" + bool);
      }
      if (bool)
      {
        if (!paramj.dim) {
          break;
        }
        this.jdField_a_of_type_Atnq.c(paramj);
      }
      return;
    }
    this.jdField_a_of_type_Atnq.d(paramj);
  }
  
  public void eui()
  {
    this.jdField_a_of_type_Atnq.b(null);
  }
  
  public void kQ(int paramInt1, int paramInt2)
  {
    int i = this.mApp.a().A(acbn.blq, 9999);
    if (paramInt1 == i) {
      if (QLog.isColorLevel()) {
        QLog.i("DingdongPluginManager", 2, "new unreadNum is the same with current unreadNum[" + i + "].");
      }
    }
    do
    {
      return;
      this.mApp.a().G(acbn.blq, 9999, paramInt1 - i);
      bH(true);
      this.eqB = paramInt1;
      this.eqC = paramInt2;
    } while (!QLog.isColorLevel());
    QLog.i("DingdongPluginManager", 2, "setUnreadNum:mCacheUnreadVersion[" + this.eqC + "], mCacheUnreadNum[" + this.eqB + "]");
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this);
    this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
    this.qf.clear();
    this.mDestroyed = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnk
 * JD-Core Version:    0.7.0.1
 */