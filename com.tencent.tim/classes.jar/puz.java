import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.mobileqq.app.DeviceProfileManager.e;
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

public class puz
  implements Manager
{
  DeviceProfileManager.a jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a = null;
  private puz.a jdField_a_of_type_Puz$a;
  public boolean aBT;
  public boolean aBU;
  public boolean aBV = true;
  public boolean aBW;
  private boolean aBX;
  private boolean aBY;
  private boolean aBZ;
  private boolean aCa;
  public byte aJ = -1;
  private final pmd b = new pvb(this);
  public int bkE;
  QQAppInterface mApp;
  
  public puz(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.aBU = ((Boolean)((psr)psx.a(10)).c("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.aBV = Jf();
    bmT();
    DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a);
    paramQQAppInterface.addObserver(this.b);
    this.aBW = ((pmb)paramQQAppInterface.getManager(181)).Io();
    sp(false);
    paramQQAppInterface = psr.mz();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_Puz$a = a(paramQQAppInterface);
      if (this.jdField_a_of_type_Puz$a != null) {
        this.jdField_a_of_type_Puz$a.alW = psr.IR();
      }
    }
  }
  
  private puz.a a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      ram.i("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    try
    {
      puz.a locala = new puz.a();
      JSONObject localJSONObject = new JSONObject(paramString);
      locala.startTime = localJSONObject.optLong("startTime", -1L);
      locala.endTime = localJSONObject.optLong("endTime", -1L);
      locala.imageUrl = localJSONObject.optString("imageUrl", "");
      locala.desc = localJSONObject.optString("desc", "");
      locala.jumpUrl = localJSONObject.optString("jumpUrl", "");
      locala.contentId = localJSONObject.optString("contentId", "");
      if (localJSONObject.optInt("oneTimeUse", 0) == 1) {}
      for (;;)
      {
        locala.aCb = bool;
        return locala;
        bool = false;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      ram.e("Q.qqstory.config.takevideo", "parseTakeVideoConfig config error config=" + paramString, localJSONException);
    }
  }
  
  private void bmS()
  {
    if ((!this.aBU) || (!this.aBV) || (this.aJ != 0) || (this.aCa) || (this.mApp == null)) {
      return;
    }
    ram.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
    this.aCa = true;
    Object localObject = SosoInterface.c();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).a != null)) {}
    long l1;
    long l2;
    for (localObject = new pvd(((SosoInterface.SosoLbsInfo)localObject).a.cityCode);; localObject = new pvd(null))
    {
      pmb localpmb = (pmb)this.mApp.getManager(181);
      pva localpva = new pva(this, (pma)this.mApp.getBusinessHandler(98), localpmb);
      l1 = localpmb.dF();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      ppv.a().a((ppw)localObject, localpva);
      ram.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    ram.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
  }
  
  private void bmT()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a = new pvc(this);
    }
  }
  
  private void bmU()
  {
    if ((this.aBX) && (this.aBZ) && (this.aBY)) {
      bmS();
    }
  }
  
  private void bmV()
  {
    pma localpma;
    if (this.mApp != null)
    {
      localpma = (pma)this.mApp.getBusinessHandler(98);
      if ((!this.aBU) || (!this.aBV)) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localpma.notifyUI(1022, true, Boolean.valueOf(bool));
      return;
    }
  }
  
  private void sp(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "update cfg svr=" + this.aBU + ", dpc=" + this.aBV + ", user=" + this.aBW);
    }
    boolean bool2 = this.aBT;
    boolean bool1;
    if ((this.aBU) && (this.aBV) && (this.aBW))
    {
      bool1 = true;
      this.aBT = bool1;
      this.bkE = 52;
      if (this.mApp != null) {
        break label113;
      }
    }
    label113:
    while ((!paramBoolean) || (bool2 == this.aBT))
    {
      return;
      bool1 = false;
      break;
    }
    ((jnp)this.mApp.getBusinessHandler(43)).notifyUI(105, true, null);
    ((pma)this.mApp.getBusinessHandler(98)).notifyUI(1020, true, Boolean.valueOf(this.aBT));
  }
  
  public boolean Jf()
  {
    String str = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.StoryCfg.name(), "1");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "getMsgTabDPC:" + str);
    }
    Integer[] arrayOfInteger;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfInteger = new Integer[1];
      arrayOfInteger[0] = Integer.valueOf(0);
    }
    return (DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.e()) < 0) || (arrayOfInteger[0].intValue() == 1);
  }
  
  public puz.a a()
  {
    return this.jdField_a_of_type_Puz$a;
  }
  
  public void bmW()
  {
    this.jdField_a_of_type_Puz$a = null;
    psr.si(false);
    psr.rj("");
    ram.i("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    puz.b localb = new puz.b();
    pmi.a().dispatch(localb);
  }
  
  public boolean fi(String paramString)
  {
    puz.a locala = a(paramString);
    if (locala != null)
    {
      if (TextUtils.isEmpty(locala.contentId)) {
        ram.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
      }
    }
    else {
      return false;
    }
    if ((this.jdField_a_of_type_Puz$a != null) && (TextUtils.equals(this.jdField_a_of_type_Puz$a.contentId, locala.contentId)))
    {
      ram.w("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
      return false;
    }
    ram.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_Puz$a, paramString);
    this.jdField_a_of_type_Puz$a = locala;
    psr.si(false);
    psr.rj(paramString);
    paramString = new puz.b();
    pmi.a().dispatch(paramString);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.mApp != null) {
      this.mApp.removeObserver(this.b);
    }
    DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a);
    this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a = null;
  }
  
  public void sq(boolean paramBoolean)
  {
    if (this.mApp == null) {
      return;
    }
    pmb localpmb = (pmb)this.mApp.getManager(181);
    this.aBW = paramBoolean;
    localpmb.rP(paramBoolean);
    sp(true);
  }
  
  public static class a
  {
    public boolean aCb;
    public boolean alW;
    public String contentId;
    public String desc;
    public long endTime;
    public String imageUrl;
    public String jumpUrl;
    public long startTime;
    
    public boolean Jg()
    {
      boolean bool2 = false;
      long l = System.currentTimeMillis();
      boolean bool1;
      if ((l >= this.startTime) && (l < this.endTime))
      {
        bool1 = true;
        if ((!bool1) || (!this.aCb) || (!this.alW)) {
          break label68;
        }
        bool1 = bool2;
      }
      label68:
      for (;;)
      {
        ram.b("Q.qqstory.config.takevideo", "isVariable=%b content=%s", Boolean.valueOf(bool1), toString());
        return bool1;
        bool1 = false;
        break;
      }
    }
    
    public void a(a parama)
    {
      if (parama == null) {
        return;
      }
      this.startTime = parama.startTime;
      this.endTime = parama.endTime;
      this.imageUrl = parama.imageUrl;
      this.desc = parama.desc;
      this.jumpUrl = parama.jumpUrl;
      this.contentId = parama.contentId;
      this.aCb = parama.aCb;
      this.alW = parama.alW;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("MsgTabTakeVideoNodeConfig=[");
      localStringBuilder.append(" startTime:").append(this.startTime);
      localStringBuilder.append(" endTime:").append(this.endTime);
      localStringBuilder.append(" imageUrl:").append(this.imageUrl);
      localStringBuilder.append(" desc:").append(this.desc);
      localStringBuilder.append(" jumpUrl:").append(this.jumpUrl);
      localStringBuilder.append(" contentId:").append(this.contentId);
      localStringBuilder.append(" isOneTimeUse:").append(this.aCb);
      localStringBuilder.append(" hasClicked:").append(this.alW);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static final class b
    extends plt
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     puz
 * JD-Core Version:    0.7.0.1
 */