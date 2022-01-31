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

public class uza
  implements Manager
{
  public byte a;
  public int a;
  alrb jdField_a_of_type_Alrb = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final ulw jdField_a_of_type_Ulw = new uzc(this);
  private uze jdField_a_of_type_Uze;
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public uza(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = ((Boolean)((uvt)uwa.a(10)).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    c();
    DeviceProfileManager.a(this.jdField_a_of_type_Alrb);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ulw);
    this.d = ((ulu)paramQQAppInterface.getManager(181)).f();
    b(false);
    paramQQAppInterface = uvt.e();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_Uze = a(paramQQAppInterface);
      if (this.jdField_a_of_type_Uze != null) {
        this.jdField_a_of_type_Uze.jdField_b_of_type_Boolean = uvt.j();
      }
    }
  }
  
  private uze a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      wxe.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    try
    {
      uze localuze = new uze();
      JSONObject localJSONObject = new JSONObject(paramString);
      localuze.jdField_a_of_type_Long = localJSONObject.optLong("startTime", -1L);
      localuze.jdField_b_of_type_Long = localJSONObject.optLong("endTime", -1L);
      localuze.jdField_a_of_type_JavaLangString = localJSONObject.optString("imageUrl", "");
      localuze.jdField_b_of_type_JavaLangString = localJSONObject.optString("desc", "");
      localuze.c = localJSONObject.optString("jumpUrl", "");
      localuze.d = localJSONObject.optString("contentId", "");
      if (localJSONObject.optInt("oneTimeUse", 0) == 1) {}
      for (;;)
      {
        localuze.jdField_a_of_type_Boolean = bool;
        return localuze;
        bool = false;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      wxe.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig config error config=" + paramString, localJSONException);
    }
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c) || (this.jdField_a_of_type_Byte != 0) || (this.h) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    wxe.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
    this.h = true;
    Object localObject = SosoInterface.b();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).a != null)) {}
    long l1;
    long l2;
    for (localObject = new uzg(((SosoInterface.SosoLbsInfo)localObject).a.f);; localObject = new uzg(null))
    {
      ulu localulu = (ulu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
      uzb localuzb = new uzb(this, (ult)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98), localulu);
      l1 = localulu.a();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      urp.a().a((urt)localObject, localuzb);
      wxe.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    wxe.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
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
    ((ult)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).notifyUI(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Alrb == null) {
      this.jdField_a_of_type_Alrb = new uzd(this);
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
    ult localult;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localult = (ult)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98);
      if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localult.notifyUI(1022, true, Boolean.valueOf(bool));
      return;
    }
  }
  
  public uze a()
  {
    return this.jdField_a_of_type_Uze;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Uze = null;
    uvt.f(false);
    uvt.g("");
    wxe.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    uzf localuzf = new uzf();
    umc.a().dispatch(localuzf);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ulu localulu = (ulu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
    this.d = paramBoolean;
    localulu.i(paramBoolean);
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
    return (DeviceProfileManager.a(str, arrayOfInteger, new alrg()) < 0) || (arrayOfInteger[0].intValue() == 1);
  }
  
  public boolean a(String paramString)
  {
    uze localuze = a(paramString);
    if (localuze != null)
    {
      if (TextUtils.isEmpty(localuze.d)) {
        wxe.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
      }
    }
    else {
      return false;
    }
    if ((this.jdField_a_of_type_Uze != null) && (TextUtils.equals(this.jdField_a_of_type_Uze.d, localuze.d)))
    {
      wxe.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
      return false;
    }
    wxe.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_Uze, paramString);
    this.jdField_a_of_type_Uze = localuze;
    uvt.f(false);
    uvt.g(paramString);
    paramString = new uzf();
    umc.a().dispatch(paramString);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ulw);
    }
    DeviceProfileManager.b(this.jdField_a_of_type_Alrb);
    this.jdField_a_of_type_Alrb = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uza
 * JD-Core Version:    0.7.0.1
 */