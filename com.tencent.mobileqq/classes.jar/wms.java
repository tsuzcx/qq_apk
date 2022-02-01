import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class wms
  implements Manager
{
  public byte a;
  public int a;
  ante jdField_a_of_type_Ante = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final vzx jdField_a_of_type_Vzx = new wmu(this);
  private wmw jdField_a_of_type_Wmw;
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public wms(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = ((Boolean)((wjl)wjs.a(10)).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    c();
    DeviceProfileManager.a(this.jdField_a_of_type_Ante);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Vzx);
    this.d = ((vzv)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER)).f();
    b(false);
    paramQQAppInterface = wjl.e();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_Wmw = a(paramQQAppInterface);
      if (this.jdField_a_of_type_Wmw != null) {
        this.jdField_a_of_type_Wmw.jdField_b_of_type_Boolean = wjl.f();
      }
    }
  }
  
  private wmw a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      ykq.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    try
    {
      wmw localwmw = new wmw();
      JSONObject localJSONObject = new JSONObject(paramString);
      localwmw.jdField_a_of_type_Long = localJSONObject.optLong("startTime", -1L);
      localwmw.jdField_b_of_type_Long = localJSONObject.optLong("endTime", -1L);
      localwmw.jdField_a_of_type_JavaLangString = localJSONObject.optString("imageUrl", "");
      localwmw.jdField_b_of_type_JavaLangString = localJSONObject.optString("desc", "");
      localwmw.c = localJSONObject.optString("jumpUrl", "");
      localwmw.d = localJSONObject.optString("contentId", "");
      if (localJSONObject.optInt("oneTimeUse", 0) == 1) {}
      for (;;)
      {
        localwmw.jdField_a_of_type_Boolean = bool;
        return localwmw;
        bool = false;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      ykq.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig config error config=" + paramString, localJSONException);
    }
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c) || (this.jdField_a_of_type_Byte != 0) || (this.h) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ykq.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
    this.h = true;
    Object localObject = SosoInterface.getSosoInfo();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).mLocation != null)) {}
    long l1;
    long l2;
    for (localObject = new wmy(((SosoInterface.SosoLbsInfo)localObject).mLocation.cityCode);; localObject = new wmy(null))
    {
      vzv localvzv = (vzv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
      wmt localwmt = new wmt(this, (vzu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER), localvzv);
      l1 = localvzv.a();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      wfi.a().a((wfm)localObject, localwmt);
      ykq.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    ykq.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
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
    ((ntj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).notifyUI(105, true, null);
    ((vzu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Ante == null) {
      this.jdField_a_of_type_Ante = new wmv(this);
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
    vzu localvzu;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localvzu = (vzu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
      if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      localvzu.notifyUI(1022, true, Boolean.valueOf(bool));
      return;
    }
  }
  
  public wmw a()
  {
    return this.jdField_a_of_type_Wmw;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wmw = null;
    wjl.e(false);
    wjl.f("");
    ykq.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    wmx localwmx = new wmx();
    wad.a().dispatch(localwmx);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    vzv localvzv = (vzv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
    this.d = paramBoolean;
    localvzv.i(paramBoolean);
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
    return (DeviceProfileManager.a(str, arrayOfInteger, new antj()) < 0) || (arrayOfInteger[0].intValue() == 1);
  }
  
  public boolean a(String paramString)
  {
    wmw localwmw = a(paramString);
    if (localwmw != null)
    {
      if (TextUtils.isEmpty(localwmw.d)) {
        ykq.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
      }
    }
    else {
      return false;
    }
    if ((this.jdField_a_of_type_Wmw != null) && (TextUtils.equals(this.jdField_a_of_type_Wmw.d, localwmw.d)))
    {
      ykq.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
      return false;
    }
    ykq.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_Wmw, paramString);
    this.jdField_a_of_type_Wmw = localwmw;
    wjl.e(false);
    wjl.f(paramString);
    paramString = new wmx();
    wad.a().dispatch(paramString);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Vzx);
    }
    DeviceProfileManager.b(this.jdField_a_of_type_Ante);
    this.jdField_a_of_type_Ante = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wms
 * JD-Core Version:    0.7.0.1
 */