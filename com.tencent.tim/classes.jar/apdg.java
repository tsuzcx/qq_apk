import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeLabelTextView;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class apdg
{
  private static apdg a;
  protected SparseArray<apdg.a> dA = new SparseArray();
  public int dTy = BaseApplication.getContext().getResources().getColor(2131166497);
  
  public static apdg a()
  {
    try
    {
      if (a == null) {
        a = b();
      }
      apdg localapdg = a;
      return localapdg;
    }
    finally {}
  }
  
  protected static apdg a(String paramString)
  {
    try
    {
      apdg localapdg = new apdg();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("rankMap");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localapdg;
        if (i >= j) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        apdg.a locala = new apdg.a();
        locala.id = paramString.getInt("id");
        locala.title = paramString.getString("rank");
        locala.bgColor = Color.parseColor(paramString.getString("bg"));
        localapdg.dA.put(locala.id, locala);
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "parseConfig exp:", paramString);
      }
      paramString = null;
    }
  }
  
  protected static apdg b()
  {
    try
    {
      Object localObject1 = a(BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 0).getString("rank_map_key", ""));
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopRankConfig", 2, "getConfigFromLocal exp, localConfig==null");
        }
        localObject3 = new apdg();
        localObject1 = new apdg.a();
        ((apdg.a)localObject1).id = 300;
        ((apdg.a)localObject1).title = acfp.m(2131716088);
        ((apdg.a)localObject1).bgColor = Color.parseColor("#F4BF20");
        apdg.a locala1 = new apdg.a();
        locala1.id = 301;
        locala1.title = acfp.m(2131716077);
        locala1.bgColor = Color.parseColor("#6CD9A3");
        apdg.a locala2 = new apdg.a();
        locala2.id = 302;
        locala2.title = "";
        locala2.bgColor = Color.parseColor("#B395EF");
        apdg.a locala3 = new apdg.a();
        locala3.id = 303;
        locala3.title = acfp.m(2131716078);
        locala3.bgColor = Color.parseColor("#F4BF20");
        apdg.a locala4 = new apdg.a();
        locala4.id = 304;
        locala4.title = acfp.m(2131716085);
        locala4.bgColor = Color.parseColor("#6CD9A3");
        apdg.a locala5 = new apdg.a();
        locala5.id = 305;
        locala5.title = acfp.m(2131716080);
        locala5.bgColor = Color.parseColor("#FF988A");
        apdg.a locala6 = new apdg.a();
        locala6.id = 306;
        locala6.title = acfp.m(2131716087);
        locala6.bgColor = Color.parseColor("#F4BF20");
        apdg.a locala7 = new apdg.a();
        locala7.id = 307;
        locala7.title = acfp.m(2131716082);
        locala7.bgColor = Color.parseColor("#72CCE6");
        apdg.a locala8 = new apdg.a();
        locala8.id = 308;
        locala8.title = acfp.m(2131716086);
        locala8.bgColor = Color.parseColor("#FF988A");
        apdg.a locala9 = new apdg.a();
        locala9.id = 315;
        locala9.title = "";
        locala9.bgColor = Color.parseColor("#8EBDF9");
        apdg.a locala10 = new apdg.a();
        locala10.id = 311;
        locala10.title = acfp.m(2131716081);
        locala10.bgColor = Color.parseColor("#F25D5D");
        apdg.a locala11 = new apdg.a();
        locala11.id = 312;
        locala11.title = acfp.m(2131716083);
        locala11.bgColor = Color.parseColor("#F25D5D");
        apdg.a locala12 = new apdg.a();
        locala12.id = 313;
        locala12.title = acfp.m(2131716090);
        locala12.bgColor = Color.parseColor("#FFA5BD");
        apdg.a locala13 = new apdg.a();
        locala13.id = 314;
        locala13.title = acfp.m(2131716079);
        locala13.bgColor = Color.parseColor("#FFA5BD");
        apdg.a locala14 = new apdg.a();
        locala14.id = 332;
        locala14.title = acfp.m(2131716084);
        locala14.bgColor = Color.parseColor("#F4C020");
        apdg.a locala15 = new apdg.a();
        locala15.id = 333;
        locala15.title = acfp.m(2131716089);
        locala15.bgColor = Color.parseColor("#F4C020");
        ((apdg)localObject3).dA.put(300, localObject1);
        ((apdg)localObject3).dA.put(301, locala1);
        ((apdg)localObject3).dA.put(302, locala2);
        ((apdg)localObject3).dA.put(303, locala3);
        ((apdg)localObject3).dA.put(304, locala4);
        ((apdg)localObject3).dA.put(305, locala5);
        ((apdg)localObject3).dA.put(306, locala6);
        ((apdg)localObject3).dA.put(307, locala7);
        ((apdg)localObject3).dA.put(308, locala8);
        ((apdg)localObject3).dA.put(311, locala10);
        ((apdg)localObject3).dA.put(312, locala11);
        ((apdg)localObject3).dA.put(313, locala12);
        ((apdg)localObject3).dA.put(314, locala13);
        ((apdg)localObject3).dA.put(315, locala9);
        ((apdg)localObject3).dA.put(332, locala14);
        ((apdg)localObject3).dA.put(333, locala15);
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopRankConfig", 2, "getConfigFromLocal exp:", localException);
        }
        Object localObject2 = null;
      }
    }
  }
  
  public static void i(TextView paramTextView, int paramInt)
  {
    paramTextView.setBackgroundDrawable(apuh.k(BaseApplication.getContext().getResources(), paramInt));
    if ((paramTextView instanceof ThemeLabelTextView)) {
      ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
    }
  }
  
  public static boolean qp(String paramString)
  {
    bool2 = false;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "refreshConfig:" + paramString);
      }
      apdg localapdg = a(paramString);
      bool1 = bool2;
      if (localapdg != null)
      {
        a = localapdg;
        BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 0).edit().putString("rank_map_key", paramString).commit();
        bool1 = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("TroopRankConfig", 2, "TroopRankTitleConfig.refreshConfig exp, jsonStr=" + paramString, localException);
          bool1 = bool2;
        }
      }
    }
    finally {}
    return bool1;
  }
  
  public static void report(String paramString1, String paramString2)
  {
    anot.a(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, "report,  opType=" + paramString1 + ", opName=" + paramString2);
    }
  }
  
  public void U(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, "setHasNewRankRedDot, troopUin=" + paramString1 + ", memberUin=" + paramString2 + ", hasRedDot=" + paramBoolean);
    }
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("troop_rank_cfg", 4).edit().putBoolean("new_rank_flag" + paramString1 + "_" + paramString2, paramBoolean).commit();
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopRankConfig", 2, "setHasNewRankRedDot exp:", paramString1);
    }
  }
  
  public apdg.a a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((apdg.a)this.dA.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((apdg.a)this.dA.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (apdg.a)this.dA.get(300);
    }
    if (paramBoolean3) {
      return (apdg.a)this.dA.get(301);
    }
    return (apdg.a)this.dA.get(paramInt - 10000);
  }
  
  protected apdg.a a(apdg.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((parama == null) || (parama.id == 300) || (parama.id == 301)) {}
    apdg.a locala;
    do
    {
      return parama;
      if ((paramBoolean1) && (this.dA.get(300) != null))
      {
        if (paramBoolean3)
        {
          locala = new apdg.a();
          locala.id = parama.id;
          locala.title = parama.title;
          locala.bgColor = ((apdg.a)this.dA.get(300)).bgColor;
          return locala;
        }
        parama.bgColor = ((apdg.a)this.dA.get(300)).bgColor;
        return parama;
      }
    } while ((!paramBoolean2) || (this.dA.get(301) == null));
    if (paramBoolean3)
    {
      locala = new apdg.a();
      locala.id = parama.id;
      locala.title = parama.title;
      locala.bgColor = ((apdg.a)this.dA.get(301)).bgColor;
      return locala;
    }
    parama.bgColor = ((apdg.a)this.dA.get(301)).bgColor;
    return parama;
  }
  
  public apdg.a a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return null;
    }
    boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
    if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
    int i;
    apdg.a locala1;
    for (boolean bool1 = true;; bool1 = false)
    {
      i = paramTroopMemberInfo.level;
      if ((i >= 10000) || (i <= 0)) {
        break label232;
      }
      locala1 = (apdg.a)this.dA.get(i);
      if ((i != 302) || (locala1 == null)) {
        break;
      }
      paramTroopInfo = new apdg.a();
      paramTroopInfo.id = locala1.id;
      paramTroopInfo.title = paramTroopMemberInfo.mUniqueTitle;
      paramTroopInfo.bgColor = locala1.bgColor;
      return a(paramTroopInfo, bool2, bool1, false);
    }
    apdg.a locala2;
    if (i == 315)
    {
      locala2 = new apdg.a();
      if (locala1 != null) {}
      for (locala2.bgColor = locala1.bgColor;; locala2.bgColor = Color.parseColor("#8EBDF9"))
      {
        locala2.title = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        locala2.id = i;
        return a(locala2, bool2, bool1, false);
      }
    }
    return a(locala1, bool2, bool1, true);
    label232:
    if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
    {
      paramTroopInfo = (apdg.a)this.dA.get(302);
      if (paramTroopInfo != null)
      {
        locala1 = new apdg.a();
        locala1.id = paramTroopInfo.id;
        locala1.title = paramTroopMemberInfo.mUniqueTitle;
        locala1.bgColor = paramTroopInfo.bgColor;
        return a(locala1, bool2, bool1, false);
      }
      return null;
    }
    if (bool2) {
      return (apdg.a)this.dA.get(300);
    }
    if (bool1) {
      return (apdg.a)this.dA.get(301);
    }
    if (i == 10315)
    {
      locala1 = (apdg.a)this.dA.get(315);
      locala2 = new apdg.a();
      if (locala1 != null) {}
      for (locala2.bgColor = locala1.bgColor;; locala2.bgColor = Color.parseColor("#8EBDF9"))
      {
        locala2.title = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        locala2.id = 315;
        return locala2;
      }
    }
    return (apdg.a)this.dA.get(i - 10000);
  }
  
  public apdg.a a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return a(300, false, true, false);
    }
    if (paramBoolean2) {
      return a(301, false, false, true);
    }
    return null;
  }
  
  public boolean bN(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("troop_rank_cfg", 4).getBoolean("new_rank_flag" + paramString1 + "_" + paramString2, false);
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "hasNewRankRedDot: troopUin=" + paramString1 + ", memberUin=" + paramString2 + ", ret=" + bool);
      }
      return bool;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "hasNewRankRedDot exp:", paramString1);
      }
    }
    return false;
  }
  
  public static class a
  {
    public int bgColor;
    public int id;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdg
 * JD-Core Version:    0.7.0.1
 */