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

public class wwh
  implements Manager
{
  public byte a;
  public int a;
  anwh jdField_a_of_type_Anwh = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final wjd jdField_a_of_type_Wjd = new wwj(this);
  private wwl jdField_a_of_type_Wwl;
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public wwh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = ((Boolean)((wta)wth.a(10)).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    c();
    DeviceProfileManager.a(this.jdField_a_of_type_Anwh);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Wjd);
    this.d = ((wjb)paramQQAppInterface.getManager(181)).f();
    b(false);
    paramQQAppInterface = wta.e();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_Wwl = a(paramQQAppInterface);
      if (this.jdField_a_of_type_Wwl != null) {
        this.jdField_a_of_type_Wwl.jdField_b_of_type_Boolean = wta.j();
      }
    }
  }
  
  private wwl a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      yuk.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    try
    {
      wwl localwwl = new wwl();
      JSONObject localJSONObject = new JSONObject(paramString);
      localwwl.jdField_a_of_type_Long = localJSONObject.optLong("startTime", -1L);
      localwwl.jdField_b_of_type_Long = localJSONObject.optLong("endTime", -1L);
      localwwl.jdField_a_of_type_JavaLangString = localJSONObject.optString("imageUrl", "");
      localwwl.jdField_b_of_type_JavaLangString = localJSONObject.optString("desc", "");
      localwwl.c = localJSONObject.optString("jumpUrl", "");
      localwwl.d = localJSONObject.optString("contentId", "");
      if (localJSONObject.optInt("oneTimeUse", 0) == 1) {}
      for (;;)
      {
        localwwl.jdField_a_of_type_Boolean = bool;
        return localwwl;
        bool = false;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      yuk.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig config error config=" + paramString, localJSONException);
    }
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c) || (this.jdField_a_of_type_Byte != 0) || (this.h) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    yuk.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
    this.h = true;
    Object localObject = SosoInterface.b();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).a != null)) {}
    long l1;
    long l2;
    for (localObject = new wwn(((SosoInterface.SosoLbsInfo)localObject).a.f);; localObject = new wwn(null))
    {
      wjb localwjb = (wjb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
      wwi localwwi = new wwi(this, (wja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98), localwjb);
      l1 = localwjb.a();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      wow.a().a((wpa)localObject, localwwi);
      yuk.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    yuk.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
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
    ((nku)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).notifyUI(105, true, null);
    ((wja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).notifyUI(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Anwh == null) {
      this.jdField_a_of_type_Anwh = new wwk(this);
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
    wja localwja;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localwja = (wja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98);
      if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localwja.notifyUI(1022, true, Boolean.valueOf(bool));
      return;
    }
  }
  
  public wwl a()
  {
    return this.jdField_a_of_type_Wwl;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wwl = null;
    wta.f(false);
    wta.g("");
    yuk.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    wwm localwwm = new wwm();
    wjj.a().dispatch(localwwm);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    wjb localwjb = (wjb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
    this.d = paramBoolean;
    localwjb.i(paramBoolean);
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
    return (DeviceProfileManager.a(str, arrayOfInteger, new anwm()) < 0) || (arrayOfInteger[0].intValue() == 1);
  }
  
  public boolean a(String paramString)
  {
    wwl localwwl = a(paramString);
    if (localwwl != null)
    {
      if (TextUtils.isEmpty(localwwl.d)) {
        yuk.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
      }
    }
    else {
      return false;
    }
    if ((this.jdField_a_of_type_Wwl != null) && (TextUtils.equals(this.jdField_a_of_type_Wwl.d, localwwl.d)))
    {
      yuk.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
      return false;
    }
    yuk.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_Wwl, paramString);
    this.jdField_a_of_type_Wwl = localwwl;
    wta.f(false);
    wta.g(paramString);
    paramString = new wwm();
    wjj.a().dispatch(paramString);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Wjd);
    }
    DeviceProfileManager.b(this.jdField_a_of_type_Anwh);
    this.jdField_a_of_type_Anwh = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwh
 * JD-Core Version:    0.7.0.1
 */