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

public class vxx
  implements Manager
{
  public byte a;
  public int a;
  amqq jdField_a_of_type_Amqq = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final vlc jdField_a_of_type_Vlc = new vxz(this);
  private vyb jdField_a_of_type_Vyb;
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public vxx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = ((Boolean)((vuq)vux.a(10)).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    c();
    DeviceProfileManager.a(this.jdField_a_of_type_Amqq);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Vlc);
    this.d = ((vla)paramQQAppInterface.getManager(181)).f();
    b(false);
    paramQQAppInterface = vuq.e();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_Vyb = a(paramQQAppInterface);
      if (this.jdField_a_of_type_Vyb != null) {
        this.jdField_a_of_type_Vyb.jdField_b_of_type_Boolean = vuq.f();
      }
    }
  }
  
  private vyb a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      xvv.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    try
    {
      vyb localvyb = new vyb();
      JSONObject localJSONObject = new JSONObject(paramString);
      localvyb.jdField_a_of_type_Long = localJSONObject.optLong("startTime", -1L);
      localvyb.jdField_b_of_type_Long = localJSONObject.optLong("endTime", -1L);
      localvyb.jdField_a_of_type_JavaLangString = localJSONObject.optString("imageUrl", "");
      localvyb.jdField_b_of_type_JavaLangString = localJSONObject.optString("desc", "");
      localvyb.c = localJSONObject.optString("jumpUrl", "");
      localvyb.d = localJSONObject.optString("contentId", "");
      if (localJSONObject.optInt("oneTimeUse", 0) == 1) {}
      for (;;)
      {
        localvyb.jdField_a_of_type_Boolean = bool;
        return localvyb;
        bool = false;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      xvv.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig config error config=" + paramString, localJSONException);
    }
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c) || (this.jdField_a_of_type_Byte != 0) || (this.h) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    xvv.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
    this.h = true;
    Object localObject = SosoInterface.getSosoInfo();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).mLocation != null)) {}
    long l1;
    long l2;
    for (localObject = new vyd(((SosoInterface.SosoLbsInfo)localObject).mLocation.cityCode);; localObject = new vyd(null))
    {
      vla localvla = (vla)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
      vxy localvxy = new vxy(this, (vkz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(98), localvla);
      l1 = localvla.a();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      vqn.a().a((vqr)localObject, localvxy);
      xvv.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    xvv.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
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
    ((nmj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(43)).notifyUI(105, true, null);
    ((vkz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(98)).notifyUI(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Amqq == null) {
      this.jdField_a_of_type_Amqq = new vya(this);
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
    vkz localvkz;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localvkz = (vkz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(98);
      if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localvkz.notifyUI(1022, true, Boolean.valueOf(bool));
      return;
    }
  }
  
  public vyb a()
  {
    return this.jdField_a_of_type_Vyb;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vyb = null;
    vuq.e(false);
    vuq.f("");
    xvv.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    vyc localvyc = new vyc();
    vli.a().dispatch(localvyc);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    vla localvla = (vla)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
    this.d = paramBoolean;
    localvla.i(paramBoolean);
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
    return (DeviceProfileManager.a(str, arrayOfInteger, new amqv()) < 0) || (arrayOfInteger[0].intValue() == 1);
  }
  
  public boolean a(String paramString)
  {
    vyb localvyb = a(paramString);
    if (localvyb != null)
    {
      if (TextUtils.isEmpty(localvyb.d)) {
        xvv.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
      }
    }
    else {
      return false;
    }
    if ((this.jdField_a_of_type_Vyb != null) && (TextUtils.equals(this.jdField_a_of_type_Vyb.d, localvyb.d)))
    {
      xvv.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
      return false;
    }
    xvv.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_Vyb, paramString);
    this.jdField_a_of_type_Vyb = localvyb;
    vuq.e(false);
    vuq.f(paramString);
    paramString = new vyc();
    vli.a().dispatch(paramString);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Vlc);
    }
    DeviceProfileManager.b(this.jdField_a_of_type_Amqq);
    this.jdField_a_of_type_Amqq = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxx
 * JD-Core Version:    0.7.0.1
 */