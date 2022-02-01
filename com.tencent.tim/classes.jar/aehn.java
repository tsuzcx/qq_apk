import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class aehn
{
  private final SparseArray<String> cs = new SparseArray(10);
  private final ConcurrentHashMap<String, CopyOnWriteArraySet<aehn.b>> eX;
  
  public aehn()
  {
    this.cs.put(271, "batch_add_friend_for_troop_config");
    this.cs.put(275, "confess_config");
    this.cs.put(358, "contact_top_entry_config");
    this.cs.put(372, "breaking_ice_config");
    this.cs.put(326, "sosointerface_config");
    this.cs.put(357, "register_invitation_config");
    this.cs.put(330, "hiboom_config");
    this.cs.put(296, "extend_friend_config_785");
    this.cs.put(369, "account_logout_config");
    this.cs.put(379, "qqsettingme_f2f_guide_config");
    this.cs.put(378, "profile_btn_config");
    this.cs.put(381, "profile_switch_config");
    this.cs.put(401, "smart_devices_discovery_config");
    this.cs.put(407, "hide_qq_xman");
    this.cs.put(405, "add_contact_page_public_account_switch");
    this.cs.put(408, "select_member_entry_switch");
    this.cs.put(355, "troop_member_list_config");
    this.eX = new ConcurrentHashMap(10);
    int i = 0;
    while (i < this.cs.size())
    {
      String str = (String)this.cs.valueAt(i);
      this.eX.put(str, new CopyOnWriteArraySet());
      i += 1;
    }
    a("qqsettingme_f2f_guide_config", new aehz());
    a("smart_devices_discovery_config", new aeia());
  }
  
  private CopyOnWriteArraySet<aehn.b> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.cs.indexOfValue(paramString) < 0) {
      return null;
    }
    return (CopyOnWriteArraySet)this.eX.get(paramString);
  }
  
  public static String aS(String paramString1, String paramString2)
  {
    return aqmj.k(BaseApplicationImpl.getApplication(), paramString1, paramString2);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = (String)this.cs.get(paramInt1);
      QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "handleConfigFail [id: %s, tag: %s, isSuc: %s, result: %s]", new Object[] { Integer.valueOf(paramInt1), paramQQAppInterface, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) }));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    String str1 = (String)this.cs.get(paramInt);
    if (TextUtils.isEmpty(str1)) {
      if (QLog.isColorLevel()) {
        QLog.d("CfgProcess", 2, String.format(" handleConfig tag is null ! config: %s", new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    String str2;
    BaseApplication localBaseApplication;
    aehn.a locala;
    do
    {
      return;
      str2 = paramQQAppInterface.getCurrentAccountUin();
      localBaseApplication = paramQQAppInterface.getApp();
      locala = new aehn.a();
      locala.version = paramConfig.version.get();
      locala.localVersion = aqmj.k(localBaseApplication, str2, str1);
      if (locala.version != locala.localVersion) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CfgProcess", 2, new Object[] { " handleConfig config version is the same. [tag: %s, version: %s]", str1, Integer.valueOf(locala.version) });
    return;
    locala.result = 0;
    if (paramConfig.msg_content_list.size() > 0)
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        break label367;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CfgProcess", 2, " handleConfig content is null !");
      }
      locala.result = 1;
    }
    for (;;)
    {
      if (locala.strContent == null) {
        locala.strContent = "";
      }
      locala.bTX = true;
      locala.bTW = false;
      if (locala.result == 0) {
        try
        {
          aqgt.a(paramQQAppInterface, str1, locala);
          if (!locala.bTW)
          {
            aqmj.q(localBaseApplication, str2, str1, locala.strContent);
            paramConfig = a(str1);
            if ((paramConfig == null) || (paramConfig.size() <= 0)) {
              break label579;
            }
            paramConfig = paramConfig.iterator();
            for (;;)
            {
              for (;;)
              {
                if (!paramConfig.hasNext()) {
                  break label579;
                }
                aehn.b localb = (aehn.b)paramConfig.next();
                try
                {
                  localb.a(paramQQAppInterface, paramInt, str1, locala);
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                }
                if (QLog.isColorLevel())
                {
                  QLog.i("CfgProcess", 2, "handleConfig OnGetConfigListener fail:  " + str1);
                  continue;
                  label367:
                  if (paramConfig.compress.get() != 1) {
                    break label484;
                  }
                  paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
                  if (paramConfig == null) {
                    break label460;
                  }
                  try
                  {
                    locala.strContent = new String(paramConfig, "UTF-8");
                  }
                  catch (Throwable paramConfig)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("CfgProcess", 2, " handleConfig Throwable:" + paramConfig.getMessage());
                    }
                    locala.result = 2;
                  }
                }
              }
              break;
              label460:
              locala.result = 3;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("CfgProcess", 2, " handleConfig inflateConfigString error!");
              break;
              label484:
              locala.strContent = paramConfig.content.get().toStringUtf8();
            }
          }
        }
        catch (Throwable paramConfig)
        {
          for (;;)
          {
            paramConfig.printStackTrace();
            if (QLog.isColorLevel())
            {
              QLog.i("CfgProcess", 2, "handleConfig call save individual fail:  " + str1);
              continue;
              if (QLog.isColorLevel()) {
                QLog.i("CfgProcess", 2, "handleConfig self save config tag: " + str1);
              }
            }
          }
        }
      }
    }
    label579:
    if (locala.bTX) {}
    for (int i = locala.version;; i = 0)
    {
      aqmj.i(localBaseApplication, str2, str1, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CfgProcess", 2, String.format(Locale.getDefault(), "handleConfigForTag  configId: %s, tag: %s, localVersion: %s, version: %s, result: %s, strContent: %s", new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(locala.localVersion), Integer.valueOf(locala.version), Integer.valueOf(locala.result), locala.strContent }));
      return;
    }
  }
  
  public void a(ConfigurationService.ConfigSeq paramConfigSeq, QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str1 = (String)this.cs.get(paramInt);
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "initConfigVersion tag is null, configId: %s", new Object[] { Integer.valueOf(paramInt) }));
      }
      return;
    }
    String str2 = paramQQAppInterface.getCurrentUin();
    paramQQAppInterface = paramQQAppInterface.getApp();
    int i;
    if (aqmj.l(paramQQAppInterface, str2, str1) != AppSetting.getAppId())
    {
      aqmj.j(paramQQAppInterface, str2, str1, AppSetting.getAppId());
      aqmj.i(paramQQAppInterface, str2, str1, 0);
      paramConfigSeq.version.set(0);
      i = 0;
    }
    for (;;)
    {
      paramConfigSeq.compress.set(1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "initConfigVersion [id: %s, tag: %s, version: %s]", new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(i) }));
      return;
      i = aqmj.k(paramQQAppInterface, str2, str1);
      paramConfigSeq.version.set(i);
    }
  }
  
  public boolean a(aehn.b paramb)
  {
    Iterator localIterator = this.eX.values().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((CopyOnWriteArraySet)localIterator.next()).remove(paramb) | bool) {}
    return bool;
  }
  
  public boolean a(String paramString, aehn.b paramb)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = paramString.add(paramb);
    }
    return bool;
  }
  
  public boolean b(String paramString, aehn.b paramb)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = paramString.remove(paramb);
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.eX.clear();
    this.cs.clear();
  }
  
  public static class a
  {
    public boolean bTW;
    public boolean bTX;
    public int localVersion;
    public int result;
    public String strContent = "";
    public int version;
  }
  
  public static abstract interface b
  {
    public abstract void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aehn.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aehn
 * JD-Core Version:    0.7.0.1
 */