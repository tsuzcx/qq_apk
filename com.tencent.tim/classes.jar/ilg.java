import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ilg
  extends EffectConfigBase<ZimuItem>
  implements ijt.a
{
  protected boolean Sd;
  boolean Se = false;
  boolean Sf = false;
  
  public ilg(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static void J(Context paramContext, int paramInt)
  {
    paramContext = d(paramContext).edit();
    paramContext.putInt("qav_zimu_is_show", paramInt);
    paramContext.commit();
  }
  
  private boolean cv(String paramString)
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.has("switch")) {
          return bool;
        }
        paramString = paramString.getString("switch");
        igd.aJ("EffectZimuManager", "parse ZIMU:" + paramString);
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase("off")))
        {
          J(this.mApp.getApplication(), 0);
          return true;
        }
        J(this.mApp.getApplication(), 1);
        return true;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static SharedPreferences d(Context paramContext)
  {
    return paramContext.getSharedPreferences("qav_zimu", 4);
  }
  
  public static boolean isShow(VideoAppInterface paramVideoAppInterface)
  {
    ((ilg)paramVideoAppInterface.a(0)).parse();
    return d(paramVideoAppInterface.getApp()).getInt("qav_zimu_is_show", 0) == 1;
  }
  
  public void X(String paramString, boolean paramBoolean)
  {
    if (this.Sd != paramBoolean)
    {
      QLog.w("EffectZimuManager", 1, "setRecievedSentence, from[" + paramString + "], mIsRecieveSentence[" + this.Sd + "->" + paramBoolean + "]");
      this.Sd = paramBoolean;
    }
  }
  
  public void Y(int paramInt, String paramString)
  {
    if ((paramInt == 3002) || (paramInt == 3003)) {
      d(AudioHelper.hG(), "");
    }
  }
  
  public Class<?> a()
  {
    return ZimuItem.class;
  }
  
  public List<ZimuItem> a(int paramInt, String paramString)
  {
    List localList = super.a(paramInt, paramString);
    cv(paramString);
    return localList;
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    QLog.w("EffectZimuManager", 1, "onSessionStatusChanged, event[" + paramInt + "], seq[" + paramLong + "]");
    ((ijg)this.mApp.getBusinessHandler(1)).anc();
    new iya.f(paramLong, "onSessionStatusChanged", 2, null).n(this.mApp);
  }
  
  public void a(String paramString1, boolean paramBoolean, long paramLong, String paramString2)
  {
    irk.a().pause(4);
    if (!this.Se)
    {
      ijg localijg = (ijg)this.mApp.getBusinessHandler(1);
      localijg.a(paramString1, "TransInfoCreate.CreateSession", paramLong, paramString2);
      localijg.onDestroy();
      this.Sf = paramBoolean;
    }
    this.Se = true;
  }
  
  public boolean a(long paramLong, ZimuItem paramZimuItem)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("EffectZimuManager", 1, "setCurrentItem, seq[" + paramLong + "], item[" + paramZimuItem + "]", new Throwable("打印调用栈"));
    }
    boolean bool = super.a(paramLong, paramZimuItem);
    Object localObject;
    if (bool)
    {
      if (paramZimuItem == null)
      {
        localObject = null;
        ilg.a.x((String)localObject);
        X("setCurrentItem_" + (String)localObject + "_" + paramLong, false);
      }
    }
    else
    {
      localObject = this.mApp;
      if (this.b != null) {
        break label205;
      }
    }
    label205:
    for (int i = 4;; i = 5)
    {
      ((VideoAppInterface)localObject).l(new Object[] { Integer.valueOf(165), Integer.valueOf(i) });
      if (paramZimuItem != null)
      {
        localObject = (ijt)this.mApp.a(12);
        if (localObject != null) {
          ((ijt)localObject).X(3001, paramZimuItem.getId());
        }
      }
      return bool;
      localObject = paramZimuItem.getId();
      break;
    }
  }
  
  protected boolean cs(String paramString)
  {
    return cv(getConfigString());
  }
  
  public int getConfigID()
  {
    return 216;
  }
  
  public void im(boolean paramBoolean)
  {
    int j;
    if (this.mItemList != null)
    {
      Iterator localIterator = this.mItemList.iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label77;
      }
      ZimuItem localZimuItem = (ZimuItem)localIterator.next();
      if ((!ilf.cu(localZimuItem.getId())) || (localZimuItem.isUsable() == paramBoolean)) {
        break label82;
      }
      localZimuItem.setUsable(paramBoolean);
      i = 1;
    }
    label77:
    label82:
    for (;;)
    {
      break;
      j = 0;
      if (j != 0) {}
      return;
    }
  }
  
  public boolean isSender()
  {
    return this.Sf;
  }
  
  public int kY()
  {
    if ((ZimuItem)a() == null) {}
    return 4;
  }
  
  public void onCreate()
  {
    super.onCreate();
    ijt localijt = (ijt)this.mApp.a(12);
    if (localijt != null) {
      localijt.a(3001, this);
    }
  }
  
  public void p(String paramString, long paramLong)
  {
    if (this.Se)
    {
      iji localiji = (iji)this.mApp.getBusinessHandler(0);
      localiji.a(paramString, paramLong, "TransInfo.ExitSession", null);
      localiji.onDestroy();
      ((ijg)this.mApp.getBusinessHandler(1)).anc();
    }
    this.Se = false;
    irk.a().resume(4);
  }
  
  public void q(String paramString, long paramLong)
  {
    irk.a().pause(4);
    if (this.Se)
    {
      iji localiji = (iji)this.mApp.getBusinessHandler(0);
      localiji.a(paramString, paramLong, "TransInfo.ChangeSession", null);
      localiji.onDestroy();
    }
  }
  
  public boolean tP()
  {
    return this.Sd;
  }
  
  public boolean tQ()
  {
    return this.Se;
  }
  
  public List<ZimuItem> y(String paramString)
  {
    paramString = super.y(paramString);
    ArrayList localArrayList = new ArrayList();
    if (this.mItemList != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  public static class a
  {
    static String Nz;
    static boolean RP;
    static long lt;
    
    public static void B(String paramString1, String paramString2, String paramString3)
    {
      igd.aJ("EffectZimuManager", "DataReport onUsedZimu reportClickEvent:" + paramString1 + "|" + paramString2 + "|" + paramString3);
      anot.a(null, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", paramString2, paramString3);
    }
    
    public static void h(VideoAppInterface paramVideoAppInterface)
    {
      if (paramVideoAppInterface.ch(0))
      {
        paramVideoAppInterface = (ZimuItem)((ilg)paramVideoAppInterface.a(0)).a();
        if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId()))) {
          x(null);
        }
      }
    }
    
    public static void r(String paramString, long paramLong)
    {
      igd.aJ("EffectZimuManager", "DataReport zimu:" + paramString + "|" + paramLong);
      HashMap localHashMap = new HashMap();
      localHashMap.put("zimuName", paramString);
      localHashMap.put("duration", String.valueOf(paramLong));
      UserAction.onUserAction("actAVFunChatZimu", true, -1L, -1L, localHashMap, true);
      try
      {
        UserAction.flushObjectsToDB(true);
        return;
      }
      catch (Exception paramString)
      {
        igd.aL("EffectZimuManager", paramString.getMessage());
      }
    }
    
    public static void reportClickEvent(String paramString1, String paramString2)
    {
      igd.aJ("EffectZimuManager", "DataReport onUsedZimu reportClickEvent:" + paramString1 + "|" + paramString2);
      anot.a(null, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", paramString2, "");
    }
    
    static long x(String paramString)
    {
      long l1 = 0L;
      long l2 = l1;
      if (!irc.equals(paramString, Nz))
      {
        long l3 = System.currentTimeMillis();
        igd.aJ("EffectZimuManager", "DataReport calTime zimu:" + paramString + "|" + Nz + "|" + lt);
        l2 = l1;
        if (!TextUtils.isEmpty(Nz))
        {
          if (lt != 0L)
          {
            l1 = l3 - lt;
            igd.aJ("EffectZimuManager", "DataReport zimu:" + l1);
            RP = true;
            l1 /= 1000L;
            r(Nz, l1);
            anot.a(null, "CliOper", "", "", "0X800888D", "0X800888D", 0, 0, String.valueOf(l1), "", Nz, "");
            if (ilf.cu(Nz)) {
              anot.a(null, "CliOper", "", "", "0X8009193", "0X8009193", 0, 0, String.valueOf(l1), "", Nz, "");
            }
          }
          igd.aJ("EffectZimuManager", "DataReport zimu 33:" + l1);
          l2 = l1;
        }
        Nz = paramString;
        lt = l3;
      }
      return l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilg
 * JD-Core Version:    0.7.0.1
 */