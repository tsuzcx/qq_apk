package com.tencent.av.business.manager;

import aden;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.VoiceChangeToolbar;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import igd;
import igk;
import igl;
import iiv;
import ijg;
import ijh;
import ijo;
import ikl;
import ilg;
import iya.e;
import iya.f;
import java.lang.ref.WeakReference;
import jll;
import org.json.JSONObject;

@Deprecated
public class EffectOperateManager
  extends ijo
{
  private String Nl;
  private boolean RK = true;
  private boolean RL;
  private boolean RM;
  private int anN;
  private int anO;
  private long beginTime;
  private int effectType = -1;
  private long endTime;
  private String iconUrl;
  private int versionCode;
  private String wording;
  private int xL;
  
  public EffectOperateManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private void parse(String paramString)
  {
    String str;
    label178:
    label217:
    label225:
    boolean bool;
    if (!TextUtils.isEmpty(paramString))
    {
      igd.aJ("EffectOperateManager", "parse config: " + paramString);
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("versionCode")) {
          this.versionCode = localJSONObject.getInt("versionCode");
        }
        if (localJSONObject.has("beginTime")) {
          this.beginTime = aden.ah(localJSONObject.getString("beginTime"));
        }
        if (localJSONObject.has("endTime")) {
          this.endTime = aden.ah(localJSONObject.getString("endTime"));
        }
        if (localJSONObject.has("wording")) {
          this.wording = localJSONObject.getString("wording");
        }
        if (localJSONObject.has("wordingColor"))
        {
          str = localJSONObject.getString("wordingColor");
          try
          {
            if (!str.startsWith("0x")) {
              break label622;
            }
            paramString = str.replace("0x", "#");
            this.anN = Color.parseColor(paramString);
          }
          catch (NumberFormatException paramString)
          {
            for (;;)
            {
              this.anN = -1;
              paramString.printStackTrace();
              igd.aJ("EffectOperateManager", "parse|wording color is invalid!" + paramString.getMessage());
            }
          }
          if (!localJSONObject.has("wordingBgColor")) {
            break label796;
          }
          str = localJSONObject.getString("wordingBgColor");
        }
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        igd.aJ("EffectOperateManager", "parse exception: " + paramString.toString());
        return;
      }
      try
      {
        if (!str.startsWith("0x")) {
          break label729;
        }
        paramString = str.replace("0x", "#");
        this.anO = Color.parseColor(paramString);
      }
      catch (NumberFormatException paramString)
      {
        this.anO = -16777216;
        paramString.printStackTrace();
        igd.aJ("EffectOperateManager", "parse|wording color is invalid!" + paramString.getMessage());
        break label225;
      }
      if (localJSONObject.has("showTimes")) {
        this.xL = localJSONObject.getInt("showTimes");
      }
      if (localJSONObject.has("effectType")) {
        this.effectType = localJSONObject.getInt("effectType");
      }
      if (localJSONObject.has("effectId")) {
        this.Nl = localJSONObject.getString("effectId");
      }
      if (localJSONObject.has("play")) {
        this.RK = localJSONObject.getBoolean("play");
      }
      if (localJSONObject.has("showBeforeConnect"))
      {
        if (localJSONObject.getInt("showBeforeConnect") != 0) {
          break label839;
        }
        bool = false;
        label331:
        this.RL = bool;
      }
      if (localJSONObject.has("iconUrl")) {
        this.iconUrl = localJSONObject.getString("iconUrl");
      }
      if (TextUtils.isEmpty(this.iconUrl)) {
        switch (this.effectType)
        {
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        paramString = ((EffectConfigBase)this.mApp.a(i)).a(this.Nl);
        if (paramString != null) {
          this.iconUrl = paramString.getIconurl();
        }
      }
      for (;;)
      {
        igd.aJ("EffectOperateManager", "parse|versionCode: " + this.versionCode + ", beginTime: " + this.beginTime + ", endTime: " + this.endTime + ", wording: " + this.wording + ", play: " + this.RK + ", wordingColor: 0x" + Long.toString(this.anN, 16).toUpperCase() + ", wordingBgColor: 0x" + Long.toString(this.anO, 16).toUpperCase() + ", showTimes: " + this.xL + ", showBeforeConnect: " + this.RL + ", effectType: " + this.effectType + ", effectId: " + this.Nl + ", iconUrl: " + this.iconUrl);
        return;
        label622:
        paramString = str;
        if (!str.startsWith("0X")) {
          break;
        }
        paramString = str.replace("0X", "#");
        break;
        this.anN = -1;
        break label178;
        label729:
        paramString = str;
        if (!str.startsWith("0X")) {
          break label217;
        }
        paramString = str.replace("0X", "#");
        break label217;
        label796:
        this.anO = -16777216;
        break label225;
        igd.aJ("EffectOperateManager", "parse|cannot get item!");
        continue;
        this.iconUrl = this.Nl;
      }
      igd.aJ("EffectOperateManager", "parse|config is empty!");
      return;
      int i = -1;
      continue;
      label839:
      bool = true;
      break label331;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 1;
      continue;
      i = 0;
    }
  }
  
  void ane()
  {
    long l = AudioHelper.hG();
    QLog.w("EffectOperateManager", 1, "gotoVoiceChangePendant, effectId[" + this.Nl + "], play[" + this.RK + "], seq[" + l + "]");
    if (this.RK) {
      VoiceChangeToolbar.setEffectConfigItem(l, this.Nl);
    }
  }
  
  void anf()
  {
    ikl localikl = (ikl)this.mApp.a(2);
    PendantItem localPendantItem = (PendantItem)localikl.a(this.Nl);
    long l;
    if (localPendantItem != null)
    {
      l = AudioHelper.hG();
      QLog.w("EffectOperateManager", 1, "gotoPendant, id[" + localPendantItem.getId() + "], seq[" + l + "], play[" + this.RK + "], item[" + localPendantItem + "]");
      if (this.RK)
      {
        if (localPendantItem.isUsable()) {
          break label145;
        }
        localikl.Ny = this.Nl;
        notifyEvent(Integer.valueOf(171), null, null);
        localikl.a(l, localPendantItem);
      }
    }
    return;
    label145:
    localikl.a(l, localPendantItem);
  }
  
  void ang()
  {
    String str = this.Nl;
    ilg localilg = (ilg)this.mApp.a(0);
    ZimuItem localZimuItem = (ZimuItem)localilg.a();
    boolean bool;
    if (localZimuItem == null) {
      bool = true;
    }
    long l;
    for (;;)
    {
      l = AudioHelper.hG();
      QLog.w("EffectOperateManager", 1, "gotoZimu, id[" + str + "], isChanged[" + bool + "], play[" + this.RK + "], seq[" + l + "]");
      if ((bool) && (this.RK))
      {
        new iya.f(l, "gotoZimu", 1, str).n(this.mApp);
        if (((ijg)this.mApp.getBusinessHandler(1)).tr()) {
          ijh.a(this.mApp, "gotoZimu", l, str, true);
        }
        if (localZimuItem != null) {
          break;
        }
        localilg.a("gotoZimu_" + str, true, l, null);
      }
      return;
      if (!str.equalsIgnoreCase(localZimuItem.getId())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    localilg.q("gotoZimu_" + str, l);
  }
  
  void anh()
  {
    String str = this.Nl;
    if (str.equals("0")) {
      notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
    }
    do
    {
      return;
      AudioHelper.dj(str, false);
    } while (!this.RK);
    new iya.e(AudioHelper.hG(), str, true, 5).n(this.mApp);
  }
  
  public boolean cs(String paramString)
  {
    return false;
  }
  
  public String getEffectId()
  {
    return this.Nl;
  }
  
  public int getEffectType()
  {
    return this.effectType;
  }
  
  public void ic(boolean paramBoolean)
  {
    int i = 0;
    Object localObject = jll.a(this.mApp);
    String str = "qav_effect_operate_config_show_times_" + this.versionCode;
    if (!paramBoolean) {
      i = ((SharedPreferences)localObject).getInt(str, 0);
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(str, i + 1);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void id(boolean paramBoolean)
  {
    iiv localiiv = this.mApp.b().b();
    if (localiiv == null) {
      QLog.w("EffectOperateManager", 1, "setEffectOperateShown, sessionInfo为null, show[" + paramBoolean + "]");
    }
    do
    {
      return;
      QLog.w("EffectOperateManager", 1, "setEffectOperateShown, hasShownEffectOperate[" + localiiv.Qj + "->" + paramBoolean + "], sessionInfo[" + localiiv + "]");
      localiiv.Qj = paramBoolean;
    } while (!paramBoolean);
    ic(false);
  }
  
  public void ie(boolean paramBoolean)
  {
    this.RM = paramBoolean;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    igd.aJ("EffectOperateManager", "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.mApp.l(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void onCreate()
  {
    parse(igl.b(263).content);
  }
  
  public boolean tv()
  {
    return this.RM;
  }
  
  static class MyGoToFaceRunnable
    extends EffectOperateManager.MyGotoRunnable
  {
    public void run()
    {
      EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.bl.get();
      if (localEffectOperateManager != null) {
        localEffectOperateManager.anh();
      }
    }
  }
  
  static class MyGoToPendantRunnalbe
    extends EffectOperateManager.MyGotoRunnable
  {
    public void run()
    {
      EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.bl.get();
      if (localEffectOperateManager != null) {
        localEffectOperateManager.anf();
      }
    }
  }
  
  static class MyGoToVoiceChangeRunnalbe
    extends EffectOperateManager.MyGotoRunnable
  {
    public void run()
    {
      EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.bl.get();
      if (localEffectOperateManager != null) {
        localEffectOperateManager.ane();
      }
    }
  }
  
  static class MyGoToZimuRunnable
    extends EffectOperateManager.MyGotoRunnable
  {
    public void run()
    {
      EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.bl.get();
      if (localEffectOperateManager != null) {
        localEffectOperateManager.ang();
      }
    }
  }
  
  static abstract class MyGotoRunnable
    implements Runnable
  {
    WeakReference<EffectOperateManager> bl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectOperateManager
 * JD-Core Version:    0.7.0.1
 */