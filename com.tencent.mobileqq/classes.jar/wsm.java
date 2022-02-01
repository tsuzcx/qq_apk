import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class wsm
  implements Manager
{
  public byte a;
  public int a;
  ankk jdField_a_of_type_Ankk = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final wfi jdField_a_of_type_Wfi = new wso(this);
  private wsq jdField_a_of_type_Wsq;
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public wsm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = ((Boolean)((wpf)wpm.a(10)).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    c();
    DeviceProfileManager.a(this.jdField_a_of_type_Ankk);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Wfi);
    this.d = ((wfg)paramQQAppInterface.getManager(181)).f();
    b(false);
    paramQQAppInterface = wpf.e();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_Wsq = a(paramQQAppInterface);
      if (this.jdField_a_of_type_Wsq != null) {
        this.jdField_a_of_type_Wsq.jdField_b_of_type_Boolean = wpf.j();
      }
    }
  }
  
  private wsq a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      yqp.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    try
    {
      wsq localwsq = new wsq();
      JSONObject localJSONObject = new JSONObject(paramString);
      localwsq.jdField_a_of_type_Long = localJSONObject.optLong("startTime", -1L);
      localwsq.jdField_b_of_type_Long = localJSONObject.optLong("endTime", -1L);
      localwsq.jdField_a_of_type_JavaLangString = localJSONObject.optString("imageUrl", "");
      localwsq.jdField_b_of_type_JavaLangString = localJSONObject.optString("desc", "");
      localwsq.c = localJSONObject.optString("jumpUrl", "");
      localwsq.d = localJSONObject.optString("contentId", "");
      if (localJSONObject.optInt("oneTimeUse", 0) == 1) {}
      for (;;)
      {
        localwsq.jdField_a_of_type_Boolean = bool;
        return localwsq;
        bool = false;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      yqp.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig config error config=" + paramString, localJSONException);
    }
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c) || (this.jdField_a_of_type_Byte != 0) || (this.h) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    yqp.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
    this.h = true;
    Object localObject = SosoInterface.b();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).a != null)) {}
    long l1;
    long l2;
    for (localObject = new wss(((SosoInterface.SosoLbsInfo)localObject).a.f);; localObject = new wss(null))
    {
      wfg localwfg = (wfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
      wsn localwsn = new wsn(this, (wff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98), localwfg);
      l1 = localwfg.a();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      wlb.a().a((wlf)localObject, localwsn);
      yqp.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    yqp.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "update cfg svr=" + this.jdField_b_of_type_Boolean + ", dpc=" + this.c + ", user=" + this.d);
    }
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1;
    if ((this.jdField_b_of_type_Boolean) && (this.c) && (this.d))
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Int = 52;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label113;
      }
    }
    label113:
    while ((!paramBoolean) || (bool2 == this.jdField_a_of_type_Boolean))
    {
      return;
      bool1 = false;
      break;
    }
    ((niz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).notifyUI(105, true, null);
    ((wff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).notifyUI(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Ankk == null) {
      this.jdField_a_of_type_Ankk = new wsp(this);
    }
  }
  
  private void d()
  {
    if ((this.e) && (this.g) && (this.f)) {
      b();
    }
  }
  
  private void e()
  {
    wff localwff;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localwff = (wff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98);
      if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localwff.notifyUI(1022, true, Boolean.valueOf(bool));
      return;
    }
  }
  
  public wsq a()
  {
    return this.jdField_a_of_type_Wsq;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wsq = null;
    wpf.f(false);
    wpf.g("");
    yqp.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    wsr localwsr = new wsr();
    wfo.a().dispatch(localwsr);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    wfg localwfg = (wfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
    this.d = paramBoolean;
    localwfg.i(paramBoolean);
    b(true);
  }
  
  public boolean a()
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.StoryCfg.name(), "1");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "getMsgTabDPC:" + str);
    }
    Integer[] arrayOfInteger;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfInteger = new Integer[1];
      arrayOfInteger[0] = Integer.valueOf(0);
    }
    return (DeviceProfileManager.a(str, arrayOfInteger, new ankp()) < 0) || (arrayOfInteger[0].intValue() == 1);
  }
  
  public boolean a(String paramString)
  {
    wsq localwsq = a(paramString);
    if (localwsq != null)
    {
      if (TextUtils.isEmpty(localwsq.d)) {
        yqp.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
      }
    }
    else {
      return false;
    }
    if ((this.jdField_a_of_type_Wsq != null) && (TextUtils.equals(this.jdField_a_of_type_Wsq.d, localwsq.d)))
    {
      yqp.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
      return false;
    }
    yqp.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_Wsq, paramString);
    this.jdField_a_of_type_Wsq = localwsq;
    wpf.f(false);
    wpf.g(paramString);
    paramString = new wsr();
    wfo.a().dispatch(paramString);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Wfi);
    }
    DeviceProfileManager.b(this.jdField_a_of_type_Ankk);
    this.jdField_a_of_type_Ankk = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsm
 * JD-Core Version:    0.7.0.1
 */