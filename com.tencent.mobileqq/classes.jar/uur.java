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

public class uur
  implements Manager
{
  public byte a;
  public int a;
  almm jdField_a_of_type_Almm = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final uhn jdField_a_of_type_Uhn = new uut(this);
  private uuv jdField_a_of_type_Uuv;
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public uur(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = ((Boolean)((urk)urr.a(10)).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    c();
    DeviceProfileManager.a(this.jdField_a_of_type_Almm);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Uhn);
    this.d = ((uhl)paramQQAppInterface.getManager(181)).f();
    b(false);
    paramQQAppInterface = urk.e();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_Uuv = a(paramQQAppInterface);
      if (this.jdField_a_of_type_Uuv != null) {
        this.jdField_a_of_type_Uuv.jdField_b_of_type_Boolean = urk.j();
      }
    }
  }
  
  private uuv a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      wsv.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    try
    {
      uuv localuuv = new uuv();
      JSONObject localJSONObject = new JSONObject(paramString);
      localuuv.jdField_a_of_type_Long = localJSONObject.optLong("startTime", -1L);
      localuuv.jdField_b_of_type_Long = localJSONObject.optLong("endTime", -1L);
      localuuv.jdField_a_of_type_JavaLangString = localJSONObject.optString("imageUrl", "");
      localuuv.jdField_b_of_type_JavaLangString = localJSONObject.optString("desc", "");
      localuuv.c = localJSONObject.optString("jumpUrl", "");
      localuuv.d = localJSONObject.optString("contentId", "");
      if (localJSONObject.optInt("oneTimeUse", 0) == 1) {}
      for (;;)
      {
        localuuv.jdField_a_of_type_Boolean = bool;
        return localuuv;
        bool = false;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      wsv.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig config error config=" + paramString, localJSONException);
    }
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c) || (this.jdField_a_of_type_Byte != 0) || (this.h) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    wsv.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
    this.h = true;
    Object localObject = SosoInterface.b();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).a != null)) {}
    long l1;
    long l2;
    for (localObject = new uux(((SosoInterface.SosoLbsInfo)localObject).a.f);; localObject = new uux(null))
    {
      uhl localuhl = (uhl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
      uus localuus = new uus(this, (uhk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98), localuhl);
      l1 = localuhl.a();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      ung.a().a((unk)localObject, localuus);
      wsv.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    wsv.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
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
    ((nag)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).notifyUI(105, true, null);
    ((uhk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).notifyUI(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Almm == null) {
      this.jdField_a_of_type_Almm = new uuu(this);
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
    uhk localuhk;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localuhk = (uhk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98);
      if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localuhk.notifyUI(1022, true, Boolean.valueOf(bool));
      return;
    }
  }
  
  public uuv a()
  {
    return this.jdField_a_of_type_Uuv;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Uuv = null;
    urk.f(false);
    urk.g("");
    wsv.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    uuw localuuw = new uuw();
    uht.a().dispatch(localuuw);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    uhl localuhl = (uhl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
    this.d = paramBoolean;
    localuhl.i(paramBoolean);
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
    return (DeviceProfileManager.a(str, arrayOfInteger, new almr()) < 0) || (arrayOfInteger[0].intValue() == 1);
  }
  
  public boolean a(String paramString)
  {
    uuv localuuv = a(paramString);
    if (localuuv != null)
    {
      if (TextUtils.isEmpty(localuuv.d)) {
        wsv.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
      }
    }
    else {
      return false;
    }
    if ((this.jdField_a_of_type_Uuv != null) && (TextUtils.equals(this.jdField_a_of_type_Uuv.d, localuuv.d)))
    {
      wsv.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
      return false;
    }
    wsv.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_Uuv, paramString);
    this.jdField_a_of_type_Uuv = localuuv;
    urk.f(false);
    urk.g(paramString);
    paramString = new uuw();
    uht.a().dispatch(paramString);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Uhn);
    }
    DeviceProfileManager.b(this.jdField_a_of_type_Almm);
    this.jdField_a_of_type_Almm = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uur
 * JD-Core Version:    0.7.0.1
 */